package com.connxun.util.http;

import com.connxun.util.log.LogUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class HttpUtil {

	/**
	 * 发送http请求， 参数是json串，获取返回值，返回值是json
	 * 
	 * @param url url
	 * @param jsonParam json串
	 * @return 返回值是json
	 */
	public static String getJsonFromUrlPost(String url, String jsonParam) {
		LogUtil.infoSys("请求url：" + url + ";请求参数：" + jsonParam);
		String getJson = "";
		HttpClient httpclient = null;
		HttpPost httpPost = null;
		try {
			httpclient = new DefaultHttpClient();
			httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(jsonParam, "utf-8");// 解决中文乱码问题
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse response = httpclient.execute(httpPost);
			response.getStatusLine().getStatusCode();
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			String str = "";
			while ((str = rd.readLine()) != null) {
				getJson += str;
			}
			LogUtil.infoSys("返回值：" + getJson);
		} catch (Exception e) {
			LogUtil.infoSys(e.getMessage());
		} finally {
			httpPost.abort();
			httpPost.releaseConnection();
		}
		return getJson;
	}

	/**
	 * 根据url请求服务器，获取json
	 * 
	 * @param url
	 * @return
	 */
	public static String getJsonFromUrl(String url) {
		LogUtil.infoSys("请求url：" + url);
		String getJson = "";
		HttpClient httpclient = null;
		HttpGet httpgets = null;
		try {
			httpclient = new DefaultHttpClient();
			httpgets = new HttpGet(url);
			httpgets.addHeader("Content-Type", "text/html;charset=UTF-8");
			HttpResponse response = httpclient.execute(httpgets);
			response.getStatusLine().getStatusCode();
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			String str = "";
			while ((str = rd.readLine()) != null) {
				getJson += str;
			}
			LogUtil.infoSys("返回值：" + getJson);
		} catch (Exception e) {
			LogUtil.infoSys(e.getMessage());
		} finally {
			assert httpgets != null;
			httpgets.abort();
			httpgets.releaseConnection();
		}
		return getJson;
	}

	/**
	 * 根据请求，获取map
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) {
		// 解析结果存储在HashMap
		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
			// 读取输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			for (Element e : elementList)
				map.put(e.getName(), e.getText());
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.infoSys("解析xml报错：" + e.getMessage());
			assert inputStream != null;
			LogUtil.infoSys("解析xml报错：" + inputStream.toString());
		} finally {
			try {
				assert inputStream != null;
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * 提交SSL请求
	 */

	/**
	 * 解析返回的xml
	 * 
	 * @param protocolXML
	 * @return
	 */
	public static HashMap<String, String> parseXml(String protocolXML) {
		protocolXML = protocolXML.replaceAll("\\\n", "");
		System.out.println(protocolXML);
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(protocolXML)));
			org.w3c.dom.Element root = doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();
			if (nodes != null) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node book = nodes.item(i);
					hashMap.put(book.getNodeName(), book.getFirstChild().getNodeValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}


	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！"+e);
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}








}
