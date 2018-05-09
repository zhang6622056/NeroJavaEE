package transientkey;

import java.io.*;

/**
 * 手动序列化
 * Created by Nero on 2017/12/5.
 */
public class ExternalizableTransient implements Externalizable{

    private static transient String content = "手动序列化传递。静态也木有用啊。";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String a = (String) in.readObject();
        System.out.println(a);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableTransient externalizableTransient = new ExternalizableTransient();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\output_test_dir/transient_hand.txt"));
        externalizableTransient.writeExternal(objectOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\output_test_dir/transient_hand.txt"));
        externalizableTransient.readExternal(objectInputStream);
    }




}
