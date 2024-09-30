package utilities;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

public class ML extends MouseAdapter
{
    private boolean mousePressed = false;
    private boolean mouseDragged = false;
    private int mouseButton = -1;
    private float x = -1.0f, y = -1.0f;
    private float dx = -1.0f, dy = -1.0f;

    public void mousePressed(MouseEvent mouseEvent)
    {
        this.mousePressed = true;
        this.mouseButton = mouseEvent.getButton();
    }

    public void mouseReleased(MouseEvent mouseEvent)
    {
        this.mousePressed = false;
        this.mouseDragged = false;
        this.dx = 0;
        this.dy = 0;
    }

    public void mouseMoved(MouseEvent mouseEvent)
    {
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    public void mouseDragged(MouseEvent mouseEvent)
    {
        this.mouseDragged = true;
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
        this.dx = mouseEvent.getX() - this.x;
        this.dy = mouseEvent.getY() - this.y;
    }

    public boolean getMousePressed()
    {
        return this.mousePressed;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public int getMouseButton()
    {
        return this.mouseButton;
    }

    public boolean mouseDragged()
    {
        return this.mouseDragged;
    }

    public float getDX()
    {
        return this.dx;
    }

    public float getDY()
    {
        return this.dy;
    }
}

