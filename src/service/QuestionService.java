package service;

import java.util.Scanner;

public class QuestionService {
    static Scanner scanner = new Scanner(System.in);

    public static String questionString(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    
    public static Integer questionInteger(String question) {
        System.out.print(question);
        return Integer.valueOf(scanner.nextLine());
    }

    public static Double questionDouble(String question) {
        System.out.print(question);
        return Double.valueOf(scanner.nextLine());
    }
    
}
