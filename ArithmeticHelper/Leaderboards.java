import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leaderboards extends JFrame {

	private JPanel contentPane;
	private String[] data;
	private String[] allScores;
	private String[] allNames;
	private Double[] allScoresD;
	private int i=0;

	/**
	 * Create the frame.
	 * @param score 
	 * @param name 
	 */
	public Leaderboards(String name, double score) {
		allScores = new String[11];
		allScoresD = new Double[11];
		allNames = new String[11];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//creates a file for appending to the text file 
//		File file = new File("Leaderboard.txt");
//		Scanner sc = new Scanner(new FileInputStream(file));
//		while(sc.hasNext())
//		{
//			String str = sc.nextLine();
//			
//			data = str.split("\t");
//			if()
//		}
//		sc.close();
		try {
			File file = new File("Leaderboard.txt");
			Scanner sc = new Scanner(new FileInputStream(file));
			while(sc.hasNext() && i<11)
			{
				String str = sc.nextLine();
				
				data = str.split("\t");
				allNames[i] = data[0];		
				allScores[i] = data[1];
				i++;
			}
				String tempScore;
				String replacedScore = Double.toString(score);
				String tempName;
				String replacedName=name;
			
			for(i=0;i<11;i++) {
				if(replacedScore.compareTo(allScores[i])>=0)
				{
					tempScore=allScores[i];
					tempName=allNames[i];
					allScores[i] = replacedScore;
					allNames[i] = replacedName;
					replacedScore=tempScore;
					replacedName=tempName;
				}
			}
			try {
				//clear list
				FileWriter fw;
				//clears file after main menu
				fw = new FileWriter("Leaderboard.txt", false);
				PrintWriter pw = new PrintWriter(fw, false);
		        pw.flush();
		        pw.close();
		        fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 			 
			FileWriter fr;
				fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br);
			for(i=0;i<11;i++)
			{
			pr.printf("%s\t",allNames[i]);
			pr.printf("%s\n", allScores[i]);
			}
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(i=0;i<11;i++)
		{
			System.out.print(allScores[i]+" ");
			System.out.println(allNames[i]);
		}
//		File file = new File("Leaderboard.txt");
//		Scanner sc = new Scanner(new FileInputStream(file));
//		while(sc.hasNext())
//		{
//			String str = sc.nextLine();
//			
//			data = str.split("\t");
//		}
//		sc.close();
		JLabel lblHeader = new JLabel("Rank List of Arithmetic Helper");
		lblHeader.setBounds(94, 11, 187, 14);
		contentPane.add(lblHeader);
		
		JLabel lbl1 = new JLabel("1."+allNames[0]+"\t"+allScores[0]);
		lbl1.setBounds(54, 44, 227, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("2."+allNames[1]+"\t"+allScores[1]);
		lbl2.setBounds(54, 69, 227, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("3."+allNames[2]+"     "+allScores[2]);
		lbl3.setBounds(54, 94, 249, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("4."+allNames[3]+"     "+allScores[3]);
		lbl4.setBounds(54, 119, 249, 14);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("5."+allNames[4]+"     "+allScores[4]);
		lbl5.setBounds(54, 144, 227, 14);
		contentPane.add(lbl5);
		
		JLabel lbl6 = new JLabel("6."+allNames[5]+"     "+allScores[5]);
		lbl6.setBounds(54, 169, 227, 14);
		contentPane.add(lbl6);
		
		JLabel lbl7 = new JLabel("7."+allNames[6]+"     "+allScores[6]);
		lbl7.setBounds(54, 194, 227, 14);
		contentPane.add(lbl7);
		
		JLabel lbl8 = new JLabel("8."+allNames[7]+"     "+allScores[7]);
		lbl8.setBounds(54, 219, 227, 14);
		contentPane.add(lbl8);
		
		JLabel lbl9 = new JLabel("9."+allNames[8]+"     "+allScores[8]);
		lbl9.setBounds(54, 244, 227, 14);
		contentPane.add(lbl9);
		
		JLabel lbl10 = new JLabel("10."+allNames[9]+"     "+allScores[9]);
		lbl10.setBounds(54, 269, 227, 14);
		contentPane.add(lbl10);
		
		JButton btnMain = new JButton("Main Menu");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArithmeticHelperMain main = new ArithmeticHelperMain();
				setVisible(false);
				main.setVisible(true);
			}
		});
		btnMain.setBounds(83, 313, 91, 23);
		contentPane.add(btnMain);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(212, 313, 91, 23);
		contentPane.add(btnExit);
	}
}

