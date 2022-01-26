import java.util.Random;

/*COP3330 Spring 2019. Assignment 3
	 * This code is written by: Hamzah Ullah
	 */
public class Operation extends User{
		private int num1;
		private int num2;
		private Object name2;
		private static int index;
		private double[] result= new double[problems];
		private static int current;
	
		
		Operation()
		{
			super(name,digits,problems,operation);
			this.num1 = num1;
			this.num2 = num2;
			this.name = name;
			

		}

		public int getNum1() {
			return num1;
		}
		public void setNum1(int num1) {
			this.num1 = num1;
		}
		public int getNum2() {
			return num2;
		}
		public void setNum2(int num2) {
			this.num2 = num2;
		}
		public int add(int num1, int num2) {
			return num1+num2;
		}
		public int sub(int num1, int num2) {
			return num1-num2;
		}
		public int mul(int num1, int num2) {
			return num1*num2;
		}
		public double div(double value1, double value2) {
			return value1/value2;
		}
		public void setName(Object object)
		{
			if(object == "Random")
			{
				Random number = new Random();
				index = 0+number.nextInt(4);
				String[] Operation = {"Addition[+]","Subtration[-]","Multiplication[*]","Division[/]"};
				object = Operation[index];
			}
			this.name2 = object;
		}
		public Object getName()
		{
			return name;
		}
		public int getIndex() {
		return index+1;
		}
		public String getName(int index)
		{
			if(index == 1)
				return "Addition";
			if(index == 2)
				return "Subtraction";
			if(index == 3)
				return "Multiplication";
			if(index == 4)
				return "Division";
			return null;
		}
		public String getName(String label)
		{
			if(label == "Addition")
				return "+";
			if(label == "Subtraction")
				return "-";
			if(label == "Multiplication")
				return "*";
			if(label == "Division")
				return "/";
			return null;
		}
		public void setResult(double[] result) {
			this.result = result;
			setResult(result);
		}
		public double getResult(int index) {
			return result[index];
		}
		public static void main(String[] args) {
		}
	}

