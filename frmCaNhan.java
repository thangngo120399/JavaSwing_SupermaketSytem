package jvswing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class frmCaNhan extends JPanel {
	ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
	NhanVien nv = new NhanVien();
	int index;
	public frmCaNhan() {
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
        
        JLabel lblNewLabel = new JLabel("CÁ NHÂN");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Apps-preferences-desktop-user-password-icon.png"));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(349, 11, 229, 30);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Mã NV: ");
        lblNewLabel_1.setBounds(34, 119, 77, 20);
        add(lblNewLabel_1);
        
        lbl_MaNV = new JLabel("");
        lbl_MaNV.setForeground(Color.BLUE);
        lbl_MaNV.setBounds(90, 116, 116, 23);
        add(lbl_MaNV);
        
        JLabel lblNewLabel_3 = new JLabel("Họ và Tên: ");
        lblNewLabel_3.setBounds(34, 158, 77, 30);
        add(lblNewLabel_3);
        
        lbl_HoTen = new JLabel("");
        lbl_HoTen.setForeground(Color.BLUE);
        lbl_HoTen.setBounds(103, 158, 140, 30);
        add(lbl_HoTen);
        
        JLabel lblNewLabel_2 = new JLabel("SĐT: ");
        lblNewLabel_2.setBounds(34, 212, 46, 20);
        add(lblNewLabel_2);
        
        lbl_SDT = new JLabel("");
        lbl_SDT.setForeground(Color.BLUE);
        lbl_SDT.setBounds(90, 207, 116, 30);
        add(lbl_SDT);
        
        JLabel lblNewLabel_4 = new JLabel("Email: ");
        lblNewLabel_4.setBounds(253, 207, 64, 30);
        add(lblNewLabel_4);
        
        lbl_Email = new JLabel("");
        lbl_Email.setForeground(Color.BLUE);
        lbl_Email.setBounds(314, 210, 135, 25);
        add(lbl_Email);
        
        JLabel lblNewLabel_5 = new JLabel("Giới tính: ");
        lblNewLabel_5.setBounds(253, 119, 64, 20);
        add(lblNewLabel_5);
        
        lbl_GioiTinh = new JLabel("");
        lbl_GioiTinh.setForeground(Color.BLUE);
        lbl_GioiTinh.setBounds(314, 119, 96, 20);
        add(lbl_GioiTinh);
        
        JLabel lblNewLabel_6 = new JLabel("Nhóm: ");
        lblNewLabel_6.setBounds(253, 163, 64, 20);
        add(lblNewLabel_6);
        
        lbl_Nhom = new JLabel("");
        lbl_Nhom.setForeground(Color.BLUE);
        lbl_Nhom.setBounds(314, 158, 96, 30);
        add(lbl_Nhom);
        
        JLabel lblNewLabel_7 = new JLabel("Địa chỉ: ");
        lblNewLabel_7.setBounds(34, 255, 77, 20);
        add(lblNewLabel_7);
        
        lbl_DiaChi = new JLabel("");
        lbl_DiaChi.setForeground(Color.BLUE);
        lbl_DiaChi.setBounds(100, 243, 269, 42);
        add(lbl_DiaChi);
        
        JLabel lblNewLabel_8 = new JLabel("Mật khẩu mới");
        lblNewLabel_8.setBounds(476, 136, 102, 20);
        add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Nhập lại mật khẩu mới");
        lblNewLabel_9.setBounds(474, 207, 140, 25);
        add(lblNewLabel_9);
        frmNhanVien frmNV = new frmNhanVien();
        frmNV.loadFile();
        listNV = frmNV.listNV;
        nv =getNVByCode(frmDangNhap.maNVLogin);
        lbl_MaNV.setText(nv.getMaNhanVien());
        lbl_HoTen.setText(nv.getHoTen());
        lbl_SDT.setText(nv.getSoDienThoai());
        lbl_DiaChi.setText(nv.getDiachi());
        lbl_GioiTinh.setText(nv.getGioiTinh());
        if(nv.getNhom()==1) {
        	lbl_Nhom.setText("Quản lí");
        }else {
        	lbl_Nhom.setText("Nhân viên");
        }
        lbl_Email.setText(nv.getEmail());
        
        JButton btnNewButton = new JButton("Thay đổi mật khẩu");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		checkPass();
        	}
        });
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\changes-prevent-icon.png"));
        btnNewButton.setBounds(545, 268, 190, 35);
        add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nh\u00E2n Vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(20, 79, 435, 257);
        add(panel);
        
        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
        lblNewLabel_10.setBounds(10, 0, 64, 50);
        add(lblNewLabel_10);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.ORANGE);
        panel_2.setBounds(0, 0, 809, 50);
        add(panel_2);
        
        lbl_note = new JLabel("");
        lbl_note.setForeground(Color.RED);
        lbl_note.setBounds(565, 166, 190, 20);
        add(lbl_note);
        
        txt_Pass = new JPasswordField();
        txt_Pass.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(txt_Pass.getText().length()<6) {
					lbl_note.setText("Mật khẩu phải lớn hơn 6 kí tự");
					lbl_note.setForeground(Color.RED);
					lbl_note.setFont(new Font("Tahoma", Font.BOLD, 11));
				}else {
					lbl_note.setText("");
				}
        	}
        });
        txt_Pass.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_Pass.setBorder(new LineBorder(Color.BLUE));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {	
        		txt_Pass.setBorder(new LineBorder(Color.WHITE));
				if(txt_Pass.getText().equals("")) {
					txt_Pass.setBorder(new LineBorder(Color.RED));
					lbl_note.setText("Vui lòng nhập mật khẩu");
					lbl_note.setForeground(Color.RED);
					lbl_note.setFont(new Font("Tahoma", Font.BOLD, 11));
				}
        	}
        });
        txt_Pass.setBounds(607, 129, 148, 35);
        add(txt_Pass);
        
        txt_RePass = new JPasswordField();
        txt_RePass.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_RePass.setBorder(new LineBorder(Color.BLUE));
        		
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_RePass.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_RePass.setBounds(607, 202, 148, 35);
        add(txt_RePass);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thay \u0111\u1ED5i M\u1EADt Kh\u1EA9u", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel_1.setBackground(new Color(255, 250, 205));
        panel_1.setBounds(465, 79, 310, 257);
        add(panel_1);
        
        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
        lblNewLabel_11.setBounds(0, 49, 829, 527);
        add(lblNewLabel_11);
	}
	 public NhanVien getNVByCode(String id) {
		 for(int i=0; i<listNV.size(); i++) {
			 if(id.equals(listNV.get(i).getMaNhanVien())) {
				 index =i;
				 return listNV.get(i);
			 }
		 }
		 return null;
	 }
	 public void checkPass() {
		 String pass = txt_Pass.getText();
		 String rePass = txt_RePass.getText();
		 if(pass.length()<8) {
			 JOptionPane.showMessageDialog(this, "Mật khẩu ít nhất 8 kí tự!!!");
			 txt_Pass.setText("");
			 txt_RePass.setText("");
			 return;
		 }
		 if(pass.equals(rePass)) {
			 nv.setMatKhau(Utils.md5(pass));
			 frmNhanVien frmNV = new frmNhanVien();
			 frmNV.loadFile();
			 frmNV.listNV.get(index).setMatKhau(nv.getMatKhau());
			 frmNV.saveFile();
			 JOptionPane.showMessageDialog(this,"Thay đổi mật khẩu thành công !!!");
			 txt_Pass.setText("");
			 txt_RePass.setText("");
		 }else {
			 JOptionPane.showMessageDialog(this,"Mật khẩu không trùng khớp!!!!");
			 txt_RePass.setText("");
			 return;
		 }
	 }
	private JLabel lbl_MaNV;
	private JLabel lbl_HoTen;
	private JLabel lbl_SDT;
	private JLabel lbl_DiaChi;
	private JLabel lbl_Email;
	private JLabel lbl_Nhom;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_note;
	private JPasswordField txt_Pass;
	private JPasswordField txt_RePass;
}
