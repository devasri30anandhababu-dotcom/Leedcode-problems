class Solution {
    public int islandPerimeter(int[][] grid) {
        Queue<int []>q=new LinkedList<>();
        int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
        int start=-1;
        int end=-1;
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    start=i;
                    end=j;
                    c++;
                    break;
                }
            }
            if(c!=0)
            {
                break;
            }
        }
        if(start==-1||end==-1)
        {
            return -1;
        }
        q.add(new int[]{start,end});
        boolean hp[][]=new boolean[grid.length][grid[0].length];
        int perimeter=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int curr[]=q.poll();
                int x=curr[0];
                int y=curr[1];
                hp[x][y]=true;
                for(int j=0;j<4;j++)
                {
                    int xt=dir[j][0]+x;
                    int yt=dir[j][1]+y;
                    if(xt<0||xt>=grid.length||yt<0||yt>=grid[0].length||grid[xt][yt]==0)
                    {
                        perimeter++;
                    }
                    if(xt>=0&&xt<grid.length&&yt>=0&&yt<grid[0].length&&grid[xt][yt]==1&&!hp[xt][yt])
                    {
                        q.add(new int[]{xt,yt});
                        hp[xt][yt]=true;
                    }
                }
            }
        }
        return perimeter;
    }
}
