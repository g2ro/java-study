package behavior.iterator;

public class AggregateImpl<E> implements Aggregate<E> {
	private E[] datas;
	
	public AggregateImpl(E[] datas) {
		this.datas = datas;
	} // 리스트 메소드 연산, 여기서는 외부에서 받아서 사용?
	
	@Override
	public Iterator<E> createIterator(){
		return new IteratorImpl();
	}
	
	private class IteratorImpl implements Iterator<E>{ // index를 이용하기 때문에 한번만 구현이 가능하다.
		private int index = 0;
		
		@Override
		public E next() {
			
			return index < datas.length ? datas[index++] : null;
		}

		@Override
		public boolean hasNext() {
			
			return index < datas.length;
		}
		
	}
}
