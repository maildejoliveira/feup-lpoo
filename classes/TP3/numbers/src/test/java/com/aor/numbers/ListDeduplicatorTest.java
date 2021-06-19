package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list = new ArrayList<>();

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
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726() {
        List<Integer> tobededuplicated = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        IListSorter stubIListSorter = Mockito.mock(IListSorter.class);
        Mockito.when(stubIListSorter.sort()).thenReturn(Arrays.asList(1,2,2,4));

        /*class StubIListSort implements IListSorter{
            @Override
            public List<Integer> sort() {
                List<Integer> l = Arrays.asList(1,2,2,4);
                return l;
            }
        }*/

        ListDeduplicator deduplicator = new ListDeduplicator(tobededuplicated);
        //using stubs
        //List<Integer> distinct = deduplicator.deduplicate(new StubIListSort());
        //using mockito
        List<Integer> distinct = deduplicator.deduplicate(stubIListSorter);

        Assertions.assertEquals(expected, distinct);
    }
}
