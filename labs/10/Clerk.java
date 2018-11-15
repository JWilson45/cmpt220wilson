public class Clerk extends Employee {
	Clerk(){
		
	}
	
	Clerk(String name, int age, int hourRate){
		this.name = name;
		this.age = age;
		this.hourRate = hourRate;
	}

	@Override
	public double salary(double hours) {
		return hours * hourRate;
	}
}