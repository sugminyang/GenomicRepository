package kr.ac.bike;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<PatientVO> selectPhenotype(String phenotype) {
		System.out.println("Enter a dao.selectAllData()");
		Map<String, String> map = new HashMap<String, String>();
		map.put("phenotype",phenotype);
		
		return sqlSession.selectList(Namespace+".selectPhenotype",map);
	}

}
