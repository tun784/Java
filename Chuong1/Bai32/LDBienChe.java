/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai32;

/**
 *
 * @author Administrator
 */
public abstract class LDBienChe extends NguoiLaoDong{
    protected double HSL;
    public final static long LCS = 1490000;

    public double getHSL() {
        return HSL;
    }

    public void setHSL(double HSL) {
        this.HSL = HSL;
    }

    public LDBienChe() {
        super();
        HSL = 0.0;
    }

    public LDBienChe(String maSo, String hoTen, int namSinh, double HSL) {
        super(maSo, hoTen, namSinh);
        this.HSL = HSL;
    }    
}
