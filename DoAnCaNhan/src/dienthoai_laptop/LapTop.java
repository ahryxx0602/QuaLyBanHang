/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoai_laptop;

/**
 *
 * @author Admin
 */
public class LapTop extends DienThoai_Va_Laptop{
    String CPU, Card, ChatLieu;
    double trongLuong;

    public LapTop() {
    }

    public LapTop(String CPU, String Card, String ChatLieu, double trongLuong, String maSP, String thuonghieu, String RAM, String ROM, String tenSP, int soluong, int giaban, boolean tinhTrang) {
        super(maSP, thuonghieu, RAM, ROM, tenSP, soluong, giaban, tinhTrang);
        this.CPU = CPU;
        this.Card = Card;
        this.ChatLieu = ChatLieu;
        this.trongLuong = trongLuong;
    }



    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String Card) {
        this.Card = Card;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public double getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(double trongLuong) {
        this.trongLuong = trongLuong;
    }

    
    @Override
    public double tinhThanhTieṇ̣() {
            return soluong * giaban;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+CPU+"\t"+Card+"\t"+ChatLieu+"\t"+trongLuong;
    }
    
    
}
