/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review;

import java.io.*;

public class Review {

    static InputStreamReader in = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(in);

    /**
     * Main method
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int k = 0;
        String num = "";

        do {
            System.out.print("Choose which type of recursion you want to test: \nPress 1 for String and 2 for int ");
            num = input.readLine();
            System.out.println(num);
        } while (!num.equals("1") && !num.equals("2"));

        k = Integer.parseInt(num);

        if (k == 1) {
            Strings();
        } else {
            Ints();
        }
    }

    /**
     * Navigation for various methods involving strings
     *
     * @throws IOException
     */
    public static void Strings() throws IOException {
        String str = "", sub = "";
        int num = 0, n = 0;
        System.out.print("Enter string:");
        str = input.readLine();

        System.out.print("Do you want to enter a substring? Press 1 for yes 2 for no ");
        num = Integer.parseInt(input.readLine());
        if (num == 1) {
            System.out.print("Enter your substring ");
            sub = input.readLine();

            System.out.println("Which method would you like to run? \n1 for strCount \n2 for strDist \n3 for strCopies");
            int ch = Integer.parseInt(input.readLine());
            if (ch == 1) {
                System.out.print(strCount(str, sub));
            } else if (ch == 2) {
                System.out.println(strDist(str, sub));
            } else if (ch == 3) {
                System.out.print("Enter a number");
                n = Integer.parseInt(input.readLine());
                System.out.println(strCopies(str, sub, n));
            }
        } else {
            System.out.println("Which method would you like to run? \n1 strCount \n2 Countx \n3 ChangePi \n4 CountHi \n5 ChangeXY \n6 noX \n7 stringClean"
                    + "\n8 pairStar \n9 countPairs \n10 endX \n11 countAbc \n12 count11 \n13 parenBit \n14 nestParen");
            int nu = Integer.parseInt(input.readLine());
            if (nu == 1) {
                System.out.print(strCount(str, sub));
            } else if (nu == 2) {
                System.out.println(Countx(str));
            } else if (nu == 3) {
                System.out.println(ChangePi(str));
            } else if (nu == 4) {
                System.out.println(CountHi(str));
            } else if (nu == 5) {
                System.out.println(ChangeXY(str));
            } else if (nu == 6) {
                System.out.println(noX(str));
            } else if (nu == 7) {
                System.out.println(stringClean(str));
            } else if (nu == 8) {
                System.out.println(pairStar(str));
            } else if (nu == 9) {
                System.out.println(countPairs(str));
            } else if (nu == 10) {
                System.out.println(endX(str));
            } else if (nu == 11) {
                System.out.println(countAbc(str));
            } else if (nu == 12) {
                System.out.println(count11(str));
            } else if (nu == 13) {
                System.out.println(parenBit(str));
            } else if (nu == 14) {
                System.out.println(nestParen(str));
            }
        }
    }

    /**
     * Navigation for various methods involving integers
     *
     * @throws IOException
     */
    public static void Ints() throws IOException {
        int x = 0, base = 0;
        System.out.print("Please enter int: ");
        x = Integer.parseInt(input.readLine());

        System.out.println("Which method would you like to run? \n1 for PowerN \n2 for Factorial \n3 for Count7 \n4 for Count8");
        int ch = Integer.parseInt(input.readLine());
        if (ch == 1) {
            System.out.print("Please enter a base: ");
            base = Integer.parseInt(input.readLine());
            System.out.println(PowerN(base, x));
        } else if (ch == 2) {
            System.out.println(Factorial(x));
        } else if (ch == 3) {
            System.out.println(Count7(x));
        } else if (ch == 4) {
            System.out.println(Count8(x));
        }
    }

    /**
     * compute the value of base to the x power
     *
     * @param base
     * @param x
     * @return
     */
    public static int PowerN(int base, int x) {
        if (x == 0) {
            return 1;
        }

        return base * PowerN(base, x - 1);
    }

    /**
     * return the factorial of x
     *
     * @param x
     * @return
     */
    public static int Factorial(int x) {
        if (x == 1) {
            return 1;
        }

        return x * Factorial(x - 1);
    }

    /**
     * return the count of the occurrences of 7
     *
     * @param x
     * @return
     */
    public static int Count7(int x) {
        if (x < 1) {
            return x;
        }

        if (x % 10 == 7) {
            return 1 + Count7(x / 10);
        } else {
            return 0 + Count7(x / 10);
        }
    }

    /**
     * return the count of the occurrences of 8 (an 8 with another 8 beside it
     * counts as double)
     *
     * @param x
     * @return
     */
    public static int Count8(int x) {
        if (x < 1) {
            return 0;
        }

        if (x % 100 == 88) {
            return 2 + Count8(x / 10);
        } else if (x % 10 == 8) {
            return 1 + Count8(x / 10);
        } else {
            return Count8(x / 10);
        }
    }

    /**
     * compute the number of lowercase "x" characters in a string
     *
     * @param str
     * @return
     * @throws IOException
     */
    public static int Countx(String str) throws IOException {

        if (str.length() == 0) {
            return 0;
        }

        if (str.substring(0, 1).equals("x")) {
            return 1 + Countx(str.substring(1));
        } else {
            return 0 + Countx(str.substring(1));
        }
    }

    /**
     * compute a new string where all instances of "pi" are replaced with "3.14"
     *
     * @param str
     * @return
     * @throws IOException
     */
    public static String ChangePi(String str) throws IOException {
        if (str.length() <= 1) {
            return str;
        }

        if (str.substring(0, 2).equals("pi")) {
            return "3.14" + ChangePi(str.substring(2));
        } else {
            return str.charAt(0) + ChangePi(str.substring(1));
        }
    }

    /**
     * count the number of instances "Hi" appears in a given string
     *
     * @param str
     * @return
     */
    public static int CountHi(String str) {
        if (str.length() <= 1) {
            return 0;
        }

        if (str.substring(0, 2).equals("hi")) {
            return 1 + CountHi(str.substring(2));
        }

        return 0 + CountHi(str.substring(1));
    }

    /**
     * switch every x with a y
     *
     * @param str
     * @return
     */
    public static String ChangeXY(String str) {
        if (str.length() == 0) {
            return str;
        }

        if (str.substring(0, 1).equals("x")) {
            return "y" + ChangeXY(str.substring(1));
        } else {
            return str.substring(0, 1) + ChangeXY(str.substring(1));
        }
    }

    /**
     * remove all the "x" characters in a given string
     *
     * @param str
     * @return
     */
    public static String noX(String str) {
        if (str.length() == 0) {
            return str;
        }

        if (str.substring(0, 1).equals("x")) {
            return "" + noX(str.substring(1));
        } else {
            return str.substring(0, 1) + noX(str.substring(1));
        }
    }

    /**
     * return a string in which each character is only displayed once
     *
     * @param str
     * @return
     */
    public static String stringClean(String str) {
        if (str.length() < 2) {
            return str;
        }

        if (str.substring(0, 1).equals(str.substring(1, 2))) {
            return stringClean(str.substring(1));
        } else {
            return str.substring(0, 1) + stringClean(str.substring(1));
        }
    }

    /**
     * all identical adjacent characters are separated by a "*"
     *
     * @param str
     * @return
     */
    public static String pairStar(String str) {
        if (str.length() < 2) {
            return str;
        }

        if (str.substring(0, 1).equals(str.substring(1, 2))) {
            return str.substring(0, 1) + "*" + pairStar(str.substring(1));
        } else {
            return str.substring(0, 1) + pairStar(str.substring(1));
        }
    }

    /**
     * count the number of pairs in a given string
     *
     * @param str
     * @return
     */
    public static int countPairs(String str) {
        if (str.length() < 3) {
            return 0;
        }

        if (str.substring(0, 1).equals(str.substring(2, 3))) {
            return 1 + countPairs(str.substring(1));
        } else {
            return countPairs(str.substring(1));
        }
    }

    /**
     * return a string where all lowercase "x" characters are moved to the end
     * of the string
     *
     * @param str
     * @return
     */
    public static String endX(String str) {
        if (str.length() < 1) {
            return str;
        }

        if (str.substring(0, 1).equals("x")) {
            return endX(str.substring(1)) + "x";
        } else {
            return str.substring(0, 1) + endX(str.substring(1));
        }
    }

    /**
     * count the number of "abc" and "aba" substrings in a given string
     *
     * @param str
     * @return
     */
    public static int countAbc(String str) {
        if (str.length() < 3) {
            return 0;
        }
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) {
            return 1 + countAbc(str.substring(1));
        } else {
            return countAbc(str.substring(1));
        }
    }

    /**
     * count the number of "11" substrings in a string
     *
     * @param str
     * @return
     */
    public static int count11(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.substring(0, 2).equals("11")) {
            return 1 + count11(str.substring(2));
        } else {
            return count11(str.substring(1));
        }
    }

    /**
     * compute a new string which only contains the parenthesis and whatever is
     * inside it
     *
     * @param str
     * @return
     */
    public static String parenBit(String str) {
        if (str.length() == 0) {
            return str;
        }

        if (str.substring(0, 1).equals("(")) {
            if (str.substring(str.length() - 1, str.length()).equals(")")) {
                return str;
            } else {
                return parenBit(str.substring(0, str.length() - 1));
            }

        } else {
            return parenBit(str.substring(1));
        }
    }

    /**
     * return true if a string is a nesting of zero or more pairs of parenthesis
     *
     * @param str
     * @return
     */
    public static boolean nestParen(String str) {
        if (str.length() == 0) {
            return true;
        }

        if (str.substring(0, 1).equals("(")
                && str.substring(str.length() - 1, str.length()).equals(")")) {
            return nestParen(str.substring(1, str.length() - 1));

        } else {
            return false;
        }
    }

    /**
     * return the number of times that the sub appears in the string
     *
     * @param str
     * @param sub
     * @return
     */
    public static int strCount(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        if (str.substring(0, sub.length()).equals(sub)) {
            return 1 + strCount(str.substring(sub.length()), sub);
        } else {
            return 0 + strCount(str.substring(1), sub);
        }
    }

    /**
     * return true if at least n copies of a sub appear in the string (w/
     * overlapping)
     *
     * @param str
     * @param sub
     * @param n
     * @return
     */
    public static boolean strCopies(String str, String sub, int n) {
        if (check(str, sub) == n) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return the number of times sub appears in str
     *
     * @param str
     * @param sub
     * @return
     */
    public static int check(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        if (str.substring(0, sub.length()).equals(sub)) {
            return 1 + check(str.substring(1), sub);
        } else {
            return 0 + check(str.substring(1), sub);
        }
    }

    /**
     * compute the largest substring which starts and ends with sub and return
     * length
     *
     * @param str
     * @param sub
     * @return
     */
    public static int strDist(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }

        if (str.substring(0, sub.length()).equals(sub)
                && str.substring(str.length() - sub.length()).equals(sub)) {
            return str.length();
        }

        if (!str.substring(0, sub.length()).equals(sub)) {
            return strDist(str.substring(1), sub);
        } else {
            return strDist(str.substring(0, str.length() - 1), sub);
        }
    }
}
