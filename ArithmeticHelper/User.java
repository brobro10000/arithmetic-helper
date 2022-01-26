import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class User {
	protected static String name;
	private double score;
	protected static int digits;
	protected static int operation;
	protected static int problems;
	protected int variables;
	protected double[] result;
	
	//insert time;
	
	User(String name, int digits, int problems, int operation)
	{
		this.name = name;
		this.digits = digits;
		this.problems = problems;
		this.operation = operation;
		int operators = problems*2;
	}
	public Object getName()
	{
		return name;
	}
	public int getDigits()
	{
		return digits;
	}
	public int getProblems()
	{
		return problems;
	}
	public int getOperation()
	{
		return operation;
	}
	public void setVariables(int[] variables)
	{
		
	}
	public int getVariables(){
		return variables;
	}
}
