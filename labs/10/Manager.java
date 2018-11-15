public class Manager extends Employee implements Printable {
	Manager(){
		
	}
	
	Manager(String name, int age, int hourRate){
		this.name = name;
		this.age = age;
		this.hourRate = hourRate;
	}
	
	Manager(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public double salary(double hours) {
		return hours * hourRate;
	}

	@Override
	public void print() {
		System.out.println("Manager - Name = " + name + " Age = " + age);
	}
}