import java.util.Scanner;

import controller.BookController;

public class App {

    static String opsi;
    static Scanner input = new Scanner(System.in);
    static BookController books = new BookController();
    static boolean exit = false;

    private static void menuApp() {
        System.out.println("=== BOOK MANAGEMENT ===");
        System.out.println("1. Tambahkan Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Edit Buku");
        System.out.println("4. Tampilkan Semua Buku");
        System.out.println("5. Pilih Buku dan Tampilkan");
        System.out.println("6. Keluar Aplikasi");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }

    public static void main(String[] args) throws Exception {
        do {
            menuApp();
            switch (opsi) {
                case "1":
                    System.out.print("Input Judul Buku : ");
                    String title = input.nextLine();
                    System.out.print("Input Pengarang Buku : ");
                    String author = input.nextLine();
                    books.saveBook(title, author);
                    break;

                case "2":
                    System.out.print("Input ID buku yang akan dihapus : ");
                    try {
                        books.deleteBook(Integer.valueOf(input.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Buku tidak ditemukan");
                        System.out.print("Tekan enter untuk melanjutkan.");
                        input.nextLine();
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Input ID buku yang akan diedit : ");
                        Integer id = Integer.valueOf(input.nextLine());
                        System.out.print("Input Judul Buku : ");
                        String newTitle = input.nextLine();
                        System.out.print("Input Pengarang Buku : ");
                        String newAuthor = input.nextLine();
                        books.updateBook(id, newTitle, newAuthor);
                        
                    } catch (Exception e) {
                        System.out.println("Buku tidak ditemukan");
                        System.out.print("Tekan enter untuk melanjutkan.");
                        input.nextLine();
                    }
                    break;

                case "4":
                    books.getBooks();
                    System.out.print("Tekan enter untuk melanjutkan.");
                    input.nextLine();
                    break;

                case "5":
                    System.out.print("Input ID buku yang akan ditampilkan : ");
                    try {
                        books.getBookByid(Integer.valueOf(input.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Buku tidak ditemukan");
                    }
                    System.out.print("Tekan enter untuk melanjutkan.");
                    input.nextLine();
                    break;

                case "6":
                    exit = true;
                    break;

                default:
                    System.out.println("Opsi tidak tersedia.");
                    break;
            }

        } while (!exit);

    }
}
