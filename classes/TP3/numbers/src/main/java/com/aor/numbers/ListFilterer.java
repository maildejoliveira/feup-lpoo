package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFilterer {
    private final List<Integer> list;

    public ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter iListFilter) {
        List<Integer> filtered = new ArrayList<>();
        for (int n: list) {
            if(iListFilter.accept(n)){
                filtered.add(n);
            }
        }
        return filtered;
    }
}
