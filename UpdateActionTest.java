	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;


class UpdateActionTest extends JFrame{
		
	public UpdateActionTest(String username){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Update Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
					
		setDefaultCloseOperation(0);
	MyPanel4 panel = new MyPanel4(this,username);
		add(panel);
			}
		}

	class MyPanel4 extends JPanel implements ActionListener{
		
		JButton updateButton;
		
		JButton backButton;
		JButton checkButton;
		
		
		JLabel l1,l2,l3;
		JTextField t1,t2,t3;
		
		
		boolean b;
		UpdateActionTest ua;
		
		String fName,lName,user;
		boolean buttonActive;
		String username;
		public MyPanel4(UpdateActionTest ua,String username){
		
			this.ua=ua;
			this.username=username;
		l1 = new JLabel("Enter user_id");
		t1 = new JTextField(20);
		l2 = new JLabel("Your fName");
		t2 = new JTextField(20);
		l3 = new JLabel("Your lName");
		t3 = new JTextField(20);

		updateButton = new JButton("Update");
		
		backButton = new JButton("Back");
		
		checkButton = new JButton("Check");
		

			setLayout(null);

			l1.setBounds(100,50,100,20);
			t1.setBounds(210,50,100,20);
			
		   	
				add(l1);			
				add(t1);
				add(l2);
				add(t2);
				add(l3);
				add(t3);
				
			checkButton.setBounds(320,50,70,20);
			updateButton.setBounds(150,170,80,20);
			backButton.setBounds(240,170,70,20);
			
			
			add(checkButton);
			add(updateButton);
			add(backButton);
			
			checkButton.addActionListener(this);	
			updateButton.addActionListener(this);
			backButton.addActionListener(this);
		
			}

		public void actionPerformed(ActionEvent e){

			
		Object source = e.getSource();
			MyDb obj = new MyDb();			
			if(source==checkButton){
			
		user = t1.getText();
			
			if(user.equals("")){
		JOptionPane.showMessageDialog(this,"Field cannot be blank");
			
			return;
			}
		
  		
			
				

		if(user.equals(username)){
			try{
	java.util.Vector v = obj.getDetails(user);
			if(v.size()==2){

		fName = (String)v.get(0);
		lName = (String)v.get(1);
		//System.out.println(fName+"  "+lName);	

			l2.setBounds(100,100,100,20);
			t2.setBounds(210,100,100,20);
			l3.setBounds(100,130,100,20);
			t3.setBounds(210,130,100,20);
				
				add(l2);
				add(t2);
				add(l3);
				add(t3);	
			
			t2.setText(fName);
			t3.setText(lName);
			
			buttonActive=true;
			t1.setEditable(false);
		
		/*updateButton.setBounds(150,170,80,20);
		backButton.setBounds(240,170,70,20);
			
			add(updateButton);
			
			add(backButton);
					*/
				}
			}
			catch(Exception e2){
	JOptionPane.showMessageDialog(this,"Exception "+e2);

					}
			}
		else{
	JOptionPane.showMessageDialog(this,"You have entered wrong user_id");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				}

			}

			if(source==updateButton){
				
				if(buttonActive){

			String newFname = t2.getText();
			String newLname = t3.getText();
		if(newFname.equals("") || newLname.equals("")){
	JOptionPane.showMessageDialog(this,"Updated field cannot be blank");
					return;
				}
		/*if(newFname.equals("") && newLname.equals("")){
	JOptionPane.showMessageDialog(this,"Updated information cannot be blank");
					return;
				}*/
		if(newFname.equals(fName) && newLname.equals(lName)){
	JOptionPane.showMessageDialog(this,"Unable to update,you have to change any one of the information");
					return;
					}
			try{
		int i = obj.update(newFname,newLname,user);
				if(i>0){
		JOptionPane.showMessageDialog(this,"Successfully updated...");
				t2.setEditable(false);
				t3.setEditable(false);
	JOptionPane.showMessageDialog(this,"You can see your updated informations by search and display option");
				ua.dispose();
			new HomeActionTest(username).setVisible(true);
					}
				}
			catch(Exception e3){
		JOptionPane.showMessageDialog(this,"exception "+e3); 
					} 
			
				}
				else{

  JOptionPane.showMessageDialog(this,"First click on Check button for the validation of user_id");

				}
				
			}

			
			if(source==backButton) {
				ua.dispose();
			new HomeActionTest(username).setVisible(true);
				}
			}
		
	          }                          