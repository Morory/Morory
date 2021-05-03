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
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class ChangePassword extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField NewPassword;
	private JPasswordField NewPasswordConfig;
	private JButton btnUpdate;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ChangePassword dialog = new ChangePassword();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ChangePassword() {
		
		super ((Frame) null, "", true);
		setTitle("비밀번호 재설정");
		
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbNewPass = new JLabel("새로운 비밀번호");
			lbNewPass.setBounds(73, 67, 106, 15);
			contentPanel.add(lbNewPass);
		}
		{
			JLabel lbNewPassConfig = new JLabel("새로운 비밀번호 확인");
			lbNewPassConfig.setBounds(73, 126, 116, 15);
			contentPanel.add(lbNewPassConfig);
		}
		
		NewPassword = new JPasswordField();
		NewPassword.setBounds(213, 61, 179, 28);
		NewPassword.setBorder(null);
		NewPassword.setBackground(new Color(249, 249, 240));
		contentPanel.add(NewPassword);
		
		NewPasswordConfig = new JPasswordField();
		NewPasswordConfig.setBounds(213, 120, 179, 28);
		NewPasswordConfig.setBorder(null);
		NewPasswordConfig.setBackground(new Color(249, 249, 240));
		contentPanel.add(NewPasswordConfig);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 195, 434, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnUpdate = new JButton("수정");
				btnUpdate.setBounds(153, 5, 69, 23);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
				btnUpdate.addActionListener(this);
			}
			{
				btnCancel = new JButton("취소");
				btnCancel.setBounds(234, 5, 69, 23);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				btnCancel.addActionListener(this);
				
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//메인메소드에 있던 것 : 팝업화면에 닫기버튼 누르면 JDialog를 닫아라 라는 뜻(로그인 창만 닫아라)
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpdate)
		{
			changePW();
		}
		if(e.getSource() == btnCancel)
		{
			this.dispose();
		}
		
	}
	
	public void changePW() {
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		LoginDTO loginDto = new LoginDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		loginDto = (LoginDTO)hm.get("loginDTO");
		
		String sUpdate = "UPDATE MBER SET PASSWORD = ? WHERE MBER_NO = ? AND MBER_AT = 'y'";
		
		int ret;
		
		String strpassword 	= new String(NewPassword.getPassword());	//1번 패스워드
		String str2password	= new String(NewPasswordConfig.getPassword());	//확인용 패스워드
		
		if(strpassword.isEmpty() || str2password.isEmpty() )
		{
			JOptionPane.showMessageDialog(null, "빈 칸이 있습니다. 다시 입력하세요");
			return;
		}
		
		if(!strpassword.equals(str2password))
		{
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			return;
		}
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sUpdate);
			pstmt.setString(1, strpassword);
			pstmt.setString(2, loginDto.getMberNo());// 바인딩
			
			ret = pstmt.executeUpdate();	// rs에 뭐가있냐가 중요한게 아니라 있냐 없냐가 중요해서 밑의 next() 해야함
			
			if(ret > 0)
			{
				JOptionPane.showMessageDialog(null, "정상 처리 되었습니다.");
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "오류가 발생했습니다.");
			}
			
		} catch (Exception e)	{e.printStackTrace();
		} finally {
			try { if ( rs     != null) rs.close();
				} catch (SQLException e1) {}
			try { if ( pstmt  != null) pstmt.close();
				} catch (SQLException e1) {}
			try { if ( Common.con    != null) Common.con.close();
			} catch (SQLException e1) {}
			}
	}
}
