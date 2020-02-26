package kr.ac.bike;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ac.bike.other.DisgenetVO;

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
		System.out.println("Enter a service.selectPhenotype()");
		List<PatientVO> voList = new ArrayList<PatientVO>();
		
		for(PatientVO vo : genomeDAO.selectPhenotype(phenotype)) {
			voList.add(vo);
		}
		
		return voList;
	}

	public String selectAllDisGeNet() {
		String genes = "";
		for(DisgenetVO vo: genomeDAO.selectAllDisGeNet())	{
			System.out.println(vo.getDisease_name() + ", " + vo.getGene_symbol());
			genes += vo.getGene_symbol() + ",";
		}
		genes = genes.substring(0,genes.length()-1);
		
		return genes;
		
	}

	public List<DisgenetVO> isExistDisease(String diseaseCode) {
		List<DisgenetVO> voList = genomeDAO.isExistDisease(diseaseCode);

		for(DisgenetVO vo : voList) {
			System.out.println(vo.getDiseaseid() + ",  " + vo.getGene_symbol());
		}
				
		return voList;
	}

	public void insertDiseaseGenes(List<DisgenetVO> tempList) {
		if(tempList == null)	{
			System.out.println("Error: data which are score >=0.5 is not existed.");
			return ;
		}
		
		for(DisgenetVO vo: tempList)	{
			if(genomeDAO.insertDiseaseGenes(vo) == 1)	{
				System.out.println("insert success");
			}
			else {
				System.out.println("Error: insert fail");
			}
		}
		
	}

	public List<String> select100diseases() {
		List<String> disList = genomeDAO.select100diseases();
				
		return disList;
	}
	
}
