import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class ArithmeticHelperMain extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldProblems;
	private JTextField textFieldDigits;
	private String n;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArithmeticHelperMain frame = new ArithmeticHelperMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ArithmeticHelperMain() {
		
		setTitle("Arithmetic Helper");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblName.setForeground(Color.ORANGE);
		lblName.setBounds(40, 97, 80, 14);
		contentPane.add(lblName);
		
		JLabel lblProblems = new JLabel("Problems");
		lblProblems.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblProblems.setForeground(Color.ORANGE);
		lblProblems.setBounds(40, 122, 80, 17);
		contentPane.add(lblProblems);
		
		JLabel lblDigits = new JLabel("Digit(s)");
		lblDigits.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDigits.setForeground(Color.ORANGE);
		lblDigits.setBounds(40, 147, 80, 14);
		contentPane.add(lblDigits);
		
		JLabel lblOperation = new JLabel("Operation");
		lblOperation.setForeground(Color.ORANGE);
		lblOperation.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblOperation.setBounds(40, 172, 80, 17);
		contentPane.add(lblOperation);
		
		textFieldName = new JTextField("Enter Name");
		textFieldName.setBounds(130, 94, 106, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldProblems = new JTextField();
		textFieldProblems.setBounds(130, 119, 106, 20);
		contentPane.add(textFieldProblems);
		textFieldProblems.setColumns(10);
		
		textFieldDigits = new JTextField();
		textFieldDigits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldDigits.setBounds(130, 144, 106, 20);
		contentPane.add(textFieldDigits);
		textFieldDigits.setColumns(10);
		
		JComboBox comboBoxOperation = new JComboBox();
		comboBoxOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checks index and performs operation of pulling values;
				try {
				int index = comboBoxOperation.getSelectedIndex();
				if(index == 1) {
					Operation data = new Operation();
					data.setName(comboBoxOperation.getSelectedItem());
					n = textFieldName.getText();
					String d  = textFieldDigits.getText();
					String p = textFieldProblems.getText();
					int problems;
					int digits;
					digits = sToI(d);
					problems = sToI(p);
					//User P1 = new User(n,digits,problems,comboBoxOperation.getSelectedIndex());
					QuizStart start = new QuizStart(n,digits,problems,comboBoxOperation.getSelectedIndex()); 
					start.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, ""+digits+""+data.getName()+""+problems+""+comboBoxOperation.getSelectedIndex());
				}
				if(index == 2) {
					Operation data = new Operation();
					data.setName(comboBoxOperation.getSelectedItem());
					n = textFieldName.getText();
					String d  = textFieldDigits.getText();
					String p = textFieldProblems.getText();
					int problems;
					int digits;
					digits = sToI(d);
					problems = sToI(p);
					//User P1 = new User(n,digits,problems,comboBoxOperation.getSelectedIndex());
					QuizStart start = new QuizStart(n,digits,problems,comboBoxOperation.getSelectedIndex()); 
					start.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, ""+digits+""+data.getName()+""+problems+""+comboBoxOperation.getSelectedIndex());				
				}
				if(index == 3) {
					Operation data = new Operation();
					data.setName(comboBoxOperation.getSelectedItem());
					n = textFieldName.getText();
					String d  = textFieldDigits.getText();
					String p = textFieldProblems.getText();
					int problems;
					int digits;
					digits = sToI(d);
					problems = sToI(p);
					//User P1 = new User(n,digits,problems,comboBoxOperation.getSelectedIndex());
					QuizStart start = new QuizStart(n,digits,problems,comboBoxOperation.getSelectedIndex()); 
					start.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, ""+digits+""+data.getName()+""+problems+""+comboBoxOperation.getSelectedIndex());	
				}
				if(index == 4) {
					Operation data = new Operation();
					data.setName(comboBoxOperation.getSelectedItem());
					n = textFieldName.getText();
					String d  = textFieldDigits.getText();
					String p = textFieldProblems.getText();
					int problems;
					int digits;
					digits = sToI(d);
					problems = sToI(p);
					//User P1 = new User(n,digits,problems,comboBoxOperation.getSelectedIndex());
					QuizStart start = new QuizStart(n,digits,problems,comboBoxOperation.getSelectedIndex()); 
					start.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, ""+digits+""+data.getName()+""+problems+""+comboBoxOperation.getSelectedIndex());
					
				}
				if(index == 5) {
					Operation data = new Operation();
					data.setName(comboBoxOperation.getSelectedItem());
					n = textFieldName.getText();
					String d  = textFieldDigits.getText();
					String p = textFieldProblems.getText();
					int problems;
					int digits;
					digits = sToI(d);
					problems = sToI(p);
					//User P1 = new User(n,digits,problems,data.getIndex());
					QuizStart start = new QuizStart(n,digits,problems,data.getIndex()); 
					start.setVisible(true);
					setVisible(false);
				
					//JOptionPane.showMessageDialog(null, ""+digits+""+data.getName()+""+problems+""+data.getIndex());
			
				}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Program Failed: " + e3 + "\n ***Enter values for digits and problems***");
				}
				}
			
		});
		comboBoxOperation.setModel(new DefaultComboBoxModel(new String[] {"--Select--","Addition[+]","Subtration[-]","Multiplication[*]","Division[/]","Random"}));
		comboBoxOperation.setBounds(130, 171, 106, 22);
		contentPane.add(comboBoxOperation);
		
		JButton btnDevInfo = new JButton("Developer info");
		btnDevInfo.setBounds(106, 214, 142, 23);
		contentPane.add(btnDevInfo);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(282, 214, 91, 23);
		contentPane.add(btnClose);
		
		JLabel lblTitle = new JLabel("Arithmetic Helper");
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblTitle.setBounds(106, 21, 267, 54);
		contentPane.add(lblTitle);
	}
	public int sToI(String String)
	{
		return Integer.parseInt(String);
	}
}
