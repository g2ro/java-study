package thread;

public class UpperCaseAlphabet {
	public void print() {
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c);
			try {
				Thread.sleep(1000); // thread와 관련 없음, sleep을 사용하기 위한 것
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
