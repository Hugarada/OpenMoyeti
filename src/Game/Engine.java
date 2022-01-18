package Game;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Engine extends JFrame
{
    public Engine()
    {
        initUI();
    }

    private void initUI()
    {
        add(new Riven());

        setTitle("Riven: The sequel to Myst");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        dispose();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            Engine ex = new Engine();
            ex.setVisible(true);
        });
    }
}