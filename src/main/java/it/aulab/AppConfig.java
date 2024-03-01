package it.aulab;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import it.aulab.models.Product;
import it.aulab.models.Provider;
import it.aulab.repositories.ProductRepository;
import it.aulab.repositories.ProductRepositoryInterface;
import it.aulab.repositories.ProviderRepository;
import it.aulab.repositories.RepositoryInterface;

@Configuration
@ComponentScan("it.aulab")
public class AppConfig {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springcommerce");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public RepositoryInterface<Product> getProductRepository() {
        return new ProductRepository();
    }

    @Bean
    public RepositoryInterface<Provider> getProviderRepository() {
        return new ProviderRepository();
    }
}
