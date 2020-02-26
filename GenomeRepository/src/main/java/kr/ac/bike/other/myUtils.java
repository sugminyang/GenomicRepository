package kr.ac.bike.other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class myUtils {
	
	public static List<DisgenetVO> executeURLQuery(String url) throws IOException {
		BufferedReader in = null;
		List<DisgenetVO> voList = null;

		// call url
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection(); 
		con.setRequestMethod("GET");
		con.connect();
		try
		{
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			String line = in.readLine();
			voList = parserJSON(line);
		}
		catch(FileNotFoundException e)	{
			voList = null;
		}
		
		con.disconnect();
		return voList;
	}
	
	private static List<DisgenetVO> parserJSON(String jsonString)	{
		List<DisgenetVO> voList = new ArrayList<DisgenetVO>();
		System.out.println(jsonString);
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(jsonString);

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject object = (JsonObject) jsonArray.get(i);
			
			DisgenetVO vo = new DisgenetVO();
			
			String disease_name;	
			if(!object.get("disease_name").isJsonNull())	{
				disease_name = object.get("disease_name").getAsString();
			}
			else	{
				disease_name = "";
			}
			vo.setDisease_name(disease_name);
			
			String diseaseid;
			if(!object.get("diseaseid").isJsonNull())	{
				diseaseid = object.get("diseaseid").getAsString();
			}
			else	{
				diseaseid = "";
			}			
			vo.setDiseaseid(diseaseid);
			
			String gene_symbol;
			if(!object.get("gene_symbol").isJsonNull())	{
				gene_symbol = object.get("gene_symbol").getAsString();
			}
			else	{
				gene_symbol = "";
			}					
			vo.setGene_symbol(gene_symbol);
			
			double score;	
			if(!object.get("score").isJsonNull())	{
				score = object.get("score").getAsDouble();
			}
			else	{
				score = 0;
			}		
			vo.setScore(score);
			
			double ei;	
			if(!object.get("ei").isJsonNull())	{
				ei = object.get("ei").getAsDouble();
			}
			else	{
				ei = 0;
			}		
			vo.setEi(ei);
			
			String geneid;
			if(!object.get("geneid").isJsonNull())	{
				geneid = object.get("geneid").getAsString();
			}
			else	{
				geneid = "";
			}			
			vo.setGeneid(geneid);
			
			String protein_class;
			if(!object.get("protein_class").isJsonNull())	{
				protein_class = object.get("protein_class").getAsString();
			}
			else	{
				protein_class = "";
			}
			vo.setProtein_class(protein_class);
			
			double gene_dpi;
			if(!object.get("gene_dpi").isJsonNull())	{
				gene_dpi = object.get("gene_dpi").getAsDouble();
			}
			else	{
				gene_dpi = 0;
			}
			vo.setGene_dpi(gene_dpi );
			
			String disease_semantic_type;
			if(!object.get("disease_semantic_type").isJsonNull())	{
				disease_semantic_type = object.get("disease_semantic_type").getAsString();
			}
			else	{
				disease_semantic_type = "";
			}				
			vo.setDisease_semantic_type(disease_semantic_type );
			
			int year_final;
			if(!object.get("year_final").isJsonNull())	{
				year_final = object.get("year_final").getAsInt();
			}
			else	{
				year_final = 0;
			}
			vo.setYear_final(year_final);
			
			double gene_dsi;
			if(!object.get("gene_dsi").isJsonNull())	{
				gene_dsi = object.get("gene_dsi").getAsDouble();
			}
			else	{
				gene_dsi = 0;
			}
			vo.setGene_dsi(gene_dsi );
			
			String el;
			if(!object.get("el").isJsonNull())	{
				el = object.get("el").getAsString();
			}
			else	{
				el = "";
			}				
			vo.setEl(el);
			
			String protein_class_name;
			if(!object.get("protein_class_name").isJsonNull())	{
				protein_class_name = object.get("protein_class_name").getAsString();
			}
			else	{
				protein_class_name = "";
			}				
			vo.setProtein_class_name(protein_class_name );
			
			double gene_pli;
			if(!object.get("gene_pli").isJsonNull())	{
				gene_pli = object.get("gene_pli").getAsDouble();
			}
			else	{
				gene_pli = 0;
			}		
			vo.setGene_pli(gene_pli);
			
			String disease_class_name;
			if(!object.get("disease_class_name").isJsonNull())	{
				disease_class_name = object.get("disease_class_name").getAsString();
			}
			else	{
				disease_class_name = "";
			}							
			vo.setDisease_class_name(disease_class_name );
			
			String source;
			if(!object.get("source").isJsonNull())	{
				source = object.get("source").getAsString();
			}
			else	{
				source = "";
			}						
			vo.setSource(source);
			
			String uniprotid;
			if(!object.get("uniprotid").isJsonNull())	{
				uniprotid = object.get("uniprotid").getAsString();
			}
			else	{
				uniprotid = "";
			}				
			vo.setUniprotid(uniprotid);
			
			String disease_type;
			if(!object.get("disease_type").isJsonNull())	{
				disease_type = object.get("disease_type").getAsString();
			}
			else	{
				disease_type = "";
			}		
			vo.setDisease_type(disease_type );
			
			int year_initial;
			if(!object.get("year_initial").isJsonNull())	{
				year_initial = object.get("year_initial").getAsInt();
			}
			else	{
				year_initial = 0;
			}
			vo.setYear_initial(year_initial );
			
			String disease_class;
			if(!object.get("disease_class").isJsonNull())	{
				disease_class = object.get("disease_class").getAsString();
			}
			else	{
				disease_class = "";
			}					
			vo.setDisease_class(disease_class );
			
//			System.out.println(vo);
			voList.add(vo);
		}

		return voList;
	}
}
