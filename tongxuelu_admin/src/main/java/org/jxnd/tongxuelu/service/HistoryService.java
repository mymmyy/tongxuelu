package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.entity.History;
import org.springframework.stereotype.Service;

@Service
public interface HistoryService {
	List<History> getAllHistory();
}
