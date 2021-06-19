package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    List<Integer> list = new ArrayList<>();

    @BeforeEach
    private void helper(){
        list.clear();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
    }

    @Test
    public void filter_divisible() {
        List<Integer> expected = new ArrayList();
        expected.add(2);
        expected.add(6);
        expected.add(4);

        ListFilterer filterer = new ListFilterer(list);
        List<Integer> filtered = filterer.filter(new DivisibleByFilter(2));

        Assertions.assertEquals(expected, filtered);
    }

    @Test
    public void filter_positive() {
        List<Integer> l = Arrays.asList(1,-1,2,-3);
        List<Integer> expected = Arrays.asList(1,2);

        ListFilterer filterer = new ListFilterer(l);
        List<Integer> filtered = filterer.filter(new PositiveFilter());

        Assertions.assertEquals(expected, filtered);
    }
}
