package com.wincher.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 用来处理字符串的一些方法
 * @版本 V 1.0
 */
public class StringUtil {
	
	/**
	 * @Title: checkIfEmpty
	 * @Description: (用来判断字符是否为空的方法)
	 * @param source
	 * @return boolean 返回类型
	 */
	public static String insertSrcToTarget(String source, String separator,String value) {
		int index = 0;
		
	    while (source.indexOf(separator,index) != -1){
	    	index = source.indexOf(separator,index) + separator.length();
	    	String temp = source;
	    	source = temp.substring(0,index) + value + temp.substring(index);
	    }
	    return source;
	}

	/**
	 * @Title: checkIfEmpty
	 * @Description: (用来判断字符是否为空的方法)
	 * @param source
	 * @return boolean 返回类型
	 */
	public static boolean checkIfEmpty(String source) {
		if (source == null || "".equals(source.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: checkIfNotEmpty
	 * @Description: (判断字符是否不为空)
	 * @param source
	 * @return boolean 返回类型
	 */
	public static boolean checkIfNotEmpty(String source) {
		return !checkIfEmpty(source);
	}

	/**
	 * @Title: isNumeric
	 * @Description: (判断字符串是否为数字)
	 * @param str
	 * @return boolean 返回类型
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @title trim2null
	 * @param str
	 * @return str或是null
	 * @description 将全部内容为空格的字符串置为null
	 */
	public static String trim2null(String str) {
		if (str == null)
			return null;
		if ("".equals(str.trim()))
			return null;
		return str;
	}

	/**
	 * 
	 * @title split
	 * @param idsText
	 * @return results
	 * @description id以逗号分割用字符串保存，转换为Long[]
	 */
	public static Long[] split(String idsText, String separator) {
		if (idsText == null) {
			return null;
		}
		String[] ids = idsText.split(separator);
		Long[] results = new Long[ids.length];
		for (int i = 0; i < ids.length; i++) {
			results[i] = Long.parseLong(ids[i]);
		}
		return results;
	}

	/**
	 * @title stringToLongArray
	 * @param ids 可传入"1,2,3"或"1,2,3,"
	 * @return
	 * @description 将英文逗号拼接的id字符串转换为long[]数据
	 */
	/*public static Long[] stringToLongArray(String ids) {
		ids = ids.endsWith(",") ? ids.substring(0, ids.length() - 1) : ids;
		String[] idsArr = ids.split(",");
		Long[] idsArrLong = (Long[]) ConvertUtils.convert(idsArr, Long.class);
		return idsArrLong;
	}
*/
	/**
	 * 
	 * 方法说明:可传入"1,2,3"
	 * @param ids
	 * @return	
	 */
	public static List<String> stringToStringList(String ids,String separator) {
		List<String> listId = new ArrayList<String>();
		String[] idsArray = ids.split(separator);
		if (idsArray != null && idsArray.length > 0) {
			for (int i = 0; i < idsArray.length; i++) {
				String id = idsArray[i];
				if (StringUtil.checkIfNotEmpty(id)) {
					listId.add(id);
				}
			}
		}
		return listId;
	}

	/**
	 * 
	 * 方法说明:将separator拼接的id字符串转换为String[]数据
	 * 
	 * @author   2014-8-26 下午3:38:23
	 * @param ids
	 *            可传入"1,2,3"或"1,2,3,"
	 * @return 字符串数组
	 */
	public static String[] stringToStringArray(String ids,String separator) {
		ids = ids.endsWith(separator) ? ids.substring(0, ids.length() - 1) : ids;
		String[] idsArr = ids.split(separator);
		return idsArr;
	}

	/**
	 * 方法说明:字符串数组转换为separator隔开的字符串
	 * @param array
	 *            字符串数组
	 * @return 如果字符串数组为null则返回null，否则返回,隔开的字符串
	 */
	public static String stringArrayToString(String[] array,String separator) {
		StringBuilder dest = new StringBuilder();
		if (array == null) {
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			dest.append(array[i]);
			if (i != array.length - 1) {
				dest.append(separator);
			}
		}
		return dest.toString();
	}

	/**
	 * 
	 * 方法说明:判断separator隔开的字符串是否包含某个元素
	 * @param src 逗号隔开的字符串
	 * @param target 指定的元素
	 * @param separator 分隔符号
	 * @return true表示存在，false不存在
	 */
	public static boolean isExistsInString(String src, String target, String separator) {
		String[] array = StringUtil.stringToStringArray(src,separator);
		for (int i = 0; i < array.length; i++) {
			if (target.equals(array[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 方法说明:对格式如"1,2,3"进行删减，删减指定下标的元素，如删除下标为1的元素，则返回"1,3"
	 * @param src
	 * @param index 从0开始计数
	 * @return 返回格式如"1,2,3,34"的字符串
	 */
	public static String delElementInString(String src, int index, String separator) {
		List<String> tempStrList = StringUtil.stringToStringList(src, separator);
		tempStrList.remove(index);
		StringBuilder sb = new StringBuilder("");
		if (tempStrList.size() > 0) {
			for (String str : tempStrList) {
				sb.append(str + ",");
			}
			sb.deleteCharAt(sb.toString().length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 方法说明:字符串数组转换为逗号隔开的字符串
	 * @param array
	 *            字符串数组
	 * @return 如果字符串数组为null则返回null，否则返回,隔开的字符串
	 */
	public static String stringArrayToString(Object[] array, String separator) {
		StringBuilder dest = new StringBuilder();
		if (array == null) {
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			dest.append((String) array[i]);
			if (i != array.length - 1) {
				dest.append(separator);
			}
		}
		return dest.toString();
	}

	/**
	 * 
	 * @title formatValue
	 * @param str
	 * @return str
	 * @description 将单引号、双引号转化成xml中的实体
	 * 
	 */
	public static String formatValue(String str) {
		if (str == null) {
			return str;
		}
		str = str.replace("\'", "&apos;").replace("\"", "&quot;");
		return str;
	}

	/**
	 * single quote mark string 方法说明:转换成带有单引号且逗号隔开的字符串，如"'ab','cc','dd'"
	 * 
	 * @author   2014-9-3 下午3:53:05
	 * @param array
	 * @return
	 */
	public static String stringArrayToSQString(Object[] array) {

		StringBuilder dest = new StringBuilder();
		if (array == null) {
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			dest.append((String) array[i]);
			if (i != array.length - 1) {
				dest.append(",");
			}
		}
		return ("\'" + dest.toString().replaceAll(",", "\',\'") + "\'").toString();
	}

	/**
	 * single quote mark string 方法说明:转换成带有单引号且逗号隔开的字符串，如"'ab','cc','dd'"
	 * @param array
	 * @return
	 */
	public static String stringArrayToSQString(String str) {

		StringBuilder dest = new StringBuilder();
		if (str == null) {
			return null;
		}
		Object[] array = str.split(",");
		for (int i = 0; i < array.length; i++) {
			dest.append((String) array[i]);
			if (i != array.length - 1) {
				dest.append(",");
			}
		}
		return ("\'" + dest.toString().replaceAll(",", "\',\'") + "\'").toString();
	}

	/**
	 * @title replaceBlank
	 * @param str
	 * @return
	 * @description 去掉所有的空格、换行、回车、水平制表符 注： \n 回车( ) \t 水平制表符( ) \s 空格(\u0008) \r
	 *              换行( )
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * @title existsStrCount
	 * @param sourceStr
	 * @param targetStr
	 * @return
	 * @description ueditor分页标签数
	 */
	public static int existsStrCount(String sourceStr, String targetStr) {
		int count = 0;
		String tempStr = sourceStr;
		while (tempStr.indexOf(targetStr) > 0) {
			count++;
			tempStr = tempStr.substring(tempStr.indexOf(targetStr) + 1);
		}
		return count;
	}

	/**
	 * @title subStringByTag
	 * @param sourceStr
	 * @param targetStr
	 * @param end
	 * @return
	 * @description ueditor分页富文本分隔
	 */
	public static String subStringByTag(String sourceStr, String targetStr, int end) {
		int count = 0;
		String tempStr = sourceStr;
		while (tempStr.indexOf(targetStr) > 0) {
			if (count == end) {
				return tempStr.substring(0, tempStr.indexOf(targetStr));
			} else {
				tempStr = tempStr.substring(tempStr.indexOf(targetStr) + targetStr.length());
			}
			count++;
		}
		return tempStr;
	}

	/**
	 * @title fillPageStyle
	 * @param sourceStr
	 * @param url
	 * @param totalPage
	 * @param currPage
	 * @return
	 * @description ueditor分页样式添加
	 */
	public static String fillPageStyle(String sourceStr, String url, int totalPage, int currPage) {
		StringBuffer strBuffer = new StringBuffer(sourceStr);
		strBuffer.append("<style type='text/css' media='screen'>");
		strBuffer.append(
				"#pagination-digg li { border:0; margin:0; padding:0; font-size:11px; list-style:none; /* savers */ float:left; }");
		strBuffer.append("#pagination-digg a { border:solid 1px #9aafe5; margin-right:2px; }");
		strBuffer.append(
				"#pagination-digg .previous-off,#pagination-digg .next-off  { border:solid 1px #DEDEDE; color:#888888; display:block; float:left; font-weight:bold; margin-right:2px; padding:3px 4px; }");
		strBuffer.append("#pagination-digg .next a,#pagination-digg .previous a { font-weight:bold; }	");
		strBuffer.append(
				"#pagination-digg .active { background:#2e6ab1; color:#FFFFFF; font-weight:bold; display:block; float:left; padding:4px 6px; /* savers */ margin-right:2px; }");
		strBuffer.append(
				"#pagination-digg a:link,#pagination-digg a:visited { color:#0e509e; display:block; float:left; padding:3px 6px; text-decoration:none; }");
		strBuffer.append("#pagination-digg a:hover { border:solid 1px #0e509e; }");
		strBuffer.append("</style>");
		strBuffer.append("<ul id='pagination-digg'>");
		if (currPage == 1) {
			strBuffer.append("<li class='previous-off'>&laquo;Previous</li>");
		} else {
			strBuffer.append(
					"<li class='previous'><a href='" + url + "&pg=" + (currPage - 1) + "'>&laquo;Previous</a></li>");
		}
		for (int i = 1; i <= totalPage; i++) {
			if (i != currPage) {
				strBuffer.append("<li><a href='" + url + "&pg=" + i + "'>" + i + "</a></li>");
			} else {
				strBuffer.append("<li class='active'>" + i + "</li>");
			}
		}
		if (totalPage == currPage) {
			strBuffer.append("<li class='next-off'>Next &raquo;</li>");
		} else {
			strBuffer.append("<li class='next'><a href='" + url + "&pg=" + (currPage + 1) + "'>Next &raquo;</a></li>");
		}
		strBuffer.append("</ul>");
		return strBuffer.toString();
	}

	public static void main(String[] args) {
		String str = "123_ueditor_page_break_tag_456_ueditor_page_break_tag_789";
		// System.out.println(StringUtil.existsStrCount(str,
		// "_ueditor_page_break_tag_"));
		int count = StringUtil.existsStrCount(str, "_ueditor_page_break_tag_");
		for (int i = 0; i <= count; i++) {
			System.out.println(fillPageStyle(StringUtil.subStringByTag(str, "_ueditor_page_break_tag_", i),
					"www.baidu.com", count + 1, i + 1));
		}
	}

	/**
	 * 
	 * 方法说明:字符串list转换成separator隔开的字符串 "a,2,5,h"
	 * @paramlist
	 * @param
	 * @return String
	 */
	public static String stringListToString(List<String> list, String separator) {
		// 1，循环list
		StringBuilder dest = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			dest.append(list.get(i));
			if (i != (list.size() - 1)) {
				dest.append(separator);
			}
		}
		return dest.toString();
	}

	/**
	 * 
	 * 方法说明:字符串list转换成separator隔开的字符串 "a,2,5,h"
	 * @param @param
	 *            list
	 * @param @return
	 * @return String
	 */
	public static String stringListToString(String[] list, String separator) {
		// 1，循环list
		StringBuilder dest = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			dest.append(list[i]);
			if (i != (list.length - 1)) {
				dest.append(separator);
			}
		}
		return dest.toString();
	}
}
