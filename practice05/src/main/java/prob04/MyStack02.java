package prob04;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		/* 구현하기 */
		top = -1;
		buffer = new Object[capacity];
	}

	public void push(Object s) {
		/* 구현하기 */
		if(this.top == this.buffer.length-1) {
			this.resize();
		}
		buffer[++top] = s;
	}

	public Object pop() throws MyStackException {
		/* 구현하기 */
		if(isEmpty()) {
			throw new MyStackException();
		}
		Object result = this.buffer[top--];
		
		return result;
	}

	public boolean isEmpty() {
		/* 구현하기 */
		if(this.top == -1) {
			return true;
		}
		return false;
	}

	private void resize() {
		/* 구현하기 */
		int len = buffer.length;
		Object [] buffer2 = new Object[len];
		buffer2 = buffer.clone();
		buffer = new Object[len * 2];
		
		for(int i = 0; i < len; i++) {
			buffer[i] = buffer2[i];
		}
		
	}
}
