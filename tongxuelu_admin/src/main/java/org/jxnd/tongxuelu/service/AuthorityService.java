package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.entity.Authority;
import org.jxnd.tongxuelu.entity.Roles;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {
	List<Authority> getAuthorityByrolesid(int rid);
	
	
	List<Authority> selectAuthorityAll();
	
	
	List<Authority> getAuthorityByRid(int rid);
	
	int deleteRoleSystemByRid(int rid);
	
	int updateRoleSystem(int rid,int[] items,Administrator admin);
	
	 List<Roles> selectRolesAll();
}
