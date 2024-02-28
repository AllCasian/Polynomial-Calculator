package DataModels;

import java.util.SortedMap;

public class PolynomialToString {
    public static String convertToString(SortedMap<Integer, Monomial> monomialList) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Monomial monomial : monomialList.values()) {
            float coefficient = monomial.getCoefficient();
            int exponent = monomial.getExponent();

            if (coefficient < 0) {
                sb.append("-");
                coefficient = -coefficient;
            } else if (i > 0) {
                sb.append("+");
            }

            if (coefficient != 1 || exponent == 0) {
                sb.append(coefficient);
            }

            if (exponent > 0) {
                sb.append("x");

                if (exponent != 1) {
                    sb.append("^").append(exponent);
                }
            }

            i++;
        }

        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
