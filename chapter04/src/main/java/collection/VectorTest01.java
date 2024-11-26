package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
// Collection 편입전
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
		// 순회1
		for(int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v.removeElementAt(2);
		
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) { // e에 데이터가 존재하는 지 확인
			String s = e.nextElement();
			System.out.println(s);
		}
	}

}
