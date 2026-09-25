class Solution {
    int index = 0;
    public String decodeString(String s) {
        return solve(s);
    }
    String solve(String s){
        StringBuilder result = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']'){
            char ch = s.charAt(index);

            if(Character.isLetter(ch)){
                result.append(ch);
                index++;
            }
            else{
                int num = 0;
                while(Character.isDigit(s.charAt(index))){
                    num = num*10 + (s.charAt(index)-'0');
                    index ++;
                }
                index++;
                String inside = solve(s);
                index++;
                for(int i=0; i<num; i++){
                    result.append(inside);
                }

            }
        } 
        return result.toString();
    }
}