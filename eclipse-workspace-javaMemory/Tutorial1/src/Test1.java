
public class Test1 {
	
	public static void main(String[] args) {
		int age = 10;
		String name = "hello";
		age = calculate(age);
		System.out.println("Update age "+age);
		
	}
	static int calculate(int data) {
		return data * 2;
	}

}
