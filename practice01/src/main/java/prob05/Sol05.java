package prob05;

public class Sol05 {
	public static void main(String[] args) {

		for(int i = 1; i<= 100; i++) {
			// System.out.println(i); == System.out.print( i + '\n');
			/*문자열 반환 => 3,6,9비교*/
			
			String number = String.valueOf(i);
			int claps = 0;
			int len = number.length();
			for(int e = 0; e < len; e++) {
				char ele = number.charAt(e);
				if(ele == '3' || ele == '6' || ele == '9') {
					claps += 1;
				}
			}
			if(claps != 0) {
				System.out.print(i + " ");
				for(int clap = 1; clap <= claps; clap+= 1 ) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}
