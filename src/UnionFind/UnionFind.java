package UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionFind {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    UnionFind(int n)
    {
        for(int i=0;i<n;i++)
        {
            rank.add(0);
            parent.add(i);     // In constructor assign the number of node that we need : )
        }
    }
    public int findPar(int node)
    {
        if(node==parent.get(node)) // We need to find the parent of the node for that we need to check already recorded parent in its index..if the node and parent is same return the node itself
        {
            return node;
        }
        int ultPar=findPar(parent.get(node)); // else make a recursive call to find the parent (it's act like an chain)
        parent.set(node,ultPar); // update the node's parent
        return parent.get(node); // get the parent of the node in list and return
    }
    public void union(int u,int v)
    {
        int u_ultPar=findPar(u); // to make union we need to find the ultimate parent of node U and v
        int v_ultPar=findPar(v);
        if(u_ultPar==v_ultPar) // if it's same so they both have same parent no need to make connection because it's already in same set
            return;
        if(rank.get(u_ultPar)<rank.get(u_ultPar)) // 1) if the rank of ultimate parent of U is lesser that rank of ultimate parent of V we need to merge the U's ultimate parent into V's ultimate parent
        {
            parent.set(u_ultPar,v_ultPar);
        }
        else if(rank.get(u_ultPar)>rank.get(u_ultPar))// 2) [ do the opposite here ]
        {
            parent.set(v_ultPar,u_ultPar);
        }
        else
        {
            parent.set(u_ultPar,v_ultPar); // if it's same merge anything into anyone of them
            int inc=rank.get(u_ultPar); // and set the rank+1
            rank.set(u_ultPar,inc++);
        }
    }
    public static void main(String args[])
    {
        UnionFind uf=new UnionFind(7);
        uf.union(0,0);
        uf.union(5,6);
        uf.union(1,2);
        if(uf.findPar(1)== uf.findPar(2))
        {
            System.out.println("They are in same set");
        }
        else
        {
            System.out.println("The are in diff set");
        }
    }
}
