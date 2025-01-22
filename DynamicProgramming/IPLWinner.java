package DynamicProgramming;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IPLWinner {
	public static void main(String[] args) {
		int[][] results = {
				{-1,1,-1,0},
				{-1,-1,-1,-1},
				{-1,1,-1,0},
				{-1,-1,1,-1},
		};
		
		int[] players = {2,1,0,3};
		System.out.println(findWinner(players, results));
	}
	
	public static int findWinner(int[] players, int[][] results) {

	  int valid = players.length%2==0?players.length/2:3;
	  if(valid%2!=0) {
	  	System.out.println("invalid list of players");
	    return -1;
	  }
	 List<Integer> p = Arrays.stream(players).boxed().collect(Collectors.toList());
	 List<Integer> winner = doMatches(p,results);
	  
	 return winner.get(0);

	}

	public static List<Integer> doMatches(List<Integer> players, int[][] results) {
	 List<Integer> winners = new LinkedList<>();
		
	 while(winners.size()!=1) {
		 winners = new LinkedList<>();
		 for(int i=0, j=1;i<players.size();i=i+2,j=j+2) {
				int player_i = players.get(i);
				int player_j = players.get(j);
		  	if(results[player_i][player_j]==1) winners.add(player_i);
		    else if(results[player_i][player_j]==0) winners.add(player_j);
		    else return null;
		  }
		 players = winners;
	 }
	  
	  return winners;
	}
}
