package ra.run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("\n+----------------------------------------------------------+");
            System.out.println("|                    QUẢN LÝ HỌC VIỆN                      |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    1. Quản lý lớp.                       |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    2. Quản lý sinh viên.                 |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    3. Thoát.                             |");
            System.out.println("+----------------------------------------------------------+\n");

            int choice=0;
            while (choice<1||choice>3) {
                try {
                    System.out.print("Chọn từ \"1- 3\" để tiếp tục: ");
                     choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Sai định dạng, hãy nhập lại.");
                }
            }
            switch (choice) {
                case 1:
                   classManagement();
                    break;
                case 2:
                    studentManagement();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
    public static void classManagement() {
        boolean outCase = true;
        do {
            System.out.println("\n\n+----------------------------------------------------------+");
            System.out.println("|                       QUẢN LÝ LỚP HỌC                    |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  1. Thêm mới lớp học.                                    |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  2. Cập nhật thông tin lớp học.                          |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  3. Hiển thị thông tin lớp học.                          |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  4. Thống kê lớp học đang hoạt động (ClassStatus = 2.).  |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  5. Tìm kiếm lớp học theo tên lớp học.                   |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  6. Thoát.                                               |");
            System.out.println("+----------------------------------------------------------+\n");

            int choice = 0;
            while (choice<1||choice>6) {
                try {
                    System.out.print("Chọn từ \"1- 6\" để tiếp tục: ");
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Sai định dạng, hãy nhập lại.");
                }
            }
            switch (choice) {
                case 1:
                    ClassStudentMethod.addNewClass();
                    break;
                case 2:
                    ClassStudentMethod.updateClass();
                    break;
                case 3:
                    ClassStudentMethod.showListClass();
                    break;
                case 4:
                    ClassStudentMethod.showClassOn();
                    break;
                case 5:
                    ClassStudentMethod.searchClass();
                    break;
                case 6:
                    outCase = false;
                    break;
            }
        } while (outCase);
    }
    public static void studentManagement() {
        boolean outCase = true;
        do {
            System.out.println("\n\n+----------------------------------------------------------+");
            System.out.println("|                   QUẢN LÝ SINH VIÊN                      |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   1. Thêm mới sinh viên.                                 |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   2. Cập nhật thông tin sinh viên.                       |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   3. Hiển thị thông tin sinh viên.                       |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   4. Tính điểm trung bình.                               |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   5. Xếp loại sinh viên.                                 |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   6. Sắp xếp sinh viên theo điểm trung bình tăng dần.    |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   7. Tìm kiếm sinh viên theo tên sinh viên.              |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   8. Thống kê số sinh viên theo học lực.                 |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   9. Thống kê các sinh viên Pass qua các môn học.        |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|   10.Thoát.                                              |");
            System.out.println("+----------------------------------------------------------+\n");

            int choice = 0;
            while (choice<1||choice>10) {
                try {
                    System.out.println("Chọn từ \"1- 10\" để tiếp tục: ");
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.err.println("Sai định dạng, hãy nhập lại.");
                }
            }
            switch (choice) {
                case 1:
                    StudendMethod.addNewStudent();
                    break;
                case 2:
                    StudendMethod.updateStudent();
                    break;
                case 3:
                    StudendMethod.showListStudent();
                    break;
                case 4:
                    StudendMethod.avgMarkStudent();
                    break;
                case 5:
                    StudendMethod.gpaStudent();
                    break;
                case 6:
                    StudendMethod.sortAvgStudent();
                    break;
                case 7:
                    StudendMethod.searchStudent();
                    break;
                case 8:
                    StudendMethod.sortListGpa();
                    break;
                case 9:
                    StudendMethod.showListPass();
                    break;
                case 10:
                   outCase=false;
                   break;
            }
        } while (outCase);

    }


}



