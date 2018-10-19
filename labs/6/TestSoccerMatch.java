public class TestSoccerMatch {

	public static void main(String[] args) {
		SoccerMatch match1 = new SoccerMatch("10/18/18 4:00PM","The Average Joes","The Purple Cobras","BBStadium");

		//creating players and adding them to the match
		Player joe = new Player("Joe", "The Average Joes");
		Player john = new Player("John", "The Average Joes");
		Player bill = new Player("Bill", "The Average Joes");
		Player joel = new Player("Joel", "The Average Joes");
		Player sammy = new Player("Sammy", "The Average Joes");
		
		Player jordan = new Player("Jordan", "The Purple Cobras");
		Player greg = new Player("Greg", "The Purple Cobras");
		Player jason = new Player("Jason", "The Purple Cobras");
		Player james = new Player("James", "The Purple Cobras");
		Player pat = new Player("Pat", "The Purple Cobras");
		
		match1.addHomePlayer(joe);
		match1.addHomePlayer(john);
		match1.addHomePlayer(bill);
		match1.addHomePlayer(joel);
		match1.addHomePlayer(sammy);
		
		match1.addVisitorPlayer(jordan);
		match1.addVisitorPlayer(greg);
		match1.addVisitorPlayer(jason);
		match1.addVisitorPlayer(james);
		match1.addVisitorPlayer(pat);
		
		//creating goals and adding the goals to the match
		Goal goal1 = new Goal();
		goal1.setMinute(3);
		goal1.setPlayer(joe);
		match1.addHomeGoal(goal1);
		
		Goal goal2 = new Goal();
		goal2.setMinute(10);
		goal2.setPlayer(sammy);
		match1.addHomeGoal(goal2);
		
		Goal goal3 = new Goal();
		goal3.setMinute(26);
		goal3.setPlayer(james);
		match1.addVisitorGoal(goal3);
		
		Goal goal4 = new Goal();
		goal4.setMinute(50);
		goal4.setPlayer(joe);
		match1.addHomeGoal(goal4);
		
		Goal goal5 = new Goal();
		goal5.setMinute(86);
		goal5.setPlayer(john);
		match1.addHomeGoal(goal5);
		
		Goal goal6 = new Goal();
		goal6.setMinute(89);
		goal6.setPlayer(jason);
		match1.addVisitorGoal(goal6);
		
		//Set end time
		match1.setEndTime("10/18/18 5:30PM");
		
		//Print everything
		System.out.print("Match Summary:\n\n" + "Match Start Time: " + match1.getStartTime() 
		+ "\n\nTeam Names: \n" + match1.getHome() + "\n" + match1.getVisitor() + "\n\nMatch Location:\n"
		+ match1.getLocation() + "\n\n" + match1.getHome() + " Goals:\n");
		
		for(int i = 0;i<match1.getHomeGoalIndex();i++) {
			Goal[] array = match1.getHomeGoal();
			System.out.println(array[i].getPlayer().getName() + " scored at minute " + array[i].getMinute());			
		}
		
		System.out.println("\n" + match1.getVisitor() + " Goals:");
		for(int i = 0;i<match1.getVisitorGoalIndex();i++) {
			Goal[] array = match1.getVisitorGoal();
			System.out.println(array[i].getPlayer().getName() + " scored at minute " + array[i].getMinute());
		}
		
		System.out.println("\nWinning Team:\n" + match1.getWinner() + "\n\nMatch End Time:\n" + match1.getEndTime());
	}

}