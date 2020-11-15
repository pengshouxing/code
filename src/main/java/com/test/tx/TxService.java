package com.test.tx;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxService {
	
	@Autowired
	private TxDao txDao;
	
	@Transactional
	public void insertSchool() {
		saveSchool();
	}
	
	@Transactional
	public void saveSchool() {
		Random random = new Random();
		txDao.insert("深圳大学"+random.nextInt(10)+random.nextInt(10));
		int i = 10/0;
	}

}
