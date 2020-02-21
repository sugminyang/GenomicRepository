package kr.ac.bike;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class GenomeService {

	@Inject GenomeDAO genomeDAO;
	
	public List<PatientVO> selectAllData() {
		System.out.println("Enter a service.selectAllData()");
		List<PatientVO> voList = new ArrayList<PatientVO>();
		
		for(PatientVO vo : genomeDAO.selectAllData()) {
			voList.add(vo);
		}
		
		return voList;
	}

	public List<PatientVO> selectPhenotype(String phenotype) {	
		List<PatientVO> voList = new ArrayList<PatientVO>();
		
		for(PatientVO vo : genomeDAO.selectPhenotype(phenotype)) {
			voList.add(vo);
		}
		
		return voList;
	}
	
}
