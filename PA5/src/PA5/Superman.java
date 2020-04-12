package PA5;

public class Superman extends Person {
	
	/**
	 * super fast recovery
	 */
	 void checkForInfection(){
		    if (this.exposed && ! this.infected) {
					this.infected = true;
					this.infectionTime = this.age;
				}
				this.age++;
				if (infected && !this.recovered && (this.age - this.infectionTime > this.recoveryTime)) {
					this.recovered = true;
				}
		  }
}
