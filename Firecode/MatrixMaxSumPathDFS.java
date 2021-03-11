// 1,2
// 3,4

// 1,2,3
// 4,5,6

// 1,2,3
// 4,5,6
// 7,8,9

public static int matrixMaxSumDfs(int[][] grid) 
    return maxSum(0,0,grid);
}

public static int maxSum(int i, int j, int[][]grid) { 
    int tempSum = 0;
    if(i==grid.length-1) {
        // can only move right
        for(int k=j; k<grid[0].length; k++) {
            tempSum = tempSum + grid[i][k];
        }

        return tempSum;
    }
 
    if(j==grid[0].length-1) {
        // can only move down
        for(int k=i; k<grid.length; k++){
            tempSum = tempSum +grid[k][j];
        }

        return tempSum;
    }
    
    return grid[i][j] + Math.max( maxSum(i, j+1, grid), maxSum(i+1, j, grid) );
}
