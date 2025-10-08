package BITFLAG;
import java.util.*;

public class SudukuChecker {
    public static void main(String args[]){
            int[][] matrix = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };
        System.out.println(check(matrix));
    }

    public static boolean check(int[][] matrix){
        int[] rowFlag=new int[9];
        int[] columnFlag=new int[9];
        int[] boxFlag=new int[9];
        Arrays.fill(rowFlag,0);
        Arrays.fill(columnFlag,0);
        Arrays.fill(boxFlag,0);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int currElement=matrix[i][j];
                if(currElement==0) continue;

                int bit=1<<(currElement-1);

                if((rowFlag[i]&bit)!=0) return false;
                rowFlag[i]|=bit;

                if((columnFlag[j]&bit)!=0) return false;
                columnFlag[j]|=bit;

                int boxIndex=3*(i/3)+(j/3);
                if((boxFlag[boxIndex]&bit)!=0) return false;
                boxFlag[boxIndex]|=bit; 
            }
        }
        return true;
    }

}
