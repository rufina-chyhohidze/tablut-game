package be.kdg.tablut.presentation.ascii.input;
import java.util.Scanner;
public class LeaderBoardSearchManager {

    public static String getUsernameToSearchLeaderboard() {
        Scanner sc= new Scanner(System.in);
        System.out.print("-".repeat(60) + "\n" +
                "| Enter the name of a user to see them on the leaderboard! | \n" +
                "-".repeat(60) + "\n");
        return sc.nextLine();
    }

}
