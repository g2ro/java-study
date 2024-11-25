package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		/* 구현하기 */
		top = -1;
		buffer = new String[capacity];
	}

	public void push(String s) {
		/* 구현하기 */
		if(this.top == this.buffer.length-1) {
			this.resize();
		}
		buffer[++top] = s;
	}

	public String pop() throws MyStackException {
		/* 구현하기 */
		if(isEmpty()) {
			throw new MyStackException();
		}
		String result = this.buffer[top--];
		
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
		String [] buffer2 = new String[len];
		buffer2 = buffer.clone();
		buffer = new String[len * 2];
		
		for(int i = 0; i < len; i++) {
			buffer[i] = buffer2[i];
		}
		
	}	
}