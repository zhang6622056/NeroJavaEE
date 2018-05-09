package jmx;

import javax.management.*;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;
import java.lang.management.ManagementFactory;

/**
 * 利用JConsole监控JMX Service
 * 本地客户端代理
 * Created by nero on 2018/2/23.
 */
public class JConsoleLook {


    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        try{
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            INero INero = new INero();
            ObjectName connector = new ObjectName("RMIAgent:name=NeroRmi");
            mbs.registerMBean(INero,connector);

            //String protocol =  "rmi";
            String protocol =  "IIOP";
            String host = "127.0.0.1";
            int port = 6598;

            JMXServiceURL jmxServiceURL = new JMXServiceURL(protocol,host,port);
            RMIConnectorServer connectorServer = new RMIConnectorServer(jmxServiceURL,null,mbs);
            connectorServer.start();
            System.out.println("rmi service started...");
        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
