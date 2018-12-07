/*
 * huirong Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * Author     :liyb
 * Create Date:2016年5月5日
 */
package cn.hrfax.open.common.util;

import cn.hrfax.open.config.FsConfig;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.*;
import java.util.Random;

/**
 * 图片Base64工具类
 * @author liyb
 * @version Base64Util.java,2016年5月5日 下午1:26:33
 */
public class Base64Util {

    private static final Random random = new Random();
    
    private static String FILE_PATH =FsConfig.getLocalTemp();

    static {
        File file = new File(FILE_PATH);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    /**
     * byte数字转换成base64字符串
     * @param b
     * @return
     */
    public static String byteToStringBase64(byte[] b){
        String base64Data="";
        try {
           
            base64Data = Base64.encodeBase64String(b);
            if(StringUtils.isNotEmpty(base64Data)){
                base64Data = base64Data.replaceAll("\\+", "*").replaceAll("\\/", "-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64Data;//返回Base64编码过的字节数组字符串
    }
    
    /**
     * base64字符串转换成byte数组
     * @param base64String
     * @return
     */
    public static byte[] base64StringToByte(String base64String){
        if (base64String == null) 
            return null;
        //替换字符
        base64String = base64String.replaceAll("\\*", "+").replaceAll("-", "/");
        //Base64解码
        byte[] b = null;
        b=Base64.decodeBase64(base64String);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {//调整异常数据
                b[i] += 256;
            }
        }
        return b;
    }
    
    /**
     * 字符串转化成base64字符串
     * @param file 文件对象
     * @return
     */
    public static String getImageBase64(String str) {
        //将字符串转化为字节数组字符串，并对其进行Base64编码处理
        //对字节数组Base64编码
        String base64Data="";
		try {
			base64Data = Base64.encodeBase64String(str.getBytes("utf-8"));
			if(StringUtils.isNotEmpty(base64Data)){
	            base64Data = base64Data.replaceAll("\\+", "*").replaceAll("\\/", "-");
	        }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return base64Data;//返回Base64编码过的字节数组字符串
    }

    /**
     * 图片转化成base64字符串(base64字符串转换特俗字符方式)
     * @param file 文件对象
     * @return
     */
    public static String getImageBase64(File file) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //String imgFile = "E:/image/001.png";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        String base64Data = Base64.encodeBase64String(data);
        if(StringUtils.isNotEmpty(base64Data)){
            base64Data = base64Data.replaceAll("\\+", "*").replaceAll("\\/", "-");
        }
        return base64Data;//返回Base64编码过的字节数组字符串
    }
    
    /**
     * base64字符串转化成图片
     * @param imageBase64Str 图片base64字符串
     * @return 返回生成的文件对象
     */
    public static File generateImage(String imageBase64Str) {
        File file=null;
        OutputStream out = null;
        //对字节数组字符串进行Base64解码并生成图片
        if (imageBase64Str == null) //图像数据为空
            return null;
        try {
            //替换字符
            imageBase64Str = imageBase64Str.replaceAll("\\*", "+").replaceAll("-", "/");
            //Base64解码
            byte[] b = Base64.decodeBase64(imageBase64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            String imgFilePath = FILE_PATH + File.separator + String.valueOf(System.currentTimeMillis())+ random.nextInt()+".jpg";
            out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            file = new File(imgFilePath);
            return file;
        } catch (Exception e) {
            return null;
        } finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {}
            }
        }
    }

    
    public static boolean strToFile(String imageBase64Str, String filePath, String fileName) {
    	boolean flag = false;
        
        BufferedOutputStream out = null;
        //对字节数组字符串进行Base64解码并生成图片
        if (imageBase64Str == null) //图像数据为空
            return flag;
        try {
            //替换字符
            imageBase64Str = imageBase64Str.replaceAll("\\*", "+").replaceAll("-", "/");
            //Base64解码
            byte[] b = Base64.decodeBase64(imageBase64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成图片
            out = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));
            out.write(b);
            out.flush();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {}
            }
        }
        
        return flag;
    }
    
    /**
     * 把图片文件生成base64字符串
     * @param file
     * @return
     */
    public static String getImageBase64Str(String file){
        InputStream in = null;
        byte[] data = null;
        try {
            file = imageProcess(file);
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(data);
    }
    
    /**
     * 处理图片再次压缩
     * @param file
     * @return
     */
    public static String imageProcess(String file){
        String filePath=file;
        try {
            File f = new File(file);
            File tmpfile = ImageUtils.compressionFile(f, f.getName());
            filePath = tmpfile.getPath();
        } catch (Exception e) {
            filePath=file;
            e.printStackTrace();
        }
        return filePath;
    }
    
    /**
     * 字符串加密为base64字符串
     * @param: @param param
     * @param: @return   
     * @return: String   
     * @throws
     */
    public static String encodeStr(String param){
    	String encodeStr = "";
    	try{
    		if(StringUtil.isBlank(param)){
        		return StringUtil.EMPTY_STRING;
        	}
    		encodeStr = Base64.encodeBase64String(param.getBytes("UTF-8"));
    		if(StringUtils.isNotEmpty(encodeStr)){
    			encodeStr = encodeStr.replaceAll("\\+", "*").replaceAll("\\/", "-");
	        }
    	}catch(Exception e){
    		encodeStr = StringUtil.EMPTY_STRING;
    		e.printStackTrace();
    	}
    	return encodeStr;
    }
    
    /**
     * base64字符串解密为字符串
     * @param: @param param
     * @param: @return   
     * @return: String   
     * @throws
     */
    public static String decodeStr(String param){
    	String decodeStr = "";
    	try{
    		if(StringUtil.isBlank(param)){
        		return StringUtil.EMPTY_STRING;
        	}
    		param = param.replaceAll("\\*", "+").replaceAll("-", "/");
    		decodeStr = new String(Base64.decodeBase64(param.getBytes("utf-8")));
    	}catch(Exception e){
    		decodeStr = "";
    		e.printStackTrace();
    	}
    	return decodeStr;
    }
    
    /**
     * 文件转base64字符串(base64字符串不转换特俗字符方式)
     * @param file
     * @return
     */
    public static String getImageStrFromFile(File file) {
        InputStream in = null;
        byte[] data = null;  
        // 读取图片字节数组  
        try {  
            in = new FileInputStream(file);
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {
             e.printStackTrace();
        }  
        // 返回Base64编码过的字节数组字符串  
        return Base64.encodeBase64String(data);  
    }
    
    public static void main(String[] args) {
    	String s = getImageBase64(new File("F:\\材料图片\\照片 003.jpg"));
		
		System.out.println(s);
    }
}
