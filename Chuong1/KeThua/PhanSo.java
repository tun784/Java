/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong1.pkg38;

/**
 *
 * @author Administrator
 */
public class PhanSo {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    public int tu, mau;
    
    public PhanSo(){
        tu = rand.nextInt(20)-10;
        mau = rand.nextInt(19)+1;
    }    
    public PhanSo(int tu, int mau){
        this.tu = tu;
        this.mau = mau;
    }
    public PhanSo(PhanSo p){
        this.tu = p.tu;
        this.mau = p.mau;
    }
    
    public void nhapPhanSo(){
        System.out.print("Nhap tu so: ");
        this.tu = sc.nextInt();
        System.out.print("Nhap mau so: ");
        this.mau = sc.nextInt();
        while (this.mau == 0){
            System.out.print("mau so bang " + mau + ". Xin vui long nhap lai mau so: ");
            this.mau = sc.nextInt();
        }
    }
    public void hienThi(){
        if (tu == 0 || mau == 1)
            System.out.println(tu);
        else
            System.out.println("(tu/mau)= (" + tu + "/" + mau + ")");
    }
    public void swap(){
        int t = tu;
        tu = mau;
        mau = t;
    }
    public void nghichDao(){
        if (tu == 0)
            return;
        else
            swap();
    }
    public double tinhGiaTriThuc(){
        return this.tu / this.mau;
    }
}
