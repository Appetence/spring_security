package com.ztx.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
@Component
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		// 销毁
		System.out.println("this is filter destry");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 执行的操作
		Date start = new Date();
		System.out.println("time filter start"+start);
		chain.doFilter(request, response);
		Date end = new Date();
		System.out.println("time filter end"+end);
		System.out.println(" filter time "+(end.getTime()-start.getTime()));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//初始化
		System.out.println("this is filter init");
	}

}
