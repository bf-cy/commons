/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年8月1日 下午5:33:40
 *****************************************************************************************************************************************************/
package lzy.commons.utils.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年8月1日 下午5:33:40
 *****************************************************************************************************************************************************/
public class HttpUtils {

	/*****************************************************************************************************************************************************
	 * desc: get请求
	 * @param url 请求地址
	 * @param header 请求头 可以为空
	 * @return 返回相应结果
	 * @author lzy 2019年8月1日 下午6:10:53
	 *****************************************************************************************************************************************************/
	public static String get(String url,Map<String,String> header) {
		String entityStr = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// 创建httpget
			HttpGet httpGet = new HttpGet(url);
			// 添加头部信息
			if(header!=null) {
				header.forEach((key,val) -> {
					httpGet.addHeader(key,val);
				});
			}
			// 执行get请求
			CloseableHttpResponse response = httpClient.execute(httpGet);
			try {
				// 获取响应实体     
				HttpEntity entity = response.getEntity();
				if(entity!=null) {
					entityStr = EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entityStr;
	}
	
	

	/*****************************************************************************************************************************************************
	 * desc: get请求
	 * @param url 请求地址
	 * @param header 请求头 可以为空
	 * @param entity http实体，主要是传递参数数据 可以为空
	 * @return 返回相应结果
	 * @author lzy 2019年8月1日 下午6:10:53
	 *****************************************************************************************************************************************************/
	public static String post(String url,Map<String,String> header, HttpEntity entity) {
		String entityStr = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// 创建httpget
			HttpPost httpPost = new HttpPost(url);
			if(entity!=null) {
				httpPost.setEntity(entity);
			}
			// 添加头部信息
			if(header!=null) {
				header.forEach((key,val) -> {
					httpPost.addHeader(key,val);
				});
			}
			// 执行get请求
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				// 获取响应实体     
				HttpEntity responseEntity = response.getEntity();
				if(responseEntity!=null) {
					entityStr = EntityUtils.toString(responseEntity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entityStr;
	}
}
