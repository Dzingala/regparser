package com.epam;


public class Main {
    public static void main(String[] args) {
        DFAModel dfaModel = new DFAModel();


        dfaModel.fillInAutomata("(abc|cd)|(ef|gh)");
        //dfaModel.checkInputMatchesRegex("abcd");
    }
}