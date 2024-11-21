package prob06;

public class Div {
	private int lValue;
	private int rValue;
	
	public void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public float calculate() {
		float result;
		result = this.lValue / this.rValue;
		return result;
	}
}
