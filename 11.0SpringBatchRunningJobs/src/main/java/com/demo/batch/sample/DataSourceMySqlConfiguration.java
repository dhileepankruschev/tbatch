package com.demo.batch.sample;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.mysql.jdbc.Driver;

@Configuration
public class DataSourceMySqlConfiguration {

    @Bean(name = "dataSource")
    @Scope
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }

    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-drop-mysql.sql"));
        databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-mysql.sql"));
        return databasePopulator;
    }

    private SimpleDriverDataSource createDataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        try {
			simpleDriverDataSource.setDriverClass((Class<Driver>) Class.forName("com.mysql.jdbc.Driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        simpleDriverDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        simpleDriverDataSource.setUsername("root");
        simpleDriverDataSource.setPassword("root");
        return simpleDriverDataSource;      
    }
}