package algs.learnCollection;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;
import java.util.stream.Collectors;

public class LearnList {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<String> toRemove = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add(null);
        strings.add(null);

        System.out.println(strings);

        // JUST test
//        ListIterator<String> listIterator = strings.listIterator();
//        while (listIterator.hasNext()) {
//            listIterator.next();
//            listIterator.remove();
//        }

//        WITHOUT iterator.next() throw exception
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//
////            iterator.next();
//            iterator.remove();
//        }



//          THROW ConcurrentModificationException
//        for (String string : strings) {
//            strings.remove(1);
//        }



        // HOW TO REMOVE WITH VALUE CHECK
//        for (Iterator<String> intr = strings.iterator(); intr.hasNext();) {
//            String next = intr.next();
//            if ( next != null && next.equals("3")) {
//                intr.remove();
//            }
//        }


//        removeAll test
//        for (String string : strings) {
//            if ( string != null && string.equals("3")) {
//                toRemove.add(string);
//            }
//        }
//        strings.removeAll(toRemove);


//        removeIf test
//        strings.removeIf(value -> value != null && value.equals("3"));


//        Remove with stream
//        List<String> collect = strings.stream()
//                .filter(Objects::nonNull)
//                .filter(v -> !v.equals("3"))
//                .collect(Collectors.toList());
//        System.out.println(collect);

        System.out.println(strings);
    }
}
