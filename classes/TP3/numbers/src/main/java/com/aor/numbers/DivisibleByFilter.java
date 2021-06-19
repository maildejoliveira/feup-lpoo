package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    private Integer n;
    public DivisibleByFilter(Integer n){
        this.n=n;
    }

    @Override
    public boolean accept(Integer number) {
        if(number%n==0) return true;
        return false;
    }
}
