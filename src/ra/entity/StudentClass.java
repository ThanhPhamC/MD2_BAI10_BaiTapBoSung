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
        do {
            this.classId = sc.nextLine();
            if (this.classId.trim().length() != 0) {
                if (this.classId.trim().length() == 5) {
                    if (this.classId.trim().charAt(0) == 'J') {
                        boolean check = true;
                        for (StudentClass classstudent : ClassStudentMethod.listStudsentClass) {
                            if (classstudent.classId.equals(this.classId.trim())) {
                                check = false;
                            }
                        }
                        if (!check) {
                            System.out.println("Id đã bị trùng");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Id phải bắt đầu là kí tự 'J'.");
                    }
                } else {
                    System.out.println("Id phải là 5 kí tự.");
                }
            } else {
                System.out.println("Không để trống.");
            }
        } while (true);
        System.out.print("Nhập tên lớp: ");
        do {
            this.className = sc.nextLine();
            if (this.className.trim().length()!=0){
                if (this.className.trim().length()<10){
                    boolean check = true;
                    for (StudentClass classstudent : ClassStudentMethod.listStudsentClass) {
                        if (classstudent.className.equals(this.className.trim())) {
                            check = false;
                        }
                    }
                    if (!check) {
                        System.out.println("Tên đã bị trùng");
                    } else {
                        break;
                    }
                }else {
                    System.out.println("Do dai ten duoi 10 ki tu");
                }
            }else {
                System.out.println("khong de trong");
            }
        } while (true);
        System.out.print("Mô tả: ");
        this.descriptions = sc.nextLine();
        System.out.println("Trạng thái lớp:");
        System.out.println("1. Sắp bắt đầu.");
        System.out.println("2. Hoạt động.");
        System.out.println("3. Tạm dừng.");
        while (this.classStatus < 1 || this.classStatus > 3) {
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
