package fanxing;

/**
 * Created by Nero on 2018/2/14.
 */
public class Fan<T> {

    private static final int INIT_LIST_SIZE = 50;

    private T t;

    private int size = 0;

    private Object[] arr;


    public void add(T t){
        arr[size] = t;
        size++;
    }


    public T get(int i){
        return arr[i] == null ? null : (T) arr[i];
    }

    Fan(){
        arr = arr == null ? new Object[INIT_LIST_SIZE] : arr;
    }

    public void compare(CompareInter compareInter){
        compareInter.compare(arr);
    }

    interface CompareInter{
        void compare(Object[] objs);
    }

}
