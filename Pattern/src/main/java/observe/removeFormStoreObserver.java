package observe;

/**
 * 扣减库存观察创建订单
 * Created by Nero on 2018-06-29.
 */
public class RemoveFormStoreObserver implements Observer{

    private static final String dowhat = "扣减库存....";

    @Override
    public void createOrder(String message) {
        System.out.println(dowhat+message);
    }
}
