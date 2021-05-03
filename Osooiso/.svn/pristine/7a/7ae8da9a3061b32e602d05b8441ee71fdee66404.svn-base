package osooiso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CreateAccount extends JDialog implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	private final JPanel createAccountPanel = new JPanel();
	private JTextField tfID;
	private JPasswordField password;
	private JPasswordField Cpassword;
	private JTextField tfTelno;
	private JTextField tfNcnm;
	private JButton btnCreate;
	private JButton btnCancel;
	private JLabel lbCreateAccount;
	
	private int doCL = 0 ;
	
	PreparedStatement pstmt  = null;
	PreparedStatement pstmt2 = null;
	ResultSet 			rs	 = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			TestPop dialog = new TestPop();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreateAccount() {
		
		super ((Frame) null, "", true);
		setTitle("회원가입");
		
		setBounds(0, 0, 604, 628);//650, 220
		setLocationRelativeTo(null);//중앙에 팝업뜨는것
		getContentPane().setLayout(new BorderLayout());
		createAccountPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(createAccountPanel, BorderLayout.CENTER);
		createAccountPanel.setLayout(null);
		{
			tfID = new JTextField();
			tfID.setColumns(10);
			tfID.setBorder(null);
			tfID.setBackground(new Color(249, 249, 240));
			tfID.setBounds(210, 152, 179, 28);
			createAccountPanel.add(tfID);
		}
		{
			password = new JPasswordField();
			password.setBorder(null);
			password.setBackground(new Color(249, 249, 240));
			password.setBounds(210, 202, 179, 28);
			createAccountPanel.add(password);
		}
		{
			Cpassword = new JPasswordField();
			Cpassword.setBorder(null);
			Cpassword.setBackground(new Color(249, 249, 240));
			Cpassword.setBounds(210, 249, 179, 28);
			createAccountPanel.add(Cpassword);
		}
		{
			tfTelno = new JTextField();
			tfTelno.setForeground(Color.GRAY);
			tfTelno.setText("ex) 010XXXXYYYY");// 
			tfTelno.setColumns(10);
			tfTelno.setBorder(null);
			tfTelno.setBackground(new Color(249, 249, 240));
			tfTelno.setBounds(210, 302, 179, 28);
			createAccountPanel.add(tfTelno);
			tfTelno.addMouseListener(this);
		}
		{
			tfNcnm = new JTextField();
			tfNcnm.setColumns(10);
			tfNcnm.setBorder(null);
			tfNcnm.setBackground(new Color(249, 249, 240));
			tfNcnm.setBounds(210, 353, 179, 28);
			createAccountPanel.add(tfNcnm);
		}
	
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(249, 249, 240));
		buttonPane.setBounds(0, 390, 586, 197);
		createAccountPanel.add(buttonPane);
		buttonPane.setLayout(null);
		buttonPane.setBorder(null);
		{		
			btnCreate = new JButton();
			btnCreate.setBounds(137, 12, 140, 80);
			btnCreate.setBorder(null);
			btnCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
			buttonPane.add(btnCreate);
			btnCreate.setActionCommand("OK");
			getRootPane().setDefaultButton(btnCreate);//
			btnCreate.addActionListener(this);
			btnCreate.setIcon(makeIcon(btnCreate, "./image/btnCreate.jpg"));
		}
		{
			btnCancel = new JButton();
			btnCancel.setBounds(316, 12, 140, 80);
			btnCancel.setBorder(null);
			btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCancel.setActionCommand("Cancel");
			buttonPane.add(btnCancel);
			btnCancel.addActionListener(this);
			btnCancel.setIcon(makeIcon(btnCancel, "./image/btnCancel.jpg"));
		}
		
		lbCreateAccount = new JLabel();
		lbCreateAccount.setBounds(0, 0, 600, 600);
		createAccountPanel.add(lbCreateAccount);
		lbCreateAccount.setIcon(makeIcon(lbCreateAccount, "./image/CreateAccountPanel.jpg"));

		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//메인메소드에 있던 것 : 팝업화면에 닫기버튼 누르면 JDialog를 닫아라 라는 뜻(로그인 창만 닫아라)
		setVisible(true);									//메인메소드에 있던 것 : login에 대한 생성자를 화면에 보이게하라 는 뜻
	}
	
	private ImageIcon makeIcon(Component menu, String address) {
		Image im = Toolkit.getDefaultToolkit().getImage(address);
		im = im.getScaledInstance(menu.getWidth(), menu.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(im);
		return img;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnCreate)
		{
//			JOptionPane.showMessageDialog(null, "확인버튼 클릭");
//			try {
				createAccount();
//			} catch(BizException e) {
//				e.printStackTrace();
//			}
			
			
		}
		else if(e.getSource() == btnCancel)
		{
//			JOptionPane.showMessageDialog(null, "취소버튼 클릭");
			this.dispose();	//로그인창 화면만 닫는 것
		}
	}
	public void createAccount() //throws BizException
		{
			//*시퀀스 PK 자동생성
			//CREATE SEQUENCE MBER_NO_SEQ
			//START WITH 1
			//INCREMENT BY 1;
			
			// 년일월 날짜 구하는 쿼리.
		

			
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
			Calendar time = Calendar.getInstance();
			String format_time1 = format1.format(time.getTime());
//			System.out.println(format_time1);
			
			String sSearchEmail = "SELECT * FROM MBER WHERE EMAIL = ?";
			String sSearchNcnm = "SELECT * FROM MBER WHERE NCNM = ?";
			String sSearchTelno = "SELECT * FROM MBER WHERE TELNM = ?";
			
			String sInsert = "INSERT INTO MBER (MBER_NO, EMAIL, PASSWORD, TELNM, NCNM,SRBDE, MBER_AT) VALUES(MBER_NO_SEQ.NEXTVAL,?,?,?,?,?,?)";
			
			int ret;	//return 	
			
			
			String strEmail 	= tfID.getText();
			String strpassword 	= new String(password.getPassword());	//1번 패스워드
			String str2password	= new String(Cpassword.getPassword());	//확인용 패스워드/////////////////////////
			
			String strNcnm 		= tfNcnm.getText();
			String strTelno 	= tfTelno.getText();
			
			if(!strpassword.equals(str2password))//////////////////////////////////////////
			{
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.다시입력하세요!");
				return;
			}
			
			if (strEmail.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "이메일을 입력하세요");
				
				return;	// 리턴값이 없으면 메소드 탈출~!
			}
//			if(tfID.getText().replace(" ","") == strEmail) //공백 들어간거 잡아내는것
//			{
//				JOptionPane.showMessageDialog(null, "스페이스 들어갔는지 확인바람~");
//				return;
//			}
			
			if(strpassword.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "패스워드를 입력하세요");
				
				return;
			}
			if(strNcnm.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "닉네임을 입력하세요");
				
				return;
			}
			if(strTelno.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
				
				return;
			}
			
			

			try {
				Common.dbconnect();
				
				pstmt = Common.con.prepareStatement(sSearchEmail);
				pstmt.setString(1, strEmail);	// 바인딩
				
				rs = pstmt.executeQuery();	// rs에 뭐가있냐가 중요한게 아니라 있냐 없냐가 중요해서 밑의 next() 해야함
				
				if(rs.next() && rs.getString("EMAIL").equals(strEmail)) //정보가 있으면
				{	
					
					JOptionPane.showMessageDialog(null, "중복 되는 이메일이 있습니다.");
					return;
//					throw new BizException();
				}
				
				pstmt = Common.con.prepareStatement(sSearchNcnm);
				pstmt.setString(1, strNcnm);	// 바인딩
				
				rs = pstmt.executeQuery();	// rs에 뭐가있냐가 중요한게 아니라 있냐 없냐가 중요해서 밑의 next() 해야함
				
				if(rs.next() && rs.getString("Ncnm").equals(strNcnm)) //정보가 있으면
				{
					
					JOptionPane.showMessageDialog(null, "중복 되는 닉네임이 있습니다.");
					return;
//					throw new BizException();
				}
				
				pstmt = Common.con.prepareStatement(sSearchTelno);
				pstmt.setString(1, strTelno);	// 바인딩
				
				rs = pstmt.executeQuery();	// rs에 뭐가있냐가 중요한게 아니라 있냐 없냐가 중요해서 밑의 next() 해야함
				
				if(rs.next() && rs.getString("TELNM").equals(strTelno)) //정보가 있으면
				{
					
					JOptionPane.showMessageDialog(null, "중복 되는 전화번호가 있습니다.");
					return;
//					throw new BizException();
				}
				
				if(strEmail.getBytes().length > 30)
				{
					tfID.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "이메일은 영문 총 30글자 까지 입니다.");
					tfID.setForeground(Color.BLACK);
					return;
				}
				if(strpassword.getBytes().length > 20)
				{
					JOptionPane.showMessageDialog(null, "비밀번호는 영문 20글자 까지 입니다.");
					return;
				}
				if(strTelno.getBytes().length > 11)
				{
					tfTelno.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "전화번호는 11자리 까지 입니다.");
					tfTelno.setForeground(Color.BLACK);
					return;
				}
				
				if(strNcnm.getBytes().length > 15)
				{
					tfNcnm.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "닉네임은 한글은 최대 5글자 영문은 15글자 까지 입니다.");
					tfNcnm.setForeground(Color.BLACK);
					return;
				}

				pstmt2 = Common.con.prepareStatement(sInsert);
				pstmt2.setString (1, strEmail);
				pstmt2.setString	(2, strpassword);
				pstmt2.setString (3, strTelno);
				pstmt2.setString (4, strNcnm);
				pstmt2.setString (5, format_time1);
				pstmt2.setString	(6, "y" );

				ret = pstmt2.executeUpdate();
		
				//메시지 출력
				if( ret > 0)
				{
					JOptionPane.showMessageDialog(null, "정상등록 되었습니다.");
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "비정상 처리 되었습니다.");
					
				}
//			} catch(BizException e) {
			} catch (Exception e)	{//SQLException e
//				int code = 10;
//				throw new BizException(code);
			} finally {
				try { if ( rs     != null) rs.close();
					} catch (SQLException e1) {}
				try { if ( pstmt  != null) pstmt.close();
					} catch (SQLException e1) {}
				try { if ( pstmt2 != null) pstmt2.close();
					} catch (SQLException e1) {}
				try { if ( Common.con    != null) Common.con.close();
				} catch (SQLException e1) {}
				}
			}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tfTelno) {
			if (doCL == 0) {
			tfTelno.setText("");
			tfTelno.setForeground(Color.black);
			doCL++;
			}
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	}

