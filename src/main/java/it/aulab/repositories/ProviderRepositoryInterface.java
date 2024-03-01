package it.aulab.repositories;
import it.aulab.models.Provider;
@Deprecated
public interface ProviderRepositoryInterface {
    public Provider findById(Long id);
    public boolean save(Provider Provider);
    public boolean update(Provider Provider);
    public boolean delete(Long id);
}
