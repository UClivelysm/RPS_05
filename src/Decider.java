public class Decider {

    /**
     *
     * @param playerMove
     * @param computerMove
     * @param computerMode
     * @return
     */
    public static String PickWinner(int playerMove, int computerMove, int computerMode) {
        String winner = "";
        String mode = "";
        String retString = "";


        if (computerMode == 1) {
            mode = ", Random)\n";
        } else if (computerMode == 2) {
            mode = ", Last Used)\n";
        } else if (computerMode == 3) {
            mode = ", Cheat)\n";
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
            winner = "Paper Covers Rock! (CPU Wins";
        }
        if (playerMove == 1 && computerMove == 3) { //player rock, CPU Scissors
            winner = "Rock crushes Scissors! (Player Wins";
        }
        if (playerMove == 2 && computerMove == 1) { //player Paper, CPU Rock
            winner = "Paper Covers Rock! (Player Wins";
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


    /**
     *
     * @param playerMove
     * @param computerMove
     * @return
     */
    public static int PickWinnerLogic(int playerMove, int computerMove) {

/*
0 = draw
1 = player
2 = CPU
 */
        int winner = 1;
        if (playerMove == 1 && computerMove == 1) { //player rock, CPU Rock
            winner = 0;
//            return 0;
        }
        if (playerMove == 1 && computerMove == 2) { //player rock, CPU Paper
            winner = 2;
//            return 2;
        }
        if (playerMove == 1 && computerMove == 3) { //player rock, CPU Scissors
            winner = 1;
//            return 1;
        }
        if (playerMove == 2 && computerMove == 1) { //player Paper, CPU Rock
            winner = 1;
//            return 1;
        }
        if (playerMove == 2 && computerMove == 2) { //player Paper, CPU Paper
            winner = 0;
//            return 0;
        }
        if (playerMove == 2 && computerMove == 3) { //player Paper, CPU Scissors
            winner = 2;
//            return 2;
        }
        if (playerMove == 3 && computerMove == 1) { //player Scissors, CPU Rock
            winner = 2;
//            return 2;
        }
        if (playerMove == 3 && computerMove == 2) { //player Scissors, CPU Paper
            winner = 1;
//            return 1;
        }
        if (playerMove == 3 && computerMove == 3) { //player Scissors, CPU Scissors
            winner = 0;
//            return 0;
        }
        return winner;

    }

}
