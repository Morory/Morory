package basAnno;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("histDao")
public class HistDAO {
	
	@Autowired
	SqlSessionTemplate myBatis;
	
	public void insertHist(String contents) throws Exception {
		myBatis.insert("histDao.insertHist", contents);
	}
	
	

}
