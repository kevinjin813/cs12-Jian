package PA5;
import java.util.Random;
public class Skeptic extends Person {
	 private Random random = new Random();
	public void tick() {
	    this.tryToMove();
	   
		}

	  void tryToMove(){
			tryToMoveRandomly();
		}
	  /**
		   try to move one step in a random direction.
			 if they way is blocked then don't move.
		*/
	  void tryToMoveRandomly(){
	    int dx = random.nextInt(3)-1; 
	    int dy = random.nextInt(3)-1; 
	    if(dx==0 && dy==0) {
	    	tryToMove();
	    }
	    if (isOK(this.x+dx, this.y+dy,this.country)) {
	      this.moveTo(this.x+dx, this.y+dy);
	    }
	   
	  }
		
	
		/**
		this tests to see if the position (a,b) is on the grid
		for the country and if it has the value null, so that
		a Person could move there.
		*/
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
