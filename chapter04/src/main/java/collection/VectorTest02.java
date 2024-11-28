package collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("또치");
		
		// 순회1
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		// 삭제
		list.remove(2);
		
		// 순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) { // e에 데이터가 존재하는 지 확인
			String s = it.next();
			System.out.println(s);
		}
		
		// 순회3
		// 배열 자체는 iterable이 없음 => 배열을 list로 바꿔주는 기능이 생긴거라고 생각됨.
		for(String s : list) {
			System.out.println(s);
		}

	}

}