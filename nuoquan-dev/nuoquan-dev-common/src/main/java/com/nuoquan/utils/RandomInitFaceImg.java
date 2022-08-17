package com.nuoquan.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RandomInitFaceImg {

    /**
     * @Description: 获取[1, max]区间内随机整数
     */
    public static String getRandomPath() {
        int max = 8;
        /**
         * 获取[0, max)区间内随机整数
         */
        int ran = (int) (Math.random() * max + 1);
        String imgPath = "";

        switch (ran){
            case 1:
                imgPath = "nqprod/img/220817169624068947968.png";
                break;
            case 2:
                imgPath = "nqprod/img/220817169604540268544.png";
                break;
            case 3:
                imgPath = "nqprod/img/220817169581068943360.png";
                break;
            case 4:
                imgPath = "nqprod/img/220817169533977395200.png";
                break;
            case 5:
                imgPath = "nqprod/img/220817169513874096128.png";
                break;
            case 6:
                imgPath = "nqprod/img/220817169486588051456.png";
                break;
            case 7:
                imgPath = "nqprod/img/220817169460325416960.png";
                break;
            case 8:
                imgPath = "nqprod/img/220817169434425589760.png";
                break;
            default:
                imgPath = null;
                break;
        }
        return imgPath;
    }
    public static void main(String[] args) {
        String s1 = getRandomPath();
        System.out.println(s1);
        String s2 = getRandomPath();
        System.out.println(s2);
        String s3 = getRandomPath();
        System.out.println(s3);
    }

}
