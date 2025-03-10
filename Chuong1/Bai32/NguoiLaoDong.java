/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai32;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public abstract class NguoiLaoDong {
    protected String maSo, hoTen;
    protected int namSinh;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public NguoiLaoDong() {
        maSo = "00000000";
        hoTen = "NULL_";
        namSinh = 1900;
    }
    public NguoiLaoDong(String maSo, String hoTen, int namSinh) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }
    
    public abstract double tinhLuong();
    public void xuat(){
        System.out.printf("Ma so: %s ", maSo);
        System.out.printf("Ho ten: %s ", hoTen);
        System.out.println("Nam sinh: " + namSinh);
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);        
        
        System.out.print("Nhap ma so: ");
        maSo = sc.nextLine();
        System.out.println("Nhap ho ten: ");
        hoTen = sc.nextLine();
        sc.nextLine();
        System.out.println("Nhap nam sinh");
        namSinh = sc.nextInt();
    }
    public void nhapRandom(){
        Random rand = new Random();
        maSo = rand.toString();
        hoTen = rand.toString();
        namSinh = rand.nextInt();
    }
}
