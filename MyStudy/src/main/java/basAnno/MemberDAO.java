package basAnno;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mbrDao")
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate myBatis;
	
	public void insert(MemberDTO dto) {
		myBatis.insert("mbrDao.insert", dto);
	}
	
	public void delete(String id) {
		myBatis.delete("mbrDao.delete", id);
	}
	
	public void update(MemberDTO dto) {
		myBatis.update("mbrDao.update", dto);
	}
	
	public MemberDTO select(String id) {
		return myBatis.selectOne("mbrDao.select", id);
	}
	
	public List<MemberDTO> selectAll() {
		return myBatis.selectList("mbrDao.selectAll");
	}
	
	public void commit() {
		myBatis.commit();
	}
	
	public void rollback() {
		myBatis.rollback();
	}

}
