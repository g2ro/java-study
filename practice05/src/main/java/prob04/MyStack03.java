package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack03(int capacity) {
		/* 구현하기 */
		top = -1;
		buffer = (T[])new Object[capacity];
	}

	public void push(T s) {
		/* 구현하기 */
		if(this.top == this.buffer.length-1) {
			this.resize();
		}
		buffer[++top] = s;
	}

	public T pop() throws MyStackException {
		/* 구현하기 */
		if(isEmpty()) {
			throw new MyStackException();
		}
		T result = this.buffer[top--];
		
		return result;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		if(this.top == -1) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		/* 구현하기 */
		int len = buffer.length;
		T[] buffer2 = (T[])new Object[len];
		buffer2 = buffer.clone();
		buffer = (T[])new Object[len * 2];
		
		for(int i = 0; i < len; i++) {
			buffer[i] = buffer2[i];
		}
		
	}
}
