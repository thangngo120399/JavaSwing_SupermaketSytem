package jvswing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;





public class frmThongKe extends JPanel {
	private DefaultTableModel defaultTableModel;
	NumberFormat formatter = new DecimalFormat("###,###");
	public frmThongKe() {
		initComponents();
	}
	ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
	public void initComponents() {
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(0, 302, 795, 213);
			setLayout(null);
	        add(jScrollPane1);
	        tbl_thongke = new JTable();
	        jScrollPane1.setViewportView(tbl_thongke);
	        tbl_thongke.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        tbl_thongke.setModel(new DefaultTableModel(
	        		new Object[][] {
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        			{null, null, null, null,  null},
	        		{null, null, null, null,  null},
	            	
	            },
	        		new String [] {
	                        "Mã HD", "Tên sản phẩm", "Số lượng ", "Đơn giá", "Thành tiền"
	                }
	            ));
	        
	        JLabel lblNewLabel = new JLabel("Ngày tháng năm");
	        lblNewLabel.setForeground(new Color(0, 0, 255));
	        lblNewLabel.setBounds(80, 120, 94, 34);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
	        lblNewLabel_1.setForeground(new Color(0, 0, 255));
	        lblNewLabel_1.setBounds(368, 120, 83, 34);
	        add(lblNewLabel_1);
	        
	        txt_MaNV = new JTextField();
	        txt_MaNV.setBounds(472, 120, 110, 34);
	        add(txt_MaNV);
	        txt_MaNV.setColumns(10);
	        
	        JButton btn_ThongKe = new JButton("Thống kê");
	        btn_ThongKe.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		getData();
	        	}
	        });
	        btn_ThongKe.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\chart-icon (1).png"));
	        btn_ThongKe.setBounds(592, 120, 127, 34);
	        add(btn_ThongKe);

	        
	        JLabel lblNewLabel_2 = new JLabel("BÁO CÁO THỐNG KÊ");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-office-chart-area-icon.png"));
	        lblNewLabel_2.setBounds(306, 0, 185, 45);
	        add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Actions-office-chart-area-icon.png"));
	        lblNewLabel_3.setBounds(472, 0, 61, 45);
	        add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_5 = new JLabel("");
	        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
	        lblNewLabel_5.setBounds(10, 0, 64, 45);
	        add(lblNewLabel_5);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.ORANGE);
	        panel_1.setBounds(0, 0, 795, 45);
	        add(panel_1);
	        
	       jDate1 = new JDateChooser();
	        jDate1.getCalendarButton().addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		check++;
	        	}
	        });
	        jDate1.setBounds(180, 120, 137, 34);
	        add(jDate1);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(250, 250, 210));
	        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm Ki\u1EBFm", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
	        panel.setBounds(35, 84, 724, 99);
	        add(panel);
	        
	        JLabel lblNewLabel_4 = new JLabel("New label");
	        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
	        lblNewLabel_4.setBounds(0, 41, 795, 264);
	        add(lblNewLabel_4);

	   
	}
	int check=0;
	public void getData() {
		getDateHoaDon();
		if(check==0) {
			JOptionPane.showMessageDialog(this, "Bạn phải chọn ngày muốn thống kê");
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = jDate1.getDate();
		String date_str = sdf.format(date);
		if(txt_MaNV.getText().equals("")) {
				defaultTableModel= new DefaultTableModel();
				defaultTableModel.addColumn("Mã HD");
				defaultTableModel.addColumn("Tên sản phẩm");
				defaultTableModel.addColumn("Số lượng");
				defaultTableModel.addColumn("Đơn giá");
				defaultTableModel.addColumn("Thành tiền");
		
				for(HoaDon hd: listHD) {
				if(hd.getNgayban().equals(date_str)) {
					frmBanHang frmBH = new frmBanHang();
					SanPham sp = new SanPham();
					sp = frmBH.getSPByCode(hd.getMaSP());
					Vector vector = new Vector();
					vector.add(hd.getMaHD());
					vector.add(sp.getTenSP());
					vector.add(hd.getSoLuongMua());
					vector.add(formatter.format(sp.getDonGia()));
					vector.add(formatter.format(hd.getThanhGia()));
					defaultTableModel.addRow(vector);
				}
			}
			tbl_thongke.setModel(defaultTableModel);
		}else {
			defaultTableModel= new DefaultTableModel();
			defaultTableModel.addColumn("Mã HD");
			defaultTableModel.addColumn("Tên sản phẩm");
			defaultTableModel.addColumn("Số lượng");
			defaultTableModel.addColumn("Đơn giá");
			defaultTableModel.addColumn("Thành tiền");
	
			for(HoaDon hd: listHD) {
			if(hd.getNgayban().equals(date_str) && txt_MaNV.getText().equals(hd.getMaNV())) {
				frmBanHang frmBH = new frmBanHang();
				SanPham sp = new SanPham();
				sp = frmBH.getSPByCode(hd.getMaSP());
				Vector vector = new Vector();
				vector.add(hd.getMaHD());
				vector.add(sp.getTenSP());
				vector.add(hd.getSoLuongMua());
				vector.add(formatter.format(sp.getDonGia()));
				vector.add(formatter.format(hd.getThanhGia()));
				defaultTableModel.addRow(vector);
			}
		}
		tbl_thongke.setModel(defaultTableModel);
		}
		
	}
	
	
	public void getDateHoaDon() {
		        try {
		            BufferedReader br = null;
		            FileReader fr = null;
		            listHD = new ArrayList<>(); //lưu ý
		            fr = new FileReader("D:\\HoaDons list.txt");
		            br = new BufferedReader(fr);
		            String s = null;
		            
		            try {
		                while ((s = br.readLine()) != null) {
		                    //Cắt chuỗi:
		                    String arr[] = s.split("\t");
		                    //Khởi tạo
		                    HoaDon hd = new HoaDon();
		                    hd.setMaHD(arr[0]);
		                    hd.setMaNV(arr[1]);
		                    hd.setMaKH(arr[2]);
		                    hd.setMaSP(arr[3]);
		                    hd.setSoLuongMua(Integer.parseInt(arr[4]));;
		                    hd.setDonGia(Integer.parseInt(arr[5]));
		                    hd.setThanhGia(Integer.parseInt(arr[6]));
		                    hd.setNgayban(arr[7]);
		                    listHD.add(hd);
		                }
		            } catch (IOException ex) {
		                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
		            }
		        } catch (FileNotFoundException ex) {
		            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
		        }
		           

		    }
	private JScrollPane jScrollPane1;
	private JTable tbl_thongke;
	private JTextField txt_MaNV;
	private JDateChooser jDate1;
}
