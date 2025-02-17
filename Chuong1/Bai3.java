/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong1;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        System.out.print("Nhap a: ");
        a = sc.nextInt();
        System.out.print("Nhap b: ");
        b = sc.nextInt();
        
        if (a>b)
            System.out.println("So " + a + " la so lon hon con so " + b + " la so nho hon.");
        if (a<b)
            System.out.println("So " + b + " la so lon hon con so " + a + " la so nho hon.");
        else
            System.out.println("Hai so bang nhau.");
    }
}
