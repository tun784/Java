/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Chuong1.pkg38;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
                
        Diem2D a = new Diem2D();
        Diem2D b = new Diem2D();
        
        a.hienThi();
        b.hienThi();
        
        System.out.println(a.khoangCach());
        System.out.println(b.khoangCach());
        System.out.println(a.khoangCach(b));
        System.out.println("");
        
        PhanSo p1 = new PhanSo();
        PhanSo p2 = new PhanSo();
        
        System.out.println(p1.tinhGiaTriThuc());
        System.out.println(p2.tinhGiaTriThuc());
    }
    
}
