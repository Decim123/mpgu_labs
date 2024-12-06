package Lab_4;

public class Main {
    //String 2
    //task 1
    public String doubleChar(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.append(c).append(c);
        }
        return result.toString();
    }
    //task 2
    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                count++;
            }
        }
        return count;
    }    
    //task 3
    public boolean catDog(String str) {
        int catCount = 0;
        int dogCount = 0;
        
        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i, i + 3);
            if (sub.equals("cat")) {
                catCount++;
            } else if (sub.equals("dog")) {
                dogCount++;
            }
        }
        
        return catCount == dogCount;
    }    
    //task 4
    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e') {
                count++;
            }
        }
        return count;
    }    
    //task 5
    public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
    
        if (a.endsWith(b) || b.endsWith(a)) {
            return true;
        }
        return false;
    }    
    //task 6
    public boolean xyzThere(String str) {
        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                if (i == 0 || str.charAt(i - 1) != '.') {
                    return true;
                }
            }
        }
        return false;
    }    
    //task 7
    public boolean bobThere(String str) {
        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                return true;
            }
        }
        return false;
    }    
}
