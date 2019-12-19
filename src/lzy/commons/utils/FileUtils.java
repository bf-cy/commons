/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月22日 下午3:48:38
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import java.io.File;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月22日 下午3:48:38
 *****************************************************************************************************************************************************/
public class FileUtils {

	private final static String regex = "[\\\\*|/*]";
	/*****************************************************************************************************************************************************
	 * 本地文件路径转换，转换原因，在不同系统中，本地路径有的是斜线间隔文件夹，有的是反斜线间隔文件夹，所以为了保证文件路径的通用性，在这里将文件路径转换一下
	 * 网路文件路径不需要转换
	 * @param localFilePath 转换前的本地文件路径
	 * @return 转换后的本地文件路径
	 * @author lzy 2019年11月22日 下午3:50:48
	 *****************************************************************************************************************************************************/
	public static String localFilePathConversion(String localFilePath) {
		if(StringUtils.isBlank(localFilePath)) {
			return localFilePath;
		}
		if(localFilePath.toLowerCase().indexOf("http://")!=0 && localFilePath.toLowerCase().indexOf("https://")!=0 && localFilePath.toLowerCase().indexOf("ftp://")!=0 ) {
			String replacement = File.separator;
			if(File.separator.equals("\\")) {
				replacement = File.separator+File.separator;
			}
			localFilePath = localFilePath.replaceAll("[\\\\*|/*]",replacement);
		}
		
		
		
		return localFilePath;
	}
	
}
