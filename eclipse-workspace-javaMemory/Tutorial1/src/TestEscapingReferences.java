import java.util.HashMap;
import java.util.Map;

class Employee{
	private String name;
}

class EmployeeManager{
	Map<String, Employee> map = new HashMap<String, Employee>();

	//this returns the map object with which we get Employee object can change it.
	public Map<String, Employee> getMap() {
		return map;
	}

	public void setMap(Map<String, Employee> map) {
		this.map = map;
	}
	
	
	
}




public class TestEscapingReferences {

}
