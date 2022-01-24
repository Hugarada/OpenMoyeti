package Game;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseEvent;

public class MandC
{
	int height = 25;
	int width = 250;
	int w, h;

	public JLabel[] hitChange(int i, Dimension size, boolean supret) //the boolean "supret" is supposed to define where the users wants to actually change the existing texts and hitboxes or not
	{
		JLabel[] label;
		switch (i)
		{
			case 0:
				label = setMenu(size);
				break;
			default:
				label = null;
				break;
		}
		if (supret == false) //in case the user didn't desired to change the existing labels
			return null;
		else
			return label;
	}


	private JLabel[] setMenu(Dimension size)
	{
		JLabel[] GText = new JLabel[4];
		
		//Getting menu values

		//Creating the font values
		int fsize = height; 

		if (size.getWidth() == 1366 && size.getHeight() == 768)
		{
			w = 972;
			h = 307;
		}
		else if (size.getWidth() == 1920 && size.getHeight() == 1080)
		{
			w = 1400;
			h = 363;
		}
		else
		{
			w = 0;
			h = 0;
		}
		
		//Config labels
		GText[0] = new JLabel("Start new Game");
		GText[1] = new JLabel("Load new Game");
		GText[2] = new JLabel("Credits");
		GText[3] = new JLabel("Exit Game");
		for (int i = 0; i <= 3; i++)
		{
			GText[i].setFont(new Font("Microsoft YaHei UI", Font.PLAIN, fsize));
			GText[i].setOpaque(false);
			GText[i].setForeground(Color.white);
			if (i == 0)
				GText[i].setBounds(w, h, width, height);
			else
				GText[i].setBounds(w, GText[i - 1].getY() + 30, width, height);
			GText[i].setVisible(true);
		}

		return GText;
	}

	public int[] setHitBoxes(int C_ImageID)
	{
		int[] = hitX, hitY;
	}

	public void createHitBoxes(Graphics g, int C_ImageID)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new Color(150, 150, 15));

		RenderingHints rh = new RenderingHints
		(
			RenderingHints.KEY_ANTIALIASING,
		        RenderingHints.VALUE_ANTIALIAS_ON	
		);

		rh.put(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_QUALITY
		);

		g2d.setRenderingHints(rh);

		switch(C_ImageID)
		{
			case 0:
				int cheight = h;
				for (int i = 0; i <= 3; i++)
				{
					g2d.fillRect(w, cheight, width, height);
					cheight += 30;
				}
		}	
	}

	public int[] mousePointer(MouseEvent e, int C_ImageID)
	{
		int areturn[2]; //array to return

		areturn[0] = C_ImageID;
		switch(C_ImageID)
		{
			case 0:
				int[] mouseAvail[4]; //set available positions

				boolean returned = false; //check if it is inside of a hitbox
				for (int i = 0; i<= 3; i++)
				{
					mouseAvail[i] = h + (30 * i);
					if (e.getX() >= w && e.getX() <= width && e.getY() >= mouseAvail[i] && e.getY() <= mouseAvail[i] + 30);
				}
		}
	}
}
