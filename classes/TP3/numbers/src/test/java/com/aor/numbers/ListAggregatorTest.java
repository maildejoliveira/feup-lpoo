package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private final List<Integer> list = new ArrayList<>();

    @BeforeEach
    private void helper(){
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263(){
        List<Integer> l = new ArrayList<>();
        l.add(-1);
        l.add(-4);
        l.add(-5);

        ListAggregator aggregator = new ListAggregator(l);
        int max = aggregator.max();

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new ListDeduplicator(list));

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726(){
        List<Integer> l = Arrays.asList(1,2,4,2);

        IListDeduplicator stubIListDeduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(stubIListDeduplicator.deduplicate(Mockito.any())).thenReturn(Arrays.asList(1,2,4));

        /*class StubIListDeduplicator implements IListDeduplicator{
            @Override
            public List<Integer> deduplicate(IListSorter iListSorter) {
                List<Integer> l = Arrays.asList(1,2,4);
                return l;
            }
        }*/

        ListAggregator aggregator = new ListAggregator(l);
        //int distinct = aggregator.distinct(new StubIListDeduplicator());
        int distinct = aggregator.distinct(stubIListDeduplicator);

        Assertions.assertEquals(3, distinct);
    }

}
