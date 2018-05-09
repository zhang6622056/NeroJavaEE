package com.boot.frame.application.logback;

import ch.qos.logback.classic.html.HTMLLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 因采用logback，重新定义html layout类
 * Created by Nero on 2018-04-17.
 */
public class OverseaLogLayout extends HTMLLayout {

    private String ips;

    public OverseaLogLayout() {
        List<String> ipArr = getIps();
        ips = ipArr.toString();
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuffer sb = new StringBuffer();
        sb.append("<tr><td colspan=\"2\">服务器IP地址:</td>");
        sb.append("<td colspan=\"4\">");
        sb.append(ips);
        sb.append("</td></tr>");
        sb.append(super.doLayout(event));
        return sb.toString();
    }

    @Override
    public String getContentType() {
        return "text/html;charset=utf-8";
    }

    public static List<String> getIps() {
        List<String> ips = new ArrayList<String>();
        Enumeration<?> e1;
        try {
            e1 = NetworkInterface.getNetworkInterfaces();
            while (e1.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e1.nextElement();
                Enumeration<?> e2 = ni.getInetAddresses();
                while (e2.hasMoreElements()) {
                    InetAddress ia = (InetAddress) e2.nextElement();
                    if (ia instanceof Inet6Address)
                        continue;
                    String ip = ia.getHostAddress();
                    if (ip.equals("127.0.0.1")) {
                        continue;
                    }
                    ips.add(ip);
                }
            }
        } catch (SocketException e) {
        }
        return ips;
    }





}
