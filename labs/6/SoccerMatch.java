public class SoccerMatch {
	private String startTime;
	private String endTime;
	private String location;
	private String home;
	private String visitor;
	private Player[] homePlayers = new Player[11];
	private Player[] visitorPlayers = new Player[11];
	private Goal[] homeGoals = new Goal[10];
	private Goal[] visitorGoals = new Goal[10];
	private int homePlayerIndex;
	private int visitorPlayerIndex;
	private int homeGoalIndex;
	private int visitorGoalIndex;
	
	public SoccerMatch(){
		
	}
	
	public SoccerMatch(String startTime, String home, String visitor, String location) {
		this.startTime = startTime;
		this.home = home;
		this.visitor = visitor;
		this.location = location;
	}
	
	public void addHomePlayer(Player p) {
		this.homePlayers[homePlayerIndex] = p;
		homePlayerIndex++;
	}
	
	public void addVisitorPlayer(Player p) {
		this.visitorPlayers[visitorPlayerIndex] = p;
		visitorPlayerIndex++;
	}
	
	public String getWinner() {
		return ((homeGoalIndex > visitorGoalIndex) ? home : visitor);  
	}
	
	public void addHomeGoal(Goal g) {
		this.homeGoals[homeGoalIndex] = g;
		homeGoalIndex++;
	}
	
	public void addVisitorGoal(Goal g) {
		this.visitorGoals[visitorGoalIndex] = g;
		visitorGoalIndex++;
		
	}
	
	public Goal[] getHomeGoal() {
		return homeGoals;
	}
	
	public Goal[] getVisitorGoal() {
		return visitorGoals;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getLocation() {
		return location;
	}

	public String getHome() {
		return home;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getHomeGoalIndex() {
		return homeGoalIndex;
	}

	public int getVisitorGoalIndex() {
		return visitorGoalIndex;
	}
}