package paramonov.valentine.d8test.service;

import java.util.List;

public interface StorageService<T> {
    boolean add(T t);
    boolean delete(long id);
    boolean update(T t);
    T get(long id);
    List<T> getValues();
}
