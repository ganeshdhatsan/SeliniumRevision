package SeleniumMethods;

public class ClassA extends ClassB{
	
	public void method1() {
	System.out.println("method1");
	}
	
	public void method2() {
		System.out.println("method2");

	}
	public void method3() {
		System.out.println("method3");

	}
	

	public void m4() {
		System.out.println("ClassA-m4");
	}
	
	public static void main(String[] args) {
		
		ClassA a = new ClassA();
		
		ClassB b = new ClassB();
		
		ClassB b1 = new ClassA();
	    b1.m4();
		
		
		
		
	}

}
