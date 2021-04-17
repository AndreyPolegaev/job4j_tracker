package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;

        String[] leftData = left.split("/");
        String[] rightData = right.split("/");
        int steps = Math.min(leftData.length, rightData.length);
        for (int i = 0; i < steps; i++) {
            if (leftData[i].compareTo(rightData[i]) > 0) {
                rsl = 1;
                break;
            } else if (leftData[i].compareTo(rightData[i]) < 0) {
                rsl = -1;
                break;
            } else if (leftData[i].compareTo(rightData[i]) == 0) {
                rsl = -1;
            }
        }
        return rsl;
    }

}



//package ru.job4j.collection.departments;
//
//        import java.util.Comparator;
//
//public class DepDescComp implements Comparator<String> {
//    @Override
//    public int compare(String left, String right) {
//        int rsl = 0;
//
//        String[] leftData = left.split("/");
//        String[] rightData = right.split("/");
//        int steps = Math.min(leftData[0].length(), rightData[0].length());
//        for (int i = 0; i < steps; i++) {
//            if (leftData[i].compareTo(rightData[i]) > 0) {
//                rsl = -1;
//                break;
//            } else if (leftData[i].compareTo(rightData[i]) < 0) {
//                rsl = 1;
//                break;
//            } else if (leftData[i].compareTo(rightData[i]) == 0) {
//                rsl = 1;
//                continue;
//            } else if (left.length() < right.length()) {
//                rsl = 1;
//            }
//        }
//        return rsl;
//    }
//
//}
