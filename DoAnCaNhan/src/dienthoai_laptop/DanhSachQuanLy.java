/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoai_laptop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DanhSachQuanLy {

    ArrayList<DienThoai_Va_Laptop> arr = new ArrayList<>();

    public void themVaoDS(DienThoai_Va_Laptop dvl) {
        arr.add(dvl);
    }

    public boolean xoaTheoMaSP(String maSP) {
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getMaSP().equalsIgnoreCase(maSP)) {
                arr.remove(dvl);
                return true;
            }
        }
        return false;
    }

    public DienThoai_Va_Laptop timTheoMaSP(String maSP) {
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getMaSP().equalsIgnoreCase(maSP)) {
                return dvl;
            }
        }
        return null;
    }

    public ArrayList<DienThoai_Va_Laptop> getDStheoLoai(String loaiSP) {
        int n = arr.size();
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).getGiaban() < arr.get(j).getGiaban()) {
                    DienThoai_Va_Laptop temp = arr.set(i, arr.get(i));
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        if (loaiSP.equalsIgnoreCase("1")) {
            for (DienThoai_Va_Laptop dvl : arr) {
                if (dvl instanceof DienThoai) {
                    b.add(dvl);
                }
            }
        } else if (loaiSP.equalsIgnoreCase("2")) {
            for (DienThoai_Va_Laptop dvl : arr) {
                if (dvl instanceof LapTop) {
                    b.add(dvl);
                }
            }
        }

        return b;
    }

    public ArrayList<DienThoai_Va_Laptop> getDStheoGiaDOWN() {
        int n = arr.size();
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>(arr);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).getGiaban() < arr.get(j).getGiaban()) {
                    DienThoai_Va_Laptop temp = arr.set(i, arr.get(i));
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return b;
    }

    public ArrayList<DienThoai_Va_Laptop> getDStheoGiaUP() {
        int n = arr.size();
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>(arr);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).getGiaban() > arr.get(j).getGiaban()) { // Thay đổi điều kiện so sánh
                    DienThoai_Va_Laptop temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return b;
    }
    
    public ArrayList<DienThoai_Va_Laptop> getDSDuoi10Tr()   {
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>();
        int MuoiTrieu = 10000000;
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getGiaban()<MuoiTrieu) {
                b.add(dvl);
            }
        }
        return b;
    }
    
    public ArrayList<DienThoai_Va_Laptop> getDSTren10tr()   {
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>();
        int Muoi5Trieu = 10000000;
        int Hai5Trieu = 25000000;
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getGiaban()<Hai5Trieu && dvl.getGiaban() >Muoi5Trieu) {
                b.add(dvl);
            }
        }
        return b;
    }
    
    public ArrayList<DienThoai_Va_Laptop> getDSTren25tr()   {
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>();
        int Ba5Trieu = 35000000;
        int Hai5Trieu = 25000000;
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getGiaban()<Ba5Trieu && dvl.getGiaban() >Hai5Trieu) {
                b.add(dvl);
            }
        }
        return b;
    }
    
    public ArrayList<DienThoai_Va_Laptop> getDSTren35Tr()   {
        ArrayList<DienThoai_Va_Laptop> b = new ArrayList<>();
        int Ba5Trieu = 35000000;
        for (DienThoai_Va_Laptop dvl : arr) {
            if (dvl.getGiaban()>Ba5Trieu) {
                b.add(dvl);
            }
        }
        return b;
    }

    public void docFile(String tenFile) {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String s[] = line.split(", ");
                String maSp = s[1];
                String tenSP = s[2];
                String thuongHieu = s[3];
                boolean tinhTrang = DienThoai_Va_Laptop.chuyenChuoiThanhTinhTrang(s[4]);
                String RAM = s[5];
                String ROM = s[6];
                int giaBan = Integer.parseInt(s[15]);
                int soLuong = Integer.parseInt(s[16]);
                if (s[0].equalsIgnoreCase("Điện thoại")) {
                    String chip = s[7];
                    String mauSac = s[8];
                    String camTruoc = s[9];
                    String camSau = s[10];
                    DienThoai dt = new DienThoai(chip, mauSac, camTruoc, camSau, maSp, thuongHieu, RAM, ROM, tenSP, soLuong, giaBan, tinhTrang);
                    themVaoDS(dt);
                } else {
                    String CPU = s[11];
                    String CARD = s[12];
                    String ChatLieu = s[13];
                    Double trongLuong = Double.parseDouble(s[14]);
                    LapTop lt = new LapTop(CPU, CARD, ChatLieu, trongLuong, maSp, thuongHieu, RAM, ROM, tenSP, soLuong, giaBan, tinhTrang);
                    themVaoDS(lt);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void ghiFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (DienThoai_Va_Laptop dvl : arr) {
                bw.write(dvl.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

}
