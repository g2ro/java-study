package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String str = new String("마이콜");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(str); // 값 기반으로 데이터를 넣기 때문에 크기는 s.add(str)이 없어도 3개
		
		System.out.println(s.size());
		System.out.println(s.contains("마이콜")); // 같은 객체여서 나오는 것이 아니라 값이 같아서 나온 것임.
		System.out.println(s.contains(str)); // 마이콜 값이 있는가?
		
		for(String str2 : s) {
			System.out.println(str2);
		}
		

	}

}
