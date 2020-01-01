package com.ztx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ztx.entity.Dept;
import com.ztx.service.DeptService;

@RestController
@RequestMapping("dept")
public class DeptController {
	@Autowired
	private DeptService deptService = null;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	};
	@RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept findById(@PathVariable("id") Long id) {
		Dept dept =  this.deptService.findById(id);
		
		if(dept == null) {
			throw new RuntimeException("该ID:"+id+"无对应的信息");
		}
		
		return dept;
	};
	//上边方法短融时候执行此方法
	@SuppressWarnings("unused")
	private Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID:"+id+"无对应信息").setDb_source("无此数据库");
	}
	
	@RequestMapping(value="/dept/list",method = RequestMethod.GET)
	public List<Dept> findAll(){
		return deptService.findAll();
	};
	
	
}
