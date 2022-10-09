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
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int inputnumber = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputnumber; i++) {
            Student newStudent = new Student();
            System.out.println("Sinh viên " + (i + 1) + ":");
            newStudent.inputData();
            listStudent.add(newStudent);
             addstudentClass(newStudent);         //goi ham 143.
        }
    }
    //--2----------update Student----------
    public static void updateStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi update!");
        }
        System.out.print("Nhập Id để cập nhập thông tin: ");
        String inputIdStudent = sc.nextLine();
        String newStudentName;
        for (Student student : listStudent) {
            if (student.getStudentId().equals(inputIdStudent)) {
                while (true) {
                    System.out.print("Nhập tên sinh viên: ");
                     newStudentName = sc.nextLine();
                    if (newStudentName.trim().length() > 10 && newStudentName.trim().length() < 50) {
                        student.setStudentName(newStudentName);
                        break;
                    } else {
                        System.out.println("Tên gồm 10-50 kí tự.");
                    }
                }
                System.out.print("Nhập tuổi sinh viên: ");
                student.setAge(Student.inputAge(sc));
                System.out.print("Nhập giới tính sinh viên: ");
                student.setSex(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("Trạng thái của sinh viên: ");
                student.setStudentStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.print("Chọn lớp sinh viên: ");
                addstudentClass(student);//goi ham 143.
                System.out.println("Cập nhập thành công.");
            }
        }
    }
    //---3-------------Show list student----------------------
    public static void showListStudent() {
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ","| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
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
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ","| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
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
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ","| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        for (Student sstudent : listStudent) {
                if (sstudent.getAvgMark()>5){
                    sstudent.displayData();
                    count++;
                }
        }
        System.out.printf("Có %d học sinh đã đỗ.",count);
    }
//-------------add class for student----------------------
public static void addstudentClass( Student newStudent) {
    int count=1;
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
            if (student.getClassName().equals(inputNameClass) ) {
                newStudent.setStudentClass(student);
                System.out.println("Thêm thành công.");
                return;
            } else {
                System.err.print("Nhập sai, hãy nhập lại: ");
                inputNameClass = sc.nextLine();

            }
        }
    }

}


    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
