package fanxing;

import fanxing.question.Division2;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nero on 2018/2/28.
 */
public class FanTest {


    public static void main(String[] args) {
        Fan<Map> fan = new Fan<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new LinkedHashMap<>();
        fan.add(map1);
        fan.add(map2);

        LinkedHashMap temp = (LinkedHashMap) fan.get(1);

        System.out.println(temp.hashCode());

        fan.compare(new Fan.CompareInter() {
            @Override
            public void compare(Object[] objs) {
                System.out.println(objs.length);
            }
        });
    }


    @Test
    public void test(){
        Division2<Object> division2 = new Division2();
        Integer in = 4;
        Double dou = 4d;
        Float fl = 4f;
        Long lo = 4l;

        division2.add(in).add(dou).add(fl).add(lo);
        Division2.DivisionResult[] divisionResults = division2.division();

        for(Division2.DivisionResult result : divisionResults){
            System.out.println(result.getType()+":"+result.getCountMills()+":"+result.toSec());
        }
    }


    @Test
    public void test01(){



    }




}
