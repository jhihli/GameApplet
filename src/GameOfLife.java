import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.applet.Applet;

import javax.swing.*;



public class GameOfLife extends Applet{

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Graphics g = getGraphics();
			
			
			
		}
	}
	
	ButtonListener aButtonListener = new ButtonListener();
	
	private class ClearButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Graphics g = getGraphics();
			
		}
	}
	
	ClearButtonListener clear = new ClearButtonListener();
	
    public static void main(String[] args) {
        new GameOfLife();
    }

    public GameOfLife() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame myFrame = new JFrame();
				JPanel aPanel = new JPanel();
				JButton aButton = new JButton("Next Generation");
				JButton clearButton = new JButton("Clear Board");

				aButton.setSize(150, 150);
				aButton.addActionListener(clear);
				myFrame.setSize(200, 200);
				aPanel.setSize(200, 200);
				aPanel.add(aButton);
				aPanel.add(clearButton);
				myFrame.add(aPanel);
				myFrame.setVisible(true);
                
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        private List<Shape> grid;
        private List<Shape> fill;

        public PaintPane() {
            grid = new ArrayList<>(5);
            fill = new ArrayList<>(5);
            
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Shape shape : grid) {
                        if (shape.contains(e.getPoint())) {
                            if (fill.contains(shape)) {
                            	fill.remove(shape);
                            } else {
                                fill.add(shape);
                            }
                        }
                    }
                    repaint();
                }
            });

            int colWidth = 500 / 50;
            int rowHeight = 500 / 50;

            for (int row = 0; row < 50; row++) {
                for (int col = 0; col < 50; col++) {
                    grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            for (Shape cell : fill) {
                g2d.fill(cell);
            }
            g2d.setColor(Color.BLACK);
            for (Shape cell : grid) {
                g2d.draw(cell);
            }
        }

    }

}