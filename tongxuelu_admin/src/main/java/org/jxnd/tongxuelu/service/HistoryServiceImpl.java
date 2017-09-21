package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.HistoryMapper;
import org.jxnd.tongxuelu.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
	@Autowired
	private HistoryMapper his;

	@Override
	public List<History> getAllHistory() {
		return his.getAllHistory();
	}

}
