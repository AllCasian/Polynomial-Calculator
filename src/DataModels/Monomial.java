package DataModels;

public class Monomial {
    private float coefficient;
    private int exponent;

    public Monomial(float coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public String toString(){
        return "Coefficient:" + coefficient + ", Exponent:" + exponent;
    }
}
