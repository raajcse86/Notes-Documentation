class CustomerTest{
	//private int id;
	private String name;
	
	CustomerTest(String name){
		this.name = name;
	}
}


public class TestGC {

	public static void main(String[] args) {
		
		Runtime rt = Runtime.getRuntime();
					
		System.out.println("Available memory "+rt.freeMemory());
		
		
		for(int i=1; i <=1000000;i++) {
			new CustomerTest("test"+i);
		}

		
		System.out.println("Avail memory"+rt.freeMemory());
		
		System.gc();
		System.out.println("After gc "+rt.freeMemory());
	}
}
