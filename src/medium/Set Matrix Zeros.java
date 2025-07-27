import java.util.*;

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        HashMap<Integer,Boolean> ht1 = new HashMap<>();
        HashMap<Integer,Boolean> ht2 = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    ht1.put(i,true);
                    ht2.put(j,true);
                }
            }
        }
        for(Integer r : ht1.keySet()){
            for(int i = 0; i < n; i++){
                mat[r][i] = 0;
            }
        }
        for(Integer col : ht2.keySet()){
            for(int i = 0; i < m; i++){
                mat[i][col] = 0;
            }
        }
    }
}
