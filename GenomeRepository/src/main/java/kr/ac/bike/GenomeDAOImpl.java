package kr.ac.bike;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class GenomeDAOImpl implements GenomeDAO {

	private static final String Namespace = "kr.ac.mappers.GenomeMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<PatientVO> selectAllData() {
		System.out.println("Enter a dao.selectAllData()");
		return sqlSession.selectList(Namespace+".selectAllData");
	}

}
