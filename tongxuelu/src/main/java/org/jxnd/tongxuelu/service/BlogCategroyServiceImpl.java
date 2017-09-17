package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.BlogCategoryMapper;
import org.jxnd.tongxuelu.entity.BlogCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BlogCategroyServiceImpl implements IBlogCategroyService {
	
	@Autowired
	private BlogCategoryMapper blogCategroyMapper;
	@Override
	public List<BlogCategory> getAllBlogCategory() {
		// TODO Auto-generated method stub
		
		return blogCategroyMapper.getAllBlogCategory();
	}

}
