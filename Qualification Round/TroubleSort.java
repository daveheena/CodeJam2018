package codejam2018;

import java.util.Scanner;

public class TroubleSort {
	public static int inspectSorting(int[] list) {
		int sort = -1;
		
		for(int i=0;i<list.length-1;i++) {
			if(list[i]>list[i+1]) {
				sort = i;
				break;
			}
		}
		
		return sort;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for(int i=1;i<=testCases;i++) {
			int N = Integer.parseInt(sc.nextLine());
			int[] array = new int[N]; 
			String[] line = sc.nextLine().split(" ");
			
			for(int j=0;j<N;j++) {
				array[j] = Integer.parseInt(line[j]);
				//System.out.println(array[j]);
			}
			boolean found = false;
			while(!found) {
				found = true;
				for(int j=0;j<N-2;j++) {
					if(array[j]>array[j+2]) {
						//System.out.println(array[j]+" : "+array[j+2]);
						found = false;
						int temp = array[j];
						array[j] = array[j+2];
						array[j+2] = temp;
						//System.out.println(array[j]+" : "+array[j+2]);
					}
				}
			}			
			int result = inspectSorting(array);
			if(result == -1) {
				System.out.println("Case #"+i+": OK");
			}
			else {
				System.out.println("Case #"+i+": "+result);
			}
		}
		sc.close();
	}

}
