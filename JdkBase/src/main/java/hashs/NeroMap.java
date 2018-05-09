package hashs;

import hashs.base.Map;
import only.PrimeNumber;
import sun.security.action.GetPropertyAction;

import java.io.Serializable;
import java.security.AccessController;
import java.util.HashMap;

/**
 * NeroMap
 * Created by Nero on 2017/12/6.
 */
public class NeroMap<K,V> implements Map<K,V>,Serializable,Cloneable{

    private static final int DEFAULT_INITAL_CAPACITY = 1 << 4;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;


    static final Entry<?,?>[] EMPTY_TABLE = {};


    transient int size;


    float loadFactor;


    transient Entry<K,V>[] table = (Entry<K, V>[]) EMPTY_TABLE;


    transient int modCount; //the number of reload times


    int threshold; //capacity number


    /****
     * A random value assciated with this instance that is applied to
     * hash code of keys to make hash collisions harder to find
     * if 0 then alternative hashing is disabled.
     */
    transient int hashSeed = 0;


    static final int ALTERNATIVE_HASHING_THRESHOLD_DEFAULT = Integer.MAX_VALUE;


    public NeroMap(int initialCapcity,float loadFactor) {
        if(initialCapcity < 0){
            initialCapcity = DEFAULT_INITAL_CAPACITY;
        }
        if(initialCapcity > MAXIMUM_CAPACITY){
            initialCapcity = MAXIMUM_CAPACITY;
        }
        if(loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Illegal load factor:"+loadFactor);
        }

        this.loadFactor = loadFactor;
        this.threshold = initialCapcity;

        init();
    }

    public NeroMap(){
        this(DEFAULT_INITAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }




    void init(){}


    /***
     * the number who >= arument number.
     * and the number which is the power of two.
     * @param number
     * @return
     */
    private static int roundUpToPowerOf2(int number){
        int rounded = number >= Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : (rounded = Integer.highestOneBit(number)) != 0
                ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
                : 1;

        return rounded;
    }


    /****
     * init the capacity of map.
     * count the capacity
     * count the threshold
     * choose the hashing method
     * @param intoSize
     */
    private void inflateTable(int intoSize){
        //find a power of two which >= the into size
        int capacity = roundUpToPowerOf2(intoSize);

        //the threshold of the size to hashmap to reload
        threshold = (int) Math.min(capacity * loadFactor,MAXIMUM_CAPACITY + 1);
        table = new Entry[capacity];

        //choose the hashing method by the capacity
        initHashSeedAsNeeded(capacity);
    }


    /***
     * Initialize the hashing mask value.We defer intialization util we really need it.
     * use the different hash strategy to adapt capacity
     * @param capacity
     * @return
     */
    final boolean initHashSeedAsNeeded(int capacity){
        boolean currentAltHashing = hashSeed != 0;

        boolean useAltHashing = sun.misc.VM.isBooted() &&
                (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);

        boolean switching = currentAltHashing ^ useAltHashing;

        if(switching){
//            hashSeed = useAltHashing ?
//                    sun.misc.Hashing.randomHashSeed(this)
//                    : 0;
        }
        return switching;
    }








    private V putForNullKey(V value){

        return null;
    }


    /****
     * first hash key.return the hash value
     * if the value is string type.then different hash value
     * @param k
     * @return
     */
    private final int hash(Object k){
        int h = hashSeed;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /***
     * returns index for hash code h.
     * @param h
     * @param length
     * @return
     */
    static int indexFor(int h,int length){
        return h & length -1;
    }




    /****
     * add entry to the bucket. if the key is not in the map.
     * it means the key which not in the map before do add.
     * @param hash
     * @param key
     * @param value
     * @param bucketIndex
     */
    void addEntry(int hash,K key,V value,int bucketIndex){
        if(size >= threshold && null != table[bucketIndex]){
            resize(table.length * 2);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash,table.length);
        }
        createEntry(hash,key,value,bucketIndex);
    }


    /***
     * insert entry to the bucket index which count out
     * @param hash
     * @param key
     * @param value
     * @param bucketIndex
     */
    void createEntry(int hash,K key,V value,int bucketIndex){
        Entry now = table[bucketIndex];
        table[bucketIndex] = new Entry<K,V>(key,value,now,hash);
        size++;
    }






    /****
     * resize the bucket of the map.
     * if the size >= threshold.
     * @param newCapacity
     */
    void resize(int newCapacity){
        Entry[] oldtable = table;
        int oldcapacity = table.length;

        if(newCapacity == MAXIMUM_CAPACITY){
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable,initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int) Math.min(newCapacity * loadFactor,MAXIMUM_CAPACITY + 1);
    }




    /****
     * all the entrys
     * transfer old table to the newtable.
     * @param newTable
     * @param rehash
     */
    void transfer(Entry[] newTable,boolean rehash){
        int newCapacity = newTable.length;
        for(Entry<K,V> entry : table){
            while(entry != null){
                Entry next = entry.next;

                if (rehash) {
                    entry.hash = null == entry.key ? 0 : hash(entry.key);
                }
                int index = indexFor(entry.hash,newCapacity);

                //the first will be the nexted one.
                //不断赋值给next，变量转换思想，主要解决collsion的问题
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;
            }
        }
    }

    @Override
    public V put(K key, V value) {
        //choose the hashing method and initiaza threshold.give the value of hashseed
        if(table == EMPTY_TABLE){
            inflateTable(threshold);
        }

        if(key == null){
           return putForNullKey(value);
        }

        //find the index of table arr
        int h = hash(key);
        int i = indexFor(h,table.length);

        //if some key is already in the map.so replace it.
        for(Entry<K,V> e = table[i]; e != null ; e = e.next){
            if(e.getKey().equals(key) && hash(e.getKey()) == hash(key)){
                V oldvalue = e.getValue();
                e.setValue(value);
                e.recordAccess(this);
                return oldvalue;
            }
        }

        //add entry
        addEntry(h,key,value,i);
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(K k) {

    }

    @Override
    public void clear() {

    }






    private static class Holder{
        /****
         * 表容量高于此值可以使用替代散列。
         * Table capacity above which to switch to use alternative hashing
         */
        static final int ALTERNATIVE_HASHING_THRESHOLD;

        static{
            String altThreshold = AccessController.doPrivileged(new GetPropertyAction("jdk.map.althashing.threshold"));

            int threshold;

            try{
                threshold = (null != altThreshold)
                        ? Integer.parseInt(altThreshold)
                        : ALTERNATIVE_HASHING_THRESHOLD_DEFAULT;

                if(threshold == -1){
                    threshold = Integer.MAX_VALUE;
                }

                if(threshold < 0){
                    throw new IllegalArgumentException("threshold value must be positive integer.");
                }
            }catch(IllegalArgumentException failed){
                throw new Error("Illegal value for 'jdk.map.althashing.threshold'",failed);
            }
            ALTERNATIVE_HASHING_THRESHOLD = threshold;
        }
    }







    static class Entry<K,V> implements Map.Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        int hash;


        public Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }


        /***
         * it is a replace method
         * the method will be invoked when the key eq somekey already in the map.
         * @param m
         */
        void recordAccess(NeroMap<K,V> m){

        }



    }











}
