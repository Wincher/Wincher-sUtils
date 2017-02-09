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
			String string = StringUtil.stringArrayToString(subList.toArray(), ",");
			System.out.println(string);
		}
	}
	
	


}
