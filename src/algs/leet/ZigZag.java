package algs.leet;

public class ZigZag {
    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (s == null) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int step = 2 * numRows - 2;
        if (numRows == 1) {
            step = 1;
        }

        for (int main = 0; main < numRows; main++) {
            if ((main == 0) || main==numRows-1) {
                for (int i = main; i < s.length(); i=i+step) {
                    builder.append(s.charAt(i));
                }
            }else{
                int j = main;
                boolean flip = true;
                int step1 = 2 * (numRows - main - 1);
                int step2 = step - step1;

                while (j < s.length()) {
                    builder.append(s.charAt(j));
                    if (flip) {
                        j = j + step1;
                    }else {
                        j = j + step2;
                    }
                    flip = !flip;
                }
            }
        }
        return builder.toString();
    }
}
