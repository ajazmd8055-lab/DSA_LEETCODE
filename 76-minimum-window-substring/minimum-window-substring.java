class Solution {

    public String minWindow(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Expand the window using right
        for (; right < s.length(); right++) {

            // Add current character to window
            mapS[s.charAt(right)]++;

            // If current window contains all characters of t
            while (contains(mapS, mapT)) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove left character and move left forward
                mapS[s.charAt(left++)]--;
            }
        }

        // If no valid window was found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        // Return minimum window
        return s.substring(minStart, minStart + minLen);
    }


    private boolean contains(int[] mapS, int[] mapT) {

        for (int i = 0; i < 256; i++) {

            // We need more of this character
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }
}