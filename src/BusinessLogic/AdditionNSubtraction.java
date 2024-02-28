package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;
import DataModels.PolynomialToString;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class AdditionNSubtraction {
    SortedMap<Integer, Monomial> monomialList1;
    SortedMap<Integer, Monomial> monomialList2;
    SortedMap<Integer, Monomial> monomialList3 = new TreeMap<>();

    private Polynomial poly1;
    private Polynomial poly2;
    private char operator;
    public AdditionNSubtraction(Polynomial poly1, Polynomial poly2, char operator){
        this.poly1 = poly1;
        this.poly2 = poly2;
        this.operator = operator;
    }

    public String getResult(){
        monomialList1 = poly1.getMonomialList();
        monomialList2 = poly2.getMonomialList();
        for (Map.Entry<Integer, Monomial> entry : monomialList1.entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial1 = entry.getValue();
            Monomial monomial3 = new Monomial(monomial1.getCoefficient(), exponent);
            monomialList3.put(exponent, monomial3);
        }

        for (Map.Entry<Integer, Monomial> entry : monomialList2.entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial2 = entry.getValue();
            Monomial monomial3 = monomialList3.get(exponent);
            if (monomial3 == null) {
                monomialList3.put(exponent, new Monomial(monomial2.getCoefficient(), exponent));
            } else {
                if(operator == '+') {
                    monomialList3.put(exponent, new Monomial(monomial3.getCoefficient() + monomial2.getCoefficient(), exponent));
                }
                else if(operator == '-'){
                    monomialList3.put(exponent, new Monomial(monomial3.getCoefficient() - monomial2.getCoefficient(), exponent));
                }
            }
        }
        return PolynomialToString.convertToString(monomialList3);
    }
}
