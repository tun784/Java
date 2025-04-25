package pkgktgk;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class SanPham implements Serializable {
    public String MaSP, TenSP, DVT;
    public int SL;
    public double DonGia;
    
    public SanPham(){}
    
    public SanPham(String MaSP, String TenSP, String DVT, int SL, double DonGia){
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DVT = DVT;
        this.SL = SL;
        this.DonGia = DonGia;
    }
    
    public double getThanhTien() {
        return SL * DonGia;
    }
}