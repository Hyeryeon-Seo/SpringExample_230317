package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan(basePackages = "com.example.*")  // mapper scan 추가!!! - 여기 베이스패키지이름으로 (spring..applic에서 잘붙)
@Configuration // Spring bean 설정 관련 / 이 어노테이션있어야 스프링 빈으로 동작
public class DatabaseConfig {
	
	  @Bean // 맨 아래 걸로 core. ..보라색 import
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);

	        // 아래 classpath대로 패키지-xml 만들기, *자리에 테이블명
	        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
	        sessionFactory.setMapperLocations(res);

	        return sessionFactory.getObject();
	    }
	

}
