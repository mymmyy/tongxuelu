package org.jxnd.tongxuelu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.LeaveWord;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.ILeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/space/leaveWord")
public class LeaveWordController {
	@Autowired
	private ILeaveWordService leaveWordService;
	
	/**
	 * @author Administrator
	 * @param start,end 分页参数
	 * @return MSG
	 * */
	@ResponseBody
    @RequestMapping("/selectLeaveWord")
    public MSG selectLeaveWord(String start,String end,HttpSession session){
		MSG msg = MSG.fail();
    	Map<String,Object> map =new HashMap<String,Object>();
    	User user = (User)session.getAttribute("spaceUser");
    	map.put("userId", user.getUserId());//从session中取值
    	map.put("start", Integer.parseInt(start));
    	map.put("end", Integer.parseInt(end));
    	List<LeaveWord> list = null;
    	try {
			list = this.leaveWordService.selectLeaveWord(map);
			for (LeaveWord leaveWord : list) {
				System.out.println(leaveWord.toString());
			}
			msg = MSG.success().add("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return msg;
    }
    //添加留言
	@ResponseBody
    @RequestMapping("/addLeaveWord")
    public MSG addLeaveWord(LeaveWord leaveWord,HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("existUser");
    	User spaceUser =  (User)session.getAttribute("spaceUser");
    	leaveWord.setLeaveUserId(user.getUserId());//留言者id
    	leaveWord.setUserId(spaceUser.getUserId());//被留言者ID
    	leaveWord.setDeleteState(1);
    	leaveWord.setLeaveWordTime(new java.sql.Date(new Date().getTime()));
    	try{
			if(this.leaveWordService.addLeaveWord(leaveWord)){
				msg=MSG.success();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
    	return msg;
    }
    //删除留言
    @ResponseBody
    @RequestMapping(value="/deleteLeaveWord/{id}")
    public MSG deleteLeaveWord(@PathVariable("id")int leaveWordId){
    	String msg = "0";
    	try {
			if(this.leaveWordService.deleteLeaveWord(leaveWordId)){
				msg = "1";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return MSG.success().add("returnMsg", msg);
    }
    //查询条数
    @ResponseBody
    @RequestMapping(value="/selectCount")
    public MSG selectCount(){
    	MSG msg = MSG.fail();
    	int count = 0;
    	try {
			count = this.leaveWordService.selectCount();
			msg = MSG.success().add("count", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  msg;
    }
} 
