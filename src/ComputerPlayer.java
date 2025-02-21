import java.util.Random;
public class ComputerPlayer {
    /*
    1 = rock
    2 = paper
    3 = scissors
     */

    //random return
    public static int ModeOne() {
        Random rand = new Random();
        return rand.nextInt(3) + 1; // This will generate a random number between 1 and 3 (inclusive)
    }

    //last used
    public static int ModeTwo(int playerLast) {
        if (playerLast != 0) {
            return playerLast;
        } else {
            return ModeOne();
        }
    }

    //cheat sometimes, else random
    public static int ModeThree(int playerCurrent) {
        Random rand = new Random();
        if (rand.nextInt(9) == 0) {
            if (playerCurrent == 1){
                System.out.println("oops, I cheated");
                return 2;
            } else if (playerCurrent == 2){
                System.out.println("oops, I cheated");
                return 3;
            } else if (playerCurrent == 3){
                System.out.println("oops, I cheated");
                return 1;
            } else {
                return ModeOne();
            }
        } else {
            return ModeOne();
        }
    }

    //most used
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
