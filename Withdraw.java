import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Withdraw extends JFrame implements ActionListener{
	
	JButton withdraw, back;
	JTextField amount;
	String password;
	
	Withdraw(String password){
		
		this.password = password;
		
		setLayout(null);
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("iconss/atm2.jpg"));
		Image im2 = im.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//helps to resize the image.
		ImageIcon im3 = new ImageIcon(im2);//changing image into image icon.
		JLabel image = new JLabel(im3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter The Amount to Withdraw.");
		text.setBackground(Color.GREEN);
		text.setForeground(Color.black);
		text.setFont(new Font("System", Font.BOLD,14));
		text.setBounds(280, 430, 700, 30);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("System", Font.BOLD,14));
		amount.setBounds(280, 470, 200, 30);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(400,580,100,30);
		withdraw.setBackground(Color.GREEN);
		withdraw.setForeground(Color.black);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(280,580,100,30);
		back.setBackground(Color.GREEN);
		back.setForeground(Color.black);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == withdraw) {
			String amountwithdraw = amount.getText();
			Date date = new Date();
			if (amountwithdraw.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw");
			}else {
				try {
					Conn con = new Conn();
					String query = "insert into account values('"+password+"','"+date+"','Withdrawl','"+amountwithdraw+"')";
					con.st.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null,amountwithdraw+ "￥ Withdrawl Sucessfully.");
					setVisible(false);
					new Transaction(password).setVisible(true);
				}catch (Exception ex){
					System.out.println(ex);
				}
				
			}
			
		}else if(e.getSource() == back) {
			setVisible(false);
			new Transaction(password).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Withdraw("");
	}



}
