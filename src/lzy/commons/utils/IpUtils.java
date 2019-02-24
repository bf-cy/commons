/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2019年1月5日 下午2:55:13
 **********************************************************************************/
package lzy.commons.utils;

import javax.servlet.http.HttpServletRequest;


/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2019年1月5日 下午2:55:13
 **********************************************************************************/
public class IpUtils {

	
	/**********************************************************************************
	 * @Desc 获取登录用户的外网地址 复制于web项目LoginController
	 * @param request
	 * @return
	 * @author lzy
	 * @date 2019年1月5日 下午2:39:51
	 **********************************************************************************/
	private String getIpAddress(HttpServletRequest request)
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
