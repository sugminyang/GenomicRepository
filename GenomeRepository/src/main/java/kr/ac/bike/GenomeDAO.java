package kr.ac.bike;

import java.util.List;

public interface GenomeDAO {
	List<PatientVO> selectAllData();
	List<PatientVO> selectPhenotype(String phenotype);

}
