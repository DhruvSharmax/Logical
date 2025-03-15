package JavaSpecific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TakingInputs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Scanner input open:");
		System.out.println(sc.nextLine());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("BufferedReader input open:");
		try {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
