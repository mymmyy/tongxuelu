package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.BlogCategory;
import org.jxnd.tongxuelu.entity.BlogCategoryExample;

public interface BlogCategoryMapper {
    long countByExample(BlogCategoryExample example);

    int deleteByExample(BlogCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    List<BlogCategory> selectByExample(BlogCategoryExample example);

    BlogCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByExample(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);
    
    List<BlogCategory> getAllBlogCategory();
}