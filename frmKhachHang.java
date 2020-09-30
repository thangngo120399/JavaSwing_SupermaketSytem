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

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class frmKhachHang extends JPanel {

	private DefaultTableModel defaultTableModel;
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	KhachHang kh = new KhachHang();
	public frmKhachHang() {
		initComponents();
		loadFile();
		getData(listKH);
	}
	int index;
	public void initComponents() {
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(1, 340, 806, 181);
		tbl_khachhang = new JTable();
		btn_add = new JButton("Thêm");
		tbl_khachhang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_khachhang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btn_add.setEnabled(false);
				int row = tbl_khachhang.getSelectedRow();
        		String idKH =tbl_khachhang.getValueAt(row, 0).toString();
        		for(int i=0; i<listKH.size();i++) {
        			if(listKH.get(i).getMaKhachHang().equalsIgnoreCase(idKH)) {
        				kh = listKH.get(i);
        				index =i;
        				break;
        			}
        		}
        		txt_MaKH.setEnabled(false);
        		txt_MaKH.setText(kh.getMaKhachHang());
        		txt_HoTen.setText(kh.getHoTen());
        		txt_SDT.setText(kh.getSoDienThoai());
        		txt_Email.setText(kh.getEmail());
        		txt_DiaChi.setText(kh.getDiachi());
        	}
  
		});
		
		tbl_khachhang.setModel(new DefaultTableModel(
				new Object[][] {
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
		                "Mã", "Họ và Tên", "Số ĐT", "Email", "Địa chỉ"
		        }
	            ));
			jScrollPane1.setViewportView(tbl_khachhang);
			setLayout(null);
	        add(jScrollPane1);
	        
	        JLabel lbl_MaKH = new JLabel("Mã khách hàng");
	        lbl_MaKH.setBounds(11, 105, 95, 28);
	        add(lbl_MaKH);
	        lbl_MaKH.setHorizontalAlignment(SwingConstants.TRAILING);
	        lbl_MaKH.setVerticalAlignment(SwingConstants.TOP);
	        
	        txt_MaKH = new JTextField();
	        txt_MaKH.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_MaKH.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_MaKH.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_MaKH.setBounds(116, 105, 112, 28);
	        add(txt_MaKH);
	        txt_MaKH.setColumns(10);
	        
	        lblNewLabel = new JLabel("Họ và Tên");
	        lblNewLabel.setBounds(34, 160, 72, 28);
	        add(lblNewLabel);
	        
	        txt_HoTen = new JTextField();
	        txt_HoTen.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		txt_HoTen.setBorder(new LineBorder(Color.BLUE));
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		txt_HoTen.setBorder(new LineBorder(Color.WHITE));
	        	}
	        });
	        txt_HoTen.setBounds(116, 160, 112, 28);
	        add(txt_HoTen);
	        txt_HoTen.setColumns(10);
	        
	        lbl_SDT = new JLabel("SDT");
	        lbl_SDT.setBounds(34, 217, 72, 28);
	        add(lbl_SDT);
	        
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
	        txt_SDT.setBounds(116, 217, 112, 28);
	        add(txt_SDT);
	        txt_SDT.setColumns(10);
	        
	        lbl_Email = new JLabel("Email");
	        lbl_Email.setBounds(251, 105, 62, 28);
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
	        txt_Email.setBounds(307, 105, 112, 28);
	        add(txt_Email);
	        txt_Email.setColumns(10);
	        
	        lbl_DiaChi = new JLabel("Địa chỉ");
	        lbl_DiaChi.setBounds(251, 160, 46, 28);
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
	        txt_DiaChi.setBounds(307, 160, 112, 28);
	        add(txt_DiaChi);
	        txt_DiaChi.setColumns(10);
	        
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
	        txt_search.setBounds(496, 75, 222, 33);
	        add(txt_search);
	        txt_search.setColumns(10);
	        
	        JButton btnNewButton = new JButton("");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String key = txt_search.getText();
	        		if(key.equals("Từ khóa.........")){
	        			key = "";
	        		}
	        		if(key.equals("")) {
	        			getData(listKH);
	        		}
	        		ArrayList<KhachHang> search = new ArrayList<KhachHang>();
	        		for(KhachHang kh : listKH) {
	        			if(kh.getMaKhachHang().contains(key) || kh.getSoDienThoai().contains(key) || kh.getEmail().contains(key) ){
	        				search.add(kh);
	        			}
	        		}
	        		txt_search.setForeground(Color.GRAY);
	     	        txt_search.setFont(new Font("Tahoma", Font.ITALIC, 11));
	        		txt_search.setText("Từ khóa.........");
	        		getData(search);
	        	}
	        });
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Start-Menu-Search-icon.png"));
	        btnNewButton.setBounds(728, 75, 46, 33);
	        add(btnNewButton);
	        
	        
	        btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_add.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String maKH = txt_MaKH.getText().trim();
	        		String tenKH = txt_HoTen.getText().trim();
	        		String sdt = txt_SDT.getText();
	        		String email = txt_Email.getText().trim();
	        		String diaChi = txt_DiaChi.getText().trim();
	        		
	        		
	        		KhachHang kh = new KhachHang();
	        		int KT=0;
	        		if(CheckID(listKH,maKH)) {
	        			kh.setMaKhachHang(maKH);;
	        		}else {
	        			txt_MaKH.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(CheckName(tenKH)) {
	        			kh.setHoTen(tenKH);
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
	        			kh.setSoDienThoai(sdt);
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
	        			kh.setEmail(email);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_Email, "Email không được chưa kí tự đặt biệt!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	        			txt_Email.setBorder(new LineBorder(Color.RED));
	        			KT++;
	        		}
	        		if(KT!=0) {
	        			return;
	        		}
	        		kh.setDiachi(diaChi);
	        		listKH.add(kh);
	        		saveFile();
	        		getData(listKH);
	        		reset();
	        		JOptionPane.showMessageDialog(btn_add, "Thêm khách hàng thành công!!!");
	        	}
	        });
	        btn_add.setBackground(new Color(128, 128, 128));
	        btn_add.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-list-add-user-icon.png"));
	        btn_add.setBounds(496, 147, 118, 41);
	        add(btn_add);
	        
	        JButton btn_delete = new JButton("Xóa");
	        btn_delete.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_delete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(txt_MaKH.getText().equals("")) {
	        			JOptionPane.showMessageDialog(txt_MaKH, "Hãy chọn Khách Hàng muốn xóa!!!");
	        			return;
	        		}
	        		Integer confirm =JOptionPane.showConfirmDialog(btn_delete,"Bạn có chắc chắn muốn xóa không?","Xóa",2);
	        		if(confirm == JOptionPane.YES_OPTION) {
	        			if(listKH.remove(kh)) {
	        				saveFile();
	        				getData(listKH);
	        				JOptionPane.showMessageDialog(btn_delete, "Xóa thành công khách hàng	: "+ kh.getHoTen());
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
	        btn_delete.setBounds(496, 216, 118, 41);
	        add(btn_delete);
	        
	        JButton btn_update = new JButton("Chỉnh sửa");
	        btn_update.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_update.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String maKH = txt_MaKH.getText().trim();
	        		String tenKH = txt_HoTen.getText().trim();
	        		String sdt = txt_SDT.getText();
	        		String email = txt_Email.getText().trim();
	        		String diaChi = txt_DiaChi.getText().trim();
	        		if(maKH.equals(kh.getMaKhachHang()) && tenKH.equals(kh.getHoTen()) && sdt.equals(kh.getSoDienThoai()) && email.equals(kh.getEmail()) &&
	        		 diaChi.equals(kh.getDiachi())) {
	        			JOptionPane.showMessageDialog(btn_update, "Thông tin khách hàng chưa được chỉnh sửa");
	        			return;
	        		}
	        		if(CheckName(tenKH)) {
	        			listKH.get(index).setHoTen(tenKH);
	        		}else {
	        			return;
	        		}
	        		if(!sdt.substring(0,1).equals("0")) {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại không hợp lệ","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			return;	
	        		}
	        		if(sdt.length() >= 10 && sdt.length() <=11 ) {
	        			listKH.get(index).setSoDienThoai(sdt);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_SDT,"Số điện thoại phải >=10 hoặc <=11 chữ số","Lỗi SĐT",JOptionPane.ERROR_MESSAGE);
	        			return;
	        		}
	        		if(!email.contains("@gmail.com")) {
	    				JOptionPane.showMessageDialog(txt_Email, "Email phải có định dạng xxx.@gmail.com!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	    				return;
	    			}
	        		if(CheckEmail(email)) {
	        			listKH.get(index).setEmail(email);
	        		}else {
	        			JOptionPane.showMessageDialog(txt_Email, "Email không được chưa kí tự đặt biệt!!!","Lỗi Email",JOptionPane.ERROR_MESSAGE);
	        			return;
	        		}
	        		listKH.get(index).setDiachi(diaChi);
	        		saveFile();
	        		getData(listKH);
	        		reset();
	        		JOptionPane.showMessageDialog(btn_update, "Chỉnh sửa thành công Nhân viên: "+maKH);
	        	}
	        	
	        });
	        btn_update.setBackground(new Color(128, 128, 128));
	        btn_update.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-document-edit-icon.png"));
	        btn_update.setBounds(645, 147, 129, 41);
	        add(btn_update);
	        
	        JButton btn_exit = new JButton("Thoát");
	        btn_exit.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btn_exit.setBackground(new Color(255, 165, 0));
	        btn_exit.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Users-Exit-icon.png"));
	        btn_exit.setBounds(645, 216, 129, 41);
	        add(btn_exit);
	        
	        label = new JLabel("New label");
	        label.setBounds(1, 290, 396, -264);
	        add(label);
	        
	        btnNewButton_1 = new JButton("");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		reset();
	        	}
	        });
	        btnNewButton_1.setToolTipText("Reset");
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\iconfinder_update_678134.png"));
	        btnNewButton_1.setBounds(379, 217, 40, 28);
	        add(btnNewButton_1);
	        
	        panel = new JPanel();
	        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
	        panel.setBackground(Color.LIGHT_GRAY);
	        panel.setBounds(10, 73, 437, 206);
	        add(panel);
	        
	        lblNewLabel_1 = new JLabel("Khách Hàng");
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Occupations-Bartender-Male-Light-icon.png"));
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_1.setBounds(369, 0, 187, 41);
	        add(lblNewLabel_1);
	        
	        lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
	        lblNewLabel_2.setBounds(1, 48, 802, 294);
	        add(lblNewLabel_2);
	        
	        lblNewLabel_3 = new JLabel("");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
	        lblNewLabel_3.setBounds(11, 0, 62, 50);
	        add(lblNewLabel_3);
	        
	        panel_1 = new JPanel();
	        panel_1.setBackground(Color.ORANGE);
	        panel_1.setBounds(1, 0, 806, 50);
	        add(panel_1);

	}
	
	public void loadFile() {
		try {
			File url = new File("D:\\Customers list.txt");
			FileReader rd = null;
			BufferedReader br = null;
			listKH = new ArrayList<KhachHang>();
		
			rd = new FileReader(url);
			br = new BufferedReader(rd);
			
			String temp = null;
			while((temp = br.readLine())!=null) {
				String arr[] = temp.split("\t");
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(arr[0].toUpperCase());
				kh.setHoTen(arr[1]);
				kh.setSoDienThoai(arr[2]);
				kh.setEmail(arr[3]);
				kh.setDiachi(arr[4]);
				listKH.add(kh);
			}
		} catch (FileNotFoundException e) {
					
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public void getData(ArrayList<KhachHang> listKH) {
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Mã");
		defaultTableModel.addColumn("Họ và Tên");
		defaultTableModel.addColumn("Số ĐT");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Địa chỉ");
		
		for(KhachHang kh : listKH) {
			Vector vector = new Vector();
			vector.add(kh.getMaKhachHang());
			vector.add(kh.getHoTen());
			vector.add(kh.getSoDienThoai());
			vector.add(kh.getEmail());
			vector.add(kh.getDiachi());
			defaultTableModel.addRow(vector);
		}
		tbl_khachhang.setModel(defaultTableModel);
	}
	
	public void saveFile() {
		File url = new File("D:\\Customers list.txt");
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
		       for (int i = 0; i < listKH.size(); i++) {
		       String row = ""; //tạo hàng rỗng
		       row = row + listKH.get(i).getMaKhachHang() + "\t";
		       row = row + listKH.get(i).getHoTen() + "\t";
		       row = row + listKH.get(i).getSoDienThoai() + "\t";
		       row = row + listKH.get(i).getEmail() + "\t";
		       row = row + listKH.get(i).getDiachi() +"\n";
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
	
	 private boolean CheckID(ArrayList<KhachHang> listKH, String id) {

			if(id.equals("")) {
				JOptionPane.showMessageDialog(txt_MaKH, "Mã khách hàng không được để trống!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			for(KhachHang kh : listKH) {
				if(kh.getMaKhachHang().equalsIgnoreCase(id)) {
					JOptionPane.showMessageDialog(txt_MaKH, "Mã khách hàng đã tồn tại!!!","Lỗi ID",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			return true;
		}
	
		private boolean CheckName(String name) {
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
			txt_MaKH.setText("");
			txt_HoTen.setText("");
			txt_SDT.setText("");
			txt_Email.setText("");
			txt_DiaChi.setText("");
			btn_add.setEnabled(true);
		}
	private JScrollPane jScrollPane1;
	private JTable tbl_khachhang;
	private JTextField txt_MaKH;
	private JLabel lblNewLabel;
	private JTextField txt_HoTen;
	private JLabel lbl_SDT;
	private JTextField txt_SDT;
	private JLabel lbl_Email;
	private JTextField txt_Email;
	private JLabel lbl_DiaChi;
	private JTextField txt_DiaChi;
	private JTextField txt_search;
	private JLabel label;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btn_add;
	private JLabel lblNewLabel_3;
	private JPanel panel_1;
}
