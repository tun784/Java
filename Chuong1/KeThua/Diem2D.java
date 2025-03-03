package Chuong1.pkg38;

import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
1.24. Cài đặt lớp Diem2D (Điểm trong không gian 2 chiều) gồm:
     Thuộc tính: x, y là số nguyên.
     Các phương thức bao gồm :
         Hàm khởi tạo mặc định: Diem();
         Hàm khởi tạo có 2 tham số: Diem(int, int );
         Nhập tọa độ cho điểm từ bàn phím void nhapDiem ();
         Hiển thị ra màn hình tọa độ điểm theo dạng (x,y): void hienThi();
         Dời điểm đi 1 độ dời (dx, dy): void doiDiem(int dx, int dy);
         Lấy ra giá trị hoành độ của điểm: int giaTriX();
         Lấy ra giá trị tung độ của điểm: int giaiTriY();
         Tính khoảng cách từ điểm đó đến gốc tọa độ: float khoangCach();
         Tính khoảng cách từ điểm đó đến 1 điểm khác: float khoangCach(Diem d);
 */
public class Diem2D {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int x, y;
    
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public Diem2D(){
        x = rand.nextInt(20)-10;
        y = rand.nextInt(20)-10;
    }
    public Diem2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Diem2D(Diem2D d){
        this.x = d.x;
        this.y = d.y;
    }
    
    public void nhapDiem(){
        System.out.print("Nhap x: ");
        x = sc.nextInt();
        System.out.print("Nhap y: ");
        y = sc.nextInt();
    }
    public void hienThi(){
        System.out.println("(x,y)= (" + x + "," + y + ")");
    }
    public void doiDiem(int dx, int dy){ // dời điểm
        this.x += dx;
        this.y += dy;
    }
    public int giaTriX(){
        return this.x;
    }
    public int giaTriY(){
        return this.y;
    }
    public double khoangCach(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public double khoangCach(Diem2D d){
        return Math.sqrt(Math.pow(d.x - this.x, 2) + Math.pow(d.y - this.y, 2));
    }
}