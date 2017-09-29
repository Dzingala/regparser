package com.epam;


public class Main {
    public static void main(String[] args) {
        DFAModel dfaModel = new DFAModel();

        System.out.println(dfaModel.isCorrectString("ab"));

        System.out.println(dfaModel.isCorrectString("cd"));

        System.out.println(dfaModel.isCorrectString("abcd"));

        System.out.println(dfaModel.isCorrectString("acbd"));

        System.out.println(dfaModel.isCorrectString("(ac|ab)+"));
        System.out.println(dfaModel.checkInputRegex("absda_d*l"));
        System.out.println(dfaModel.checkInputRegex("dsadasdas*l"));
    }
}