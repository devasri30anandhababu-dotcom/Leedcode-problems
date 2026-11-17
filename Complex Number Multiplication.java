class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int plusPos1 = num1.indexOf('+');
        int r1 = Integer.parseInt(num1.substring(0, plusPos1));
        int i1 = Integer.parseInt(num1.substring(plusPos1 + 1, num1.length() - 1));

        int plusPos2 = num2.indexOf('+');
        int r2 = Integer.parseInt(num2.substring(0, plusPos2));
        int i2 = Integer.parseInt(num2.substring(plusPos2 + 1, num2.length() - 1));

        int realPart = r1 * r2 - i1 * i2;
        int imagPart = r1 * i2 + r2 * i1;

        return realPart + "+" + imagPart + "i";
    }
}
