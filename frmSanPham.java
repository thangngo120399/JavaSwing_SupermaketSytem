package jvswing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class frmSanPham extends JPanel {
	private DefaultTableModel defaultTableModel1;
	ArrayList<SanPham> listSP = new ArrayList<SanPham>();
	SanPham sp = new SanPham();
	NumberFormat formatter = new DecimalFormat("###,###");
	public frmSanPham() {
		initComponents();
		loadFile();
		getData(listSP);
	}
	int index;
	public void initComponents() {
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setToolTipText("Reset");
		jScrollPane1.setBounds(1, 340, 806, 181);
		tbl_sanpham = new JTable();
		tbl_sanpham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_add.setEnabled(false);
				int row = tbl_sanpham.getSelectedRow();
				String maSP = tbl_sanpham.getValueAt(row, 0).toString();
				for( int i=0; i<listSP.size(); i++) {
					if(listSP.get(i).getMaSP().equalsIgnoreCase(maSP)) {
						sp = listSP.get(i);
						index = i;
						break;
					}
				}
				txt_MaSP.setEnabled(false);
        		txt_MaSP.setText(sp.getMaSP());
        		txt_TenSP.setText(sp.getTenSP());
        		txt_DonViTinh.setText(sp.getLoai());
        		txt_SoLuong.setText(String.valueOf(sp.getSoLuong()));
        		txt_DonGia.setText(String.valueOf(sp.getDonGia()));
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
        
        JLabel lbl_MaSP = new JLabel("Mã sản phẩm");
        lbl_MaSP.setBounds(23, 110, 89, 35);
        add(lbl_MaSP);
        
        txt_MaSP = new JTextField();
        txt_MaSP.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_MaSP.setBorder(new LineBorder(Color.BLUE));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_MaSP.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_MaSP.setBounds(122, 110, 113, 35);
        add(txt_MaSP);
        txt_MaSP.setColumns(10);
        
        lbl_TenSP = new JLabel("Tên sản phẩm");
        lbl_TenSP.setBounds(23, 172, 89, 35);
        add(lbl_TenSP);
        
        txt_TenSP = new JTextField();
        txt_TenSP.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_TenSP.setBorder(new LineBorder(Color.BLUE));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_TenSP.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_TenSP.setEditable(true);
        txt_TenSP.setText("");
        txt_TenSP.setBounds(122, 172, 113, 35);
        add(txt_TenSP);
        txt_TenSP.setColumns(10);
        
        lbl_SoLuong = new JLabel("Số lượng");
        lbl_SoLuong.setBounds(255, 110, 93, 35);
        add(lbl_SoLuong);
        
        txt_SoLuong = new JTextField();
        txt_SoLuong.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_SoLuong.setBorder(new LineBorder(Color.BLUE));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_SoLuong.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_SoLuong.setText("");
        txt_SoLuong.setBounds(326, 110, 103, 35);
        add(txt_SoLuong);
        txt_SoLuong.setColumns(10);
        
        lbl_DonGia = new JLabel("Đơn giá");
        lbl_DonGia.setBounds(257, 172, 55, 35);
        add(lbl_DonGia);
        
        txt_DonGia = new JTextField();
        txt_DonGia.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_DonGia.setBorder(new LineBorder(Color.BLUE));
        		txt_DonGia.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_DonGia.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_DonGia.setText("");
        txt_DonGia.setBounds(326, 172, 105, 35);
        add(txt_DonGia);
        txt_DonGia.setColumns(10);
        
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
        txt_search.setBounds(520, 85, 187, 28);
        add(txt_search);
        txt_search.setColumns(10);
        
        btn_search = new JButton("");
        btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String key = txt_search.getText();
        		if(key.equals("Từ khóa.........")) {
	        		key ="";
        		}
        		if(key.equals("") ) {
        			getData(listSP);
        		}
        		ArrayList<SanPham> search = new ArrayList<SanPham>();
        		for(SanPham sp : listSP) {
        			if(sp.getMaSP().contains(key) || sp.getTenSP().contains(key)){
        				search.add(sp);
        			}
        		}
        		txt_search.setForeground(Color.GRAY);
     	        txt_search.setFont(new Font("Tahoma", Font.ITALIC, 11));
        		txt_search.setText("Từ khóa.........");
        		getData(search);
        	}
        });
        btn_search.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Start-Menu-Search-icon.png"));
        btn_search.setBounds(717, 85, 40, 28);
        add(btn_search);
        
        btn_add = new JButton("Thêm");
        btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String maSP = txt_MaSP.getText().trim();
        		String tenSP = txt_TenSP.getText().trim();
        		String loai = txt_DonViTinh.getText().trim();
        		String soLuong = txt_SoLuong.getText();
        		String donGia = txt_DonGia.getText().trim();
        
        		
        		SanPham sp = new SanPham();
        		int KT=0;
        		if(CheckID(listSP,maSP)) {
        			sp.setMaSP(maSP);
        		}else {
        			txt_MaSP.setBorder(new LineBorder(Color.RED));
        			KT++;
        		}
        		if(tenSP.equals("")) {
        			JOptionPane.showMessageDialog(txt_TenSP, "Tên sản phẩm không được để trống!!!");
        			txt_TenSP.setBorder(new LineBorder(Color.RED));
        			KT++;
        		}else {
        			sp.setTenSP(tenSP);
        		}
        		sp.setLoai(loai);
        		if(soLuong.equals("")||Integer.parseInt(soLuong)<0)  {
        			JOptionPane.showMessageDialog(txt_SoLuong, "Số lượng phải lớn hơn 0!!!");
        			txt_SoLuong.setBorder(new LineBorder(Color.RED));
        			KT++;
        		}else {
        			sp.setSoLuong(Integer.parseInt(soLuong));
        			
        		}
        		if(donGia.equals("")||Integer.parseInt(donGia) < 0 ) {
        			JOptionPane.showMessageDialog(txt_SoLuong, "Đơn giá phải lớn hơn 0!!!");
        			txt_DonGia.setBorder(new LineBorder(Color.RED));
        			KT++;
        		}else {
        			sp.setDonGia(Integer.parseInt(donGia));
        		}
        		if(KT!=0) {
        			return;
        		}
        		listSP.add(sp);
        		saveFile();
        		getData(listSP);
        		reset();
        		JOptionPane.showMessageDialog(btn_add, "Thêm sản phẩm thành công!!!");

        	}
        });
        btn_add.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-list-add-user-icon.png"));
        btn_add.setBackground(new Color(128, 128, 128));
        btn_add.setBounds(520, 167, 103, 43);
        add(btn_add);
        
        btn_update = new JButton("Chỉnh sửa");
        btn_update.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn_update.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String maSP = txt_MaSP.getText().trim();
        		String tenSP = txt_TenSP.getText().trim();
        		String soLuong = txt_SoLuong.getText();
        		String donGia = txt_DonGia.getText().trim();
        		
        		if(tenSP.equals(sp.getTenSP()) && soLuong.equals(String.valueOf(sp.getSoLuong())) && donGia.equals(String.valueOf(sp.getDonGia()))) {
   	        			JOptionPane.showMessageDialog(btn_update, "Thông tin sản phẩm chưa được chỉnh sửa");
   	        			return;
   	        		}
        
        		if(tenSP.equals("")) {
        			JOptionPane.showMessageDialog(txt_TenSP, "Tên sản phẩm không được để trống!!!");
        			return;
        		}else {
        			sp.setTenSP(tenSP);
        		}
        		if(soLuong.equals("")||Integer.parseInt(soLuong)<0)  {
        			JOptionPane.showMessageDialog(txt_SoLuong, "Số lượng phải lớn hơn 0!!!");
        			return;
        		}else {
        			sp.setSoLuong(Integer.parseInt(soLuong));
        			
        		}
        		if( donGia.equals("")||Integer.parseInt(donGia) < 0 ) {
        			JOptionPane.showMessageDialog(txt_SoLuong, "Đơn giá phải lớn hơn 0!!!");
        			return;
        		}else {
        			sp.setDonGia(Integer.parseInt(donGia));
        		}
        		listSP.add(sp);
        		saveFile();
        		getData(listSP);
        		reset();
        		JOptionPane.showMessageDialog(btn_add, "Chỉnh sửa thành công sản phẩm: " + maSP);
        	}
        	
        	
        });
        btn_update.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-document-edit-icon.png"));
        btn_update.setBackground(new Color(128, 128, 128));
        btn_update.setBounds(647, 167, 132, 43);
        add(btn_update);
        
        btn_delete = new JButton("Xóa");
        btn_delete.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn_delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (txt_MaSP.getText().equals("")) {
        			JOptionPane.showMessageDialog(txt_MaSP, "Hãy chọn Sản Phẩm muốn xóa!!!");
        			return;
        		}
        		Integer confirm =JOptionPane.showConfirmDialog(btn_delete,"Bạn có chắc chắn muốn xóa không?","Xóa",2);
        		if(confirm == JOptionPane.YES_OPTION) {
        			if(listSP.remove(sp)) {
        				saveFile();
        				getData(listSP);
        				JOptionPane.showMessageDialog(btn_delete, "Xóa thành công sản phẩm	: "+ sp.getTenSP());
        				reset();
        			}else {
        				JOptionPane.showMessageDialog(btn_delete, "Xóa thất bại!!!");
        			}
        		}
        	}
        });
        btn_delete.setForeground(new Color(255, 0, 0));
        btn_delete.setBackground(new Color(128, 128, 128));
        btn_delete.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Close-icon.png"));
        btn_delete.setBounds(516, 229, 105, 48);
        add(btn_delete);
        
        btn_exit = new JButton("Thoát");
        btn_exit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn_exit.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Users-Exit-icon.png"));
        btn_exit.setBackground(new Color(255, 140, 0));
        btn_exit.setBounds(647, 229, 132, 48);
        add(btn_exit);
        
        JButton btn_reset = new JButton("");
        btn_reset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		reset();
        	}
        });
        btn_reset.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\iconfinder_update_678134.png"));
        btn_reset.setBounds(391, 229, 40, 35);
        add(btn_reset);
        
        JLabel lblNewLabel = new JLabel("SẢN PHẨM");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Coffee-brown-icon.png"));
        lblNewLabel.setBounds(369, 11, 139, 28);
        add(lblNewLabel);
        
        JLabel lbl_DonViTinh = new JLabel("Đơn vị tính");
        lbl_DonViTinh.setBounds(26, 229, 86, 35);
        add(lbl_DonViTinh);
        
        txt_DonViTinh = new JTextField();
        txt_DonViTinh.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txt_DonViTinh.setBorder(new LineBorder(Color.BLUE));
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		txt_DonViTinh.setBorder(new LineBorder(Color.WHITE));
        	}
        });
        txt_DonViTinh.setBounds(122, 229, 113, 35);
        add(txt_DonViTinh);
        txt_DonViTinh.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(10, 85, 465, 205);
        add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
        lblNewLabel_1.setBounds(1, 50, 806, 292);
        add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
        lblNewLabel_2.setBounds(10, 0, 64, 50);
        add(lblNewLabel_2);
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.GREEN);
        panel_1.setBounds(1, 0, 806, 50);
        add(panel_1);
		
		
	}
	public void loadFile() {
		File url = new File("D:\\Products list.txt");
		FileReader rd = null;
		BufferedReader br = null;
		try {
			listSP = new ArrayList<SanPham>();
		
			rd = new FileReader(url);
			br = new BufferedReader(rd);
			
			String temp = null;
			while((temp = br.readLine())!=null) {
				String arr[] = temp.split("\t");
				SanPham sp = new SanPham();
				sp.setMaSP(arr[0].toUpperCase());
				sp.setTenSP(arr[1]);
				sp.setLoai(arr[2]);
				sp.setSoLuong(Integer.parseInt(arr[3]));
				sp.setDonGia(Integer.parseInt(arr[4]));
				listSP.add(sp);
			}
		} catch (FileNotFoundException e) {
					
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public void getData(ArrayList<SanPham> listSP) {
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
	public void saveFile() {
		File url = new File("D:\\Products list.txt");
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
		       for (int i = 0; i < listSP.size(); i++) {
		       String row = ""; //tạo hàng rỗng
		       row = row + listSP.get(i).getMaSP() + "\t";
		       row = row + listSP.get(i).getTenSP() + "\t";
		       row = row + listSP.get(i).getLoai() + "\t";
		       row = row + listSP.get(i).getSoLuong() + "\t";
		       row = row + listSP.get(i).getDonGia() + "\n";
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
	private boolean CheckID(ArrayList<SanPham> listKH, String id) {

		if(id.equals("")) {
			JOptionPane.showMessageDialog(txt_MaSP, "Mã sản phẩm không được để trống!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for(SanPham sp : listSP) {
			if(sp.getMaSP().equalsIgnoreCase(id)) {
				JOptionPane.showMessageDialog(txt_MaSP, "Mã sản phẩm đã tồn tại!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	private void reset() {
		txt_MaSP.setText("");
		txt_TenSP.setText("");
		txt_DonViTinh.setText("");
		txt_SoLuong.setText("");
		txt_DonGia.setText("");
		btn_add.setEnabled(true);
	}
	
	private JScrollPane jScrollPane1;
	private JTable tbl_sanpham;
	private JTextField txt_MaSP;
	private JLabel lbl_TenSP;
	private JTextField txt_TenSP;
	private JLabel lbl_SoLuong;
	private JTextField txt_SoLuong;
	private JLabel lbl_DonGia;
	private JTextField txt_DonGia;
	private JTextField txt_search;
	private JButton btn_add;
	private JButton btn_search;
	private JButton btn_update;
	private JButton btn_delete;
	private JButton btn_exit;
	private JTextField txt_DonViTinh;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
}
