package crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cstSrv")
public class CustomerSrvImpl {
	
	@Autowired
	private CustomerDAO cstDao;

	public String getList(int code) {
		String msg = "";
		
		List<CustomerDTO> list = cstDao.selectAll(code);
		
		if(list.size() == 0)
		{
			msg = "조회된 자료가 없습니다.";
			return msg;
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			msg = msg + list.get(i).toString() + "\n";
		}
		
		return msg;
	}
	
	public String insert(CustomerDTO dto) {
		String msg;

		CustomerDTO chkCst = cstDao.select(dto.getCode());
		if(chkCst != null)
		{
			msg = "해당 코드의 자료가 이미 존재합니다.";
			return msg;
		}
		cstDao.insert(dto);
		cstDao.insertHist("insert| " + dto.toString());

		msg = "정상처리 되었습니다.";

		return msg;
	}
	
	public String update(int code, String tel) {
		String msg;

		CustomerDTO chkCst = cstDao.select(code);

		if(chkCst == null)
		{
			msg = "해당코드의 자료가 존재하지 않습니다.";
			return msg;
		}
		chkCst.setCode(code);
		chkCst.setTel(tel);

		cstDao.update(chkCst);
		cstDao.insertHist("update| " + chkCst.toString());

		msg = "정상처리 되었습니다.";

		return msg;
	}
	
	public String delete(int code) {
		String msg;

		CustomerDTO chkCst = cstDao.select(code);
		if(chkCst == null)
		{
			msg = "해당코드의 자료가 존재하지 않습니다.";
			return msg;
		}

		cstDao.delete(code);
		cstDao.insertHist("delete| " + chkCst.toString());

		msg = "정상처리 되었습니다.";

		return msg;
	}

}
