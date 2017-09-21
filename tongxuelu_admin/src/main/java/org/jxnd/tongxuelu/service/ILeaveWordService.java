package org.jxnd.tongxuelu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.LeaveWord;
import org.springframework.stereotype.Service;

@Service
public interface ILeaveWordService {
	//查询
   public List<LeaveWord> selectLeaveWord(Map<String,Object>map) throws Exception;
   //添加
   public boolean addLeaveWord(LeaveWord leaveWord) throws Exception;
   //删除
   public boolean deleteLeaveWord(int leaveWordId) throws Exception;
   //查询
   public int selectCount() throws Exception;
   //查询所有的留言数据
   List<LeaveWord> getAllWord();
   
   //后台删除
   int deleteWord(int leaveWordId);
   
 //分页获取所有数据
   List<LeaveWord> getWordByPage(int pageIndex,int size);
   //获取数据条数
   int getCount();
}
