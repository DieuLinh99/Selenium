package math;

public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	public int add(int a, int b) {
		return (a+b);
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int devide(int a, int b){
		int i = 0;
		try{
			i = a/b;
		}catch(ArithmeticException e) {
			System.out.print(e);
		}
		return i;
	}

}
