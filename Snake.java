import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Snake extends KeyAdapter
{
	JLabel label1,label2,label3,label4,label5,label6,l;
	Timer t;
	JFrame f;
	JPanel p ;
	boolean left = true;
	boolean right = true;
	boolean up = true;
	boolean down =true;
	int a,b,c=0;
	int position[][]={
	{200,200},
	{225,200},
	{250,200},
	{275,200},
	{300,200}
	};
	Snake()
	{
		f = new JFrame();
		f.setLayout(null);
		f.setUndecorated(true);
		p = new JPanel();
		f.getContentPane().setLayout(null);
		p.setBackground(Color.blue);
		p.setLayout(null);
		label1 = new JLabel();
		ImageIcon icon1 = new ImageIcon("1.png");
		label1.setBounds(200,200,30,30);
		label1.setIcon(icon1);
		label2 = new JLabel();
		ImageIcon icon2 = new ImageIcon("2.png");
		label2.setBounds(225,200,30,30);
		label2.setIcon(icon2);
		label3 = new JLabel();
		ImageIcon icon3 = new ImageIcon("3.png");
		label3.setBounds(250,200,30,30);
		label3.setIcon(icon3);
		label4 = new JLabel();
		ImageIcon icon4 = new ImageIcon("4.png");
		label4.setBounds(275,200,30,30);
		label4.setIcon(icon4);
		label5 = new JLabel();
		ImageIcon icon5 = new ImageIcon("5.png");
		label5.setBounds(300,200,30,30);
		label5.setIcon(icon2);
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);
		p.add(label5);
		label6 = new JLabel();
		ImageIcon icon6 = new ImageIcon("6.png");
		label6.setIcon(icon6);
		a = (int)(300*Math.random());
		b = (int)(300*Math.random());
		label6.setBounds(a,b,30,30);
		p.add(label6);
		f.getContentPane().add(p);
		p.setBounds(0,0,400,400);
		l = new JLabel();
		l.setBounds(420,150,180,50);
		l.setText("Your Score: \n0");
		f.add(l);
		f.addKeyListener(this);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int  sw = (int)(d.getWidth());
        int  sh = (int)(d.getHeight());
        f.setLocation((sw-600)/2,(sh-400)/2);		
		f.setSize(600,400);
		f.setVisible(true);
		t = new Timer(100,new GamePlay());
		t.start();
	}
	int x=200,y=200;
	class GamePlay implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(kc == KeyEvent.VK_LEFT&&left==true)
			{
				up=true;
				down=true;
				right =false;
				x=x>0?x-=25:375;
				position[4][0]=position[3][0];
				position[4][1]=position[3][1];
				position[3][0]=position[2][0];
				position[3][1]=position[2][1];
				position[2][0]=position[1][0];
				position[2][1]=position[1][1];
				position[1][0]=position[0][0];
				position[1][1]=position[0][1];
				position[0][0]=x;
				position[0][1]=y;
			}
			else if(kc == KeyEvent.VK_RIGHT&&right==true)
			{
				up=true;
				down=true;
				left = false;
				x=(x+25)%400;
				position[4][0]=position[3][0];
				position[4][1]=position[3][1];
				position[3][0]=position[2][0];
				position[3][1]=position[2][1];
				position[2][0]=position[1][0];
				position[2][1]=position[1][1];
				position[1][0]=position[0][0];
				position[1][1]=position[0][1];
				position[0][0]=x;
				position[0][1]=y;
				
			}
			else if(kc == KeyEvent.VK_UP&&up==true)
			{
				left=true;
				right=true;
				down = false;
				y=y>0?y-25:375;
				position[4][0]=position[3][0];
				position[4][1]=position[3][1];
				position[3][0]=position[2][0];
				position[3][1]=position[2][1];
				position[2][0]=position[1][0];
				position[2][1]=position[1][1];
				position[1][0]=position[0][0];
				position[1][1]=position[0][1];
				position[0][0]=x;
				position[0][1]=y;
			}
			else if(kc == KeyEvent.VK_DOWN&&down==true)
			{
				left=true;
				right=true;
				up=false;
				y=(y+25)%400;
				position[4][0]=position[3][0];
				position[4][1]=position[3][1];
				position[3][0]=position[2][0];
				position[3][1]=position[2][1];
				position[2][0]=position[1][0];
				position[2][1]=position[1][1];
				position[1][0]=position[0][0];
				position[1][1]=position[0][1];
				position[0][0]=x;
				position[0][1]=y;
			}
			if(left==false)
				kc=39;
			if(right==false)
				kc=37;
			if(up==false)
				kc=40;
			if(down==false)
				kc = 38;
			label1.setBounds(position[0][0],position[0][1],30,30);
			label2.setBounds(position[1][0],position[1][1],30,30);
			label3.setBounds(position[2][0],position[2][1],30,30);
			label4.setBounds(position[3][0],position[3][1],30,30);
			label5.setBounds(position[4][0],position[4][1],30,30);
			if((x>=a-12&&x<=a+12)&&(y>=b-12&&y<=b+12))
			{
				c++;
				l.setText("Your Score: \n"+c);
				a = (int)(300*Math.random());
				b = (int)(300*Math.random());
				label6.setBounds(a,b,30,30);
			}
		}
	}
	int kc = 37;
	public void keyPressed(KeyEvent e)
	{
		kc = e.getKeyCode();
	}
	public static void main(String a[])
	{
		new Snake();
	}
}