abstract class Q1 {
	
	public abstract void printMessage();
}

class Sub1 extends Q1 {

	Sub1(){
		printMessage();
	}
	
	@Override
	public void printMessage() {
		System.out.println("This is first subclass");
	}
	
}

class Sub2 extends Q1 {

	Sub2(){
		printMessage();
	}
	@Override
	public void printMessage() {
		System.out.println("This is second subclass");
	}
	
}