package lzy.commons.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/*****************************************************************************************************************************************************
 * 
 * 
 * @author lzy
* 2019年3月4日 下午2:21:47
 *****************************************************************************************************************************************************/
public class IpUtils {

	
	/*****************************************************************************************************************************************************
	 * 获取ip地址
	 * @param request 请求信息
	 * @return 返回IP地址
	 * @author lzy
* 2019年3月4日 下午2:21:51
	 *****************************************************************************************************************************************************/
	public static String getIpAddress(HttpServletRequest request)
	{
		String ip="";
		String ipAddresses = request.getHeader("X-Forwarded-For");
		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isBlank(ipAddresses) || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("X-Real-IP");
		}
		if (StringUtils.isNotBlank(ipAddresses)) {
			String[] split = ipAddresses.split(",");
			for (String ip_ : split) {
				if(StringUtils.isNotBlank(ip_) && !ip_.equals("unknown")) {
					ip=ip_;
					break;
				}
			}
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ipAddresses)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
    /*****************************************************************************************************************************************************
     * 获取本机的内网ip地址
     * @return
     * @throws SocketException
     * @author lzy 2020年11月13日 下午8:40:18
     *****************************************************************************************************************************************************/
    public static String getInnetIp() throws SocketException {
       String localip = null;// 本地IP，如果没有配置外网IP则返回它
       String netip = null;// 外网IP
       Enumeration<NetworkInterface> netInterfaces;
        netInterfaces = NetworkInterface.getNetworkInterfaces();
       InetAddress ip = null;
       boolean finded = false;// 是否找到外网IP
       while (netInterfaces.hasMoreElements() && !finded) {
         NetworkInterface ni = netInterfaces.nextElement();
         Enumeration<InetAddress> address = ni.getInetAddresses();
           while (address.hasMoreElements()) {
               ip = address.nextElement();
             if (!ip.isSiteLocalAddress() 
                        &&!ip.isLoopbackAddress() 
                        &&ip.getHostAddress().indexOf(":") == -1){// 外网IP
                   netip = ip.getHostAddress();
                   finded = true;
                             break;
           } else if (ip.isSiteLocalAddress() 
                     &&!ip.isLoopbackAddress() 
             &&ip.getHostAddress().indexOf(":") == -1){// 内网IP
                   localip = ip.getHostAddress();
               }
           }
       }
       if (netip != null && !"".equals(netip)) {
           return netip;
       } else {
           return localip;
       }
   }
 
    
    /*****************************************************************************************************************************************************
     * 获取本机外网ip
     * @return
     * @author lzy 2020年11月13日 下午8:39:04
     *****************************************************************************************************************************************************/
    public static String getV4IP() {
        String ip = "";
        String chinaz = "http://ip.chinaz.com";
 
        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            while ((read = in.readLine()) != null) {
                inputLine.append(read + "\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if (m.find()) {
            String ipstr = m.group(1);
            ip = ipstr;
            //System.out.println(ipstr);
        }
        return ip;
    }
 
}
