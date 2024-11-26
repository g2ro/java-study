package behavior.iterator;

public interface Iterator<E> {
	E next();
	boolean hasNext(); // hasNext는 존재 유무에 대한 것
}
