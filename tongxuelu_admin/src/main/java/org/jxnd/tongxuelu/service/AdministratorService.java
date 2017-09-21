package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.entity.Administrator;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {
	/*登录验证*/
	Administrator adminLogin(String name,String pwd);
	/*获取所有管理员*/
	List<Administrator> getAllAdmin();
	/*删除管理员*/
	int deleteAdmin(String name,Administrator admin);
	/*管理员修改密码*/
	int updatePwd(String pwd,String name,Administrator admin);
	//分页查询
	List<Administrator> getAdminBypage(int pageIndex,int size);
	//查询数据条数
	int getCount();
 
}
