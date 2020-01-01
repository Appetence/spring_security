package com.ztx.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 监听器
 * @author zuo
 *
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{//bean初始化完成之后执行
	private Logger logger = LoggerFactory.getLogger(QueueListener.class);
	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		new Thread(() -> {
			while( true ) {
				logger.info("***********"+mockQueue.getComplete());
				if(StringUtils.isNotBlank(mockQueue.getComplete())) {
					String orderNumber = mockQueue.getComplete();
					logger.info("订单处理完成："+orderNumber);
					//设置处理结果返回
					deferredResultHolder.getMap().get(orderNumber).setResult("complate order result");
					mockQueue.setComplete(null);
				}else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		})/*.start()*/ ;
		
	}
}