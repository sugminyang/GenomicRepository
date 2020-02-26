package kr.ac.bike;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.bike.other.DisgenetVO;
import kr.ac.bike.other.myUtils;
import net.sf.json.JSONArray;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private GenomeService genomeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Model model, HttpServletRequest request) {
		String type = request.getParameter("type[]");
		String text = request.getParameter("text[]");
		logger.info("phenotype: " +text);
		
		
		//		Service에 특정 business logic 함수 하나 호출.
		List<PatientVO> voList = null;
		if(type.equalsIgnoreCase("phenotype"))	{ //phenotype
			if(text.length() == 0)	{
				voList = genomeService.selectAllData();
			}
			else	{
				voList = genomeService.selectPhenotype(text);
			}
		}
		else	{	//geneSymbol
			if(text.length() != 0)	{
//				voList = genomeService.selectPatientByGene(text);
			}
		}
		
		//vo객체들을 json형태로 변경해서 view에 전달해야함 !!
		JSONArray jsonArray = null;
		jsonArray = JSONArray.fromObject(voList);
		logger.info("data: " + jsonArray);
		
		model.addAttribute("data", jsonArray);
		
		return "result";
	}
	
	@RequestMapping(value = "/disgenet", method = RequestMethod.GET)
	public String disgenet(Locale locale, Model model) {
		String diseaseCode = "C0011849"; //C0007131 : nsclc, dm: C0011849
		
//		String genes = genomeService.selectAllDisGeNet();
		
		//diseaseCode로 현재 table(disgenet_disease_genes)에 있는지 확인하고, 없으면 restfulAPI호출해서 데이터 insert.
		List<DisgenetVO> voList = genomeService.isExistDisease(diseaseCode);
		if(voList.size() == 0)	{
			String url = "https://www.disgenet.org/api/gda/disease/" + diseaseCode + "?min_score=0.5&format=json";
			//restful api call & print.
			List<DisgenetVO> tempList = null;
			
			try {
				tempList = myUtils.executeURLQuery(url);
				genomeService.insertDiseaseGenes(tempList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("unstored disease...");
			model.addAttribute("data",tempList);
		}
		else	{
			model.addAttribute("data",voList);
		}
		
		return "home";
	}
	
	
//	임시 URI로 disease name 100개에 대해서 disease-genes데이터 저장.
	@RequestMapping(value = "/disgenet2", method = RequestMethod.GET)
	public String disgenet2(Model model) {
		
//		diseaseCode 가져오기.
//		String diseaseCode = "C0011849"; //C0007131 : nsclc, dm: C0011849
		
		List<String> diseaseList = genomeService.select100diseases();
		for(String diseaseCode : diseaseList)	{
			System.out.println(diseaseCode);
			
			//diseaseCode로 현재 table(disgenet_disease_genes)에 있는지 확인하고, 없으면 restfulAPI호출해서 데이터 insert.
			List<DisgenetVO> voList = genomeService.isExistDisease(diseaseCode);
			if(voList.size() == 0)	{
				String url = "https://www.disgenet.org/api/gda/disease/" + diseaseCode + "?min_score=0.5&format=json";
				//restful api call & print.
				List<DisgenetVO> tempList = null;
				
				try {
					tempList = myUtils.executeURLQuery(url);
					genomeService.insertDiseaseGenes(tempList);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("unstored disease...");
				model.addAttribute("data",tempList);
			}
			else	{
				model.addAttribute("data",voList);
			}
			
		}
		
		return "home";
	}
}
