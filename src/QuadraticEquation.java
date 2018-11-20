//Calvin Zheng Period 8&9
public class QuadraticEquation
{
    //instance variables
    private double a;
    private double b;
    private double c;
    //ax^2 + bx + c = y

    //constructors
    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(QuadraticEquation other)
    {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }

    //y=a(x-h)^2+k
    //y=a(x^2-2hx+h^2)+k
    //y=ax^2-2ahx+ah^2+k
    public QuadraticEquation(Coords vertex, double coefficient)
    {
        double h = vertex.getX();
        double k = vertex.getY();
        this.a = coefficient;
        this.b = -2*coefficient*h;
        this.c = (h*h)*coefficient + k;
    }

    //y = x^2
    public QuadraticEquation()
    {
        this.a = 1;
        this.b = 0;
        this.c = 0;
    }

    //methods
    public String toString()
    {
        return a+"x^2 +" + b + "x + " + c;
    }

    public double getDiscriminant()
    {
        return (b*b-4/a*c);
    }

    public boolean hasRealRoots()
    {
        return getDiscriminant() >= 0;
    }

    public boolean hasEqualRoots()
    {
        return getDiscriminant() == 0;
    }

    public boolean hasMinimum()
    {
        return a > 0;
    }

    public boolean hasMaximum()
    {
        return a < 0;
    }

    public LinearEquation axisOfSymmetry()
    {
        return new LinearEquation(1, 0, b/(2*a));
    }

    public Coords vertex()
    {
        double xVertex = -b/2*a;
        double yVertex = a*(xVertex*xVertex) + b*xVertex + c;
        return new Coords (xVertex, yVertex);
    }

    public LinearEquation derivative()
    {
        return new LinearEquation(2*a, -1,b);
    }

    public QuadraticRoots getRoots() {
        //a root is a ComplexNumber
        if (a != 0) {
            double real1 = -b / (2 * a);
            double real2 = real1;
            double imag = Math.sqrt(b * b - 4 * a * c) / (2 * a);
            if (hasRealRoots() || hasEqualRoots())
            {
                real1 += imag;
                real2 -= imag;
                return new QuadraticRoots(real1, real2);
            }
            else
            {
                ComplexNumber root = new ComplexNumber(real1, imag);
                return new QuadraticRoots(root);
            }
        }
        return null;
    }
}