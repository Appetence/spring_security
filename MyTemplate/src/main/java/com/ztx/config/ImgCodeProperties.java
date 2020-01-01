package com.ztx.config;

/**
 * @author:wenfan
 * @description:
 * @data: 2019/1/1 9:21
 */
public class ImgCodeProperties {

    private  int width = 100;// 定义图片的width
    private  int height= 30;// 定义图片的height
    private  int codeCount = 4;// 定义图片上显示验证码的个数
    private int  expiredTime = 60;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }
}