import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignUpNext extends JFrame implements ActionListener {
	
	JTextField workTextField;
	JButton next;
	JComboBox<?> income1,purpose1;
	String formno;
	SignUpNext(String formno){
		this.formno = formno;
		//setting Default layout null to use manual layout
		setLayout(null); 
		
		JLabel additionalDetails = new JLabel("Page2: Additional Details");
		additionalDetails.setFont(new Font("Arial", Font.BOLD, 20));
		additionalDetails.setBounds(290, 80, 300, 30);//(left,top,right,down)
		add(additionalDetails);
		
		JLabel income = new JLabel("Income/Year:");
		income.setFont(new Font("Arial", Font.BOLD, 18));
		income.setBounds(100, 140, 200, 30);//(left,top,right,down)
		add(income);
		
		String valincome[]= {"0-180k","180K～240K", "240k～280K","280K～320K","320～380K","380K～460K","460～"};
		income1 = new JComboBox<Object>(valincome);
		income1.setBounds(280, 140, 300, 30);
		income1.setBackground(Color.white);
		add(income1);
		
		JLabel purpose = new JLabel("Purpose:");
		purpose.setFont(new Font("Arial", Font.BOLD, 18));
		purpose.setBounds(100, 190, 200, 30);//(left,top,right,down)
		add(purpose);
		
		String valpurpose[]= {"Null","Salary", "Business","Other"};
		purpose1 = new JComboBox<Object>(valpurpose);
		purpose1.setBounds(280, 190, 300, 30);
		purpose1.setBackground(Color.white);
		add(purpose1);
		
		JLabel cname = new JLabel("Work Place:");
		cname.setFont(new Font("Arial", Font.BOLD, 18));
		cname.setBounds(100, 240, 200, 30);//(left,top,right,down)
		add(cname);
		
		workTextField = new JTextField();
		workTextField.setFont(new Font("Arial", Font.BOLD,16));
		workTextField.setBounds(280, 240, 300, 30);
		add(workTextField);
		
		next = new JButton("Next");
		next.setBounds(620,660,80,30);
		next.setBackground(Color.GREEN);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.cyan);
		
		setSize(850, 800);
		setLocation(350,10);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String income = (String) income1.getSelectedItem();
		String purpose = (String) purpose1.getSelectedItem();
		String work = workTextField.getText();
		
		try {
			if(income.equals("")||work.equals("") || purpose.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill all segments");
			}else {
				Conn con = new Conn();
				String query = "insert into signupnext values('"+formno+"','"+income+"','"+purpose+"','"+work+"')";
				con.st.executeUpdate(query);
				
				setVisible(false);
				new FormSubmit(formno).setVisible(true);
				
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	public static void main(String[] args) {
		new SignUpNext(null);
	}


}

