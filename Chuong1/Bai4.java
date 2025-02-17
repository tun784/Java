/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong1;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        System.out.print("Nhap a: ");
        a = sc.nextInt();
        System.out.print("Nhap b: ");
        b = sc.nextInt();
        System.out.print("Nhap c: ");
        c = sc.nextInt();
        
        int max = (a>b) ? a : b;
        max = (c>max) ? c : max;
        
        int min = (a<b) ? a : b;
        min = (c < min) ? c : min;
        System.out.println("Max= " + max);
        System.out.println("Min= " + min);
        
    }
}
