	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;



class Registration extends JFrame{
		
		public Registration(){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Registration Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
	   setDefaultCloseOperation(0);
	MyPanel2 panel = new MyPanel2(this);
		add(panel);
			}
		}

	class MyPanel2 extends JPanel implements ActionListener{
		
		JLabel l1,l2,l3,l4;
		JTextField t1,t3,t4;
		JPasswordField t2;
		
		JButton submitButton;
		JButton resetButton;
		JButton backButton;
		
		Registration rn;
		
		public MyPanel2(Registration rn){
			this.rn=rn;
		
		l1 = new JLabel("Enter user_id");
		t1 = new JTextField(20);
		l2 = new JLabel("Enter password");
		t2 = new JPasswordField(20);
		l3 = new JLabel("Enter fname");
		t3 = new JTextField(20);
		l4 = new JLabel("Enter lname");
		t4 = new JTextField(20);

		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		backButton = new JButton("Back");

			setLayout(null);

			l1.setBounds(10,20,100,20);
			t1.setBounds(120,20,100,20);
			l2.setBounds(10,50,100,20);
			t2.setBounds(120,50,100,20);
			l3.setBounds(10,80,100,20);
			t3.setBounds(120,80,100,20);
			l4.setBounds(10,110,100,20);
			t4.setBounds(120,110,100,20);
			
			submitButton.setBounds(120,150,80,20);
			resetButton.setBounds(210,150,70,20);
			backButton.setBounds(290,150,70,20);
					
				add(l1);
				add(t1);
				add(l2);
				add(t2);
				add(l3);
				add(t3);
				add(l4);
				add(t4);

				add(submitButton);
				add(resetButton);
				add(backButton);
		
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);

				}
		public void actionPerformed(ActionEvent e){

			MyDb obj=new MyDb();
		Object source = e.getSource();
		boolean b1=false,b2=false;
	
			if(source == submitButton){
		String u = t1.getText();
		String p = t2.getText();
		String f = t3.getText();
		String l = t4.getText();

	if(u.equals("") || p.equals("") || f.equals("") || l.equals("")){
		
		JOptionPane.showMessageDialog(this,"Field cannot be blank");
				return;
				}

			if(p.length()<6){
	JOptionPane.showMessageDialog(this,"Password minimum six character");
				t2.setText("");
				return;
				}

		for(int i=0;i<p.length();i++){

             	char ch = p.charAt(i);
		if(Character.isUpperCase(ch)){
			
			b1=true;
			}

			else if(Character.isDigit(ch)){
			
				b2 = true;

				}
			
			}

		
	
			if(b1 && b2){
			//try{
			int i = obj.insertData(u,p,f,l);
			if(i>0){
	JOptionPane.showMessageDialog(this,"Succefully inserted....");
			rn.dispose();
		new LoginAction().setVisible(true);
				}
			//}
			//catch(Exception ee){
	//JOptionPane.showMessageDialog(this,"Exception "+ee);			
				//}
			}
		else{
JOptionPane.showMessageDialog(this,"In case of password,atleat one character must be capital and one chaaracter must be number");
			t2.setText("");
				}

			}
			if(source == resetButton){

			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");

				}
			if(source == backButton){
			rn.dispose();
		new LoginAction().setVisible(true);


				}


			}
		}
