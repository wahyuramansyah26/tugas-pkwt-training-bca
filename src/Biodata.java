import java.util.Scanner;

public class Biodata {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        System.out.print("Input First Name : ");
        String firstName = input.nextLine();

        System.out.print("Input Last Name : ");
        String lastName = input.nextLine();

        System.out.print("Input Birth Place : ");
        String birthPlace = input.nextLine();

        System.out.print("Input Birth Year : ");
        Integer birthYear = Integer.valueOf(input.nextLine());

        System.out.print("Input Favorite Programming Language : ");
        String proLangFav = input.nextLine();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(birthPlace);
        System.out.println(birthYear);
        System.out.println(proLangFav);
    }
}
