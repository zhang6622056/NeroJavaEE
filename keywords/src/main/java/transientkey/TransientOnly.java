package transientkey;

import java.io.*;

/**
 * transient keywords test
 * demo for 被transient修饰的变量不会被序列化传输，场景如用户银行卡号敏感信息不被传输
 * @Author nero
 * @Date 2017-12-05
 * Created by Nero on 2017/12/5.
 */
public class TransientOnly implements Serializable{


    private String username;
    private transient String bankcard;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }


    /***
     * 序列化对象经过IO操作以后，被transient修饰的变量在IO操作以后丢失了。
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransientOnly aTransientOnly = new TransientOnly();
        aTransientOnly.setUsername("nero");
        aTransientOnly.setBankcard("1001 2002 3003 4004");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\output_test_dir/transient.txt"));
        oos.writeObject(aTransientOnly);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\\\output_test_dir/transient.txt"));
        TransientOnly readobj = (TransientOnly) ois.readObject();
        ois.close();

        System.out.println(readobj.getUsername());
        System.out.println(readobj.getBankcard());
    }








}
