package ra.run;

import ra.entity.StudentClass;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassStudentMethod {
    public static ArrayList<StudentClass> listStudsentClass = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }


    //---------them moi lop hoc------------------
    public static void addNewClass() {
        System.out.print("Nhập số lượng lớp muốn thêm mới: ");
        int inputnumber = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputnumber; i++) {
            System.out.printf("Lớp học thứ: %d\n", (i + 1));
            StudentClass studentClass = new StudentClass();
            studentClass.inputData();
            listStudsentClass.add(studentClass);
        }

    }

    //--------- Cap nhap thong tin lop hoc---------------
    public static void updateClass() {
        System.out.print("Nhập Id lớp học muốn sửa: ");
        String inputId = sc.nextLine();
        for (StudentClass x : listStudsentClass) {
            if (x.getClassId().equals(inputId)) {
                System.out.print("Nhập tên lớp: ");
                String  className= sc.nextLine();
                boolean checkout=true;
                while (checkout) {
                    for (StudentClass xclass : ClassStudentMethod.listStudsentClass) {
                        if (xclass.getClassName().equals(className.trim()) || className.trim().length() == 0 || className.trim().length() > 10) {
                            System.out.print("Độ dài tên <10 và không được trùng hoặc trống, nhập lại: ");
                            className = sc.nextLine();
                            break;
                        } else {
                            checkout = false;
                        }
                    }
                }
                x.setClassName(className);
                System.out.print("Mô tả: ");
                x.setDescriptions(sc.nextLine());
                System.out.println("Trạng thái lớp:");
                System.out.println("1. Sắp bắt đầu.");
                System.out.println("2. Hoạt động.");
                System.out.println("3. Tạm dừng.");
                int newClassStatus=0;
                while (newClassStatus<1||newClassStatus >3) {
                    try {
                        System.out.print("Vui lòng chọn trong khoảng 1 - 3: ");
                        newClassStatus= Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Sai định dạng, hãy nhập lại");
                    }
                }
                x.setClassStatus(newClassStatus);
            }
        }
    }

    //--------- Hiển thị thông tin lop hoc-------------
    public static void showListClass() {
        System.out.printf("Hiện tại có %d lớp học: \n",listStudsentClass.size());
        System.out.println("+--------------------------------------------------------------------+");
        System.out.printf("%-16s%-20s%-20s%-10s\n", "|   Mã lớp học", "|    Tên lớp học", "|      Mô tả", "| Trạng thái |");
        System.out.println("+--------------------------------------------------------------------+");

        for (StudentClass x : listStudsentClass) {
            x.displayData();
        }

    }

    //------- thong ke lop hoc dang hoat dong------------------
    public static void showClassOn() {
        int count=0;
        System.out.println("+--------------------------------------------------------------------+");
        System.out.printf("%-16s%-20s%-20s%-10s\n", "|   Mã lớp học", "|    Tên lớp học", "|      Mô tả", "| Trạng thái |");
        System.out.println("+--------------------------------------------------------------------+");
        for (StudentClass aClass : listStudsentClass) {
            if (aClass.getClassStatus() == 2) {
                aClass.displayData();
                count++;
            }
        }
        System.out.printf("Có %d lớp đang hoạt động.\n",count);
    }

    //--------tim kiem lop hoc theo ten----------------------
    public static void searchClass() {
        System.out.println("Nhập tên class cần tìm: ");
        String inputName = sc.nextLine();
        System.out.println("+--------------------------------------------------------------------+");
        System.out.printf("%-16s%-20s%-20s%-10s\n", "|   Mã lớp học", "|    Tên lớp học", "|      Mô tả", "| Trạng thái |");
        System.out.println("+--------------------------------------------------------------------+");
        for (StudentClass aClass : listStudsentClass) {
            if (aClass.getClassName().equals(inputName)) {
                aClass.displayData();
            }else {
                System.out.printf("Không tồn tại lớp học %s\n",inputName);
            }
        }
    }
}