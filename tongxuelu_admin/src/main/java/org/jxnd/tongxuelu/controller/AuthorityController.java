package org.jxnd.tongxuelu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.entity.Authority;
import org.jxnd.tongxuelu.entity.LeaveWord;
import org.jxnd.tongxuelu.entity.Roles;
import org.jxnd.tongxuelu.service.AuthorityService;
import org.jxnd.tongxuelu.service.ILeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	@Autowired
	private AuthorityService auth;
	
	@Autowired
	private ILeaveWordService leaveWordService;
	
	
	
	@ResponseBody
	@RequestMapping("/updateRoleSystem")
	public int updateRoleSystem(HttpServletRequest request, HttpServletResponse response) {
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		int rid=Integer.parseInt(request.getParameter("rid"));
		String[] items=request.getParameter("items").split(",");
		int[] sidItem=new int[items.length];
		for (int i = 0; i < items.length; i++) {
			sidItem[i]=Integer.parseInt(items[i]);
		}
		if (auth.updateRoleSystem(rid, sidItem,admin)>0)
			return 1;
		else
			return 0;
	}
	
	@RequestMapping("/getAuthorityByRolesid")
	@ResponseBody
	public MSG getAuthorityByRolesid(HttpServletRequest request,HttpServletResponse reponse){
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		List<Authority> author=auth.getAuthorityByrolesid(admin.getRolesid());
		if(author!=null){
			System.out.println(author);
			return MSG.success().add("author", author);
		}else{
			return MSG.fail();
		}
		
	}
	
	
	@RequestMapping("/adminName")
	@ResponseBody
	public MSG adminName(HttpServletRequest request,HttpServletResponse response){
		Administrator admin=(Administrator) request.getSession().getAttribute("admin");
		if(admin!=null){
			return MSG.success().add("admin", admin);
		}else{
			return MSG.fail();
		}
		
	}
	
	
	/*查询所有权限*/
	@ResponseBody 
	@RequestMapping("/selectAuthorityAll")
	public List<Authority> selectAuthorityAll(){
		return auth.selectAuthorityAll();
	}

	/**通过角色id查询权限*/
	@ResponseBody
	@RequestMapping("/getAuthorityByRid")
	public List<Authority> getAuthorityByRid(int rid){
		return auth.getAuthorityByRid(rid);
	}
	 @ResponseBody
	    @RequestMapping("/getAllUserWord")
	    public List<LeaveWord> getAllWord(){
	    	System.out.println("进入方法");
	    	List<LeaveWord> list=leaveWordService.getAllWord();
	    	if(list!=null){
	    		return list;
	    	}else{
	    		return null;
	    	}
	    } /*删除*/
	    @ResponseBody
	    @RequestMapping("/deleteWord")
	    public int deleteWord(int leaveWordId){
	    	return leaveWordService.deleteWord(leaveWordId);
	    }
	    
	    /*获取数据条数*/
	    @ResponseBody
	    @RequestMapping("/getCount")
	    public int getCount(){
	    	int j=leaveWordService.getCount();
	    	return j;
	    }
	    
	    /*分页获取数据*/
	    @ResponseBody
	    @RequestMapping("/getWordByPage")
	    public List<LeaveWord> getWordByPage(int pageIndex,int size){
	    	List<LeaveWord> list=leaveWordService.getWordByPage(pageIndex, size);
	    	if(list!=null){
	    		return list;
	    	}else{
	    		return null;
	    	}
	    }
	 
	 
	 /**查询所有角色*/
		@ResponseBody
		@RequestMapping("selectRolesAll")
		public List<Roles> selectRolesAll(){
			return auth.selectRolesAll();
		}
		
		

}
