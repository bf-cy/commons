package lzy.commons;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;




public class Test {
	private static ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(
			1,2,3,4,5,6,7,8,9,10,
			11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,
			31,32,33,34,35,36,37,38,39,40,
			41,42,43,44,45,46,47,48,49,50,
			51,52,53,54,55,56,57,58,59,60,
			61,62,63,64,65,66,67,68,69,70,
			71,72,73,74,75,76,77,78,79,80,
			81,82,83,84,85,86,87,88,89,90,
			91,92,93,94,95,96,97,98,99,100
			));
	
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<String>();

		System.out.println(list instanceof Iterable);
		System.out.println(list instanceof ArrayList);
		
		String menu=
//				"1," + //绯荤粺绠＄悊
				"52," + 
				"56," + 
				"57," + 
				"53," + 
				"54," + 
				"55," + 
				"56," + 
				"57," + 
				"58," + 
				"59," + 
				"60," + 
				"61," + 
				"62," + 
				"63," + 
				"64," + 
//				"65," + //鍏抽敭瀛楁悳绱㈣缃�
				"66," + 
				"67," + 
				"68," + 
				"69," + 
				"70," + 
				"71," + 
				"72," + 
				"73,";
		String[] menuIds = menu.split(",");
		BigInteger rights = new BigInteger("0");
		for(int i=0; i<menuIds.length; i++){
			rights = rights.setBit(Integer.parseInt(menuIds[i]));
		}

		System.out.println(rights.toString());
		//9444728462139663056898
		//9407834973992243953666
		
//		18889461427878953484290
		String str = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx94df459ea7d2101f&secret=504eb49d9c532d536e1578808129eba0&code=011C3HO50hExiD1KcHL50fWCO50C3HOS&grant_type=authorization_code";
		String str2 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx94df459ea7d2101f&secret=504eb49d9c532d536e1578808129eba0&code=011C3HO50hExiD1KcHL50fWCO50C3HOS&grant_type=authorization_code";
		System.out.println(str.equals(str2));
//		Integer[] a = {1,2,3};
//		Integer[] b = {2,3,4,5,6};
//		for (int i = 0; i < b.length; i++) {
//			boolean f = true;
//			for (int j = 0; j < a.length; j++) {
//				if(a[j]==b[i]) {
//					f=false;
//					break;
//				}
//			}
//			if(f)
//			System.out.println(b[i]);
//			
//		}
		
//		String str = null;
//		BigDecimal bigDecimal = new BigDecimal(str);
//		System.out.println(bigDecimal);
		
//		LinkedList<Integer> list = new LinkedList();
//		list.addFirst(1);
//		list.addFirst(2);
//		list.addFirst(3);
//		list.addFirst(4);
//		System.out.println(list.getFirst());
//		System.out.println(list.getFirst());
//		
//		Integer prizes[] = new Integer[] {10,20,30,15,25};
//		Integer percentageArray[][] = new Integer[100][1];
//		ArrayList<Integer> array_ = (ArrayList<Integer>)array.clone();
//		int a = 0;
//		//寰幆濂栧姳淇℃伅
//		for (int i = 0; i < prizes.length; i++) {
//			//鑾峰彇闅忔満鏁�
//			System.out.println("i:"+i);
//			Random random = new Random();
//			for (int j = prizes[i]; j >0; --j) {
//				//鍦�100浠ュ唴鐨勬鏁存暟鏁扮粍涓殢鏈哄彇鍊硷紝鐒跺悗灏嗚繖涓�间粠鏁扮粍涓Щ闄わ紝涓嬩竴娆″湪鍓╀綑鐨�100浠ュ唴鐨勬鏁存暟鏁扮粍涓殢鏈哄彇鍊�
//				int nextInt = random.nextInt(array_.size());
//				Integer remove = array_.remove(nextInt);
//				//鏍规嵁涓婇潰闅忔満鍙栧嚭鐨勬鏁存暟锛屽湪濂栧姳闅忔満姒傜巼浜岀淮鏁扮粍涓瓨鍏ュ搴旂殑濂栧姳
//				percentageArray[nextInt][0] = remove;
//				System.out.println(a++);
//			}
//		}
//		
//		System.out.println(percentageArray);
	}

}
