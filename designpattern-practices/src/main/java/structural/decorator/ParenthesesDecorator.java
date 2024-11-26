package structural.decorator;

public class ParenthesesDecorator extends Decorator {
//	ParenthesesDecorator(){
//		super();
//	} => Decorator의 기본생성자가 없어 오류 발생
	
	public ParenthesesDecorator(Component component){
		super(component);
	}
	@Override
	public String operation() {
		String text = component.operation();
		return "(" + text + ")";
	}

}
