package com.g56.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int currOption;

    public Menu() {
        //NOTE: Exit may always be the last element on the array
        options = Arrays.asList("START", "EXIT");
        this.currOption = 0;
    }

    public void nextOption(){
        currOption++;
        if(currOption==options.size()){
            currOption=options.size()-1;
        }
    }

    public void previousOption(){
        currOption--;
        if(currOption < 0){
            currOption=0;
        }
    }

    public String getOption(int option){
        if(option < options.size() && option >= 0) return options.get(option);
        return "";
    }

    public int getNumberOptions(){
        return options.size();
    }

    public boolean isStartSelected(){
        return currOption == 0;
    }

    public boolean isCreditsSelected(){
        return currOption == 1;
    }

    public boolean isExitSelected(){
        return currOption == options.size()-1;
    }

    public int getCurrOption() {
        return currOption;
    }
}
