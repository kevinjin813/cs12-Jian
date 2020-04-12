package PA5;

import java.util.Random;

public class AnalyzeSimulation {
	// the maximum number of days the simulation will run
			private static int MAX_TICKS=1000;

			private Random random = new Random();

			public static void main(String[] args) {
				// first we get the simulation parameters
				// from the command line
				
				int width = Integer.parseInt(args[0]);
				int height = Integer.parseInt(args[1]);
				int numStayHome = Integer.parseInt(args[2]);
				int numEssential = Integer.parseInt(args[3]);
				int numSkeptic = Integer.parseInt(args[4]);
	            int numRepetition=Integer.parseInt(args[5]);
				// next we create the population and the country
				Population population;
				int[] newInfect=new int[numRepetition];
				int[] totalInfect=new int[numRepetition];
				int[] totalRecover=new int[numRepetition];
				int[] maxInfect=new int[numRepetition];
				for(int i=0;i<=numRepetition-1;i++)
				{
					population = new MixedPopulation(numStayHome, numEssential, numSkeptic);
					population.createPeople();
					int j=0;
					int max=0;
					Country country = new Country(width,height);
					// and add a link to the population in the country
					country.population = population;
					// next we place the people into the country randomly
					population.placePeople(country);
					for(int k=0;k<MAX_TICKS; k++) {
						country.simulateOneStep();
						if (country.numInfected==0) {
							break;
						}
						if(country.newInfected==0 && j==0)
						{
							newInfect[i]=k;
							j=1;
						}
						if(country.numInfected-country.numRecovered>max)
						{
							max=country.numInfected-country.numRecovered;
						}
					}
					totalInfect[i]=country.numInfected;
					totalRecover[i]=country.numRecovered;
					maxInfect[i]=max;
				}
				
				int k=0;
				int x=0;
				int y=0;
				int z=0;
				for(int i=0;i<=numRepetition-1;i++)
				{
					k=k+newInfect[i];
					x=x+totalInfect[i];
					y=y+totalRecover[i];
					z=z+maxInfect[i];
				}
				System.out.println("The average number of days it takes until there are no new infections: "+k/numRepetition);
				System.out.println("The average number of people infected: "+x/numRepetition);
				System.out.println("The average number of people recovered: "+y/numRepetition);
				System.out.println("The average number of maximum infected at any time: "+z/numRepetition);
				

			}
}
