/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dienthoai_laptop;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_GiaoDien extends javax.swing.JFrame {

    private final Undo_Redo<MasterForm> forms = new Undo_Redo<>();
    DefaultTableModel model;
    DanhSachQuanLy dsql;

    /**
     * Creates new form GUI_GiaoDien
     */
    public GUI_GiaoDien() {
        initComponents();
        myInit();
    }

    public void myInit() {
        setTitle("CT Quan Ly Dien Thoai Laptop");
        setLocationRelativeTo(null);
        dsql = new DanhSachQuanLy();
        model = (DefaultTableModel) tableAAA.getModel();
        tableAAA.setModel(model);
        //xu li 2 radio Nam Nu
        ButtonGroup group = new ButtonGroup();
        group.add(radioCu);
        group.add(radioMoi);
        docFile();
        txtCAM1.setVisible(false);
        txtCAM2.setVisible(false);
        txtChip.setVisible(false);
        txtMau.setVisible(false);
        lChip.setVisible(false);
        lMauSac.setVisible(false);
        lCamTrc.setVisible(false);
        lCamSau.setVisible(false);

        txtCPU.setVisible(true);
        txtCard.setVisible(true);
        txtChatLieu.setVisible(true);
        txtTrongLuong.setVisible(true);
        lCPU.setVisible(true);
        lCard.setVisible(true);
        lChatLieu.setVisible(true);
        lTrongLuong.setVisible(true);
        jpanelDMCON2.setVisible(true);
        
        jpanelTo.setBackground(Color.white);
        jpanelChucNang.setBackground(Color.white);
        jpanelDanhMuc.setBackground(Color.white);
        jpanelDanhMucCon1.setBackground(Color.white);
        jpanelDMCON2.setBackground(Color.white);
        jpanelDMCON3.setBackground(Color.white);
    }

    public void themMotDongVaoTable(IDienThoai_Laptop dvl) {
        if (dvl instanceof DienThoai) {
            DienThoai dt = (DienThoai) dvl;
            model.addRow(new Object[]{
                dt.getMaSP(),
                dt.getTenSP(),
                dt.getThuonghieu(),
                DienThoai_Va_Laptop.chuyenTinhTrangThanhChuoi(dt.isTinhTrang()),
                dt.getRAM(),
                dt.getROM(),
                dt.getChip(),
                dt.getMausac(),
                dt.getCamTruoc(),
                dt.getCamSau(),
                "",
                "",
                "",
                "",
                dt.getGiaban()+" VNĐ",
                dt.getSoluong()
            });
        } else if (dvl instanceof LapTop) {
            LapTop lt = (LapTop) dvl;
            model.addRow(new Object[]{
                lt.getMaSP(),
                lt.getTenSP(),
                lt.getThuonghieu(),
                DienThoai_Va_Laptop.chuyenTinhTrangThanhChuoi(lt.isTinhTrang()),
                lt.getRAM(),
                lt.getROM(),
                "",
                "",
                "",
                "",
                lt.getCPU(),
                lt.getCard(),
                lt.getChatLieu(),
                lt.getTrongLuong()+" kg",
                lt.getGiaban()+" VNĐ",
                lt.getSoluong()
            });
        }
    }

    public void LayDSRieng() {
        do {
            String loaiSP = JOptionPane.showInputDialog("Nhap loai San Pham muon in.\n"
                    + "1. Điện thoại    |   2. Laptop");
            if (loaiSP.equalsIgnoreCase("2") || loaiSP.equalsIgnoreCase("1")) {
                xoaBang();
                for (DienThoai_Va_Laptop dienThoai_Va_Laptop : dsql.getDStheoLoai(loaiSP)) {
                    themMotDongVaoTable(dienThoai_Va_Laptop);
                }
                break;
            } else {
                JOptionPane.showConfirmDialog(null, "Vui lòng nhập lại.");
            }
        } while (true);
    }

    public void LayDSTheoGiaUP() {
        for (DienThoai_Va_Laptop dienThoai_Va_Laptop : dsql.getDStheoGiaDOWN()) {
            themMotDongVaoTable(dienThoai_Va_Laptop);
        }
    }

    public void LayDSTheoGiaDOWN() {
        for (DienThoai_Va_Laptop dienThoai_Va_Laptop : dsql.getDStheoGiaUP()) {
            themMotDongVaoTable(dienThoai_Va_Laptop);
        }
    }

    public void INDS() {
        for (DienThoai_Va_Laptop dvl : dsql.arr) {
            themMotDongVaoTable(dvl);
        }
    }
    
    public void DSDuoi10tr()    {
        for (DienThoai_Va_Laptop dvl : dsql.getDSDuoi10Tr()) {
            themMotDongVaoTable(dvl);
        }
    }
    
    public void DSTren10tr()    {
        for (DienThoai_Va_Laptop dvl : dsql.getDSTren10tr()) {
            themMotDongVaoTable(dvl);
        }
    }
    
    public void DSTren25tr()    {
        for (DienThoai_Va_Laptop dvl : dsql.getDSTren25tr()) {
            themMotDongVaoTable(dvl);
        }
    }
    
    public void DSTren35Tr()    {
        for (DienThoai_Va_Laptop dvl : dsql.getDSTren35Tr()) {
            themMotDongVaoTable(dvl);
        }
    }

    public void docFile() {
        dsql.docFile("Thanh.txt");
        INDS();
    }

    public void xoaBang() {
        int n = tableAAA.getRowCount();   //Lay so dong
        //xoa tu duoi len
        for (int i = n; i > 0; i--) {
            model.removeRow(i - 1);
        }
    }

    public void Undo() {
        for (MasterForm form : forms) {

        }
    }

    public boolean kiemTra() {
        for (DienThoai_Va_Laptop dvl : dsql.arr) {
            if (txtMaSP.getText().isEmpty()
                    || txtTenSP.getText().isEmpty()
                    || txtThuongHieu.getText().isEmpty()
                    || (radioCu.getText().isBlank() || radioMoi.getText().isBlank())
                    || txtRAM.getText().isEmpty()
                    || txtROM.getText().isEmpty()
                    || txtGiaBan.getText().isEmpty()
                    || txtSoLuong.getText().isEmpty()) {
                if (comboboxloai.getSelectedIndex() == 0
                        || txtCPU.getText().isEmpty()
                        || txtCard.getText().isEmpty()
                        || txtChatLieu.getText().isEmpty()
                        || txtTrongLuong.getText().isEmpty()) {
                    return true;
                } else if (comboboxloai.getSelectedIndex() == 1
                        || txtChip.getText().isEmpty()
                        || txtMau.getText().isEmpty()
                        || txtCAM1.getText().isEmpty()
                        || txtCAM2.getText().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public DienThoai NhapDienThoai() {
        String maSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        String thuongHieu = txtThuongHieu.getText();
        boolean tinhTrang = (radioMoi.isSelected() ? true : false);
        String RAM = txtRAM.getText();
        String ROM = txtROM.getText();
        String chip = txtChip.getText();
        String mauSac = txtMau.getText();
        double camTruoc = Double.parseDouble(txtCAM1.getText());
        double camSau = Double.parseDouble(txtCAM2.getText());
        int giaBan = Integer.parseInt(txtGiaBan.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        DienThoai dt = new DienThoai(chip, mauSac, mauSac, mauSac, maSP, thuongHieu, maSP, chip, TenSP, soLuong, giaBan, tinhTrang);
        return dt;
    }

    public LapTop NhapLaptop() {
        String maSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        String thuongHieu = txtThuongHieu.getText();
        boolean tinhTrang = (radioMoi.isSelected() ? true : false);
        String RAM = txtRAM.getText();
        String ROM = txtROM.getText();
        String CPU = txtCPU.getText();
        String Card = txtCard.getText();
        String chatLieu = txtChatLieu.getText();
        double trongLuong = Double.parseDouble(txtTrongLuong.getText());
        int giaBan = Integer.parseInt(txtGiaBan.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        LapTop lt = new LapTop(CPU, Card, chatLieu, trongLuong, maSP, thuongHieu, RAM, ROM, TenSP, soLuong, giaBan, tinhTrang);
        return lt;
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn thoát khỏi Chương trình?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jpanelTo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAAA = new javax.swing.JTable();
        jpanelDanhMuc = new javax.swing.JPanel();
        jpanelDMCON2 = new javax.swing.JPanel();
        txtCPU = new javax.swing.JTextField();
        lCPU = new javax.swing.JLabel();
        txtCard = new javax.swing.JTextField();
        lCard = new javax.swing.JLabel();
        txtChatLieu = new javax.swing.JTextField();
        lChatLieu = new javax.swing.JLabel();
        txtTrongLuong = new javax.swing.JTextField();
        lTrongLuong = new javax.swing.JLabel();
        lChip = new javax.swing.JLabel();
        txtChip = new javax.swing.JTextField();
        lMauSac = new javax.swing.JLabel();
        txtMau = new javax.swing.JTextField();
        lCamTrc = new javax.swing.JLabel();
        txtCAM1 = new javax.swing.JTextField();
        lCamSau = new javax.swing.JLabel();
        txtCAM2 = new javax.swing.JTextField();
        jpanelDanhMucCon1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboboxloai = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtThuongHieu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        radioMoi = new javax.swing.JRadioButton();
        radioCu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtRAM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtROM = new javax.swing.JTextField();
        jpanelDMCON3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jpanelChucNang = new javax.swing.JPanel();
        btThemMoi = new javax.swing.JButton();
        btGhiFile = new javax.swing.JButton();
        btCapNhat = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSapXepTheoLoai = new javax.swing.JButton();
        btSapXepTrongLuong = new javax.swing.JButton();
        btSapXepTheoGia = new javax.swing.JButton();
        comboMucTien = new javax.swing.JComboBox<>();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1211, -1, -1));

        tableAAA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Thương hiệu", "Tình trạng", "RAM", "ROM", "Chip", "Màu sắc", "Cam trước", "Cam sau", "CPU", "Card", "Chất liệu", "Trọng lượng", "Giá bán", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAAA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAAAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAAA);

        jpanelDanhMuc.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Danh Mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(51, 0, 255))); // NOI18N

        txtCPU.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lCPU.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lCPU.setText("CPU:");

        txtCard.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lCard.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lCard.setText("Card đồ họa:");

        txtChatLieu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lChatLieu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lChatLieu.setText("Chất liệu:");

        txtTrongLuong.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lTrongLuong.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lTrongLuong.setText("Trọng lượng:");

        lChip.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lChip.setText("Chip:");

        txtChip.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lMauSac.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lMauSac.setText("Màu sắc:");

        txtMau.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lCamTrc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lCamTrc.setText("Cam trước:");

        txtCAM1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lCamSau.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lCamSau.setText("Cam sau:");

        txtCAM2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpanelDMCON2Layout = new javax.swing.GroupLayout(jpanelDMCON2);
        jpanelDMCON2.setLayout(jpanelDMCON2Layout);
        jpanelDMCON2Layout.setHorizontalGroup(
            jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lChatLieu)
                    .addComponent(lCard)
                    .addComponent(lCPU)
                    .addComponent(lTrongLuong))
                .addGap(18, 18, 18)
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTrongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtChatLieu)
                    .addComponent(txtCard)
                    .addComponent(txtCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                        .addComponent(lCamTrc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCAM1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                        .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lCamSau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCAM2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                                        .addComponent(lMauSac)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMau))
                                    .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(lChip)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChip)))))
                        .addContainerGap())))
        );
        jpanelDMCON2Layout.setVerticalGroup(
            jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDMCON2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCPU)
                    .addComponent(txtChip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lChip))
                .addGap(18, 18, 18)
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lCard)
                        .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lMauSac))
                .addGap(18, 18, 18)
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lChatLieu)
                    .addComponent(lCamTrc)
                    .addComponent(txtCAM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelDMCON2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTrongLuong)
                    .addComponent(lCamSau)
                    .addComponent(txtCAM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Chọn loại:");

        comboboxloai.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        comboboxloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Điện thoại" }));
        comboboxloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxloaiActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel19.setText("Tên sản phẩm:");

        txtMaSP.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Mã SP");

        txtTenSP.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Thương hiệu:");

        txtThuongHieu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Tình trạng:");

        radioMoi.setText("Mới");

        radioCu.setText("Cũ");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Dung lượng RAM:");

        txtRAM.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Bộ nhớ trong:");

        txtROM.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpanelDanhMucCon1Layout = new javax.swing.GroupLayout(jpanelDanhMucCon1);
        jpanelDanhMucCon1.setLayout(jpanelDanhMucCon1Layout);
        jpanelDanhMucCon1Layout.setHorizontalGroup(
            jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboboxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioCu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtROM, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpanelDanhMucCon1Layout.setVerticalGroup(
            jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDanhMucCon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboboxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioMoi)
                    .addComponent(radioCu))
                .addGap(21, 21, 21)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelDanhMucCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtROM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Số lượng:");

        txtGiaBan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel18.setText("Giá bán:");

        javax.swing.GroupLayout jpanelDMCON3Layout = new javax.swing.GroupLayout(jpanelDMCON3);
        jpanelDMCON3.setLayout(jpanelDMCON3Layout);
        jpanelDMCON3Layout.setHorizontalGroup(
            jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDMCON3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtSoLuong))
                .addContainerGap())
        );
        jpanelDMCON3Layout.setVerticalGroup(
            jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDMCON3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jpanelDMCON3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelDanhMucLayout = new javax.swing.GroupLayout(jpanelDanhMuc);
        jpanelDanhMuc.setLayout(jpanelDanhMucLayout);
        jpanelDanhMucLayout.setHorizontalGroup(
            jpanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDanhMucLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelDanhMucCon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelDanhMucLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jpanelDMCON3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelDanhMucLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpanelDMCON2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(276, 276, 276))
        );
        jpanelDanhMucLayout.setVerticalGroup(
            jpanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDanhMucLayout.createSequentialGroup()
                .addComponent(jpanelDMCON2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpanelDMCON3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpanelDanhMucCon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpanelChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        btThemMoi.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btThemMoi.setText("Thêm mới");
        btThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemMoiActionPerformed(evt);
            }
        });

        btGhiFile.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btGhiFile.setText("Ghi file");
        btGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhiFileActionPerformed(evt);
            }
        });

        btCapNhat.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btCapNhat.setText("Cập nhật");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSapXepTheoLoai.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btSapXepTheoLoai.setText("Sắp xếp theo loại SP");
        btSapXepTheoLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepTheoLoaiActionPerformed(evt);
            }
        });

        btSapXepTrongLuong.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btSapXepTrongLuong.setText("Sắp xếp theo tên");
        btSapXepTrongLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepTrongLuongActionPerformed(evt);
            }
        });

        btSapXepTheoGia.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btSapXepTheoGia.setText("Sắp xếp theo giá");
        btSapXepTheoGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepTheoGiaActionPerformed(evt);
            }
        });

        comboMucTien.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        comboMucTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dưới 10tr", "15tr - 20tr", "20tr - 35tr", "Trên 35tr" }));
        comboMucTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMucTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelChucNangLayout = new javax.swing.GroupLayout(jpanelChucNang);
        jpanelChucNang.setLayout(jpanelChucNangLayout);
        jpanelChucNangLayout.setHorizontalGroup(
            jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelChucNangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCapNhat)
                    .addGroup(jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btThemMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btGhiFile, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(36, 36, 36)
                .addGroup(jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelChucNangLayout.createSequentialGroup()
                        .addComponent(btSapXepTheoLoai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelChucNangLayout.createSequentialGroup()
                        .addGroup(jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpanelChucNangLayout.createSequentialGroup()
                                .addComponent(btSapXepTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpanelChucNangLayout.createSequentialGroup()
                                .addComponent(btSapXepTheoGia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboMucTien, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(187, 187, 187))))
        );
        jpanelChucNangLayout.setVerticalGroup(
            jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelChucNangLayout.createSequentialGroup()
                .addGroup(jpanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSapXepTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMucTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btSapXepTheoLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSapXepTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(jpanelChucNangLayout.createSequentialGroup()
                .addComponent(btThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btGhiFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelToLayout = new javax.swing.GroupLayout(jpanelTo);
        jpanelTo.setLayout(jpanelToLayout);
        jpanelToLayout.setHorizontalGroup(
            jpanelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelToLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jpanelToLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jpanelDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 942, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanelChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jpanelToLayout.setVerticalGroup(
            jpanelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelToLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jpanelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanelChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        getContentPane().add(jpanelTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMoiActionPerformed
        // TODO add your handling code here:

        if (kiemTra()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin!");
        } else {
            if (comboboxloai.getSelectedIndex() == 1) {
                DienThoai dt = NhapDienThoai();
                dsql.themVaoDS(dt);
                themMotDongVaoTable(dt);

            } else {
                LapTop lt = NhapLaptop();
                dsql.themVaoDS(lt);
                themMotDongVaoTable(lt);
            }
        }
    }//GEN-LAST:event_btThemMoiActionPerformed

    private void tableAAAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAAAMouseClicked
        // TODO add your handling code here:
        DienThoai_Va_Laptop dvl = null;
        int i = tableAAA.getSelectedRow();
        if (evt.getClickCount() == 2) {
            txtMaSP.setText(model.getValueAt(i, 0).toString());
            txtTenSP.setText(model.getValueAt(i, 1).toString());
            txtThuongHieu.setText(model.getValueAt(i, 2).toString());
            if (model.getValueAt(i, 3).toString().equalsIgnoreCase("Mới")) {
                radioMoi.setSelected(true);
            } else {
                radioCu.setSelected(true);
            }
            txtRAM.setText(model.getValueAt(i, 4).toString());
            txtROM.setText(model.getValueAt(i, 5).toString());

            if (model.getValueAt(i, 10) == "") {
                comboboxloai.setSelectedIndex(1);
                txtChip.setText(model.getValueAt(i, 6).toString());
                txtMau.setText(model.getValueAt(i, 7).toString());
                txtCAM1.setText(model.getValueAt(i, 8).toString());
                txtCAM2.setText(model.getValueAt(i, 9).toString());

                txtCPU.setVisible(false);
                txtCard.setVisible(false);
                txtChatLieu.setVisible(false);
                txtTrongLuong.setVisible(false);
                lCPU.setVisible(false);
                lCard.setVisible(false);
                lChatLieu.setVisible(false);
                lTrongLuong.setVisible(false);
                jpanelDMCON2.setVisible(false);
            } else if (model.getValueAt(i, 6) == "") {
                comboboxloai.setSelectedIndex(0);
                txtCPU.setText(model.getValueAt(i, 10).toString());
                txtCard.setText(model.getValueAt(i, 11).toString());
                txtChatLieu.setText(model.getValueAt(i, 12).toString());
                txtTrongLuong.setText(model.getValueAt(i, 13).toString());

                txtCAM1.setVisible(false);
                txtCAM2.setVisible(false);
                txtChip.setVisible(false);
                txtMau.setVisible(false);
                lChip.setVisible(false);
                lMauSac.setVisible(false);
                lCamTrc.setVisible(false);
                lCamSau.setVisible(false);

            }
            txtGiaBan.setText(model.getValueAt(i, 14).toString());
            txtSoLuong.setText(model.getValueAt(i, 15).toString());

        }
    }//GEN-LAST:event_tableAAAMouseClicked

    private void btGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhiFileActionPerformed
        do {
            String tenFile = JOptionPane.showInputDialog("Nhap ten File.");
            if (tenFile.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Lỗi, hãy đặt lại tên file.");
            } else {
                dsql.ghiFile(tenFile);
                JOptionPane.showMessageDialog(null, "Ghi File thành công.");
                break;
            }
        } while (true);
    }//GEN-LAST:event_btGhiFileActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        // TODO add your handling code here:
        DienThoai_Va_Laptop dvl = dsql.timTheoMaSP(txtMaSP.getText());
        if (dvl == null) {
            JOptionPane.showMessageDialog(null, "Khong tim thay.");
        } else {
            dvl.setTenSP(txtTenSP.getText());
            dvl.setThuonghieu(txtThuongHieu.getText());
            dvl.setTinhTrang(radioMoi.isSelected() ? true : false);
            dvl.setRAM(txtRAM.getText());
            dvl.setROM(txtROM.getText());
            dvl.setGiaban(Integer.parseInt(txtGiaBan.getText()));
            dvl.setSoluong(Integer.parseInt(txtSoLuong.getText()));
            if (dvl instanceof DienThoai) {
                DienThoai dt = (DienThoai) dvl;
                dt.setChip(txtChip.getText());
                dt.setCamSau(txtCAM1.getText());
                dt.setCamTruoc(txtCAM2.getText());
                dt.setMausac(txtMau.getText());
            } else {
                LapTop lt = (LapTop) dvl;
                lt.setCPU(txtCPU.getText());
                lt.setCard(txtCard.getText());
                lt.setChatLieu(txtChatLieu.getText());
                lt.setTrongLuong(Double.parseDouble(txtTrongLuong.getText()));
            }
            xoaBang();
            themMotDongVaoTable(dvl);
        }
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        String maSP = txtMaSP.getText();
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa sản phẩm đã chọn?");
        if (luaChon == JOptionPane.YES_OPTION) {
            if (dsql.xoaTheoMaSP(maSP)) {
                JOptionPane.showMessageDialog(null, "Xoa thanh cong.");
                xoaBang();
                INDS();
            } else {
                JOptionPane.showMessageDialog(null, "Khong tim thay.");
            }
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSapXepTheoLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepTheoLoaiActionPerformed
        // TODO add your handling code here:
        LayDSRieng();
    }//GEN-LAST:event_btSapXepTheoLoaiActionPerformed

    private void btSapXepTrongLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepTrongLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSapXepTrongLuongActionPerformed

    private void btSapXepTheoGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepTheoGiaActionPerformed
        // TODO add your handling code here:
        do {
            String cachThuc = JOptionPane.showInputDialog("Chọn cách thức muốn in.\n"
                    + "1. Thấp->Cao    |   2. Cao->Thấp");
            if (cachThuc.equalsIgnoreCase("2") || cachThuc.equalsIgnoreCase("1")) {
                xoaBang();
                if (cachThuc.equalsIgnoreCase("1")) {
                    LayDSTheoGiaUP();
                } else {
                    LayDSTheoGiaDOWN();
                }
                break;
            } else {
                JOptionPane.showConfirmDialog(null, "Vui lòng nhập lại.");
            }
        } while (true);
    }//GEN-LAST:event_btSapXepTheoGiaActionPerformed

    private void comboMucTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMucTienActionPerformed
        // TODO add your handling code here:
        if (comboMucTien.getSelectedIndex()==0) {
            xoaBang();
            DSDuoi10tr();
        } else if (comboMucTien.getSelectedIndex()==1) {
            xoaBang();
            DSTren10tr();
        } else if (comboMucTien.getSelectedIndex()==2) {
            xoaBang();
            DSTren25tr();
        } else {
            xoaBang();
            DSTren35Tr();
        }
    }//GEN-LAST:event_comboMucTienActionPerformed

    private void comboboxloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxloaiActionPerformed
        // TODO add your handling code here:
        if (comboboxloai.getSelectedIndex() == 1) {
            txtCPU.setVisible(false);
            txtCard.setVisible(false);
            txtChatLieu.setVisible(false);
            txtTrongLuong.setVisible(false);
            lCPU.setVisible(false);
            lCard.setVisible(false);
            lChatLieu.setVisible(false);
            lTrongLuong.setVisible(false);

            txtCAM1.setVisible(true);
            txtCAM2.setVisible(true);
            txtChip.setVisible(true);
            txtMau.setVisible(true);
            lChip.setVisible(true);
            lMauSac.setVisible(true);
            lCamTrc.setVisible(true);
            lCamSau.setVisible(true);

        } else {
            txtCAM1.setVisible(false);
            txtCAM2.setVisible(false);
            txtChip.setVisible(false);
            txtMau.setVisible(false);
            lChip.setVisible(false);
            lMauSac.setVisible(false);
            lCamTrc.setVisible(false);
            lCamSau.setVisible(false);

            txtCPU.setVisible(true);
            txtCard.setVisible(true);
            txtChatLieu.setVisible(true);
            txtTrongLuong.setVisible(true);
            lCPU.setVisible(true);
            lCard.setVisible(true);
            lChatLieu.setVisible(true);
            lTrongLuong.setVisible(true);
            jpanelDMCON2.setVisible(true);
        }
    }//GEN-LAST:event_comboboxloaiActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_GiaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btGhiFile;
    private javax.swing.JButton btSapXepTheoGia;
    private javax.swing.JButton btSapXepTheoLoai;
    private javax.swing.JButton btSapXepTrongLuong;
    private javax.swing.JButton btThemMoi;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> comboMucTien;
    private javax.swing.JComboBox<String> comboboxloai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpanelChucNang;
    private javax.swing.JPanel jpanelDMCON2;
    private javax.swing.JPanel jpanelDMCON3;
    private javax.swing.JPanel jpanelDanhMuc;
    private javax.swing.JPanel jpanelDanhMucCon1;
    private javax.swing.JPanel jpanelTo;
    private javax.swing.JLabel lCPU;
    private javax.swing.JLabel lCamSau;
    private javax.swing.JLabel lCamTrc;
    private javax.swing.JLabel lCard;
    private javax.swing.JLabel lChatLieu;
    private javax.swing.JLabel lChip;
    private javax.swing.JLabel lMauSac;
    private javax.swing.JLabel lTrongLuong;
    private javax.swing.JRadioButton radioCu;
    private javax.swing.JRadioButton radioMoi;
    private javax.swing.JTable tableAAA;
    private javax.swing.JTextField txtCAM1;
    private javax.swing.JTextField txtCAM2;
    private javax.swing.JTextField txtCPU;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextField txtChip;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMau;
    private javax.swing.JTextField txtRAM;
    private javax.swing.JTextField txtROM;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThuongHieu;
    private javax.swing.JTextField txtTrongLuong;
    // End of variables declaration//GEN-END:variables
}
