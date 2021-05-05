package concrete;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import abstracts.IEntity;
import abstracts.IEntityRepository;

public class EntityReposiyoryBase<T extends IEntity<T>> implements IEntityRepository<T> {
	List<T> _context;

	public EntityReposiyoryBase(List<T> context) {
		_context = context;
	}

	@Override
	public void add(T entity) {
		_context.add(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		if (entity != null) {
			T entityToUpdate = this.getAll().stream().filter(p -> p.getId() == entity.getId()).findFirst().get();
			if (entityToUpdate == null)
				throw new Exception("Not found");
			entityToUpdate.Clone(entity);
		} else {
			throw new Exception("Not found");
		}

	}

	@Override
	public void delete(T entity) throws Exception {
		if (entity != null) {
			// T entityToDelete = this.getAll().stream().filter(p -> p.getId() ==
			// entity.getId()).findFirst().get();

			if (!_context.removeIf(p -> p.getId() == entity.getId()))
				throw new Exception("Not found");
		} else {
			throw new Exception("Not found");
		}
	}

	@Override
	public List<T> getAll() {
		return _context;
	}

	@Override
	public T getById(int id) {
		// return this.getAll().stream().filter(p -> p.getId() == id).findFirst().get();
		return this.get(p -> p.getId() == id);
	}

	public T get(Predicate<? super T> filter) {
		for (Iterator<T> iterator = _context.iterator(); iterator.hasNext();) {
			T t = (T) iterator.next();
			if (filter.test(t)) {
				return t;
			}

		}

		return null;
	}

	public List<T> getFiltered(Predicate<? super T> filter) {
		return this.getAll().stream().filter(filter).collect(Collectors.<T>toList());
	}

}
