import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wins = 0;
        int losses = 0;
        int draws = 0;
        String[] rounds = new String[5];
        for (int i = 0; i < 5; i++) {
            String playerMove = sc.next();
            int r = (int)(Math.random() * 3);
            String computerMove = "";
            if(r == 0) computerMove = "Rock";
            else if(r == 1) computerMove = "Paper";
            else computerMove = "Scissors";
            
            String result = playRound(playerMove, computerMove);
            if(result.equals("Player Wins")) wins++;
            else if(result.equals("Computer Wins")) losses++;
            else draws++;
            
            rounds[i] = "Round " + (i+1) + " | " + playerMove + " | " + computerMove + " | " + result;
        }
        for(int i=0; i<5; i++){
            System.out.println(rounds[i]);
        }
        double winPercentage = (wins * 100.0) / 5;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
    public static String playRound(String playerMove, String computerMove) {
        if(playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if(playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors") ||
           playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock") ||
           playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
