package com.wincher.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ���������ַ�����һЩ����
 * @�汾 V 1.0
 */
public class StringUtil {
	
	/**
	 * @Title: checkIfEmpty
	 * @Description: (�����ж��ַ��Ƿ�Ϊ�յķ���)
	 * @param source
	 * @return boolean ��������
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
	 * @Description: (�����ж��ַ��Ƿ�Ϊ�յķ���)
	 * @param source
	 * @return boolean ��������
	 */
	public static boolean checkIfEmpty(String source) {
		if (source == null || "".equals(source.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: checkIfNotEmpty
	 * @Description: (�ж��ַ��Ƿ�Ϊ��)
	 * @param source
	 * @return boolean ��������
	 */
	public static boolean checkIfNotEmpty(String source) {
		return !checkIfEmpty(source);
	}

	/**
	 * @Title: isNumeric
	 * @Description: (�ж��ַ����Ƿ�Ϊ����)
	 * @param str
	 * @return boolean ��������
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
	 * @return str����null
	 * @description ��ȫ������Ϊ�ո���ַ�����Ϊnull
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
	 * @description id�Զ��ŷָ����ַ������棬ת��ΪLong[]
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
	 * @param ids �ɴ���"1,2,3"��"1,2,3,"
	 * @return
	 * @description ��Ӣ�Ķ���ƴ�ӵ�id�ַ���ת��Ϊlong[]����
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
	 * ����˵��:�ɴ���"1,2,3"
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
	 * ����˵��:��separatorƴ�ӵ�id�ַ���ת��ΪString[]����
	 * 
	 * @author   2014-8-26 ����3:38:23
	 * @param ids
	 *            �ɴ���"1,2,3"��"1,2,3,"
	 * @return �ַ�������
	 */
	public static String[] stringToStringArray(String ids,String separator) {
		ids = ids.endsWith(separator) ? ids.substring(0, ids.length() - 1) : ids;
		String[] idsArr = ids.split(separator);
		return idsArr;
	}

	/**
	 * ����˵��:�ַ�������ת��Ϊseparator�������ַ���
	 * @param array
	 *            �ַ�������
	 * @return ����ַ�������Ϊnull�򷵻�null�����򷵻�,�������ַ���
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
	 * ����˵��:�ж�separator�������ַ����Ƿ����ĳ��Ԫ��
	 * @param src ���Ÿ������ַ���
	 * @param target ָ����Ԫ��
	 * @param separator �ָ�����
	 * @return true��ʾ���ڣ�false������
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
	 * ����˵��:�Ը�ʽ��"1,2,3"����ɾ����ɾ��ָ���±��Ԫ�أ���ɾ���±�Ϊ1��Ԫ�أ��򷵻�"1,3"
	 * @param src
	 * @param index ��0��ʼ����
	 * @return ���ظ�ʽ��"1,2,3,34"���ַ���
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
	 * ����˵��:�ַ�������ת��Ϊ���Ÿ������ַ���
	 * @param array
	 *            �ַ�������
	 * @return ����ַ�������Ϊnull�򷵻�null�����򷵻�,�������ַ���
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
	 * @description �������š�˫����ת����xml�е�ʵ��
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
	 * single quote mark string ����˵��:ת���ɴ��е������Ҷ��Ÿ������ַ�������"'ab','cc','dd'"
	 * 
	 * @author   2014-9-3 ����3:53:05
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
	 * single quote mark string ����˵��:ת���ɴ��е������Ҷ��Ÿ������ַ�������"'ab','cc','dd'"
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
	 * @description ȥ�����еĿո񡢻��С��س���ˮƽ�Ʊ�� ע�� \n �س�( ) \t ˮƽ�Ʊ��( ) \s �ո�(\u0008) \r
	 *              ����( )
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
	 * @description ueditor��ҳ��ǩ��
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
	 * @description ueditor��ҳ���ı��ָ�
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
	 * @description ueditor��ҳ��ʽ���
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
	 * ����˵��:�ַ���listת����separator�������ַ��� "a,2,5,h"
	 * @paramlist
	 * @param
	 * @return String
	 */
	public static String stringListToString(List<String> list, String separator) {
		// 1��ѭ��list
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
	 * ����˵��:�ַ���listת����separator�������ַ��� "a,2,5,h"
	 * @param @param
	 *            list
	 * @param @return
	 * @return String
	 */
	public static String stringListToString(String[] list, String separator) {
		// 1��ѭ��list
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
