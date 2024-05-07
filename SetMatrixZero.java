//pblm link --> https://leetcode.com/problems/set-matrix-zeroes/description/
/*
Bhai dekho logic kya hai 
logic ye hai ki jo (row,col) pe value zero uske corresponding first row and first column ko 0 mark kardo and than 
iss example se samjho
    0   1  2
0  [1 , 1, 1]
1  [1 , 0, 1]
2  [1 , 1, 1]
yaha par dekho (1,1) pe value zero hai toh uske corresponding first row and first column ko zero mark kardo
that means matrix ab kuchh iss prakar dikhega

    0   1  2
0  [1 , 0, 1]
1  [0 , 0, 1]
2  [1 , 1, 1]
now simply entire matrix ko traverse karo and jab bhi (row,col) pe ho tab uss case mei check karo ki kya (row,0) yaa (0,col) 0 marked hai kya agar hai toh (row,col) ko bhi zero mark kardo

just hume edge case ko alag se leke chalna padega aur woh hai jab(0,0) wala grid already 0 hai
uss case mei problem ye hai ki uss (row,col) ke corressponding hume (row,0) yaa (0,col) nhi milega to mark 
so isiliye jaise hi (0,0) already 0 marked mila toh uss case mei usko alag se traverse karke 0 mark kardo
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        //ye 2 boolean variables isiliye bana rahe hai so that hum tackle kar paaye (0,0) marked 0 wala case bhi
        boolean firstRow = false;
        boolean firstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        firstRow = true;
                    }
                    if(j==0){
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //now marked 0 ko find karke uske corresponding entire row and column ko 0 mark kardo aap
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //now agar (0,0) bhi already 0 tha toh usko traverse krke 0 mark kardo
        if(firstRow){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(firstCol){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

    }
}
