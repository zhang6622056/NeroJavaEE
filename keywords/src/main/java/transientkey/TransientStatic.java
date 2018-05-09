package transientkey;

import java.io.*;

/**
 * 被static修饰的变量，不管是否经过了transient操作，都无法被序列化传输
 * Created by Nero on 2017/12/5.
 */
public class TransientStatic implements Serializable{
    private String username;        //普通变量，正常序列化
    private transient String cardNumber;    //transient变量。不会被序列化传递
    private static String personNumber;     //static变量。永远不会被序列化传递

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public static String getPersonNumber() {
        return personNumber;
    }
    public static void setPersonNumber(String personNumber) {
        TransientStatic.personNumber = personNumber;
    }


    public static void main(String[] args) throws Exception {
        TransientStatic transientStatic = new TransientStatic();
        transientStatic.setCardNumber("transient变量");
        transientStatic.setUsername("普通变量");
        transientStatic.setPersonNumber("static 变量");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\output_test_dir/transient_static.txt"));
        oos.writeObject(transientStatic);
        oos.flush();
        oos.close();

        transientStatic.setPersonNumber("JVM内存更改了");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\output_test_dir/transient_static.txt"));
        TransientStatic transientStaticRead = (TransientStatic) ois.readObject();
        System.out.println(transientStaticRead.getUsername());
        System.out.println(transientStaticRead.getPersonNumber());
        System.out.println(transientStaticRead.getCardNumber());

    }














}
