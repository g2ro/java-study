package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String domain = scanner.nextLine();
		try {
			InetAddress[] InetAddresses = InetAddress.getAllByName(domain); // 도메인 한개에 하나의 IP주소가 할당된것은 아님.
			
			for(InetAddress inetAddress : InetAddresses) {
				System.out.print(domain + ":");
				System.out.println(inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		scanner.close();
		
	}
	
}
