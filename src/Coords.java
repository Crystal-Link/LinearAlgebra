import java.util.ArrayList;

//Calvin Zheng Period 8&9
public class Coords
{
    private double x;
    private double y;

    public Coords(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coords(double value)
    {
        x = value;
        y = value;
    }

    public Coords(Coords other)
    {
        this.x = other.x;
        this.y = other.y;
    }

    public Coords()
    {
        x = 0;
        y = 0;
    }

    public double getY()
    {
        return y;
    }

    public double getX()
    {
        return x;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double Y)
    {
        this.y = y;
    }

    public void reflectOnXAxis()
    {
        this.y = this.y * -1;
    }

    public void reflectOnYAxis()
    {
        this.x = this.x * -1;
    }

    public void reflectOnOrigin()
    {
        this.y = y * -1;
        this.x = x * -1;
    }

    public void translate(double horizontal, double vertical)
    {
        this.x += horizontal;
        this.y += vertical;
    }

    public void dilate(double dilationFactor)
    {
        this.x = x * dilationFactor;
        this.y = y * dilationFactor;
    }

    public double distanceFromOrigin()
    {
        return Math.sqrt(x*x + y*y);
        // return distanceFrom(new Coords());
    }

    public double distanceFrom(Coords other)
    {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public boolean equals(Coords otherPoint)
    {
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    public double getSlopeOfLineSegement(Coords other)
    {
        if (slopeOfLineSegmentDefined(other))
            return ((this.y - other.y)/(this.x - other.x));
        else
            return -1;
    }

    public boolean slopeOfLineSegmentDefined(Coords other)
    {
        return (this.x - other.x) != 0;
    }

    public static Coords closestPointToOrigin(ArrayList<Coords> points)
    {
        Coords closestPoint = points.get(0);
        for (Coords c : points)
            if (c.distanceFromOrigin() < closestPoint.distanceFromOrigin())
                closestPoint = c;
        return closestPoint;
    }
}
