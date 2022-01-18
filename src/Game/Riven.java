package Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;

import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Riven extends JPanel implements ActionListener, MouseMotionListener
{
    private keyBindings kb;
	private soundEngine se;
	private MandC MC;
    private int C_ImageID = 0;
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //Get screen resolution
    private Image C_Image;
    private JLabel mouseX, mouseY;
	private JLabel THitboxes;
    private final int DELAY = 16;
    private Timer timer;
    private int x, y;

    public Riven()
    {
        initRiven();
    }

    private void initRiven()
    {
        addKeyListener(new TAdapter());
        addMouseMotionListener(this);
        setBackground(Color.black);
        loadImage();
        setFocusable(true);

        kb = new keyBindings(); //set keyBindings
        mouseX = new JLabel();
        mouseY = new JLabel(); //set JLabels

        //Setting cursor
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("../Frames/cursor/cursor.png").getImage(), new Point(0, 0), "Hand cursor"));

        //Configuring the Debug JLabel
        mouseX.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16)); //Set configurations such as Font, and size
        mouseX.setOpaque(false);
        mouseX.setForeground(Color.white);

        mouseY.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16)); //Set configurations such as Font, and size
        mouseY.setOpaque(false);
        mouseY.setForeground(Color.white);

        setLayout(null);
        mouseX.setBounds(20, 20, 100, 20);
        mouseX.setVisible(false);

        mouseY.setBounds(mouseX.getX(), mouseX.getY() + mouseX.HEIGHT + 20, 100, 20);
        mouseY.setVisible(true);//Label settings

        add(mouseX);
        add(mouseY);//add mouse coordinate givers

        timer = new Timer(DELAY, this);
        timer.start();
		
		//Play Menu
		se = new soundEngine(); //Importing the sound engine
        se.setFile(0);
        se.play();
		
		//Set Menu
		MC = new MandC();
    }

    private void loadImage()
    {
        String imagedir = showImage.importImage(C_ImageID, size);
        ImageIcon ii = new ImageIcon(imagedir);
        C_Image = ii.getImage();
    }

    //Paints
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(C_Image, 0, 0, null); //Draw the front frame
        paintDBG(g);
    }

    private void paintDBG(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        if (kb.getDBG()) //If the debug is set to ON
        {
            //set shape color
            g2d.setPaint(Color.black);

            //drawing the rectangle
            g2d.fillRect(0, 0, 105, 60);
            mouseX.setVisible(true);
            mouseY.setVisible(true);
        }
        else
        {
            g2d.dispose();
            mouseX.setVisible(false);
            mouseY.setVisible(false);
        }
    }

    private void labChange()
    {
        mouseX.setText("Cor X: " + String.valueOf(x));
        mouseY.setText("Cor Y: " + String.valueOf(y));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        labChange();
    }

    //Mouse Tracker
    public void mouseDragged(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
    }
    
    //Key Bindings
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            kb.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            kb.keyReleased(e);
        }
    }
}