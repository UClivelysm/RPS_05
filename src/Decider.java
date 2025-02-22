public class Decider {
    public static String PickWinner(int playerMove, int computerMove, int computerMode) {
        String winner = "";
        String mode = "";
        String retString = "";


        if (computerMode == 1) {
            mode = ", Random)\n";
        } else if (computerMode == 2) {
            mode = ", Last Used)\n";
        } else if (computerMode == 3) {
            mode = ", Cheat Sometimes)\n";
        } else if (computerMode == 4) {
            mode = ", Most Used)\n";
        } else if (computerMode == 5) {
            mode = ", Least Used)\n";
        } else {
            mode = ", No Mode Specified)\n";
        }


        if (playerMove == 1 && computerMove == 1) { //player rock, CPU Rock
            winner = "Two Rocks Tie! (Draw";
        }
        if (playerMove == 1 && computerMove == 2) { //player rock, CPU Paper
            winner = "Paper Beats Rock! (CPU Wins";
        }
        if (playerMove == 1 && computerMove == 3) { //player rock, CPU Scissors
            winner = "Rock crushes Scissors! (Player Wins";
        }
        if (playerMove == 2 && computerMove == 1) { //player Paper, CPU Rock
            winner = "Paper Beats Rock! (Player Wins";
        }
        if (playerMove == 2 && computerMove == 2) { //player Paper, CPU Paper
            winner = "Two Papers Tie! (Draw";
        }
        if (playerMove == 2 && computerMove == 3) { //player Paper, CPU Scissors
            winner = "Scissors Cut Paper! (CPU Wins";
        }
        if (playerMove == 3 && computerMove == 1) { //player Scissors, CPU Rock
            winner = "Rock crushes Scissors! (CPU Wins";
        }
        if (playerMove == 3 && computerMove == 2) { //player Scissors, CPU Paper
            winner = "Scissors Cut Paper! (Player Wins";
        }
        if (playerMove == 3 && computerMove == 3) { //player Scissors, CPU Scissors
            winner = "Two Scissors Tie! (Draw";
        }

            retString = winner + mode;
        return retString;

    }

    public static int PickWinnerLogic(int playerMove, int computerMove) {

/*
0 = draw
1 = player
2 = CPU
 */

        if (playerMove == 1 && computerMove == 1) { //player rock, CPU Rock
            return 0;
        } else if (playerMove == 1 && playerMove == 2) { //player rock, CPU Paper
            return 2;
        } else if (playerMove == 1 && playerMove == 3) { //player rock, CPU Scissors
            return 1;
        } else if (playerMove == 2 && computerMove == 1) { //player Paper, CPU Rock
            return 1;
        } else if (playerMove == 2 && playerMove == 2) { //player Paper, CPU Paper
            return 0;
        } else if (playerMove == 2 && playerMove == 3) { //player Paper, CPU Scissors
            return 2;
        } else if (playerMove == 3 && computerMove == 1) { //player Scissors, CPU Rock
            return 2;
        } else if (playerMove == 3 && playerMove == 2) { //player Scissors, CPU Paper
            return 1;
        } else if (playerMove == 3 && playerMove == 3) { //player Scissors, CPU Scissors
            return 0;
        } else{
            return 0;
        }
    }
}
