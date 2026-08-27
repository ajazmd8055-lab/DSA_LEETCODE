class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        int i = 0;

        // Match target characters
        while (i < s.length() && count[target.charAt(i) - 'a'] > 0) {

            char c = target.charAt(i);

            prefix.append(c);
            count[c - 'a']--;

            i++;
        }

        // IMPORTANT: start from the last possible position
        for (int pos = Math.min(i, s.length() - 1); pos >= 0; pos--) {

            // If prefix is longer than pos, restore last character
            while (prefix.length() > pos) {

                char removed = prefix.charAt(prefix.length() - 1);

                count[removed - 'a']++;
                prefix.deleteCharAt(prefix.length() - 1);
            }

            int targetChar = target.charAt(pos) - 'a';

            // Find smallest available character greater than target[pos]
            for (int j = targetChar + 1; j < 26; j++) {

                if (count[j] > 0) {

                    StringBuilder ans = new StringBuilder(prefix);

                    ans.append((char) ('a' + j));
                    count[j]--;

                    // Add remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {

                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}