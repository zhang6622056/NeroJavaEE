package snowflake;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * SnowFlake算法获取分布式唯一ID
 * Created by Nero on 2018-05-08.
 */
public class SnowFlake {


    private static final long START_STAMP = 1480166465631L; //开始时间戳，本算法从这个时间后退96年。。

    //
    private static final long SEQUENCE_BIT = 12;    //序列号占用的位数
    private static final long MACHINE_BIT = 5;  //机器标识占用bit位
    private static final long DATACENTER_BIT = 5;   //数据中心占用bit位



    //知识点预热 原码，反码，补码
    //异或 相同为0，不同为1
    //同等效果写法还有  (1 << X) - 1 位数的最大值
    private static final long SEQUENCE_BIT_MAX = -1l ^ (-1l << SEQUENCE_BIT);
    private static final long MACHINE_BIT_MAX = -1L ^ (-1L << MACHINE_BIT);
    private static final long DATACENTER_BIT_MAX = -1l ^ (-1l << DATACENTER_BIT);



    //每一部分向左的位移相加的和，现在暂时不明为啥要这样相加
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private static final long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;


    private long dataCenterId;  //数据中心ID
    private long machineId;     // 机器ID
    private long sequence  = 0L;    //序列号
    private long lastStmp = -1L;  //上一次用到的时间戳



    public SnowFlake(long dataCenterId, long machineId) {
        if(dataCenterId > DATACENTER_BIT_MAX || dataCenterId < 0){
            throw new IllegalArgumentException("dataCenterId must range form 0 and power of 5 ");
        }
        if(machineId > MACHINE_BIT_MAX || machineId < 0){
            throw new IllegalArgumentException("machineId must range form 0 and power of 5 ");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }


    /****
     * 获取分布式内唯一ID
     * @return
     */
    public synchronized  long nextId(){
        long currentStmp = getNewTimeStmp();
        if(currentStmp < lastStmp){     //判断时钟回拨
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        //固定位数之后，任意数值与最大数值进行&操作都会是它本身，
        // 用下列这种方式，使得sequence的方式永远不可能超过固定位数下的最大值
        // 于是则为   TIME10000-TIME19999 的一个数量区间
        if(currentStmp == lastStmp){    //相同毫秒，采用毫秒内序列号自增的方式
            sequence =( sequence + 1 ) & SEQUENCE_BIT_MAX;

            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currentStmp = getNextMill();
            }
        }else{  //不同毫秒内，则置为0
            sequence = 0;
        }
        lastStmp = currentStmp;

        //移位拼接64位，并且与0进行异或，得出十进制结果
        return (currentStmp - START_STAMP) << TIMESTAMP_LEFT //时间戳部分
                | dataCenterId << DATACENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }




    /***
     * 时钟回拨，获取下一个时钟
     * @return
     */
    private long getNextMill(){
        long currentMill = getNewTimeStmp();
        while(currentMill <= lastStmp){
            currentMill = getNewTimeStmp();
        }
        return currentMill;
    }


    /***
     * 获取最新的系统时间
     * @return
     */
    private long getNewTimeStmp(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis() - 1480166465631L;
        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(2199023255552L)));
    }
}
