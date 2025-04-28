/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

public class class_sach {
    public String maSach;
    public String tenSach;
    public String tacGia;
    public String theLoai;
    public String tinhTrang; // "Có sẵn", "Đã mượn"
    
    public class_sach(String maSach, String tenSach, String tacGia, String theLoai, String tinhTrang) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.tinhTrang = tinhTrang;
    }
}