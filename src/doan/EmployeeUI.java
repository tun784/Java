
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;

public class EmployeeUI extends JPanel {

    private RoundedTextField txtMa;
    private RoundedTextField txtTen;
    private RoundedTextField txtChucVu;
    private RoundedTextField txtSDT;
    private RoundedTextField txtEmail;
    private JTable table;
    private DefaultTableModel tableModel;

    public EmployeeUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setBackground(new Color(250, 250, 255));

        add(buildFormPanel(), BorderLayout.NORTH);
        add(buildTablePanel(), BorderLayout.CENTER);
    }

    // buildFormPanel: Tạo panel chứa form nhập liệu và các nút chức năng
    private JPanel buildFormPanel() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(220, 240, 255));
        container.setBorder(BorderFactory.createTitledBorder("Quản Lý Nhân Viên"));

        ImageIcon icon = new ImageIcon("employee_icon.jpg");
        Image img = icon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        JLabel lblIcon = new JLabel(new ImageIcon(img));
        lblIcon.setPreferredSize(new Dimension(150, 200));
        lblIcon.setHorizontalAlignment(JLabel.CENTER);
        lblIcon.setVerticalAlignment(JLabel.CENTER);

        JPanel panelLeft = new JPanel(new GridBagLayout());
        panelLeft.setBackground(new Color(220, 240, 255));
        panelLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelLeft.add(lblIcon);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(220, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        txtMa = new RoundedTextField(15);
        txtTen = new RoundedTextField(15);
        txtChucVu = new RoundedTextField(15);
        txtSDT = new RoundedTextField(15);
        txtEmail = new RoundedTextField(20);

        // Font in đậm
        Font boldFont = new Font("Segoe UI", Font.BOLD, 14);

        JLabel lblMa = new JLabel("MÃ NHÂN VIÊN:");
        lblMa.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblMa, gbc);
        gbc.gridx = 1;
        formPanel.add(txtMa, gbc);

        JLabel lblChucVu = new JLabel("CHỨC VỤ:");
        lblChucVu.setFont(boldFont);
        gbc.gridx = 2;
        formPanel.add(lblChucVu, gbc);
        gbc.gridx = 3;
        formPanel.add(txtChucVu, gbc);

        JLabel lblTen = new JLabel("TÊN NHÂN VIÊN:");
        lblTen.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblTen, gbc);
        gbc.gridx = 1;
        formPanel.add(txtTen, gbc);

        JLabel lblSDT = new JLabel("SỐ ĐIỆN THOẠI:");
        lblSDT.setFont(boldFont);
        gbc.gridx = 2;
        formPanel.add(lblSDT, gbc);
        gbc.gridx = 3;
        formPanel.add(txtSDT, gbc);

        JLabel lblEmail = new JLabel("EMAIL:");
        lblEmail.setFont(boldFont);
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
        btnSave.addActionListener(e -> saveEmployee());
        btnDelete.addActionListener(e -> deleteEmployee());
        btnEdit.addActionListener(e -> editEmployee());

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

    // buildTablePanel: Tạo bảng hiển thị danh sách nhân viên
    private JScrollPane buildTablePanel() {
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã Nhân Viên", "Tên", "Chức vụ", "Email", "SĐT"}
        );
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setGridColor(Color.LIGHT_GRAY);
        table.setShowGrid(true);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
                    txtChucVu.setText(tableModel.getValueAt(row, 2).toString());
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
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh Sách Nhân Viên"));

        return scrollPane;
    }

    // clearFields: Xóa trắng các trường nhập liệu
    private void clearFields() {
        txtMa.setText("");
        txtTen.setText("");
        txtChucVu.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        table.clearSelection();
    }

    // showCustomDialog: Tạo hộp thoại tùy chỉnh với giao diện đẹp
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

    // saveEmployee: Lưu thông tin nhân viên vào bảng
    private void saveEmployee() {
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String chucVu = txtChucVu.getText().trim();
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || chucVu.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
            showCustomDialog("Lỗi Nhập Liệu", "Vui lòng điền đầy đủ tất cả các trường thông tin!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!sdt.matches("\\d+")) {
            showCustomDialog("Lỗi Nhập Liệu", "Số điện thoại chỉ được chứa các chữ số!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{ma, ten, chucVu, email, sdt});
        clearFields();
        showCustomDialog("Thành Công", "Thông tin nhân viên đã được lưu!", JOptionPane.INFORMATION_MESSAGE);
    }

    // deleteEmployee: Xóa nhân viên đã chọn
    private void deleteEmployee() {
        int row = table.getSelectedRow();
        if (row < 0) {
            showCustomDialog("Lỗi Thao Tác", "Vui lòng chọn một nhân viên từ danh sách để xóa!", JOptionPane.ERROR_MESSAGE);
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

        JLabel messageLabel = new JLabel("<html><center>Bạn có chắc chắn muốn xóa nhân viên này?</center></html>");
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
            showCustomDialog("Thành Công", "Nhân viên đã được xóa!", JOptionPane.INFORMATION_MESSAGE);
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

    // editEmployee: Cập nhật thông tin nhân viên
    private void editEmployee() {
        int row = table.getSelectedRow();
        if (row < 0) {
            showCustomDialog("Lỗi Thao Tác", "Vui lòng chọn một nhân viên từ danh sách để sửa!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String chucVu = txtChucVu.getText().trim();
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || chucVu.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
            showCustomDialog("Lỗi Nhập Liệu", "Vui lòng điền đầy đủ tất cả các trường thông tin!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!sdt.matches("\\d+")) {
            showCustomDialog("Lỗi Nhập Liệu", "Số điện thoại chỉ được chứa các chữ số!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.setValueAt(ma, row, 0);
        tableModel.setValueAt(ten, row, 1);
        tableModel.setValueAt(chucVu, row, 2);
        tableModel.setValueAt(email, row, 3);
        tableModel.setValueAt(sdt, row, 4);

        showCustomDialog("Thành Công", "Thông tin nhân viên đã được cập nhật!", JOptionPane.INFORMATION_MESSAGE);
    }

}

class RoundedTextField extends JTextField {

    private int arc;

    public RoundedTextField(int columns) {
        super(columns);
        arc = 20;
        setOpaque(false);
        setBorder(new EmptyBorder(6, 12, 6, 12));
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        super.paintComponent(g);
    }
}

class RoundedButton extends JButton {

    // Constructor: Khởi tạo button bo tròn
    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false); // Tắt viền mặc định
        setOpaque(false); // Đảm bảo không hiển thị nền mặc định
        setForeground(Color.WHITE);
        setBackground(new Color(30, 144, 255));
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setPreferredSize(new Dimension(100, 36));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // paintComponent: Vẽ button với nền bo tròn
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền bo tròn che phủ toàn bộ khu vực button
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker()); // Màu tối hơn khi nhấn
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter()); // Màu sáng hơn khi di chuột
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        super.paintComponent(g);
        g2.dispose();
    }
}
