package general;

public class Transform 
{
    private double xPosition, yPosition, rotation;

    public Transform()
    {
        this.xPosition = 0;
        this.yPosition = 0;
        this.rotation = 0;
    }

    public Transform(double x, double y)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.rotation = 0;
    }

    public Transform(double x, double y, double rotation)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.rotation = rotation;
    }

    public double getXPosition() { return this.xPosition; }
    public double getYPosition() { return this.yPosition; }
    public double getRotation() { return this.rotation; }

    public void setXPosition(double x) { this.xPosition = x; }
    public void setYPosition(double y) { this.yPosition = y; }
    public void setRotation(double rotation) { this.rotation = rotation; }

    public void incrementXPosition(double delta) { this.xPosition += delta; }
    public void incrementYPosition(double delta) { this.yPosition += delta; }
    public void incrementRotation(double delta) { this.rotation += delta; }

    public Transform copy()
    {
        return new Transform(this.xPosition, this.yPosition, this.rotation);
    }
}
