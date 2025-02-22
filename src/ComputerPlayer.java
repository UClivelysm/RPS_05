import java.util.Random;

/**
 * This is the class file with the different computer strategies.
 */
public class ComputerPlayer {
    /*
    1 = rock
    2 = paper
    3 = scissors
     */

    //random return

    /**
     *
     * @return
     */
    public static int ModeOne() {
        Random rand = new Random();
        return rand.nextInt(3) + 1; // This will generate a random number between 1 and 3 (inclusive)
    }


    //last used

    /**
     *
     * @param playerLast
     * @return
     */
    public static int ModeTwo(int playerLast) {
        if (playerLast != 0) {
            return playerLast;
        } else {
            return ModeOne();
        }
    }


    //cheat sometimes

    /**
     *
     * @param playerCurrent
     * @return
     */
    public static int ModeThree(int playerCurrent) {
        Random rand = new Random();

        if (playerCurrent == 1){
            return 2;
        } else if (playerCurrent == 2){
            return 3;
        } else if (playerCurrent == 3){
            return 1;
        } else {
            return ModeOne();
        }

    }


    //most used

    /**
     *
     * @param firstLast
     * @param secondLast
     * @param thirdLast
     * @return
     */
    public static int ModeFour(int firstLast, int secondLast, int thirdLast) {
        //if rock(1) most, chose paper
        if ((firstLast == 1 && secondLast == 1) || (firstLast == 1 && thirdLast == 1) || (secondLast == 1 && thirdLast == 1)) {
            return 2;
        } else //if paper(2) most, choose scissors
            if ((firstLast == 2 && secondLast == 2) || (firstLast == 2 && thirdLast == 2) || (secondLast == 2 && thirdLast == 2)) {
            return 3;
        } else //if scissors(3) most, choose rock
            if ((firstLast == 3 && secondLast == 3) || (firstLast == 3 && thirdLast == 3) || (secondLast == 3 && thirdLast == 3)) {
            return 1;
        } else { //else return random
            return ModeOne();
        }
    }


    //least used

    /**
     *
     * @param firstLast
     * @param secondLast
     * @param thirdLast
     * @return
     */
    public static int ModeFive(int firstLast, int secondLast, int thirdLast) {
        //if rock(1) least, chose paper
        if (firstLast != 1 && secondLast != 1 && thirdLast != 1) {
            return 2;
        } else //if paper(2) least, chose paper
            if (firstLast != 2 && secondLast != 2 && thirdLast != 2) {
            return 3;
        } else //if scissors(3) least, chose paper
            if (firstLast != 3 && secondLast != 3 && thirdLast != 3) {
            return 3;
        } else { //else return random
            return ModeOne();
        }
    }


}
