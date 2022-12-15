package com.project.codingtask.repos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.codingtask.entity.ENewspaperModel;

@Repository
public class SpringJdbc {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
		 
    public  List<ENewspaperModel> findBywidthContaining(int width,int offset,int pagesize,
    		                                            String sort)
    {
    	
    	String WIDTH_QUERY="select * from enewspaper where width like '%"+width+"%' order by "+sort+" offset "+offset+" rows fetch next "+pagesize+" rows only" ;
    	return springJdbcTemplate.query(WIDTH_QUERY, new BeanPropertyRowMapper<>(ENewspaperModel.class));
    }
    public  List<ENewspaperModel> findByheightContaining(int height,int offset,int pagesize,
            String sort){

       String HEIGHT_QUERY="select * from enewspaper where height like '%"+height+"%' order by "+sort+" offset "+offset+" rows fetch next "+pagesize+" rows only" ;
       return springJdbcTemplate.query(HEIGHT_QUERY, new BeanPropertyRowMapper<>(ENewspaperModel.class));
}
    public  List<ENewspaperModel> findBydpiContaining(int dpi,int offset,int pagesize,
            String sort){

       String DPI_QUERY="select * from enewspaper where dpi like '%"+dpi+"%' order by "+sort+" offset "+offset+" rows fetch next "+pagesize+" rows only" ;
       return springJdbcTemplate.query(DPI_QUERY, new BeanPropertyRowMapper<>(ENewspaperModel.class));
}
	
}
