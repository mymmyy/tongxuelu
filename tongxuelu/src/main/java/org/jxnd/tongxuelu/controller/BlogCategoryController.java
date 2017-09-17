package org.jxnd.tongxuelu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.BlogCategory;
import org.jxnd.tongxuelu.service.IBlogCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 * 文章分类的controller层
 * @author jjq
 *
 */
@Controller
@RequestMapping("/BlogCategoryController")
public class BlogCategoryController {
	@Autowired
	private IBlogCategroyService ibcs;
	@ResponseBody
	@RequestMapping("/getAllBlogCategory")
	public MSG getAllBlogCategory(){
		List<BlogCategory> list=ibcs.getAllBlogCategory();
		if(list!=null){
			return MSG.success().add("list", list);
		}else
			return MSG.fail();
	}
	
}
