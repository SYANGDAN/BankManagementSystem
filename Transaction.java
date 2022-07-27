import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Transaction extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, inquary, pinchange, exit;
	String password;
	
	Transaction(String password){
		this.password = password;
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("iconss/atm2.jpg"));
		Image im2 = im.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel image = new JLabel(im3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select your Transactions.");
		text.setBounds(280, 430, 700, 30);
		text.setForeground(Color.black);
		text.setFont(new Font("System", Font.BOLD,14));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(280,470,100,30);
		deposit.setBackground(Color.GREEN);
		deposit.setForeground(Color.black);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(400,470,100,30);
		withdraw.setBackground(Color.GREEN);
		withdraw.setForeground(Color.black);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		inquary = new JButton("Balance");
		inquary.setBounds(280,520,100,30);
		inquary.setBackground(Color.GREEN);
		inquary.setForeground(Color.black);
		inquary.addActionListener(this);
		image.add(inquary);
		
		pinchange = new JButton("Pin change");
		pinchange.setBounds(400,520,100,30);
		pinchange.setBackground(Color.GREEN);
		pinchange.setForeground(Color.black);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		exit = new JButton("Exit");
		exit.setBounds(400,580,100,30);
		exit.setBackground(Color.GREEN);
		exit.setForeground(Color.black);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ex) {
		if(ex.getSource() == exit) {
			System.exit(0);
		}else if(ex.getSource() == deposit) {
			setVisible(false);
			new Deposit(password).setVisible(true);
		}else if(ex.getSource() == withdraw) {
			setVisible(false);
			new Withdraw(password).setVisible(true);
		}else if(ex.getSource() == pinchange) {
			setVisible(false);
			new Pinchange(password).setVisible(true);
		}else if(ex.getSource() == inquary) {
			setVisible(false);
			new Balance(password).setVisible(true);
		}
	}



	public static void main(String[] args) {
		new Transaction(null);

	}

}
