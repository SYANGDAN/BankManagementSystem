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

@SuppressWarnings("serial")
public class Balance extends JFrame implements ActionListener {
	String password;
	JLabel text, balancetext;
	JButton back;
	
	Balance(String password){
		
		setLayout(null);
		
		this.password = password;
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("iconss/atm2.jpg"));
		Image im2 = im.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//helps to resize the image.
		ImageIcon im3 = new ImageIcon(im2);//changing image into image icon.
		JLabel image = new JLabel(im3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(280,580,80,30);
		back.setBackground(Color.GREEN);
		back.setForeground(Color.black);
		back.addActionListener(this);
		image.add(back);
		
		Conn con = new Conn();
		int balance = 0;
		try {
			String query = "select * from account where pin = '"+password+"'";
			ResultSet rs = con.st.executeQuery(query);
			
			while(rs.next()) {
				if(rs.getString("type").equals("deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		text = new JLabel("Balance: ￥ " + balance);
		text.setBackground(Color.GREEN);
		text.setForeground(Color.black);
		text.setFont(new Font("System", Font.BOLD,14));
		text.setBounds(300, 480, 700, 30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(password).setVisible(true); 
	}
	
	public static void main (String[] args) {
		new  Balance("");
	}

}
