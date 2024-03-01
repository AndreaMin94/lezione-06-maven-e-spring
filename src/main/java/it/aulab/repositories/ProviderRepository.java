package it.aulab.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import it.aulab.models.Provider;

public class ProviderRepository implements RepositoryInterface<Provider>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Provider findById(Long id) {
        return jdbcTemplate.queryForObject(
            "Select * FROM providers WHERE id = ? LIMIT 1",
            BeanPropertyRowMapper.newInstance(Provider.class),
            id
        );
    }

    @Override
    public boolean save(Provider model) {
        return jdbcTemplate.update(
            "INSERT INTO providers (name, price) VALUES (?, ?)",
            model.getName()
        ) > 0;
    }

    @Override
    public boolean update(Provider model) {
        return jdbcTemplate.update(
            "UPDATE providers SET name = ? WHERE id = ?",
            model.getName(),
            model.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(
            "DELETE FROM providers WHERE id = ?",
            id
        ) > 0;
    }

}
