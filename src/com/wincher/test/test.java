package com.wincher.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.wincher.utils.DateUtil;
import com.wincher.utils.StringUtil;

public class test {
	public static void main(String[] args) {
		insertSrcToTarget();
	}

	public static void testDate() {
		DateUtil.iteratorDate(2014, 2014);
	}

	public static String insertSrcToTarget() {
		String value = "";
		try {
			value = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String s = StringUtil.insertSrcToTarget("aabbccddeeaaggaahh", "aa", "aa".toUpperCase());
		System.out.println(s);
		return s;

	}
}
