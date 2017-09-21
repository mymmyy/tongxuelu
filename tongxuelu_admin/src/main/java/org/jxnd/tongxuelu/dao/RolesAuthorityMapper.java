package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.RolesAuthority;
import org.jxnd.tongxuelu.entity.RolesAuthorityExample;

public interface RolesAuthorityMapper {
    long countByExample(RolesAuthorityExample example);

    int deleteByExample(RolesAuthorityExample example);

    int insert(RolesAuthority record);

    int insertSelective(RolesAuthority record);

    List<RolesAuthority> selectByExample(RolesAuthorityExample example);

    int updateByExampleSelective(@Param("record") RolesAuthority record, @Param("example") RolesAuthorityExample example);

    int updateByExample(@Param("record") RolesAuthority record, @Param("example") RolesAuthorityExample example);
}