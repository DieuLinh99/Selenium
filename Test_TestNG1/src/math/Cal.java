package math;

public class Cal {
	int result;
	public int add(int x, int y) throws Exception{
		return result = x + y;
		
	}
	public int sub(int x, int y) throws Exception{
		return result = x - y;
	}
	public int div(int x, int y) throws ArithmeticException{
		if(y == 0) {
			throw new ArithmeticException("Can not divided by 0");
		}else {
			return result = x/y;
		}	
	}
	public int mul(int x, int y) throws Exception{
		return result = x*y;
	}

}
