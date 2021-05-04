package abstracts;

public interface IEntity<T extends IEntity<?>> {
	public int getId();
	public void Clone(T entity);
}
