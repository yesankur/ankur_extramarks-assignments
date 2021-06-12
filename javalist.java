import java.util.ArrayList;
import java.util.Scanner;

public class javalist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			arr.add(sc.nextInt());
		}
		
		int itr = sc.nextInt();
		for (int i = 0; i < itr; i++) {
			String iString = sc.next();
			if (iString.equals("Insert")) {
				int index = sc.nextInt();
				int v = sc.nextInt();
				arr.add(index, v);

			} else {
				int index = sc.nextInt();
				arr.remove(index);
			}
		}
		sc.close();
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}
}