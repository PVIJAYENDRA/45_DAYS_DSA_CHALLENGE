// Brute Force using extra space

// class Solution {
//     public int compareVersion(String version1, String version2) {
//         String[] v1 = version1.split("\\.");
//         String[] v2 = version2.split("\\.");
//         int i=0, j=0;
        
//         while( i<v1.length || j <v2.length ){
//             int a,b;
            
//             if(i >= v1.length){
//                 a = 0;
//             }else{
//                 a = Integer.parseInt(v1[i]);
//             }
//             if(j >= v2.length){
//                 b = 0;
//             }else{
//                 b = Integer.parseInt(v2[j]);
//             }
            
//             if(a < b){
//                 return -1;
//             }else if(a > b){
//                 return 1;
//             }
            
//             i++; j++;
//         }
        
//         return 0;
//     }
// }



// without extra space by process upto dot
class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        
        while (i < n || j < m) {
            int a = 0, b = 0;
            
            // Parse next integer from version1
            while (i < n && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i) - '0');
                i++;
            }
            
            // Parse next integer from version2
            while (j < m && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j) - '0');
                j++;
            }
            
            if (a < b) return -1;
            if (a > b) return 1;
            
            // skip the '.' separator
            i++;
            j++;
        }
        
        return 0;
    }
}
