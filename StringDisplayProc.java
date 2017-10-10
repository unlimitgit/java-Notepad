import java.util.List;
import java.util.ArrayList;

public class StringDisplayProc {
	
	public static String content, keyword;
	
	public static class ProcResult{
		public int returnCode;
		public String dispStr;    
	}
	

	// public static class ProcResultArray{
		// public List<ProcResult> searchFileResults = new ArrayList<String>();
	// }
	
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
				System.out.println(tempResult.dispStr);
				result.add(tempResult);
				content = content.substring(keyword.length(), content.length());
				pos = content.toLowerCase().indexOf(keyword.toLowerCase());
			} else if(pos == content.length()- keyword.length()) { // Keyword is in the end
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(0, pos);
				tempResult.returnCode = 1;
				System.out.println(tempResult.dispStr);
				result.add(tempResult);
				content = content.substring(pos+1,content.length()) ;
				pos = -1;
			} else {  // Keyword is in the middle
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(0, pos);
				tempResult.returnCode = 1;
				System.out.println(tempResult.dispStr);
				result.add(tempResult);
				
				tempResult = new ProcResult();
				tempResult.dispStr = content.substring(pos, pos+keyword.length());
				tempResult.returnCode = 4;
				System.out.println(tempResult.dispStr);
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
	

	public static void main(String[] args) {
		content = "mdam Test da";
		//content = "da";
		keyword = "da";
		List<ProcResult> test = new ArrayList<ProcResult>();
		test = keywordExtract(content, keyword);
		for (int i=0; i < test.size(); i++){
		//for (int i=0; i < 1; i++){
			System.out.println(i + ":" + test.get(i).dispStr + ":" + test.get(i).returnCode);
		}
		
		
		
        
	}
}