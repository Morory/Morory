package osooiso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FindAccount extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancel;
	private JLabel label;
	private JLabel lbDInsertTelno;
	private JLabel label_1;
	private JLabel lbPWInsertEmail;
	private JLabel lbPWInsertTelno;
	private JTextField tfIDInsertTelno;
	private JTextField tfPWInsertEmail;
	private JTextField tfPWInsertTelno;
	private JButton btnFind;
	private JButton btnApply;
	private JLabel lbIDPrintEmail;
	private JLabel lbPWPrintPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewFindAccount dialog = new NewFindAccount();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FindAccount() {
		
		super ((Frame) null, "", true);
		
		setBounds(650, 220, 604, 628);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		label = new JLabel("                                        <아이디 찾기>");
		label.setBounds(134, 10, 387, 37);
		contentPanel.add(label);
		
		lbDInsertTelno = new JLabel("전화번호 입력");
		lbDInsertTelno.setBounds(95, 127, 106, 15);
		contentPanel.add(lbDInsertTelno);
		
		label_1 = new JLabel("                                      <비밀번호 찾기>");
		label_1.setBounds(134, 192, 387, 37);
		contentPanel.add(label_1);
		
		lbPWInsertEmail = new JLabel("이메일 입력");
		lbPWInsertEmail.setBounds(95, 263, 106, 15);
		contentPanel.add(lbPWInsertEmail);
		
		lbPWInsertTelno = new JLabel("전화번호 입력");
		lbPWInsertTelno.setBounds(95, 329, 106, 15);
		contentPanel.add(lbPWInsertTelno);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 410, 588, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnCancel = new JButton("취소");
				btnCancel.setBounds(427, 0, 73, 33);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				btnCancel.addActionListener(this);
			}
		}
		
		tfIDInsertTelno = new JTextField();
		tfIDInsertTelno.setColumns(10);
		tfIDInsertTelno.setBorder(null);
		tfIDInsertTelno.setBackground(new Color(249, 249, 240));
		tfIDInsertTelno.setBounds(213, 121, 179, 28);
		contentPanel.add(tfIDInsertTelno);
		
		tfPWInsertEmail = new JTextField();
		tfPWInsertEmail.setColumns(10);
		tfPWInsertEmail.setBorder(null);
		tfPWInsertEmail.setBackground(new Color(249, 249, 240));
		tfPWInsertEmail.setBounds(213, 257, 179, 28);
		contentPanel.add(tfPWInsertEmail);
		
		tfPWInsertTelno = new JTextField();
		tfPWInsertTelno.setColumns(10);
		tfPWInsertTelno.setBorder(null);
		tfPWInsertTelno.setBackground(new Color(249, 249, 240));
		tfPWInsertTelno.setBounds(213, 323, 179, 28);
		contentPanel.add(tfPWInsertTelno);
		
		btnFind = new JButton("찾기 ");
		btnFind.setBounds(404, 123, 97, 23);
		contentPanel.add(btnFind);
		btnFind.addActionListener(this);
		
		btnApply = new JButton("재설정");
		btnApply.setBounds(404, 325, 97, 23);
		contentPanel.add(btnApply);
		btnApply.addActionListener(this);
		
		lbIDPrintEmail = new JLabel("");
		lbIDPrintEmail.setBounds(213, 159, 225, 15);
		contentPanel.add(lbIDPrintEmail);
		
		lbPWPrintPassword = new JLabel("");
		lbPWPrintPassword.setBounds(213, 364, 225, 15);
		contentPanel.add(lbPWPrintPassword);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//메인메소드에 있던 것 : 팝업화면에 닫기버튼 누르면 JDialog를 닫아라 라는 뜻(로그인 창만 닫아라)
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFind)
		{
			findID();
		}
		else if(e.getSource() == btnApply)
		{
			findPW();
		}
		else if(e.getSource() == btnCancel)
		{
			this.dispose();
		}
		
	}
	
public void findID() {
	
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String findsql = "SELECT * FROM MBER WHERE TELNM = ? AND MBER_AT = 'y'";
		String strTelno 	= tfIDInsertTelno.getText();
		
		if(strTelno.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			
			return;
		}
		
		try {
			Common.dbconnect();
			
			
			pstmt = Common.con.prepareStatement(findsql);
			pstmt.setString(1, strTelno);
			rs = pstmt.executeQuery();
			
			if(rs.next() && rs.getString("TELNM").equals(strTelno)) //정보가 있으면
			{
				lbIDPrintEmail.setForeground(Color.RED);	
				lbIDPrintEmail.setText(rs.getString("EMAIL") + "    입니다.");
				return;
//				throw new BizException();
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.");
				return;
//				throw new BizException();
			}
		}catch (Exception e) {}finally {
			try { if ( rs     != null) rs.close();
			} catch (SQLException e1) {}
		try { if ( pstmt  != null) pstmt.close();
			} catch (SQLException e1) {}
		try { if ( Common.con    != null) Common.con.close();
		} catch (SQLException e1) {}
		}
	}
	
	public void findPW() {
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String findsql = "SELECT * FROM MBER WHERE TELNM = ? AND EMAIL = ? AND MBER_AT = 'y'";
		String strTelnoPw 	= tfPWInsertTelno.getText();
		String strEmail 	= tfPWInsertEmail.getText();
		
		if(strEmail.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "비밀번호를 찾기 위한 이메일을 입력하세요");
			
			return;
		}
		
		if(strTelnoPw.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "비밀번호를 찾기 위한 전화번호를 입력하세요");
			return;
		}
		
		
		try {
			Common.dbconnect();
			
			
			pstmt = Common.con.prepareStatement(findsql);
			pstmt.setString(1, strTelnoPw);
			pstmt.setString(2, strEmail);
			
			rs = pstmt.executeQuery();
			
//			if(!Common.rs.next())
//			{
//				JOptionPane.showMessageDialog(null, "오류 발생");
//				return;
//			}
			
			if( rs.next() && rs.getString("TELNM").equals(strTelnoPw) && rs.getString("EMAIL").equals(strEmail) ) //정보가 있으면
			{
				
				LoginDTO loginDto = new LoginDTO();
				loginDto.setMberNo(rs.getObject("MBER_NO").toString());
				
				HashMap<String, Object> hm = Common.getHm();
				
				hm.put("loginDTO", loginDto);
				
				new ChangePassword();
				this.dispose();
//				return;
//				throw new BizException();
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, "일치하는 아이디가 없거나 잘못입력하셨습니다.");
				return;
//				throw new BizException();
			}
		}catch (Exception e) {}finally {
			try { if ( rs     != null) rs.close();
			} catch (SQLException e1) {}
		try { if ( pstmt  != null) pstmt.close();
			} catch (SQLException e1) {}
		try { if ( Common.con    != null) Common.con.close();
		} catch (SQLException e1) {}
		}
		
	}
}
