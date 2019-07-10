package lzy.commons.utils;

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
	
	
//	public static String getIpAddr(HttpServletRequest request) {
//        String ipAddress = null;
//        try {
//            ipAddress = request.getHeader("x-forwarded-for");
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getRemoteAddr();
//                if (ipAddress.equals("127.0.0.1")) {
//                    // 根据网卡取本机配置的IP
//                    InetAddress inet = null;
//                    try {
//                        inet = InetAddress.getLocalHost();
//                    } catch (UnknownHostException e) {
//                        e.printStackTrace();
//                    }
//                    ipAddress = inet.getHostAddress();
//                }
//            }
//            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
//                                                                // = 15
//                if (ipAddress.indexOf(",") > 0) {
//                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
//                }
//            }
//        } catch (Exception e) {
//            ipAddress="";
//        }
//        // ipAddress = this.getRequest().getRemoteAddr();
//        
//        return ipAddress;
//    }
}
