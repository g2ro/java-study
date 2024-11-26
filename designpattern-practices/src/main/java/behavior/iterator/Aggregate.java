package behavior.iterator;
// Aggregate : 데이터를 갖고 있음.
// 자료구조에서 제네릭은 E를 많이 사용

public interface Aggregate<E> {
 Iterator<E> createIterator();
}
