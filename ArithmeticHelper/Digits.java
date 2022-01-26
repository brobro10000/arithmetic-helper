import java.util.Random;

public class Digits extends User{
	private int digit;
	protected int variables;
	
	Digits(int digit)
	{	
		super(name,digits,problems,operation);
		this.digit = digit;
	}
	public int getVariable() {
		variables = getDigit();
		return variables;
	}
	public int getDigit() {
		Random number = new Random();
		int result=0;
		if(digit == 1)
		{
			result = 0+number.nextInt(10);
			return result;
		}
		if(digit == 2)
		{
			result = 10+number.nextInt(90);
			return result;
		}
		if(digit == 3)
		{
			result = 100+number.nextInt(900);
			return result;
		}
		if(digit == 4)
		{
			result = 1000+number.nextInt(9000);
			return result;
		}
		if(digit == 5)
		{
			result = 10000+number.nextInt(90000);
			return result;
		}
		if(digit == 6)
		{
			result = 100000+number.nextInt(900000);
			return result;
		}
		if(digit == 7)
		{
			result = 1000000+number.nextInt(9000000);
			return result;
		}
		
		return -1;
	}
//	public static void main(String[] args) {
//		int i=0;
//		int digit = 1;
//		
//		while(digit<8) {
//			Digits test = new Digits(digit);
//		while(i<100) {
//			System.out.println(test.getDigit(digit));
//			i++;
//		}
//		digit++;
//		i=0;
//	}

}
