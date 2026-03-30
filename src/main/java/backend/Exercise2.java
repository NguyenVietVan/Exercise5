package backend;
import entity.Document;
import entity.Article;
import entity.Magazine;
import entity.Book;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Exercise2 {public static int ID = 0;
    private ArrayList<Document> documentList;
    private Scanner sc;
    public Exercise2() {
        sc = new Scanner(System.in);
        documentList = new ArrayList<Document>();}
    public void question4() {
        loadMenu();}
    public void loadMenu() {
        while (true) {
            System.out.println("======================================================================");
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. Thêm mới tài liệu. ===");
            System.out.println("=== 2. Xóa tài liệu.===");
            System.out.println("=== 3. Hiện thị thông tin tài liệu. ===");
            System.out.println("=== 4. Tìm kiếm tài liệu theo loại ===");
            System.out.println("=== 5. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            String menuChoose = sc.nextLine();
            switch (menuChoose) {
                case "1":
                    addDocument();
                    break;
                case "2":
                    delDocument();
                    break;
                case "3":
                    printListDocument();
                    break;
                case "4":
                    findByCategory();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Alarm: Lựa chọn đúng số trên menu");
                    break;
            }
        }
    }
    private void findByCategory() {
        System.out.println("Nhập vào loại tài liệu cần tìm kiếm 1.Sách, 2.Báo, 3.Tạp chí: ");
        int chooseCategory = sc.nextInt();
        switch (chooseCategory) {
            case 1:
                for (Document document : documentList) {
                    if (document instanceof Book) {
                        System.out.println(document);
                    }
                }
                break;
            case 2:
                for (Document document : documentList) {
                    if (document instanceof Article) {
                        System.out.println(document);
                    }
                }
                break;
            case 3:
                for (Document document : documentList) {
                    if (document instanceof Magazine) {
                        System.out.println(document);
                    }
                }
                break;
            default:
                System.out.println("Nhập không đúng.!!");
                break;
        }
    }
    //instanceof được dùng để kiểm tra xem một đối tượng có phải là thể hiện (instance) của một lớp, lớp con, hoặc interface cụ thể hay không
    private void printListDocument() {
        for (Document document : documentList) {
            System.out.println(document);
        }
    }
    private void delDocument() {
        System.out.println("Nhập vào mã tài liệu muốn xóa: ");
        int idDel = sc.nextInt();
        Boolean flagCheckExists = false;
        for (Document document : documentList) {
            if (document.getId() == idDel) {
                flagCheckExists = true;
            }
        }
        if (flagCheckExists) {
            documentList.removeIf(doc -> doc.getId() == idDel);
            for (Document document : documentList) {
                System.out.println("Xóa tài liệu thành công, danh sách tài liệu còn lại:");
                System.out.println(document);
            }
        } else {
            System.out.println("Mã tài liệu bạn nhập không có trên hệ thống.");
        }
    }
    private void addDocument() {
        System.out.println("----------------------------------------------------");
        System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
        System.out.println("--- 1. Thêm Sách ---");
        System.out.println("--- 2. Thêm Báo ---");
        System.out.println("--- 3. Thêm Tạp chí ---");
        System.out.println("----------------------------------------------------");
        int choose1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập vào tên nhà xuất bản: ");
        String publisher = sc.next();
        System.out.println("Nhập vào số bản phát hành: ");
        int numRelease = sc.nextInt();
        switch (choose1) {
            case 1:
                System.out.println("Nhập vào tên tác giả: ");
                String authorName = sc.next();
                System.out.println("Nhập vào số trang: ");
                int numPage = sc.nextInt();
                ID++;
                Document book = new Book(ID, publisher, numRelease,authorName, numPage);
                documentList.add(book);
                break;
            case 2:
                System.out.println("Nhập vào ngày phát hành: ");
                int day = sc.nextInt();
                System.out.println("Nhập vào tháng phát hành: ");
                int month = sc.nextInt();
                System.out.println("Nhập vào năm phát hành: ");
                int year = sc.nextInt();
                LocalDate dayReleaseArticle = LocalDate.of(year, month, day);
                ID++;
                Document artice = new Article(ID, publisher, numRelease, dayReleaseArticle);
                documentList.add(artice);
                break;
            case 3:
                System.out.println("Nhập vào số phát hành: ");
                int idReleaseMagazine = sc.nextInt();
                System.out.println("Nhập vào ngày phát hành: ");
                int day1 = sc.nextInt();
                System.out.println("Nhập vào tháng phát hành: ");
                int month1 = sc.nextInt();
                System.out.println("Nhập vào năm phát hành: ");
                int year1 = sc.nextInt();
                LocalDate monthReleaseMagazine = LocalDate.of(year1, month1,day1);
                ID++;
                Document magazine = new Magazine(ID, publisher, numRelease, idReleaseMagazine, monthReleaseMagazine);
                documentList.add(magazine);
                break;
            default:
                break;
        }
    }
}

