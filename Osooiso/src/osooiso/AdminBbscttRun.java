package osooiso;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AdminBbscttRun implements ActionListener, ItemListener, MouseListener{

	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField tfScondition;
	private JTextField tfCode;
	private JTextField tfMberNo;
	private JTextField tfUP_BBSCTT_NO;
	private JButton btnSearch;
	private JButton btnClear;
	private JButton btnUpdate;
	private JLabel lbMSG;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JComboBox<String> cmbCodeName;
	private JButton btnNext;
	
	
	
	
	
	//1.
	private String[]	saTit		= new String[] {"게시글번호", "상위게시글번호", "회원번호", "게시글제목", "게시글내용", "게시글날짜", "표시여부" };	//컬럼 만들어주는 것	//string array title
	private int []		iaCwidth	= new int	[] {10,		30,		10,		100,		100,		80,		10};	//칼럼 폭//int array column width
	private int []		iaAlm		= new int 	[]	{JLabel.RIGHT, JLabel.RIGHT, JLabel.LEFT,JLabel.LEFT, JLabel.LEFT, JLabel.LEFT, JLabel.CENTER};
	//파이널 상수 // 코드 우정렬, (이름, 이메일) 좌정렬, 전화번호 중앙, 체중 우정렬 
	
	private DefaultTableModel dtModel;			//AbstractTableModel 을 상속받아 사용하는 것 보다 효율적임
	
//	private static final int CONDITION 	= 1;	//화면 조회조건항목 초기화
//	private static final int TABLE 		= 2;	//화면 테이블항목 초기화
//	private static final int FIELD 		= 4;	//화면 조작황목 초기화
//	private static final int ALL 		= 7;	//화면 전체항목 초기화
		
	PreparedStatement pstmt  = null;
	PreparedStatement pstmt2 = null;
	ResultSet 			rs	 = null;
	
	
	private 		   	 int pageNum = 0;	//page 번호
	private static final int MAXCNT = 8;	//한 화면에 조회될 최대 데이터 건수
	
	private static final int NONE = 0;
	private static final int CODE = 1;		//코드순 조회
	private static final int EMAIL = 2;		//이메일 조회
	private static final int INDICT_AT = 3;	//게시물여부 조회
	private 			 int iSearch = CODE;	//조회구분 (코드순, 성명)	//디폴트값으로 코드를 서치하겠다는 뜻
	private JLabel label_6;
	private JTextField tfINDICT_AT;
	private JButton btnExit;
	private JTextArea textArea;
	private JButton btnMber;

	/**
	 * Launch the application.
	 */
	
	
//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GuiTestSqlConnectionName window = new GuiTestSqlConnectionName();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		});
//		
//	}

	/**
	 * Create the application.
	 */
	public AdminBbscttRun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(500, 290, 870, 468);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		label = new JLabel("*조건조회");
		label.setBounds(25, 55, 73, 15);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("게시물번호");
		label_1.setBounds(25, 268, 84, 15);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		frame.getContentPane().add(label_1);
		
		label_3 = new JLabel("회원번호");
		label_3.setBounds(362, 268, 65, 15);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("상위게시글번호");
		label_4.setBounds(175, 268, 116, 15);
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		frame.getContentPane().add(label_4);
		
		tfScondition = new JTextField();
		tfScondition.setBounds(226, 52, 118, 21);
		frame.getContentPane().add(tfScondition);
		tfScondition.setColumns(10);
		
		tfCode = new JTextField();
		tfCode.setBounds(106, 265, 57, 21);
		tfCode.setColumns(10);
		frame.getContentPane().add(tfCode);
		
		tfMberNo = new JTextField();
		tfMberNo.setBounds(427, 265, 57, 21);
		tfMberNo.setColumns(10);
		frame.getContentPane().add(tfMberNo);
		
		tfUP_BBSCTT_NO = new JTextField();
		tfUP_BBSCTT_NO.setBounds(287, 265, 57, 21);
		tfUP_BBSCTT_NO.setColumns(10);
		frame.getContentPane().add(tfUP_BBSCTT_NO);
		
		btnSearch = new JButton("조회");
		btnSearch.setBounds(599, 25, 101, 31);
		btnSearch.setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnClear = new JButton("초기화");
		btnClear.setBounds(726, 25, 101, 31);
		btnClear.setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().add(btnClear);
		btnClear.addActionListener(this);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(736, 347, 106, 31);
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		lbMSG = new JLabel("");
		lbMSG.setBounds(52, 404, 263, 15);
		lbMSG.setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().add(lbMSG);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 95, 786, 163);
		frame.getContentPane().add(scrollPane);
		
		
		lblNewLabel = new JLabel("MSG");
		lblNewLabel.setBounds(12, 404, 41, 15);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setToolTipText("");
		frame.getContentPane().add(lblNewLabel);
		
		btnNext = new JButton("다음");
		btnNext.setBounds(714, 265, 97, 23);
		btnNext.setEnabled(false);
		btnNext.setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().add(btnNext);
		btnNext.addActionListener(this);
		
		cmbCodeName = new JComboBox<String>();
		cmbCodeName.setBounds(103, 52, 97, 21);
		cmbCodeName.setModel(new DefaultComboBoxModel<String>(new String[] {"게시물코드", "회원번호", "게시물여부"}));
		frame.getContentPane().add(cmbCodeName);
		cmbCodeName.addItemListener(this);
		
		frame.setVisible(true);	//메인메소드 지워서 이렇게해야 화면에 보임
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//메뉴 실행		//화면만 닫는것 = 메뉴화면으로 돌아가는 셈
		
		
		table = new JTable();
		//2. 테이블의 속성을 지정하여 테이블을 생성한다.
		
		//STEP 1. 테이블 모델을 생성한다.
		dtModel = new DefaultTableModel(saTit, 0) {	//dtmodel 객체를 만들어	//0 은 첨자 
		
		
		private static final long serialVersionUID = 1L;
		boolean[] canEdit = new boolean[] 
				{
				false,false,false,false,false,false,false
				};
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
			return canEdit[columnIndex];		
			}
		};
		
		//STEP 2. 테이블의 컬럼 출력형식을 새롭게 지정한다.
		//SEEP 2-1. 테이블 컬럼을 생성하지 않게 한다.
		table.setAutoCreateColumnsFromModel(false);	//자동컬럼 만드는 기능 끈다. 길이 (폭)을 수동으로 정렬하겠다.
		table.setModel(dtModel);	//Table 에 dtmodel 넣는다.
		
		for (int i = 0; i < iaAlm.length; i++)	//칼럼 갯수만큼 돌아라 = 5개 니깐 다섯번 돔
		{
			//STEP 2-2. CELL 렌더러를 만들고, 각각의 셀에 정렬 방식을 지정한다.
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(iaAlm[i]);	//정렬방식 지정
			//STEP 2-3. 각각의 컬럼에 정렬방식이 지정된 CELL 렌더러를 지정하고, 각 셀의 Width를 지정한다.
			TableColumn column = new TableColumn(i, iaCwidth[i], renderer, null);	//칼럼만드는 곳 //
			
			//STEP 2-4. 생성된 컬럼을 테이블에 추가한다.
			table.addColumn(column); 	//테이블에다가 컬럼 넣는다.
		}
		
		table.setFocusable(false);					//테이블 내에서 입력금지용	//테이블에선 조회만 하니깐
		scrollPane.setViewportView(table);
		
		label_6 = new JLabel("게시물여부");
		label_6.setBounds(508, 268, 84, 15);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("굴림", Font.BOLD, 15));
		frame.getContentPane().add(label_6);
		
		tfINDICT_AT = new JTextField();
		tfINDICT_AT.setBounds(599, 265, 41, 21);
		tfINDICT_AT.setColumns(10);
		frame.getContentPane().add(tfINDICT_AT);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(736, 388, 106, 31);
		btnExit.setFont(new Font("굴림", Font.BOLD, 12));
		btnExit.setEnabled(true);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setBounds(25, 293, 691, 108);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		btnMber = new JButton("회원관리");
		btnMber.setFont(new Font("굴림", Font.BOLD, 12));
		btnMber.setEnabled(true);
		btnMber.setBounds(736, 306, 106, 31);
		frame.getContentPane().add(btnMber);
		btnMber.addActionListener(this);
	
		table.addMouseListener(this);	// 마우스리스너 JVM 에게 부탁하는 것
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		enableInit();	//처음상태로 돌아간다~
		if(e.getSource() == btnClear)	//초기화 버튼
		{
			clear();
		}
		
		else if(e.getSource() == btnSearch)		//조회 버튼
		{
			dtModel.setRowCount(0);
			if (tfScondition.getText().isEmpty())				//입력된 데이터를 가꼬 오는데 리턴타입은 스트링. 스트링 객체에는 isEmpty 를 쓸 수 있다. isEmpty = 텅비었냐 true 면 비었다.
			{
				JOptionPane.showMessageDialog(frame, "조회조건을 선택하세요.");	//JOptionPane 는 클래스이름 (스태틱) //JOptionPane.showMessageDialog 대화창 여는 메소드// frame < 부모화면 23번 줄.// 부모창이 없으면 null
				return;
			}
				pageNum = 1;	//조회버튼이 눌러졌으니 1
				
				if(iSearch == CODE)	// 코드가 선택됬으면 코드 메소드 실행
				{
					bbsctt_codes();
				}
				else if(iSearch == EMAIL)
				{
					bbsctt_mberNo();
				}
				else if(iSearch == INDICT_AT)
				{
					indict_at();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "조회조건을  선택하세요.");	//JOptionPane 는 클래스이름 (스태틱) //JOptionPane.showMessageDialog 대화창 여는 메소드// frame < 부모화면 23번 줄.// 부모창이 없으면 null
					return;
				}

		}
		else if(e.getSource() == btnNext)
		{
			pageNum++;
			if (iSearch == CODE)
			{
				bbsctt_codes();
			}
			else if (iSearch == EMAIL)
			{
				bbsctt_mberNo();
			}
			else if (iSearch == INDICT_AT)
			{
				indict_at();
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "조회조건을 선택하세요.");
				return;
			}
		}
		else if(e.getSource() == btnMber)
		{
			frame.setVisible(false);
			new AdminMemberRun();
		}		
		else if(e.getSource() == btnUpdate)	//수정 버튼
		{		
			update();		
		}
		else if(e.getSource() == btnExit)
		{
			System.exit(0);
		}
	}
//	lpad(BBSCTT_NO, 4, '0') 
	
	public void bbsctt_codes() {

		String sSelect5 =	"SELECT *" 							+
				"FROM ( SELECT  O.*"				+
				" 			 ,  ROWNUM RNUM"		+
				"       FROM (  select BBSCTT_NO\r\n" + 
				"        ,UP_BBSCTT_NO\r\n" + 
				"        ,MBER_NO\r\n" + 
				"        ,BBSCTT_CN\r\n" + 
				"        ,BBSCTT_SJ\r\n" + 
				"        ,BBSCTT_DATE\r\n" + 
				"        ,INDICT_AT\r\n" + 
				"        ,HASHCD\r\n" + 
				"        ,PHOTO_ADRES"			+
				"               FROM   BBSCTT"	+
				"               WHERE  1 = 1"		+
				"               AND    BBSCTT_NO >= ?"	+
				"               ORDER BY BBSCTT_NO"		+
				"            )  O"					+
				"     )" 							+
				"WHERE  RNUM   > = ?  "				+//이거만 바뀜 1페이지때는 1 2페이지때는 6 3페이지때는 11
				"AND    ROWNUM < = ?  ";			//6 고정
													//RUNM = 페이지 1, 6 , 11, 16, 21 	두번째 페이지는 6,6
													//ROWNUM 건수 ex) 5건 보고싶으면 6 입력
													//		start# = (page# -1) * 5 + 1
													//
													//		5의 의미는 page 당 건수
													//
													//		ex) 10건이면
													//		start# = (page# -1) * 10 + 1
													//
													//		//페이지넘버 구하는거
													//		page 번호라는 변수를 준비해서 조회버튼 눌러지면 1
													//		다음 버튼 눌러지면 페이지넘버를 ++
//			start = (pageNum -1) * 5 + 1;	//몇번 부터 시작하는지
		String[] saData = new String[7];
			
		try {
			Common.dbconnect();
			pstmt = Common.con.prepareStatement(sSelect5);
			pstmt.setInt(1, Integer.parseInt(tfScondition.getText()));
			pstmt.setInt(2, (pageNum -1) * MAXCNT + 1);
			pstmt.setInt(3, MAXCNT + 1);
			rs = pstmt.executeQuery();
				
			int cnt = 0;
				
			while (true)
			{
				if (!rs.next()) //5개가 꽉 안찻을때 나가는 경우 도 됨
				{
					btnNext.setEnabled(false);	//정보가 없으면 다음버튼 허용 x
					break;
				}
					
				cnt++;
					
				if (cnt > MAXCNT)	//next data 가 존재 할 경우 , 5개가 다 찻을때 나가는경우
				{
					btnNext.setEnabled(true);	//cnt 가 MAXCNT(5)보다 커지면 다음버튼 활성화
					break;						//터짐
				}
				saData[0] = rs.getString(1);
				saData[1] = rs.getString(2);
				saData[2] = rs.getString(3);
				saData[3] = rs.getString(4);
				saData[4] = rs.getString(5);
				saData[5] = rs.getString(6);
				saData[6] = rs.getString(7);
				
				dtModel.addRow(saData);		//saData에 채워진걸 dtModel에 추가
			}					
				
				
				
			if(cnt == 0)
			{
				lbMSG.setForeground(Color.RED);		//정상
				lbMSG.setText("해당자료가 없습니다.");
			}
			else
			{
				lbMSG.setForeground(Color.BLACK);
				lbMSG.setText("정상조회 되었습니다.");
					
			}
				
				
			} catch (Exception e)	{
				e.printStackTrace();
			} finally {
			try { if ( rs     != null) rs.close();
				} catch (SQLException e1) {}
			try { if ( pstmt  != null) pstmt.close();
				} catch (SQLException e1) {}
			try { if ( Common.con    != null)Common.con.close();
			} catch (SQLException e1) {}
			}

	}
	
	public void bbsctt_mberNo() {	
		String sSelect5 =	"SELECT *" 									+
							"FROM ( SELECT  O.*"						+
							" 			 ,  ROWNUM RNUM"				+
							"       FROM (  select BBSCTT_NO\r\n" + 
							"        ,UP_BBSCTT_NO						\r\n" + 
							"        ,MBER_NO		\r\n" + 
							"        ,BBSCTT_CN							\r\n" + 
							"        ,BBSCTT_SJ							\r\n" + 
							"        ,BBSCTT_DATE						\r\n" + 
							"        ,INDICT_AT							\r\n" + 
							"        ,HASHCD							\r\n" + 
							"        ,PHOTO_ADRES"			+
							"               FROM   BBSCTT"				+
							"               WHERE  1 = 1"				+
							"               AND MBER_NO = ?"+
							"               ORDER BY MBER_NO, BBSCTT_NO"+
							"            )  O"							+
							"     )" 									+
							"WHERE  RNUM   > = ?  "						+//이거만 바뀜 1페이지때는 1 2페이지때는 6 3페이지때는 11	//시작 로우넘버
							"AND    ROWNUM < = ?  ";				//6 고정										//데이터건수
																//RUNM = 페이지 1, 6 , 11, 16, 21 	두번째 페이지는 6,6
																//ROWNUM 건수 ex) 5건 보고싶으면 6 입력
																//		start# = (page# -1) * 5 + 1
																//
																//		5의 의미는 page 당 건수
																//
																//		ex) 10건이면
																//		start# = (page# -1) * 10 + 1
																//
																//		//페이지넘버 구하는거
																//		page 번호라는 변수를 준비해서 조회버튼 눌러지면 1
																//		다음 버튼 눌러지면 페이지넘버를 ++
//		start = (pageNum -1) * 5 + 1;	//몇번 부터 시작하는지
		String[] saData = new String[7];
		 
		try {
			Common.dbconnect();
			pstmt = Common.con.prepareStatement(sSelect5);

			
			pstmt.setInt(1, Integer.parseInt(tfScondition.getText()));
			pstmt.setInt(2, (pageNum -1) * MAXCNT + 1 );	
			pstmt.setInt(3, MAXCNT + 1);
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while (true)
			{
				if (!rs.next())
				{
					btnNext.setEnabled(false);
					break;
				}
				
				cnt++;
				
				if (cnt > MAXCNT)
				{
					btnNext.setEnabled(true);
					break;
				}
				saData[0] = rs.getString(1);
				saData[1] = rs.getString(2);
				saData[2] = rs.getString(3);
				saData[3] = rs.getString(4);
				saData[4] = rs.getString(5);
				saData[5] = rs.getString(6);
				saData[6] = rs.getString(7);
				dtModel.addRow(saData);		//saData에 채워진걸 dtModel에 추가
			}					
			
			
			
			if(cnt == 0)
			{
				lbMSG.setForeground(Color.RED);		//정상
				lbMSG.setText("해당자료가 없습니다.");
			}
			else
			{
				lbMSG.setForeground(Color.BLACK);
				lbMSG.setText("정상조회 되었습니다.");
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if ( rs     != null) rs.close();
				} catch (SQLException e1) {}
			try { if ( pstmt  != null) pstmt.close();
				} catch (SQLException e1) {}
			try { if ( Common.con    != null) Common.con.close();
				} catch (SQLException e1) {}
			}

	}
	
	public void clear()
	{
		tfScondition.setText("");	//위에 코드 텍스트부분 공백으로
		
		lbMSG.setText("");			//밑에 메시지부분 공백으로
		
		dtModel.setRowCount(0);		//모델에 로우카운트를 0 으로
			
		tfCode.setText("");			//밑에 코드 텍스트부분 공백으로
		tfMberNo.setText("");		//밑에 이메일 텍스트부분 공백으로	
		tfUP_BBSCTT_NO.setText("");		//밑에 전화번호 텍스트부분 공백으로
		tfINDICT_AT.setText("");		//밑에 회원여부 텍스트부분 공백으로
	}
		
	
	public void indict_at() {

		String sSearchSingle = "SELECT * FROM BBSCTT WHERE INDICT_AT = ?";


		String sSelect5 =	"SELECT *" 								+
				"FROM ( SELECT  O.*"					+
				" 			 ,  ROWNUM RNUM"			+
				"       FROM (  select BBSCTT_NO BBSCTT_NO\r\n" + 
				"        ,UP_BBSCTT_NO\r\n" + 
				"        ,MBER_NO MBER_NO\r\n" + 
				"        ,BBSCTT_CN\r\n" + 
				"        ,BBSCTT_SJ\r\n" + 
				"        ,BBSCTT_DATE\r\n" + 
				"        ,INDICT_AT\r\n" + 
				"        ,HASHCD\r\n" + 
				"        ,PHOTO_ADRES"			+
				"               FROM   BBSCTT"			+
				"               WHERE  1 = 1"			+
				"               AND    INDICT_AT = ?"	+
				"               ORDER BY BBSCTT_NO"+
				"            )  O"						+
				"     )" 								+
				"WHERE  RNUM   > = ?  "					+//이거만 바뀜 1페이지때는 1 2페이지때는 6 3페이지때는 11	//시작 로우넘버
				"AND    ROWNUM < = ?  ";				//6 고정										//데이터건수
													//RUNM = 페이지 1, 6 , 11, 16, 21 	두번째 페이지는 6,6
													//ROWNUM 건수 ex) 5건 보고싶으면 6 입력
													//		start# = (page# -1) * 5 + 1
													//
													//		5의 의미는 page 당 건수
													//
													//		ex) 10건이면
													//		start# = (page# -1) * 10 + 1
													//
													//		//페이지넘버 구하는거
													//		page 번호라는 변수를 준비해서 조회버튼 눌러지면 1
													//		다음 버튼 눌러지면 페이지넘버를 ++
		//start = (pageNum -1) * 5 + 1;	//몇번 부터 시작하는지
		String[] saData = new String[7];


		try {
			Common.dbconnect();

			
			pstmt = Common.con.prepareStatement(sSearchSingle);
			pstmt.setString(1,tfScondition.getText());
			


			pstmt = Common.con.prepareStatement(sSelect5);
			pstmt.setString(1,tfScondition.getText());
			pstmt.setInt(2, (pageNum -1) * MAXCNT + 1 );	
			pstmt.setInt(3, MAXCNT + 1);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (true)
			{
				if (!rs.next())
				{
					btnNext.setEnabled(false);
					break;
				}
	
				cnt++;
	
				if (cnt > MAXCNT)
				{
					btnNext.setEnabled(true);
					break;
				}
				saData[0] = rs.getString(1);
				saData[1] = rs.getString(2);
				saData[2] = rs.getString(3);
				saData[3] = rs.getString(4);
				saData[4] = rs.getString(5);
				saData[5] = rs.getString(6);
				saData[6] = rs.getString(7);
				dtModel.addRow(saData);		//saData에 채워진걸 dtModel에 추가
			}					



			if(cnt == 0)
			{
				lbMSG.setForeground(Color.RED);		//정상
				lbMSG.setText("해당자료가 없습니다.");
			}
			else
			{
				lbMSG.setForeground(Color.BLACK);
				lbMSG.setText("정상조회 되었습니다.");
	
			}
			
			
			
		}catch(BizException e) {
		} catch (Exception e)	{e.printStackTrace();
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
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cmbCodeName )	//콤보박스에 이벤트가 생겻냐. 라는 뜻
		{
			if(e.getStateChange() == ItemEvent.SELECTED)	//상태가 바뀐정보를 얻는다. 선택된 메시지
			{	
				btnNext.setEnabled(false);
				if("게시물코드".equals(e.getItem().toString())	)				//어떤항목을 get
				{
					iSearch = CODE;	//isearch 라는 변수에 code 넣
				}
				else if ("회원번호".equals(e.getItem()))
				{
					iSearch = EMAIL;
				}
				else if ("게시물여부".equals(e.getItem()))
				{
					iSearch = INDICT_AT;
				}
				else
				{
					iSearch = NONE;
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row;		//선택된 테이블의 행값	//어느 줄을 클릭했냐
//		int col;  		//선택된 테이블의 열값
		
		if(e.getSource() == table)
		{
			JTable jtable = (JTable)e.getSource();	//이줄은 없어도됨.
			row = jtable.getSelectedRow();	// 선택된 테이블의 행값
//			col = jtable.getSelectedColumn();	// 선택된 테이블의 열값
//			System.out.println(row + "," + col);	// 선택된 위치 값을 출력
			
			lbMSG.setText("");				//메시지 초기화
			
			if(row > -1)					// table 에서 특정 행을 클릭한 경우
			{
				tfCode.setText			((String)table.getValueAt(row, 0));	//row는 가로 줄// 0은 칼럼? 세로.
				tfCode.setEnabled(false);							// 코드 항목은 수정대상이 아니므로 disable
				tfUP_BBSCTT_NO.setText	((String)table.getValueAt(row, 1));
				tfUP_BBSCTT_NO.setEnabled(false);
				tfMberNo.setText		((String)table.getValueAt(row, 2));
				tfMberNo.setEnabled(false);				
				textArea.setText		((String)table.getValueAt(row, 4));
				textArea.setEnabled(false);
				tfINDICT_AT.setText		((String)table.getValueAt(row, 6));

				btnUpdate.setEnabled(true);
				
			}
		}
	}
	
	public void update () {	//★★★★★ key 존재 확인해야하고 수정인 경우에는 쿼리하나로 해결하기 위해 하나로 묶는다?? //db에서 읽어올때 select 를 왕창 다 읽어와서 일부분만 써버리자 
		String sSearchSingle = "SELECT * FROM BBSCTT WHERE BBSCTT_NO = ?";
		String sUpdate = "UPDATE BBSCTT SET INDICT_AT = ?   WHERE BBSCTT_NO = ?";
		
		int ret;
		
		String strBbscttNo = tfCode.getText();
		String strBbscttAt = tfINDICT_AT.getText();
		

		if (strBbscttNo.isEmpty())
		{
			JOptionPane.showMessageDialog(frame, "코드를 선택하세요");
			lbMSG.setText("");
			return;
		}
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSearchSingle);
			pstmt.setString(1,strBbscttNo);
			
			rs = pstmt.executeQuery();
			
			if (!rs.next())
			{
				lbMSG.setForeground(Color.RED);
				lbMSG.setText("해당되는 자료가 없습니다.");
				throw new BizException();
			}
			
			pstmt2 = Common.con.prepareStatement(sUpdate);
			pstmt2.setString(1, strBbscttAt);
			pstmt2.setString(2, strBbscttNo);
			
			ret = pstmt2.executeUpdate();
			
			if(ret > 0)
			{
				JOptionPane.showMessageDialog(null, "정상처리 되었습니다.");			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "오류가 발생했습니다.");	
			}
			
		}catch(BizException e) {
		} catch (Exception e)	{e.printStackTrace();
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
	
	public void enableInit()
	{
		tfCode.setEnabled(true);		//밑의 코드 텍스트부분 허용
		btnUpdate.setEnabled(false);	//삭제버튼 허용x
	}
}

