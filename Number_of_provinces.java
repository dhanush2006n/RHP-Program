class Solution {
    public int find(int[] ldr,int node){
        if(ldr[node]==node){
            return node;
        }
        return ldr[node]=find(ldr,ldr[node]);
    }
    public void join(int[] ldr,int lt,int rt){
        int ldlt = find(ldr,lt);
        int ldrt = find(ldr,rt);
        ldr[ldrt]=ldlt;
    }
    public int findCircleNum(int[][] C) {
        int n = C.length;
        int[] ldr=new  int[n];
        for(int i=0;i<n;i++){
            ldr[i]=i;
        }
        for(int c=0;c<n;c++){
            for(int oc=0;oc<n;oc++){
                if(oc==c)continue;
                if(C[c][oc]==1) {
                    join(ldr,c,oc);
                }
            }

        }
        int c=0;
       for(int k=0;k<n;k++){
        if(ldr[k]==k){
            c+=1;
        }
       }
        return c;
    }
}
