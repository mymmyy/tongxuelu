package org.jxnd.tongxuelu.service;

import java.util.Date;
import java.util.List;

import org.jxnd.tongxuelu.dao.AdministratorMapper;
import org.jxnd.tongxuelu.dao.HistoryMapper;
import org.jxnd.tongxuelu.entity.Administrator;
import org.jxnd.tongxuelu.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private AdministratorMapper mapper;
	
	@Autowired
	private HistoryMapper historyMapper;

	@Override
	public Administrator adminLogin(String name, String pwd) {
		return mapper.adminLogin(name, pwd);
	}

	@Override
	public List<Administrator> getAllAdmin() {
		return mapper.getAllAdmin();
	}

	@Override
	public int deleteAdmin(String name,Administrator admin) {
		History history = 
				new History(admin.getId(),admin.getName(),"删除管理员:"+name,new Date());
		historyMapper.insertHistory(history);
		return mapper.deleteAdmin(name);
	}

	@Override
	public int updatePwd(String pwd, String name,Administrator admin) {
		History history = 
				new History(admin.getId(),admin.getName(),"修改密码",new Date());
		historyMapper.insertHistory(history);
		return mapper.updatePwd(pwd, name);
	}

	@Override
	public List<Administrator> getAdminBypage(int pageIndex, int size) {
		pageIndex=(pageIndex-1)*size;
		return mapper.getAdminBypage(pageIndex, size);
	}

	@Override
	public int getCount() {
		return mapper.getCount();
	}

	

}
