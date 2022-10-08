package ra.run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudendMethod implements Comparator<Student> {
    public static ArrayList<Student> listStudent = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    }

    //---1----- add new student-----------------
    public static void addNewStudent() {
        if (ClassStudentMethod.listStudsentClass.size() == 0) {
            System.out.println("Danh sách lớp trống, tạo danh sách lớp trước khi thêm mới sinh viên!");
            return;
        }
        int count = 1;
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int inputnumber = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputnumber; i++) {
            Student newStudent = new Student();
            System.out.println("Sinh viên " + (i + 1) + ":");
            newStudent.inputData();
            listStudent.add(newStudent);
            System.out.printf("Hiện tại đang có %d lớp:\n", ClassStudentMethod.listStudsentClass.size());
            for (StudentClass student : ClassStudentMethod.listStudsentClass) {
                System.out.printf("%-10d%-20s\n", count++, student.getClassName());
                ;
            }
            System.out.print("Nhập tên lớp muốn thêm : ");
            String inputNameClass = sc.nextLine();
            boolean run = true;
            while (run) {
                for (StudentClass student : ClassStudentMethod.listStudsentClass) {
                    if (!student.getClassName().equals(inputNameClass) || inputNameClass.trim().length() == 0) {
                        System.err.print("Nhập sai, hãy nhập lại: ");
                        inputNameClass = sc.nextLine();
                        break;
                    } else {
                        newStudent.setStudentClass(student);
                        System.out.println("Thêm thành công.");
                        run = false;
                    }
                }
            }
        }
    }

    //--2----------update Student----------
    public static void updateStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi update!");
        }
        System.out.print("Nhập Id để cập nhập thông tin: ");
        String inputIdStudent = sc.nextLine();
        for (Student student : listStudent) {
            if (student.getStudentId().equals(inputIdStudent)) {

                System.out.print("Nhập tuổi sinh viên: ");
//                this.age = Integer.parseInt(sc.nextLine());
//                System.out.print("Nhập giới tính sinh viên: ");
//                this.sex = Boolean.parseBoolean(sc.nextLine());
//                System.out.print("Nhập lớp sinh viên: ");
            }
        }

    }

    //---3-----Show list student-------------
    public static void showListStudent() {
        for (Student student : listStudent) {
            student.displayData();
        }

    }

    //----4---- avgMark---------------------
    public static void avgMarkStudent() {
        for (Student student : listStudent) {
            student.calAvgMark();
        }
    }

    //-----5------GPA- student----------
    public static void gpaStudent() {
        for (Student student : listStudent) {
            student.getGpaStudent();
        }
    }

    //-----6--- sort avg student---------
    public static void sortAvgStudent() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvgMark() > o2.getAvgMark()) {
                    return 1;
                } else if (o1.getAvgMark() == o2.getAvgMark()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    //----7--------search student----------
    public static void searchStudent() {
        System.out.println("Nhập tên sinh viên muốn tìm kiếm");
        String searchName = sc.nextLine();
        for (Student sstudent : listStudent) {
            if (sstudent.getStudentName().contains(searchName)) {
                sstudent.displayData();
            }
        }

    }

    //---8----sort list GPA student------------
    public static void sortListGpa() {
        int count_weak = 0;
        int count_medium = 0;
        int count_pretty = 0;
        int count_good = 0;
        for (Student csdudent : listStudent) {
            if (csdudent.getgPA().equals("Yếu.")) {
                count_weak++;
            } else if (csdudent.getgPA().equals("Trung bình.")) {
                count_medium++;
            } else if (csdudent.getgPA().equals("Khá.")) {
                count_pretty++;
            } else if (csdudent.getgPA().equals("Giỏi.")) {
                count_good++;
            }
        }
        System.out.println("Học lực gỏi có : " + count_good + " sv, " + "học lực khá có : " + count_pretty + " sv, " + "học lực trung bình có : " + count_medium + " sv, " + "học lực yếu có : " + count_weak + " sv.");


    }

    //-----9-----show list pass----------------
    public static void showListPass() {
        int count = 0;
        for (Student sstudent : listStudent) {
                if (sstudent.getAvgMark()>5){
                    sstudent.displayData();
                    count++;
                }
        }
        System.out.printf("Có %d học sinh đã đỗ.",count);
    }


    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
