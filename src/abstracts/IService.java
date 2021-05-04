package abstracts;

import java.util.List;


public interface IService<T extends IEntity<T>> {

    public void add(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T getById(int id);
    public List<T> getAll();
}
