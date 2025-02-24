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
public class Mang1Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(399)-199;
        }
        for (int element:arr)
            System.out.print(element + " ");
        System.out.println("");
    }
}
