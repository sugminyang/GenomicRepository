package kr.ac.bike;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class GenomeService {

	@Inject GenomeDAO genomeDAO;
	
	public String selectAllData() {
//		List<String> say = genomeDAO.selectAllData();
		System.out.println("Enter a service.selectAllData()");
		
		String line = "";
		for(PatientVO vo : genomeDAO.selectAllData()) {
			line += vo.getSample() + ",";
		}
		
		line = line.substring(0,line.length()-1);
		return line;
	}
	
}
