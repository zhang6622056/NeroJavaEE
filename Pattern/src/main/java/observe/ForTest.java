package observe;

/**
 * Created by admin on 2018-06-29.
 */
public class ForTest {


    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();
        Observer a = new RemoveFormStoreObserver();
        Observer b = new EmailToUserObServer();
        Observer c = new ToMoreOrderObServer();

        subject.addObserver(a);
        subject.addObserver(b);
        subject.addObserver(c);

        subject.notifyObservers("订单号为111");

    }


}
