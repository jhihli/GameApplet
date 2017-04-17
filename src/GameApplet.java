
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;


public class GameApplet extends Applet{

	int oldx, oldy;
	
	JFrame myFrame = new JFrame();
	JPanel aPanel = new JPanel();
	JButton aButton = new JButton("Next Generation");
	JButton clearButton = new JButton("Clear Board");
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Graphics g = getGraphics();
			g.drawString("You add code to display next generation", 10, 10);
			
			
		}
	}
	
	ButtonListener aButtonListener = new ButtonListener();
	
	private class ClearButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Graphics g = getGraphics();
			g.drawString("You add code to clear", 10, 50);
		}
	}
	
	ClearButtonListener clear = new ClearButtonListener();
	
	public void init()
	{
		//JRootPane rootPane = this.getRootPane();
		//rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
		oldx = -1;
		oldy = -1;
		this.addMouseListener(myListener);
		aButton.setSize(150,150);
		aButton.addActionListener(clear);
		
		myFrame.setSize(200, 200);
		aPanel.setSize(200, 200);
		aPanel.add(aButton);
		aPanel.add(clearButton);
		myFrame.add(aPanel);
		myFrame.setVisible(true);
	}
	
	private class MousePressedListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			Graphics g = getGraphics();
			int x = e.getX();
			int y = e.getY();
			
			if(oldx<0)
			{
				oldx = x;
				oldy = y;
			}
			else
			{
				g.setColor(Color.black);
				g.drawLine(oldx, oldy, x, y);
				oldx = x;
				oldy = y;
			}
		}
		
		public void mouseReleased(MouseEvent e)
		{
			
		}
		public void mouseClicked(MouseEvent e)
		{
			Graphics g = getGraphics();
			g.drawString("You clicked the mouse!", 10, 70);
		}
		public void mouseEntered(MouseEvent e)
		{
			
		}
		public void mouseExited(MouseEvent e)
		{
			
		}
		
	}
	
	MousePressedListener myListener = new MousePressedListener();
	
	public void paint(Graphics g)
	{
		
	}
}
