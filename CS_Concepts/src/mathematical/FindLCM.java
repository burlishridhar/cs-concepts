package mathematical;

import java.util.ArrayList;
import java.util.List;

public class FindLCM {

	public static void main(String[] args) {
		FindLCM f = new FindLCM();
		int m = 3 , n=9;
		System.out.println(f.findLCM(m, n));
		
	}
	
	public List<Integer> primes(int n){
			boolean[] nonPrime = new boolean[n+1];
			for(int i=2; i<=Math.sqrt(n); i++){
					if(!nonPrime[i])
							for(int j=i*2; j<=n; j+=i) nonPrime[j]=true;
					
			}
			List<Integer> primes = new ArrayList<Integer>();
			for(int i=2; i<=n; i++)
					if(!nonPrime[i]) primes.add(i);
			
			return primes;
	}

	public int findLCM(int m, int n){
		int q=1;
		List<Integer> primeList = primes(Math.min(m, n));
		for(Integer p: primeList){
				int a=1, b=1;
				while((m%(Math.pow(p, a)))==0) a++;
				while((n%(Math.pow(p, b)))==0) b++;
				q= (int) ( q * Math.pow(p, Math.max(--a, --b)) );
		}
		return q;
	}
}
