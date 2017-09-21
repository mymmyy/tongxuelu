package org.jxnd.tongxuelu.service;

import java.util.Date;
import java.util.List;

import org.jxnd.tongxuelu.dao.AuthorityMapper;
import org.jxnd.tongxuelu.dao.HistoryMapper;
import org.jxnd.tongxuelu.dao.RolesMapper;
import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.entity.Authority;
import org.jxnd.tongxuelu.entity.History;
import org.jxnd.tongxuelu.entity.Roles;
import org.jxnd.tongxuelu.entity.RolesAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityMapper autmapper;
	
	@Autowired
	private HistoryMapper historyMapper;
	
	@Autowired
	private RolesMapper roles;

	@Override
	public List<Authority> getAuthorityByrolesid(int rid) {
		return autmapper.getAuthorityByrolesid(rid);
	}
	
	@Override
	public List<Authority> selectAuthorityAll() {
		return autmapper.selectAuthorityAll();
	}

	@Override
	public List<Authority> getAuthorityByRid(int rid) {
		return autmapper.getAuthorityByRid(rid);
	}
	
	@Override
	public int deleteRoleSystemByRid(int rid) {
		return autmapper.deleteRoleSystemByRid(rid);
	}

	@Override
	public int updateRoleSystem(int rid, int[] items,Administrator admin) {
		History history = 
				new History(admin.getId(),admin.getName(),"修改权限",new Date());
		historyMapper.insertHistory(history);
		int i=autmapper.deleteRoleSystemByRid(rid);
		for (int sid : items) {
			autmapper.insertRoleAuthority(new RolesAuthority(0, rid, sid));
		}
		return i;
	}
	
	@Override
	public List<Roles> selectRolesAll() {
		return autmapper.selectRolesAll();
	}

}
