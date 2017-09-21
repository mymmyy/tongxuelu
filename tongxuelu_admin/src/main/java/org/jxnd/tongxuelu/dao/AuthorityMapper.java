package org.jxnd.tongxuelu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Authority;
import org.jxnd.tongxuelu.entity.AuthorityExample;
import org.jxnd.tongxuelu.entity.Roles;
import org.jxnd.tongxuelu.entity.RolesAuthority;

public interface AuthorityMapper {
    long countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExample(AuthorityExample example);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);
    
    List<Authority> getAuthorityByrolesid(@Param("rid") int rid);
    
    List<Authority> selectAuthorityAll();
    
    List<Authority> getAuthorityByRid(int rid);
    
    int deleteRoleSystemByRid(int rid);
    
    int insertRoleAuthority(RolesAuthority info);
    
    List<Roles> selectRolesAll();
}