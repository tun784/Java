package Chuong1;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class BaiTap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        System.out.print("Nhap chuoi: ");
        str = s.nextLine();
        // In ra các kí tự viết hoa có trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c))
                System.out.print(c + " ");
        }
        System.out.println("");
        // Tổng các giá trị là số có trong chuối
        int sum = 0;
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (Character.isDigit(c))
                sum += Character.getNumericValue(c);
        }
        System.out.println("Tong cac gia tri la so co trong chuoi: " + sum);
        // Chuỗi sau khi chuyển toàn bộ thành chữ hoa
        str.toUpperCase();
        System.out.println(str);
    }    
}
