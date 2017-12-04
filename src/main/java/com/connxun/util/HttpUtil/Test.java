//
//package com.connxun.util.HttpUtil;
//
//public class Test {
//	public static void main(String[] args) {
//		String url = "http://www.baidu.com/s";
//		HttpUtil http = HttpUtil.HttpUtil.get(url);
//		http.addParameter("wd", "java 核心技术"); //搜索关键字
//		http.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0");
//		http.setProxy("10.10.12.62", 3128); //设置代理
//		HttpUtil.ResponseWrap response = http.execute(); //执行请求
//		System.out.println(response.getString()); //输出内容
//		response.transferTo("d:/baidu-search-java.html"); //输出到文件
//		http.shutdown();
//	}
//
//}
