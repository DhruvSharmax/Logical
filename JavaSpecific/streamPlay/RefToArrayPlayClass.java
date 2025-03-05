import JavaSpecific.ListOperations;

import java.util.Arrays;
import java.util.List;

void main(){
    List<Integer> list = Arrays.asList(2,3,4,3,4,10,20,2,4,1);
    List<Integer> list1 = Arrays.asList(2,3,4,5,7,-1);
    ListOperations.calculateSumStream(list,list1);
}
