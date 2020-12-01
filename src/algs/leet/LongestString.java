package algs.leet;

public class LongestString {

    public static void main(String[] args) {
        LongestString string = new LongestString();
        System.out.println(string.lengthOfLongestSubstring("geeksforgeeks"));
    }

    public int lengthOfLongestSubstring(String str) {
        int l = str.length();
        int sum = 0;

        for (int i = 0; i < l; i++) {
            boolean[] visited = new boolean[50000];
            for (int j = i; j < l; j++) {
                if (visited[str.charAt(j)] == true) {
                    break;
                }else {
                    sum = Math.max(sum, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return sum;
    }
}
