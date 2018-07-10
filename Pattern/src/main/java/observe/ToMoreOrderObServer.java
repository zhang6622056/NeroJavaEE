package observe;

/**
 * Created by admin on 2018-06-29.
 */
public class ToMoreOrderObServer implements Observer{


    private final static String dowhat = "拆成多单";

    @Override
    public void createOrder(String message) {
        System.out.println(dowhat+message);
    }
}
