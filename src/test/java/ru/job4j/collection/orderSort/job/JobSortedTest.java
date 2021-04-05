package ru.job4j.collection.orderSort.job;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobSortedTest {

    @Test
    public void whenUpByName() {
        List<Job> nameUp = Arrays.asList(
                new Job("Task", 1),
                new Job("Fix", 0)
        );
        Comparator<Job> comparator = new JobUpByName();
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Fix", 0)));
        assertThat(it.next(), is(new Job("Task", 1)));
    }

    @Test
    public void whenUpByPriority() {
        List<Job> nameUp = Arrays.asList(
                new Job("Task", 1),
                new Job("Fix", 2)
        );
        Comparator<Job> comparator = new JobUpByPriority();
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Task", 1)));
        assertThat(it.next(), is(new Job("Fix", 2)));
    }

    @Test
    public void whenDestByName() {
        List<Job> nameUp = Arrays.asList(
                new Job("Job4j", 1),
                new Job("Ru", 2)
        );
        Comparator<Job> comparator = new JobDescByName();
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Ru", 2)));
        assertThat(it.next(), is(new Job("Job4j", 1)));
    }

    @Test
    public void whenDestByNameLn() {
        List<Job> nameUp = Arrays.asList(
                new Job("Job4j", 1),
                new Job("Ru", 2)
        );
        Comparator<Job> comparator = new JobDescByNameLn();
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Job4j", 1)));
        assertThat(it.next(), is(new Job("Ru", 2)));
    }

    @Test
    public void whenDescByPriority() {
        List<Job> nameUp = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix", 1)
        );
        Comparator<Job> comparator = new JobDescByPriority();
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Fix", 1)));
        assertThat(it.next(), is(new Job("Task", 0)));
    }

    @Test
    public void whenComparatorByNameUpAndPriorityUp() {
        List<Job> nameUp = Arrays.asList(
                new Job("Task", 0),
                new Job("Task", 1),
                new Job("Relax", 1),
                new Job("Task", 2),
                new Job("Task", 3)
        );
        Comparator<Job> comparator = new JobUpByName().thenComparing(new JobUpByPriority());
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Relax", 1)));
        assertThat(it.next(), is(new Job("Task", 0)));
        assertThat(it.next(), is(new Job("Task", 1)));
        assertThat(it.next(), is(new Job("Task", 2)));
        assertThat(it.next(), is(new Job("Task", 3)));
    }

    @Test
    public void whenComparatorByNameUpAndPriorityDesc() {
        List<Job> nameUp = Arrays.asList(
                new Job("Task", 0),
                new Job("Task", 1),
                new Job("Relax", 1),
                new Job("Task", 2),
                new Job("Task", 3)
        );
        Comparator<Job> comparator = new JobUpByName().thenComparing(new JobDescByPriority());
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Relax", 1)));
        assertThat(it.next(), is(new Job("Task", 3)));
        assertThat(it.next(), is(new Job("Task", 2)));
        assertThat(it.next(), is(new Job("Task", 1)));
        assertThat(it.next(), is(new Job("Task", 0)));
    }

    @Test
    public void whenComparatorByNameLnAndPriorityUp() {
        List<Job> nameUp = Arrays.asList(
                new Job("Wake up and start working", 0),
                new Job("Read a book", 1),
                new Job("Read a book", 2),
                new Job("Relax", 1),
                new Job("Task", 2)
        );
        Comparator<Job> comparator = new JobDescByNameLn().thenComparing(new JobUpByPriority());
        Collections.sort(nameUp, comparator);
        Iterator<Job> it = nameUp.iterator();
        assertThat(it.next(), is(new Job("Wake up and start working", 0)));
        assertThat(it.next(), is(new Job("Read a book", 1)));
        assertThat(it.next(), is(new Job("Read a book", 2)));
        assertThat(it.next(), is(new Job("Relax", 1)));
        assertThat(it.next(), is(new Job("Task", 2)));
    }

    @Test
    public void testComparator() {
        Comparator<Job> comparator = new JobUpByPriority().thenComparing(new JobUpByName());
        int rsl = comparator.compare(
          new Job("Task", 0),
          new Job("TaskNew", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
