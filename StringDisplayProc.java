import java.util.List;
import java.util.ArrayList;

public class StringDisplayProc {
	
	public static String content, keyword, s1, s2;
	
	public static class ProcResult{
		public int returnCode;
		public String dispStr;    
	}
	
	//Extract Keyword
	public static List<ProcResult> 	keywordExtract(String content, String keyword){
		List<ProcResult> result = new ArrayList<ProcResult>();
		result.clear();		
		int pos = content.toLowerCase().indexOf(keyword.toLowerCase());
		ProcResult tempResult;
		while (pos != -1) {			// Find keyword			
			if (pos == 0) {			// Keyword is in the beginning
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(0, keyword.length());
				tempResult.returnCode = 4;
				result.add(tempResult);
				content = content.substring(keyword.length(), content.length());
				pos = content.toLowerCase().indexOf(keyword.toLowerCase());
			} else if(pos == content.length()- keyword.length()) { // Keyword is in the end
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(0, pos);
				tempResult.returnCode = 1;
				result.add(tempResult);
				content = content.substring(pos+1,content.length()) ;
				pos = -1;
			} else {  // Keyword is in the middle
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(0, pos);
				tempResult.returnCode = 1;
				result.add(tempResult);
				
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(pos, pos+keyword.length());
				tempResult.returnCode = 4;
				result.add(tempResult);
				content = content.substring(pos+keyword.length(), content.length());
				pos = content.toLowerCase().indexOf(keyword.toLowerCase());
			}
			
		}
		
		tempResult = new ProcResult();
		tempResult.dispStr = content + "ENDLINE";
		tempResult.returnCode = 1;
		result.add(tempResult);
		return result;
	}
	
	//Extract special characteritics, usaually the characteristics will be show up as a pair, such as "[" and "]"
	public static List<Integer>  specialCharFind(String content, String s1, String s2 ){
		List<Integer> result = new ArrayList<>();
		result.clear();
		
		int pos1 = content.toLowerCase().indexOf(s1.toLowerCase());
		int pos2 = content.toLowerCase().indexOf(s2.toLowerCase());
		
		if (pos1 < pos2) {			
			result.add(pos1);
			result.add(pos2);				
		}
		
		return result;
	}
	
	public static List<ProcResult> 	specialCharExtract(String content, String s1, String s2 ){
		List<ProcResult> result = new ArrayList<ProcResult>();
		result.clear();		
		ProcResult tempResult;
		
		List<Integer> resultPos = specialCharFind(content, s1, s2 );
		while (resultPos.size() > 0) {
			
			tempResult = new ProcResult();
			tempResult.dispStr = content.substring(0,resultPos.get(0));
			tempResult.returnCode = 1;
			result.add(tempResult);
			
			tempResult = new ProcResult();
			tempResult.dispStr = content.substring(resultPos.get(0), resultPos.get(0)+ s1.length());
			tempResult.returnCode = 2;
			result.add(tempResult);
			
			tempResult = new ProcResult();
			tempResult.dispStr = content.substring(resultPos.get(0)+ s1.length(), resultPos.get(1));
			tempResult.returnCode = 3;
			result.add(tempResult);
			
			tempResult = new ProcResult();
			tempResult.dispStr = content.substring(resultPos.get(1), resultPos.get(1)+ s2.length());
			tempResult.returnCode = 2;
			result.add(tempResult);
			
			content = content.substring(resultPos.get(1)+ s2.length(), content.length());
			resultPos = specialCharFind(content, s1, s2 );
			
		}
		
		tempResult = new ProcResult();
		tempResult.dispStr = content;
		tempResult.returnCode = 1;
		result.add(tempResult);
		
		return result;
	
		
		
		
	}
	

	public static void main(String[] args) {
		content = "m<h>dam Test da </h>c";
		//content = "da";
		keyword = "da";
		s1 = "<h>";
		s2 = "</h>";
		List<ProcResult> test = new ArrayList<ProcResult>();
		test = specialCharExtract(content, s1, s2);
		// test = keywordExtract(content, keyword);
		for (int i=0; i < test.size(); i++){
			System.out.println(test.get(i).dispStr + ":" + test.get(i).returnCode);
		}
		
		
		
        
	}
}