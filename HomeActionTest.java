
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;


	class HomeActionTest extends JFrame{
		
		public HomeActionTest(String username){
	
  Toolkit kit = Toolkit.getDefaultToolkit();
	
  Dimension screenSize = kit.getScreenSize();
	int w = screenSize.width;
	int h = screenSize.height;
		setTitle("Home Frame");
	   setSize(w/2,h/2);
	   setLocation(w/4,h/4);
	   setResizable(false);
		setDefaultCloseOperation(0);
	MyPanel1 panel = new MyPanel1(this,username);
		add(panel);
			}
		}

	class MyPanel1 extends JPanel{
	JButton serachButton;
	JButton updateButton;
	JButton deleteButton;
	JButton exitButton;
		
		int x;
		Timer t;
		HomeActionTest bc;
		String username;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
	serachButton.setBackground(Color.yellow);
	updateButton.setBackground(Color.green);
	deleteButton.setBackground(Color.pink);
	exitButton.setBackground(Color.magenta);
		
		Graphics2D g1 = (Graphics2D)g;
		g1.setPaint(Color.blue);
	Font f = new Font("Serif",Font.BOLD,15);
			setFont(f);
		g1.drawString("Made by Anirban",x,299);
			
			}
		
		public MyPanel1(HomeActionTest bc,String username){
			this.username=username;
			this.bc=bc;
	serachButton = new JButton("Search And Display");
	updateButton = new JButton("Update");
	deleteButton = new JButton("Delete");
	exitButton = new JButton("Back");
		add(serachButton);
		add(updateButton);
		add(deleteButton);
		add(exitButton);
	
   		
		HomeAction m = new HomeAction();
		t = new Timer(400,m);
			t.start();
		t.addActionListener(m);
		serachButton.addActionListener(m);
		updateButton.addActionListener(m);
		deleteButton.addActionListener(m);
		exitButton.addActionListener(m);

			
	
			}
		
  class HomeAction implements ActionListener{

	  public void actionPerformed(ActionEvent e){
			
		Object source = e.getSource();
			if(source==t){
			
			x+=10;

			if(x>690)
			x=10;
				//repaint();
				
				}

			if(source==serachButton){
				bc.dispose();
				
			new SearchAction(username).setVisible(true);
				
					}
				
			if(source==updateButton){
				bc.dispose();
			new UpdateActionTest(username).setVisible(true);
					}
			if(source==deleteButton){
				bc.dispose();
			new DeleteActionTest(username).setVisible(true);
					}

			if(source==exitButton){

				bc.dispose();
			
			new LoginAction().setVisible(true);
			
				}
			

			}
		}
	}	 	