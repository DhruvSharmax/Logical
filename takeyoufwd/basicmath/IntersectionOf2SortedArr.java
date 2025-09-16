package takeyoufwd.basicmath;
// find commons between both arrays (duplicates can be there)
public class IntersectionOf2SortedArr {
    void main(){
        int[] a={1,2,2,3,3,4,5},
              b={2,3,3,5,6,6,7};
        inter(a,b);
    }

    private void inter(int[] a, int[] b) {
        int i=0,j=0,k=0;
        int flen = a.length, slen = b.length;
        int[] inter=new int[flen + slen];
        while (i< flen && j< slen){
            if(a[i]<b[j]) i++;
            else if(b[j]<a[i]) j++;
            else {
                inter[k++]=a[i];
                i++;j++;
            }
        }
        for (i=0;i<k;i++) System.out.print(inter[i]);
    }
}
