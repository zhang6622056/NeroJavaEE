package com.boot.frame.application.rocketmq.config;

import java.io.*;

/**
 * Created by Administrator on 2017/4/18.
 */
public class IoUtil {

    /**
     * 对象转变为byte数组
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] objectToBytes(Object obj) throws IOException {
        ByteArrayOutputStream bout = null;
        ObjectOutputStream oout = null;
        byte[] bytes = null;
        try {
            bout = new ByteArrayOutputStream();
            oout = new ObjectOutputStream(bout);
            oout.writeObject(obj);
            oout.flush();
            bytes = bout.toByteArray();
        } finally {
            if (oout != null) {
                oout.close();
            }
            if (bout != null) {
                bout.close();
            }
        }
        return bytes;
    }

    /**
     * byte数组转为对象
     * @param bytes
     * @return
     */
    public static Object byteToObject(byte[] bytes) throws Exception {
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);

            obj = oi.readObject();
        } finally {
            if (oi != null) {
                oi.close();
            }
            if (bi != null) {
                bi.close();
            }
        }
        return obj;
    }
}
