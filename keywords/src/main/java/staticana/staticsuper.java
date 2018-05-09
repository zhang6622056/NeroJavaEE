package staticana;

/**
 * Created by admin on 2018/3/2.
 */
public class staticsuper {

    static Integer a = 0;

    static String b = "1";

    static{
        a = 1;
    }

    private static class check{
        private static staticsuper cc = new staticsuper();
    }

    public staticsuper getobj(){
        return check.cc;
    }

}
