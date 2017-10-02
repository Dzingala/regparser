package com.epam;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan_Dzinhala on 9/26/2017.
 */
public class DFAModel implements DFA{
    public enum States{
        STATE_INITIAL,
        STATE_1,
        STATE_2,
        STATE_INCORRECT,
        STATE_3,
        STATE_ACCEPTANCE
    }

    private static String alphabet="abcdefghijklmnopqrstuvwxyz()|*+";

    private static States currentState;

    private int acceptanceState;
    private Map<Character,HashMap<States,States>> transitionTable;

    DFAModel(){
        transitionTable = new TreeMap<>();
        currentState=States.STATE_INITIAL;
    }

    public void fillInAutomata(String input){
        for(int i = 0 ; i < input.length() ; i++) {
            Character currentChar = input.charAt(i);

            HashMap charStatesMap = new HashMap<States, States>();
            boolean isIncorrectInput = false;

            switch (currentState){
                case STATE_INITIAL:{
                    switch (currentChar){
                        case '(': {
                            currentState = States.STATE_1;
                            charStatesMap.put(States.STATE_INITIAL, States.STATE_1);
                            break;
                        }
                        default:{
                            currentState = States.STATE_INCORRECT;
                            isIncorrectInput=true;
                        }
                    }
                    break;
                }
                case STATE_1:{
                    if((currentChar>='a' && currentChar<='z') || (currentChar>='A' && currentChar<='Z')){
                        charStatesMap.put(States.STATE_1, States.STATE_1);
                    }else if(currentChar=='|'){
                        currentState = States.STATE_2;
                        charStatesMap.put(States.STATE_1, States.STATE_2);
                    }else{
                        currentState = States.STATE_INCORRECT;
                        isIncorrectInput=true;
                    }
                    break;
                }
                case STATE_2:{
                    if((currentChar>='a' && currentChar<='z') || (currentChar>='A' && currentChar<='Z')){
                        charStatesMap.put(States.STATE_2, States.STATE_2);
                    }else if(currentChar==')'){
                        currentState = States.STATE_3;
                        charStatesMap.put(States.STATE_2, States.STATE_3);
                    }else{
                        currentState = States.STATE_INCORRECT;
                        isIncorrectInput=true;
                    }
                    break;
                }case STATE_3:{
                    if(currentChar=='+'){
                        currentState = States.STATE_ACCEPTANCE;
                        charStatesMap.put(States.STATE_3, States.STATE_ACCEPTANCE);
                    }else{
                        currentState=States.STATE_INCORRECT;
                        isIncorrectInput=true;
                    }
                    break;
                }
            }

            if(isIncorrectInput){
                throw new UnsupportedOperationException("INCORRECT INPUT");
            }

            transitionTable.put(currentChar, charStatesMap);
        }
        System.out.println("resulting state:" + currentState);
    }


    public void checkInputMatchesRegex(String input) {
        Integer inputState = 0;
        for(int i=0;i<input.length();i++){
            Character currentCharacter = input.charAt(i);
            //HashMap<Integer, Integer> charStates = transitionTable.get(currentCharacter);
            //inputState = charStates.get(inputState);
            if(null==inputState){
                throw new UnsupportedOperationException("Input string does not fit regex");
            }
        }

    }
    private void processInsideBrackets(String substring, boolean isEnd) {
        System.out.println("processing string: "+substring);
        if(substring.length()<=2){
            return;
        }

        for(int i=0;i<substring.length();i++){

            Character currentChar = substring.charAt(i);
            System.out.println("Processing symbol: "+currentChar);
            //transitionTable.put(substring.charAt(0),statesMap);
        }
    }

    boolean checkInputRegex(String input){
        for(int i=0;i<input.length();i++){
            if(alphabet.indexOf(input.charAt(i))<0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isCorrectString(String input){
//        States currentState = States.STATE_INITIAL;
//        for (int i=0;i<input.length();i++){
//            char currentChar = input.charAt(i);
//            currentState = move(currentState, currentChar);
//            if(currentState==States.STATE_ACCEPTANCE){
//                return true;
//            }
//        }
        return false;
    }

    private String move(String currentState, final char currentChar) {

        return "d";
    }


}
