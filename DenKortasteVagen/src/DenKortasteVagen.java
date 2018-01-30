class DenkortasteVagen 
{
	/*/
	 * mellanstationer returnerar en vektor med de mellanstationer som finns p�
	 * den kortaste v�gen. Ordningsnummer av den f�rsta mellanstationen
	 * finns p� index 1, och ordningsnummer av den andra mellanstationer
	 * p index 2 i vektorn.
	 */
// Mellanstationerna �r a, b, c. b �r en tv�dimensionell vektor
	public static String[] mellanstationer (double [] a, double [][] b, double [] c)
	{
		int m = a.length-1;  
		int n = c.length-1;
		
		double vaglangd = 0;
		
		double min = a[0] + b[0][0] + c[0];  // aktuella kortaste avst�ndet
		String[] mellanstationer = new String [2];
		
		String u = "U";
		String v = "V";
		int t = 0;
		int r = 0;
		for (int i = 0; i <= m; i++)
		{		
			for (int j = 0; j <= n; j++)
			{	
				vaglangd = a[i] + b[i][j] + c[j];
						
				if (vaglangd <= min) 
				{
					min = vaglangd;
					t = i + 1;
					r = j + 1;
					mellanstationer[0] = u + t;
					mellanstationer[1] = v + r;
				}
			}
		}
	return mellanstationer;	

	} 
	
	
	// Langd returnerar l�ngden av den kortaste v�gen.
	public static double langd (double[] a, double [][] b, double [] c)
	{
		int m = a.length - 1;
		int n = c.length - 1;
		
		double min = a[0] + b[0][0] + c[0];
		
		double vaglangd = 0;
		
			for (int i = 0; i<=m; i++)
			{
				for (int j = 0; j<= n;j++)
				{
					vaglangd = a[i] + b[i][j] + c[j];
					
					min = Math.min(min,  vaglangd); 
				}
			}
		
			return min; 
	  }
	}