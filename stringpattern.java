public class Solution{
	boolean isMatch(String str, String pattern){
		if(pattern.length() > str.length())	return false;
		if(patten.length() == 0)	return str.length() == 0;
		Map<Character, String> map = new HashMap<>();
		return isMatch(str, 0, pattern, 0, map);
	}

	boolean isMatch(String str, int iStr, String pattern, int pStr, Map<Character, String> map){
		if(iStr == str.length() && pStr == pattern.length())	return true;
		if(iStr == str.length() && pStr == pattern.length())	return false;
		char c = pattern.charAt(pStr);
		if(map.containsKey(c)){
			String target = map.get(c);
			for(int i = 0; i < target.length(); ++i){
				if(iStr + i > str.length() || str.charAt(iStr + i) != target.charAt(i))
					return false;
			}
			return isMatch(str, iStr + i, pattern, pStr + 1, map);
		}
		else{
			for(int i = iStr + 1; i < str.length(); ++i){
				String curr = str.substring(iStr, i);
				map.put(c, curr);
				if(isMatch(str, i, pattern, pStr + 1, map))
					return true;
				map.remove(c);
			}	
			return false;
		}
	}

	public static void main(String[] args){
		
		Solution sol = new Solution();
		
		if(sol.isMatch("redbluereadblue", "abab"))
			System.out.println("true");
		else
			System.out.println("false");
		
	}
}