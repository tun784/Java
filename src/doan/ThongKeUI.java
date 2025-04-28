import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ThongKeUI extends JPanel {
    private JCheckBox chkSoLuongSach, chkSachMuonNhieuNhat, chkSoDocGia, chkDocGiaMuonNhieu;
    private JComboBox<String> cmbThoiGian;
    private JButton btnXemKetQua;
    private JTable tableKetQua;
    private DefaultTableModel tableModel;

    public ThongKeUI() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initUI();
    }

    private void initUI() {
        // Panel chính với gradient background
        JPanel mainPanel = new GradientPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel trên cùng (Top Panel) chứa các tùy chọn
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1), 
                " Tùy Chọn Thống Kê ", 
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                new Font("Segoe UI", Font.BOLD, 14)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Panel chứa các checkbox (sắp xếp dạng lưới)
        JPanel checkBoxPanel = new JPanel(new GridLayout(2, 2, 15, 10));
        checkBoxPanel.setOpaque(false);

        // Nhóm các checkbox bằng ButtonGroup để chỉ chọn được 1
        ButtonGroup checkBoxGroup = new ButtonGroup();
        chkSoLuongSach = createStyledCheckBox("SỐ LƯỢNG SÁCH");
        chkSachMuonNhieuNhat = createStyledCheckBox("SÁCH ĐƯỢC MƯỢN NHIỀU NHẤT");
        chkSoDocGia = createStyledCheckBox("SỐ ĐỘC GIẢ ĐÃ MƯỢN SÁCH");
        chkDocGiaMuonNhieu = createStyledCheckBox("ĐỘC GIẢ MƯỢN NHIỀU SÁCH NHẤT");

        // Thêm các checkbox vào ButtonGroup
        checkBoxGroup.add(chkSoLuongSach);
        checkBoxGroup.add(chkSachMuonNhieuNhat);
        checkBoxGroup.add(chkSoDocGia);
        checkBoxGroup.add(chkDocGiaMuonNhieu);

        checkBoxPanel.add(chkSoLuongSach);
        checkBoxPanel.add(chkSachMuonNhieuNhat);
        checkBoxPanel.add(chkSoDocGia);
        checkBoxPanel.add(chkDocGiaMuonNhieu);

        // Panel chứa combobox và button
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        filterPanel.setOpaque(false);
        cmbThoiGian = new JComboBox<>(new String[] {
            "Tất cả", "Tuần này", "Tháng này", "Năm nay"
        });
        cmbThoiGian.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbThoiGian.setPreferredSize(new Dimension(150, 30));
        cmbThoiGian.setBackground(Color.WHITE);
        cmbThoiGian.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));

        btnXemKetQua = createStyledButton("Xem Kết Quả");
        filterPanel.add(createStyledLabel("Lọc theo thời gian:"));
        filterPanel.add(cmbThoiGian);
        filterPanel.add(btnXemKetQua);

        topPanel.add(checkBoxPanel, BorderLayout.CENTER);
        topPanel.add(filterPanel, BorderLayout.SOUTH);

        // Bảng kết quả
        String[] columnNames = {"Tiêu Đề", "Giá Trị"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableKetQua = new JTable(tableModel);
        styleTable(tableKetQua);

        JScrollPane scrollPane = new JScrollPane(tableKetQua);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
        scrollPane.getViewport().setBackground(Color.WHITE);

        // Panel chứa bảng kết quả với tiêu đề
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setOpaque(false);
        JLabel tableTitle = new JLabel("Kết Quả Thống Kê", SwingConstants.CENTER);
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tableTitle.setForeground(new Color(0, 140, 235));
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        tablePanel.add(tableTitle, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Gắn các phần vào main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        add(mainPanel);

        // Xử lý sự kiện nút
        btnXemKetQua.addActionListener(e -> {
            if (checkBoxGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một tùy chọn thống kê!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            animateResultDisplay();
            hienThiKetQua();
        });
    }

    private JCheckBox createStyledCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font in đậm
        checkBox.setOpaque(false);
        checkBox.setForeground(new Color(50, 50, 50));
        return checkBox;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(0, 120, 215));
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(0, 150, 255));
                } else {
                    g.setColor(new Color(0, 140, 235));
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        // Header style
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0, 140, 235));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        
        // Cell renderer
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 245, 250));
                if (isSelected) {
                    c.setBackground(new Color(0, 140, 235));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setForeground(new Color(50, 50, 50));
                }
                return c;
            }
        };
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, renderer);
    }

    private void animateResultDisplay() {
        tableKetQua.setEnabled(false);
        Timer timer = new Timer(50, new ActionListener() {
            int alpha = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 10;
                tableKetQua.setBackground(new Color(255, 255, 255, alpha));
                if (alpha >= 255) {
                    ((Timer)e.getSource()).stop();
                    tableKetQua.setEnabled(true);
                }
            }
        });
        timer.start();
    }

    private void hienThiKetQua() {
        tableModel.setRowCount(0);
        String thoiGian = cmbThoiGian.getSelectedItem().toString();

        if (chkSoLuongSach.isSelected()) {
            tableModel.addRow(new Object[]{"Số lượng sách (" + thoiGian + ")", "1234"});
        } else if (chkSachMuonNhieuNhat.isSelected()) {
            tableModel.addRow(new Object[]{"Sách mượn nhiều nhất (" + thoiGian + ")", "Java Programming"});
        } else if (chkSoDocGia.isSelected()) {
            tableModel.addRow(new Object[]{"Số độc giả mượn sách (" + thoiGian + ")", "256"});
        } else if (chkDocGiaMuonNhieu.isSelected()) {
            tableModel.addRow(new Object[]{"Độc giả mượn nhiều sách nhất (" + thoiGian + ")", "Nguyễn Văn A"});
        }
    }

    private class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth();
            int h = getHeight();
            Color color1 = new Color(220, 240, 255);
            Color color2 = new Color(180, 220, 255);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }
}
