package Game;

import java.awt.Dimension;

public class showImage
{
    public static String importImage(int i, Dimension size)
    {
        //Resolution folder variables
        String res = String.valueOf((int)size.getWidth()) + 'x' + String.valueOf((int)size.getHeight()) + "/";
        //Convert the name of the image to ("File Name".png)
        String imageName = String.valueOf(i) + ".png";
        //Finds the file
        String image = ("../Frames/" + res + imageName);
        return image;
    }

    public static String returnCursor()
    {
        return "../Frames/cursor/cursor.png";
    }
}