package algs.learnCollection;

public class TestMyList {
    public static void main(String[] args) {
        MyArrayListImplementation<String> strings = new MyArrayListImplementation();
        strings.add("1");
        strings.add("2");
        strings.add("3");


        System.out.println(strings.toString());

    }
}
