package com.cos.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//configuration, controller, restcontroller, bean, component, service, repository
//용도에 맞게 메모리에 올리기 위해 사용하는 어노테이션
//new 할 필요 없이 spring에서 싱글톤관리

@Configuration
@MapperScan(basePackages = "com.cos.board.repository")
public class DataAccessConfig {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		sessionFactory
				.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}