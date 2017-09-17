package org.jxnd.tongxuelu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.LeaveWord;

public interface ILeaveWordService {
	//查询
   public List<LeaveWord> selectLeaveWord(Map<String,Object>map) throws Exception;
   //添加
   public boolean addLeaveWord(LeaveWord leaveWord) throws Exception;
   //删除
   public boolean deleteLeaveWord(int leaveWordId) throws Exception;
   //查询
   public int selectCount() throws Exception;
}
