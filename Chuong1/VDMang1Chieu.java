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
public class VDMang1Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {4,6,3,9,8};
        System.out.print("In cac gia tri trong mang dung foreach: ");
        for (int pt:a)
            System.out.print(pt + " ");
        System.out.println("");
        
        System.out.print("In cac gia tri trong mang theo cach truyen thong: ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]+" ");
    }
}