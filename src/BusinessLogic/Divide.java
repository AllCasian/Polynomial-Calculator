package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;
import DataModels.PolynomialToString;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Divide {
    private Polynomial poly1;
    private Polynomial poly2;

    public Divide(Polynomial poly1, Polynomial poly2) {
        this.poly1 = poly1;
        this.poly2 = poly2;
    }

    public String getResult() {
        Polynomial result = new Polynomial("");
        for (Monomial mono1 : poly1.getMonomialList().values()) {
            for (Monomial mono2 : poly2.getMonomialList().values()) {
                float coef = mono1.getCoefficient() / mono2.getCoefficient();
                int exp = mono1.getExponent() - mono2.getExponent();
                if (result.getMonomialList().containsKey(exp)) {
                    coef += result.getMonomialList().get(exp).getCoefficient();
                }
                result.getMonomialList().put(exp, new Monomial(coef, exp));
            }
        }
        return PolynomialToString.convertToString(result.getMonomialList());
    }

}