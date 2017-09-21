package org.jxnd.tongxuelu.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.service.AdministratorService;
import org.jxnd.tongxuelu.service.ILeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	private AdministratorService admins;
	
	
	
	
	/*登录功能*/
	@RequestMapping("/adminLogin")
	@ResponseBody
	public MSG adminLogin(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		Administrator admin=admins.adminLogin(name, pwd);
		if(admin!=null){
			request.getSession().setAttribute("admin",admin);
			return MSG.success().add("admin",admin);
		}else{
			return MSG.fail();
		}
	}
	
	/*获取所有管理员信息*/
	@RequestMapping("/getAllAdmin")
	@ResponseBody
	public MSG getAllAdmin(){
		
		List<Administrator> list=admins.getAllAdmin();
		
		if(list != null){
			return MSG.success().add("list", list);
		}else {
			return MSG.fail();
		}
		
		
	}
	
	
	
	/*通过name删除管理员*/
	@ResponseBody
	@RequestMapping("/deleteAdmin")
	public int deleteAdmin(String name,HttpServletRequest request){
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		return admins.deleteAdmin(name,admin);
	}
	

	
	/*@RequestMapping(value="/adminLogin")
	@ResponseBody                                   //数据传到前台需要使用
	public MSG adminLogin(String name,String pwd){
		System.out.println("123");
		Administrator admin=admins.adminLogin(name, pwd);
		if(admin!=null){
			return MSG.success();
		}else{
			return MSG.fail();
		}
	}*/
	
	/*修改密码*/
	@RequestMapping("/updatePwd")
	@ResponseBody 
	public int updatePwd(String newPwd,HttpServletRequest request){
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		String name=admin.getName();
		int i=admins.updatePwd(newPwd, name,admin);
		return i;
	}


	/*旧密码对比*/
	@RequestMapping("/compareoldPwd")
	@ResponseBody 
	public int compareoldPwd(String oldPwd,HttpServletRequest request){
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		if(admin.getPwd().equals(oldPwd))
			return 1;
		else
			return 0;
	}
	
	/*分页查询*/
	
	@RequestMapping("/getAdminByPage")
	@ResponseBody
	public MSG getAdminByPage(int pageIndex,int size){
		List<Administrator> list=admins.getAdminBypage(pageIndex, size);
		if(list!=null){
			return MSG.success().add("list", list);
		}else{
			return MSG.fail();
		}
		
		
	}
	
	@RequestMapping("/getCount")
	@ResponseBody
	public int getCount(){
		int i=admins.getCount();
		return i;
	}
	
	
	
}
