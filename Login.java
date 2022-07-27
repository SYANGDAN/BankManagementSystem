import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	//creating button globally so that i can use it from anywhere.
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField passwordTextField;
	
	Login(){
		setTitle("Online Banking System");
		setLayout(null);
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("iconss/bank.jpg"));
		Image im2 = im.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel label = new JLabel(im3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward", Font.BOLD, 40));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Railway", Font.BOLD, 20));
		cardno.setBounds(120,150,180,40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(240,150,250,30);
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(cardTextField);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Railway", Font.BOLD, 20));
		password.setBounds(120,220,180,40);
		add(password);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(240,220,250,30);
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(passwordTextField);
		
		login = new JButton("LOGIN");
		login.setBounds(250,300,100,30);
		login.setBackground(Color.GREEN);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(380,300,100,30);
		clear.setBackground(Color.GREEN);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(250,350,230,30);
		signup.setBackground(Color.GREEN);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.cyan);
		
		setSize(800,480);//Size of the Window.
		setVisible(true);
		setLocation(350,200);//set the location from where the window pop-up.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// methods should be override in java while using any interface.
		if(e.getSource() == login) {
			Conn con = new Conn();
			String cardnumber = cardTextField.getText();
			String password = passwordTextField.getText();
			String query = "select * from login where cardnumber ='"+cardnumber+"'and pin='"+password+"'"; 
			
			try {
				ResultSet rs = con.st.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transaction(password).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
				
			}catch (Exception ex){
				System.out.println(ex);
			}
			
		} else if(e.getSource() == clear) {
			cardTextField.setText("");
			passwordTextField.setText("");
			
		}else if(e.getSource() == signup){
			setVisible(false);
			new SignUp().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Login();

	}

}
