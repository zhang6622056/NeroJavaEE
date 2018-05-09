package hashs.base;

/**
 * Map 接口实践
 * Created by Nero on 2017/12/6.
 */
public interface Map<K,V> {

    V put(K k,V v);

    V get(K k);

    boolean containsKey(K k);

    boolean containsValue(V v);

    boolean isEmpty();

    int size();

    void remove(K k);

    void clear();


    interface Entry<K,V> {

        K getKey();


        V getValue();


        void setValue(V value);
    }
}
