/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2019年1月10日 下午3:18:19
 **********************************************************************************/
package lzy.commons.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**********************************************************************************
 * @Desc 使用方法，新建子类，继承当前类，然后调用构造函数对子类进行初始化，推荐项目启动时初始化（因为ssl协议文件一般是不会变动的）
 * @author lzy
 * @date 2019年1月10日 下午12:41:43
 **********************************************************************************/
public abstract class SSLConfigure {
	private static String certLocalPath;//证书文件位置
	private static String certPassword;//证书密钥
	private static FileInputStream certFileInputStream;//证书文件流，通过证书文件位置获取
	private static int socketTimeout = 0;// 连接超时时间，单位毫秒
	private static int connectTimeout = 0;// 传输超时时间，单位毫秒
	
	/**********************************************************************************
	 * @Desc 获取链接超时时间
	 * @return
	 * @author lzy
	 * @date 2019年1月10日 下午3:25:05
	 **********************************************************************************/
	public int getSocketTimeout() {
		return socketTimeout;
	}

	/**********************************************************************************
	 * @Desc 获取传输超时时间
	 * @return
	 * @author lzy
	 * @date 2019年1月10日 下午3:26:15
	 **********************************************************************************/
	public int getConnectTimeout() {
		return connectTimeout;
	}


	/**********************************************************************************
	 * @Desc 构造类---使用前必须自动构造
	 * @param certLocalPath 证书文件位置
	 * @param certPassword 证书密钥
	 * @throws FileNotFoundException
	 * @author lzy
	 * @date 2019年1月10日 下午3:12:41
	 **********************************************************************************/
	public SSLConfigure(String certLocalPath,String certPassword) throws FileNotFoundException {
		SSLConfigure.certLocalPath=certLocalPath;
		SSLConfigure.certPassword=certPassword;
		File file = new File(SSLConfigure.getCertLocalPath());
		certFileInputStream = new FileInputStream(file);// 加载本地的证书进行https加密传输
	}
	/**********************************************************************************
	 * @Desc 构造类---使用前必须自动构造
	 * @param certLocalPath 证书文件位置
	 * @param certPassword 证书密钥
	 * @param socketTimeout 链接超时时间,单位毫秒
	 * @param connectTimeout 传输超时时间,单位毫秒
	 * @throws FileNotFoundException
	 * @author lzy
	 * @date 2019年1月10日 下午3:12:41
	 **********************************************************************************/
	public SSLConfigure(String certLocalPath,String certPassword,int socketTimeout,int connectTimeout) throws FileNotFoundException {
		SSLConfigure.certLocalPath=certLocalPath;
		SSLConfigure.certPassword=certPassword;
		SSLConfigure.socketTimeout=socketTimeout;
		SSLConfigure.connectTimeout=connectTimeout;
		File file = new File(SSLConfigure.getCertLocalPath());
		certFileInputStream = new FileInputStream(file);// 加载本地的证书进行https加密传输
	}

	/**********************************************************************************
	 * @Desc 证书密钥
	 * @return
	 * @author lzy
	 * @date 2019年1月10日 下午2:49:56
	 **********************************************************************************/
	public static String getCertPassword() {
		return certPassword;
	}

	/**********************************************************************************
	 * @Desc 证书路径
	 * @return
	 * @author lzy
	 * @date 2019年1月10日 下午2:50:05
	 **********************************************************************************/
	public static String getCertLocalPath() {
		return certLocalPath;
	}
	
	/**********************************************************************************
	 * @Desc 获取证书文件流
	 * @return
	 * @throws FileNotFoundException
	 * @author lzy
	 * @date 2019年1月10日 下午2:59:51
	 **********************************************************************************/
	public static FileInputStream getCertFileInputStream() {
		return certFileInputStream;
	}
}
