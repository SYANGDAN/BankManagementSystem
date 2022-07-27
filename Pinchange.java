import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Pinchange extends JFrame implements ActionListener {
	
	JLabel text, pintext,repintext;
	JPasswordField pin, repin;
	JButton change, back;
	String password;
	
	Pinchange(String password){
		setLayout(null);
		
		this.password = password;
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("iconss/atm2.jpg"));
		Image im2 = im.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//helps to resize the image.
		ImageIcon im3 = new ImageIcon(im2);//changing image into image icon.
		JLabel image = new JLabel(im3);
		image.setBounds(0,0,900,900);
		add(image);
		
		text = new JLabel("Change Your Password.");
		text.setBackground(Color.GREEN);
		text.setForeground(Color.black);
		text.setFont(new Font("System", Font.BOLD,14));
		text.setBounds(310, 430, 700, 30);
		image.add(text);
		
		pintext = new JLabel("New Pin");
		pintext.setBackground(Color.GREEN);
		pintext.setForeground(Color.black);
		pintext.setFont(new Font("System", Font.BOLD,14));
		pintext.setBounds(280, 470, 100, 30);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setBounds(400,470,80,30);
		pin.setFont(new Font("Arial", Font.BOLD,20));
		image.add(pin);
		
		repintext = new JLabel("Re-Enter Pin");
		repintext.setBackground(Color.GREEN);
		repintext.setForeground(Color.black);
		repintext.setFont(new Font("System", Font.BOLD,14));
		repintext.setBounds(280, 520, 100, 30);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setBounds(400,520,80,30);
		repin.setFont(new Font("Arial", Font.BOLD,20));
		image.add(repin);
		
		back = new JButton("Back");
		back.setBounds(280,580,80,30);
		back.setBackground(Color.GREEN);
		back.setForeground(Color.black);
		back.addActionListener(this);
		image.add(back);
		
		change = new JButton("Change");
		change.setBounds(400,580,80,30);
		change.setBackground(Color.GREEN);
		change.setForeground(Color.black);
		change.addActionListener(this);
		image.add(change);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == change){
			try{
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "PIN doesn't Matched.");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter New PIN");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
					return;
				}
				
				Conn con = new Conn();
				String query1 = "update account set pin = '"+rpin+"' where pin = '"+password+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin = '"+password+"'";
				String query3 = "update formsubmit set pin = '"+rpin+"' where pin = '"+password+"'";
				con.st.executeUpdate(query1);
				con.st.executeUpdate(query2);
				con.st.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN Changed Sucessfully.");
				
				setVisible(false);
				new Transaction(rpin).setVisible(true);
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
		
		}else {
			setVisible(false);
			//new Transaction()
		}
		
	}

	public static void main(String[] args) {
		new Pinchange("").setVisible(true);
	}

}
