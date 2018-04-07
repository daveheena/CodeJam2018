package codejam2018;

import java.util.Scanner;

public class SavingTheUniverse {
	public static int findTotalDamage(String P) {
		int totaldamage = 0;
		int charge = 1;
		for(int j=0;j<P.length();j++) {
			if(P.charAt(j)=='C') {
				charge *= 2;
			}
			else {
				totaldamage += charge;
			}
		}
		//System.out.println("totaldamage:"+totaldamage);
		return totaldamage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for(int i=1;i<=testCases;i++) {
			String input = sc.nextLine();
			int D = Integer.parseInt(input.split(" ")[0]);
			String P = input.split(" ")[1];
			
			if(P.indexOf('S')==-1) {
				System.out.println("Case #"+i+": 0");
			}
			else {
				int totaldamage = findTotalDamage(P);
				if(totaldamage <= D) {
					System.out.println("Case #"+i+": 0");
				}
				else {
					char[] array = new char[P.length()];
					array = P.toCharArray();
					int swap = 0;
					boolean found = false;
					int lasttotaldamage = 0;
					while(!found) {
						lasttotaldamage = totaldamage;
						int firstindex = new String(array).indexOf('S',new String(array).indexOf('C'));
						for(int j=firstindex-1;j>=0;j--) {
							if(array[j]=='C') {
								array[firstindex] = 'C';
								array[j] = 'S';
								totaldamage = findTotalDamage(new String(array));								
								swap++;
								break;
							}							
						}						
						if(totaldamage <= D) {
							System.out.println("Case #"+i+": "+swap);
							found = true;
						}
						else if(totaldamage == lasttotaldamage) {
							System.out.println("Case #"+i+": IMPOSSIBLE");
							found = true;
						}
					}
				}
			}
		}
		sc.close();
	}

}
