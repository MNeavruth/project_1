import java.util.*;
public class PrimsAlgorithm { 
public static void primMST(int[][] cost, int n) { 
int[] near = new int[n]; 
int[][] t = new int[n - 1][2]; 
int mincost = 0;
int k = -1, l = -1, min = 999;
for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (cost[i][j] < min && i != j) {
                min = cost[i][j];
                k = i;
                l = j;
            }
        }
    }
  	mincost += min;
           t[0][0] = k;
           t[0][1] = l;
           for (int i = 0; i < n; i++) {
                    if (cost[i][l] < cost[i][k])
            	near[i] = l;
        	         else
            	near[i] = k;
    }
    near[k] = near[l] = -1; 
    for (int i = 1; i < n - 1; i++) {
        int j = -1, minEdge = 999;
        for (int m = 0; m < n; m++) {
            if (near[m] != -1 && cost[m][near[m]] < minEdge) {
                minEdge = cost[m][near[m]];
                j = m;
            }
        }
        t[i][0] = j;
        t[i][1] = near[j];
        mincost += cost[j][near[j]];
        near[j] = -1;
        for (int m = 0; m < n; m++) {
            if (near[m] != -1 && cost[m][near[m]] > cost[m][j]) {
                near[m] = j;
            }
        }
    }
    System.out.println("Edges in MST:");
    for (int i = 0; i < n - 1; i++) {
        System.out.println(t[i][0] + " - " + t[i][1]);
  }
    System.out.println("Minimum Cost: " + mincost);
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of vertices: ");
    int n = sc.nextInt();
    int[][] cost = new int[n][n];
    System.out.println("Enter the cost adjacency matrix ");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cost[i][j] = sc.nextInt();
            if(cost[i][j]==0){
                cost[i][j]=999;
            }
        }
    }
    sc.close();
    
    primMST(cost, n);
}
}
