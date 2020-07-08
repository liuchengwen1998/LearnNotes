package SocketDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SocketUtil {

	public static void main(String[] args) throws IOException {
		//获取配置文件信息
		String pathname = SocketUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"config.properties";
		Properties props = new Properties();
		InputStream in = new FileInputStream(pathname);
		props.load(in);
		//获取应用四要素及渠道信息
		String dqm = props.getProperty("dqm");
		String ywzl= props.getProperty("ywzl");
		String ywlx= props.getProperty("ywlx");
		String ywdw= props.getProperty("ywdw");
		String qudao= props.getProperty("qudao");

		//测试数据
		Map map = new HashMap();
		map.put("asxz", "wewewe");
		map.put("wesd", "xcdff");
		map.put("trancode", "TIPFREE");
		try {
			//Map转换成xml报文
			String resultxml = MapToXml(map);
			//拼接六要素信息：地区码（4位）+业务种类（6位）+委托单位编码（15位）+业务单位编码（15位）+渠道号（8位）+ 外部交易码（15位）
			String resultsys = dqm+ywzl+ywlx+ywdw+qudao+getStr(map.get("trancode").toString())+resultxml;
			//获取报文长度
			String resultlen = get8XmlLength(resultsys);
			//最终报文
			String result = resultlen+resultsys;
			System.out.println("最终结果"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成8位的xml报文长度，报文长度超过8位的时候报文过长,包含对报文中汉字的处理
	 *
	 * @param string
	 * @return
	 */
	public static String get8XmlLength(String string) throws UnsupportedEncodingException {

		StringBuffer sb = new StringBuffer();
		if (string != null) {
			String strTemp = String.valueOf(string.getBytes("UTF-8").length);
			if (strTemp.length() > 8) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < 8 - strTemp.length(); i++) {
					sb.append("0");
				}
				sb.append(strTemp);
				return sb.toString();
			}
		}
		return null;
	}
	/**
	 * map转换成xml
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static String MapToXml(Map  map) throws Exception {
		System.out.println("将map转换成xml格式输出，map："+map.toString());
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		mapToXML(map,sb);
		sb.append("</ROOT>");
		System.out.println("将map转换成xml格式输出，xml："+sb.toString());
		try{
			return sb.toString();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	private static void mapToXML(Map map,StringBuffer sb){
		Set set=map.keySet();

		for(Iterator it=set.iterator();it.hasNext();){
			String key=(String) it.next();
			Object value=map.get(key);
			if(null==value){
				value="";
			}
			if(value.getClass().getName().equals("java.util.ArrayList")){

				ArrayList list=(ArrayList) map.get(key);
				sb.append("<"+key+">");
				for(int i=0;i<list.size();i++){
					HashMap hm=(HashMap) list.get(i);
					mapToXML(hm,sb);
				}
				sb.append("</"+key+">");
			}else{
				if(value instanceof HashMap){
					sb.append("<"+key+">");
					mapToXML((HashMap)value,sb);
					sb.append("</"+key+">");
				}else{
					sb.append("<"+key+">"+value+"</"+key+">");
				}
			}
		}
	}

	/**
	 * 字符串补位
	 *
	 * @param string
	 * @return
	 */
	public static String getStr(String string) throws UnsupportedEncodingException {
		String result = "";
		if (string.length() <= 15) {
			for (int i = 0; i < 15; i++) {
				if(i < string.length()) {
					result=result+string.charAt(i);
				}else {
					result=result+" ";
				}

			}
			return result;
		}
		return null;
	}

}
