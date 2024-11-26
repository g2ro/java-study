package behavior.iterator;

public class Client {

	public static void main(String[] args) {
		Aggregate<String> fruits = new AggregateImpl<>(new String[] {"Mago", "Banana", "Apple"});
		Iterator<String> it = fruits.createIterator();
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
		

	}

}
