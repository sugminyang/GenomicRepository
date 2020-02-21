package kr.ac.bike;

import java.util.List;
import kr.ac.bike.other.DisgenetVO;

public interface GenomeDAO {
	List<PatientVO> selectAllData();
	List<PatientVO> selectPhenotype(String phenotype);
	List<DisgenetVO> selectAllDisGeNet();
	List<DisgenetVO> isExistDisease(String diseaseCode);
	int insertDiseaseGenes(DisgenetVO vo);

}
