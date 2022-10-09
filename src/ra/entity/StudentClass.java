package ra.entity;

import ra.run.ClassStudentMethod;
import ra.run.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Id: ");
        this.classId = sc.nextLine();
        while (this.classId.trim().length() != 5 || this.classId.charAt(0) != 'J') {
            System.out.print("ID gồm 5 kí tự và bắt đầu bằng \"J\": ");
            this.classId = sc.nextLine();
        }
        if (ClassStudentMethod.listStudsentClass.size() != 0) {
            boolean checkout = true;
            while (checkout) {
                for (StudentClass xclass : ClassStudentMethod.listStudsentClass) {
                    if (xclass.getClassId().equals(this.classId.trim()) || this.classId.trim().length() != 5 || this.classId.trim().charAt(0) != 'J') {
                        System.out.print("Độ dài Id=5 bắt đầu bằng \"J\" và không được trùng hoặc trống, nhập lại: ");
                        this.classId = sc.nextLine();
                        break;
                    } else {
                        checkout = false;
                    }
                }
            }

        }
        System.out.print("Nhập tên lớp: ");
        this.className = sc.nextLine();
        while (this.className.trim().length() == 0 || this.className.trim().length() > 10) {
            System.out.print("Nhập lại tên với độ dài <10: ");
            this.className = sc.nextLine();
        }
        if (ClassStudentMethod.listStudsentClass.size() != 0) {
            boolean checkout = true;
            while (checkout) {
                for (StudentClass xclass : ClassStudentMethod.listStudsentClass) {
                    if (xclass.getClassName().equals(this.className.trim()) || this.className.trim().length() == 0 || this.className.trim().length() > 10) {
                        System.out.print("Độ dài tên <10 và không được trùng hoặc trống, nhập lại: ");
                        this.className = sc.nextLine();
                        break;
                    } else {
                        checkout = false;
                    }
                }
            }
        }
        System.out.print("Mô tả: ");
        this.descriptions = sc.nextLine();
        System.out.println("Trạng thái lớp:");
        System.out.println("1. Sắp bắt đầu.");
        System.out.println("2. Hoạt động.");
        System.out.println("3. Tạm dừng.");
        while (this.classStatus<1||this.classStatus >3) {
            try {
                System.out.print("Vui lòng chọn trong khoảng 1 - 3: ");
                this.classStatus = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Sai định dạng, hãy nhập lại");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.printf("|   %-12s|     %-14s|     %-14s|     %-7s|\n", classId, className, descriptions, classStatus);
        System.out.println("+--------------------------------------------------------------------+");

    }

}
