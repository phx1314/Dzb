package com.ab.util;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 宫智耀 on 2016/10/13.
 */
public class DES {
    //初始化向量，随意填写
    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
    public static String key = "hongtaid";

    /**
     * @param encryptString 明文
     * @param encryptKey    密钥
     * @return 加密后的密文
     */
    public static String encryptDES(String encryptString, String encryptKey) {

        try {
            //实例化IvParameterSpec对象，使用指定的初始化向量
//            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            //实例化SecretKeySpec，根据传入的密钥获得字节数组来构造SecretKeySpec
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
            //创建密码器
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //执行加密操作
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
            return Base64.encodeToString(encryptedData, 0);
//            return new String(encryptedData, "UTF-8");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解密的过程与加密的过程大致相同
     *
     * @param decryptString 密文
     * @param decryptKey    密钥
     * @return 返回明文
     */

    public static String decryptDES(String decryptString, String decryptKey) {

        try {
            //先使用Base64解密
            byte[] byteMi = Base64.decode(decryptString, 0);
//            byte[] byteMi = decryptString.getBytes();
            //实例化IvParameterSpec对象使用指定的初始化向量
//            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            //实例化SecretKeySpec，根据传入的密钥获得字节数组来构造SecretKeySpec,
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
            //创建密码器
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //用密钥初始化Cipher对象,上面是加密，这是解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            //获取解密后的数据
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
