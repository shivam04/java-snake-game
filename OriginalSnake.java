import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.*;
class OriginalSnake extends KeyAdapter
{
	ArrayList<JLabel> label = new ArrayList<JLabel>();
	JLabel label10,l,l1;
	Timer t;
	JFrame f;
	JPanel p;
	ImageIcon icon;
	boolean left = true;
	boolean right = true;
	boolean up = true;
	boolean down =true;
	int a,b,c=0;
	int[][] position= new int[30][2];
	int ax = 200, bx=200;
	int inc =0;
	String nm;
	OriginalSnake(String name)
	{
		int inn=0;
		for(int i=0;i<7;i++)
		{
			position[i][0]=200+inn;
			position[i][1]=200;
			inn+=25;
		}
		nm = name;
		f = new JFrame();
		f.setUndecorated(true);
		p = new JPanel();
		f.getContentPane().setLayout(null);
		p.setBackground(Color.blue);
		p.setLayout(null);
		label10 = new JLabel();
		ImageIcon icon10 = new ImageIcon("10.png");
		label10.setIcon(icon10);
		for(int i=0;i<7;i++)
		{
			label.add(new JLabel());
		}
		int i=0;
		for(JLabel k : label)
		{
			if(i==0)
			{
				icon=new ImageIcon("1.png");
				i=1;
			}
			else
			{
				icon = new ImageIcon("2.png");
			}
			k.setIcon(icon);
			k.setBounds(ax+inc,bx,30,30);
			p.add(k);
			inc+=25;
		}
		//System.out.println(label.size()-1);
		a = (int)(900*Math.random());
		b = (int)(700*Math.random());
		label10.setBounds(a,b,30,30);
		p.add(label10);
		l1 = new JLabel();
		l1.setBounds(1100,250,200,50);
		l1.setText("Hello "+name);
		f.add(l1);
		l = new JLabel();
		l.setBounds(1100,400,200,50);
		l.setText("Your Score: \n0");
		f.add(l);
		f.getContentPane().add(p);
		p.setBackground(Color.white);
		p.setBounds(0,0,1000,750);
		f.addKeyListener(this);
		f.setSize(1366,768);
		//System.out.println(label.size());
		f.setVisible(true);
		t = new Timer(100,new GamePlay1());
		t.start();
	}
	int x=200,y=200,np,nq;
	int vx=6;
	class GamePlay1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(kc == KeyEvent.VK_LEFT&&left==true)
			{
				up=true;
				down=true;
				right =false;
				x=x>0?x-=25:975;
				np = position[label.size()-1][0];
				nq = position[label.size()-1][1];
				for(int i=label.size()-1;i>=1;i--)
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
				x=(x+25)%1000;
				np = position[label.size()-1][0];
				nq = position[label.size()-1][1];
				for(int i=label.size()-1;i>=1;i--)
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
				y=y>0?y-25:725;
				np = position[label.size()-1][0];
				nq = position[label.size()-1][1];
				for(int i=label.size()-1;i>=1;i--)
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
				y=(y+25)%750;
				np = position[label.size()-1][0];
				nq = position[label.size()-1][1];
				for(int i=label.size()-1;i>=1;i--)
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
			int j=0;
			checkgameover();
			if((x>=a-12&&x<=a+12)&&(y>=b-12&&y<=b+12))
			{
				label.add(new JLabel());
				int g=1;
				c++;
				vx++;
				//System.out.println(label.size());
				if(vx>=29)
				{
					for(JLabel k : label)
					{
						if(j<29)
						k.setBounds(position[j][0],position[j][1],30,30);
						j+=1;
					}
					t.stop();
					JOptionPane.showMessageDialog(f,"You Won \n Got "+c+" points");
					f.dispose();
				}
				for(JLabel k : label)
				{
					if(g==label.size())
					{
						k.setIcon(new ImageIcon("2.png"));
						//k.setBounds(np,nq,30,30);
						p.add(k);
					}
					g+=1;
				}
				position[vx][0]=np;
				position[vx][1]=nq;
				l1.setText("Hello "+nm);
				l.setText("Your Score: "+c);
				a = (int)(900*Math.random());
				b = (int)(700*Math.random());
				label10.setBounds(a,b,30,30);
			}
			for(JLabel k : label)
			{
				if(j<label.size())
				k.setBounds(position[j][0],position[j][1],30,30);
				j+=1;
			}
		}
	}
	public void checkgameover()
	{
		for(int i=label.size()-1;i>=1;i--)
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
		new OriginalSnake("Shivi");
	}
}