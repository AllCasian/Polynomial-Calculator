package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;
import DataModels.PolynomialToString;

public class Integral {
    private Polynomial polynomial;

    public Integral(Polynomial polynomial) {
        this.polynomial = polynomial;
    }

    public String getResult() {
        Polynomial integral = new Polynomial("");
        for (Monomial monomial : polynomial.getMonomialList().values()) {
            float coef = monomial.getCoefficient() / (monomial.getExponent() + 1);
            int exp = monomial.getExponent() + 1;
            integral.getMonomialList().put(exp, new Monomial(coef, exp));
        }
        return PolynomialToString.convertToString(integral.getMonomialList());
    }
}
