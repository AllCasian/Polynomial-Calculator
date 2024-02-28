package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;
import DataModels.PolynomialToString;

public class Derivative {
    private Polynomial poly;

    public Derivative(Polynomial poly) {
        this.poly = poly;
    }

    public String getResult() {
        Polynomial derivative = new Polynomial("");
        for (Monomial mono : poly.getMonomialList().values()) {
            float coef = mono.getCoefficient() * mono.getExponent();
            int exp = mono.getExponent() - 1;
            if (exp >= 0) {
                derivative.getMonomialList().put(exp, new Monomial(coef, exp));
            }
        }
        return PolynomialToString.convertToString(derivative.getMonomialList());
    }
}
