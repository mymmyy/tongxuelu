package org.jxnd.tongxuelu.controller;

import java.util.List;



import org.jxnd.tongxuelu.entity.History;
import org.jxnd.tongxuelu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/HistoryController")
public class HistoryController {
	
	@Autowired
	private HistoryService history;
	
	@RequestMapping("/getAllHistory")
	@ResponseBody
	public MSG getAllHistory(){
		List<History> list=history.getAllHistory();
		if(list!=null){
			return MSG.success().add("list", list);
		}else{
			return MSG.fail();
		}
	}

}
