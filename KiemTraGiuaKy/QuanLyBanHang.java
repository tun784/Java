/*
Nút “Thêm” dùng để bổ sung vào List và đổ dữ liệu lên bảng, xóa trắng các ô nhập trên form khi đã thêm
thành công.
Kiểm các lỗi sau khi nhấp nút “thêm” và nút “sửa”
    Không để trống mã, không cho phép trùng mã nếu bổ sung mới.
    Không để trống tên sản phẩm, số lượng và đơn giá.
    Số lượng và đơn giá phải là kiểu số, không âm.
Nút “Xóa” dùng để xóa sản phẩm theo Mã sản phẩm, nếu xóa thành công thì xuất hiện cửa sổ JOptionPane
thông báo đã xóa thành công. Cần kiểm lỗi không để trống mã.
Nút “Sửa” sửa đổi thông tin sản phẩm đang được chọn trên bảng.
Nút “Tìm kiếm” dùng để tìm sản phẩm theo mã, nếu có thì sẽ hiển thị chi tiết sản phẩm đó trên các textbox, nếu không có thì hiển thị cửa sổ JOptionPane thông báo không có sản phẩm này.
Khi nhấp chuột vào một hàng trên bảng thì thông tin chi tiết được hiển thị lên form
Nút “Mở tệp” để đọc file dữ liệu và đưa vào List<SanPham>
Thông tin sản phẩm đầu tiên trong List được hiện lên form
Nếu không có sản phẩm nào thì các textbox sẽ để trống
Bảng hiển thị danh sách sản phẩm trong List
Nút “Lưu tệp” sẽ thực hiện việc lưu dữ liệu xuống file
Nút “Sắp xếp theo MaSP” tăng dần, Nút “Sắp xếp theo giá SP” giảm dần
Tính tổng tiền của các sản phẩm
 */
package pkgktgk;

/**
 *
 * @author ktgk
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.filechooser.FileNameExtensionFilter;

public class QuanLyBanHang extends javax.swing.JFrame {
    private ArrayList<SanPham> dsSanPham;
    private DefaultTableModel modelTable;
    private String fileName = "sanpham.txt";
    private DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
    /**
     * Creates new form QuanLyBanHang
     */
    public QuanLyBanHang() {
        initComponents();
        // Khởi tạo danh sách sản phẩm
        dsSanPham = new ArrayList<>();
        
        // Thiết lập các giá trị cho ComboBox DVT
        cbDVT.removeAllItems();
        cbDVT.addItem("Gói");
        cbDVT.addItem("Cái");
        cbDVT.addItem("Thùng");
        cbDVT.addItem("Kg");
        
        // Thiết lập mô hình cho bảng
        modelTable = (DefaultTableModel) jTable1.getModel();
        
        // Thêm sự kiện cho bảng
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienThiSanPhamLenForm();
            }
        });
        
        // Thêm sự kiện cho các nút
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themSanPham();
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaSanPham();
            }
        });
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaSanPham();
            }
        });
        
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemSanPham();
            }
        });
        
        btnMoTep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moTep();
            }
        });
        
        btnLuuTep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuTep();
            }
        });
        
        btnSapXepTheoMaSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepTheoTenSP();
            }
        });
        
        btnSapXepTheoGiaSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepTheoGiaSP();
            }
        });
        
        // Cố gắng mở tệp khi khởi động
        moTep();
    }
    // Phương thức xóa trắng các ô nhập liệu
    private void xoaTrang() {
        txtMaSP.setText("");
        txtTenSanPham.setText("");
        cbDVT.setSelectedIndex(0);
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtMaSP.requestFocus();
    }
    // Phương thức kiểm tra và lấy dữ liệu từ form
    private SanPham laySanPhamTuForm() throws Exception {
        String maSP = txtMaSP.getText().trim();
        String tenSP = txtTenSanPham.getText().trim();
        String dvt = cbDVT.getSelectedItem().toString();
        String soLuongStr = txtSoLuong.getText().trim();
        String donGiaStr = txtDonGia.getText().trim();
        
        // Kiểm tra mã SP
        if (maSP.isEmpty()) {
            throw new Exception("Mã sản phẩm không được để trống!");
        }
        
        // Kiểm tra tên SP
        if (tenSP.isEmpty()) {
            throw new Exception("Tên sản phẩm không được để trống!");
        }
        
        // Kiểm tra số lượng
        if (soLuongStr.isEmpty()) {
            throw new Exception("Số lượng không được để trống!");
        }
        
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong < 0) {
                throw new Exception("Số lượng phải là số không âm!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Số lượng phải là số nguyên!");
        }
        
        // Kiểm tra đơn giá
        if (donGiaStr.isEmpty()) {
            throw new Exception("Đơn giá không được để trống!");
        }
        
        double donGia;
        try {
            donGia = Double.parseDouble(donGiaStr);
            if (donGia < 0) {
                throw new Exception("Đơn giá phải là số không âm!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Đơn giá phải là số!");
        }
        
        return new SanPham(maSP, tenSP, dvt, soLuong, donGia);
    }
    
    // Phương thức thêm sản phẩm vào danh sách và bảng
    private void themSanPham() {
        try {
            SanPham sp = laySanPhamTuForm();
            
            // Kiểm tra trùng mã
            for (SanPham item : dsSanPham) {
                if (item.MaSP.equals(sp.MaSP)) {
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            // Thêm vào danh sách
            dsSanPham.add(sp);
            
            // Cập nhật bảng
            capNhatBang();
            
            // Xóa trắng form
            xoaTrang();
            
            // Cập nhật tổng tiền
            tinhTongTien();
            
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Phương thức cập nhật bảng
    private void capNhatBang() {
        // Xóa tất cả dữ liệu trong bảng
        modelTable.setRowCount(0);
        
        // Thêm dữ liệu từ danh sách vào bảng
        for (SanPham sp : dsSanPham) {
            modelTable.addRow(new Object[] {
                sp.MaSP,
                sp.TenSP,
                sp.DVT,
                sp.SL,
                decimalFormat.format(sp.DonGia),
                decimalFormat.format(sp.getThanhTien())
            });
        }
    }
    
    // Phương thức xóa sản phẩm
    private void xoaSanPham() {
        String maSP = txtMaSP.getText().trim();
        
        if (maSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int index = -1;
        for (int i = 0; i < dsSanPham.size(); i++) {
            if (dsSanPham.get(i).MaSP.equals(maSP)) {
                index = i;
                break;
            }
        }
        
        if (index != -1) {
            // Xác nhận xóa
            int confirm = JOptionPane.showConfirmDialog(this, 
                    "Bạn có chắc muốn xóa sản phẩm này?", 
                    "Xác nhận xóa", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                dsSanPham.remove(index);
                capNhatBang();
                xoaTrang();
                tinhTongTien();
                JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + maSP, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Phương thức sửa sản phẩm
    private void suaSanPham() {
        try {
            SanPham spMoi = laySanPhamTuForm();
            
            int index = -1;
            for (int i = 0; i < dsSanPham.size(); i++) {
                if (dsSanPham.get(i).MaSP.equals(spMoi.MaSP)) {
                    index = i;
                    break;
                }
            }
            
            if (index != -1) {
                // Cập nhật sản phẩm
                dsSanPham.set(index, spMoi);
                capNhatBang();
                tinhTongTien();
                JOptionPane.showMessageDialog(this, "Đã cập nhật sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + spMoi.MaSP, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Phương thức tìm kiếm sản phẩm
    private void timKiemSanPham() {
        String maSP = txtMaSP.getText().trim();
    
        if (maSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm cần tìm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SanPham spTimThay = null;
        int rowIndex = -1;

        // Tìm sản phẩm trong danh sách
        for (int i = 0; i < dsSanPham.size(); i++) {
            if (dsSanPham.get(i).MaSP.equals(maSP)) {
                spTimThay = dsSanPham.get(i);
                rowIndex = i;
                break;
            }
        }

        if (spTimThay != null) {
            // Hiển thị thông tin sản phẩm lên form
            txtMaSP.setText(spTimThay.MaSP);
            txtTenSanPham.setText(spTimThay.TenSP);
            cbDVT.setSelectedItem(spTimThay.DVT);
            txtSoLuong.setText(String.valueOf(spTimThay.SL));
            txtDonGia.setText(String.valueOf(spTimThay.DonGia));

            // Scroll đến hàng tìm thấy và chọn hàng đó
            if (rowIndex >= 0) {
                jTable1.setRowSelectionInterval(rowIndex, rowIndex);
                jTable1.scrollRectToVisible(jTable1.getCellRect(rowIndex, 0, true));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + maSP, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Phương thức hiển thị sản phẩm được chọn trên bảng lên form
    private void hienThiSanPhamLenForm() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String maSP = jTable1.getValueAt(selectedRow, 0).toString();
            
            for (SanPham sp : dsSanPham) {
                if (sp.MaSP.equals(maSP)) {
                    txtMaSP.setText(sp.MaSP);
                    txtTenSanPham.setText(sp.TenSP);
                    cbDVT.setSelectedItem(sp.DVT);
                    txtSoLuong.setText(String.valueOf(sp.SL));
                    txtDonGia.setText(String.valueOf(sp.DonGia));
                    break;
                }
            }
        }
    }
    
    // Phương thức mở tệp
    private void moTep() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Mở tệp");

        // Set file filter for .txt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            fileName = selectedFile.getAbsolutePath();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList) {
                    dsSanPham = (ArrayList<SanPham>) obj;
                    capNhatBang();
                    tinhTongTien();

                    // Hiển thị sản phẩm đầu tiên trong danh sách (nếu có)
                    if (!dsSanPham.isEmpty()) {
                        SanPham sp = dsSanPham.get(0);
                        txtMaSP.setText(sp.MaSP);
                        txtTenSanPham.setText(sp.TenSP);
                        cbDVT.setSelectedItem(sp.DVT);
                        txtSoLuong.setText(String.valueOf(sp.SL));
                        txtDonGia.setText(String.valueOf(sp.DonGia));
                    } else {
                        xoaTrang();
                    }

                    JOptionPane.showMessageDialog(this, "Đọc file thành công!");
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy file: " + fileName, "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Phương thức lưu tệp
    private void luuTep() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu tệp");

        // Set file filter for .txt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        // Default suggested file name
        if (fileName != null && !fileName.isEmpty()) {
            File defaultFile = new File(fileName);
            fileChooser.setSelectedFile(defaultFile);
        } else {
            fileChooser.setSelectedFile(new File(fileName));
        }

        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            fileName = selectedFile.getAbsolutePath();

            // Add .txt extension if not present
            if (!fileName.toLowerCase().endsWith(".txt")) {
                fileName += ".txt";
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(dsSanPham);
                JOptionPane.showMessageDialog(this, "Lưu file thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Phương thức sắp xếp theo tên sản phẩm tăng dần
    private void sapXepTheoTenSP() {
        Collections.sort(dsSanPham, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp1.TenSP.compareToIgnoreCase(sp2.TenSP);
            }
        });
        
        capNhatBang();
    }
    
    // Phương thức sắp xếp theo giá sản phẩm giảm dần
    private void sapXepTheoGiaSP() {
        Collections.sort(dsSanPham, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp2.DonGia, sp1.DonGia);
            }
        });
        
        capNhatBang();
    }
    
    // Phương thức tính tổng tiền
    private void tinhTongTien() {
        double tongTien = 0;
        for (SanPham sp : dsSanPham) {
            tongTien += sp.getThanhTien();
        }
        
        txtTongTien.setText(decimalFormat.format(tongTien));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuanLyBanHang = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblDonGia = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        cbDVT = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnMoTep = new javax.swing.JButton();
        btnLuuTep = new javax.swing.JButton();
        btnSapXepTheoMaSanPham = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSapXepTheoGiaSanPham = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ktgk");
        setResizable(false);

        lblQuanLyBanHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQuanLyBanHang.setForeground(new java.awt.Color(0, 0, 255));
        lblQuanLyBanHang.setText("QUẢN LÝ BÁN HÀNG");

        lblMaSP.setText("Mã SP");

        lblTenSP.setText("Tên Sản phẩm");

        lblDVT.setText("Đơn vị tính");

        lblSoLuong.setText("Số lượng");

        lblDonGia.setText("Đơn giá");

        cbDVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDVTActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/Actions-document-new-icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/Action-cancel-icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/Action-edit-icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnMoTep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/open-file.png"))); // NOI18N
        btnMoTep.setText("Mở tệp");
        btnMoTep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoTepActionPerformed(evt);
            }
        });

        btnLuuTep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/save.png"))); // NOI18N
        btnLuuTep.setText("Lưu tệp");
        btnLuuTep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTepActionPerformed(evt);
            }
        });

        btnSapXepTheoMaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/Action-reload-icon.png"))); // NOI18N
        btnSapXepTheoMaSanPham.setText("Sắp xếp theo mã SP");
        btnSapXepTheoMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepTheoMaSanPhamActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaSP", "TenSP", "ĐVT", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        btnSapXepTheoGiaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgktgk/Images/Actions-view-refresh-icon.png"))); // NOI18N
        btnSapXepTheoGiaSanPham.setText("Sắp xếp theo giá SP");
        btnSapXepTheoGiaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepTheoGiaSanPhamActionPerformed(evt);
            }
        });

        lblTongTien.setForeground(new java.awt.Color(0, 0, 255));
        lblTongTien.setText("Tổng tiền");

        txtTongTien.setForeground(new java.awt.Color(0, 0, 255));
        txtTongTien.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuanLyBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSapXepTheoMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSapXepTheoGiaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTongTien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSP)
                                    .addComponent(txtTenSanPham)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtDonGia))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLuuTep, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMoTep, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblQuanLyBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMoTep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLuuTep)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSapXepTheoMaSanPham)
                    .addComponent(btnSapXepTheoGiaSanPham))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnMoTepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoTepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoTepActionPerformed

    private void btnLuuTepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuTepActionPerformed

    private void btnSapXepTheoMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepTheoMaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSapXepTheoMaSanPhamActionPerformed

    private void btnSapXepTheoGiaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepTheoGiaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSapXepTheoGiaSanPhamActionPerformed

    private void cbDVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDVTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuTep;
    private javax.swing.JButton btnMoTep;
    private javax.swing.JButton btnSapXepTheoGiaSanPham;
    private javax.swing.JButton btnSapXepTheoMaSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbDVT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblQuanLyBanHang;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
