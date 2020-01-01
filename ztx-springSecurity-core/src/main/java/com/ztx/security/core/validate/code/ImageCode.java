package com.ztx.security.core.validate.code;
/**
 * 图形验证码
 * @author zuo
 *
 */

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {
	private BufferedImage image;
	private String code;
	private LocalDateTime expireTime;
	
	/**
	 * 过期时间
	 * @param image
	 * @param code
	 * @param expireIn	多少s后过期
	 */
	public ImageCode(BufferedImage image, String code, int expireIn) {
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	
	/**
	 * 带参构造方法
	 * @param image
	 * @param code
	 * @param expireTime	过期时间
	 */
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		this.image = image;
		this.code = code;
		this.expireTime = expireTime;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
}
