package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

//    @Test
//    public void whenAddItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        assertThat(created.getName(),is(expected.getName()));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
//                "replaced item"
//        };
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(),is("replaced item"));
//    }
//
//    @Test
//    public void whenDeleteItemThenNull() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("FirstItem");
//        tracker.add(item);
//        String[] answers = {String.valueOf(item.getId())};
//        StartUI.deteleItem(new StubInput(answers), tracker);
//        Item deleted = tracker.findById(item.getId());
//        assertThat(deleted,is(nullValue()));
//    }

//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }

//    @Test
//    public void whenReplaceItemNew() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Replaced item"));
//        int id = item.getId();
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(id), replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceItem(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Deleted item"));
//        int id = item.getId();
//        Input in = new StubInput(
//                new String[] {"0", Integer.toString(id), "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll(){
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item); /* добавили новую заявку в трекер */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllItems(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show All Items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show All Items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName(){
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item); /* добавили новую заявку в трекер */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "new Item", "1"}
        );
        UserAction[] actions = {
                new FindItemByName(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. FindItemByName" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. FindItemByName" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByID(){
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item); /* добавили новую заявку в трекер */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindById(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }
}