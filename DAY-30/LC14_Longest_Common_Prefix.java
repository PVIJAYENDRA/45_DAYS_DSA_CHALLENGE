class Solution {
    public String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);

        String start = strs[0];
        String last = strs[strs.length-1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< Math.min(start.length(),last.length()); i++){
            if(start.charAt(i) == last.charAt(i)){
                sb.append(start.charAt(i));
            }
            else{
                return sb.toString();
            }
        }

        return sb.toString();

    }
}
