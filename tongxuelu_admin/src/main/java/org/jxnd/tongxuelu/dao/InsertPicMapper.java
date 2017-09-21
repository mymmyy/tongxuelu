package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.InsertPic;
import org.jxnd.tongxuelu.entity.InsertPicExample;

public interface InsertPicMapper {
    long countByExample(InsertPicExample example);

    int deleteByExample(InsertPicExample example);

    int deleteByPrimaryKey(String imgId);

    int insert(InsertPic record);

    int insertSelective(InsertPic record);

    List<InsertPic> selectByExample(InsertPicExample example);

    InsertPic selectByPrimaryKey(String imgId);

    int updateByExampleSelective(@Param("record") InsertPic record, @Param("example") InsertPicExample example);

    int updateByExample(@Param("record") InsertPic record, @Param("example") InsertPicExample example);

    int updateByPrimaryKeySelective(InsertPic record);

    int updateByPrimaryKey(InsertPic record);
    
    List<InsertPic> getAllPic();
}