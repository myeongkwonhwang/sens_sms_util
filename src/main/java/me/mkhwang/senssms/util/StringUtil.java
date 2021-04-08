package me.mkhwang.senssms.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Random;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}else if("null".equals(str)) {
			return true;
		}
		return str.trim().equals("");
	}

	public static boolean isEmpty(Object str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String[] str) {
		if (str == null || str.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(List<Object> list) {
		if (list == null || list.isEmpty() == true) {
			return true;
		}
		return false;
	}

	public static String nvl(String str, String replace) {
		if ( str == null || str.trim().equals("")) {
			str = replace;
		}
		return str;
	}

	public static String digitOnly(String s) {
		if(s == null)
			return null;
		return s.replaceAll("[^0-9]", "");
	}

	/**
	 * 입력 문자열을 특정한 길이로 변환한다. 왼쪽에 임의의 문자가 빈 공간을 채운다.
	 * 
	 * @param  str     입력 문자열
	 * @param  size    길이
	 * @param  padChar 빈공간을 채울 문자
	 * @return         변환된 문자열
	 */
	public static String leftPad(String str, int size, char padChar) { return StringUtils.leftPad(str, size, padChar); }

	/**
	 * <pre>
	 * null String을 (공백) String으로 변환한다.
	 * </pre>
	 * 
	 * @param  text
	 * @return
	 */
	public static String getNullToEmpty(String text) { return getNullToEmpty(text, true); }

	/**
	 * <pre>
	 * null String을 (공백) String으로 변환한다. isNull이 false이면 &quot;null&quot;이란 String은 &quot;&quot;으로 변환하지 않는다.
	 * </pre>
	 * 
	 * @param  text
	 * @param  isNull
	 * @return
	 */
	public static String getNullToEmpty(String text, boolean isNull) {
		String rtn;

		rtn = "";
		if(text == null) {
			return rtn;
		} else if(isNull && text.toLowerCase().equals("null")) {
			return rtn;
		} else {
			return text;
		}
	}

	/**
	 * 스트링이 널인지 판단하여 널이면 디폴트 값을 리턴한다.
	 * 
	 * @param  text         검사할 스트링
	 * @param  defaultValue 디폴트 스트
	 * @return
	 */
	public static String getNullToDefault(String text, String defaultValue) {

		if(text == null || text.trim().length() == 0 || text.trim().toLowerCase().equals("null")) {
			return defaultValue;
		} else {
			return text;
		}
	}

	public static String getShuffleNumber(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		int idx = 0;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < len; i++) {
			idx = (int) (charSet.length * Math.random());
			sb.append(charSet[idx]);
		}

		return sb.toString();
	}

	public static String getValidPath(String path) throws Exception {

		if(path == null || "".equals(path)) {
			return path;
		}
		
		if(path.indexOf("..") > -1) {
			throw new Exception("path contains ..");
		}
		
		if(path.indexOf("//") > -1) {
			throw new Exception("path contains // :" + path);
		}
		
		if(path.indexOf("&") > -1) {
			throw new Exception("path contains & :" + path);
		}
		
		return path;
	}

	public static String checkHeaderManipulation(String psStr) {
	    if (psStr != null) {
	        return psStr.replaceAll("(\\r\\n|\\r|\\n|\\n\\r)", " ");
	    } else {
	        return "";
	    }
	}

	public static String getFormattedCompanyNo(String no) {
		if(StringUtils.isEmpty(no)) return no;
		String dt = no.replaceAll("-", "");
		if(dt != null && !"".equals(dt) && dt.length() == 10) {
			dt = dt.substring(0, 3) + "-" + dt.substring(3, 5) + "-" + dt.substring(5);
		}else{
			dt = no;
		}
		return dt;
	}
	
	/**
	 * 20자리 랜덤 난수 생성
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String randomStr() throws Exception {
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		return temp.toString();
	}
}
