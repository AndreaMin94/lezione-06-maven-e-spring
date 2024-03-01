package it.aulab.repositories;

public interface RepositoryInterface<T> {
    public T findById(Long id);
    public boolean save(T model);
    public boolean update(T model);
    public boolean delete(Long id);
}
