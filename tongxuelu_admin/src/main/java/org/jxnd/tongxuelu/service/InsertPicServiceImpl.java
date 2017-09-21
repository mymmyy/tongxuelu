package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.InsertPicMapper;
import org.jxnd.tongxuelu.entity.InsertPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertPicServiceImpl implements InsertPicService {
	@Autowired
	private InsertPicMapper insertpic;

	@Override
	public List<InsertPic> getAllPic() {
		return insertpic.getAllPic();
	}

}
