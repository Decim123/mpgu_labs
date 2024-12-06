package Lab_3;

public class Main {
    // Array-1
    //task 1
    public boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length - 1] == 6;
    }
    //task 2
    public boolean sameFirstLast(int[] nums) {
        if (nums.length >= 1) {
            return nums[0] == nums[nums.length - 1];
        }
        return false;
    }
    //task 3
    public int[] makePi() {
        return new int[] {3, 1, 4};
    }
    //task 4
    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }
    // task 5
    public int sum3(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }
    //task 6
    public int[] rotateLeft3(int[] nums) {
        return new int[] {nums[1], nums[2], nums[0]};
    }
    //task 7
    public int[] reverse3(int[] nums) {
        return new int[] {nums[2], nums[1], nums[0]};
    }    
    //task 8
    public int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[nums.length - 1]);
        return new int[] {max, max, max};
    }    
    //task 9
    public int sum2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return nums[0] + nums[1];
        }
    }    
    //task 10
    public int[] middleWay(int[] a, int[] b) {
        return new int[] {a[1], b[1]};
    }    
    //String 1
    //task 1
    public String helloName(String name) {
        return "Hello " + name + "!";
    }    
    //task 2
    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }
    //task 3
    public String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }    
    //task 4
    public String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }    
    //task 5
    public String extraEnd(String str) {
        String lastTwoChars = str.substring(str.length() - 2);
        return lastTwoChars + lastTwoChars + lastTwoChars;
    }    
    //task 6
    public String firstTwo(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(0, 2);
        }
    }    
    //task 7
    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }    
    //task 8
    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }    
    //task 9
    public String comboString(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        } else {
            return b + a + b;
        }
    }    
    //task 10
    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }    
}
