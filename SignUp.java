import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class SignUp extends JFrame implements ActionListener {
	
	int Random;
	JTextField fnameTextField, lnameTextField, dobTextField, genderTextField,
	maritalStatTextField, mobileNoTextField, emailTextField, postTextField, 
	addressTextField;
	JButton next;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser date ;
	
	
	SignUp(){
		//set Default layout null to use manual layout
		setLayout(null); 
		
		Random rand = new Random();
		Random=Math.abs(rand.nextInt());
		
		JLabel formno = new JLabel("APPLICATION NO."+Random);
		formno.setFont(new Font("Arial", Font.BOLD, 40));
		formno.setBounds(140, 20, 600, 40);//(left,top,right,down)
		add(formno);
		
		JLabel personDetails = new JLabel("Page1: Personal Details");
		personDetails.setFont(new Font("Arial", Font.BOLD, 20));
		personDetails.setBounds(290, 80, 300, 30);//(left,top,right,down)
		add(personDetails);
		
		JLabel fname = new JLabel("First_Name:");
		fname.setFont(new Font("Arial", Font.BOLD, 18));
		fname.setBounds(100, 140, 200, 30);//(left,top,right,down)
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Arial", Font.BOLD,16));
		fnameTextField.setBounds(280, 140, 300, 30);
		add(fnameTextField);
		
		JLabel lname = new JLabel("Last_Name:");
		lname.setFont(new Font("Arial", Font.BOLD, 18));
		lname.setBounds(100, 190, 200, 30);//(left,top,right,down)
		add(lname);
		
		lnameTextField = new JTextField();
		lnameTextField.setFont(new Font("Arial", Font.BOLD,16));
		lnameTextField.setBounds(280, 190, 300, 30);
		add(lnameTextField);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Arial", Font.BOLD, 18));
		dob.setBounds(100, 240, 200, 30);//(left,top,right,down)
		add(dob);
		
		date = new JDateChooser();
		date.setBounds(280,240,200,30);
		add(date);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Arial", Font.BOLD, 18));
		gender.setBounds(100, 290, 200, 30);//(from left, from top,length/right,height/down)
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(280, 290, 60, 30);
		male.setBackground(Color.cyan);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(350, 290, 100, 30);
		female.setBackground(Color.cyan);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		genderTextField = new JTextField();
		genderTextField.setFont(new Font("Arial", Font.BOLD,16));
		genderTextField.setBounds(280, 140, 300, 30);
		add(genderTextField);
		
		JLabel maritalStat = new JLabel("Marital Staus:");
		maritalStat.setFont(new Font("Arial", Font.BOLD, 18));
		maritalStat.setBounds(100, 340, 200, 30);//(left,top,right,down)
		add(maritalStat);
		
		married = new JRadioButton("Married");
		married.setBounds(280, 340, 100, 30);
		married.setBackground(Color.cyan);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(390, 340, 100, 30);
		unmarried.setBackground(Color.cyan);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(500, 340, 100, 30);
		other.setBackground(Color.cyan);
		add(other);
		
		ButtonGroup maritalstatgroup = new ButtonGroup();
		maritalstatgroup.add(married);
		maritalstatgroup.add(unmarried);
		maritalstatgroup.add(other);
		
		JLabel mobileNo = new JLabel("Mobile Number:");
		mobileNo.setFont(new Font("Arial", Font.BOLD, 18));
		mobileNo.setBounds(100, 390, 200, 30);//(left,top,right,down)
		add(mobileNo);
		
		mobileNoTextField = new JTextField();
		mobileNoTextField.setFont(new Font("Arial", Font.BOLD,16));
		mobileNoTextField.setBounds(280, 390, 300, 30);
		add(mobileNoTextField);
		
		JLabel email = new JLabel("Email-Address:");
		email.setFont(new Font("Arial", Font.BOLD, 18));
		email.setBounds(100, 440, 200, 30);//(left,top,right,down)
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Arial", Font.BOLD,16));
		emailTextField.setBounds(280, 440, 300, 30);
		add(emailTextField);
		
		JLabel post = new JLabel("Postal code:");
		post.setFont(new Font("Arial", Font.BOLD, 18));
		post.setBounds(100, 490, 200, 30);//(left,top,right,down)
		add(post);
		
		postTextField = new JTextField();
		postTextField.setFont(new Font("Arial", Font.BOLD,16));
		postTextField.setBounds(280, 490, 300, 30);
		add(postTextField);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Arial", Font.BOLD, 18));
		address.setBounds(100, 540, 200, 30);//(left,top,right,down)
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Arial", Font.BOLD,16));
		addressTextField.setBounds(280, 540, 300, 30);
		add(addressTextField);
		
		next = new JButton("Next");
		next.setBounds(620,660,80,30);
		next.setBackground(Color.GREEN);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		//next.addActionListener();
		add(next);
		
		getContentPane().setBackground(Color.cyan);
		
		setSize(850, 800);
		setLocation(350,10);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formno = ""+ Random;
		String fname = fnameTextField.getText();
		String lname = lnameTextField.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String email = emailTextField.getText();
		String mobileNo = mobileNoTextField.getText();
		String gender = null;
		
		if (male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		
		String maritalStat =null;
		
		if (married.isSelected()) {
			maritalStat = "Married";
		}else if(unmarried.isSelected()) {
			maritalStat = "Unmarried";
		}else if(other.isSelected()) {
			maritalStat = "Other";
		}
				
		String address = addressTextField.getText();
		String post = postTextField.getText();
		
		try {
			if(fname.equals("")||lname.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill all segments");
			}else {
				Conn con = new Conn();
				String query = "insert into signup values('"+formno+"','"+dob+"','"+fname+"','"+lname+"','"+gender+"','"+maritalStat+"','"+mobileNo+"','"+email+"','"+post+"','"+address+"')";
				con.st.executeUpdate(query);
				
				setVisible(false);
				new SignUpNext(formno).setVisible(true);
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	public static void main(String[] args) {
		new SignUp();
	}
}
