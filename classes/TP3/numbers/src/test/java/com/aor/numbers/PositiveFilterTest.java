package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    public void accept_pos() {
        boolean expected = true;
        IListFilter positiveFilter = new PositiveFilter();
        boolean accepted = positiveFilter.accept(2);

        Assertions.assertEquals(expected, accepted);
    }

    @Test
    public void accept_neg() {
        boolean expected = false;
        IListFilter positiveFilter = new PositiveFilter();
        boolean accepted = positiveFilter.accept(-2);

        Assertions.assertEquals(expected, accepted);
    }

    @Test
    public void accept_zero() {
        boolean expected = true;
        IListFilter positiveFilter = new PositiveFilter();
        boolean accepted = positiveFilter.accept(0);

        Assertions.assertEquals(expected, accepted);
    }
}
