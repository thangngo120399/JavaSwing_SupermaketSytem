/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Zenter
 */
public class JMain extends JFrame {

    /**
     * Creates new form frmMain
     */
    public JMain(String title) {
    	super(title);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcontent = new JTabbedPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\system-file-manager-icon.png"));
        jMenuItem1 = new JMenuItem();
        jMenuItem1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\users-icon.png"));
        jMenuItem2 = new JMenuItem();
        jMenuItem2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Office-Customer-Male-Light-icon.png"));
        jMenuItem3 = new JMenuItem();
        jMenuItem3.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\sale-icon (1).png"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jMenu1.setText("Quản lý");

        jMenuItem1.setText("Quản lý nhân viên");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
       
        
        
        jMenuItem2.setText("Quản lí khách hàng");
        jMenuItem2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jMenuItem2ActionPerformed(e);
				
			}
		});
        jMenu1.add(jMenuItem2); 
        jMenuItem3.setText("Quản lí sản phẩm");
        jMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem3ActionPerformed(e);
			}
		});
        jMenu1.add(jMenuItem3);
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        
        jMenuBanHang = new JMenu("Bán hàng");
        jMenuBanHang.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		jMenuItem4ActionMouseClick(e);
        	}
        });

        jMenuBanHang.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\shop-icon.png"));
        jMenuBar1.add(jMenuBanHang);
        
        jMenuThongKe = new JMenu("Thống kê");
        jMenuThongKe.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		jMenuItem5ActionMouseClick(e);
        	}
        });
        jMenuThongKe.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\chart-icon.png"));
        jMenuBar1.add(jMenuThongKe);
        jMenu2 = new JMenu();
        jMenu2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Apps-system-software-update-icon.png"));
        
        jMenu2.setText("Hệ thống");
        jMenuBar1.add(jMenu2);
        
        jMenu_CaNhan = new JMenu("Cá nhân");
        jMenu_CaNhan.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		jMenuItem6ActionMouseClick(e);
        	}
        });
        jMenu_CaNhan.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Apps-preferences-desktop-user-password-icon.png"));
        jMenuBar1.add(jMenu_CaNhan);
        
        jMenu_DangXuat = new JMenu("Đăng xuất");
        jMenu_DangXuat.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		dangxuat();
        	}
        
        });
        jMenu_DangXuat.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Users-Exit-icon.png"));
        jMenuBar1.add(jMenu_DangXuat);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jcontent, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jcontent,GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );
        
        lbl_anhnen1 = new JLabel("");
        lbl_anhnen1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\vin-mart.jpg"));
        jcontent.add(lbl_anhnen1);

        pack();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
    	frmNhanVien frmNhanVien = new frmNhanVien();
    	jcontent.removeAll();
    	jcontent.add(frmNhanVien, "Quản lí nhân viên");
    }
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
    	frmKhachHang frmKhachHang = new frmKhachHang();
    	jcontent.removeAll();
    	jcontent.add(frmKhachHang, "Quản lí khách hàng");
    }
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
    	frmSanPham frmSanPham = new frmSanPham();
    	jcontent.removeAll();
    	jcontent.add(frmSanPham, "Quản lí sản phẩm");
    }
    private void jMenuItem4ActionMouseClick(MouseEvent e) {
        frmBanHang frmBanhang = new frmBanHang();
        jcontent.removeAll();
        jcontent.add(frmBanhang, "Quản lí đơn hàng");
    }
    private void jMenuItem5ActionMouseClick(MouseEvent e) {
    	frmThongKe frmThongKe = new frmThongKe();
    	jcontent.removeAll();
    	jcontent.add(frmThongKe, "Thống kê");
    }
    private void jMenuItem6ActionMouseClick(MouseEvent e) {
        frmCaNhan frmCN = new frmCaNhan();
        jcontent.removeAll();
        jcontent.add(frmCN, "Cá Nhân");
    }
    public void dangxuat() {
    	Integer confirm =JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn đăng xuất không?","Đăng Xuất",2);
    	if(confirm == JOptionPane.YES_OPTION) {
	    	frmDangNhap frmDN = new frmDangNhap("Đăng Nhập");
	    	frmDN.setVisible(true);
	    	this.dispose();
    	}
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMain("Quản lí bán hàng").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JTabbedPane jcontent;
    private JLabel lbl_anhnen1;
    private JMenu jMenuBanHang;
    private JMenu jMenuThongKe;
    private JMenu jMenu_DangXuat;
    private JMenu jMenu_CaNhan;
    // End of variables declaration//GEN-END:variables
}
