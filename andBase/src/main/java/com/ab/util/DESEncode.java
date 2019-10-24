package com.ab.util;

import java.security.*;

import javax.crypto.Cipher;

import javax.crypto.SecretKey;

import javax.crypto.SecretKeyFactory;

import javax.crypto.spec.DESKeySpec;

/**
 * 字符串加密工具.可对字符串进行加解密.加密方式为DES对称加密.
 */

public class DESEncode {

    private final static String DES = "DES";
    public static String key = "hongtaid";

    /**
     * 加密
     *
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回加密后的数据
     * @throws Exception
     */

    public static byte[] encode(byte[] src, byte[] key) throws Exception {

        // DES算法要求有一个可信任的随机数源

        SecureRandom sr = new SecureRandom();

        // 从原始密匙数据创建DESKeySpec对象

        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密匙工厂，然后用它把DESKeySpec转换成

        // 一个SecretKey对象

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);

        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作

        Cipher cipher = Cipher.getInstance(DES);

        // 用密匙初始化Cipher对象

        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        // 现在，获取数据并加密

        // 正式执行加密操作

        return cipher.doFinal(src);

    }

    /**
     * 解密
     *
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回解密后的原始数据
     * @throws Exception
     */

    public static byte[] decode(byte[] src, byte[] key) throws Exception {

        // DES算法要求有一个可信任的随机数源

        SecureRandom sr = new SecureRandom();

        // 从原始密匙数据创建一个DESKeySpec对象

        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成

        // 一个SecretKey对象

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);

        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作

        Cipher cipher = Cipher.getInstance(DES);

        // 用密匙初始化Cipher对象

        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        // 现在，获取数据并解密

        // 正式执行解密操作

        return cipher.doFinal(src);

    }

    /**
     * 字符串解密
     *
     * @param src    要加密的字符串
     * @param srcKey 加密密码
     * @throws Exception
     */

    public final static String stringDecode(String src, String srcKey) {
        try {
            return new String(decode(hex2byte(src.getBytes()),
                    srcKey.getBytes()));
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 字符串加密
     *
     * @param src    要加密的字符串
     * @param srcKey 加密密码
     * @return
     * @throws Exception
     */

    public final static String stringEncode(String src, String srcKey) {

        try {

            return byte2hex(encode(src.getBytes(), srcKey.getBytes()));
        } catch (Exception e) {

        }

        return null;

    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */

    public static String byte2hex(byte[] b) {

        String hs = "";

        String stmp = "";

        for (int n = 0; n < b.length; n++) {

            stmp = (Integer.toHexString(b[n] & 0XFF));

            if (stmp.length() == 1)

                hs = hs + "0" + stmp;

            else

                hs = hs + stmp;

        }

        return hs.toUpperCase();

    }

    public static byte[] hex2byte(byte[] b) {

        if ((b.length % 2) != 0)

            throw new IllegalArgumentException("长度不是偶数");

        byte[] b2 = new byte[b.length / 2];

        for (int n = 0; n < b.length; n += 2) {

            String item = new String(b, n, 2);

            b2[n / 2] = (byte) Integer.parseInt(item, 16);

        }

        return b2;
    }

    // 测试用例
    public static void main(String[] args) {
        String str1 = "";
        String str3 = "this is 我的 first encrypt program 知道吗?DES算法要求有一个可信任的随机数源 ";
        String str = stringEncode(str3, key);
        String strr = stringEncode(str1, key);
        System.out.println("加密Str3 is : " + str);
        System.out.println("outStr4 is : " + stringDecode(str, key));
        System.out.println("为空时 is : " + stringDecode(strr, key));
    }

}