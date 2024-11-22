package prob02;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String lresult = "오리의 이름은";
		String Rresult = " 입니다.";
		
		return lresult + this.name + Rresult;
	}
	public abstract void fly();
	public abstract void sing();
	
}