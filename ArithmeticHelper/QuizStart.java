import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class QuizStart extends JFrame {
	int i = 0;
	private JPanel contentPane;
	public PrintWriter out;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public QuizStart(String name, int digits, int problems, int operation) {
		setTitle("Get Ready!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Operation label= new Operation();
		
		JLabel lblHeader = new JLabel("Welcome to "+ label.getName(operation) +" Solver");
		lblHeader.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblHeader.setForeground(Color.RED);
		lblHeader.setBounds(68, 11, 332, 28);
		contentPane.add(lblHeader);
		
		JLabel lblName = new JLabel("Name: " + name);
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblName.setForeground(Color.ORANGE);
		lblName.setBounds(139, 84, 243, 14);
		contentPane.add(lblName);
		
		JLabel lblProblems = new JLabel("Number of Problems: "+ problems);
		lblProblems.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblProblems.setForeground(Color.ORANGE);
		lblProblems.setBounds(139, 127, 243, 14);
		contentPane.add(lblProblems);
		
		JLabel lblDigits = new JLabel("Number of Digits: "+ digits);
		lblDigits.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDigits.setForeground(Color.ORANGE);
		lblDigits.setBounds(139, 164, 243, 22);
		contentPane.add(lblDigits);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				//clears file for data
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
				//creates count for numbers and passes values
					int count=1;
					Problems questions = new Problems(name, digits, problems, operation,count,(System.currentTimeMillis()-System.currentTimeMillis()));
					questions.setVisible(true);
					setVisible(false);
			}	
		});
		
		btnStart.setBounds(175, 209, 91, 23);
		contentPane.add(btnStart);
	}

}
