import java.util.List;
import java.util.Scanner;

import controller.BookController;
import models.Book;

public class App {

    static String opsi;
    static Scanner input = new Scanner(System.in);
    static BookController books = new BookController();
    static boolean exit = false;

    private static void menuApp() {
        System.out.println("=== BOOK MANAGEMENT ===");
        System.out.println("1. Tambahkan Buku");
        System.out.println("2. Tampilkan Semua Buku");
        System.out.println("3. Hapus Buku by ID");
        System.out.println("4. Pilih Buku dan Tampilkan");
        System.out.println("5. Keluar Aplikasi");
        System.out.print("Pilihan : ");
        opsi = input.nextLine();
    }

    public static void main(String[] args) throws Exception {
        do {
            menuApp();
            switch (opsi) {
                case "1":
                    Boolean addPerson = true;
                    while (addPerson) {
                        System.out.print("Input Judul Buku : ");
                        String title = input.nextLine();
                        System.out.print("Input Pengarang Buku : ");
                        String author = input.nextLine();
                        books.saveBook(title, author);
                        while (true) {
                            System.out.print("Ingin tambah buku lagi (y|n)? ");
                            String option = input.nextLine();
                            if (option.equalsIgnoreCase("y")) {
                                addPerson = true;
                                break;
                            } else if (option.equalsIgnoreCase("n")) {
                                addPerson = false;
                                break;
                            } else {
                                System.out.println("Silahkan input y atau n");
                                continue;
                            }
                        }
                    }
                    break;

                case "2":
                    List<Book> listBook = books.getBooks();
                    if (listBook.size() > 0) {
                        Boolean state;
                        while (true) {
                            System.out.print("Ingin ubah buku? (y|n) ");
                            String option = input.nextLine();
                            if (option.equalsIgnoreCase("y")) {
                                state = true;
                                break;
                            } else if (option.equalsIgnoreCase("n")) {
                                state = false;
                                break;
                            } else {
                                System.out.println("Silahkan input y atau n");
                                continue;
                            }
                        }
                        if (state) {
                            Boolean editBook = true;
                            while (editBook) {
                                try {
                                    System.out.print("Input ID buku yang akan diedit : ");
                                    Integer id = Integer.valueOf(input.nextLine());
                                    System.out.print("Input Judul Buku : ");
                                    String newTitle = input.nextLine();
                                    System.out.print("Input Pengarang Buku : ");
                                    String newAuthor = input.nextLine();
                                    books.updateBook(id, newTitle, newAuthor);
                                    System.out.println("Buku berhasil diperbarui");
                                    books.getBooks();

                                } catch (Exception e) {
                                    System.out.println("Buku tidak ditemukan");
                                    System.out.print("Tekan enter untuk melanjutkan.");
                                    input.nextLine();
                                    break;
                                }

                                while (true) {
                                    System.out.print("Ingin ubah buku lagi (y|n)? ");
                                    String option = input.nextLine();
                                    if (option.equalsIgnoreCase("y")) {
                                        editBook = true;
                                        break;
                                    } else if (option.equalsIgnoreCase("n")) {
                                        editBook = false;
                                        break;
                                    } else {
                                        System.out.println("Silahkan input y atau n");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    System.out.print("Tekan enter untuk melanjutkan.");
                    input.nextLine();
                    break;

                case "3":
                    System.out.print("Input ID buku yang akan dihapus : ");
                    try {
                        books.deleteBook(Integer.valueOf(input.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Buku tidak ditemukan");
                        System.out.print("Tekan enter untuk melanjutkan.");
                        input.nextLine();
                    }
                    break;

                case "4":
                    System.out.print("Input ID buku yang akan ditampilkan : ");
                    try {
                        books.getBookByid(Integer.valueOf(input.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Buku tidak ditemukan");
                    }
                    System.out.print("Tekan enter untuk melanjutkan.");
                    input.nextLine();
                    break;

                case "5":
                    exit = true;
                    break;

                default:
                    System.out.println("Opsi tidak tersedia.");
                    break;
            }

        } while (!exit);

    }
}
