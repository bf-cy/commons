/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年10月17日 下午7:01:08
 *****************************************************************************************************************************************************/
package lzy.commons.http.entity;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年10月17日 下午7:01:08
 *****************************************************************************************************************************************************/
public class CustomHttpClient {

	public static int socket_time_out = 4000;//socket超时时间，单位毫秒
	public static int connect_time_out = 4000;//连接超时时间，单位毫秒
	
	/*****************************************************************************************************************************************************
	 * post 参数请求方式
	 * @param url 请求路径
	 * @param nvps 参数集合 	
	 * 			集合中NameValuePair的实现类为：BasicNameValuePair 
	 * 			使用例子：BasicNameValuePair name = new BasicNameValuePair("name", "lzy");
	 * 				
	 * @return 请求成功，返回请求结果；请求失败，返回请求异常信息。
	 * @author lzy 2019年10月17日 下午7:11:48
	 *****************************************************************************************************************************************************/
	public String PostParams(String url,LinkedList<NameValuePair> nvps) {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			RequestConfig requestConfig = RequestConfig.custom()
			.setSocketTimeout(socket_time_out).setConnectTimeout(connect_time_out).build();
			HttpPost httpPost = new HttpPost();  
			httpPost.setURI(new URI(url));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
			httpPost.setConfig(requestConfig);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			return result;
		} catch (ParseException | URISyntaxException | IOException e) {
			return "{'code':'500','msg':"+e.getMessage()+"}";
		}
	}
	

}
