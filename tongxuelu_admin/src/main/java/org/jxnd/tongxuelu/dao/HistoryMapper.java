package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.History;
import org.jxnd.tongxuelu.entity.HistoryExample;

public interface HistoryMapper {
    long countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);
    
    List<History> getAllHistory();
    
    
    /**
     * 自定义插入历史记录
     * @param record
     * @return
     */
    int insertHistory(History record);
    
}