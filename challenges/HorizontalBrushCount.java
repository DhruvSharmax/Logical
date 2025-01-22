package challenges;

/*
* Problem statement: https://stackoverflow.com/questions/56373582/how-can-i-count-how-many-horizontal-brush-strokes-are-required-to-draw-an-array
*/
public class HorizontalBrushCount {
	public static void main(String[] args) {
		System.out.println(countBrushStrokes(new int[] {1,4,3,3,3,1}));
	}
	
	public static int countBrushStrokes(int[] A) {
        int output = 0;
        int prev = 0;
        for(int curr:A){
            if(curr>prev)
                output+=(curr-prev);
            prev=curr;
        }
        return output;
    }
}
