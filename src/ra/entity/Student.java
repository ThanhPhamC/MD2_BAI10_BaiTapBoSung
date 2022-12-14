package ra.entity;

import ra.run.ClassStudentMethod;
import ra.run.StudendMethod;

import java.sql.SQLOutput;
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
        System.out.print("Nh???p m?? sinh vi??n: ");                                        //.nhap ma sinh vien.

        do {
            this.studentId = sc.nextLine();
            if (this.studentId.trim().length() != 0) {
                if (this.studentId.trim().length() == 6) {
                    if (this.studentId.trim().charAt(0) == 'S') {
                        boolean check = true;
                        for (Student student : StudendMethod.listStudent) {
                            if (student.getStudentId().equals(this.studentId.trim())) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            break;
                        } else {
                            System.out.println("Id ???? t???n t???i, nh???p Id m???i: ");
                        }
                    } else {
                        System.out.println("Id ph???i b???t ?????u l?? k?? t??? 'S', nh???p l???i: ");
                    }
                } else {
                    System.out.println("Id ph???i l?? 6 k?? t???, nh???p l???i: ");
                }

            } else {
                System.out.println("Kh??ng ???????c ????? tr???ng, nh???p l???i: ");
            }
        } while (true);
        while (true) {                                                               //.nhap ten sinh vien.
            System.out.print("Nh???p t??n sinh vi??n: ");
            this.studentName = sc.nextLine();
            if (this.studentName.trim().length() > 10 && this.studentName.trim().length() < 50) {
                break;
            } else {
                System.out.println("T??n g???m 10-50 k?? t???.");
            }
        }
        if (StudendMethod.listStudent.size() != 0) {
            boolean checkout = true;
            while (checkout) {
                for (Student student : StudendMethod.listStudent) {
                    if (student.getStudentName().equals(this.studentName.trim()) || this.studentName.trim().length() < 10
                            || this.studentName.trim().length() > 50) {
                        System.out.println("T??n g???m 10-50 k?? t??? v?? kh??ng ????? tr???ng, nh???p l???i: ");
                        this.studentName = sc.nextLine();
                        break;
                    } else {
                        checkout = false;
                    }
                }
            }
        }
        System.out.print("Nh???p tu???i sinh vi??n: ");                                    // nhap tuoi.
        this.age = inputAge(sc);
        while (true) {                                                               //.nhap gioi tinh.
            try {
                System.out.print("Nh???p gi???i t??nh sinh vi??n: ");
                this.sex = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai ?????nh d???ng, h??y nh???p l???i(true or false).");
            }
        }
        System.out.print("Nh???p ??i???m m??n JavaScript: ");                             //.nhap diem.
        inputMark(listMarkJavaScript, sc);
        System.out.print("Nh???p ??i???m m??n JavaCore: ");
        inputMark(listMarkJavaCore, sc);
        System.out.print("Nh???p ??i???m m??n JavaWeb: ");
        inputMark(listMarkJavaWeb, sc);
        while (true) {                                                                //.trang thai
            try {
                System.out.print("Nh???p tr???ng th??i sinh vi??n: ");
                this.studentStatus = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai ?????nh d???ng, h??y nh???p l???i(true or false).");
            }
        }
    }

    //------- input AGE-------------
    public static int inputAge(Scanner sc) {
        while (true) {
            try {
                int age = Integer.parseInt(sc.nextLine());
                if (age < 18) {
                    System.out.println("Sai tu???i, h??y nh???p l???i!");
                } else {
                    return age;
                }
            } catch (Exception e) {
                System.out.println("Sai ?????nh d???ng, h??y nh???p l???i.");
            }
        }
    }

    //    ------- diem 3 mon----------
    public static void inputMark(List<Float> listMark, Scanner sc) {
        int count = listMark.size() + 1;
        float mark;
        do {
            while (true) {
                try {
                    System.out.printf("Nh???p ??i???m thi l???n %d\n", count);
                    mark = Float.parseFloat(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Sai ?????nh d???ng, h??y nh???p l???i.");
                }
            }
            listMark.add(mark);
            count++;
            System.out.printf("B???n c?? mu???n nh???p ??i???m l???n th??? %d kh??ng?\n", count);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("L???a ch???n c???a b???n l??: ");
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
            this.gPA = "Y???u.";
        } else if (this.avgMark < 7) {
            this.gPA = "Trung b??nh.";
        } else if (this.avgMark < 9) {
            this.gPA = "Kh??.";
        } else {
            this.gPA = "Gi???i.";
        }
    }

    @Override
    public void displayData() {
        if (this.sex) {
            System.out.printf("|    %-10s|  %-17s|   %-6s|    Nam    |  %-7s|       %-12s|  %-7s|  %-8s  |\n",
                    studentId, studentName, age, studentClass.getClassName(), avgMark, gPA, studentStatus);
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.print("??i???m JavaScript: ");
            for (Float jsmark : listMarkJavaScript) {
                System.out.print(jsmark+", ");
            }
            System.out.println("");
            System.out.print("??i???m JavaCore  : ");
            for (Float jcmark : listMarkJavaCore) {
                System.out.print(jcmark+", ");
            }
            System.out.println("");
            System.out.print("??i???m JavaWeb   : ");
            for (Float jwmark : listMarkJavaWeb) {
                System.out.print(jwmark+", ");
            }
            System.out.println("");
        } else {
            System.out.printf("|    %-10s|  %-17s|   %-6s|    Nam    |  %-7s|       %-12s|  %-7s|  %-8s  |\n",
                    studentId, studentName, age, studentClass.getClassName(), avgMark, gPA, studentStatus);
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        }


    }
}
