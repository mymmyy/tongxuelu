package org.jxnd.tongxuelu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.LeaveWord;

public interface LeaveWordMapper {
	//查询
    public List<LeaveWord> selectLeaveWord(Map<String,Object>map) throws Exception;
    //添加
    public int addLeaveWord(LeaveWord leaveWord) throws Exception;
    //删除
    public int deleteLeaveWord(@Param("leaveWordId")int leaveWordId) throws Exception;
    //查询
    public int selectCount() throws Exception;
}
