package utils;

import java.util.Scanner;

public class scannerUtil {

    private static final Scanner sc = new Scanner(System.in);

    private scannerUtil(){}

    public static String nextLine(){
        return sc.nextLine();
    }

    public static int nextInt(){
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static double nextDouble(){
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    public static char nextChar(){
        String input = sc.nextLine().trim();
        if (input.isEmpty()){
            return ' ';
        }
        return input.charAt(0);
    }
}
