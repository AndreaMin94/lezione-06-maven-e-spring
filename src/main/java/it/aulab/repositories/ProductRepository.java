package it.aulab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import it.aulab.models.Product;

public class ProductRepository implements RepositoryInterface<Product> {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Product findById(Long id) {
        return jdbcTemplate.queryForObject(
            "Select * FROM products WHERE id = ? LIMIT 1",
            BeanPropertyRowMapper.newInstance(Product.class),
            id
        );
    }

    @Override
    public boolean save(Product product) {
        return jdbcTemplate.update(
            "INSERT INTO products (name, price) VALUES (?, ?)",
            product.getName(),
            product.getPrice()
        ) > 0;
    }

    @Override
    public boolean update(Product product) {
        return jdbcTemplate.update(
            "UPDATE products SET name = ?, price = ? WHERE id = ?",
            product.getName(),
            product.getPrice(),
            product.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(
            "DELETE FROM products WHERE id = ?",
            id
        ) > 0;
    }
}
