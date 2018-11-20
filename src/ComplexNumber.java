//Calvin Zheng Period 8&9
public class ComplexNumber {
    //a+bi
    //instance variables
    private double a;
    private double b;

    //constructors
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.a = realPart;
        this.b = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber other) {
        this.a = other.a;
        this.b = other.b;
    }

    //accessors
    public double getRealMagnitude()
    {
        return this.a;
    }

    public double getImaginaryMagnitude()
    {
        return this.b;
    }
    public String toString()
    {
        return this.a + " + " + this.b + "i";
    }

    //mutators
    public void add(double scalar)
    {
        this.a += scalar;
    }

    public void add(ComplexNumber other)
    {
        this.a += other.a;
        this.b += other.b;
    }

    public void subtract(double scalar)
    {
        this.a -= scalar;
    }

    public void subtract(ComplexNumber other)
    {
        this.a -= other.a;
        this.b -= other.b;
    }

    public void multiply(double scalar)
    {
        this.a *= scalar;
        this.b *= scalar;
    }

    //(a+bi)(c+di) = ac+(ad+bc)i-(bd)
    public void multiply(ComplexNumber other)
    {
        this.a = (this.a*other.a)-(this.b*other.b);
        this.b = (this.a*other.b) + (this.b*other.a);
    }

    public boolean divideBy(double scalar)
    {
        if (scalar == 0)
            return false;
        else {
            this.a /= scalar;
            this.b /= scalar;
            return true;
        }
    }

    //(a+bi)/(c+di) = (a+bi)(c-di)/(c^2+d^2) = (ac+(-ad+bc)i+bd)/(c^2+d^2)
    public boolean divideBy(ComplexNumber other)
    {
        if (other.a == 0 && other.b == 0)
            return false;
        else
        {
            this.a = ((this.a * other.a) + (this.b * other.b)) / ((other.a * other.a) + (other.b * other.b));
            this.b = ((-this.a * other.b) + (this.b * other.a)) / ((other.a * other.a) + (other.b * other.b));
            return true;
        }
    }

}
