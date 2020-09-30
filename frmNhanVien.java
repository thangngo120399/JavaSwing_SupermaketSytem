package jvswing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;


public class frmNhanVien extends JPanel {
	private DefaultTableModel defaultTableModel;
 ArrayList<NhanVien> listNV = new ArrayList<>();
	NhanVien nv = new NhanVien();
	public frmNhanVien() {
		initComponents();
		loadFile();
		getData(listNV);

	}
	int index;
	   private void initComponents() {

	        jScrollPane1 = new JScrollPane();
	        jScrollPane1.setBounds(1, 340, 806, 181);
	        tbl_nhanvien = new JTable();
	        btn_add = new JButton("Thêm");
	        tbl_nhanvien.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		btn_add.setEnabled(false);
	        		int row = tbl_nhanvien.getSelectedRow();
	        		String idNV =tbl_nhanvien.getValueAt(row, 0).toString();
	        		for(int i=0; i<listNV.size();i++) {
	        			if(listNV.get(i).getMaNhanVien().equalsIgnoreCase(idNV)) {
	        				nv = listNV.get(i);
	        				index =i;
	        				break;
	        			}
	        		}
	        		txt_MaNV.setEnabled(false);
	        		txt_MaNV.setText(nv.getMaNhanVien());
	        		txt_HoTen.setText(nv.getHoTen());
	        		txt_SDT.setText(nv.getSoDienThoai());
	        		txt_Email.setText(nv.getEmail());
	        		txt_pass.setEnabled(false);
	        		txt_pass.setText(nv.getMatKhau());
	        		txt_DiaChi.setText(nv.getDiachi());
	        		if(nv.getGioiTinh().equals("Nam")) {
	        			comboBox_GioiTinh.setSelectedItem("Nam");
	        		}else if(nv.getGioiTinh().equals("Nữ")) {
	        			comboBox_GioiTinh.setSelectedItem("Nữ");
	        		}else {
	        			comboBox_GioiTinh.setSelectedItem("Khác");
	        		}
	        		if(nv.getNhom() == 1) {
	        			comboBox_Nhom.setSelectedItem("Quản lý");
	        		}else  {
	        			comboBox_Nhom.setSelectedItem("Nhân viên");
	        		}
	        		if(nv.getTrangThai()==1) {
	        			comboBox_TrangThai.setSelectedItem("Hoạt động");
	        		}else {
	        			comboBox_TrangThai.setSelectedItem("Đã khóa");
	        		}

	        	}
	        	
	        	
	        });

	        tbl_nhanvien.setModel(new DefaultTableModel(
	            new Object [][] {
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	            	{null, null, null, null,  null, null, null, null},
	                {null, null, null, null,  null, null, null, null},
	            },
	            new String [] {
	                "Mã NV", "Tên NV", "Số ĐT", "Email", "Địa chỉ","Giới tính","Nhóm","Trạng thái"
	            }
	        ));
	        jScrollPane1.setViewportView(tbl_nhanvien);
	        setLayout(null);
	        add(jScrollPane1);
	        
	        JLabel lbl_MaNV = new JLabel("Mã nhân viên");
	        lbl_MaNV.setBounds(10, 99, 89, 26);
	        add(lbl_MaNV);
	        lbl_MaNV.setHorizontalAlignment(SwingConstants.TRAILING);
	        lbl_MaNV.setVerticalAlignment(SwingConstants.TOP);
	        
	        txt_MaNV = new JTextField();
	        txt_MaNV.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_MaNV.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_MaNV.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_MaNV.setBounds(109, 93, 118, 27);
	        add(txt_MaNV);
	        txt_MaNV.setColumns(10);
	        
	        JLabel lbl_HotenNV = new JLabel("Họ tên");
	        lbl_HotenNV.setBounds(35, 144, 64, 14);
	        add(lbl_HotenNV);
	        
	        txt_HoTen = new JTextField();
	        txt_HoTen.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_HoTen.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	public void focusLost(FocusEvent e) {
	        		txt_HoTen.setBorder(new LineBorder(Color.WHITE));
	        	}
	        	
	        });
	        txt_HoTen.setBounds(109, 138, 118, 27);
	        add(txt_HoTen);
	        txt_HoTen.setColumns(10);
	        
	        JLabel lbl_SĐT = new JLabel("Số ĐT");
	        lbl_SĐT.setBounds(35, 194, 64, 14);
	        add(lbl_SĐT);
	        
	        JLabel lbl_Email = new JLabel("Email");
	        lbl_Email.setBounds(35, 243, 64, 14);
	        add(lbl_Email);
	        
	        txt_Email = new JTextField();
	        txt_Email.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_Email.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_Email.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_Email.setBounds(109, 237, 118, 26);
	        add(txt_Email);
	        txt_Email.setColumns(10);
	        
	        JLabel lbl_MatKhau = new JLabel("Mật khẩu");
	        lbl_MatKhau.setBounds(35, 294, 64, 14);
	        add(lbl_MatKhau);
	        
	        JLabel lbl_DiaChi = new JLabel("Địa chỉ");
	        lbl_DiaChi.setHorizontalAlignment(SwingConstants.TRAILING);
	        lbl_DiaChi.setBounds(237, 99, 55, 14);
	        add(lbl_DiaChi);
	        
	        txt_DiaChi = new JTextField();
	        txt_DiaChi.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_DiaChi.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_DiaChi.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_DiaChi.setText("");
	        txt_DiaChi.setBounds(331, 94, 120, 25);
	        add(txt_DiaChi);
	        txt_DiaChi.setColumns(10);
	        
	        JLabel lbl_GioiTinh = new JLabel("Giới tính");
	        lbl_GioiTinh.setHorizontalAlignment(SwingConstants.TRAILING);
	        lbl_GioiTinh.setBounds(237, 144, 64, 14);
	        add(lbl_GioiTinh);
	        
	        comboBox_GioiTinh = new JComboBox();
	        comboBox_GioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
	        comboBox_GioiTinh.setBounds(331, 138, 108, 27);
	        add(comboBox_GioiTinh);
	        
	        txt_SDT = new JTextField();
	        txt_SDT.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_SDT.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_SDT.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_SDT.setBounds(109, 188, 118, 27);
	        add(txt_SDT);
	        txt_SDT.setColumns(10);
	        
	        lbl_Nhom = new JLabel("Nhóm");
	        lbl_Nhom.setBounds(256, 194, 55, 14);
	        add(lbl_Nhom);
	        
	        comboBox_Nhom = new JComboBox();
	        comboBox_Nhom.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
	        comboBox_Nhom.setBounds(331, 187, 108, 29);
	        add(comboBox_Nhom);
	        
	        lbl_TrangThai = new JLabel("Trạng thái");
	        lbl_TrangThai.setBounds(256, 243, 77, 14);
	        add(lbl_TrangThai);
	        
	        comboBox_TrangThai = new JComboBox();
	        comboBox_TrangThai.setModel(new DefaultComboBoxModel(new String[] {"Hoạt động", "Đã khóa"}));
	        comboBox_TrangThai.setBounds(331, 237, 108, 27);
	        add(comboBox_TrangThai);
	        
	        JButton btn_Search = new JButton("");
	        btn_Search.setForeground(Color.GRAY);
	        btn_Search.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String key = txt_search.getText();
	        		if(key.equals("Từ khóa.........")) {
	        			key = "";
	        		}
	        		if(key.equals("")) {
	        			getData(listNV);
	        		}
	        		ArrayList<NhanVien> search = new ArrayList<NhanVien>();
	        		for(NhanVien nv : listNV) {
	        			if(nv.getMaNhanVien().contains(key) || nv.getSoDienThoai().contains(key) || nv.getEmail().contains(key) ){
	        				search.add(nv);
	        			}
	        		}
	        		txt_search.setForeground(Color.GRAY);
	     	        txt_search.setFont(new Font("Tahoma", Font.ITALIC, 11));
	        		txt_search.setText("Từ khóa.........");
	        		getData(search);
	        	}
	        });
	        btn_Search.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Start-Menu-Search-icon.png"));
	        btn_Search.setBounds(740, 93, 46, 29);
	        add(btn_Search);
	        
	        txt_search = new JTextField();	
	        txt_search.setForeground(Color.GRAY);
	        txt_search.setFont(new Font("Tahoma", Font.ITALIC, 11));
	        txt_search.setText("Từ khóa........."); 
	        txt_search.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_search.setBorder(new LineBorder(Color.BLUE));
	        		if(txt_search.getText().equals("Từ khóa.........")){
	        			txt_search.setText("");
	        		}
	        		txt_search.setForeground(Color.BLACK);
	        		txt_search.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_search.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_search.setBounds(491, 92, 239, 29);
	        add(txt_search);
	        txt_search.setColumns(10);
	        
	      //  JButton btn_add = new JButton("Thêm");
	        btn_add.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		String maNV = txt_MaNV.getText().trim();
	        		String tenNV = txt_HoTen.getText().trim();
	        		String sdt = txt_SDT.getText();
	        		String email = txt_Email.getText().trim();
	        		String matKhau = txt_pass.getText();
	        		String diaChi = txt_DiaChi.getText().trim();
	        		String gioiTinh ="";
	        		if(comboBox_GioiTinh.getSelectedItem().equals("Nam")) {
	        			gioiTinh = "Nam";
	        		}else if(comboBox_GioiTinh.getSelectedItem().equals("Nữ")) {
	        			gioiTinh = "Nữ";
	        		}else {
	        			gioiTinh = "Khác";
	        		}
	        		int nhom =0;
	        		if(comboBox_Nhom.getSelectedItem().equals("Quản lý")) {
	        			nhom = 1;
	        		}else {
	        			nhom = 0;
	        		}
	        		int trangThai =0;
	        		if(comboBox_TrangThai.getSelectedItem().equals("Hoạt động")) {
	        			trangThai = 1;
	        		}else {
	        			trangThai = 0;
	        		}
	        		
	        		NhanVien nv = new NhanVien();
	        		int KT=0;
	        		if(CheckID(listNV,maNV)) {
	        			nv.setMaNhanVien(maNV);
	        		}else {
	        			txt_MaNV.setBorder(new LineBorder(Color.RED));
	        			KT++;

	        		}
	        		if(CheckName(tenNV)) {
	        			nv.setHoTen(tenNV);
	        		}else {
	        			txt_HoTen.setBorder(new LineBorder(Color.RED));
	        			KT++;

	        		}
	        		if(!sdt.substring(0,1).equals("0")) {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại không hợp lệ","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			txt_SDT.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(sdt.length() >= 10 && sdt.length() <=11 ) {
	        			nv.setSoDienThoai(sdt);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại phải >=10 hoặc <=11 chữ số","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			txt_SDT.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(!email.contains("@gmail.com")) {
	    				JOptionPane.showMessageDialog(txt_Email, "Email phải có định dạng xxx.@gmail.com!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	    				txt_Email.setBorder(new LineBorder(Color.RED));
	    				KT++;
	    			}
	        		if(CheckEmail(email)) {
	        			nv.setEmail(email);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_Email, "Email không được chưa kí tự đặt biệt!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	        			txt_Email.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(matKhau.length()>=8) {
	        			nv.setMatKhau(Utils.md5(matKhau));
	        		}else {
	        			JOptionPane.showMessageDialog(txt_pass, "Mật khẩu ít nhất 8 kí tự!!!","Lỗi Mật khẩu", JOptionPane.ERROR_MESSAGE);
	        			txt_pass.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(KT!=0) {
	        			return;
	        		}
	        		nv.setDiachi(diaChi);
	        		nv.setGioiTinh(gioiTinh);
	        		nv.setNhom(nhom);
	        		nv.setTrangThai(trangThai);
	        		listNV.add(nv);
	        		saveFile();
	        		getData(listNV);
	        		reset();
	        		JOptionPane.showMessageDialog(btn_add, "Thêm nhân viên thành công!!!");
	        	}
	        });
	        btn_add.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-list-add-user-icon.png"));
	        btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_add.setBackground(Color.GRAY);
	        btn_add.setForeground(new Color(0, 0, 0));
	        btn_add.setBounds(493, 165, 108, 43);
	        add(btn_add);
	        
	        JButton btn_delete = new JButton("Xóa");
	        btn_delete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(txt_MaNV.getText().equals("")) {
	        			JOptionPane.showMessageDialog(txt_MaNV, "Hãy chọn Nhân Viên muốn xóa!!!");
	        			return;
	        		}
	        		Integer confirm =JOptionPane.showConfirmDialog(btn_delete,"Bạn có chắc chắn muốn xóa không?","Xóa",2);
	        		if(confirm == JOptionPane.YES_OPTION) {
	        			if(listNV.remove(nv)) {
	        				saveFile();
	        				getData(listNV);
	        				JOptionPane.showMessageDialog(btn_delete, "Xóa thành công nhân viên	: "+ nv.getHoTen());
	        				reset();
	        			}else {
	        				JOptionPane.showMessageDialog(btn_delete, "Xóa thất bại!!!");
	        			}
	        		}
	        	}
	        });
	        btn_delete.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Close-icon.png"));
	        btn_delete.setBackground(Color.GRAY);
	        btn_delete.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_delete.setForeground(Color.RED);
	        btn_delete.setBounds(493, 229, 108, 40);
	        add(btn_delete);
	        
	        JButton btn_update = new JButton("Chỉnh sửa");
	        btn_update.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String maNV = txt_MaNV.getText().trim();
	        		String tenNV = txt_HoTen.getText().trim();
	        		String sdt = txt_SDT.getText();
	        		String email = txt_Email.getText().trim();
	        		String matKhau = txt_pass.getText();
	        		String diaChi = txt_DiaChi.getText().trim();
	        		String gioiTinh ="";
	        		
	        		if(comboBox_GioiTinh.getSelectedItem().equals("Nam")) {
	        			gioiTinh = "Nam";
	        		}else {
	        			gioiTinh = "Nữ";
	        		}
	        		int nhom =0;
	        		if(comboBox_Nhom.getSelectedItem().equals("Quản lý")) {
	        			nhom = 1;
	        		}else {
	        			nhom = 0;
	        		}
	        		int trangThai =0;
	        		if(comboBox_TrangThai.getSelectedItem().equals("Hoạt động")) {
	        			trangThai = 1;
	        		}else {
	        			trangThai = 0;
	        		}
	        		if(maNV.equals(nv.getMaNhanVien()) && tenNV.equals(nv.getHoTen()) && sdt.equals(nv.getSoDienThoai()) && email.equals(nv.getEmail()) &&
	        		 matKhau.equals(nv.getMatKhau()) && diaChi.equals(nv.getDiachi()) && gioiTinh.equals(nv.getGioiTinh()) && (nhom == nv.getNhom()) && (trangThai == nv.getTrangThai())) {
	        			JOptionPane.showMessageDialog(btn_update, "Thông tin nhân viên chưa được chỉnh sửa");
	        			return;
	        		}
	        		if(CheckName(tenNV)) {
	        			listNV.get(index).setHoTen(tenNV);
	        		}else {
	        			return;
	        		}
	        		if(!sdt.substring(0,1).equals("0")) {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại không hợp lệ","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			return;	
	        		}
	        		if(sdt.length() >= 10 && sdt.length() <=11 ) {
	        			listNV.get(index).setSoDienThoai(sdt);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại phải >=10 hoặc <=11 chữ số","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			return;
	        		}
	        		if(!email.contains("@gmail.com")) {
	    				JOptionPane.showMessageDialog(txt_Email, "Email phải có định dạng xxx.@gmail.com!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	    				return;
	    			}
	        		if(CheckEmail(email)) {
	        			listNV.get(index).setEmail(email);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_Email, "Email không được chưa kí tự đặt biệt!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	        			return;
	        		}
	        		listNV.get(index).setDiachi(diaChi);
	        		listNV.get(index).setGioiTinh(gioiTinh);
	        		listNV.get(index).setNhom(nhom);
	        		listNV.get(index).setTrangThai(trangThai);
	        		saveFile();
	        		getData(listNV);
	        		reset();
	        		JOptionPane.showMessageDialog(btn_update, "Chỉnh sửa thành công Nhân viên: "+maNV);
	        	}
	        });
	      
	        btn_update.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-document-edit-icon.png"));
	        btn_update.setForeground(new Color(0, 0, 0));
	        btn_update.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_update.setBackground(Color.GRAY);
	        btn_update.setBounds(648, 165, 130, 43);
	        add(btn_update);
	        
	        JButton btn_exit = new JButton("Thoát");
	        btn_exit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btn_exit.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btn_exit.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Users-Exit-icon.png"));
	        btn_exit.setForeground(new Color(0, 0, 0));
	        btn_exit.setBackground(new Color(255, 140, 0));
	        btn_exit.setBounds(648, 230, 130, 41);
	        add(btn_exit);
	        
	        txt_pass = new JPasswordField();
	        txt_pass.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_pass.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_pass.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_pass.setBounds(109, 287, 118, 29);
	        add(txt_pass);
	        
	        lblNewLabel = new JLabel("New label");
	        lblNewLabel.setBounds(1, 0, -48, 3);
	        add(lblNewLabel);
	        
	        JButton btnNewButton = new JButton("");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnNewButton.setToolTipText("Reset");
	        btnNewButton.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		reset();
	        	}
	        });
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\iconfinder_update_678134.png"));
	        btnNewButton.setBounds(391, 283, 46, 33);
	        add(btnNewButton);
	        
	        lblNewLabel_1 = new JLabel("NHÂN VIÊN");
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\boss-icon.png"));
	        lblNewLabel_1.setForeground(Color.BLACK);
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_1.setBackground(Color.WHITE);
	        lblNewLabel_1.setBounds(347, 11, 216, 27);
	        add(lblNewLabel_1);
	        
	        panel = new JPanel();
	        panel.setBackground(Color.LIGHT_GRAY);
	        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
	        panel.setBounds(11, 66, 462, 263);
	        add(panel);
	        
	        lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
	        lblNewLabel_2.setBounds(0, 49, 807, 292);
	        add(lblNewLabel_2);
	        
	        lblNewLabel_3 = new JLabel("");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
	        lblNewLabel_3.setBounds(10, 0, 64, 49);
	        add(lblNewLabel_3);
	        
	        panel_1 = new JPanel();
	        panel_1.setBackground(Color.ORANGE);
	        panel_1.setBounds(1, 0, 806, 49);
	        add(panel_1);
	    }

	   public void loadFile() {
	        try {
	            BufferedReader br = null;
	            FileReader fr = null;
	            listNV = new ArrayList<>(); //lưu ý
	            fr = new FileReader("D:\\Staffs list.txt");
	            br = new BufferedReader(fr);
	            String s = null;
	            
	            try {
	                while ((s = br.readLine()) != null) {
	                    //Cắt chuỗi:
	                    String arr[] = s.split("\t");
	                    //Khởi tạo
	                    NhanVien nv = new NhanVien();
	                    nv.setMaNhanVien(arr[0].toUpperCase());
	                    nv.setHoTen(arr[1]);
	                    nv.setSoDienThoai(arr[2]);
	                    nv.setEmail(arr[3]);
	                    nv.setMatKhau(arr[4]);
	                    nv.setDiachi(arr[5]);
	                    nv.setGioiTinh(arr[6]);
	                    nv.setNhom(Integer.parseInt(arr[7]));
	                    
	                    nv.setTrangThai(Integer.parseInt(arr[8]));
	                    listNV.add(nv);
	                }
	            } catch (IOException ex) {
	                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
	        }
	           

	    }
	public void saveFile() {
	File url = new File("D:\\Staffs list.txt");
	if(!url.exists()) {
		try {
			url.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	   try {
	       BufferedWriter bw = null; //Khởi tạo
	       FileWriter fw = null; //Khởi tạo
	       String data = ""; //Tạo một string data bằng rỗng.
	       for (int i = 0; i < listNV.size(); i++) {
	       String row = ""; //tạo hàng rỗng
	       row = row + listNV.get(i).getMaNhanVien() + "\t";
	       row = row + listNV.get(i).getHoTen() + "\t";
	       row = row + listNV.get(i).getSoDienThoai() + "\t";
	       row = row + listNV.get(i).getEmail() + "\t";
	       row = row + listNV.get(i).getMatKhau() + "\t";
	       row = row + listNV.get(i).getDiachi() + "\t";
	       row = row + listNV.get(i).getGioiTinh() + "\t";
	       row = row + listNV.get(i).getNhom() + "\t";
	       row = row + listNV.get(i).getTrangThai() + "\n";
	       data += row;
	       }
	       fw = new FileWriter(url);
	       bw = new BufferedWriter(fw);
	       bw.write(data);
	       bw.close();
	    } catch (IOException ex) {
	          Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
	      }
	}
	  private void getData(ArrayList<NhanVien> listNV) {
	        defaultTableModel = new DefaultTableModel();
	        defaultTableModel.addColumn("Mã NV");
	        defaultTableModel.addColumn("Họ tên NV");
	        defaultTableModel.addColumn("SĐT");
	        defaultTableModel.addColumn("Email");
	        defaultTableModel.addColumn("Địa chỉ");
	        defaultTableModel.addColumn("Giới tính");
	        defaultTableModel.addColumn("Nhóm");
	        defaultTableModel.addColumn("Trạng Thái");

	        for (NhanVien obj : listNV) {
	            Vector vector = new Vector();
	            vector.add(obj.getMaNhanVien());	
	            vector.add(obj.getHoTen());
	            vector.add(obj.getSoDienThoai());
	            vector.add(obj.getEmail());
	            vector.add(obj.getDiachi());
	            vector.add(obj.getGioiTinh());
	            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
	            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
	            defaultTableModel.addRow(vector);
	        }
	        tbl_nhanvien.setModel(defaultTableModel);
	    }
	  
	 private boolean CheckID(ArrayList<NhanVien> listNV, String id) {

		if(id.equals("")) {
			JOptionPane.showMessageDialog(txt_MaNV, "Mã nhân viên không được để trống!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for(NhanVien nv : listNV) {
			if(nv.getMaNhanVien().equalsIgnoreCase(id)) {
				JOptionPane.showMessageDialog(txt_MaNV, "Mã nhân viên đã tồn tại!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	private boolean CheckName(String name) {
		if(name.equals("")) {
			JOptionPane.showMessageDialog(txt_HoTen, "Tên nhân viên không được để trống!!!","Lỗi Tên",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for (int i = 0; i < 10; i++) {
			if(name.contains(String.valueOf(i))){
				JOptionPane.showMessageDialog(txt_HoTen, "Tên nhân viên không được chứa số!!!","Lỗi Tên",JOptionPane.ERROR_MESSAGE);
				return false;		
			}
		}
		return true;
	}
	
	public boolean CheckEmail(String email) {
		if(email.equals("")) {
			return true;
		}
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        return ktEmail;
    }
	private void reset() {
		txt_MaNV.setText("");
		txt_HoTen.setText("");
		txt_SDT.setText("");
		txt_Email.setText("");
		txt_pass.setText("");
		txt_DiaChi.setText("");
		comboBox_GioiTinh.setSelectedItem("Nam");
		comboBox_Nhom.setSelectedItem("Quản lí");
		comboBox_TrangThai.setSelectedItem("Hoạt động");
		btn_add.setEnabled(true);
	}
	private JTable tbl_nhanvien;
	private JScrollPane jScrollPane1;
	private JTextField txt_MaNV;
	private JTextField txt_HoTen;
	private JTextField txt_Email;
	private JTextField txt_DiaChi;
	private JTextField txt_SDT;
	private JLabel lbl_Nhom;
	private JComboBox comboBox_Nhom;
	private JLabel lbl_TrangThai;
	private JComboBox comboBox_TrangThai;
	private JTextField txt_search;
	private JPasswordField txt_pass;
	private JLabel lblNewLabel;
	private JComboBox comboBox_GioiTinh;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JButton  btn_add;
	private JLabel lblNewLabel_3;
	private JPanel panel_1;
}


