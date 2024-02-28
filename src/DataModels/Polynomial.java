package DataModels;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    SortedMap<Integer, Monomial> monomialList = new TreeMap<>();

    public Polynomial(String polynomial){
        Pattern pattern = Pattern.compile("([+-]?)([0-9]*)([.][0-9]+)?([a-z][A-Z]?)?(\\^)?([^+-]+)?");
        Matcher matcher = pattern.matcher(polynomial);
        int totalTerms = 0;
        int x = 0;
        while (matcher.find()) {
            if(!Objects.equals(matcher.group(), "")) {
                x++;
                float coefficient = 0.0f;
                int exponent = 0;
                //System.out.println("Group " + x + ": " + "Coefficient:" + matcher.group(2) + "." +
                // matcher.group(3) + " Exponent:" + matcher.group(6));
                if (Objects.equals(matcher.group(2), "") && matcher.group(3) == null) {
                    coefficient = 1.0f;
                    System.out.println(coefficient);
                } else if (matcher.group(2) != null && matcher.group(3) != null) {
                    coefficient = (float) (Float.parseFloat(matcher.group(2)) + Float.parseFloat(matcher.group(3)));
                    System.out.println(coefficient);
                } else if (matcher.group(2) != null && matcher.group(3) == null) {
                    try {
                        coefficient = Float.parseFloat(matcher.group(2));
                        System.out.println(coefficient);
                    } catch (NumberFormatException e) {
                        System.out.println("null number");
                    }
                }
                if (Objects.equals(matcher.group(1), "-")) {
                    coefficient = -coefficient;
                }
                if (matcher.group(4) != null && matcher.group(6) == null) {
                    exponent = 1;
                } else if (matcher.group(4) == null && matcher.group(6) == null) {
                    exponent = 0;
                } else {
                    exponent = Integer.parseInt(matcher.group(6));
                }

                if(monomialList.containsKey(exponent)) {
                    coefficient = coefficient + monomialList.get(exponent).getCoefficient();
                }
                monomialList.put(exponent, new Monomial(coefficient, exponent));
                totalTerms++;
            }

        }
        System.out.println(x);

        for (Monomial monomial : monomialList.values()) {
            System.out.println("Exponent: " + monomial.getExponent());
            System.out.println("Coefficient: " + monomial.getCoefficient());
        }
        System.out.println(totalTerms);
        System.out.println(monomialList);
    }

    public SortedMap<Integer, Monomial> getMonomialList(){
        return monomialList;
    }




}
