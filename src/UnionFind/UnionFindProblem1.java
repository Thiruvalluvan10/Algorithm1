package UnionFind;

import java.util.ArrayList;
import java.util.List;

//990.Satisfiability of Equality Equations
public class UnionFindProblem1 {
        class Uf{

            List<Integer> l=new ArrayList<>();
            List<Integer> rank=new ArrayList<>();
            Uf()
            {
                for(int i=0;i<26;i++)
                {
                    l.add(i);
                    rank.add(0);
                }
            }
            public int findPar(int num)
            {
                if(num==l.get(num))
                    return num;
                int ultPar=findPar(l.get(num));
                l.set(num,ultPar);
                return l.get(num);
            }
            public void union(int u,int v)
            {
                int upu=findPar(u);
                int vpu=findPar(v);
                if(upu==vpu)
                {
                    return;
                }
                if(rank.get(upu)<rank.get(vpu))
                {
                    l.set(upu,vpu);
                }
                else if(rank.get(upu)>rank.get(vpu))
                {
                    l.set(vpu,upu);
                }
                else
                {
                    l.set(upu,vpu);
                    int inc=rank.get(vpu);
                    inc++;
                    rank.set(vpu,inc);
                }
            }
        }
        public boolean equationsPossible(String[] eq) {

            Uf uf=new Uf();
            for(String str:eq)
            {
                if(str.charAt(1)=='=')
                {
                    int num1=(int)str.charAt(0)-'a';
                    int num2=(int)str.charAt(str.length()-1)-'a';
                    uf.union(num1,num2);
                }
            }
            for(String str:eq)
            {
                if(str.charAt(1)=='!')
                {
                    int num1=(int)str.charAt(0)-'a';
                    int num2=(int)str.charAt(str.length()-1)-'a';
                    if(uf.findPar(num1)==uf.findPar(num2))
                    {
                        return false;
                    }
                }
            }
            return true;
        }

}
