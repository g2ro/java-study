package structural.decorator;

public abstract class Decorator extends Component {
	protected Component component; // bufferedOutputStream에서 레퍼런스 변수표현?
	
	public Decorator(Component component) {
		this.component = component;
	}
}
