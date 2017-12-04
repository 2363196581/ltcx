package com.connxun.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtil {
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String tempString;
            //			int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString).append("\r\n");
                //				line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }
        return sb.toString();
    }

    /**
     * 写文件
     */
    public static int writeFile(String fileName, String fileContent) {
        int flag = 0;
        try {
            String path = fileName.substring(0, fileName.lastIndexOf("\\\\"));
            File fileDir = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(fileContent);
            writer.close();
            flag = 1;
        } catch (Exception e) {
            System.out.println("写文件内容操作出错");
            System.out.println(fileName);
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 新建文件夹
     *
     * @param path
     */
    public static void createFileDir(String path) {
        File fileDir = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

    }

    /**
     * 删除文件
     *
     * @param path_name 文件路径名称
     */
    public static void delete(String path_name) {
        File dest = new File(path_name);
        if (dest.exists())
            dest.delete();
    }


    private static URL urlStr;
    private static HttpURLConnection connection;
    private static int state = -1;
    private static boolean succ;

    /**
     * 功能描述 : 检测当前URL是否可连接或是否有效,
     * 最多连接网络 5 次, 如果 5 次都不成功说明该地址不存在或视为无效地址.
     *
     * @param url 指定URL网络地址
     * @return String
     */
    public static synchronized boolean isConnect(String url) {
        int counts = 0;
        succ = false;
        if (url == null || url.length() <= 0) {
            return succ;
        }
        while (counts < 5) {
            try {
                urlStr = new URL(url);
                connection = (HttpURLConnection) urlStr.openConnection();
                state = connection.getResponseCode();
                if (state == 200) {
                    succ = true;
//                    succ = connection.getURL().toString();
                }
                break;
            } catch (Exception ex) {
                ;
                continue;
            }
        }
        return succ;
    }

}
