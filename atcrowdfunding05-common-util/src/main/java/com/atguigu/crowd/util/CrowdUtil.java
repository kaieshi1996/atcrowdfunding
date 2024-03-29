package com.atguigu.crowd.util;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUtil {

    /*
    * 判断当前请求是否为Ajax请求
    * @param request 请求对象
    * @return
    *   true：当前请求为Ajax请求
    *   false：当前请求不是Ajax请求
    */

    public static boolean judgeRequestType(HttpServletRequest request){
        // 1.获取请求头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Request-With");

        // 2.判断
        return (acceptHeader != null && acceptHeader.contains("application/json"))
                || (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

    /*
    * 使用md5加密字符串
    * @param source 原字符串
    * @return null或者加密后的字符串
    */

    public static String md5(String source){
        // 1.判断source是否有效
        if(source == null || source.length() == 0){
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        try {
            // 3.获取MessageDigest对象
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 4.获取明文字符串对应的字节数组
            byte[] input = source.getBytes();
            // 5.执行加密
            byte[] output = messageDigest.digest(input);
            // 6.创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);
            // 7.按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();

            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
