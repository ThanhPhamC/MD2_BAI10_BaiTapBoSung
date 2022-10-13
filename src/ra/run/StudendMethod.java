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
        } else {
            int inputnumber;
            while (true) {
                try {
                    System.out.print("Nhập số lượng sinh viên muốn thêm: ");
                    inputnumber = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Sai định dạng, hãy nhập lại.");
                }
            }
            for (int i = 0; i < inputnumber; i++) {
                Student newStudent = new Student();
                System.out.println("Sinh viên " + (i + 1) + ":");
                newStudent.inputData();
                listStudent.add(newStudent);
                addstudentClass(newStudent);
            }
        }
    }
    //--2----------update Student----------
    public static void updateStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi update!");
        } else {
            System.out.print("Nhập Id để cập nhập thông tin: ");
            String inputIdStudent = sc.nextLine();
            String newStudentName;
            boolean check = true;
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
                    addstudentClass(student);
                    boolean checkUpdateMark = true;
                    do {
                        System.out.println("+--------------------------------------+");
                        System.out.println("|    Chọn môn học bạn muốn cập nhập.   | ");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|         1. Java Script.              |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|         2. Java Core.                |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|         3. Java Web.                 |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|         4. Thoát.                    |");
                        System.out.println("+--------------------------------------+\n");
                        System.out.println("Lựa chọn của bạn là : ");
                        int choice=StudentManagement.checkChoice(1,4);
                        switch (choice){
                            case 1: updateStudentMark(student.getListMarkJavaScript(),sc,student,"Java Script");
                                break;
                            case 2: updateStudentMark(student.getListMarkJavaCore(),sc,student,"Java Core");
                                break;
                            case 3: updateStudentMark(student.getListMarkJavaWeb(),sc,student,"Java Web");
                                break;
                            case 4:
                                checkUpdateMark = false;
                                break;
                        }
                    }while (checkUpdateMark);
                    System.out.println("Cập nhập thành công.");
                } else {
                    check = false;
                }
            }
            if (!check) {
                System.out.println("Mã Id không tồn tại.");
            }
        }

    }

    //-------------------update diem cho sinh vien----------------------------
    public static void updateStudentMark(List<Float> listMark, Scanner sc, Student student, String subject) {
        boolean check = true;
        do {
            System.out.printf ("   Cập nhập điểm môn %s cho sinh viên. \n", subject);
            System.out.println("+--------------------------------------+");
            System.out.println("|  1. Tạo mới bảng điểm cho sinh viên. |");
            System.out.println("+--------------------------------------+");
            System.out.println("|  2. Thêm mới điểm cho sinh viên.     |");
            System.out.println("+--------------------------------------+");
            System.out.println("|  3. Không cập cập.                   |");
            System.out.println("+--------------------------------------+\n");
            System.out.print  ("Lựa chọn của bạn là: ");
            int choice = StudentManagement.checkChoice(1,3);
            switch (choice) {
                case 1:
                    ArrayList<Float> newMark = new ArrayList<>();
                    student.inputMark(newMark, sc);
                    switch (subject) {
                        case "Java Script":
                            student.setListMarkJavaScript(newMark);
                            break;
                        case "Java Core":
                            student.setListMarkJavaCore(newMark);
                            break;
                        case "Java Web":
                            student.setListMarkJavaWeb(newMark);
                            break;
                    }
                    break;
                case 2:
                    switch (subject) {
                        case "Java Script":
                            Student.inputMark(student.getListMarkJavaScript(), sc);
                            break;
                        case "Java Core":
                            Student.inputMark(student.getListMarkJavaCore(), sc);
                            break;
                        case "Java Web":
                            Student.inputMark(student.getListMarkJavaWeb(), sc);
                            break;
                    }
                    break;
                case 3:
                    check=false;
                    break;
                default:
                    System.out.println("vui lòng chọn trong khoảng 1-4.");
            }
        }while (check);

    }

    //---3-------------Show list student----------------------
    public static void showListStudent() {

        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ", "| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        for (Student student : listStudent) {
            student.displayData();
        }

    }

    //----4---- avgMark---------------------
    public static void avgMarkStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi tính điểm!");
        } else {
            for (Student student : listStudent) {
                student.calAvgMark();
            }
            System.out.println("Đã tính xong điểm trung bình.");
        }
    }

    //-----5------GPA- student----------
    public static void gpaStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi sắp xếp!");
        } else {
            for (Student student : listStudent) {
                student.getGpaStudent();
            }
            System.out.println("Đã sắp xếp xong học lực.");
        }
    }

    //-----6--- sort avg student---------
    public static void sortAvgStudent() {
        if (listStudent.size() == 0) {
            System.err.println("Danh sách sinh viên trống, hãy thêm mới trước khi sắp xếp!");
        } else {
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
            System.out.println("Đã sắp xếp theo thứ tự điểm trung bình tăng dần.");
        }
    }

    //----7--------search student----------
    public static void searchStudent() {
        System.out.println("Nhập tên sinh viên muốn tìm kiếm");
        String searchName = sc.nextLine();
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ", "| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        boolean check = true;
        for (Student sstudent : listStudent) {
            if (sstudent.getStudentName().contains(searchName)) {
                sstudent.displayData();
            } else {
                check = false;
            }
        }
        if (!check) {
            System.out.println("Không tồn tại sinh viên tên" + searchName);
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
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-20s%-10s%-10s\n", "| Mã sinh viên ", "|    Tên sinh viên", "|   Tuổi", "| Giới tính ", "| Lớp học ", "|   Điểm trung bình", "| Học lực", "| Trạng thái |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        for (Student sstudent : listStudent) {
            if (sstudent.getAvgMark() > Student.MARK_PASS) {
                sstudent.displayData();
                count++;
            }
        }
        System.out.printf("Có %d học sinh đã đỗ.", count);
    }

    //-------------add class for student----------------------
    public static void addstudentClass(Student newStudent) {
        int count = 1;
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
                if (student.getClassName().equals(inputNameClass)) {
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
