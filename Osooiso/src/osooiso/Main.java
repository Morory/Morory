package osooiso;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Main implements ActionListener, KeyListener, ItemListener, MouseListener {

	private LoginDTO loginDto;
	private PostDTO  postDto;
	private LikesDTO likesDto;
	private CommentDTO commentDto;
	private Likes lk = new Likes();

	// Frame
	private JFrame frame;

	// Main Panel
	private JPanel menuPanel;
	private JLabel lbMenu;
	private JButton btnHome;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnLoginMenu;
	private JButton btnProfileMenu;

	// Login Panel
	private JPanel loginPanel;
	private JTextField tfID;
	private JPasswordField password;
	private JButton btnSignIn;
	private JButton btnFindAccount;
	private JButton btnCreateAccount;
	private JButton btnGoToMain;

	// Post Panel
	private JPanel postPanel;
	private JLabel lbLoginPanel;
	private JButton btnWriteMenu;

	private JButton btnP1;
	private JButton btnP2;
	private JButton btnP3;
	private JButton btnP4;
	private JButton btnP5;
	private JButton btnP6;
	private JButton btnP7;
	private JButton btnP8;
	private JButton btnP9;
	private JButton btnNext;
	private JButton btnPrevious;
	private ArrayList<JButton> btnPn = new ArrayList<JButton>();

	private String pkAddP1 = "n";
	private String pkAddP2 = "n";
	private String pkAddP3 = "n";
	private String pkAddP4 = "n";
	private String pkAddP5 = "n";
	private String pkAddP6 = "n";
	private String pkAddP7 = "n";
	private String pkAddP8 = "n";
	private String pkAddP9 = "n";
	private String[] pk = new String[] {pkAddP1, pkAddP2, pkAddP3, pkAddP4, pkAddP5, pkAddP6, pkAddP7, pkAddP8, pkAddP9} ;


	private JLabel lbPageNo;

	// Profile Panel
	private JPanel profilePanel;
	private JLabel lbEmail;
	private JTextField tfEmail;
	private JLabel lbPassword;
	private JPasswordField Ppassword;
	private JLabel lbCpassword;
	private JPasswordField Cpassword;
	private JLabel lbTel;
	private JTextField tfTel;
	private JLabel lbNickname;
	private JTextField tfNickname;
	private JButton btnUpdate;
	private JButton btnSecession;
	private JButton btnLogout;

	// Write Panel
	private JPanel writePanel;
	private JTextField tfTitle;
	private JTextArea taContents;
	private JButton btnWrite;
	private ButtonGroup  rdDiv;
	private JRadioButton rdFood;
	private JRadioButton rdTour;
	private JLabel lbContents;
	private JLabel lbTitle;
	private JButton btnSetPhoto;
	private JLabel lbPAddress;
	private JTextField tfHashcode;
	private JLabel lbHashcode;


	private int searchSwitch = 0;
	private String searchQuery;


	//	private String[][] dataValues=new String[3][3];

	private int page = 1;
	private final int PAGELIST = 9;
	private int rnum = ((page-1) * PAGELIST) + 1;
	private PreparedStatement pstmt;
	private ResultSet key;

	// ShowPostPanel

	private JPanel showPostPanel;
	private JTextField tfPostTitle;
	private JLabel lbPostPhoto;
	private JLabel lbPostDate;
	private JTextArea tAPostContents;
	private JButton btnPostLike;
	private JButton btnPostUnlike;
	private JButton btnPostComment;
	private JLabel lbPostLike;
	private JLabel lbPostComment;
	private JPanel switchPanel;
	private JButton btnTour;
	private JButton btnFood;
	private JLabel lbShowHash;
	private JScrollPane scrollPane;
	private JTable tabComment;

	private String[] saTit = new String[] {"??????", "??????", "??????"};
	private int[] iaCwidth = new
			int[] {10, 74, 16};
	private int[] iaAlm = new
			int[] {JLabel.RIGHT, JLabel.LEFT, JLabel.RIGHT};
	private DefaultTableModel dtModel;
	private JLabel lbCommentTaget;
	private JTextArea tAComment;
	private JButton btnComment;

	private int row = 1;
	private int dbRow = 1;
	private String postPK = "n";
	private String postAddress;
	private int dono = 0 ;
	private JButton btnDeleteComment;
	private JButton btnPostModify;
	private JButton btnPostDelete;

	private String postWriterNo;
	private JLabel lbPostWriter;
	private JButton btnUpdateComment;
	private JButton btnFullScreen;

	private int doCL = 0;
	private JLabel lbLikesSort;
	private JButton btnLikesSort;
	private JLabel lbLatestSort;
	private JButton btnLatestSort;


	private final int SORTLIKES = 1;
	private final int SORTLATEST = 0;

	private int sortCondition = SORTLATEST;
	private JLabel lbSearchKeyword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		loginDto = new LoginDTO();
		postDto  = new PostDTO();
		likesDto = new LikesDTO();
		commentDto = new CommentDTO();

		frame = new JFrame();
		frame.setBounds(100, 100, 1296, 759);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("???????????????");

		// Main Panel

		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 1280, 120);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		btnHome = new JButton("");
		btnHome.setBounds(99, 32, 245, 70);
		menuPanel.add(btnHome);
		btnHome.setBorder(null);
		btnHome.addActionListener(this);
		btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHome.setIcon(makeIcon(btnHome, "./image/btnHome.jpg"));

		btnSearch = new JButton("");
		btnSearch.setBounds(746, 56, 44, 38);
		menuPanel.add(btnSearch);
		btnSearch.setBorder(null);
		btnSearch.addActionListener(this);
		btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(makeIcon(btnSearch, "./image/btnSearch.jpg"));

		btnLoginMenu = new JButton("");
		btnLoginMenu.setBounds(1130, 55, 55, 54);
		menuPanel.add(btnLoginMenu);
		btnLoginMenu.setBorder(null);
		btnLoginMenu.addActionListener(this);
		btnLoginMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLoginMenu.setIcon(makeIcon(btnLoginMenu, "./image/btnLogin.jpg"));

		btnProfileMenu = new JButton("");
		btnProfileMenu.setBounds(1130, 55, 55, 54);
		btnProfileMenu.setBackground(new Color(249,249,240));
		menuPanel.add(btnProfileMenu);
		btnProfileMenu.setBorder(null);
		btnProfileMenu.setVisible(false);
		btnProfileMenu.setIcon(makeIcon(btnProfileMenu, "./image/btnProfile.png"));
		btnProfileMenu.addActionListener(this);
		btnProfileMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));

		tfSearch = new JTextField();
		tfSearch.setForeground(new Color(0, 0, 0));
		tfSearch.setFont(new Font("??????", Font.PLAIN, 14));
		tfSearch.setBackground(new Color(249, 249, 240));
		tfSearch.setBounds(530, 59, 210, 30);
		menuPanel.add(tfSearch);
		tfSearch.setColumns(20);
		tfSearch.setBorder(null);
		tfSearch.addKeyListener(this);

		lbMenu = new JLabel("");
		lbMenu.setBounds(0, 0, 1280, 120);
		menuPanel.add(lbMenu);
		lbMenu.setIcon(makeIcon(lbMenu, "./image/homeMenu.jpg"));

		// Login Panel

		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 1280, 720);
		loginPanel.setBackground(new Color(249, 249, 240));
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);

		tfID = new JTextField();
		tfID.setForeground(new Color(28, 84, 57));
		tfID.setFont(new Font("Arial", Font.PLAIN, 13));
		tfID.setColumns(10);
		tfID.setBounds(610, 229, 155, 33);
		tfID.setBackground(new Color(249, 249, 240));
		tfID.setBorder(null);
		loginPanel.add(tfID);

		password = new JPasswordField();
		password.setForeground(new Color(0, 51, 0));
		password.setFont(new Font("Arial", Font.PLAIN, 13));
		password.setBounds(610, 303, 155, 33);
		password.setBackground(new Color(249, 249, 240));
		password.setBorder(null);
		loginPanel.add(password);
		password.addKeyListener(this);

		btnSignIn = new JButton();
		btnSignIn.setBounds(506, 368, 267, 50);
		btnSignIn.setBorder(null);
		btnSignIn.setIcon(makeIcon(btnSignIn, "./image/btnSignIn.jpg"));
		btnSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginPanel.add(btnSignIn);
		btnSignIn.addActionListener(this);

		btnCreateAccount = new JButton();
		btnCreateAccount.setBounds(506, 443, 267, 50);
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setIcon(makeIcon(btnCreateAccount, "./image/btnCreateAccount.jpg"));
		btnCreateAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginPanel.add(btnCreateAccount);
		btnCreateAccount.addActionListener(this);

		btnFindAccount = new JButton();
		btnFindAccount.setBounds(553, 500, 150, 70);
		btnFindAccount.setBorder(null);
		btnFindAccount.setIcon(makeIcon(btnFindAccount, "./image/btnFindAccount.jpg"));
		btnFindAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginPanel.add(btnFindAccount);
		btnFindAccount.addActionListener(this);

		btnGoToMain = new JButton("");
		btnGoToMain.setBounds(510, 117, 245, 70);
		loginPanel.add(btnGoToMain);
		btnGoToMain.setBorder(null);
		btnGoToMain.setIcon(makeIcon(btnGoToMain, "./image/btnhome.jpg"));
		btnGoToMain.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGoToMain.addActionListener(this);

		lbLoginPanel = new JLabel("");
		lbLoginPanel.setBounds(0, 0, 1280, 720);
		loginPanel.add(lbLoginPanel);
		lbLoginPanel.setIcon(makeIcon(lbLoginPanel, "./image/loginPanel.jpg"));

		//switch panel

		switchPanel = new JPanel();
		switchPanel.setBackground(new Color(249, 249, 240));
		switchPanel.setBounds(0, 120, 1280, 90);
		frame.getContentPane().add(switchPanel);
		switchPanel.setLayout(null);

		btnTour = new JButton("");
		btnTour.setBounds(450, 0, 200, 90);
		switchPanel.add(btnTour);
		btnTour.setBorder(null);
		btnTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTour.setIcon(makeIcon(btnTour, "./image/btnTourOrange.jpg"));
		btnTour.addActionListener(this);

		btnFood = new JButton("");
		btnFood.setBounds(650, 0, 200, 90);
		switchPanel.add(btnFood);
		btnFood.setBorder(null);
		btnFood.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFood.setIcon(makeIcon(btnFood, "./image/btnFood.jpg"));
		btnFood.addActionListener(this);

		// Post Panel

		postPanel = new JPanel();
		postPanel.setBackground(new Color(249, 249, 240));
		postPanel.setBounds(0, 210, 1280, 510);
		frame.getContentPane().add(postPanel);
		postPanel.setLayout(null);

		lbSearchKeyword = new JLabel("");
		lbSearchKeyword.setForeground(new Color(0, 51, 51));
		lbSearchKeyword.setFont(new Font("??????", Font.ITALIC, 15));
		lbSearchKeyword.setBounds(470, 5, 57, 15);
		postPanel.add(lbSearchKeyword);

		btnWriteMenu = new JButton("");
		btnWriteMenu.setBounds(1030, 360, 168, 117);
		postPanel.add(btnWriteMenu);
		btnWriteMenu.setBorder(null);
		btnWriteMenu.addActionListener(this);
		btnWriteMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnWriteMenu.setIcon(makeIcon(btnWriteMenu, "./image/btnWrite.jpg"));
		btnWriteMenu.setVisible(false);

		btnP1 = new JButton();
		btnP1.setBounds(455, 30, 110, 110);

		btnP2 = new JButton();
		btnP2.setBounds(595, 30, 110, 110);

		btnP3 = new JButton();
		btnP3.setBounds(735, 30, 110, 110);

		btnP4 = new JButton();
		btnP4.setBounds(455, 170, 110, 110);

		btnP5 = new JButton();
		btnP5.setBounds(595, 170, 110, 110);

		btnP6 = new JButton();
		btnP6.setBounds(735, 170, 110, 110);

		btnP7 = new JButton();
		btnP7.setBounds(455, 310, 110, 110);

		btnP8 = new JButton();
		btnP8.setBounds(595, 310, 110, 110);

		btnP9 = new JButton();
		btnP9.setBounds(735, 310, 110, 110);

		btnPn.add(btnP1);
		btnPn.add(btnP2);
		btnPn.add(btnP3);
		btnPn.add(btnP4);
		btnPn.add(btnP5);
		btnPn.add(btnP6);
		btnPn.add(btnP7);
		btnPn.add(btnP8);
		btnPn.add(btnP9);

		for(int i = 0; i < 9; i++)
		{
			btnPn.get(i).setBackground(new Color(249,249,240));
			postPanel.add(btnPn.get(i)); 
			btnPn.get(i).setBorder(null);
			btnPn.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnPn.get(i).addActionListener(this);
		}

		btnNext = new JButton("");
		btnNext.setBounds(870, 200, 40, 55);
		postPanel.add(btnNext);
		btnNext.addActionListener(this);
		btnNext.setBackground(new Color(249,249,240));
		btnNext.setBorder(null);
		btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNext.setIcon(makeIcon(btnNext, "./image/btnNext.png"));
		btnNext.setVisible(false);

		btnPrevious = new JButton("");
		btnPrevious.setBounds(380, 200, 40, 55);
		postPanel.add(btnPrevious);
		btnPrevious.setBackground(new Color(249,249,240));
		btnPrevious.setBorder(null);
		btnPrevious.addActionListener(this);
		btnPrevious.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPrevious.setIcon(makeIcon(btnPrevious, "./image/btnPrevious.png"));
		btnPrevious.setVisible(false);

		lbPageNo = new JLabel("");
		lbPageNo.setFont(new Font("Arial", Font.PLAIN, 13));
		lbPageNo.setBounds(630, 450, 57, 15);
		postPanel.add(lbPageNo);
		lbPageNo.setText("page " + page);

		lbLikesSort = new JLabel();
		lbLikesSort.setBounds(790, 3, 20, 20);
		lbLikesSort.setIcon(makeIcon(lbLikesSort, "./image/lbSort.png"));
		postPanel.add(lbLikesSort);

		btnLikesSort = new JButton();
		btnLikesSort.setBounds(815, 1, 25, 25);
		btnLikesSort.setBackground(new Color(249, 249, 240));
		btnLikesSort.setBorder(null);
		postPanel.add(btnLikesSort);
		btnLikesSort.setIcon(makeIcon(btnLikesSort, "./image/btnSort.png"));
		btnLikesSort.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLikesSort.addActionListener(this);

		lbLatestSort = new JLabel();
		lbLatestSort.setBounds(733, 0, 27, 27);
		lbLatestSort.setIcon(makeIcon(lbLatestSort, "./image/lbLatestSort.png"));
		postPanel.add(lbLatestSort);

		btnLatestSort = new JButton();
		btnLatestSort.setBounds(760, 1, 25, 25);
		postPanel.add(btnLatestSort);
		btnLatestSort.setBorder(null);
		btnLatestSort.setIcon(makeIcon(btnLatestSort, "./image/btnSort.png"));
		btnLatestSort.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLatestSort.addActionListener(this);


		// showPostPanel

		showPostPanel = new JPanel();
		showPostPanel.setBackground(new Color(249, 249, 240));
		showPostPanel.setLayout(null);
		showPostPanel.setBounds(0, 120, 1280, 600);
		frame.getContentPane().add(showPostPanel);
		showPostPanel.setVisible(false);

		tfPostTitle = new JTextField("");
		tfPostTitle.setBackground(new Color(249, 249, 240));
		tfPostTitle.setFont(new Font("??????", Font.BOLD, 34));
		tfPostTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tfPostTitle.setBounds(460, 0, 360, 40);
		tfPostTitle.setBorder(null);
		tfPostTitle.setEditable(false);
		showPostPanel.add(tfPostTitle);

		lbPostPhoto = new JLabel("");
		lbPostPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lbPostPhoto.setBounds(460, 65, 360, 225);
		showPostPanel.add(lbPostPhoto);

		btnFullScreen = new JButton("");
		btnFullScreen.setBounds(825, 250, 40, 40);
		btnFullScreen.setBorder(null);
		btnFullScreen.setBackground(new Color(249,249,240));
		btnFullScreen.setIcon(makeIcon(btnFullScreen, "./image/btnFullScreen.png"));
		showPostPanel.add(btnFullScreen);
		btnFullScreen.addActionListener(this);

		lbPostDate = new JLabel("yyyymmdd - hh-mi-ss");
		lbPostDate.setVerticalAlignment(SwingConstants.TOP);
		lbPostDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPostDate.setBounds(670, 40, 150, 15);
		showPostPanel.add(lbPostDate);

		tAPostContents = new JTextArea();
		tAPostContents.setFont(new Font("?????? ?????? Semilight", Font.PLAIN, 17));
		tAPostContents.setTabSize(11);
		tAPostContents.setEditable(false);
		tAPostContents.setBounds(460, 300, 360, 150);
		tAPostContents.setLineWrap(true);
		showPostPanel.add(tAPostContents);

		lbPostWriter = new JLabel("?????????");
		lbPostWriter.setForeground(new Color(36, 107, 73));
		lbPostWriter.setFont(new Font("??????", Font.PLAIN, 14));
		lbPostWriter.setBounds(680, 500, 130, 15);
		showPostPanel.add(lbPostWriter);

		btnPostLike = new JButton();
		btnPostLike.setBounds(460, 480, 50, 50);
		btnPostLike.setBackground(new Color(249,249,240));
		btnPostLike.setBorder(null);
		btnPostLike.setIcon(makeIcon(btnPostLike, "./image/btnPostLike.png"));
		btnPostLike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showPostPanel.add(btnPostLike);
		btnPostLike.addActionListener(this);

		btnPostUnlike = new JButton();
		btnPostUnlike.setBounds(460, 480, 50, 50);
		btnPostUnlike.setBackground(new Color(249,249,240));
		btnPostUnlike.setBorder(null);
		btnPostUnlike.setIcon(makeIcon(btnPostLike, "./image/btnPostLiked.png"));
		btnPostUnlike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showPostPanel.add(btnPostUnlike);
		btnPostUnlike.addActionListener(this);
		btnPostUnlike.setVisible(false);

		btnPostComment = new JButton();
		btnPostComment.setBackground(new Color(249,249,240));
		btnPostComment.setBounds(530, 485, 42, 42);
		btnPostComment.setBorder(null);
		btnPostComment.setIcon(makeIcon(btnPostComment, "./image/btnPostAnser.png"));
		showPostPanel.add(btnPostComment);
		btnPostComment.addActionListener(this);

		lbPostLike = new JLabel("");
		lbPostLike.setHorizontalAlignment(SwingConstants.CENTER);
		lbPostLike.setBounds(455, 535, 57, 15);
		showPostPanel.add(lbPostLike);

		lbPostComment = new JLabel("");
		lbPostComment.setBounds(520, 535, 57, 15);
		lbPostComment.setHorizontalAlignment(SwingConstants.CENTER);
		showPostPanel.add(lbPostComment);

		lbShowHash = new JLabel();
		lbShowHash.setForeground(Color.BLUE);
		lbShowHash.setFont(new Font("?????? ??????", Font.PLAIN, 12));
		lbShowHash.setBounds(460, 450, 360, 30);
		showPostPanel.add(lbShowHash);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(900, 50, 270, 400);
		showPostPanel.add(scrollPane);

		tabComment = new JTable();
		tabComment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dtModel = new DefaultTableModel(saTit, 0);

		tabComment.setAutoCreateColumnsFromModel(false);
		tabComment.setModel(dtModel);
		tabComment.setShowGrid(false);
		tabComment.addMouseListener(this);

		LineBorder l = new LineBorder(new Color(36, 107, 73), 2, true);

		btnPostModify = new JButton("??????");
		btnPostModify.setBounds(690, 560, 60, 23);
		showPostPanel.add(btnPostModify);
		btnPostModify.setVisible(false);
		btnPostModify.setForeground(new Color(36, 107, 73));
		btnPostModify.setBackground(new Color(249, 249, 240));
		btnPostModify.setBorder(l);
		btnPostModify.addActionListener(this);

		btnPostDelete = new JButton("??????");
		btnPostDelete.setBounds(760, 560, 60, 23);
		showPostPanel.add(btnPostDelete);
		btnPostDelete.setVisible(false);
		btnPostDelete.setForeground(new Color(36, 107, 73));
		btnPostDelete.setBackground(new Color(249, 249, 240));
		btnPostDelete.setBorder(l);
		btnPostDelete.addActionListener(this);


		for (int i = 0 ; i < iaAlm.length ; ++i)
		{
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(iaAlm[i]);
			TableColumn column = new TableColumn(i, iaCwidth[i], renderer, null);
			tabComment.addColumn(column);
		}
		tabComment.setFocusable(false);
		scrollPane.setViewportView(tabComment);
		tabComment.addMouseListener(this);

		lbCommentTaget = new JLabel("");
		lbCommentTaget.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCommentTaget.setBounds(900, 480, 70, 25);
		showPostPanel.add(lbCommentTaget);

		tAComment = new JTextArea();
		tAComment.setBounds(970, 480, 200, 25);
		showPostPanel.add(tAComment);
		tAComment.setLineWrap(true);
		//????????? ??????
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 1);
		Border emptyBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		tAComment.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		btnComment = new JButton("?????? ??????");
		btnComment.setForeground(new Color(36, 107, 73));
		btnComment.setBackground(new Color(249, 249, 240));
		btnComment.setBounds(1080, 522, 90, 35);
		showPostPanel.add(btnComment);
		btnComment.addActionListener(this);
		btnComment.setBorder(l);

		btnDeleteComment = new JButton("?????? ??????");
		btnDeleteComment.setForeground(new Color(36, 107, 73));
		btnDeleteComment.setBackground(new Color(249, 249, 240));
		btnDeleteComment.setBounds(880, 522, 90, 35);
		btnDeleteComment.setVisible(false);
		btnDeleteComment.setBorder(l);
		showPostPanel.add(btnDeleteComment);
		btnDeleteComment.addActionListener(this);

		btnUpdateComment = new JButton("?????? ??????");
		btnUpdateComment.setForeground(new Color(36, 107, 73));
		btnUpdateComment.setBackground(new Color(249, 249, 240));
		btnUpdateComment.setBounds(980, 522, 90, 35);
		btnUpdateComment.setVisible(false);
		btnUpdateComment.setBorder(l);
		showPostPanel.add(btnUpdateComment);
		btnUpdateComment.addActionListener(this);



		//Write Panel

		writePanel = new JPanel();
		writePanel.setBackground(new Color(249, 249, 240));
		writePanel.setBounds(0, 114, 1280, 606);
		frame.getContentPane().add(writePanel);
		writePanel.setLayout(null);
		writePanel.setVisible(false);

		lbTitle = new JLabel("??????");
		lbTitle.setBounds(620, 50, 57, 15);
		writePanel.add(lbTitle);

		tfTitle = new JTextField();
		tfTitle.setBounds(580, 70, 116, 21);
		writePanel.add(tfTitle);
		tfTitle.setColumns(10);

		lbContents = new JLabel("??????");
		lbContents.setBounds(620, 110, 57, 15);
		writePanel.add(lbContents);

		taContents = new JTextArea();
		taContents.setBackground(Color.LIGHT_GRAY);
		taContents.setBounds(450, 130, 400, 300);
		taContents.setLineWrap(true);
		writePanel.add(taContents);
		taContents.setColumns(10);

		btnWrite = new JButton("??????");
		btnWrite.setBounds(530, 500, 200, 60);
		writePanel.add(btnWrite);
		btnWrite.addActionListener(this);

		rdTour = new JRadioButton("?????????");
		rdTour.setSelected(true);
		rdTour.setBounds(710, 50, 121, 23);
		writePanel.add(rdTour);
		rdTour.addItemListener(this);

		rdFood = new JRadioButton("??????");
		rdFood.setBounds(710, 80, 121, 23);
		writePanel.add(rdFood);
		rdFood.addItemListener(this);

		rdDiv = new ButtonGroup();
		rdDiv.add(rdTour);
		rdDiv.add(rdFood);

		lbHashcode = new JLabel("????????????");
		lbHashcode.setBounds(400, 440, 57, 15);
		writePanel.add(lbHashcode);

		tfHashcode = new JTextField();
		tfHashcode.setForeground(new Color(0, 0, 255));
		tfHashcode.setText("ex) #???????????????#?????????");
		tfHashcode.setBounds(400, 460, 150, 21);
		writePanel.add(tfHashcode);
		tfHashcode.setColumns(10);
		tfHashcode.addMouseListener(this);

		btnSetPhoto = new JButton("?????? ??????");
		btnSetPhoto.setBounds(570, 450, 120, 30);
		writePanel.add(btnSetPhoto);

		lbPAddress = new JLabel("");
		lbPAddress.setBounds(700, 460, 400, 15);
		writePanel.add(lbPAddress);
		btnSetPhoto.addActionListener(this);

		//Profile Panel

		profilePanel = new JPanel();
		profilePanel.setBounds(0, 114, 1280, 606);
		profilePanel.setBackground(new Color(249, 249, 240));
		frame.getContentPane().add(profilePanel);
		profilePanel.setLayout(null);
		profilePanel.setVisible(false);

		lbEmail = new JLabel("?????????");
		lbEmail.setBounds(540, 93, 45, 18);
		lbEmail.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(lbEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(624, 92, 116, 21);
		tfEmail.setColumns(10);
		profilePanel.add(tfEmail);
		tfEmail.setEnabled(false);

		lbPassword = new JLabel("????????????");
		lbPassword.setBounds(540, 126, 60, 18);
		lbPassword.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(lbPassword);

		Ppassword = new JPasswordField();
		Ppassword.setBounds(624, 123, 116, 21);
		profilePanel.add(Ppassword);

		lbCpassword = new JLabel("???????????? ??????");
		lbCpassword.setFont(new Font("??????", Font.BOLD, 15));
		lbCpassword.setBounds(501, 157, 99, 18);
		profilePanel.add(lbCpassword);

		Cpassword = new JPasswordField();
		Cpassword.setBounds(624, 154, 116, 21);
		profilePanel.add(Cpassword);

		lbTel = new JLabel("????????????");
		lbTel.setBounds(540, 189, 60, 18);
		lbTel.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(lbTel);

		tfTel = new JTextField();
		tfTel.setBounds(624, 188, 116, 21);
		tfTel.setColumns(10);
		profilePanel.add(tfTel);

		lbNickname = new JLabel("?????????");
		lbNickname.setBounds(540, 220, 45, 18);
		lbNickname.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(lbNickname);

		tfNickname = new JTextField();
		tfNickname.setBounds(624, 219, 116, 21);
		tfNickname.setColumns(10);
		profilePanel.add(tfNickname);

		btnUpdate = new JButton("??????");
		btnUpdate.setBounds(522, 274, 78, 27);
		btnUpdate.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(btnUpdate);
		btnUpdate.addActionListener(this);

		btnSecession = new JButton("????????????");
		btnSecession.setBounds(624, 274, 120, 27);
		btnSecession.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(btnSecession);
		btnSecession.addActionListener(this);

		btnLogout = new JButton("????????????");
		btnLogout.setBounds(560, 330, 120, 27);
		btnLogout.setFont(new Font("??????", Font.BOLD, 15));
		profilePanel.add(btnLogout);
		btnLogout.addActionListener(this);

		seeList();

	}

	//????????? ????????? ?????????
	private ImageIcon makeIcon(Component menu, String address) {
		Image im = Toolkit.getDefaultToolkit().getImage(address);
		im = im.getScaledInstance(menu.getWidth(), menu.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(im);
		return img;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ?????? ??????
		clear();

		if( e.getSource() == btnHome )
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			tfSearch.setText("");
			clTextArea();
			seeList();
			btnDeleteComment.setVisible(false);
			btnUpdateComment.setVisible(false);
			dono = 0;

			//+ ????????? ????????? ????????????
		}
		else if( e.getSource() == btnSearch )
		{
			//			JOptionPane.showMessageDialog(null,"?????? ?????? ??????");
			doSearch();
			dono = 0;

		}
		else if( e.getSource() == btnLikesSort )
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			sortCondition = SORTLIKES;

			seeList();
		}
		else if( e.getSource() == btnLatestSort )
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			sortCondition = SORTLATEST;

			seeList();
		}
		else if( e.getSource() == btnLoginMenu )
		{	
			clTextArea();
			loginPanel.setVisible(true);
		}
		else if( e.getSource() == btnTour)
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			searchSwitch = 0;
			btnTour.setIcon(makeIcon(btnTour, "./image/btnTourOrange.jpg"));
			btnFood.setIcon(makeIcon(btnFood, "./image/btnFood.jpg"));
			page = 1;
			rnum = ((page-1) * PAGELIST) + 1;
			lbPageNo.setText("page " + page);

			seeList();
		}
		else if( e.getSource() == btnFood )
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			searchSwitch = 1;
			btnFood.setIcon(makeIcon(btnFood, "./image/btnFoodOrange.jpg"));
			btnTour.setIcon(makeIcon(btnTour, "./image/btnTour.jpg"));
			page = 1;
			rnum = ((page-1) * PAGELIST) + 1;
			lbPageNo.setText("page " + page);

			seeList();
		}
		else if( e.getSource() == btnProfileMenu )
		{	
			dono = 0 ;
			profilePanel.setVisible(true);
			menuPanel.setVisible(true);

			Profile ret = new Profile();
			ret.selectProfile();

			tfEmail.setText(loginDto.getEmail());
			tfTel.setText(loginDto.getTel());
			tfNickname.setText(loginDto.getNickname());
			Ppassword.setText(loginDto.getPw());
			Cpassword.setText(loginDto.getPw());
		}
		else if( e.getSource() == btnWriteMenu )
		{
			menuPanel.setVisible(true);
			writePanel.setVisible(true);
		}
		// ????????? ??????
		else if( e.getSource() == btnWrite )
		{
			menuPanel.setVisible(true);
			writePanel.setVisible(true);

			if( !( rdTour.isSelected() || rdFood.isSelected() ) )
			{
				JOptionPane.showMessageDialog(null, "????????????(?????????, ??????)??? ???????????????");
				return;
			}

			if( tfTitle.getText().isEmpty() || taContents.getText().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "???????????? ?????? ?????? ????????????.");
				return;
			}

			if( lbPAddress.getText().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "????????? ???????????????");
				return;
			}


			//			if( tfHashcode.getText().isEmpty() || tfHashcode.getText().equals("ex) #???????????????#?????????"))
			//			{
			//				JOptionPane.showMessageDialog(null, "??????????????? ?????? ?????? ???????????????");
			//				return;
			//			}

			String hashcode = tfHashcode.getText().replaceAll(" ", "");
			char tmpHash = hashcode.charAt(0);
			char tmp2Hash = hashcode.charAt(hashcode.length()-1);

			if( hashcode.contains("ex)"))
			{
				JOptionPane.showMessageDialog(null, "?????? ??????????????? ????????? ?????????.");
				return;
			}

			if( !hashcode.contains("#") )
			{
				hashcode = "#" + hashcode;
			}
			else if (hashcode.contains("##"))
			{
				JOptionPane.showMessageDialog(null, "'#'????????? ?????? ??? ??? ????????????.");
				return;
			}
			else if (tmp2Hash == '#')
			{
				JOptionPane.showMessageDialog(null, "'#'????????? ???????????? ??? ??? ????????????.");
				return;
			}
			else if (tmpHash != '#')
			{hashcode = "#" + hashcode;}



			postDto = (PostDTO)Common.getHm().get("PostDTO");

			postDto.setTitle( tfTitle.getText() );
			postDto.setContents( taContents.getText() );
			postDto.setHashcode( hashcode );

			if( rdTour.isSelected() )
			{
				postDto.setCategory("#?????????");
			}
			else if ( rdFood.isSelected() )
			{
				postDto.setCategory("#??????");
			}

			HashMap<String, Object> hm = Common.getHm();
			hm.put("PostDTO", postDto);

			Post wt = new Post();

			if( wt.insertPost() > 0 )
			{
				JOptionPane.showMessageDialog(null, "????????? ?????? ??????????????? ?????????????????????");

				//????????? ???????????? ??? ???????????? ????????? 1??? ??? ???????????? seeList() ??????.
				clTextPost();
				seeList();
				postPanel.setVisible(true);
				writePanel.setVisible(false);
				switchPanel.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "??????????????????????????????.");
			}	
		}
		else if( e.getSource() == btnSetPhoto )
		{
			menuPanel.setVisible(true);
			writePanel.setVisible(true);
			new SetPhoto();

			HashMap<String, Object> hm = Common.getHm();
			lbPAddress.setText(((PostDTO) hm.get("PostDTO")).getPhotoAddress().toString());
		}
		//????????? ??????
		else if( e.getSource() == btnSignIn )
		{
			loginPanel.setVisible(true);
			String sInPass = new String(password.getPassword());

			loginDto.setEmail( tfID.getText() );
			loginDto.setPw( sInPass );

			HashMap<String, Object> hm = Common.getHm();
			hm.put("LoginDTO", loginDto);

			Login log = new Login();
			int ret = log.login();


			if( ret > 0 && ret != 99)
			{
				loginPanel.setVisible(false);
				menuPanel.setVisible(true);
				postPanel.setVisible(true);
				switchPanel.setVisible(true);
				btnLoginMenu.setVisible(false);
				btnProfileMenu.setVisible(true);
				btnWriteMenu.setVisible(true);
			}
			else if( ret == 99 )
			{
				new AdminMemberRun();
			}
			else if( ret == 0 )
			{
				JOptionPane.showMessageDialog(null, "???????????? ???????????? ????????????.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "??????????????? ???????????? ????????????.");
			}

		}
		else if( e.getSource() == btnFindAccount )
		{
			loginPanel.setVisible(true);
			new FindAccount();
			clLogDt();
		}
		else if( e.getSource() == btnCreateAccount )
		{
			loginPanel.setVisible(true);
			new CreateAccount();
			clLogDt();
		}
		else if( e.getSource() == btnGoToMain )
		{
			clLogDt();
			clTextPost();
			switchPanel.setVisible(true);
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
		}
		//????????? ??????
		else if( e.getSource() == btnUpdate )
		{
			menuPanel.setVisible(true);
			profilePanel.setVisible(true);

			String pPass = new String(Ppassword.getPassword());
			String cPass = new String(Cpassword.getPassword());
			String tel   = tfTel.getText();
			String nickname = tfNickname.getText();

			if( pPass.isEmpty() || cPass.isEmpty() || tel.isEmpty() || nickname.isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "????????? ?????? ????????????.");
				return;
			}
			if( !pPass.equals(cPass))
			{
				JOptionPane.showMessageDialog(null, "??????????????? ?????? ???????????????");
				return;
			}
			loginDto.setPw(pPass);
			loginDto.setTel(tel);
			loginDto.setNickname(nickname);

			Profile ret = new Profile();

			if(ret.updateProfile() > 0)
			{
				JOptionPane.showMessageDialog(null, "???????????? ???????????????.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "????????? ??????????????????.");
			}
		}
		else if( e.getSource() == btnLogout )
		{
			menuPanel.setVisible(true);
			postPanel.setVisible(true);
			switchPanel.setVisible(true);
			btnLoginMenu.setVisible(true);
			btnProfileMenu.setVisible(false);
			btnWriteMenu.setVisible(false);
			clLogDt();
			clTextArea();
			processLogout();
		}

		else if( e.getSource() == btnSecession )
		{	
			profilePanel.setVisible(true);
			menuPanel.setVisible(true);
			int result = 0;
			result = JOptionPane.showConfirmDialog(null, "????????? ???????????? ???????????????????", "????????????",
					JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

			if (result == JOptionPane.YES_OPTION) {

				menuPanel.setVisible(true);
				postPanel.setVisible(true);
				switchPanel.setVisible(true);
				btnLoginMenu.setVisible(true);
				btnProfileMenu.setVisible(false);
				btnWriteMenu.setVisible(false);
				Profile p = new Profile();
				int r = p.leaveMember();

				if( r > 0)
				{
					JOptionPane.showMessageDialog(null,"???????????? ???????????????");
					clLogDt();
					clTextArea();
					processLogout();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"??????????????? ???????????????");
				}
			}
			else if (result == JOptionPane.CANCEL_OPTION) {}
		}
		// ????????? ??? ??????	
		else if( e.getSource() == btnPostLike )
		{
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

			if("".equals(loginDto.getMberNo()))
			{
				JOptionPane.showMessageDialog(null,"??????????????? ????????? ???????????????");
				return;
			}
			likesDto.setMberNo(loginDto.getMberNo().toString());
			//likesDto??? setPostNo??? ?????? ????????? ???????????? ??????????????????

			HashMap<String, Object> hm = Common.getHm();
			hm.put("LikesDTO", likesDto);

			Likes like = new Likes();
			int r = like.likes();

			if(r > 0)
			{
				btnPostLike.setVisible(false);
				btnPostUnlike.setVisible(true);
			}
			else if(r <= 0)
			{
				JOptionPane.showMessageDialog(null,"????????? ??????");
			}

			lbPostLike.setText( String.valueOf( lk.countLikes() ) );
		}
		else if (e.getSource() == btnPostUnlike)
		{
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

			likesDto.setMberNo(loginDto.getMberNo().toString());

			HashMap<String, Object> hm = Common.getHm();
			hm.put("LikesDTO", likesDto);

			Likes like = new Likes();
			int r = like.unlikes();

			if(r > 0)
			{
				btnPostLike.setVisible(true);
				btnPostUnlike.setVisible(false);
			}
			else if(r <= 0)
			{
				JOptionPane.showMessageDialog(null,"????????? ??????");
			}

			lbPostLike.setText( String.valueOf( lk.countLikes() ) );
		}
		else if (e.getSource() == btnPostComment) {
			lbCommentTaget.setText("???????????????");
			btnDeleteComment.setVisible(false);
			btnUpdateComment.setVisible(false);
			dono = 0 ;
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);
		}
		else if( e.getSource() == btnPostModify )
		{
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

			postDto.setTitle(tfPostTitle.getText());
			postDto.setContents(tAPostContents.getText());

			HashMap<String, Object> hm = Common.getHm();
			hm.put("PostDTO", postDto);

			Post p = new Post();
			int r = p.updatePost();

			if( r > 0 )
			{
				JOptionPane.showMessageDialog(null,"???????????? ???????????? ???????????????.");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"??????????????? ???????????????.");
			}

		}
		else if( e.getSource() == btnPostDelete )
		{
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);
			switchPanel.setVisible(true);

			Post p = new Post();	
			int r = p.deletePost();

			if( r > 0 )
			{
				JOptionPane.showMessageDialog(null,"???????????? ???????????? ???????????????.");
				clLogDt();
				seeList();
				postPanel.setVisible(true);
				showPostPanel.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"??????????????? ???????????????.");
			}
		}

		else if( e.getSource() == btnFullScreen )
		{
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

			new FullScreen(postAddress);
		}	
		// List
		else if (e.getSource() == btnNext) {
			menuPanel.setVisible(true);
			switchPanel.setVisible(true);
			postPanel.setVisible(true);
			++page;
			rnum = ((page-1) * PAGELIST) + 1;
			btnPrevious.setVisible(true);

			lbPageNo.setText("page " + page);

			seeList();
		}
		else if (e.getSource() == btnPrevious) {
			menuPanel.setVisible(true);
			switchPanel.setVisible(true);
			postPanel.setVisible(true);
			--page;
			rnum = ((page-1) * PAGELIST) + 1;
			btnNext.setVisible(true);

			lbPageNo.setText("page " + page);

			seeList();
		}

		//		insertComment();

		else if (e.getSource() == btnComment){
			//?????? ?????? ??????

			if("".equals(loginDto.getMberNo()))
			{
				menuPanel.setVisible(true);
				showPostPanel.setVisible(true);
				JOptionPane.showMessageDialog(null,"??????????????? ???????????? ???????????????.");
				return;
			}
			if (dono == 0)
				commentDto.setUpBbscttNo(postPK);
			else
				commentDto.setUpBbscttNo(commentDto.commentTarget.get(String.valueOf(dbRow))); // ?????? ????????? ????????? ??????????????? ????????? ?????? ??????????????? ??????
			if(tAComment.getText().isEmpty())
			{
				menuPanel.setVisible(true);
				showPostPanel.setVisible(true);
				JOptionPane.showMessageDialog(null,"????????? ????????? ?????????.");
				return;
			}
			else {commentDto.setContents(tAComment.getText());}

			HashMap<String, Object> hm = Common.getHm();
			hm.put("CommentDTO", commentDto);

			Comment wtAn = new Comment();

			if( wtAn.insertComment() > 0 )
			{
				//				JOptionPane.showMessageDialog(null, "????????? ?????????????????????.");

				//????????? ???????????? ??? ???????????? ????????? 1??? ??? ???????????? seeList() ??????.
				clear();
				tAComment.setText("");
				seePost(postPK);
				seeComment(postPK);

				menuPanel.setVisible(true);
				showPostPanel.setVisible(true);
			}
			else
			{	
				menuPanel.setVisible(true);
				showPostPanel.setVisible(true);
				JOptionPane.showMessageDialog(null, "????????? ???????????????.");
			}	


		}
		else if (e.getSource() == btnDeleteComment) {
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);
			int result = 0;
			result = JOptionPane.showConfirmDialog(null, "?????????????????????????", "?????? ??????",
					JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

			if (result == JOptionPane.YES_OPTION) {

				commentDto.setUpBbscttNo(commentDto.commentTarget.get(String.valueOf(dbRow)));
				//			commentDto.setContents(tAComment.getText());

				HashMap<String, Object> hm = Common.getHm();
				hm.put("CommentDTO", commentDto);

				Comment dlAn = new Comment();
				dlAn.DeleteComment();
			}
			else if (result == JOptionPane.CANCEL_OPTION) {}

			seePost(postPK);
			seeComment(postPK);
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

		}

		else if (e.getSource() == btnUpdateComment) {
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);
			int result = 0;

			if(tAComment.getText().isEmpty())
			{
				menuPanel.setVisible(true);
				showPostPanel.setVisible(true);
				JOptionPane.showMessageDialog(null,"????????? ????????? ?????????.");
				return;
			}

			result = JOptionPane.showConfirmDialog(null, "?????????????????????????", "?????? ??????",
					JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

			if (result == JOptionPane.YES_OPTION) {

				commentDto.setUpBbscttNo(commentDto.commentTarget.get(String.valueOf(dbRow)));
				commentDto.setContents(tAComment.getText());

				HashMap<String, Object> hm = Common.getHm();
				hm.put("CommentDTO", commentDto);

				Comment dlAn = new Comment();
				dlAn.UpdateComment();
			}
			else if (result == JOptionPane.CANCEL_OPTION) {}

			tAComment.setText("");
			seePost(postPK);
			seeComment(postPK);
			menuPanel.setVisible(true);
			showPostPanel.setVisible(true);

		}
		else {
			for(int i = 0; i < 9; i++)
			{
				if(e.getSource() == btnPn.get(i))
				{
					if(!"n".equals(pk[i]))
					{	
						if(dono == 0)
							lbCommentTaget.setText("???????????????");
						likesDto.setPostNo(pk[i]);
						btnDeleteComment.setVisible(false);
						btnUpdateComment.setVisible(false);

						seePost(pk[i]);
						seeComment(pk[i]);
					}			
				}

			}

		}
	}

	private void clear() {
		menuPanel.setVisible(false);
		postPanel.setVisible(false);
		showPostPanel.setVisible(false);
		switchPanel.setVisible(false);
		loginPanel.setVisible(false);
		profilePanel.setVisible(false);
		writePanel.setVisible(false);
	}

	private void processLogout() {
		HashMap<String, Object> hm = Common.getHm();

		LoginDTO loginDto = new LoginDTO();
		PostDTO  postDto  = new PostDTO();
		LikesDTO likesDto  = new LikesDTO();

		hm.put("LoginDTO", loginDto);
		hm.put("PostDTO", postDto);
		hm.put("LikesDTO", likesDto);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//		System.out.println(e.getKeyCode());				//??? ????????? ?????????
		if( e.getSource() == tfSearch )
		{
			if( e.getKeyCode() == 10 )
			{
				//				JOptionPane.showMessageDialog(null,"?????? ?????? ??????,\n ???????????? ??????");
				//				menuPanel.setVisible(false);
				//				postPanel.setVisible(false);	
				doSearch();
			}
		}
		else if( e.getSource() == password )
		{
			if( e.getKeyCode() == 10 )
			{
				String sInPass = new String(password.getPassword());

				loginDto.setEmail( tfID.getText() );
				loginDto.setPw( sInPass );

				HashMap<String, Object> hm = Common.getHm();
				hm.put("LoginDTO", loginDto);

				Login log = new Login();
				int ret = log.login();

				if( ret > 0 && ret != 99)
				{
					loginPanel.setVisible(false);
					menuPanel.setVisible(true);
					postPanel.setVisible(true);
					switchPanel.setVisible(true);
					btnLoginMenu.setVisible(false);
					btnProfileMenu.setVisible(true);
					btnWriteMenu.setVisible(true);
				}
				else if( ret == 99 )
				{
					new AdminMemberRun();
				}
				else if( ret == 0 )
				{
					JOptionPane.showMessageDialog(null, "???????????? ???????????? ????????????.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "??????????????? ???????????? ????????????.");
				}
			}
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}


	private void seeList() {
		if(page == 1) 
		{
			btnPrevious.setVisible(false);
		}

		String sql;

		if( sortCondition == 0 )
		{
			sql = 	"SELECT *\r\n														" + 
					"FROM ( SELECT O.*, ROWNUM RNUM  \r\n								" + 
					"       FROM ( SELECT B.BBSCTT_NO\r\n								" + 
					"                   , B.PHOTO_ADRES\r\n								" + 
					"               FROM   BBSCTT  B			\r\n					" + 
					"               WHERE  1 = 1 								\r\n	" + 
					"               AND UP_BBSCTT_NO is null				\r\n		" + 
					"               AND INDICT_AT = 'y' 						\r\n	" + 
					"               AND HASHCD like ?							\r\n" + 
					"               ORDER BY BBSCTT_DATE DESC					\r\n	" + 
					"            ) O 										\r\n		" + 
					"    ) 												\r\n			" + 
					"WHERE RNUM   >= ? 								\r\n				" + 
					"AND   ROWNUM <= ?	"
					;
		}
		else
		{
			sql =   "SELECT *\r\n" + 
					"FROM ( SELECT O.*, ROWNUM RNUM  \r\n" + 
					"       FROM ( SELECT B.BBSCTT_NO \r\n" + 
					"                   , B.PHOTO_ADRES \r\n" + 
					"                   , COUNT(R.BBSCTT_NO) \r\n" +
					"                   , B.BBSCTT_DATE \r\n" +
					"              FROM   BBSCTT       B\r\n" + 
					"              LEFT   JOIN   RECOMEND     R\r\n" + 
					"              ON     B.BBSCTT_NO = R.BBSCTT_NO\r\n" + 
					"              WHERE  INDICT_AT = 'y'\r\n" + 
					"              AND    UP_BBSCTT_NO IS NULL\r\n" + 
					"              AND    HASHCD like ?	\r\n" + 
					"              GROUP  BY 3, B.BBSCTT_NO, B.PHOTO_ADRES, B.BBSCTT_DATE\r\n" + 
					"              ORDER  BY 3 DESC, B.BBSCTT_DATE\r\n" + 
					"            ) O 										\r\n" + 
					"     ) 												\r\n" + 
					"WHERE RNUM   >= ? 								\r\n" + 
					"AND   ROWNUM <= ?	"
					;
		}




		try {
			Common.dbconnect();

			pstmt = Common.con.prepareStatement(sql);

			searchQuery = tfSearch.getText();

			if ("#?????????".equals(searchQuery) && searchSwitch == 0){ searchQuery = "";}
			if ("#??????".equals(searchQuery) && searchSwitch == 1){ searchQuery = "";}

			switch(searchSwitch) {
			case 0 :
				searchQuery = "#?????????%" + searchQuery + "%";
				break;
			case 1 :
				searchQuery = "#??????%" + searchQuery + "%";
				break;
			case 2 :
				if(!tfSearch.getText().isEmpty())
				{
					searchQuery = "%"+ searchQuery +"%";
				}
				else 
				{
					return;
				}
				break;
			}

			pstmt.setString(1, searchQuery );
			pstmt.setInt(2, rnum);
			pstmt.setInt(3, PAGELIST + 1);

			key = pstmt.executeQuery();

			int cunt = 0;

			String[] saDate = new String[] {"n","n","n","n","n","n","n","n","n"};
			String[] pkDate = new String[] {"n","n","n","n","n","n","n","n","n"};
			for(int i = 0 ; cunt < PAGELIST && key.next(); ++i) {
				pkDate[i] = key.getString(1);
				saDate [i] = key.getString(2);
				cunt++;
			}
			if(!key.next())
			{
				btnNext.setVisible(false);
				//				throw new BizException();
			}
			else 
			{
				btnNext.setVisible(true);
			}

			for(int i = 0; i < 9; i++)
			{
				if(!"n".equals(saDate[i]))
				{
					btnPn.get(i).setIcon(makeIcon(btnPn.get(i), saDate[i]));
					pk[i] = pkDate[i];
					btnPn.get(i).setVisible(true);
				}
				else
				{
					btnPn.get(i).setVisible(false);
				}
			}


		} catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( key!= null ) key.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
	}

	private void seePost(String k) {
		String sql = "SELECT B.*					" + 
				"     , M.NCNM					" +
				"FROM   BBSCTT   B  			" +	
				"JOIN   MBER     M 			" +	
				"ON     B.MBER_NO = M.MBER_NO 	" +	
				"WHERE  B.BBSCTT_NO = ? 		";
		try {
			Common.dbconnect();
			pstmt = Common.con.prepareStatement(sql);
			pstmt.setString(1, k);
			key = pstmt.executeQuery();
			if(key.next()) 
			{

				tfPostTitle.setText(key.getString("BBSCTT_SJ"));
				tAPostContents.setText(key.getString("BBSCTT_CN"));
				lbPostDate.setText(key.getString("BBSCTT_DATE"));
				lbShowHash.setText(key.getString("HASHCD"));
				lbPostPhoto.setIcon(makeIcon(lbPostPhoto, key.getString("PHOTO_ADRES")));
				lbPostWriter.setText("?????????  " + key.getString("NCNM") + " ???");

				postWriterNo = key.getString("MBER_NO");
				postPK = key.getString("BBSCTT_NO");
				postAddress = key.getString("PHOTO_ADRES");

			}



		} catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( key!= null ) key.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}


		HashMap<String, Object> hm = Common.getHm();
		hm.put("LikesDTO", likesDto);

		lbPostLike.setText( String.valueOf( lk.countLikes() ) );

		menuPanel.setVisible(true);
		showPostPanel.setVisible(true);

		if( !loginDto.getMberNo().isEmpty())
		{
			if(lk.checkLikes())
			{
				btnPostLike.setVisible(false);
				btnPostUnlike.setVisible(true);
			}
			else
			{
				btnPostLike.setVisible(true);
				btnPostUnlike.setVisible(false);
			}
		}

		if( postWriterNo.equals(loginDto.getMberNo()))
		{
			btnPostModify.setVisible(true);
			btnPostDelete.setVisible(true);
			tfPostTitle.setEditable(true);
			tAPostContents.setEditable(true);
		}
		else
		{
			btnPostModify.setVisible(false);
			btnPostDelete.setVisible(false);
			tfPostTitle.setEditable(false);
			tAPostContents.setEditable(false);
		}

	}
	private void seeComment(String k) {
		dtModel.setRowCount(0);

		String sql = "SELECT LEVEL													\r\n" + 
				", LPAD(' ', 4*(LEVEL-1)) || '???' || ' ' || bbsctt_cn bbsctt_cn	\r\n" +
				", ROWNUM														\r\n" + 
				", B.BBSCTT_NO													\r\n" + 
				", B.UP_BBSCTT_NO												\r\n" + 
				", B.MBER_NO													\r\n" + 
				", B.BBSCTT_DATE												\r\n" + 
				", M.NCNM														\r\n" + 
				"FROM BBSCTT B													\r\n" + 
				"join MBER M  on M.MBER_NO = B.MBER_NO							\r\n" + 
				"START WITH UP_BBSCTT_NO = ?									\r\n" + 
				"AND B.INDICT_AT = 'y'											\r\n" + 
				"CONNECT BY PRIOR B.BBSCTT_NO = B.UP_BBSCTT_NO					";
		try {
			Common.dbconnect();
			pstmt = Common.con.prepareStatement(sql);
			pstmt.setString(1, k);
			key = pstmt.executeQuery();

			int cunt = 0;

			while (key.next()) {
				String[] saDate = new String[3];

				String cutDate = key.getString("BBSCTT_DATE");
				cutDate = cutDate.substring(0, 10);

				saDate[0] = key.getString("NCNM");
				saDate[1] = key.getString("bbsctt_cn").substring(1);
				saDate[2] = cutDate;

				if(!saDate[1].contains("@????????? ??? ???"))
					cunt++;

				dtModel.addRow(saDate);

				commentDto.commentTargetNo.put(key.getString("ROWNUM"), key.getString("MBER_NO"));
				commentDto.commentTarget.put(key.getString("ROWNUM"), key.getString("BBSCTT_NO"));


			}

			lbPostComment.setText(String.valueOf(cunt));


		} catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( key!= null ) key.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
	}

	private void clLogDt() {
		tfID.setText("");
		password.setText("");
	}
	private void clTextArea() {
		tAComment.setText("");
		tAPostContents.setText("");

	}
	private void clTextPost() {
		tfTitle.setText("");
		taContents.setText("");
		tfHashcode.setText("ex) #???????????????#?????????");
		doCL = 0;
	}
	private void doSearch() {
		menuPanel.setVisible(true);
		postPanel.setVisible(true);
		switchPanel.setVisible(true);
		//		searchText = searchText.replaceAll("", "");
		seeList();

		if(page==1) 
			btnPrevious.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		btnDeleteComment.setVisible(false);
		btnUpdateComment.setVisible(false);

		if( e.getSource() == tfHashcode )
		{	
			if (doCL == 0) {
				tfHashcode.setText("");
				doCL++;
			}
		}
		else if (e.getSource() == tabComment) {
			dono = 99;
			row = tabComment.getSelectedRow();
			dbRow = row + 1 ;

			if (row > -1)
			{
				lbCommentTaget.setText(  String.valueOf(tabComment.getValueAt(row, 0)+" ??? ?????? "));
			}



			String commentTN = commentDto.commentTargetNo.get(String.valueOf(dbRow));
			String tabCommentCon = (String)tabComment.getValueAt(row, 1);

			if( commentTN.equals(loginDto.getMberNo()))
			{
				btnUpdateComment.setVisible(true);	

				if(tabCommentCon.contains("@????????? ??? ???"))
				{
					btnUpdateComment.setVisible(true);
				}
				else
				{
					btnDeleteComment.setVisible(true);
				}

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}

