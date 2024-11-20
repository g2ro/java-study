package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		int len = str.length();
		int mid;
		char [] c = new char[len];
		
		
		if((len / 2) == 0) {
			mid = (len % 2)+ 1;
		}
		else {
			mid = len / 2;
		}
		
		for(int i = 0; i < mid; i++) {
			c[i] = str.charAt(len - 1 - i);
			c[len-1-i] = str.charAt(i);
		}
		
		return c;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println(array);
	}
}