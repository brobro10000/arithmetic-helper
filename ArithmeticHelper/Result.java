import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private JPanel contentPane;
	private int correct=0;
	private double score;
	private String[] data;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @param time 
	 * @param operation 
	 * @param problems 
	 * @param digits 
	 * @param name 
	 * @throws Exception 
	 */
	public Result(String name, int digits, int problems, int operation, long time) throws Exception {
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create a file for input data
		File file = new File("test.txt");
		Scanner sc = new Scanner(new FileInputStream(file));
		while(sc.hasNext())
		{
			String str = sc.nextLine();
			
			data = str.split("\t");
			if(data[2].contentEquals(data[3]))
				correct++;
		}
		sc.close();
		
		//time formulas
		double timeFormat = time/1000.0;
		double timeAverage = timeFormat/problems;
		int timeSeconds = 0;
		timeSeconds = (int) (timeFormat % 60); 
		int timeMinutes = 0;
		timeMinutes = (int)(timeFormat/60);
		int timeHours = 0;
		timeHours = (int)(timeFormat/3600);
		
		JLabel lblHeader = new JLabel("***Arithmetic Helper Result***");
		lblHeader.setBounds(139, 11, 193, 14);
		contentPane.add(lblHeader);
		
		JLabel lblName = new JLabel("Player Name: "+ name);
		lblName.setBounds(41, 36, 235, 14);
		contentPane.add(lblName);
		
		JLabel lblNumberCorrect = new JLabel("Number of Problems were: "+problems);
		lblNumberCorrect.setBounds(41, 61, 235, 14);
		contentPane.add(lblNumberCorrect);
		
		//format for time average
		JLabel lblTotalTime = new JLabel("Hours: "+timeHours+" Minutes: "+timeMinutes+" Seconds: "+ timeSeconds);
		lblTotalTime.setBounds(41, 106, 387, 14);
		contentPane.add(lblTotalTime);
		NumberFormat doubleNum = new DecimalFormat("#0.000");
		JLabel lblAverageTime = new JLabel("Average Time: "+doubleNum.format(timeAverage)+" seconds");
		lblAverageTime.setBounds(41, 131, 291, 14);
		contentPane.add(lblAverageTime);
		
		//format for percent
		NumberFormat doubleNum2 = new DecimalFormat("#0.00");
		double percent = (double)correct/(double)problems;
		percent = percent*100;
		JLabel lblCorrectPercent = new JLabel("Correct Percent: "+doubleNum2.format(percent)+"%");
		lblCorrectPercent.setBounds(41, 156, 198, 14);
		contentPane.add(lblCorrectPercent);
		score = score(timeAverage,operation,problems,digits,correct);
		JLabel lblScore = new JLabel("Score: "+doubleNum2.format(score(timeAverage,operation,problems,digits,correct)));
		lblScore.setBounds(41, 181, 198, 14);
		contentPane.add(lblScore);
		
		JLabel lblCorrectTotal = new JLabel("Total Correct: "+correct);
		lblCorrectTotal.setBounds(41, 81, 198, 14);
		contentPane.add(lblCorrectTotal);	
		//exits program
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFinish.setBounds(72, 231, 91, 23);
		contentPane.add(btnFinish);
		
		//moves to history
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				History start = new History(name,digits,problems,operation, score);
				start.setVisible(true);
				setVisible(false);
			}
		});
		btnHistory.setBounds(215, 231, 91, 23);
		contentPane.add(btnHistory);
	}
	//method for score
	public double score(double timeAverage,int operation,int problems,int digits,int correct)
	{
		int operationMultiplier;
		double timeMultiplier;
		if((operation == 1) || (operation == 2))
				{
					operationMultiplier =2;
				} else {
					operationMultiplier =10;
				}
	
			if(timeAverage <= 10)
				timeMultiplier = 100;
			else if(timeAverage <= 20)
				timeMultiplier = 50;
			else if(timeAverage<=30)
				timeMultiplier = 25;
			else if(timeAverage<=40)
				timeMultiplier = 12.5;
			else if(timeAverage<=50)
				timeMultiplier = 6.25;
			else if(timeAverage<=60)
				timeMultiplier = 3.125;
			else
				timeMultiplier = 1;
		double score = timeMultiplier*operationMultiplier*problems*digits;
		if(correct == problems)
			score*=2;//if perfect*2
		return score;
	}
}
