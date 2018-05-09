package jmx;

/**
 * Created by admin on 2018/2/23.
 */
public class INero implements INeroMBean{

    private String name;

    @Override
    public String setName(String value) {
        this.name = value;
        System.out.println("set name:"+name);
        return this.name;
    }

    @Override
    public String getName(String a) {
        System.out.println("get name:"+this.name);
        return this.name;
    }
}
