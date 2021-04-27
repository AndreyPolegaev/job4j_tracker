package ru.job4j.function.streamapi;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DataflatTest {

    @Test
    public void testFlat() {
        Integer[][] data = {
                           {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> rsl = Dataflat.execute(data);
        assertThat(expected, is(rsl));
    }
}