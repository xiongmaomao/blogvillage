package com.bear.blogvillage.utils;




import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串工具类
 */
public class StringUtil {

	/**
	 *16进制数组 
	 */
	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static Map<String, Integer> chineseNumbers = new HashMap<String, Integer>();

	static {
		chineseNumbers.put("零", 0);
		chineseNumbers.put("一", 1);
		chineseNumbers.put("二", 2);
		chineseNumbers.put("三", 3);
		chineseNumbers.put("四", 4);
		chineseNumbers.put("五", 5);
		chineseNumbers.put("六", 6);
		chineseNumbers.put("七", 7);
		chineseNumbers.put("八", 8);
		chineseNumbers.put("九", 9);
	}

	/**
	 * 获取md5字符串
	 * @param s 字符串
	 * @return 字符串
	 */

	/*public static String encodePassword(String password){
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		String hashPass = encode.encode(password);
		return hashPass;
	}*/

	public static String md5(String s) {
		if (s == null) {
			return null;
		}
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// 将每个数进行双字节加密
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 将列表中的对象用分隔符和包含符连接起来，如'a','b'
	 * @param list 列表
	 * @param seperator 分隔符
	 * @param arrounder 包含符
	 * @return 连接后的字符串
	 */
	public static String joinWithSeperator(List list, String seperator, String arrounder) {
		if (list == null) {
			return null;
		}
		if (seperator == null) {
			seperator = "";
		}
		if (arrounder == null) {
			arrounder = "";
		}
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				sb.append(seperator);
			}
			sb.append(arrounder).append(list.get(i)).append(arrounder);
		}
		return sb.toString();
	}
	
	/**
	 * 判断字符串是否为空(null或"")
	 * @param str 字符串
	 * @return 空返回true,否则返回false
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 取加密为*后的掩码字符串
	 * @param oriStr
	 * @param beginInt
	 * @param endInt
	 * @return
	 */
	public static String generateMaskString(String oriStr, int beginInt, int endInt) {
		if (StringUtil.isEmpty(oriStr)) {
			return null;
		}
		if (oriStr.length()<endInt){
			return oriStr;
		}
		int maskLength = endInt - beginInt;
		String maskCode = "";
		while (maskLength > 0) {
			maskCode = maskCode + "*";
			maskLength--;
		}
		return oriStr.substring(0, beginInt) + maskCode + oriStr.substring(endInt, oriStr.length());
	}

	public static String generateRandom(boolean numberOnly, int length) {
		String retStr = "";
		String strTable = numberOnly ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
		return retStr;
	}

	public static List asIntList(Object obj) {
		String[] ids = obj.toString().split(",");
		List list = new ArrayList();
		for (int i = 0, iLength = ids.length; i < iLength; i++) {
			list.add(Integer.valueOf(ids[i]));
		}
		return list;
	}

	public static int toRomanNumber(String chineseNumber) {
		return chineseNumbers.get(chineseNumber);
	}

	/**
	 * 描述: 将字符串转化为Long类型，如无法转换或发生错误返回null
	 *
	 * @param str
	 *            整形字符串
	 * @return 长整形类，如发生错误返回null
	 */
	public static Long stringToLong(String str) {
		if (str == null || "".equals(str.trim()))
			return null;
		try {
			return new Long(str.trim());
		} catch (Exception ex) {
			return null;
		}
	}



	/**
	 * 将字符串转换成16进制
	 * @param erStr
	 * @return
	 */
	public static String parseByte2HexStr(String erStr){
		try{
			byte[] buf=erStr.getBytes("utf-8");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < buf.length; i++) {
				String hex = Integer.toHexString(buf[i] & 0xFF);
				if (hex.length() == 1) {
					hex = '0' + hex;
				}
				sb.append(hex.toUpperCase());
			}
			return sb.toString();
		}catch(Exception e){
			return erStr;
		}
	}

	/**
	 * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
	 * @param s
	 * @return
	 */
	public static String trim(String s){
		String result = "";
		if(null!=s && !"".equals(s)){
			result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
		}
		return result;
	}
}
