package Game;

import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class soundEngine
{
	Clip clip;
	File file[] = new File[2];
	
	public soundEngine()
	{
		file[0] = new File("../OST/0.wav");
		file[1] = new File("../OST/1.wav");
	}
	
	public void setFile(int i)
	{
		try
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(file[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch (Exception e){}
	}
	
	public void play()
	{
		clip.start();
	}
	
	public void loop()
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop()
	{
		clip.stop();
	}
}
