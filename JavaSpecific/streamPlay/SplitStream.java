import java.util.stream.Collectors;
import java.util.stream.IntStream;

void main() {
    var result = IntStream.range(0,20).boxed()
            .collect(Collectors.partitioningBy(x->x%2==0));
    System.out.println(result);
}
