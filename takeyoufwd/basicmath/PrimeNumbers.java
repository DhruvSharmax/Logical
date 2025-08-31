package takeyoufwd.basicmath;

public class PrimeNumbers {
	public static void main(String[] args) {
		int num = 47;
		checkPrime(17);
		printPrimes(num);
		//IntStream.range(2, num).forEach(i->IntStream.range(2, i/2).filter(j->i%j==0).forEach(System.out::print));
	}

	private static void checkPrime(int num) {
		for (int i=2;i<Math.sqrt(num);i++){
			if (num%i==0){
				System.out.println(num+" is not prime");
				return;
			}
		}
		System.out.println(num+" is prime");
	}

	private static void printPrimes(int num) {
		boolean flag;
		for(int i = 2;i<=num;i++) {
			flag = true;
			for(int j = 2;j<i/2;j++)
				if(i%j==0) 
					flag = false;
			
			if(flag) 
				System.out.print(i+" ");
		}
	}
}