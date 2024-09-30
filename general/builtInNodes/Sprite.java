package general.builtInNodes;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import general.GameNode;
import utilities.AssetPool;

public class Sprite extends GameNode
{
    private BufferedImage image;

    public Sprite(String name, String file)
    {
        super(name, "sprite");
        this.image = AssetPool.getSprite(file);
    }
     
    public Sprite(String name, String file, GameNode parent) 
    {
        super(name, "sprite", parent);
        this.image = AssetPool.getSprite(file);
    }

    public Sprite(String name, BufferedImage image)
    {
        super(name, "sprite");
        this.image = image;
    }

    public Sprite(String name, BufferedImage image, GameNode parent)
    {
        super(name, "sprite", parent);
        this.image = image;
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public int getWidth()
    {
        return this.image.getWidth();
    }

    public int getHeight()
    {
        return this.image.getHeight();
    }

    public void draw(Graphics2D g2)
    {
        double xPosition = this.getParent().getTransform().getXPosition()+this.getTransform().getXPosition();
        double yPosition = this.getParent().getTransform().getYPosition()+this.getTransform().getYPosition();
        double rotation = Math.toRadians((double)(this.getParent().getTransform().getRotation()+this.getTransform().getRotation()));
        AffineTransform t = new AffineTransform();
        t.setToIdentity();
        t.translate(xPosition, yPosition);
        t.rotate(rotation, (double)this.image.getWidth()/2+xPosition, (double)this.image.getHeight()/2+yPosition);
        g2.drawImage(image, t, null);
    }

    public Sprite copyWithoutChildren()
    {
        Sprite copy = new Sprite(this.getName(), this.getImage(), this.getParent());
        copy.setTransform(this.getTransform().copy());
        return copy;
    }

    public Sprite copyWithoutChildren(GameNode copyParent)
    {
        return new Sprite(this.getName(), this.getImage(), copyParent);
    }
}
