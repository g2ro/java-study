package prob02;

public class Sparrow extends Bird {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("참새(" + super.getName() +")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("참새(" + super.getName() +")가 소리내어 웁니다.");
	}

}
