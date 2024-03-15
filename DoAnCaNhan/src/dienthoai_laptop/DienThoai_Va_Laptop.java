package dienthoai_laptop;

import java.text.DecimalFormat;

public abstract class DienThoai_Va_Laptop implements IDienThoai_Laptop {

    String maSP, thuonghieu, RAM, ROM, tenSP;
    int soluong, giaban;
    boolean tinhTrang;

    public abstract double tinhThanhTieṇ̣();

    public DienThoai_Va_Laptop() {
    }

    public DienThoai_Va_Laptop(String maSP, String thuonghieu, String RAM, String ROM, String tenSP, int soluong, int giaban, boolean tinhTrang) {
        this.maSP = maSP;
        this.thuonghieu = thuonghieu;
        this.RAM = RAM;
        this.ROM = ROM;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.giaban = giaban;
        this.tinhTrang = tinhTrang;
    }

    

    

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    

    @Override
    public String toString() {
        return "\t"+maSP+"\t"+tenSP+"\t"+thuonghieu+"\t"+RAM+"\t"+ROM+"\t"+chuyenTinhTrangThanhChuoi(tinhTrang)+"\t"+giaban+"\t"+soluong;
    }

    public static String chuyenTinhTrangThanhChuoi(boolean tinhTrang)  {
        if (tinhTrang) {
            return "Mới";
        }   else {
            return "Cũ";
        }
    }
    
    public static boolean chuyenChuoiThanhTinhTrang(String str)    {
        if (str.equalsIgnoreCase("Mới"))     {
            return true;
        }   
            return false;
    }
    
    public static String dinhDangSo(double n) {
        DecimalFormat df=new DecimalFormat("###,###,###");   //
        return df.format(n);
    }
    
    public static int chuyenVeSoBinhThuong(String formattedNumber) {
        try {
            return Integer.parseInt(formattedNumber.replaceAll(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
