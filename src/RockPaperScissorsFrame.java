import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * A JFrame subclass program for playing the game Rock Paper Scissors.
 */
public class RockPaperScissorsFrame extends JFrame {

    // Keep track of three previous moves
    int firstLastMove = 0;
    int secondLastMove = 0;
    int thirdLastMove = 0;

    // Keep track of wins, losses, and draws
    int wins = 0;
    int losses = 0;
    int draws = 0;


    // Randomizer for bot mode selection
    Random modeChooser = new Random();

    // Main elements of application
    JPanel mainPnl;
    JPanel statsPnl;  // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    // Win/Loss/Draw counters
    JTextField winCountTF;
    JTextField lossCountTF;
    JTextField drawCountTF;

    // Player choice button images
    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

    // Player choice input buttons
    JButton playRockBtn;
    JButton playPaperBtn;
    JButton playScissorsBtn;

    // Quit button
    JButton quitBtn;


    /**
     *
     * Creates the main layout of the RockPaperScissorsFrame program.
     */
    public RockPaperScissorsFrame()
    {



        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle("Rock Paper Scissors");

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        // Logic to set the size and position of the window
        setSize((screenWidth / 4) *3, (screenHeight / 4) *3);
        setLocation(screenWidth / 8, screenHeight / 8);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Create StatsPanel with the JTextField counters for Wins/Losses/Draws.
     */
    private void createStatsPanel()
    {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3, 1));

        winCountTF = new JTextField("Wins: " + wins);
        winCountTF.setEditable(false);
        winCountTF.setHorizontalAlignment(JTextField.CENTER);
        winCountTF.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));

        lossCountTF = new JTextField("Losses: " + losses);
        lossCountTF.setEditable(false);
        lossCountTF.setHorizontalAlignment(JTextField.CENTER);
        lossCountTF.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));

        drawCountTF = new JTextField("Draws: " + draws);
        drawCountTF.setEditable(false);
        drawCountTF.setHorizontalAlignment(JTextField.CENTER);
        drawCountTF.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));

        statsPnl.add(winCountTF);
        statsPnl.add(lossCountTF);
        statsPnl.add(drawCountTF);
    }

    /**
     * Create the DisplayPanel element with the JTestArea within a JScrollPane.
     */
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(30, 86);
        displayTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));


        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    /**
     * Create the ControlPanel with the four buttons Rock, Paper, Scissors, and Quit within a solid border within padding.
     */
    private void createControlPanel()
    {




        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        rockIcon = new ImageIcon("src/rock.png");
        playRockBtn = new JButton(rockIcon);
        playRockBtn.addActionListener((ActionEvent ae) ->
        {

            // Set the move being played for the Rock button
            int playerMove = 1;
            int botOut = 0;
            String winner = "";
            int winnerLogic;

            // currentMode is a random int between 1-10
            // if currentMode = 3 then the bot will cheat, the rest are evenly divided between the other modes but random has an extra chance
            int currentMode = modeChooser.nextInt(10) + 1;
            if(currentMode == 1 || currentMode == 6 || currentMode == 10) { // Random
                botOut = ComputerPlayer.ModeOne();
                currentMode = 1;

            } else if (currentMode == 2 || currentMode == 7) { // Last Move
                botOut = ComputerPlayer.ModeTwo(firstLastMove);
                currentMode = 2;

            } else if (currentMode == 3) { // Cheat
                botOut = ComputerPlayer.ModeThree(playerMove);
                currentMode = 3;

            } else if (currentMode == 4 || currentMode == 8) { // Most Used
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 4;

            } else if (currentMode == 5 || currentMode == 9) { // Least Used
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 5;

            }

            // Call Decider.java to discover the winner and get the correct string to be printed
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            // Call Decider.java to get a numeric winner value to increment the Win/Loss/Draw counters and update the JTextFields
            winnerLogic = Decider.PickWinnerLogic(playerMove, botOut);
            if (winnerLogic == 1){
                wins++;
                winCountTF.setText("Wins: " + wins);
            }
            if (winnerLogic == 2){
                losses++;
                lossCountTF.setText("Losses: " + losses);
            }
            if (winnerLogic == 0){
                draws++;
                drawCountTF.setText("Draws: " + draws);
            }



            // Shuffle the previous moves data and update the last move to be the current move
            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });

        paperIcon = new ImageIcon("src/paper.png");
        playPaperBtn = new JButton(paperIcon);
        playPaperBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playPaperBtn.setIcon(paperIcon);
        playPaperBtn.addActionListener((ActionEvent ae) ->
        {

            // Set the move being played for the Paper button
            int playerMove = 2;
            int botOut = 0;
            String winner = "";
            int winnerLogic;



            // currentMode is a random int between 1-10
            // if currentMode = 3 then the bot will cheat, the rest are evenly divided between the other modes but random has an extra chance
            int currentMode = modeChooser.nextInt(10) + 1;
            if(currentMode == 1 || currentMode == 6 || currentMode == 10) { // Random
                botOut = ComputerPlayer.ModeOne();
                currentMode = 1;

            } else if (currentMode == 2 || currentMode == 7) { // Last Move
                botOut = ComputerPlayer.ModeTwo(firstLastMove);
                currentMode = 2;

            } else if (currentMode == 3) { // Cheat
                botOut = ComputerPlayer.ModeThree(playerMove);
                currentMode = 3;

            } else if (currentMode == 4 || currentMode == 8) { // Most Used
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 4;

            } else if (currentMode == 5 || currentMode == 9) { // Least Used
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 5;

            }

            // Call Decider.java to discover the winner and get the correct string to be printed
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            // Call Decider.java to get a numeric winner value to increment the Win/Loss/Draw counters and update the JTextFields
            winnerLogic = Decider.PickWinnerLogic(playerMove, botOut);
            if (winnerLogic == 1){ // Player win
                wins++;
                winCountTF.setText("Wins: " + wins);
            }
            if (winnerLogic == 2){ // Bot Win
                losses++;
                lossCountTF.setText("Losses: " + losses);
            }
            if (winnerLogic == 0){ // Draw
                draws++;
                drawCountTF.setText("Draws: " + draws);
            }


            // Shuffle the previous moves data and update the last move to be the current move
            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });


        scissorsIcon = new ImageIcon("src/scissors.png");
        playScissorsBtn = new JButton(scissorsIcon);
        playScissorsBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playScissorsBtn.addActionListener((ActionEvent ae) ->
        {

            // Set the move being played for the Scissors button
            int playerMove = 3;
            int botOut = 0;
            String winner = "";
            int winnerLogic;



            // currentMode is a random int between 1-10
            // if currentMode = 3 then the bot will cheat, the rest are evenly divided between the other modes but random has an extra chance
            int currentMode = modeChooser.nextInt(10) + 1;
            if(currentMode == 1 || currentMode == 6 || currentMode == 10) { // Random
                botOut = ComputerPlayer.ModeOne();
                currentMode = 1;

            } else if (currentMode == 2 || currentMode == 7) { // Last Move
                botOut = ComputerPlayer.ModeTwo(firstLastMove);
                currentMode = 2;

            } else if (currentMode == 3) { // Cheat
                botOut = ComputerPlayer.ModeThree(playerMove);
                currentMode = 3;

            } else if (currentMode == 4 || currentMode == 8) { // Most Used
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 4;

            } else if (currentMode == 5 || currentMode == 9) { // Least Used
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);
                currentMode = 5;

            }

            // Call Decider.java to discover the winner and get the correct string to be printed
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            // Call Decider.java to get a numeric winner value to increment the Win/Loss/Draw counters and update the JTextFields
            winnerLogic = Decider.PickWinnerLogic(playerMove, botOut);
            if (winnerLogic == 1){
                wins++;
                winCountTF.setText("Wins: " + wins);
            }
            if (winnerLogic == 2){
                losses++;
                lossCountTF.setText("Losses: " + losses);
            }
            if (winnerLogic == 0){
                draws++;
                drawCountTF.setText("Draws: " + draws);
            }


            // Shuffle the previous moves data and update the last move to be the current move
            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });



        // Create the quit button
        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(playRockBtn);
        controlPnl.add(playPaperBtn);
        controlPnl.add(playScissorsBtn);
        controlPnl.add(quitBtn);

        // Create padding around the buttons, then a solid border around the buttons, hen some more padding around the border
        int boarderPadding = 10;
        EmptyBorder paddingBorder = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        LineBorder lineBorder = new LineBorder(Color.BLACK);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, paddingBorder);
        EmptyBorder outerPadding = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        CompoundBorder compoundBorder2 = new CompoundBorder(outerPadding, compoundBorder);

        controlPnl.setBorder(compoundBorder2);

    }

}