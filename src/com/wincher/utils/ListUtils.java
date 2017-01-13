package com.wincher.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			list.add(String.valueOf(i));
		}
		subList(list, 18);
	}

	private static <T> void subList(List<T> list, int step) {
		int group;
		List<T> subList = new ArrayList<T>(step);
		int mod = list.size() % step;
		System.out.println(list.size());
		group = mod == 0 ? list.size() / step : list.size() / step + 1;
		for (int i = 0; i < group; i++) {
			subList = list.subList(step * i, i + 1 == group ? step * i + (mod == 0 ? step : mod) : step * (i + 1));
			String string = stringArrayToString(subList.toArray());
			System.out.println(string);
		}
	}
	/**
     * 方法说明:字符串数组转换为逗号隔开的字符串
     * 
     * @author 王辉阳 2014-9-3 下午3:47:50
     * @param array
     *            字符串数组
     * @return 如果字符串数组为null则返回null，否则返回,隔开的字符串
     */
	public static String stringArrayToString(Object[] array) {
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
        return dest.toString();
    }


}
