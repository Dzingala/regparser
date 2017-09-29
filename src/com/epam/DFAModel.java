package com.epam;

import com.epam.DFAImpl.States;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Ivan_Dzinhala on 9/26/2017.
 */
public class DFAModel implements DFA{

    private String alphabet="abcdefghijklmnopqrstuvwxyz()|*+";

    private HashMap<Character,TreeMap<States,States>> transitionTable;
    DFAModel(){
        transitionTable = new HashMap<>();
        TreeMap<States, States> statesFromTo = new TreeMap<>();
        for(int i = 0; i < alphabet.length(); i++){
            alphabet.charAt(i);
        }
    }

    public void parseInputText(String input){
        transitionTable = new HashMap<>();
        for(int i = 0 ; i < input.length() ; i++){
            Character currentChar = input.charAt(i);

            if(currentChar =='('){
                int j = i;
                for(;currentChar!=')';j++){
                    currentChar = input.charAt(j);
                    if(j>input.length())throw new IllegalArgumentException("Wrong string input");
                }
                processInsideBrackets(input.substring(i+1,j-1));
            }
        }
    }

    private void processInsideBrackets(String substring) {

    }

    boolean checkInputRegex(String input){
        boolean isInAlphabet = false;
        for(int i=0;i<input.length();i++){
            char currentChar = input.charAt(i);
            for(int j=0;j<alphabet.length();j++){
                if(alphabet.charAt(j)==currentChar){
                    isInAlphabet=true;
                    break;
                }
            }
        }
        return isInAlphabet;
    }

    @Override
    public boolean isCorrectString(String input){
        States currentState = States.STATE_INITIAL;
        for (int i=0;i<input.length();i++){
            char currentChar = input.charAt(i);
            currentState = move(currentState, currentChar);
            if(currentState==States.STATE_ACCEPTANCE){
                return true;
            }
        }
        return false;
    }

    private States move(States state, final char currentChar) {
        switch(state){
            case STATE_INITIAL:{
                switch (currentChar){
                    case 'a':
                        return States.STATE_A;
                    case 'c':
                        return States.STATE_C;
                    default:
                        return States.STATE_INITIAL;
                }
            }
            case STATE_A:{
                switch(currentChar){
                    case 'b':
                        return States.STATE_ACCEPTANCE;
                    default:
                        return States.STATE_INITIAL;
                }
            }
            case STATE_C:{
                switch(currentChar){
                    case 'd':
                        return States.STATE_ACCEPTANCE;
                    default:
                        return States.STATE_INITIAL;
                }
            }

        }
        return state;
    }


}
