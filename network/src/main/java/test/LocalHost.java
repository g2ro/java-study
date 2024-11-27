package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// 내 ip주소 찾기
		try {
			InetAddress inetAddress = InetAddress.getLocalHost(); // ip addr과 host name이 같이 존재함.
			
			String hostName = inetAddress.getHostName();
			String hostIPAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIPAddress);
			
			byte[] IPAddresses = inetAddress.getAddress();
			for(byte IPAddress : IPAddresses) {
//				System.out.println(IPAddress); // byte를 정수 표현식으로 인해 singed int 형태로 출력됨
				System.out.println(IPAddress & 0x000000ff);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
