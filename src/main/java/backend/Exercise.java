package backend;

import entity.Employee;
import entity.Staff;
import entity.Gender;
import entity.Engineer;
import entity.Worker;
import entity.HighSchoolStudent;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise {
    private ArrayList<Staff> staffList;// luu nhung can bo vao day
    private Scanner sc;

    public Exercise() {
        staffList = new ArrayList<Staff>(); // tạo list rỗng
        sc = new Scanner(System.in);
    }

    public void question1() {
    }
    public void question3() {
        HighSchoolStudent highSchoolStudent = new HighSchoolStudent("Van", 1, "Chuyên Văn",
                "Đại học công nghệ");
        System.out.println(highSchoolStudent);
    }

    public void question2() {
        menu();
    }

    public void menu() {
// ArrayList<Staff> staffList = null;
        while (true) {
            System.out.println("======================================================================");
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. Thêm mới cán bộ .===");
            System.out.println("=== 2. Tìm kiếm theo họ tên. ===");
            System.out.println("=== 3. Hiện thị thông tin về danh sách các cán bộ. ===");
            System.out.println("=== 4. Nhập vào tên của cán bộ và delete cán bộ đó ===");
            System.out.println("=== 5. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            String menuChoose = sc.nextLine();// kis tu
            switch (menuChoose) {
                case "1":
                    addStaff();
                    break;

                case "2":
//                    findByName();
                    break;
                case "3":
                    printListStaff();
                    break;
                case "4":
//                    deleteByName();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn đúng số trên menu");
                    break;
            }
        }

    }
    private void printListStaff() {
        for (Staff s : staffList) {
            System.out.println(s.toString());
        }
    }
    private void deleteByName() {
        System.out.println("Nhập tên cần xóa thông tin: ");
        String delName = sc.next();
        staffList.removeIf(staff -> staff.getName().equals(delName));
        printListStaff();
// for (Staff staff : staffList) {
// if (staff.getName().equals(delName)) {
// staffList.remove(staff);
// }
// } => không thể sử dụng vòng lặp này để xóa do dữ liệu sau khi xóa không tường minh, nên k chạy tiếp được vòng lặp để kiểm tra sau khi xóa
    }
    private void findByName() {
        System.out.println("Nhập vào tên muốn tìm kiếm: ");
        String findName = sc.next();
        for (Staff staff : staffList) {
            if (staff.getName().equals(findName)) {
                System.out.println(staff);
            }
        }
    }
    private void addStaff() {
        System.out.println("----------------------------------------------------");
        System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
        System.out.println("--- 1. Thêm Engineer ---");
        System.out.println("--- 2. Thêm Worker ---");
        System.out.println("--- 3. Thêm Employeee ---");
        System.out.println("----------------------------------------------------");
        int choose1 = sc.nextInt();
        sc.nextLine();
        // dua cac thong tin chung a ngoài swutch case

        // ===== PHẦN CHUNG =====
        System.out.println("Nhập vào tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập vào tuổi: ");
        int age = sc.nextInt();
        System.out.println("Nhập vào giới tính 1.Male, 2.Female, 3.Unknown: ");
        int flag = sc.nextInt();
        Gender gender = null;
        switch (flag) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.UNKNOWN;
                break;
        }
        System.out.println("Nhập vào địa chỉ: ");
        String address = sc.next();
        // ===== PHẦN RIÊNG =====
        switch (choose1) {
            case 1:
                System.out.println("Nhập vào chuyên ngành Engineer: ");
                String specialized = sc.next();
                Staff en = new Engineer(name, age, gender, address, specialized);
                staffList.add(en);
                break;

            case 2:
                System.out.println("Nhập vào bậc Worker: ");
                int rank = sc.nextInt();
                Staff worker = new Worker(name, age, gender, address, rank);
                staffList.add(worker);
                break;

            case 3:
                System.out.println("Nhập vào nhiệm vụ Employee: ");
                String task = sc.next();
                Staff emp = new Employee(name, age, gender, address, task);
                staffList.add(emp);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
    }
}


