package com.ztx.config;
/**
 * @author:wenfan
 * @description:
 * @data: 2019/1/1 9:31
 */
public class BrowserProperties {

    private ImgCodeProperties img=new ImgCodeProperties();
    private String url = "123";
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ImgCodeProperties getImg() {
        return img;
    }

    public void setImg(ImgCodeProperties img) {
        this.img = img;
    }
}