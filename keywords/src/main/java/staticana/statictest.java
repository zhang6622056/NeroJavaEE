package staticana;

/**
 * Created by admin on 2018/3/2.
 */
public class statictest extends staticsuper{

    static void test(){
        System.out.println(a);
    }


    public static void main(String[] args) {
        statictest st = new statictest();
        staticsuper kk = st.getobj();
        System.out.println(kk.hashCode());
    }


}
