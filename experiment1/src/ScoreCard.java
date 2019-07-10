
public class ScoreCard {
		private int win_time;
		private int lose_time;
		
		public ScoreCard() {
			// TODO Auto-generated constructor stub
			
			this.win_time = this.lose_time = 0;
		}
		
		public void setWin() {
			this.win_time++;
		}
		
		public void setLost() {
			this.lose_time++;
		}
		
		public int getWin() {
			return this.win_time;
		}
		
		public int getLose() {
			return this.lose_time;
		}
}
