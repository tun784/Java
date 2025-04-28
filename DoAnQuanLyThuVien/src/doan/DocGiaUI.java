
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;

public class DocGiaUI extends JPanel {

    private RoundedTextField txtMa;
    private RoundedTextField txtTen;
    private RoundedTextField txtDiaChi;
    private RoundedTextField txtSDT;
    private RoundedTextField txtEmail;
    private JTable table;
    private DefaultTableModel tableModel;

    public DocGiaUI() {
        setLayout(new BorderLayout()); // Quan trọng để layout hoạt động
        JPanel panelMain = new JPanel(new BorderLayout(10, 10));
        panelMain.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelMain.setBackground(new Color(250, 250, 255));
        
        panelMain.add(buildFormPanel(), BorderLayout.NORTH);
        panelMain.add(buildTablePanel(), BorderLayout.CENTER);

        add(panelMain); // thêm panel chính vào JPanel này
    }

    private JPanel buildFormPanel() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(220, 240, 255));
        // Chuyển tiêu đề panel thành chữ in hoa
        container.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 100)),
            "QUẢN LÝ ĐỘC GIẢ",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14)
        ));

        JPanel panelLeft = new JPanel(new GridBagLayout());
        panelLeft.setBackground(new Color(220, 240, 255));
        panelLeft.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(220, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        txtMa = new RoundedTextField(15);
        txtTen = new RoundedTextField(15);
        txtDiaChi = new RoundedTextField(15);
        txtSDT = new RoundedTextField(15);
        txtEmail = new RoundedTextField(20);

        // Các nhãn với chữ in hoa
        JLabel lblMa = new JLabel("MÃ ĐỘC GIẢ:");
        lblMa.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblMa, gbc);
        gbc.gridx = 1;
        formPanel.add(txtMa, gbc);

        JLabel lblDiaChi = new JLabel("ĐỊA CHỈ:");
        lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 2;
        formPanel.add(lblDiaChi, gbc);
        gbc.gridx = 3;
        formPanel.add(txtDiaChi, gbc);

        JLabel lblTen = new JLabel("TÊN ĐỘC GIẢ:");
        lblTen.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblTen, gbc);
        gbc.gridx = 1;
        formPanel.add(txtTen, gbc);

        JLabel lblSDT = new JLabel("SỐ ĐIỆN THOẠI:");
        lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 2;
        formPanel.add(lblSDT, gbc);
        gbc.gridx = 3;
        formPanel.add(txtSDT, gbc);

        JLabel lblEmail = new JLabel("EMAIL:");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        formPanel.add(txtEmail, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 0;
        RoundedButton btnAdd = new RoundedButton("Thêm");
        RoundedButton btnSave = new RoundedButton("Lưu");
        RoundedButton btnDelete = new RoundedButton("Xóa");
        RoundedButton btnEdit = new RoundedButton("Sửa");

        btnAdd.addActionListener(e -> clearFields());
        btnSave.addActionListener(e -> saveDocGia());
        btnDelete.addActionListener(e -> deleteDocGia());
        btnEdit.addActionListener(e -> editDocGia());

        formPanel.add(btnAdd, gbc);
        gbc.gridx = 1;
        formPanel.add(btnSave, gbc);
        gbc.gridx = 2;
        formPanel.add(btnDelete, gbc);
        gbc.gridx = 3;
        formPanel.add(btnEdit, gbc);

        container.add(panelLeft, BorderLayout.WEST);
        container.add(formPanel, BorderLayout.CENTER);

        return container;
    }

    private JScrollPane buildTablePanel() {
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"MÃ ĐỘC GIẢ", "TÊN", "ĐỊA CHỈ", "EMAIL", "SĐT"} 
        );
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setGridColor(Color.LIGHT_GRAY);
        table.setShowGrid(true);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setBackground(Color.WHITE); // Đặt nền trắng cho bảng
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtMa.setText(tableModel.getValueAt(row, 0).toString());
                    txtTen.setText(tableModel.getValueAt(row, 1).toString());
                    txtDiaChi.setText(tableModel.getValueAt(row, 2).toString());
                    txtEmail.setText(tableModel.getValueAt(row, 3).toString());
                    txtSDT.setText(tableModel.getValueAt(row, 4).toString());
                }
            }
        });

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(100, 149, 237));
        header.setForeground(Color.WHITE);
        header.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JScrollPane scrollPane = new JScrollPane(table);
        
        // Chuyển tiêu đề của bảng thành chữ in hoa
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 100)),
            "DANH SÁCH ĐỘC GIẢ",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14)
        ));
        return scrollPane;
    }

    private void clearFields() {
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        table.clearSelection();
    }

    private void showCustomDialog(String title, String message, int messageType) {
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog(parent, title, true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("<html><center>" + message + "</center></html>");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        RoundedButton okButton = new RoundedButton("OK");
        okButton.setBackground(new Color(30, 144, 255));
        okButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(okButton);

        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        switch (messageType) {
            case JOptionPane.ERROR_MESSAGE:
                dialog.getContentPane().setBackground(new Color(255, 245, 245));
                break;
            case JOptionPane.INFORMATION_MESSAGE:
                dialog.getContentPane().setBackground(new Color(245, 255, 245));
                break;
        }

        dialog.setVisible(true);
    }

    private void saveDocGia() {
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
            showCustomDialog("Lỗi Nhập Liệu", "Vui lòng điền đầy đủ tất cả các trường thông tin!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!sdt.matches("\\d+")) {
            showCustomDialog("Lỗi Nhập Liệu", "Số điện thoại chỉ được chứa các chữ số!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{ma, ten, diaChi, email, sdt});
        clearFields();
        showCustomDialog("Thành Công", "Thông tin độc giả đã được lưu!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteDocGia() {
        int row = table.getSelectedRow();
        if (row < 0) {
            showCustomDialog("Lỗi Thao Tác", "Vui lòng chọn một độc giả từ danh sách để xóa!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        JDialog confirmDialog = new JDialog(parent, "Xác Nhận Xóa", true);
        confirmDialog.setLayout(new BorderLayout(10, 10));
        confirmDialog.setSize(400, 200);
        confirmDialog.setLocationRelativeTo(this);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("<html><center>Bạn có chắc chắn muốn xóa độc giả này?</center></html>");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);

        RoundedButton yesButton = new RoundedButton("Có");
        yesButton.setBackground(new Color(30, 144, 255));
        yesButton.addActionListener(e -> {
            tableModel.removeRow(row);
            clearFields();
            confirmDialog.dispose();
            showCustomDialog("Thành Công", "Độc giả đã được xóa!", JOptionPane.INFORMATION_MESSAGE);
        });

        RoundedButton noButton = new RoundedButton("Không");
        noButton.setBackground(new Color(200, 200, 200));
        noButton.addActionListener(e -> confirmDialog.dispose());

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        confirmDialog.add(contentPanel, BorderLayout.CENTER);
        confirmDialog.add(buttonPanel, BorderLayout.SOUTH);
        confirmDialog.getContentPane().setBackground(new Color(255, 245, 245));
        confirmDialog.setVisible(true);
    }

    private void editDocGia() {
        int row = table.getSelectedRow();
        if (row < 0) {
            showCustomDialog("Lỗi Thao Tác", "Vui lòng chọn một độc giả từ danh sách để sửa!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
            showCustomDialog("Lỗi Nhập Liệu", "Vui lòng điền đầy đủ tất cả các trường thông tin!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!sdt.matches("\\d+")) {
            showCustomDialog("Lỗi Nhập Liệu", "Số điện thoại chỉ được chứa các chữ số!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.setValueAt(ma, row, 0);
        tableModel.setValueAt(ten, row, 1);
        tableModel.setValueAt(diaChi, row, 2);
        tableModel.setValueAt(email, row, 3);
        tableModel.setValueAt(sdt, row, 4);

        showCustomDialog("Thành Công", "Thông tin độc giả đã được cập nhật!", JOptionPane.INFORMATION_MESSAGE);
    }
    

}
