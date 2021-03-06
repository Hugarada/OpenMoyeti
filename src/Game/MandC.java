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
	private int height = 30;
	private int width = 250;
	private int w, h;
	private int sep = 15;
	private int oSelected, areturn = 0; //Value 0: not triggered. Value 1: Triggered. Value 2: Trigger block

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
				GText[i].setBounds(w, GText[i - 1].getY() + height + sep, width, height);
			GText[i].setVisible(true);
		}

		return GText;
	}

	public int mousePointer_sound(MouseEvent e, int C_ImageID)
	{
		switch(C_ImageID)
		{
			case 0:
				int[] mouseAvail = new int[4]; //set available positions
				boolean broken = false;

				mouseAvail[0] = h;
				for (int i = 0; i <= 3; i++)
				{
					if (i > 0)
						mouseAvail[i] = mouseAvail[i - 1] + height + sep;
					if (e.getX() >= w && e.getX() <= w + width && e.getY() >= mouseAvail[i] && e.getY() <= mouseAvail[i] + height)
					{
						if (oSelected != 2)
							oSelected += 1;
						areturn = 1;
						broken = true;
						break;
					}
					else if (e.getY() < mouseAvail[i])
						break;
				}

				if (!broken)
					oSelected = 0;
				break;
			default:
				break;
		}

		if (oSelected == 1)
			return areturn;
		else
			return 0;
	}
}
