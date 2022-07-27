import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class FormSubmit extends JFrame implements ActionListener {
	
	JRadioButton type1, type2, type3, type4;
	JCheckBox service1, service2, service3, service4, service5;
	JButton submit, cancel;
	String formno;
	
	FormSubmit(String formno){
		
		this.formno = formno;
		//setting Default layout null to use manual layout
		setLayout(null); 
		
		JLabel additionalDetails = new JLabel("Page 3: Account Details");
		additionalDetails.setFont(new Font("Arial", Font.BOLD, 20));
		additionalDetails.setBounds(290, 80, 300, 30);//(left,top,right,down)
		add(additionalDetails);
		
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Arial", Font.BOLD, 18));
		type.setBounds(100, 140, 200, 30);//(left,top,right,down)
		add(type);
		
		type1 = new JRadioButton("Saving Account");
		type1.setBounds(100, 180, 150, 20);
		type1.setBackground(Color.cyan);
		add(type1);
		
		type2 = new JRadioButton("Current Account");
		type2.setBounds(300, 180, 200, 20);
		type2.setBackground(Color.cyan);
		add(type2);
		
		type3 = new JRadioButton("Deposit Account");
		type3.setBounds(100, 220, 200, 20);
		type3.setBackground(Color.cyan);
		add(type3);
		
		type4 = new JRadioButton("Fixed Account");
		type4.setBounds(300, 220, 200, 20);
		type4.setBackground(Color.cyan);
		add(type4);
		
		 ButtonGroup groupbutton = new ButtonGroup();
		groupbutton.add(type1);
		groupbutton.add(type2);
		groupbutton.add(type3);
		groupbutton.add(type4);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Arial", Font.BOLD, 18));
		card.setBounds(100, 300, 200, 30);//(left,top,right,down)
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
		number.setFont(new Font("Arial", Font.BOLD, 18));
		number.setBounds(250, 300, 320, 30);//(left,top,right,down)
		add(number);
		
		JLabel pin = new JLabel("Password:");
		pin.setFont(new Font("Arial", Font.BOLD, 18));
		pin.setBounds(100, 350, 320, 30);//(left,top,right,down)
		add(pin);
		
		JLabel pnumber = new JLabel("****");
		pnumber.setFont(new Font("Arial", Font.BOLD, 18));
		pnumber.setBounds(250, 350, 320, 30);//(left,top,right,down)
		add(pnumber);
		
		JLabel services = new JLabel("Select Services Required");
		services.setFont(new Font("Arial", Font.BOLD, 18));
		services.setBounds(100, 400, 300, 30);//(left,top,right,down)
		add(services);
		
		service1 = new JCheckBox("ATM Card");
		service1.setBackground(Color.cyan);
		service1.setFont(new Font("Arial", Font.BOLD, 16));
		service1.setBounds(100,430,200,30);
		add(service1);
		
		service2 = new JCheckBox("Debit Card");
		service2.setBackground(Color.cyan);
		service2.setFont(new Font("Arial", Font.BOLD, 16));
		service2.setBounds(100,470,200,30);
		add(service2);
		
		service3 = new JCheckBox("Mobile Banking");
		service3.setBackground(Color.cyan);
		service3.setFont(new Font("Arial", Font.BOLD, 16));
		service3.setBounds(100,510,200,30);
		add(service3);
		
		service4 = new JCheckBox("Cheque Book");
		service4.setBackground(Color.cyan);
		service4.setFont(new Font("Arial", Font.BOLD, 16));
		service4.setBounds(100,550,200,30);
		add(service4);
		
		service5 = new JCheckBox("I here by declare that above information are correct.");
		service5.setBackground(Color.cyan);
		service5.setFont(new Font("Arial", Font.BOLD, 12));
		service5.setBounds(250,650,400,30);
		add(service5);
		
		
		submit = new JButton("Submit");
		submit.setBounds(250,700,80,30);
		submit.setBackground(Color.GREEN);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(420,700,80,30);
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.cyan);
		
		setSize(850, 800);
		setLocation(350,10);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit) {
			String accounttype = null;
			if(type1.isSelected()) {
				accounttype = "Saving Account";
			}else if(type2.isSelected()) {
				accounttype = "Current Account";
			}else if (type3.isSelected()) {
				accounttype = "Fixed Account";
			}else if(type4.isSelected()){
				accounttype = "Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 1234567800000000L);
			
			String pinnumber = "" + Math.abs(random.nextLong() %9000L + 1000);
			
			String facility = "";
			if(service1.isSelected()) {
				facility = facility + " ATM Card"; 
			}else if(service2.isSelected()) {
				facility = facility + " Debit Card"; 
			}else if(service3.isSelected()) {
				facility = facility + " Mobile Banking"; 
			}else if(service4.isSelected()) {
				facility = facility + " Cheque Book"; 
			}
			
			try {
				if(accounttype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required.");
				}else {
					Conn con = new Conn();
					String query1 = "insert into formsubmit values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					con.st.executeUpdate(query1);
					con.st.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Password: " + pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
					
				}
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}else if(e.getSource() == cancel){
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new FormSubmit("");
	}
}


