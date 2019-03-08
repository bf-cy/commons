package lzy.commons.utils;

import javax.servlet.http.HttpServletRequest;


/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @dateTime 2019年3月4日 下午2:21:47
 *****************************************************************************************************************************************************/
public class IpUtils {

	
	/*****************************************************************************************************************************************************
	 * @desc 获取ip地址
	 * @param request
	 * @return
	 * @author lzy
	 * @dateTime 2019年3月4日 下午2:21:51
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
}
