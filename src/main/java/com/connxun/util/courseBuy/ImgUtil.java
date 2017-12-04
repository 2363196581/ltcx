package com.connxun.util.courseBuy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;

public class ImgUtil {

    public static void main(String[] args) {
//        String filePath = "d:\\zhuce.jpg";
       String filePath = "/pro/zhuce.jpg";
        String outPath = "\\00002.jpg";
        String code = "200000";
        share(filePath, outPath, code);

    }


    //    C:\\java\\tomcat8\\webapps\\lwgk
    public static boolean share(String filePath, String outPath, String code) {
        boolean ret = false;
//        ImageIcon imgIcon = new ImageIcon( filePath);
//        ImageIcon imgIcon = new ImageIcon("C:\\java\\tomcat8\\webapps\\lwgk\\upload/pro/zhuce.jpg");
        ImageIcon imgIcon = new ImageIcon("/usr/local/tomcat8/webapps/lwgk/upload"+filePath);

        Image img = imgIcon.getImage();
        int width = img.getWidth(null)== -1 ? 500 : img.getWidth(null);
        int height = img.getHeight(null)== -1 ? 300 : img.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bimage.createGraphics();
        g.setBackground(Color.white);
        g.drawImage(img, 0, 0, null);
        Font f = new Font("微软雅黑", Font.BOLD, 50);
        Color mycolor = Color.white;//new Color(0, 0, 255);
        g.setColor(mycolor);
        g.setFont(f);

        g.drawString(code, 265, 730);
        g.dispose();

        try {
//            FileOutputStream out = new FileOutputStream(outPath);
            FileOutputStream out = new FileOutputStream("/usr/local/tomcat8/webapps/lwgk/upload" + outPath);
            ImageIO.write(bimage, "JPEG", out);
            out.close();
            ret = true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

}