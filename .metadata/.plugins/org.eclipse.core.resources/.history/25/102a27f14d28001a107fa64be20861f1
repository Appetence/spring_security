package com.ztx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztx.entity.Dept;
import com.ztx.service.DeptService;

@RestController
@RequestMapping("dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	};
	@RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
	public Dept findById(@PathVariable("id") Long id) {
		return deptService.findById(id);
	};
	
	@RequestMapping(value="/dept/list",method = RequestMethod.GET)
	public List<Dept> findAll(){
		return deptService.findAll();
	};
	//自测微服务调用是否可以获取信息，主要用于对外展现，测试哪些微服务可用
	@RequestMapping(value = "/dept/discovery" ,method=RequestMethod.GET)
	public Object discovery(){
		List<String> list = discoveryClient.getServices();
		System.out.println("++++++++++"+list);
		List<ServiceInstance> srvlist = discoveryClient.getInstances("provider-dept");
		for (ServiceInstance element: srvlist) {
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getUri()+"\t"+element.getPort());
		}
		return this.discoveryClient;
	};
}
