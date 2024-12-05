package prob06;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}
	
	public Object add(Money money) {
		int result = amount + money.amount;
		return new Money(result);
	}
	
	public Object minus(Money money) {
		int result = amount - money.amount;
		return new Money(result);
	}
	
	public Object multiply(Money money) {
		int result = amount * money.amount;
		return new Money(result);
	}
	
	public Object divide(Money money) {
		int result = amount / money.amount;
		return new Money(result);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			Money other = (Money)obj;
			return amount == other.amount;
		} else {
			return false;
		}			
	}	
}
