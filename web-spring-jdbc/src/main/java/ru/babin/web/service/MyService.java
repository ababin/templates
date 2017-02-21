package ru.babin.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
		   
	
    @Autowired
    DataSource dataSource;
    
    
	public int getNumber(){
		return 45;
	}
	
	@Transactional
	public List <String> getChannels(){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List <String> res = new ArrayList <>();
		
		jdbcTemplate.query( "SELECT id from btv_channel", 
                				(rs, rowNum) -> res.add(rs.getString(1))
        				  );
		return res;
	}
	
}
