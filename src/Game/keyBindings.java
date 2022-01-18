package Game;

import java.awt.event.KeyEvent;

public class keyBindings //These are keyBindings and global variables
{
    private boolean DBG = false; //debugger

    //Value Retrievier
    public boolean getDBG()
    {
        return DBG;
    }

    //KeyPress
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F3:
                if (DBG)
                    DBG = false;
                else
                    DBG = true;
                break;
            default:
                break;
        }
    }
}
