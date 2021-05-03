package osooiso;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class SetPhoto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			SetPhoto dialog = new SetPhoto();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public SetPhoto() {
		
		super ((Frame) null, "", true);
		
		HashMap<String, Object> hm = Common.getHm();
		PostDTO postDto  = new PostDTO();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JFileChooser fc = new JFileChooser("C:\\Users\\KCE00\\Desktop");
		fc.setDialogTitle("이미지 선택");
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		int result = fc.showOpenDialog(null);
//		fc.setFileFilter(filter);
		
		// Make sure that a file was chosen, else exit
		if (result != JFileChooser.APPROVE_OPTION) {
			postDto.setPhotoAddress("");
		    hm.put("PostDTO", postDto);
		    this.dispose();
		    return;
		}
		// Get file path
		String path = fc.getSelectedFile().getAbsolutePath();

		// Create folder "images" (variable success will be true if a folder was created and false if it did not)
		File folder = new File("image");
		@SuppressWarnings("unused")
		boolean success = folder.mkdir();
		// Get the destination of the folder and the new image (image.jpg will be the new name)
		String destination = folder.getAbsolutePath() + File.separator + "postIMG" + Math.random()*10000000 + ".jpg";
		try {
		    // Copy file from source to destination
		    @SuppressWarnings("resource")
			FileChannel source = new FileInputStream(path).getChannel();
		    @SuppressWarnings("resource")
			FileChannel dest = new FileOutputStream(destination).getChannel();
		    dest.transferFrom(source, 0, source.size());
//		    System.out.println(destination);
		    
		    postDto.setPhotoAddress(destination);
		    hm.put("PostDTO", postDto);
		    
		    // Close shit
		    source.close();
		    dest.close();
//		    System.out.println("Done");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		

	}
	
	

}
