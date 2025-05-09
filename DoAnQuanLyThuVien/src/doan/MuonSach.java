/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package doan;

/**
 *
 * @author GIGABYTE
 */
public class MuonSach extends javax.swing.JFrame {

    /**
     * Creates new form MuonSach
     */
    public MuonSach() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Title = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        panelThongTinSach = new javax.swing.JPanel();
        lblThongTinSach = new javax.swing.JLabel();
        lblMaSach = new javax.swing.JLabel();
        lblTenSach = new javax.swing.JLabel();
        lblTacGia = new javax.swing.JLabel();
        lblTheLoai = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cbbTrangThai = new javax.swing.JComboBox<>();
        lblAnhBiaSach = new javax.swing.JLabel();
        panelThongTinDocGia = new javax.swing.JPanel();
        lblThongTinDocGia = new javax.swing.JLabel();
        lblMaDocGia = new javax.swing.JLabel();
        txtMaDocGia = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSoDienThoai = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        panelThongTinMuonSach = new javax.swing.JPanel();
        lblThongTinMuonSach = new javax.swing.JLabel();
        lblNgayMuon = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        lblHanTra = new javax.swing.JLabel();
        txtHanTra = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnXacNhanMuon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mượn sách");
        setBackground(new java.awt.Color(255, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 153, 153));
        setResizable(false);

        lbl_Title.setBackground(new java.awt.Color(255, 255, 51));
        lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("MƯỢN SÁCH");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.setText("Tìm kiếm...");

        btnTimKiem.setBackground(new java.awt.Color(255, 213, 154));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm");

        lblThongTinSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongTinSach.setText("Thông tin sách");

        lblMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaSach.setText("Mã sách:");

        lblTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenSach.setText("Tên sách:");

        lblTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTacGia.setText("Tác giả:");

        lblTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTheLoai.setText("Thể loại:");

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSoLuong.setText("Số lượng:");

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrangThai.setText("Trạng thái:");

        txtTenSach.setFocusable(false);

        txtTacGia.setFocusable(false);

        txtTheLoai.setFocusable(false);

        txtSoLuong.setFocusable(false);

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAnhBiaSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnhBiaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book.png"))); // NOI18N
        lblAnhBiaSach.setFocusable(false);
        lblAnhBiaSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAnhBiaSach.setMaximumSize(new java.awt.Dimension(839, 1200));
        lblAnhBiaSach.setPreferredSize(new java.awt.Dimension(580, 820));

        javax.swing.GroupLayout panelThongTinSachLayout = new javax.swing.GroupLayout(panelThongTinSach);
        panelThongTinSach.setLayout(panelThongTinSachLayout);
        panelThongTinSachLayout.setHorizontalGroup(
            panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThongTinSach, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelThongTinSachLayout.createSequentialGroup()
                        .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                                .addComponent(lblMaSach)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSach))
                            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                                .addComponent(lblTenSach)
                                .addGap(16, 16, 16)
                                .addComponent(txtTenSach))
                            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                                .addComponent(lblTacGia)
                                .addGap(27, 27, 27)
                                .addComponent(txtTacGia))
                            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                                .addComponent(lblTheLoai)
                                .addGap(22, 22, 22)
                                .addComponent(txtTheLoai))
                            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                                .addComponent(lblSoLuong)
                                .addGap(15, 15, 15)
                                .addComponent(txtSoLuong)))
                        .addContainerGap())
                    .addGroup(panelThongTinSachLayout.createSequentialGroup()
                        .addComponent(lblTrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnhBiaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panelThongTinSachLayout.setVerticalGroup(
            panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnhBiaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblThongTinDocGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongTinDocGia.setText("Thông tin độc giả");

        lblMaDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaDocGia.setText("Mã độc giả:");

        lblHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoTen.setText("Họ tên:");

        txtHoTen.setFocusable(false);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFocusable(false);

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSoDienThoai.setText("SĐT:");

        txtSoDienThoai.setFocusable(false);

        btnTimKiem1.setBackground(new java.awt.Color(255, 213, 154));
        btnTimKiem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiem1.setText("Tìm");

        javax.swing.GroupLayout panelThongTinDocGiaLayout = new javax.swing.GroupLayout(panelThongTinDocGia);
        panelThongTinDocGia.setLayout(panelThongTinDocGiaLayout);
        panelThongTinDocGiaLayout.setHorizontalGroup(
            panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinDocGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThongTinDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelThongTinDocGiaLayout.createSequentialGroup()
                        .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaDocGia)
                            .addComponent(lblHoTen)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelThongTinDocGiaLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoDienThoai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoDienThoai))
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelThongTinDocGiaLayout.createSequentialGroup()
                                .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem1)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelThongTinDocGiaLayout.setVerticalGroup(
            panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinDocGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        lblThongTinMuonSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongTinMuonSach.setText("Thông tin mượn sách");

        lblNgayMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayMuon.setText("Ngày mượn:");

        txtNgayMuon.setFocusable(false);

        lblHanTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHanTra.setText("Hạn trả:");

        txtHanTra.setFocusable(false);

        lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGhiChu.setText("Ghi chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout panelThongTinMuonSachLayout = new javax.swing.GroupLayout(panelThongTinMuonSach);
        panelThongTinMuonSach.setLayout(panelThongTinMuonSachLayout);
        panelThongTinMuonSachLayout.setHorizontalGroup(
            panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinMuonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongTinMuonSachLayout.createSequentialGroup()
                        .addComponent(lblThongTinMuonSach)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelThongTinMuonSachLayout.createSequentialGroup()
                        .addGroup(panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayMuon)
                            .addComponent(lblGhiChu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThongTinMuonSachLayout.createSequentialGroup()
                                .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHanTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHanTra))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        panelThongTinMuonSachLayout.setVerticalGroup(
            panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongTinMuonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThongTinMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXacNhanMuon.setBackground(new java.awt.Color(0, 153, 0));
        btnXacNhanMuon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXacNhanMuon.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanMuon.setText("XÁC NHẬN MƯỢN");

        btnHuy.setBackground(new java.awt.Color(204, 0, 0));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HUỶ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelThongTinSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelThongTinDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelThongTinMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXacNhanMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelThongTinSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelThongTinDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelThongTinMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXacNhanMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuonSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnXacNhanMuon;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnhBiaSach;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblHanTra;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaDocGia;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblNgayMuon;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTacGia;
    private javax.swing.JLabel lblTenSach;
    private javax.swing.JLabel lblTheLoai;
    private javax.swing.JLabel lblThongTinDocGia;
    private javax.swing.JLabel lblThongTinMuonSach;
    private javax.swing.JLabel lblThongTinSach;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JPanel panelThongTinDocGia;
    private javax.swing.JPanel panelThongTinMuonSach;
    private javax.swing.JPanel panelThongTinSach;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHanTra;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
