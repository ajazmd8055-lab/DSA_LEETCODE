class Solution {

    public boolean sumGame(String num) {

        int first = 0;
        int second = 0;

        int firstQuestion = 0;
        int secondQuestion = 0;

        int n = num.length();

        for (int i = 0; i < n / 2; i++) {

            if (num.charAt(i) == '?') {
                firstQuestion++;
            } 
            else {
                first += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {

            if (num.charAt(i) == '?') {
                secondQuestion++;
            } 
            else {
                second += num.charAt(i) - '0';
            }
        }

        
        if ((firstQuestion + secondQuestion) % 2 != 0) {
            return true;
        }

        return 2 * (first - second) !=
               9 * (secondQuestion - firstQuestion);
    }
}