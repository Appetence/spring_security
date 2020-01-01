package com.ztx.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ztx.web.interceptor.TimeInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer {//WebMvcConfigurer接口的方式，而不用使用WebMvcConfigurerAdapter 
	@Value("${domain.localLoad}")
	private String localLoad;
	
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(timeInterceptor).addPathPatterns("/user");;
		 //添加登录处理拦截器，拦截所有请求，登录请求除外
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(timeInterceptor);
        //排除配置
        /*interceptorRegistration.excludePathPatterns("/sys/login.json");
        interceptorRegistration.excludePathPatterns("/charts/**");
        interceptorRegistration.excludePathPatterns("/css/**");
        interceptorRegistration.excludePathPatterns("/easyUi/**");
        interceptorRegistration.excludePathPatterns("/flashPlayer/**");
        interceptorRegistration.excludePathPatterns("/font/**");
        interceptorRegistration.excludePathPatterns("/images/**");
        interceptorRegistration.excludePathPatterns("/js/**");
        interceptorRegistration.excludePathPatterns("/pages/**");
        interceptorRegistration.excludePathPatterns("/plugin/**");
        interceptorRegistration.excludePathPatterns("/index.html");
        interceptorRegistration.excludePathPatterns("/show.html");*/
        //配置拦截策略
        interceptorRegistration.addPathPatterns("/**");

	}
	/**   解决swagger  和shiro  兼容性问题    
	 * <p>Title: addResourceHandlers</p>   
	 * <p>Description: </p>   
	 * @param registry   
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)   
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
       // registry.addResourceHandler("/static/upload/2019/7/**").addResourceLocations("file:G:/MyworkSpace/sismanager/src/main/resources/static/upload/2019/7/");
        registry.addResourceHandler("/static/upload/**").addResourceLocations("file:"+localLoad+"/");
        
    }
		 */
	  /**   
	   *	 解决前后端分离跨域问题
	   * <p>Title: addCorsMappings</p>   
	   * <p>Description: </p>   
	   * @param registry   
	   * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	  
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
	                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
	                        "Access-Control-Request-Headers")
	                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
	                .allowCredentials(true).maxAge(3600);
	    }
 */
/*	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		TimeFilter TimeFilter = new TimeFilter();
		filterRegistrationBean.setFilter(TimeFilter);
		List<String> url = new ArrayList<String>();
		url.add("/*");
		filterRegistrationBean.setUrlPatterns(url);
		return filterRegistrationBean;
	}*/

}
