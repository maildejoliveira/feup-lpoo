package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void accept() {
        boolean expected = true;
        IListFilter divisibleByFilter = new DivisibleByFilter(2);
        boolean accepted = divisibleByFilter.accept(6);

        Assertions.assertEquals(expected, accepted);
    }
}
