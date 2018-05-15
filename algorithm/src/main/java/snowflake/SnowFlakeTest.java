package snowflake;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * snowflake变种版本，由41位时间戳+8位地址码+14位序列码构成
 * -风险1：系统时间回拨，比如手动设置当前时间为实际时间之前的时间，可能会引发重复ID问题
 * -风险2：分布式系统或集群系统中，部署到多个节点上，如果spring配置bean输入了多个同样的IP，可能会引发重复ID问题
 * Created by Nero on 2018-05-11.
 */
public class SnowFlakeTest {


    // private static final long START_TIME_STAMP = 1480166465631L;   不设置起始时间，则从1970年开始往后推69年 可以到2039-09-07 23:47:35

    //ID码构成部分
    private static final long TOTAL_BIT_COUNT = 63;    //该序列码总占位
    private static final long TIMESTAMP_BIT_COUNT = 41;             //时间戳占位
    private static final long ADDRESS_BIT_COUNT = 8;   //地址IP信息占8位

    //序列码占位
    private static final long SEQUENCE_BIT_COUNT = TOTAL_BIT_COUNT-TIMESTAMP_BIT_COUNT-ADDRESS_BIT_COUNT;


    //时间戳移位
    private static final long TIMESTAMP_BIT_LEFT = TOTAL_BIT_COUNT - TIMESTAMP_BIT_COUNT;
    //ip移位
    private static final long ADDRESS_BIT_LEFT = TIMESTAMP_BIT_LEFT - ADDRESS_BIT_COUNT;


    //最大序列码，用做循环增长
    private static final long MAX_SEQUENCE = (-1 << SEQUENCE_BIT_COUNT) ^ -1;
    private static final long MAX_ADDRESS = (-1 << ADDRESS_BIT_COUNT) ^ -1;


    //初始化构成变量
    private long last_stamp = 0;
    private long ipsec = 0;
    private long sequence = 0;


    /****
     * 初始化
     * @param ip
     */
    public SnowFlakeTest(long ip) {
        if(ip <= 0 || ip > MAX_ADDRESS){
            throw new IllegalArgumentException("attention : the param of ip must unique in the distributed and must range form 1 to 255");
        }
        this.ipsec = ip == 0 ? 255 : ip;
    }

    /***
     * 获取ID
     * 目前占位为时间戳+序列码
     * @return
     */
    public synchronized long getNextId(){
        long currentStamp = getCurrentMilles();
        last_stamp = currentStamp;

        sequence = (sequence + 1) & MAX_SEQUENCE;
        if(sequence == 0){   //超出序列上限，获取下一毫秒
            currentStamp = getNextMilles(currentStamp);
        }

        return (currentStamp << TIMESTAMP_BIT_LEFT) |
                (ipsec << ADDRESS_BIT_LEFT) |
                sequence;
    }


    /***
     * 获取下一个时间，针对上一次ID生成
     * @param currentStamp
     * @return
     */
    private long getNextMilles(long currentStamp){
        while(currentStamp <= last_stamp){
            currentStamp = getCurrentMilles();
        }
        return currentStamp;
    }


    /***
     * 获取当前系统时间
     * @return
     */
    private long getCurrentMilles(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<Long> set  = new LinkedHashSet<>();

        SnowFlakeTest snowFlake = new SnowFlakeTest(1);
        for(int i = 0 ; i < 10000000; i++){
           set.add(snowFlake.getNextId());
        }

        long end = System.currentTimeMillis();

        System.out.println("总耗时："+ (end-start));
        System.out.println(set.size());
    }
}
