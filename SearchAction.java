	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;


class SearchAction extends JFrame{
		
		public SearchAction(String username){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Search Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
					
		setDefaultCloseOperation(0);
	MyPanel3 panel = new MyPanel3(this,username);
		add(panel);
			}
		}

	class MyPanel3 extends JPanel implements ActionListener{
		
		JButton searchButton;
		
		JButton backButton;
		
		
		JLabel l1,l2,l3;
		JTextField t1,t2,t3;
		
		
		boolean b,b1;
		SearchAction sa;
		String username;
		String fName,lName;
		String userid2;
		public MyPanel3(SearchAction sa,String username){
			
			this.username=username;
			this.sa=sa;
		l1 = new JLabel("Enter user_id");
		t1 = new JTextField(20);
		l2 = new JLabel("Your fName");
		t2 = new JTextField(20);
		l3 = new JLabel("Your lName");
		t3 = new JTextField(20);
		searchButton = new JButton("search");
		
		backButton = new JButton("Back");
		

			setLayout(null);

			l1.setBounds(100,50,100,20);
			t1.setBounds(210,50,100,20);
			
		   	
				add(l1);			
				add(t1);
				add(l2);
				add(t2);
				add(l3);
				add(t3);
				
				

			searchButton.setBounds(150,170,80,20);
			
			backButton.setBounds(240,170,70,20);
			

			add(searchButton);
			
			add(backButton);
			
		
			searchButton.addActionListener(this);
			backButton.addActionListener(this);
		
			}

		public void actionPerformed(ActionEvent e){

			
		Object source = e.getSource();
			MyDb obj = new MyDb();			
			if(source==searchButton){
			
		String user = t1.getText();
			
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
			t1.setEditable(false);
			t2.setEditable(false);
			t3.setEditable(false);
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
			if(source==backButton) {
				sa.dispose();
			new HomeActionTest(username).setVisible(true);
				}
			}
		
	      }                          