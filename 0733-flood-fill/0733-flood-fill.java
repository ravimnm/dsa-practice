class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        dfs(sr,sc,color,image,ans);
        return ans;
    }
    void dfs(int sr, int sc, int color, int[][] image, int[][] ans){
        int initCol=image[sr][sc];
        ans[sr][sc]=color;
        int rows=image.length;
        int cols=image[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=sr+dr[i];
            int nc=sc+dc[i];
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && image[nr][nc]==initCol && ans[nr][nc]!=color){
                dfs(nr,nc,color,image,ans);
            }
        }
    }
}