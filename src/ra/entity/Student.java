package ra.entity;

import ra.run.ClassStudentMethod;
import ra.run.StudendMethod;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
    private float avgMark;
    private String gPA;
    private boolean studentStatus;
    private ArrayList<Float> listMarkJavaScript = new ArrayList<>();
    private ArrayList<Float> listMarkJavaCore = new ArrayList<>();
    private ArrayList<Float> listMarkJavaWeb = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, StudentClass studentClass,
                   float avgMark, String gPA, boolean studentStatus, ArrayList<Float> listMarkJavaScript,
                   ArrayList<Float> listMarkJavaCore, ArrayList<Float> listMarkJavaWeb) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.avgMark = avgMark;
        this.gPA = gPA;
        this.studentStatus = studentStatus;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getgPA() {
        return gPA;
    }

    public void setgPA(String gPA) {
        this.gPA = gPA;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public ArrayList<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(ArrayList<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public ArrayList<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(ArrayList<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public ArrayList<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(ArrayList<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");                                        //.nhap ma sinh vien.
        this.studentId = sc.nextLine();
        while (this.studentId.trim().length() != 6 || this.studentId.charAt(0) != 'S') {
            System.out.println("ID gồm 6 kí tự và bắt đầu bằng \"S\": ");
            this.studentId = sc.nextLine();
        }
        if (StudendMethod.listStudent.size() != 0) {
            boolean checkout = true;
            while (checkout) {
                for (Student student : StudendMethod.listStudent) {
                    if (student.getStudentId().equals(this.studentId.trim()) || this.studentId.trim().length() != 6 || this.studentId.trim().charAt(0) != 'S') {
                        System.out.println("Độ dài Id= 6, bắt đầu bằng \"S\" và không được trùng hoặc trống, nhập lại: ");
                        this.studentId = sc.nextLine();
                        break;
                    } else {
                        checkout = false;
                    }
                }
            }

        }
        while (true) {                                                               //.nhap ten sinh vien.
            System.out.print("Nhập tên sinh viên: ");
            this.studentName = sc.nextLine();
            if (this.studentName.trim().length() > 10 && this.studentName.trim().length() < 50) {
                break;
            } else {
                System.out.println("Tên gồm 10-50 kí tự.");
            }
        }
        if (StudendMethod.listStudent.size() != 0) {
            boolean checkout = true;
            while (checkout) {
                for (Student student : StudendMethod.listStudent) {
                    if (student.getStudentName().equals(this.studentName.trim()) || this.studentName.trim().length() < 10 || this.studentName.trim().length() > 50) {
                        System.out.println("Tên gồm 10-50 kí tự và không để trống, nhập lại: ");
                        this.studentName = sc.nextLine();
                        break;
                    } else {
                        checkout = false;
                    }
                }
            }
        }
        System.out.print("Nhập tuổi sinh viên: ");                                    // nhap tuoi.
           this.age= inputAge(sc);
        while (true) {                                                               //.nhap gioi tinh.
            try {
                System.out.print("Nhập giới tính sinh viên: ");
                this.sex = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai định dạng, hãy nhập lại(true or false).");
            }
        }
        System.out.print("Nhập điểm môn JavaScript: ");                             //.nhap diem.
        inputMark(listMarkJavaScript, sc);
        System.out.print("Nhập điểm môn JavaCore: ");
        inputMark(listMarkJavaCore, sc);
        System.out.print("Nhập điểm môn JavaWeb: ");
        inputMark(listMarkJavaWeb, sc);
        while (true) {                                                                //.trang thai
            try {
                System.out.print("Nhập trạng thái sinh viên: ");
                this.studentStatus = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai định dạng, hãy nhập lại(true or false).");
            }
        }
    }

    //------- input AGE-------------
    public static int inputAge( Scanner sc) {
        while (true) {
            try {
               int age = Integer.parseInt(sc.nextLine());
                if (age < 18) {
                    System.out.println("Sai tuổi, hãy nhập lại!");
                } else {
                    return age;
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, hãy nhập lại.");
            }
        }
    }

    //    ------- diem 3 mon----------
    public static void inputMark(List<Float> listMark, Scanner sc) {
        int count = 1;
        float mark;
        do {
            while (true) {
                try {
                    System.out.printf("Nhập điểm thi lần %d\n", count);
                    mark = Float.parseFloat(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Sai định dạng, hãy nhập lại.");
                }
            }
            listMark.add(mark);
            count++;
            System.out.printf("Bạn có muốn nhập điểm lần thứ %d không?\n", count);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
    }

    //--------------------tinh diem trung binh 3 mon----------------------
    public void calAvgMark() {
        this.avgMark = (listMarkJavaCore.get(listMarkJavaCore.size() - 1) +
                listMarkJavaWeb.get(listMarkJavaWeb.size() - 1) +
                listMarkJavaScript.get(listMarkJavaScript.size() - 1)) / 3;

    }

    //---------------------xep loai hoc luc theo diem trung binh 3 mon---------------
    public void getGpaStudent() {
        if (this.avgMark < 5) {
            this.gPA = "Yếu.";
        } else if (this.avgMark < 7) {
            this.gPA = "Trung bình.";
        } else if (this.avgMark < 9) {
            this.gPA = "Khá.";
        } else {
            this.gPA = "Giỏi.";
        }
    }

    @Override
    public void displayData() {
        System.out.println(
                "studentId='" + studentId + '\'' +
                        "| studentName='" + studentName + '\'' +
                        "| age=" + age +
                        "| sex=" + sex +
                        "| studentClass=" + studentClass.getClassName() +
                        "| avgMark=" + avgMark +
                        "| gPA='" + gPA +
                        "| studentStatus='" + studentStatus + '\''
        );
    }
}
