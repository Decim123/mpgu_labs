package Lab_2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1 example

        System.out.println("Task 1:");
        double n1 = 23.5;
        int rounded = roundNumber(n1);
        System.out.println("After rounding: " + rounded);
        System.out.println();

        // Task 2 example
        
        System.out.println("Task 2:");
        double dollars = 12.4;
        convertCurrency(dollars);
        System.out.println();

        // Task 3 example
        
        System.out.println("Task 3:");
        double celsius = 5;
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println("Equivalent in Fahrenheit: " + fahrenheit);
        System.out.println();

        // Task 4 example
        
        System.out.println("Task 4:");
        double initialInvestment = 3000;
        int years = 10;
        double rate = 5.5;
        double finalAmount = calculateInvestment(initialInvestment, years, rate);
        System.out.printf("Through %d years you will receive %.2f dollars.%n", years, finalAmount);
        System.out.println();

        // Task 5 example
        
        System.out.println("Task 5:");
        printEvenNumbers(25, 62);
        System.out.println();

        // Task 6 example
        
        System.out.println("Task 6:");
        int number6 = 2;
        String isEven = checkEven(number6);
        System.out.println(isEven);
        System.out.println();

        // Task 7 example
        
        System.out.println("Task 7:");
        int trips1 = 1;
        int[] tickets1 = calculateTickets(trips1);
        printTickets(tickets1);

        int trips2 = 25;
        int[] tickets2 = calculateTickets(trips2);
        printTickets(tickets2);
        System.out.println();

        // Task 8 example
        
        System.out.println("Task 8:");
        int a1 = 6, b1 = -2;
        solveEquation(a1, b1);
        int a2 = 1, b2 = 1;
        solveEquation(a2, b2);
        int a3 = -1, b3 = 1;
        solveEquation(a3, b3);
        System.out.println();

        // Task 9 example
        
        System.out.println("Task 9:");
        int n9 = 3;
        long factorial = computeFactorial(n9);
        System.out.println("Factorial of " + n9 + " is " + factorial);
        System.out.println();

        // Task 10 example
        
        System.out.println("Task 10:");
        int number10 = 113;
        int sumDigits = sumOfDigits(number10);
        System.out.println("Sum of digits: " + sumDigits);
        System.out.println();

        // Task 11 example
        
        System.out.println("Task 11:");
        int a11 = 2, b11 = 5;
        printEvenBetween(a11, b11);
        System.out.println();

        // Task 12 example
        
        System.out.println("Task 12:");
        int a12 = 2, b12 = 5;
        int max = maxOfTwo(a12, b12);
        System.out.println("Maximum number: " + max);
        System.out.println();

        // Task 13 example
        
        System.out.println("Task 13:");
        int year1 = 2007;
        String leap1 = isLeapYear(year1);
        System.out.println(year1 + " " + leap1);
        int year2 = 2000;
        String leap2 = isLeapYear(year2);
        System.out.println(year2 + " " + leap2);
        System.out.println();

        // Task 14 example
        
        System.out.println("Task 14:");
        int x14 = 179;
        int sign = signFunction(x14);
        System.out.println(sign);
        System.out.println();

        // Task 15 example
        
        System.out.println("Task 15:");
        int a15_1 = 5, b15_1 = 5, c15_1 = 6, d15_1 = 5;
        int[] change1 = calculateChange(a15_1, b15_1, c15_1, d15_1);
        System.out.println(change1[0] + " " + change1[1]);

        int a15_2 = 3, b15_2 = 17, c15_2 = 2, d15_2 = 18;
        int[] change2 = calculateChange(a15_2, b15_2, c15_2, d15_2);
        System.out.println(change2[0] + " " + change2[1]);
        System.out.println();

        // Task 16 example
        
        System.out.println("Task 16:");
        int k1 = 3;
        String canBuy1 = canBuyScoops(k1);
        System.out.println(canBuy1);

        int k2 = 7;
        String canBuy2 = canBuyScoops(k2);
        System.out.println(canBuy2);

        scanner.close();
    }

    // Task 1
    public static int roundNumber(double n) {
        return (int) Math.round(n);
    }

    // Task 2
    public static void convertCurrency(double dollars) {
        double pounds = dollars / 1.487;
        double marks = dollars / 0.584;
        double yens = dollars / 0.00955;
        double francs = dollars / 0.172;
        System.out.printf("You will receive %.3f фунта, %.3f немецкой марки, %.3f йен, %.3f франка.%n", 
                          pounds, marks, yens, francs);
    }

    // Task 3
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Task 4
    public static double calculateInvestment(double principal, int years, double rate) {
        double amount = principal;
        for(int i = 0; i < years; i++) {
            amount += amount * (rate / 100);
        }
        return amount;
    }

    // Task 5
    public static void printEvenNumbers(int start, int end) {
        for(int i = start; i <= end; i++) {
            if(i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Task 6
    public static String checkEven(int number) {
        return (number % 2 == 0) ? "ДА" : "НЕТ";
    }

    // Task 7
    public static int[] calculateTickets(int n) {
        int[] ticketTypes = {60, 20, 10, 5, 1};
        int[] ticketCounts = new int[5];
        int remaining = n;
        
        for(int i = 0; i < ticketTypes.length; i++) {
            ticketCounts[i] = remaining / ticketTypes[i];
            remaining %= ticketTypes[i];
        }

        if(remaining > 0) {
            for(int i = 0; i < ticketTypes.length; i++) {
                if(ticketTypes[i] >= remaining) {
                    ticketCounts[i]++;
                    break;
                }
            }
        }

        return ticketCounts;
    }

    public static void printTickets(int[] tickets) {
        for(int count : tickets) {
            System.out.print(count + " ");
        }
        System.out.println();
    }

    // Task 8
    public static void solveEquation(int a, int b) {
        if(a == 0) {
            if(b == 0) {
                System.out.println("INF");
            } else {
                System.out.println("NO");
            }
        } else {
            double x = -((double)b) / a;
            if(x == (int)x) {
                System.out.println((int)x);
            } else {
                System.out.println("NO");
            }
        }
    }

    // Task 9
    public static long computeFactorial(int n) {
        long factorial = 1;
        for(int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Task 10
    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /=10;
        }
        return sum;
    }

    // Task 11
    public static void printEvenBetween(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = a; i <= b; i++) {
            if(i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Task 12
    public static int maxOfTwo(int a, int b) {
        return Math.max(a, b);
    }

    // Task 13
    public static String isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 !=0) || (year % 400 ==0)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    // Task 14
    public static int signFunction(int x) {
        if(x > 0) return 1;
        if(x < 0) return -1;
        return 0;
    }

    // Task 15
    public static int[] calculateChange(int a, int b, int c, int d) {
        int price = a * 100 + b;
        int paid = c * 100 + d;
        int change = paid - price;
        if(change < 0) {
            return new int[]{-1, -1};
        }
        int rubles = change / 100;
        int kopeks = change % 100;
        return new int[]{rubles, kopeks};
    }

    // Task 16
    public static String canBuyScoops(int k) {
        for(int i = 0; i * 3 <= k; i++) {
            for(int j = 0; j * 5 <= k; j++) {
                if(i * 3 + j * 5 == k) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
