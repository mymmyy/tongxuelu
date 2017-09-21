package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.entity.AdministratorExample;

public interface AdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
    
    Administrator adminLogin(@Param("name") String name,@Param("pwd") String pwd);
    
    List<Administrator> getAllAdmin();
    
    int deleteAdmin(@Param("name")String name);
    
    int updatePwd(@Param("pwd")String pwd,@Param("name")String name);
    
    List<Administrator> getAdminBypage(@Param("pageIndex")int pageIndex,@Param("size")int size);
    
    int getCount();
}