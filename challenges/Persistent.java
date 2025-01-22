package challenges;

public class Persistent {
	static float i=2;
	public static void main(String[] args) {
		float j = i/0;
		System.out.println(j);
		System.out.println(Float.POSITIVE_INFINITY);
		j=0;
	}
}
