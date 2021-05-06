package crud;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public void insert(CustomerDTO dto) {
		myBatis.insert("cstDao.insert", dto);
	}
	
	public void delete(int code) {
		myBatis.delete("cstDao.delete", code);
	}
	
	public void update(CustomerDTO dto) {
		myBatis.update("cstDao.update", dto);
	}
	
	public CustomerDTO select(int code) {
		return myBatis.selectOne("cstDao.select", code);
	}
	
	public List<CustomerDTO> selectAll(int code) {
		return myBatis.selectList("cstDao.selectAll", code);
	}
	
	public void insertHist(String data) {
		myBatis.insert("histDao.insertHist", data);
	}
	
	public void commit() {
		myBatis.commit();
	}
	
	public void rollback() {
		myBatis.rollback();
	}

}
