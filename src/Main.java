import ra.entity.StudentClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.print("Nhập tên sinh viên: ");
            String studentName=sc.nextLine();
            if (studentName.trim().length()>10&&studentName.trim().length()<50){
                break;
            }else {
                System.out.println("Tên gồm 10-50 kí tự.");
            }
        }
    }

}