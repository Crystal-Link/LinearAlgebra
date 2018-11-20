//Calvin Zheng Period 8&9
import sun.plugin.javascript.navig.LinkArray;

import static java.lang.Double.isInfinite;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    //ax+by+c=0
    //y=-a/bx-c/b
    //y-y1-mx+mx1 = 0

    public static boolean areValidParams(double a, double b) {
        return a == 0 && b == 0;
    }

    //constructors
    public LinearEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public LinearEquation(double slope, Coords point) {
        this.a = slope * -1;
        this.b = 1;
        this.c = (slope * point.getX() - point.getY());
    }

    public LinearEquation(LinearEquation other) //copy constructor
    {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }

    public LinearEquation(Coords point1, Coords point2) //precondition !point1.equals(point2)
    {
        if (point1.getX() == point2.getX()) {
            this.a = 1;
            this.b = 0;
            this.c = -point1.getX();
        } else {
            this.a = -point1.getSlopeOfLineSegement(point2);
            this.b = 1;
            this.c = (point1.getSlopeOfLineSegement(point2) * point1.getX() - point1.getY());
        }
    }

    public LinearEquation(LinearEquation other, Coords point) //instantiates line that passes through point and is parallel to other
    {
        this(other.slope(),point);
    }

    //accessors
    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public boolean slopeDefined() {
        return this.b != 0;
    }

    public boolean hasYIntercept() {
        return slopeDefined();
    }

    public boolean hasXIntercept() {
        return !isHorizontal();
    }

    public double slope()
    {
        return this.a/this.b;
    }

    public double yIntercept()
    {
        return -this.c/this.b;
    }

    public double xIntercept()
    {
        return -this.c/this.a;
    }

    public double slopeOfPerpendicularLine()
    {
        return -this.b/this.a;
    }

    public boolean isIncreasing()
    {
        return slope() > 0;
    }

    public boolean isDecreasing()
    {
        return slope() < 0;
    }

    public boolean isHorizontal()
    {
        return slope() == 0;
    }

    public boolean isVertical()
    {
        return isInfinite(slope());
    }

    public boolean isAFunction()
    {
        return this.b != 0;
    }

    public boolean isValidLinearEquation()
    {
        return this.a != 0 && this.b != 0;
    }

    public boolean isDirectVariation()
    {
        return this.c == 0;
    }

    //other methods
    public boolean equals(LinearEquation other)
    {
        return this.a == other.a && this.b == other.b && this.c == other.c;
    }

    public LinearEquation parallelLine(Coords point) //returns LinearEquation that passes through point and is parallel to this line
    {
        return new LinearEquation(slope(), point);
    }

    public LinearEquation perpendicularLine(Coords point)
    {
        if (!this.isValidLinearEquation())
            return null;
        if(this.isHorizontal())
            return new LinearEquation(1,0,-1*point.getX());
        if(this.isVertical())
            return new LinearEquation(0, 1, -1*point.getX());
        else
            return new LinearEquation(slopeOfPerpendicularLine(), point);
    }

    public double shortestDistanceFrom(Coords point)
    {
        return point.distanceFrom(pointOfIntersection(perpendicularLine(point)));
    }

    public LinearEquation inverseFunction() //ax+by+c=0 --> ay+bx+c=0
    {
        return new LinearEquation(this.b, this.a, this.c);
    }

    public Coords pointOfIntersection(LinearEquation other)
    {
        //receives another linear equation as parameter
        if(!this.isValidLinearEquation() || !other.isValidLinearEquation())
            return null;
        if(this.isHorizontal() && other.isHorizontal())
            return null;
        if(this.isVertical() && other.isVertical())
            return null;
        if(this.isVertical() && other.isHorizontal())
            return new Coords(this.xIntercept(), other.yIntercept());
        if(this.isHorizontal() && other.isVertical())
            return new Coords(other.xIntercept(), this.yIntercept());
        double d = other.a;
        double e = other.b;
        double f = other.c;

        double y = (a*f-c*d)/(b*d-a*e);
        double x = (-b*y-c)/a;
        return new Coords(x,y);
    }

    public boolean isParallel(LinearEquation other)
    {
        return this.slope() == other.slope();
    }

    public boolean isPerpendicular(LinearEquation other)
    {
        return this.slope() == -1/other.slope();
    }

    public String toString()
    {
        return this.a + "x + " + this.b + "y + " + this.c + " = 0";
    }

    public String getSlopeInterceptForm()
    {
        return "y = " + this.slope() + " x + " + this.yIntercept();
    }
}
