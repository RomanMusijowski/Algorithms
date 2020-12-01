package algs.leet;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.solve(1534236469));
    }

    public int solve(int number) {
        String string = String.valueOf(number);
        StringBuilder buffer = new StringBuilder();
        for (int i = string.length()-1; i >= 0; i--) {
            if (string.charAt(i) == '-') {
                buffer.insert(0, string.charAt(i));
                continue;
            }

            buffer.append(string.charAt(i) - '0');
        }
        try {
            return Integer.parseInt(buffer.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
