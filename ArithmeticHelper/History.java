import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {
	String[] questions;
	String[] results;
	String[] answers;
	int index=0;
	
	int i =0;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public History(String name, int digits, int problems, int operation, double score) {
	questions = new String[problems];
	results = new String[problems];
	answers = new String[problems];
		setTitle("History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//place data in variable for drop down
		File file = new File("test.txt");
		Scanner sc;
		try {
			sc = new Scanner(new FileInputStream(file));
			while(sc.hasNext())
		{
			String str = sc.nextLine();
			String[] data = str.split("\t");
			if(operation == 1)
			{
					questions[i] = data[0];
					questions[i] = questions[i].concat("+");
					questions[i] = questions[i].concat(data[1]);	
			}
			if(operation == 2)
			{
					questions[i] = data[0];
					questions[i] = questions[i].concat("-");
					questions[i] = questions[i].concat(data[1]);	
			}
			if(operation == 3)
			{
					questions[i] = data[0];
					questions[i] = questions[i].concat("*");
					questions[i] = questions[i].concat(data[1]);	
			}
			if(operation == 4)
			{
					questions[i] = data[0];
					questions[i] = questions[i].concat("/");
					questions[i] = questions[i].concat(data[1]);	
			}
			results[i] = data[2];
			answers[i] = data[3];
			i++;
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//returns to menu
				ArithmeticHelperMain menu = new ArithmeticHelperMain();
				setVisible(false);
				menu.setVisible(true);
				//clears data file for new input
				try {
					FileWriter fw;
					//clears file after main menu
					fw = new FileWriter("test.txt", false);
					PrintWriter pw = new PrintWriter(fw, false);
			        pw.flush();
			        pw.close();
			        fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 			        
			}
		});
		btnNewButton.setBounds(403, 7, 117, 23);
		contentPane.add(btnNewButton);
		
		//goes to leaderboard
		JButton btnNewButton_1 = new JButton("Leaderboards");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Leaderboards menu = new Leaderboards(name,score);
				setVisible(false);
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(405, 41, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(35, 11, 48, 14);
		contentPane.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(170, 11, 48, 14);
		contentPane.add(lblAnswer);
		
		JLabel lblYourAnswer = new JLabel("Your Answer");
		lblYourAnswer.setBounds(282, 11, 80, 14);
		contentPane.add(lblYourAnswer);
		
		JLabel lblYourAnswerD = new JLabel("");
		lblYourAnswerD.setBounds(271, 50, 91, 14);
		contentPane.add(lblYourAnswerD);
		
		JLabel lblAnswerD = new JLabel("");
		lblAnswerD.setBounds(170, 50, 91, 14);
		contentPane.add(lblAnswerD);
		
		JLabel lblQuestionD = new JLabel("Select a Question");
		lblQuestionD.setBounds(35, 50, 99, 14);
		contentPane.add(lblQuestionD);
				
		JComboBox comboBoxQuestions = new JComboBox();
		comboBoxQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = comboBoxQuestions.getSelectedIndex();
				for(i=0;i<problems;i++)
				if(index==i)
				{
					lblAnswerD.setText(results[index]);
					lblYourAnswerD.setText(answers[index]);
					lblQuestionD.setText(questions[index]);
				}
			}
		});
		comboBoxQuestions.setModel(new DefaultComboBoxModel(questions));
		comboBoxQuestions.setBounds(21, 75, 159, 22);
		contentPane.add(comboBoxQuestions);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clears data file for new input
				try {
					FileWriter fw;
					//clears file after main menu
					fw = new FileWriter("test.txt", false);
					PrintWriter pw = new PrintWriter(fw, false);
			        pw.flush();
			        pw.close();
			        fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
				System.exit(0);
			}
		});
		btnExit.setBounds(403, 75, 117, 23);
		contentPane.add(btnExit);
	}
}
