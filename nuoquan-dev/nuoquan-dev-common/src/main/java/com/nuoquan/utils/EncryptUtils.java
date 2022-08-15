package com.nuoquan.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class EncryptUtils {

    /**
     * @Description: 对字符串进行加密
     */
    public static String base64Encode(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * @Description: 对字符串进行解码
     */
    public static String base64Decode(String encryptedText) {
        String decryptedText = new String(Base64.getDecoder().decode(encryptedText));
        return decryptedText;
    }

    public static void main(String[] args) {
        String eMsg = base64Encode("标题");
        System.out.println(eMsg);
        String dMsg = base64Decode(eMsg);
        System.out.println(dMsg);

    }


}
