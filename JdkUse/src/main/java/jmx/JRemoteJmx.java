package jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * JMX 远程连接端代理
 * Created by Nero on 2018/2/24.
 */
public class JRemoteJmx {



    public static void main(String[] args) {
        try{
            //-mbean server bind
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName = new ObjectName("NeroMbean:name=NEROJMX");
            INero obj = new INero();
            mbs.registerMBean(obj,objectName);

            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:8089/server");
            JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL,null,mbs);
            connectorServer.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /***
     * get connector server
     * @return
     */
    public static Map getRemoteMaps(String host,int port) throws Exception{
        Map<String,Object> jmxEnvironment = new HashMap<String,Object>();
        jmxEnvironment.put("jmx.remote.credentials",new String[]{"nero","admin"});

       // InetAddress inetAddress = InetAddress.getByName(host);
        RMISocketFactory rmiSocketFactory = RMISocketFactory.getDefaultSocketFactory();
        Registry registry = LocateRegistry.createRegistry(port,null,rmiSocketFactory);
        jmxEnvironment.put(RMIConnectorServer.RMI_SERVER_SOCKET_FACTORY_ATTRIBUTE,rmiSocketFactory);

        return jmxEnvironment;
    }










}
