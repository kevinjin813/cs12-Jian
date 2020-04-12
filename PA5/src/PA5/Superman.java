package PA5;

import java.util.Random;
public class Superman extend Person {
	
	void checkForInfection(){
	    if (this.exposed && ! this.infected) {
				this.infected = true;
				this.infectionTime = this.age;
			}
			this.age++;
			if (infected && !this.recovered && (this.age - this.infectionTime > this.recoveryTime/2)) {
				this.recovered = true;
			}
	  }
}
