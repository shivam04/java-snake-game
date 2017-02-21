import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class GiveName extends MouseAdapter
{
	JFrame f ;
	JButton b;
	JTextField t;
	GiveName()
	{
			f = new JFrame();
			f.setLayout(null);
			f.setUndecorated(true);
			JLabel l = new JLabel("Give Your Name");
			l.setBounds(100,100,150,25);
			f.add(l);
			t = new JTextField(30);
			t.setBounds(75,150,175,25);
			f.add(t);
			b = new JButton("Submit");
			b.setBounds(110,200,100,25);
			f.add(b);
			b.addMouseListener(this);
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			int  sw = (int)(d.getWidth());
			int  sh = (int)(d.getHeight());
			f.setLocation((sw-300)/2,(sh-300)/2);
			f.setSize(300,300);
			f.setVisible(true);
	}
	public void mouseClicked(MouseEvent e)
	{
			String a = t.getText();
			new CheckSnake(a);
			f.dispose();
	}
	public static void main(String a[])
	{
		new GiveName();
	}
}