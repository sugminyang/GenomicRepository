package kr.ac.bike.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class myUtils {
	public static List<DisgenetVO> executeURLQuery(String url) throws IOException {
		BufferedReader in = null;
		List<DisgenetVO>  listResult = new ArrayList<DisgenetVO>();
		// call url
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection(); 
		con.setRequestMethod("GET");

		con.connect();

		in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")); 
		String line = null; 
		boolean isHeader = true;
		
		while((line = in.readLine()) != null) { // response를 차례대로 출력 
			if(line.length() == 0)	{//split node description.
				break;
			}
			
			if(isHeader)	{
				isHeader = false;
				continue;
			}
			
			System.out.println(line);
			String[] items = line.split("\t");
			
			
			//개똥 순서.
			DisgenetVO vo = new DisgenetVO();
			vo.setScore( items[0]);
			vo.setGene_dsi( items[1]);
			vo.setDisease_name(items[2]);
			vo.setGene_symbol(items[3]);
			vo.setGene_dpi( items[4]);
			vo.setDiseaseid(items[5]);
			vo.setDisease_class(items[6]);
			vo.setEl(items[7]);
			vo.setProtein_class_name(items[8]);
			vo.setDisease_semantic_type(items[9]);
			vo.setGene_pli( items[10]);
			vo.setYear_initial( items[11]);
			vo.setEi( items[12]);
			vo.setUniprotid(items[13]);
			vo.setYear_final( items[14]);
			vo.setDisease_class_name(items[15]);
			vo.setGeneid(items[16]);
			vo.setSource(items[17]);
			vo.setProtein_class(items[18]);
			vo.setDisease_type(items[19]);
			
			listResult.add(vo);
		}

		con.disconnect();
		
		return listResult;
	}
}
