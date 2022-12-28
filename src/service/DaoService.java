package service;

import java.util.List;

public interface DaoService<T, K> {
    List<T> findAll();

    T findById(K id);

    void save(T data);

    void update(T data, K id);

    void delete(K id);
}