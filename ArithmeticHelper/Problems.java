import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problems extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldResult;
	public PrintWriter out;
	private static long runningTime;
	private static long finish;
	private static long start;
	private double[] answer;
	private int increment;/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Problems(String name, int digits, int problems, int operation, int count,long time) {
		setTitle("Quiz");
		increment=count;
		answer= new double[count];
		//start timer
		runningTime=time;
		start = System.currentTimeMillis();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Digits test=new Digits(digits);
		int value1 = test.getVariable();
		int value2 = test.getVariable();
		Operation label = new Operation();
		JLabel lblNum1 = new JLabel("First Number:         "+ value1);
		lblNum1.setBounds(77, 76, 138, 14);
		contentPane.add(lblNum1);
		
		JLabel lblOperation = new JLabel("Operation:               "+label.getName(label.getName(operation)));
		lblOperation.setBounds(77, 101, 138, 14);
		contentPane.add(lblOperation);
		
		JLabel lblNum2 = new JLabel("Second Number:   "+ value2);
		lblNum2.setBounds(77, 126, 154, 14);
		contentPane.add(lblNum2);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(77, 178, 48, 14);
		contentPane.add(lblResult);
		
		
		
		textFieldResult = new JTextField();
		textFieldResult.setBounds(156, 175, 197, 20);
		contentPane.add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JLabel lblPrompt = new JLabel("Press Next to see the next Problem");
		lblPrompt.setBounds(183, 206, 48, 14);
		contentPane.add(lblPrompt);
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checks which operation and performs
				try {
				Operation solved = new Operation();
			//	int increment = count;
			//	double[] answer = new double[count];			
				if(operation == 1)
				answer[increment-1] = solved.add(value1, value2);
				if(operation == 2)
				answer[increment-1] = solved.sub(value1, value2);
				if(operation == 3)
				answer[increment-1] = solved.mul(value1, value2);
				if(operation == 4)
				answer[increment-1] =  solved.div((double)value1,(double)value2);
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Program Failed: " + e2 + "\n Enter an Answer");
				}
				//end timer
				finish = System.currentTimeMillis();
				long timeTotal = finish - start;
				runningTime += timeTotal;
				String s=textFieldResult.getText();
				double userResult;
				userResult=Double.parseDouble(s);
				
				//creates a file for appending to the text file 
				try {
					File file = new File("test.txt");
					FileWriter fr;
					fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					PrintWriter pr = new PrintWriter(br);
					pr.printf("%d\t",value1);
					pr.printf("%d\t", value2);
					pr.printf("%.2f\t", answer[increment-1]);
					pr.printf("%.2f\n",userResult);
					pr.close();
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				increment++;
				setVisible(false);
				
				//checks increment to move on after all problems answered
				if(increment>problems)
				{
					Result result;
					try {
						result = new Result(name, digits, problems, operation,runningTime);
						result.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//setVisible(false);
				}
				//continues with next problem otherwise
				else {
				Problems questions = new Problems(name, digits, problems, operation,increment,runningTime);
				questions.setVisible(true);
				}
				
			}
		});
			
	
		btnNewButton.setBounds(156, 231, 91, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblCount = new JLabel("~~~~ Problem "+increment+" of "+problems+" ~~~~");
		lblCount.setBounds(165, 50, 170, 14);
		contentPane.add(lblCount);
		
		JLabel lblHeader = new JLabel(label.getName(operation)+" Helper");
		lblHeader.setBounds(94, 11, 259, 14);
		contentPane.add(lblHeader);
	}
}
