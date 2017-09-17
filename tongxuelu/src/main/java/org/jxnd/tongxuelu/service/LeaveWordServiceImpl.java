package org.jxnd.tongxuelu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.dao.LeaveWordMapper;
import org.jxnd.tongxuelu.entity.LeaveWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveWordServiceImpl implements ILeaveWordService {

	@Autowired
	private LeaveWordMapper leaveWordMapper;
	
	public List<LeaveWord> selectLeaveWord(Map<String,Object>map) throws Exception{
		List<LeaveWord> list = this.leaveWordMapper.selectLeaveWord(map);
		return list;
	}
	
	//添加
	public boolean addLeaveWord(LeaveWord leaveWord) throws Exception{
		boolean flag = false;
		int count = this.leaveWordMapper.addLeaveWord(leaveWord);
		if(count>0){
			flag = true;
		}
		return flag;
	}
	//删除
	public boolean deleteLeaveWord(int leaveWordId) throws Exception{
		boolean flag = false;
		if(this.leaveWordMapper.deleteLeaveWord(leaveWordId)>0){
			flag = true;
		}
		return flag;
	}
	 //查询
	public int selectCount() throws Exception{
		int count = 0;
		count = this.leaveWordMapper.selectCount();
		return count;
	}

}
