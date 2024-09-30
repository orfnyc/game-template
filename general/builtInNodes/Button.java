package general.builtInNodes;

import general.GameNode;
import general.Window;

public class Button extends GameNode
{
    private double width;
    private double height;

    private boolean pressed;
    private boolean clicked;

    public Button(String name, double x, double y, double height, double width) 
    {
        super(name, "button");
        this.getTransform().setXPosition(x);
        this.getTransform().setYPosition(y);
        this.width = width;
        this.height = height;
    }

    public Button(String name, double x, double y, double height, double width, String spritePath) 
    {
        super(name, "button");
        this.getTransform().setXPosition(x);
        this.getTransform().setYPosition(y);
        this.width = width;
        this.height = height;
        this.addChild(new Sprite("buttonImage", spritePath));
    }


    public boolean pressed()
    {
        return pressed;
    }

    public boolean clicked()
    {
        return clicked;
    }
    public void update(double dt)
    {
        double mouseX = Window.getWindow().getMouseListener().getX();
        double mouseY = Window.getWindow().getMouseListener().getY();
        pressed = Window.getWindow().getMouseListener().getMousePressed() 
                && mouseX > this.getTransform().getXPosition()
                && mouseY < this.getTransform().getXPosition() + this.width
                && mouseY > this.getTransform().getYPosition()
                && mouseY < this.getTransform().getYPosition() + this.height;
        clicked = pressed && !clicked;
    }
    
}
