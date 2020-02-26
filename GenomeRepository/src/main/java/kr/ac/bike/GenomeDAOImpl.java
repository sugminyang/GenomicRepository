package kr.ac.bike;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ac.bike.other.DisgenetVO;

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
		System.out.println("Enter a dao.selectPhenotype("+phenotype+")");
		Map<String, String> map = new HashMap<String, String>();
		map.put("phenotype",phenotype);
		
		return sqlSession.selectList(Namespace+".selectPhenotype",map);
	}

	@Override
	public List<DisgenetVO> selectAllDisGeNet() {
		
		return sqlSession.selectList(Namespace+".selectAllDisGeNet");
	}

	@Override
	public List<DisgenetVO> isExistDisease(String diseaseCode) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("diseaseID",diseaseCode);
		
		return sqlSession.selectList(Namespace+".isExistDisease",map);
	}

	@Override
	public int insertDiseaseGenes(DisgenetVO vo) {
		
		return sqlSession.insert(Namespace+".insertDiseaseGenes",vo);
	}

	@Override
	public List<String> select100diseases() {
		return sqlSession.selectList(Namespace+".select100diseases");
	}

}
