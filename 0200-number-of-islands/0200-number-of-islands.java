class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        int[][] visited = new int[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='1' && visited[row][col]==0){
                    bfs(row,col,visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    void bfs(int row,int col, int[][] visited, char[][] grid){
        visited[row][col]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0,-1};

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0 && grid[nr][nc]=='1'){
                    visited[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}