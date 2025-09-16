package takeyoufwd.basicmath;

public class FindMissingNum0toN {
    void main(){
        int[] a={3,1,4,2,7,5}; // missing 6
        find1(a);   // good approach but O(2n)
        find2(a);   // better approach but integer overflow chances
        find3(a);   // xor approach, most optimal one, because no multiplication and integer overflow
    }

    void find1(int[] a){
        int[] hash = new int[a.length+2];
        int j;
        for (int i=0;i<a.length;i++){
            j=a[i];
            hash[j]=1;
        }
        for (int i=1;i<hash.length;i++)
            if(hash[i]==0) System.out.println(i);
    }

    private void find2(int[] a) {
        int currSum=0;
        for (int i:a)
            currSum+=i;

        int n = a.length+1;
        int sum = (n*(n+1))/2;      // sum of N element formula
        System.out.println(sum-currSum);
    }

    private void find3(int[] a){
        int xor1=0;
        for (int i:a)
            xor1^=i;
        int n = a.length+1;
        int xor2=0;
        for (int i=0;i<=n;i++)
            xor2^=i;

        System.out.println(xor1^xor2);
    }
}
