package prob05;

public class MyBase extends Base {
	@Override
	public void service(String state) {
		if(state.equals("오후")) {
			aftrenoon();
		}
		else {
			super.service(state);
		}
	}
	
	public void aftrenoon() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
	
}
