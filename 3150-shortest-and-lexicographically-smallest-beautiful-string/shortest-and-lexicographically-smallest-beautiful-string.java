class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == '1') {
                    count++;
                }

                if (count == k) {

                    String current = s.substring(i, j + 1);

                    if (ans.equals("") ||
                        current.length() < ans.length() ||
                        (current.length() == ans.length() &&
                         current.compareTo(ans) < 0)) {

                        ans = current;
                    }

                    break;
                }

                if (count > k) {
                    break;
                }
            }
        }

        return ans;
    }
}