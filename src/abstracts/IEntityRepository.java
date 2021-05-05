package abstracts;

import java.util.List;
import java.util.function.Predicate;

public interface IEntityRepository<T extends IEntity<T>> {
	public void add(T entity);

	public void update(T entity) throws Exception;

	public void delete(T entity) throws Exception;

	public java.util.List<T> getAll();

	public T getById(int id);

	public T get(Predicate<? super T> filter);

	public List<T> getFiltered(Predicate<? super T> filter);

}