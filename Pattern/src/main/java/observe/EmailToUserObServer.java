package observe;

/**
 * Created by admin on 2018-06-29.
 */
public class EmailToUserObServer implements Observer{

    private static final String dowhat = "发送给用户邮件...";

    @Override
    public void createOrder(String message) {
        System.out.println(dowhat+message);
    }



}
