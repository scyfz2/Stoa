package com.nuoquan.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

/**
 * 用于生成随机数并获取随机头像
 *
 * @author BoyuanYE
 * @date 2022/08/18
 */
public class RandomInitFaceImg {

    /**
     * @Description: 获取[0, max-1]区间内随机整数
     *
     * @param head 微信默认空头像，作为默认值防止bug出现
     */
    public static String getRandomPath(String head) {
        // 每次修改默认头像的时候先根据头像数修改max(8张图片则max=8)
        int max = 8;
        String imgPath = "";
        // 逐个添加图片路径
        ArrayList<String> arr = new ArrayList<>();
        arr.add("nqprod/img/220817169624068947968.png");
        arr.add("nqprod/img/220817169604540268544.png");
        arr.add("nqprod/img/220817169581068943360.png");
        arr.add("nqprod/img/220817169533977395200.png");
        arr.add("nqprod/img/220817169513874096128.png");
        arr.add("nqprod/img/220817169486588051456.png");
        arr.add("nqprod/img/220817169460325416960.png");
        arr.add("nqprod/img/220817169434425589760.png");

        /**
         * 获取[0, max-1)区间内随机整数
         */
        int ran = (int) (Math.random() * max);

        //判断是否超出boundary
        if (arr.size()>=max && max>=0){
            imgPath = arr.get(ran);
        } else {
            imgPath = head;
        }
        return imgPath;
    }


    public static void main(String[] args) {
        String s1 = getRandomPath("default");
        System.out.println(s1);
        String s2 = getRandomPath("default");
        System.out.println(s2);
        String s3 = getRandomPath("default");
        System.out.println(s3);
    }

}
