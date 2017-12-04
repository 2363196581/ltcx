package com.connxun.util.properties;

import com.connxun.util.string.StringUtil;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-20 17:21
 * @Comments：.properties文件操作类
 */
public class OpeProperties {

    private static Properties pps;

    public OpeProperties(){
        try {
            // 利用文件流方式获取路径————
//            InputStream in = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties"));
//            pps.load(in);

            // 利用反射的方式获取路径————
            // 原本是要用this，这里是static所以取父类Object.class或者换成int.class同理
            // 带 / 是读取classpath的根目录，不带读取当前类所在同一文件夹下.properties
            pps = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/application.properties");
            //从输入流中读取属性列表（键和元素对）
            pps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*静态代码块——测试后无效，Object.class无法获取到对象*/
//    static {
//        try {
//            // 利用文件流方式获取路径————
////            InputStream in = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties"));
////            pps.load(in);
//
//            // 利用反射的方式获取路径————
//            // 原本是要用this，这里是static所以取父类Object.class或者换成int.class同理
//            // 带 / 是读取classpath的根目录，不带读取当前类所在同一文件夹下.properties
//            pps = new Properties();
//            InputStream in = Object.class.getResourceAsStream("/application.properties");
//            //从输入流中读取属性列表（键和元素对）
//            pps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //利用反射原理操作
//    public static Properties GetPropertiesInstance() {
//        try {
//            // 利用文件流方式获取路径————
////            InputStream in = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties"));
////            pps.load(in);
//
//            // 利用反射的方式获取路径————
//            // 原本是要用this，这里是tatic所以取父类Object.class或者换成int.class同理
//            // 带 / 是读取classpath的根目录，不带读取当前类所在同一文件夹下.properties
//            pps = new Properties();
//            InputStream in = Object.class.getResourceAsStream("/application.properties");
//            //从输入流中读取属性列表（键和元素对）
//            pps.load(in);
//            return pps;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 根据Key读取Value
     * @param filePath 要读取的文件路径，如果不存在则读取根目录下的application.properties
     * @param key 文件中对应的键值
     * @return
     */
    public static String GetValueByKey(String filePath, String key) {
        /*如果filePath不存在，则读取根目录下的application.properties*/
        if (StringUtil.isNotNullOrEmpty(filePath)) {
            try {
                InputStream in = new BufferedInputStream(new FileInputStream(filePath));
                pps = new Properties();
                pps.load(in);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
//        else {
//            pps = GetPropertiesInstance();
//        }
        String value = pps.getProperty(key);
//        System.out.println(key + " = " + value);
        return value;
    }

    //读取Properties的全部信息
    public static void GetAllProperties(String filePath) {
        if (StringUtil.isNotNullOrEmpty(filePath)) {
            try {
                InputStream in  = new BufferedInputStream(new FileInputStream(filePath));
                pps=new Properties();
                pps.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        else {
//            pps = GetPropertiesInstance();
//        }
        Enumeration en = pps.propertyNames(); //得到配置文件的名字
        while (en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }

    }

    //写入Properties信息
    public static void WriteProperties(String filePath, String pKey, String pValue) throws IOException {

        Properties pps = new Properties();
        InputStream in = new FileInputStream(filePath);
//        从输入流中读取属性列表（键和元素对）
        pps.load(in);

        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
        //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，
        //将此 Properties 表中的属性列表（键和元素对）写入输出流
        try {
            pps.store(out, "Update " + pKey + " name");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
//        String value = GetValueByKey("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties", "tls.so");
//        System.out.println(value);
        String value2 = GetValueByKey("", "tls.so");
        System.out.println(value2);
//        GetAllProperties("");
//        WriteProperties("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties", "ggggg123gg", "111111123111111");
    }
}
