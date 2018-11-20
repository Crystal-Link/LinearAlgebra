//Calvin Zheng Period 8&9
public class QuadraticRoots
{
    //instance variables
    private ComplexNumber root1;
    private ComplexNumber root2;

    //constructors
    public QuadraticRoots(double r1, double r2)
    {
        this.root1 = new ComplexNumber(r1, 0);
        this.root2 = new ComplexNumber(r2, 0);
    }

    public QuadraticRoots(ComplexNumber r1)
    {
        this.root1 = r1;
    }

    //accessors
    public ComplexNumber getRoot1()
    {
        return this.root1;
    }

    public ComplexNumber getRoot2()
    {
        return this.root2;
    }

    public String toString()
    {
        return "(" + root1.toString() + ", " + root2.toString() + ")";
    }

    public boolean areValid()
    {
        double real1 = root1.getRealMagnitude();
        double real2 = root2.getRealMagnitude();
        double imag1 = root1.getImaginaryMagnitude();
        double imag2 = root2.getImaginaryMagnitude();
        return (real1 == real2 && imag1 == imag2) || (imag1 == 0 && imag2 == 0);
    }
}