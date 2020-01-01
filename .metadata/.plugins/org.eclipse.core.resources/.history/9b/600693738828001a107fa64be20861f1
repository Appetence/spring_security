package com.ztx.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ztx.entity.Dept;

import feign.hystrix.FallbackFactory;
//实现fallbackfactory接口，统一处理短融现象
@Component//标识为组件，必须添加
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public Dept get(long id) {
				return new Dept().setDname("该服务id:"+id+"暂时失效，请稍后重试").setDb_source("no databases in this mysql").setDeptno(id);
			}

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
			
		};
	}
	
	
}
 