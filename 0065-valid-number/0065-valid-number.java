
class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Check digit
            if (ch >= '0' && ch <= '9') {
                digitSeen = true;
            }

            // Check decimal point
            else if (ch == '.') {

                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Check exponent
            else if (ch == 'e' || ch == 'E') {

                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;
                digitSeen = false;
            }

            // Check plus or minus sign
            else if (ch == '+' || ch == '-') {

                if (i > 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Invalid character
            else {
                return false;
            }
        }

        return digitSeen;
    }
}
