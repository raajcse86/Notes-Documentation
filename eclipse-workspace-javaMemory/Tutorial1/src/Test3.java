
public class Test3 {

	
	public static void main(String[] args) {
		int localvalue = 5;
		calculate(localvalue);
		System.out.println(localvalue );
	}
	
	public static void calculate(int calcvalue) {
		calcvalue = calcvalue * 100;
	}
}
