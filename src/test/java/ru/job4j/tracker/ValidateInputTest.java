package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        Input input = new ValidateInput(out, in);
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Please enter validate data again." + System.lineSeparator()
        ));
    }

    @Test
    public void whenRightInput() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        /* Добавили новую заявку */
        Item item = new Item("new Item");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        Input input = new ValidateInput(out, in);
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Delete Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Удалено успешно" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Delete Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenSeveralRightInput() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "newItem",  "1"}
        );
        Input input = new ValidateInput(out, in);
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Create a new Item ====" + System.lineSeparator() +
                        "Item{id=1, name='newItem'} Добавлено успешно" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenNegativeInput() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1", "1"}
        );
        Input input = new ValidateInput(out, in);
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Wrong input, you can select: 0 .. 1" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

}