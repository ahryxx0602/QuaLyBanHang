/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoai_laptop;

/**
 *
 * @author Admin
 */
public class DienThoai extends DienThoai_Va_Laptop {

    String chip, mausac, camTruoc, camSau;

    public DienThoai() {
    }

    public DienThoai(String chip, String mausac, String camTruoc, String camSau, String maSP, String thuonghieu, String RAM, String ROM, String tenSP, int soluong, int giaban, boolean tinhTrang) {
        super(maSP, thuonghieu, RAM, ROM, tenSP, soluong, giaban, tinhTrang);
        this.chip = chip;
        this.mausac = mausac;
        this.camTruoc = camTruoc;
        this.camSau = camSau;
    }

 
    

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getCamTruoc() {
        return camTruoc;
    }

    public void setCamTruoc(String camTruoc) {
        this.camTruoc = camTruoc;
    }

    public String getCamSau() {
        return camSau;
    }

    public void setCamSau(String camSau) {
        this.camSau = camSau;
    }

    

    @Override
    public double tinhThanhTieṇ̣() {
            return soluong * giaban;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + chip + "\t" + mausac + "\t" + camTruoc + "\t" + camSau;
    }

}
