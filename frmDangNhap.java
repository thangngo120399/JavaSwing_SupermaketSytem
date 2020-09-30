package jvswing;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;


import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDangNhap extends JFrame {
	private JPanel contentPane;
	private JTextField txt_dangnhap;
	private JLabel lblNewLabel_2;
	private JLabel lbl_quenpass;
	private JPasswordField txt_pass;
	private JLabel lbl_noteDangNhap;
	private JLabel lbl_notePass;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap("Đăng Nhập");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmDangNhap(String title) {
		super(title);
		initComponents();
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 641);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_dangnhap = new JTextField();
		txt_dangnhap.setToolTipText("Email");
		
		txt_dangnhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txt_dangnhap.getText().equals("")) {
					lbl_noteDangNhap.setText("Vui lòng nhập địa chỉ Email hoặc SĐT");
					lbl_noteDangNhap.setForeground(Color.RED);
				}
				if(!CheckEmail(txt_dangnhap.getText())){
					lbl_noteDangNhap.setText("Email phải đúng định dạng");
					lbl_noteDangNhap.setForeground(Color.RED);
					lbl_noteDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
				}else {
					lbl_noteDangNhap.setText("");
				}
			}
		});
		
		txt_dangnhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_dangnhap.setBorder(new LineBorder(Color.BLUE));
				if(txt_dangnhap.getText().equals("Email")){
					txt_dangnhap.setText("");
					txt_dangnhap.setForeground(Color.BLACK);
					txt_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				txt_dangnhap.setBorder(new LineBorder(Color.WHITE));
				if(txt_dangnhap.getText().contentEquals("")) {
					txt_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 11));
					txt_dangnhap.setForeground(Color.GRAY);
					txt_dangnhap.setText("Email");
					txt_dangnhap.setBorder(new LineBorder(Color.RED));
					lbl_noteDangNhap.setText("Vui lòng nhập địa chỉ Email");
					lbl_noteDangNhap.setForeground(Color.RED);
				}
			}
		});
		
		
		txt_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_dangnhap.setForeground(Color.GRAY);
		txt_dangnhap.setText("Email");
		txt_dangnhap.setBounds(229, 218, 178, 31);
		contentPane.add(txt_dangnhap);
		txt_dangnhap.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\Untitled.png"));
		lblNewLabel_2.setBounds(289, 122, 60, 64);
		contentPane.add(lblNewLabel_2);
		
		lbl_quenpass = new JLabel("Quên mật khẩu?");
		lbl_quenpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_quenpass.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				quenPass();
			}
		});
	
		lbl_quenpass.setForeground(Color.BLACK);
		lbl_quenpass.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_quenpass.setForeground(new Color(0, 0, 255));
			}
		});

		lbl_quenpass.setBounds(274, 400, 107, 22);
		contentPane.add(lbl_quenpass);
		
		JButton btn_dangnhap = new JButton("Đăng nhập");
		
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMain jMain = new JMain("Quản Lí Bán Hàng");
				String userName = txt_dangnhap.getText();
				String passWord = Utils.md5(txt_pass.getText());
				frmNhanVien frmNV = new frmNhanVien();
				frmNV.loadFile();
				int dem =0;
				for( int i=0; i < frmNV.listNV.size(); i++) {
					if(userName.equals(frmNV.listNV.get(i).getEmail()) && passWord.equals(frmNV.listNV.get(i).getMatKhau())) {
						if(frmNV.listNV.get(i).getTrangThai()== 0) {
							JOptionPane.showMessageDialog(txt_dangnhap, "Tài khoản đã bị vô hiệu hóa");
							dem++;
							break;
						}
						JOptionPane.showMessageDialog(txt_dangnhap, "Đăng Nhập Thành Công!!!");
	                    jMain.setVisible(true);
	                    maNVLogin = frmNV.listNV.get(i).getMaNhanVien();
	                    nameLogin = frmNV.listNV.get(i).getHoTen();
	                    //frm.dispose();
	                   delete();
	                    dem++;
	                    break;
	                   
					}	
				}
				if(dem ==0) {
					JOptionPane.showMessageDialog(txt_dangnhap, "Đăng Nhập Thất Bại!!!");
					txt_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 11));
					txt_dangnhap.setForeground(Color.GRAY);
					txt_dangnhap.setText("Email");
					txt_pass.setText("");
				}
				
			}
		});
		btn_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_dangnhap.setForeground(Color.WHITE);
		btn_dangnhap.setBackground(new Color(30, 144, 255));
		btn_dangnhap.setBounds(229, 353, 178, 36);
		contentPane.add(btn_dangnhap);
		
		txt_pass = new JPasswordField();

		txt_pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txt_pass.getText().length()<6) {
					lbl_notePass.setText("Mật khẩu phải lớn hơn 6 kí tự");
					lbl_notePass.setForeground(Color.RED);
					lbl_notePass.setFont(new Font("Tahoma", Font.BOLD, 11));
				}else {
					lbl_notePass.setText("");
				}
			}
			
		});
		txt_pass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txt_pass.setBorder(new LineBorder(Color.WHITE));
				if(txt_pass.getText().equals("")) {
					txt_pass.setBorder(new LineBorder(Color.RED));
					lbl_notePass.setText("Vui lòng nhập mật khẩu");
					lbl_notePass.setForeground(Color.RED);
					lbl_notePass.setFont(new Font("Tahoma", Font.BOLD, 11));
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				txt_pass.setBorder(new LineBorder(Color.BLUE));
			}
		});
		
		txt_pass.setToolTipText("Mật khẩu");
		txt_pass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_pass.setBounds(229, 286, 178, 31);
		contentPane.add(txt_pass);
		
		lbl_noteDangNhap = new JLabel("");
		lbl_noteDangNhap.setBounds(229, 249, 179, 14);
		contentPane.add(lbl_noteDangNhap);
		
		lbl_notePass = new JLabel("");
		lbl_notePass.setBounds(229, 320, 178, 14);
		contentPane.add(lbl_notePass);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u0110\u0103ng Nh\u1EADp", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(185, 97, 261, 369);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\JavaNangCao-Java02\\src\\jvswing\\45603 (1).jpg"));
		lblNewLabel.setBounds(10, 0, 615, 602);
		contentPane.add(lblNewLabel);
	}
//	public void quenPass() {
//		try {
//			JOptionPane.showMessageDialog(this, "Hệ thống đang kiểm tra Email của bạn.....\nVui lòng đợi trong giây lát!");
//			String username = txt_dangnhap.getText();
//			Email email = new SimpleEmail(); 
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("supermartfrance@gmail.com","stgerrard"));
//			email.setSSLOnConnect(true);
//			email.setFrom("supermartfrance@gmail.com","HỆ THỐNG SIÊU THỊ ĐIỆN MÁY LỚN NHẤT VIỆT NAM");
//			email.setSubject("QUÊN MẬT KHẨU");
//			String tt="";
//			tt = tt+ "				  				=========== MẬT KHẨU MỚI ==============\n\n";
//			frmNhanVien frmNV = new frmNhanVien();
//			frmNV.loadFile();
//			email.setMsg(tt+ "								Mật khẩu mới của bạn là: 000000000");
//			int checkMail=0;
//			int index;
//			for(int i=0; i<frmNV.listNV.size(); i++) {
//				if(username.equals(frmNV.listNV.get(i).getEmail())){
//					frmNV.listNV.get(i).setMatKhau(Utils.md5("00000000"));
//					frmNV.saveFile();
//					email.addTo(username);
//					email.send();
//					checkMail++;
//				}
//			}
//			if(checkMail ==0) {
//				JOptionPane.showMessageDialog(this,"Email chưa được đăng kí");
//			}else {
//				JOptionPane.showMessageDialog(this,"Mật khẩu mới đã được gửi về địa chỉ: "+ username);
//			}
//			
//			
//		}catch (EmailException e) {
//			JOptionPane.showMessageDialog(this, "GỬI EMAIL KHÔNG THÀNH CÔNG !!!");
//		}
//	}
	
	public void delete() {
		this.dispose();
	}
	public boolean CheckEmail(String email) {
		
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        return ktEmail;
    }
	static String nameLogin;
	static String maNVLogin;
	
}

