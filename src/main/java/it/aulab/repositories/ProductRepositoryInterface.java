package it.aulab.repositories;
import it.aulab.models.Product;
@Deprecated
public interface ProductRepositoryInterface {
    public Product findById(Long id);
    public boolean save(Product product);
    public boolean update(Product product);
    public boolean delete(Long id);
}
