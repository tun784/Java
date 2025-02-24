/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class VDMang2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int m,n;
        System.out.print("Nhap so dong= ");
        m = sc.nextInt();
        System.out.print("Nhap so cot= ");
        n = sc.nextInt();
        
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rand.nextInt(198)-99;
                System.out.print("a["+i+"]["+j+"]= ");
                System.out.println(arr[i][j]);
            }
        }
        System.out.println("");
        System.out.println("So dong: "+ arr.length);
        System.out.println("So cot: "+ arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j]+"\t");            
            System.out.println("");
        }
    }
}