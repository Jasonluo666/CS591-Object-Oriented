
public class ScoreCard {
	    //record how many times the player wins and loses
		private int win_time;
		private int lose_time;
		
		//constructor, initialize all attributes to zero 
		public ScoreCard() {
			this.win_time = this.lose_time = 0;
		}
		
		//set win times 
		public void setWin() {
			this.win_time++;
		}
		
		//set lose times 
		public void setLose() {
			this.lose_time++;
		}
		
		//get win times 
		public int getWin() {
			return this.win_time;
		}
		
		//get lose times 
		public int getLose() {
			return this.lose_time;
		}
}
