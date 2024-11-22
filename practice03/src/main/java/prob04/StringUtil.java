package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		StringBuilder result = new StringBuilder("");
		for(int i=0; i<strArr.length; i++) {
			result.append(strArr[i]);
		}
		
		return result.toString();
		
//		String result ="";
//		for(String str: strArr) {
//			result += str;
//		}
//		return result;
	}
	
}
