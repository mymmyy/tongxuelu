package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.entity.BlogCategory;
import org.springframework.stereotype.Service;

@Service
public interface IBlogCategroyService {
	List<BlogCategory> getAllBlogCategory();
}
