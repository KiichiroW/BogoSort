import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static int length;
	static ArrayList<Integer> numberList = new ArrayList<Integer>();
	static boolean sorted = false;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the length of array");
		length = scan.nextInt();
		System.out.println("Enter entries");
		for (int i = 0; i < length; i++) {
			numberList.add(scan.nextInt());
		}

		int attempts = 0;
		while (!sorted) {
			int[] tempArray = bogoSort();

			String nums = "";
			for (int i = 0; i < length; i++) {
				nums += tempArray[i] + " ";
			}
			System.out.println("Attempt " + ++attempts + ": " + nums);

			checkList(tempArray);
		}

		System.out.println("SORTED!");
	}

	public static int[] bogoSort() {
		int[] randomizedList = new int[length];

		for (int i = 0; i < length; i++) {
			int randomIndexPos = (int) (Math.random() * numberList.size());
			randomizedList[i] = numberList.get(randomIndexPos);
			numberList.remove(randomIndexPos);
		}

		for (int i = 0; i < length; i++) {
			numberList.add(randomizedList[i]);
		}

		return randomizedList;
	}

	public static void checkList(int[] arr) {
		for (int i = 0; i < length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				sorted = false;
			} else {
				sorted = true;
			}

			if (sorted == false) {
				break;
			}
		}
	}
}
