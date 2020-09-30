package jvswing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//
//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class frmBanHang extends JPanel {
	//private static final int ArrayList = 0;
	private DefaultTableModel defaultTableModel1;
	private DefaultTableModel defaultTableModel2;
	private DefaultTableModel defaultTableModel3;
	ArrayList<SanPham> listSP = new ArrayList<SanPham>();
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	ArrayList<HoaDon> listGioHang = new ArrayList<HoaDon>();
	NumberFormat formatter = new DecimalFormat("###,###");
	HoaDon hd1 = new HoaDon();
	KhachHang kh = new KhachHang();
	SanPham sp = new SanPham();
	int index;
	int checkKH=0;
	String tenSP;
	public frmBanHang() {
		initComponents();
		listSP =loadFileSP();
		getDataSP(listSP);
		listKH = loadFileKH();
		getDataKH(listKH);
		btn_thanhToan.setEnabled(false);
	}
	String maSP;
	public void initComponents() {
		setLayout(null);
       
        jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 327, 373, 136);
		tbl_sanpham = new JTable();
		tbl_sanpham.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check++;
				
				int row = tbl_sanpham.getSelectedRow();
				String maSP = tbl_sanpham.getValueAt(row, 0).toString();
				for( int i=0; i<listSP.size(); i++) {
					if(listSP.get(i).getMaSP().equalsIgnoreCase(maSP)) {
						sp = listSP.get(i);
						index = i;
						break;
					}
				}
				txt_soLuong.setText("1");
			}
			
		});
        tbl_sanpham.setModel(new DefaultTableModel(
    			new Object[][] {
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},
    				{null, null, null, null, null},			
    				
    			
    			},
    			new String[] {
    					"Mã", "Tên SP","Đơn vị","Số lượng", "Đơn giá"
    			}
    			
    		));
    		
    		jScrollPane1.setViewportView(tbl_sanpham);
    		setLayout(null);
            add(jScrollPane1);

        jScrollPane2 = new JScrollPane();
		jScrollPane2.setBounds(10, 96, 373, 136);
		setLayout(null);
        add(jScrollPane2);
        tbl_khachhang = new JTable();
    	tbl_khachhang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				checkKH++;
				int row = tbl_khachhang.getSelectedRow();
        		String idKH =tbl_khachhang.getValueAt(row, 0).toString();
        		for(int i=0; i<listKH.size();i++) {
        			if(listKH.get(i).getMaKhachHang().equalsIgnoreCase(idKH)) {
        				kh = listKH.get(i);
        				index =i;
        				break;
        			}
        		}
        		lbl_maKH.setEnabled(false);
        		lbl_maKH.setText(kh.getMaKhachHang());
        		lbl_hoTen.setText(kh.getHoTen());
        		lbl_SDT.setText(kh.getSoDienThoai());
        		lbl_Email.setText(kh.getEmail());
        		lbl_diaChi.setText(kh.getDiachi());
        	}
  
		});
        
        jScrollPane2.setViewportView(tbl_khachhang);
        tbl_khachhang.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	            	{null, null, null, null,  null, null},
	                {null, null, null, null,  null, null},
	            },
				new String [] {
		                "Mã", "Họ và Tên", "Số ĐT", "Email","Địa chỉ"
		        }
	            ));
        
        jScrollPane3 = new JScrollPane();
		jScrollPane3.setBounds(436, 205, 340, 120);
		setLayout(null);
        add(jScrollPane3);
        tbl_gioHang = new JTable();
        tbl_gioHang.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btn_delete.setEnabled(true);
        		int row = tbl_gioHang.getSelectedRow();
				String maSP = tbl_gioHang.getValueAt(row, 0).toString();
				tenSP = tbl_gioHang.getValueAt(row,1).toString();
				for( int i=0; i<listSP.size(); i++) {
					if(listGioHang.get(i).getMaSP().equalsIgnoreCase(maSP)) {
						hd1 = listGioHang.get(i);
						index = i;
						break;
					}
				}
				
        	}
        });
        jScrollPane3.setViewportView(tbl_gioHang);
        
        tbl_gioHang.setModel(new DefaultTableModel(
        		new Object[][] {
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},
        			{null, null, null, null},			
        			
        		
        		},
        		new String[] {
        				"A", "B","C", "D"
        		}
        		
        	));
        
        
        
        txt_searchKH = new JTextField();
        txt_searchKH.setForeground(Color.GRAY);
        txt_searchKH.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txt_searchKH.setText("Từ khóa........."); 
        
        txt_searchKH.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_searchKH.setBorder(new LineBorder(Color.BLUE));
        		if(txt_searchKH.getText().equals("Từ khóa.........")){
        			txt_searchKH.setText("");
        		}
        		txt_searchKH.setForeground(Color.BLACK);
        		txt_searchKH.setFont(new Font("Tahoma", Font.PLAIN, 11));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_searchKH.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_searchKH.setBounds(47, 60, 208, 25);
        add(txt_searchKH);
        txt_searchKH.setColumns(10);
        
        JButton btn_searchKH = new JButton("");
        btn_searchKH.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String key = txt_searchKH.getText();
        		if(key.equals("Từ khóa.........")) {
        			key="";
        		}
        		if(key.equals("")) {
        			getDataKH(listKH);
        		}
        		ArrayList<KhachHang> search = new ArrayList<KhachHang>();
        		for(KhachHang kh : listKH) {
        			if(kh.getMaKhachHang().contains(key) || kh.getSoDienThoai().contains(key) || kh.getEmail().contains(key) ){
        				search.add(kh);
        			}
        		}
        		txt_searchKH.setForeground(Color.GRAY);
                txt_searchKH.setFont(new Font("Tahoma", Font.ITALIC, 11));
                txt_searchKH.setText("Từ khóa.........");
                if (search.size()==0) {
                	JOptionPane.showMessageDialog(btn_searchKH, "Khách hàng chưa tồn tại!!!\nHãy thêm khách hàng!!!");
                	return;
                }
        		getDataKH(search);
        	}
        });
        btn_searchKH.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Start-Menu-Search-icon.png"));
        btn_searchKH.setBounds(265, 60, 37, 25);
        add(btn_searchKH);
       
        
        txt_searchSP = new JTextField();
        txt_searchSP.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_searchSP.setBorder(new LineBorder(Color.BLUE));
        		if(txt_searchSP.getText().equals("Từ khóa.........")){
        			txt_searchSP.setText("");
        		}
        		txt_searchSP.setForeground(Color.BLACK);
        		txt_searchSP.setFont(new Font("Tahoma", Font.PLAIN, 11));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_searchSP.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_searchSP.setForeground(Color.GRAY);
        txt_searchSP.setFont(new Font("Tahoma", Font.ITALIC, 11));
        txt_searchSP.setText("Từ khóa........."); 
        JButton btn_searchSP = new JButton("");
        btn_searchSP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String key = txt_searchSP.getText();
        		if(key.equals("Từ khóa.........")) {
        			key="";
        		}
        		if(key.equals("") ) {
        			getDataSP(listSP);
        		}
        		ArrayList<SanPham> search = new ArrayList<SanPham>();
        		for(SanPham sp : listSP) {
        			if(sp.getMaSP().contains(key)|| sp.getTenSP().contains(key)){
        				search.add(sp);
        			}
        		}
        		   txt_searchSP.setForeground(Color.GRAY);
        	        txt_searchSP.setFont(new Font("Tahoma", Font.ITALIC, 11));
        	        txt_searchSP.setText("Từ khóa........."); 
        		getDataSP(search);
        	}
        	
        });
        
        txt_searchSP.setBounds(47, 283, 208, 25);
        add(txt_searchSP);
        txt_searchSP.setColumns(10);
        
        btn_searchSP.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Start-Menu-Search-icon.png"));
        btn_searchSP.setBounds(265, 283, 37, 25);
        add(btn_searchSP);
        
        panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel_1.setBounds(0, 38, 400, 204);
        add(panel_1);
        
        JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Inventory-icon.png"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(291, 0, 198, 41);
        add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Nhân Viên:  ");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\users-icon.png"));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(564, 0, 97, 41);
        add(lblNewLabel_1);
        
        txt_soLuong = new JTextField();
        txt_soLuong.setBounds(149, 484, 37, 25);
        txt_soLuong.setText("0");
        add(txt_soLuong);
        txt_soLuong.setColumns(10);
        
        lblNewLabel_2 = new JLabel("Số lượng");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(77, 484, 62, 25);
        add(lblNewLabel_2);
        
        btn_them = new JButton("Thêm vào giỏ hàng");
        
        btn_them.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (sp.getSoLuong() == 0) {
        		JOptionPane.showMessageDialog(btn_them, "Hiện tại trong kho đã hết sản phẩm này!!!");
        		txt_soLuong.setText("0");
        		return;
        	}
        	int soluong = Integer.parseInt(txt_soLuong.getText());
        	 if(check==0) {
    			 JOptionPane.showMessageDialog(btn_them,"Hãy chọn sản phẩm");
    			 return;
    		 }
        	 if(soluong <= 0) {
        		 JOptionPane.showMessageDialog(btn_them,"Số lượng sản phẩm phải lớn hơn 0!");
        		 txt_soLuong.setText("0");
        	 }else if(soluong > sp.getSoLuong()) {
        		 JOptionPane.showMessageDialog(btn_them,"Số lượng trong kho không đủ!", "Lỗi số lượng",JOptionPane.ERROR_MESSAGE);
        		 txt_soLuong.setText(String.valueOf(sp.getSoLuong()));
        	 }else {
        		 HoaDon hd = new HoaDon();
        		 hd.setMaSP(sp.getMaSP());
        		 hd.setSoLuongMua(soluong);
        		 hd.setDonGia(sp.getDonGia());
        		 hd.setThanhGia(soluong * sp.getDonGia());
        		 if(checkExistGioHang(hd.getMaSP(), listGioHang)) {
        			 HoaDon hoadon = listGioHang.get(indexTrungSP);
        			 hoadon.setSoLuongMua(soluong + hoadon.getSoLuongMua());
        			 hoadon.setThanhGia(hoadon.getThanhGia()+soluong * sp.getDonGia());
        			 listGioHang.set(indexTrungSP,hoadon);
        		 }else {
        			 listGioHang.add(hd);
        		 }
        		 getDataHoaDon(listGioHang);
        		 JOptionPane.showMessageDialog(btn_them, "Thêm vào giỏ hàng thành công");

        		 Tongtien(listGioHang);
        		 getDataSP(listSP);
        		 txt_soLuong.setText("0");
        		 check=0;
        	}
        }
        	 
        });
       
        btn_them.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\shop-cart-add-icon.png"));
        btn_them.setBounds(196, 479, 187, 34);
        add(btn_them);
        
        a = new JLabel("Mã KH: ");
        a.setBounds(439, 56, 68, 25);
        add(a);
        
        lbl_maKH = new JLabel("........");
        lbl_maKH.setForeground(SystemColor.textHighlight);
        lbl_maKH.setBounds(484, 56, 97, 25);
        add(lbl_maKH);
        
        lblNewLabel_3 = new JLabel("SĐT: ");
        lblNewLabel_3.setBounds(439, 97, 55, 25);
        add(lblNewLabel_3);
        
        lbl_SDT = new JLabel("........");
        lbl_SDT.setForeground(SystemColor.textHighlight);
        lbl_SDT.setBounds(478, 97, 103, 25);
        add(lbl_SDT);
        
        lblNewLabel_5 = new JLabel("Địa Chỉ: ");
        lblNewLabel_5.setBounds(439, 132, 68, 25);
        add(lblNewLabel_5);
        
        lbl_diaChi = new JLabel(".........................................");
        lbl_diaChi.setForeground(SystemColor.textHighlight);
        lbl_diaChi.setBounds(502, 133, 254, 24);
        add(lbl_diaChi);
        
        lblNewLabel_4 = new JLabel("Họ và Tên: ");
        lblNewLabel_4.setBounds(564, 60, 68, 25);
        add(lblNewLabel_4);
        
        lbl_hoTen = new JLabel("................................");
        lbl_hoTen.setForeground(SystemColor.textHighlight);
        lbl_hoTen.setBounds(631, 56, 162, 25);
        add(lbl_hoTen);
        
        lblNewLabel_6 = new JLabel("Email: ");
        lblNewLabel_6.setBounds(570, 96, 55, 25);
        add(lblNewLabel_6);
        
        lbl_Email = new JLabel("......................");
        lbl_Email.setForeground(SystemColor.textHighlight);
        lbl_Email.setBounds(615, 96, 161, 25);
        add(lbl_Email);
        
        lblNewLabel_7 = new JLabel("Giỏ Hàng: ");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\shopping-basket-add-icon.png"));
        lblNewLabel_7.setBounds(438, 168, 97, 25);
        add(lblNewLabel_7);
        
        btn_delete = new JButton("Xóa khỏi giỏ hàng");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Integer confirm =JOptionPane.showConfirmDialog(btn_delete,"Bạn có chắc chắn muốn xóa không?","Xóa",2);
        		
        		if(confirm == JOptionPane.YES_OPTION) {
        			if(listGioHang.remove(hd1)) {
        				JOptionPane.showMessageDialog(btn_delete, "Xóa thành công sản phẩm	: "+ tenSP);
        			}else {
        				JOptionPane.showMessageDialog(btn_delete, "Xóa thất bại!!!");
        			}
        			getDataHoaDon(listGioHang);
        			Tongtien(listGioHang);
        			btn_delete.setEnabled(false);
        		}
        	}
        });
        btn_delete.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Close-icon (1).png"));
        btn_delete.setBounds(564, 341, 212, 34);
        add(btn_delete);
        
        lblNewLabel_8 = new JLabel("Tổng tiền: ");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\money-icon.png"));
        lblNewLabel_8.setBounds(515, 392, 88, 25);
        add(lblNewLabel_8);
        
        lbl_tongTien = new JLabel(".......................");
        lbl_tongTien.setForeground(SystemColor.textHighlight);
        lbl_tongTien.setBounds(604, 392, 108, 25);
        add(lbl_tongTien);
        
        lblNewLabel_9 = new JLabel("(VND)");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_9.setBounds(693, 397, 42, 14);
        add(lblNewLabel_9);
        
        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(0, 260, 400, 269);
        add(panel);
        
        btn_thanhToan = new JButton("Thanh Toán");
        btn_thanhToan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int tongtien = Tongtien(listGioHang);
        		if(checkKH==0) {
        			JOptionPane.showMessageDialog(btn_thanhToan,"Vui lòng chọn khách hàng trước");
        			return;
        		}else {
        			Date date = new Date();
        			//Định dạng hóa đơn
        			SimpleDateFormat sdf = 	new SimpleDateFormat("dd-MM-yyyy--hh--mm-ss");
        			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        			String maHD = kh.getMaKhachHang() + "_" + sdf.format(date);
        			for(int i=0; i<listGioHang.size(); i++) {
        				HoaDon hd = listGioHang.get(i);
        				hd.setMaHD(maHD);
        				hd.setMaKH(kh.getMaKhachHang());
        				hd.setMaNV(frmDangNhap.maNVLogin);
        				hd.setNgayban(sdf2.format(date));
        				listGioHang.set(i,hd);
        			}
        			JTextField txtSoTien = new JTextField(10);
        			JPanel myPanel = new JPanel();
        			myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        			myPanel.add(new JLabel("Số tiền khách đưa:"));
        			myPanel.add(txtSoTien);
        			int result = JOptionPane.showConfirmDialog(null, myPanel,"Số tiền khách thanh toán", JOptionPane.OK_CANCEL_OPTION);
        			if(result==JOptionPane.OK_OPTION) {
        				 int soTienKhachDua = Integer.parseInt(txtSoTien.getText());
        				 if(soTienKhachDua < tongtien) {
        					 JOptionPane.showMessageDialog(btn_thanhToan, "Số tiền khách đưa chưa đủ!. Thiếu: "+ formatter.format(tongtien- soTienKhachDua ) + " VND" );
        					 return;
        				 }else if(soTienKhachDua > tongtien) {
        					 JOptionPane.showMessageDialog(btn_thanhToan, "Nhân viên trả lại cho khách: " + formatter.format(soTienKhachDua - tongtien) + " VND");
        				 }
        				 saveFile1();
        				 JOptionPane.showMessageDialog(btn_thanhToan, "Thanh toán thành công !!!");
        				 
        				 frmSanPham frmSP = new frmSanPham();
        				 frmSP.loadFile();
        				 for(int i=0; i<listGioHang.size(); i++) {
        					 updateSoLuong(listGioHang.get(i).getMaSP(),listGioHang.get(i).getSoLuongMua()	,frmSP.listSP);
        				 }
        				 frmSP.saveFile();
        				 getDataSP(frmSP.listSP);
        				 System.out.println(kh.getEmail());
        				 //sendHDtoEmail(listGioHang, kh.getEmail(), tongtien);
        				 listGioHang = new ArrayList<>();
        				 reset();
        			}
        		}
        	}
        });
        btn_thanhToan.setFont(new Font("Tahoma", Font.BOLD, 11));
        btn_thanhToan.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\coin-us-dollar-icon (1).png"));
        btn_thanhToan.setBounds(502, 440, 139, 41);	
        add(btn_thanhToan);
        
        btnNewButton = new JButton("Thoát");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Users-Exit-icon (1).png"));
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton.setBounds(668, 440, 108, 41);
        add(btnNewButton);
        
        panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin H\u00F3a \u0110\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel_3.setBounds(410, 38, 383, 396);
        add(panel_3);
        
        lbl_tenNV = new JLabel("");
        lbl_tenNV.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_tenNV.setForeground(Color.WHITE);
        lbl_tenNV.setBounds(654, 2, 149, 39);
        lbl_tenNV.setText(frmDangNhap.nameLogin);
        add(lbl_tenNV);
        
        panel_2 = new JPanel();
        panel_2.setBackground(Color.RED);
        panel_2.setBounds(0, 2, 815, 34);
        add(panel_2);
        
        lblNewLabel_11 = new JLabel("New label");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
        lblNewLabel_11.setBounds(0, 2, 803, 556);
        add(lblNewLabel_11);

	}
	public int  Tongtien(ArrayList<HoaDon> listHD) {
		tongtien =0;
		 for(int i=0; i<listGioHang.size(); i++) {
			 tongtien = tongtien + listGioHang.get(i).getThanhGia();        			 
		 }
		 lbl_tongTien.setText(formatter.format(tongtien));
		 return tongtien;
	}
	int tongtien;
	int checkGioHang;
	public void reset() {
		txt_soLuong.setText("0");
		lbl_hoTen.setText("..................");
		lbl_maKH.setText("..............");
		getDataHoaDon(listGioHang);
		lbl_SDT.setText("..............");
		lbl_Email.setText(".................");
		lbl_diaChi.setText("............................");
		lbl_tongTien.setText("...........");
		btn_thanhToan.setEnabled(false);
		checkKH=0;
	}
	int indexTrungSP;
//	public void update
	public boolean checkExistGioHang(String maSP, ArrayList<HoaDon> listGioHang) {
		for(int i=0; i< listGioHang.size(); i++) {
			if(maSP.equals(listGioHang.get(i).getMaSP())){
				indexTrungSP = i;
				return true;
				
			}
		}
		return false;
	}
	public void updateSoLuong(String maSP,int soLuongMua,ArrayList<SanPham> listSP) {
		for( int i=0; i<listSP.size(); i++) {
			if(maSP.equals(listSP.get(i).getMaSP())) {
				SanPham sp = listSP.get(i);
				listSP.get(i).setSoLuong(sp.getSoLuong()-soLuongMua);
				listSP.set(i,sp);
			}
		}
	}
	public void saveFile1() {
		
		   try {
			   File url = new File("D:\\HoaDons list.txt");
			   if(url.exists()) {
				  url.createNewFile();
			   }
		       BufferedWriter bw = null; //Khởi tạo
		       FileWriter fw = null; //Khởi tạo
		       String data = ""; //Tạo một string data bằng rỗng.
		       for (int i = 0; i < listGioHang.size(); i++) {
			       String row = ""; //tạo hàng rỗng
			       row = row + listGioHang.get(i).getMaHD() + "\t";
			       row = row + listGioHang.get(i).getMaNV() + "\t";
			       row = row + listGioHang.get(i).getMaKH() + "\t";
			       row = row + listGioHang.get(i).getMaSP() + "\t";
			       row = row + listGioHang.get(i).getSoLuongMua() + "\t";
			       row = row + listGioHang.get(i).getDonGia() + "\t";
			       row = row + listGioHang.get(i).getThanhGia() + "\t";
			       row = row + listGioHang.get(i).getNgayban()+ "\n";
			       data += row;
		       }
		      
		       fw = new FileWriter(url, true);
		       bw = new BufferedWriter(fw);
		       bw.write(data);
		       bw.close();
		    } catch (IOException ex) {
		          Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
		      }
		}
	
	public ArrayList<SanPham> loadFileSP(){
		ArrayList<SanPham> listSP = new ArrayList<SanPham>();
		frmSanPham frmSP = new frmSanPham();
		frmSP.loadFile();
		listSP = frmSP.listSP;
		return listSP;
	}
	 public void getDataHoaDon(ArrayList<HoaDon> listHD) {
		defaultTableModel3 = new DefaultTableModel();
 		defaultTableModel3.addColumn("Mã");
 		defaultTableModel3.addColumn("Tên SP");
 		defaultTableModel3.addColumn("Đơn vị");
 		defaultTableModel3.addColumn("Số lượng");
 		defaultTableModel3.addColumn("Đơn giá");
 		defaultTableModel3.addColumn("Thành giá");
 		
		int tongtien = 0;
 		for(HoaDon hd: listGioHang) {
 			SanPham sp = new frmBanHang().getSPByCode(hd.getMaSP());
 			Vector vector = new Vector();
 			vector.add(hd.getMaSP());
 			vector.add(sp.getTenSP());
 			vector.add(sp.getLoai());
 			vector.add(hd.getSoLuongMua());
 			vector.add(formatter.format(hd.getDonGia()));
 			vector.add(formatter.format(hd.getThanhGia()));
 			defaultTableModel3.addRow(vector);
 		}
 		
 		tbl_gioHang.setModel(defaultTableModel3);
 		if(listGioHang.size() > 0) {
 			btn_thanhToan.setEnabled(true);
 		}else {
 			btn_thanhToan.setEnabled(false);
 		}	
 		
 	}
     
	 public SanPham getSPByCode(String maSP) {
		 for(int i=0; i<listSP.size(); i++) {
			 if(maSP.equals(listSP.get(i).getMaSP())) {
				 return listSP.get(i);
			 }
		 }
		 return null;
	 }
	public void getDataSP(ArrayList<SanPham> listSP) {
		defaultTableModel1 = new DefaultTableModel();
		defaultTableModel1.addColumn("Mã");
		defaultTableModel1.addColumn("Tên SP");
		defaultTableModel1.addColumn("Đơn vị");
		defaultTableModel1.addColumn("Số lượng");
		defaultTableModel1.addColumn("Đơn giá");
		
		for(SanPham sp : listSP) {
			Vector vector = new Vector();
			vector.add(sp.getMaSP());
			vector.add(sp.getTenSP());
			vector.add(sp.getLoai());
			vector.add(sp.getSoLuong());
			vector.add(formatter.format(sp.getDonGia()));
			defaultTableModel1.addRow(vector);
		}
		
		tbl_sanpham.setModel(defaultTableModel1);
	}
	int check=0;
	public ArrayList<KhachHang> loadFileKH(){
		ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		frmKhachHang frmKH = new frmKhachHang();
		frmKH.loadFile();
		listKH = frmKH.listKH;
		return listKH;
	}
	public void getDataKH(ArrayList<KhachHang> listKH) {
		defaultTableModel2 = new DefaultTableModel();
		defaultTableModel2.addColumn("Mã");
		defaultTableModel2.addColumn("Họ và Tên");
		defaultTableModel2.addColumn("Số ĐT");
		defaultTableModel2.addColumn("Email");
		defaultTableModel2.addColumn("Địa chỉ");
		
		for(KhachHang kh : listKH) {
			Vector vector = new Vector();
			vector.add(kh.getMaKhachHang());
			vector.add(kh.getHoTen());
			vector.add(kh.getSoDienThoai());
			vector.add(kh.getEmail());
			vector.add(kh.getDiachi());
			defaultTableModel2.addRow(vector);
		}
		tbl_khachhang.setModel(defaultTableModel2);
	}
//	public void sendHDtoEmail(ArrayList<HoaDon> list, String mail, int tongtien2) {
//		try {
//			Email email = new SimpleEmail(); 
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("supermartfrance@gmail.com","stgerrard"));
//			email.setSSLOnConnect(true);
//			email.setFrom("supermartfrance@gmail.com","HỆ THỐNG SIÊU THỊ ĐIỆN MÁY LỚN NHẤT VIỆT NAM");
//			email.setSubject("HÓA ĐƠN THANH TOÁN MUA HÀNG");
//			String tt="";
//			tt = tt+ "				  				=========== THÔNG TIN HÓA ĐƠN MUA HÀNG ==============\n\n";
//			for(int i=0; i<list.size(); i++) {
//				tt = tt + "Mã sản phẩm: " +  list.get(i).getMaSP().toUpperCase()+"\t\t\tTên sản phẩm: " + getSPByCode(list.get(i).getMaSP()).getTenSP() +"\t\t\t Số lượng: "+ list.get(i).getSoLuongMua() +
//						"\t\t\t Đơn giá:  "+ list.get(i).getDonGia() + " VNĐ "+ "\t\t\t Thành tiền:  "+ list.get(i).getThanhGia()  + " VNĐ\n\n";
//			}
//			email.setMsg(tt+ "TỔNG TIỀN HÓA ĐƠN (ĐÃ BAO GỒM THUẾ GTVT VÀ CHIẾT KHẤU SẢN PHẨM: "+ formatter.format(tongtien2) +" VNĐ\n\n"
//					+ "Cảm ơn quý khách đã mua hàng tại hệ thống siêu thị của chúng tôi !!!\n"
//					+"======== XIN TRÂN TRỌNG CẢM ƠN ============");
//			email.addTo(mail);
//			email.send();
//			JOptionPane.showMessageDialog(this, "GỬI EMAIL Về Khách Hàng Thành Công !!!");
//		}catch (EmailException e) {
//			JOptionPane.showMessageDialog(this, "GỬI EMAIL KHÔNG THÀNH CÔNG !!!");
//		}
//	}
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JTable tbl_sanpham;
	private JTable tbl_khachhang;
	private JTable tbl_gioHang;
	private JTextField txt_searchKH;
	private JTextField txt_searchSP;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField txt_soLuong;
	private JLabel lblNewLabel_2;
	private JButton btn_them;
	private JLabel a;
	private JLabel lbl_maKH;
	private JLabel lblNewLabel_3;
	private JLabel lbl_SDT;
	private JLabel lblNewLabel_5;
	private JLabel lbl_diaChi;
	private JLabel lblNewLabel_4;
	private JLabel lbl_hoTen;
	private JLabel lblNewLabel_6;
	private JLabel lbl_Email;
	private JLabel lblNewLabel_7;
	private JButton btn_delete;
	private JLabel lblNewLabel_8;
	private JLabel lbl_tongTien;
	private JLabel lblNewLabel_9;
	private JPanel panel;
	private JButton btn_thanhToan;
	private JButton btnNewButton;
	private JPanel panel_3;
	private JLabel lbl_tenNV;
	private JPanel panel_2;
	private JLabel lblNewLabel_11;
}
