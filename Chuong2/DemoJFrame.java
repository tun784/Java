/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author GIGABYTE
 */
public class DemoJFrame extends JFrame{
    public DemoJFrame(){
        this.setTitle("Vi du");
        this.setSize(1650,900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container con = getContentPane();
        JButton btnThoat = new JButton("Thoat");
        
        ImageIcon icon = new ImageIcon("icons/Thoat.jpg");
        Image img = icon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        btnThoat.setIcon(new ImageIcon(img));
        
        con.add(btnThoat);
    }
}
