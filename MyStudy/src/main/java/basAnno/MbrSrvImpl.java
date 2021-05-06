package basAnno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mbrSrv")
public class MbrSrvImpl {
	
	@Autowired
	MemberDAO mbrDao;
	@Autowired
	HistDAO histDao;
	
	public MemberDTO getMbr(String id) throws Exception {
		return mbrDao.select(id);
	}
	
	public List<MemberDTO> getMbrList() throws Exception {
		return mbrDao.selectAll();
	}
	
	public String insertMbr(MemberDTO mbr) throws Exception {
		String msg;
		
		MemberDTO chkMbr = mbrDao.select(mbr.getId());
		if(chkMbr != null)
		{
			msg = "해당 자료가 존재합니다.";
			return msg;
		}
		
		mbrDao.insert(mbr);
		histDao.insertHist("Insert " + mbr.toString());
		
		msg = "정상 등록 되었습니다.";
		
		return msg;
	}
	
	public String updateMbr(MemberDTO mbr) throws Exception {
		String msg;
		
		MemberDTO chkMbr = mbrDao.select(mbr.getId());
		if(chkMbr == null)
		{
			msg = "해당 자료가 없습니다.";
			return msg;
		}
		
		chkMbr.setTel(mbr.getTel());
		mbrDao.update(chkMbr);
		histDao.insertHist("Update " + chkMbr.toString());
		
		msg = "정상 수정 되었습니다.";
		
		return msg;
	}
	
	public String deleteMbr(String id) throws Exception {
		String msg;
		
		MemberDTO chkMbr = mbrDao.select(id);
		if(chkMbr == null)
		{
			msg = "해당 자료가 없습니다.";
			return msg;
		}
		
		mbrDao.delete(id);
//		System.out.println(3/0);
		histDao.insertHist("Delete " + chkMbr.toString());
		
		msg = "정상 삭제 되었습니다.";
		
		return msg;
		
	}
}
