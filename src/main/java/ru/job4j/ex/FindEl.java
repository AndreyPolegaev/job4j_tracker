package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int index = -1;
        for (int i = 0; i < value.length; i++) {
            String search = value[i];
            if (search.equals(key)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ElementNotFoundException("This key wasn't found in array");
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        String[] data = new String[] {"aa", "bb", "WORD"};
        try {
            System.out.println(indexOf(data, "WORD"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
