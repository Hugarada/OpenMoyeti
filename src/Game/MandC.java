package Game;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class MandC
{
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
		
		int w, h;
		//Getting menu values
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
			GText[i].setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
			GText[i].setOpaque(false);
			GText[i].setForeground(Color.white);
			if (i == 0)
				GText[i].setBounds(w, h, 500, 20);
			else
				GText[i].setBounds(w, GText[i - 1].getY() + 30, 500, 20);
			GText[i].setVisible(true);
		}

		return GText;
	}
}