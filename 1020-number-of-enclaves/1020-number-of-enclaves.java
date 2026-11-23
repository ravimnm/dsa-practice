class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int visited[][]=new int[rows][cols];
        return dfs(grid, visited); 
    }
    int dfs(int[][] grid, int[][] visited){
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0 || i==rows-1 || j==cols-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nr<rows && nc<cols && nc>=0 && visited[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    visited[nr][nc]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}