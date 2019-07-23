import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

class Customer{
	private int id;
	private String name;

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return id +": "+ name;
	}
	
	public Customer(String name) {
		this.name = name;
	}
}

class CustomerManager{
	private List<Customer> customers = new ArrayList<Customer>();
	
	private int nextId = 0;
	
	public void addCustomer(Customer c) {
		synchronized (this) {
			c.setId(nextId);
			nextId++;
		}
		customers.add(c);
	}
	
	public Customer getNextCustomer() {
	return customers.get(0);
//		Customer result = null;
//		synchronized (customers) {
//			if(customers.size() >0)
//				result = customers.remove(0);
//		}
//		return result;
		
	}
	
	public void howManyCustomers() {
		int size = 0;
		size = customers.size();
		System.out.println(""+ new Date()+": "+size);
	}
	
	public void displayCustomers() {
		synchronized (customers) {
			for(Customer c:customers) {
				System.out.println(c.toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class GenerateCustomerTask implements Runnable{
	private CustomerManager cm;
	//private int totalCustomersGenerated = 0;
	
	public GenerateCustomerTask(CustomerManager c) {
		this.cm = c;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String name = new UUID(1L,10L).toString();
			Customer c = new Customer(name);
			cm.addCustomer(c);
			//totalCustomersGenerated++;
			cm.getNextCustomer();
		}
	}
	
	
}



public class TestMemory {
	
	
	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager();
		GenerateCustomerTask customerTask = new GenerateCustomerTask(customerManager);
		for(int user =0 ;user<10; user++) {
			Thread t = new Thread(customerTask);
			t.start();
		}
		
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customerManager.howManyCustomers();
			System.out.println("Available Memory: "+Runtime.getRuntime().freeMemory() / 1024 +"k");
		}
	}

}
