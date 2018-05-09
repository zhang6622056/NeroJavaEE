package hashs.base;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Nero on 2018-03-28.
 */
public abstract class AbstractMap<K,V> implements Map<K,V>{

    transient volatile Set<K> keySet = null;
    transient volatile Collection<V> values = null;

    protected AbstractMap(){

    }

    public abstract Set<Entry<K,V>> entrySet();


    @Override
    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(K key) {
        Iterator<Entry<K,V>> entrys = entrySet().iterator();
        if(key == null){
            while(entrys.hasNext()){
                Entry<K,V> entry = entrys.next();
                if(entry == null){
                    return entry.getValue();
                }
            }
        }else{
            while(entrys.hasNext()){
                Entry<K,V> entry = entrys.next();
                if(key.equals(entry.getKey())){
                    return entry.getValue();
                }
            }
        }
        return null;
    }



    @Override
    public boolean containsKey(K key) {
        Iterator<Entry<K,V>> iterators = entrySet().iterator();
        if(key == null){
            while(iterators.hasNext()){
                Entry<K,V> entry = iterators.next();
                if(entry.getKey() == null){
                    return true;
                }
            }
        }else{
            while(iterators.hasNext()){
                Entry<K,V> entry = iterators.next();
                if(key.equals(entry.getKey())){
                    return true;
                }
            }
        }
        return false;
    }




    @Override
    public boolean containsValue(V v) {
        Iterator<Entry<K,V>> iters = entrySet().iterator();

        while(iters.hasNext()){
            Entry entry = iters.next();
            if(v == null){
                if(entry.getValue() == null){
                    return true;
                }
            }else{
                if(v.equals(entry.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public void remove(K key) {
        Iterator<Entry<K,V>> iterators =  entrySet().iterator();
        Entry<K,V> entry = null;
        if(null == key){
            while(entry == null &&iterators.hasNext()){
                Entry<K,V> curEntry = iterators.next();
                if(curEntry.getKey() == null){
                    entry = curEntry;
                }
            }
        }else{
            while(entry == null && iterators.hasNext()){
                Entry<K,V> curEntry = iterators.next();
                if(curEntry.getKey().equals(key)){
                    entry = curEntry;
                }
            }
        }

        if(entry != null){
            iterators.remove();
        }
    }



    @Override
    public void clear() {
        entrySet().clear();
    }
}
