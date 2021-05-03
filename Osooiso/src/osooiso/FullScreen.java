package osooiso;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class FullScreen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lbFullScreen;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FullScreen dialog = new FullScreen();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FullScreen(String postAddress) {
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setTitle("사진");
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1584, 861);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbFullScreen = new JLabel();
		lbFullScreen.setBounds(0, 0, 1584, 861);
		panel.add(lbFullScreen);
		lbFullScreen.setIcon(makeIcon(lbFullScreen, postAddress));
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private ImageIcon makeIcon(Component menu, String address) {
		Image im = Toolkit.getDefaultToolkit().getImage(address);
		im = im.getScaledInstance(menu.getWidth(), menu.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(im);
		return img;
	}
}
