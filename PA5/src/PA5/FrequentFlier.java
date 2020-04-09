package PA5;
import java.util.Random;
public class FrequentFlier extends Person {
	 Random random=new Random();
	void tryToMove(){
			tryToMoveRandomly();
		}
	  /**
		   try to move one step in a random direction.
			 if they way is blocked then don't move.
		*/
	  void tryToMoveRandomly(){
	    int dx = random.nextInt(this.country.places[0].length)-x; 
	    int dy = random.nextInt(this.country.places.length)-y; 
	    while (isOK(this.x+dx, this.y+dy,this.country)!=true) {
	    	dx = random.nextInt(this.country.places[0].length)-x;
	    	dy = random.nextInt(this.country.places.length)-y; 
	    }
	      this.moveTo(this.x+dx, this.y+dy);
	  
	  }
  

	void moveTo(int a, int b) {
			this.country.places[this.x][this.y]=null;
			if (this.country.places[a][b]!=null){
				throw new RuntimeException("a Person can't move to an occupied position.");
			}
			this.country.places[a][b] = this;
			this.x = a;
			this.y = b;
		}
	  
		boolean isOK(int a, int b,Country country) {
			if (a<0 || a>=country.places.length || b<0
					|| b>= country.places[0].length) {
				return false;
				
			}else if (country.places[a][b] !=null) {
				return false;
			}else {
				return true;
			}

		}

    

  }
