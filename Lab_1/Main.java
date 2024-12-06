public class Main {
    // task 1
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
    // task 2
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return (aSmile && bSmile) || (!aSmile && !bSmile);
    }
    // task 3
    public int sumDouble(int a, int b) {
        return (a == b) ? 2 * (a + b) : a + b;
    }
    // task 4
    public int diff21(int n) {
        return (n > 21) ? 2 * Math.abs(n - 21) : Math.abs(n - 21);
    }
    // task 5
    public boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }
    // task 6
    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || (a + b == 10);
    }
    // task 7
    public boolean nearHundred(int n) {
        return Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10;
    }
    // task 8
    public boolean posNeg(int a, int b, boolean negative) {
        return negative ? (a < 0 && b < 0) : (a < 0 && b > 0) || (a > 0 && b < 0);
    }
    // task 9
    public String notString(String str) {
        return str.startsWith("not") ? str : "not " + str;
    }
    // task 10
    public String missingChar(String str, int n) {
        return str.substring(0, n) + str.substring(n + 1);
    }
    // task 11
    public String frontBack(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String middle = str.substring(1, str.length() - 1);
        return str.charAt(str.length() - 1) + middle + str.charAt(0);
    }
    // task 12
    public String front3(String str) {
        String front = str.length() < 3 ? str : str.substring(0, 3);
        return front + front + front;
    }    
    // task 13
    public String backAround(String str) {
        char lastChar = str.charAt(str.length() - 1);
        return lastChar + str + lastChar;
    }    
    // task 14
    public boolean or35(int n) {
        return n % 3 == 0 || n % 5 == 0;
    }    
    // task 15
    public String front22(String str) {
        String front = str.length() < 2 ? str : str.substring(0, 2);
        return front + str + front;
    }    
}
