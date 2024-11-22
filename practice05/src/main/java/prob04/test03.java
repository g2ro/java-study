package prob04;

public class test03 {

	public static void main(String[] args) {
		String [] buffer = new String[3];
		buffer[0] = "AA";
		buffer[1] = "AA";
		buffer[2] = "AA";
		
		String [] buffer2 = new String[6];
		buffer2[0] = "AA";
		buffer[5] = "AA";
		buffer = buffer2;
		System.out.println(buffer[5]);
		
	}

}
