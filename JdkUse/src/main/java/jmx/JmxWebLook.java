package jmx;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * JMX web service
 * Created by Nero on 2018/2/23.
 * 本地web代理
 */
public class JmxWebLook {




    public static void main(String[] args) {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName = new ObjectName("jmxBean:name=neroweb");
            INero iNero = new INero();
            mbs.registerMBean(iNero, objectName);

            //web html to set
            HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
            ObjectName adapterName = new ObjectName("HtmlAgent:name=htmladapter,port=8082");
            htmlAdaptorServer.preRegister(mbs,adapterName);
            htmlAdaptorServer.start();
            System.out.println("html jmx server start...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
