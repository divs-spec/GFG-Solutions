class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length/2; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[i][mat.length - 1 - j];
                mat[i][mat.length - 1 - j] = tmp;
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = i+1; j < mat.length; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }
}
