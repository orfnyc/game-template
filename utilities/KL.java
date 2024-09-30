package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KL extends KeyAdapter
{
    private boolean[] keyPressed = new boolean[128];

    public void keyPressed(KeyEvent e)
    {
        keyPressed[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e)
    {
        keyPressed[e.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int keyCode)
    {
        return keyPressed[keyCode];
    }
}
