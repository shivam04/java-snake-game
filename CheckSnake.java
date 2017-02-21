import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class CheckSnake extends KeyAdapter
{
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,l,l1;
	Timer t;
	JFrame f;
	JPanel p;
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
	{300,200},
	{325,200},
	{350,200},
	{300,350},
	{325,350}
	};
	String nm;
	CheckSnake(String name)
	{
		nm = name;
		f = new JFrame();
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
		label6 = new JLabel();
		ImageIcon icon6 = new ImageIcon("6.png");
		label6.setBounds(325,200,30,30);
		label6.setIcon(icon6);
		label7 = new JLabel();
		ImageIcon icon7 = new ImageIcon("7.png");
		label7.setBounds(350,200,30,30);
		label7.setIcon(icon7);
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);
		p.add(label5);
		p.add(label6);
		p.add(label7);
		label10 = new JLabel();
		ImageIcon icon10 = new ImageIcon("10.png");
		label10.setIcon(icon10);
		a = (int)(300*Math.random());
		b = (int)(300*Math.random());
		label10.setBounds(a,b,30,30);
		p.add(label10);
		l1 = new JLabel();
		l1.setBounds(420,100,180,50);
		l1.setText("Hello "+name);
		f.add(l1);
		l = new JLabel();
		l.setBounds(420,160,180,50);
		l.setText("Your Score: \n0");
		f.add(l);
		label8 = new JLabel();
		label8.setBounds(300,350,30,30);
		ImageIcon icon8 = new ImageIcon("8.png");
		label8.setIcon(icon8);
		label9 = new JLabel();
		label9.setBounds(325,350,30,30);
		ImageIcon icon9 = new ImageIcon("9.png");
		label9.setIcon(icon9);
		p.add(label8);
		p.add(label9);
		f.getContentPane().add(p);
		p.setBackground(Color.white);
		p.setBounds(0,0,400,400);
		f.addKeyListener(this);
		f.setSize(600,400);
		f.setVisible(true);
		t = new Timer(100,new GamePlay1());
		t.start();
	}
	int x=200,y=200;
	class GamePlay1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(kc == KeyEvent.VK_LEFT&&left==true)
			{
				up=true;
				down=true;
				right =false;
				x=x>0?x-=25:375;
				for(int i=6;i>=1;i--)
				{
					position[i][0] = position[i-1][0];
					position[i][1] = position[i-1][1];
				}
				position[0][0]=x;
				position[0][1]=y;
			}
			else if(kc == KeyEvent.VK_RIGHT&&right==true)
			{
				up=true;
				down=true;
				left = false;
				x=(x+25)%400;
				for(int i=6;i>=1;i--)
				{
					position[i][0] = position[i-1][0];
					position[i][1] = position[i-1][1];
				}
				position[0][0]=x;
				position[0][1]=y;
				
			}
			else if(kc == KeyEvent.VK_UP&&up==true)
			{
				left=true;
				right=true;
				down = false;
				y=y>0?y-25:375;
				for(int i=6;i>=1;i--)
				{
					position[i][0] = position[i-1][0];
					position[i][1] = position[i-1][1];
				}
				position[0][0]=x;
				position[0][1]=y;
			}
			else if(kc == KeyEvent.VK_DOWN&&down==true)
			{
				left=true;
				right=true;
				up=false;
				y=(y+25)%400;
				for(int i=6;i>=1;i--)
				{
					position[i][0] = position[i-1][0];
					position[i][1] = position[i-1][1];
				}
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
			label6.setBounds(position[5][0],position[5][1],30,30);
			label7.setBounds(position[6][0],position[6][1],30,30);
			checkgameover();
			if((x>=a-12&&x<=a+12)&&(y>=b-12&&y<=b+12))
			{
				c++;
				l1.setText("Hello "+nm);
				l.setText("Your Score: "+c);
				if(c==10)
				{
					JOptionPane.showMessageDialog(f,"Congratulations "+nm+"\nLevel-1 Clear\nYou Scored "+c+"Points");
					f.dispose();
					new Snake2(nm);
				}
				a = (int)(300*Math.random());
				b = (int)(300*Math.random());
				label10.setBounds(a,b,30,30);
			}
		}
	}
	public void checkgameover()
	{
		for(int i=8;i>=1;i--)
		{
			if(position[i][0]==position[0][0]&&position[i][1]==position[0][1])
			{
				t.stop();
				JOptionPane.showMessageDialog(f,"Game Over "+nm+"\n You Scored "+c);
				f.dispose();
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
		new GiveName();
	}
}