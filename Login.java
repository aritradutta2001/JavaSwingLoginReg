	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class Login{

   public static void main(String args[]){

	LoginAction ma = new LoginAction();
	ma.setDefaultCloseOperation(0);
		ma.setVisible(true);

			}
		}

	class LoginAction extends JFrame{
		
		public LoginAction(){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Login Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
		setDefaultCloseOperation(0);
	MyPanel panel = new MyPanel(this);
		add(panel);
			}
		}

	class MyPanel extends JPanel implements ActionListener{
		
		JButton loginButton;
		JButton resetButton;
		JButton exitButton;
		JButton regButton;
		
		JLabel l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		
		boolean b;
		LoginAction la;
		
		String user;
		
				
		public MyPanel(LoginAction la){
		
			this.la=la;
		l1 = new JLabel("Enter user_id");
		t1 = new JTextField(20);
		
		l2 = new JLabel("Enter password");
		t2 = new JPasswordField(20);
		
		loginButton = new JButton("Login");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		regButton = new JButton("Click");

		l3 = new JLabel("Not A User?");

			setLayout(null);

			l1.setBounds(10,20,100,20);
			t1.setBounds(120,20,100,20);
			l2.setBounds(10,50,100,20);
			t2.setBounds(120,50,100,20);
			l3.setBounds(120,150,130,20);
		

				add(l1);			
				add(t1);
				add(l2);
				add(t2);
				add(l3);

			loginButton.setBounds(120,100,70,20);
			resetButton.setBounds(200,100,70,20);
			exitButton.setBounds(280,100,60,20);
			regButton.setBounds(200,150,70,20);

			add(loginButton);
			add(resetButton);
			add(exitButton);
			add(regButton);
		
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		regButton.addActionListener(this);
		exitButton.addActionListener(this);
			}

		public void actionPerformed(ActionEvent e){

			//String un1=null;
		Object source = e.getSource();
			MyDb obj = new MyDb();			
			if(source==loginButton){

		 user = t1.getText();
		String pass = t2.getText();
			
			if(user.equals("") || pass.equals("")){
		JOptionPane.showMessageDialog(this,"Field cannot be blank");
			return;
			}
			try{
		 b = obj.checkLogin(user,pass);
			}
			catch(Exception e1){
		JOptionPane.showMessageDialog(this,"Exception "+e1);	
					}
			if(b){
		
	JOptionPane.showMessageDialog(this,"Welcome "+user);
			t1.setText("");
			t2.setText("");
			la.dispose();
		new HomeActionTest(user).setVisible(true);
				}
			else{
	JOptionPane.showMessageDialog(this,"Wrong user_id or password");

				}
		
		}
			if(source==resetButton) {
				
				t1.setText("");
				t2.setText("");
				}
			if(source==exitButton) {
				
			System.exit(0);
				}
			if(source==regButton){
				la.dispose();
			new Registration().setVisible(true);

				}
			}
		
	      }                                                  