import java.util.Scanner;

public class BestamDenKortasteVagen {
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Hur många stationer finns i Z2?");
		int Z2 = in.nextInt();
		
		double[] a = new double [Z2]; 
		
		System.out.println("/nAnge alla väglängder mellan Z1 och Z2: ");
		for (int i = 0; i<Z2; i++)
			a[i] = in.nextDouble();		
		
		System.out.println("Hur många stationer finns i Z3?");
		int Z3 = in.nextInt();
		double[][] b = new double [Z2][Z3];
		
		System.out.println("/nAnge alla väglängder mellan Z2 och Z3: ");
		for (int i = 0; i<Z2; i++)
		{	
			for (int j = 0; j<Z3; j++)
				
				b[i][j] = in.nextDouble();
		}
		
		double[] c = new double[Z3];
		System.out.println("Ange alla väglängder mellan Z3 och Z4");
		for (int j = 0; j<Z3; j++)
			c[j] = in.nextDouble();
		
		String[] S = DenkortasteVagen.mellanstationer(a, b, c);
		double L = DenkortasteVagen.langd(a, b, c);
		
		System.out.println("/nMellanstationerna" + java.util.Arrays.toString(S) +
				           "ger den kortaste vägen som är: " + L + " l.e ");
		}
	}