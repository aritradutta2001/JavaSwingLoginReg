	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;


class DeleteActionTest extends JFrame{
		
		public DeleteActionTest(String username){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Deletion Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
					
		setDefaultCloseOperation(0);
	MyPanel5 panel = new MyPanel5(this,username);
		add(panel);
			}
		}

	class MyPanel5 extends JPanel implements ActionListener{
		
		JButton deleteButton;
		
		JButton backButton;
		
		
		JLabel l1;
		JTextField t1;
		
		
		boolean b;
		DeleteActionTest da;
		String username;		
		int res;
		
		public MyPanel5(DeleteActionTest da,String username){
		
			this.da=da;
			this.username=username;
		l1 = new JLabel("Enter user_id");
		t1 = new JTextField(20);
		deleteButton = new JButton("Delete");
		
		backButton = new JButton("Back");
		

			setLayout(null);

			l1.setBounds(100,50,100,20);
			t1.setBounds(210,50,100,20);
			
		   	
				add(l1);			
				add(t1);
				
				

			deleteButton.setBounds(150,80,80,20);
			
			backButton.setBounds(240,80,70,20);
			

			add(deleteButton);
			
			add(backButton);
			
		
			deleteButton.addActionListener(this);
			backButton.addActionListener(this);
		
			}

		public void actionPerformed(ActionEvent e){

			
		Object source = e.getSource();
			MyDb obj = new MyDb();			
			if(source==deleteButton){
			
		String user = t1.getText();
			
			if(user.equals("")){
		JOptionPane.showMessageDialog(this,"Field cannot be blank");
			
			return;
			}
		
  		
		if(user.equals(username)){
		 res = JOptionPane.showConfirmDialog(this,"Are you sure want to delete?","Alert Box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION){
			try{
       			int i= obj.delete(user);
				if(i>0){
	JOptionPane.showMessageDialog(this,"Successfully deleted...");	
			da.dispose();
			new LoginAction().setVisible(true);

					}	
				}
						
				
			catch(Exception e2){
	JOptionPane.showMessageDialog(this,"Exception "+e2);

					}
			    }
			}
		else{
	JOptionPane.showMessageDialog(this,"You have entered wrong user_id");
				t1.setText("");
				
				}
			
		if(res==JOptionPane.NO_OPTION){
	JOptionPane.showMessageDialog(this,"You Have Selected NO Option");
			t1.setText("");
				return; 
				}
			
				
		}
			if(source==backButton) {
				da.dispose();
			new HomeActionTest(username).setVisible(true);
				}
			}
		
	      }                          