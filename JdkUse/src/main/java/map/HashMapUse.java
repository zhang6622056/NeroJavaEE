package map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2018/2/10.
 */
public class HashMapUse {

    public static void main(String[] args) {
        AbstractMap<String,String> map = new AbstractMap<String, String>() {
            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };


        map.clear();

    }




    public int getHashCode(){

//        int h = 0;
//        if (h == 0 && value.length > 0) {
//            char val[] = value;
//
//            for (int i = 0; i < value.length; i++) {
//                h = 31 * h + val[i];
//            }
//            hash = h;
//        }
        return 0;
    }








}
