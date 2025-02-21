import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;


public class RockPaperScissorsFrame extends JFrame {

    int firstLastMove = 0;
    int secondLastMove = 0;
    int thirdLastMove = 0; //ape method of remembering last move because ArrayLists gave annoying errors


    Random modeChooser = new Random();

    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton playRockBtn;
    JButton playPaperBtn;
    JButton playScissorsBtn;

    JButton quitBtn;





    public RockPaperScissorsFrame()
    {


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
// center frame in screen









        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize((screenWidth / 4) *3, (screenHeight / 4) *3);
        setLocation(screenWidth / 8, screenHeight / 8);
        //setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
//        icon = new ImageIcon("src/Wizard.png");
        titleLbl = new JLabel("Welcome to Rock paper scisors", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Ubuntu", Font.PLAIN, 36));
        // Obscure code to align the text to the Icon!
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 86);
        displayTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));


        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        playRockBtn = new JButton("Play Rock!");
        playRockBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playRockBtn.addActionListener((ActionEvent ae) ->
        {
            displayTA.append("You Played Rock!\n");



            int playerMove = 1;

            int currentMode = modeChooser.nextInt(5) + 1;
//            int currentMode = 5;
            if(currentMode == 1) {
                int botOut = ComputerPlayer.ModeOne();
                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Random)\n");
                    displayTA.append("Draw\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Random)\n");
                    displayTA.append("You Lose!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Random)\n");
                    displayTA.append("You Win!\n\n");
                }
            } else if (currentMode == 2) {
                int botOut = ComputerPlayer.ModeTwo(firstLastMove);
                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Last Used)\n");
                    displayTA.append("Draw\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Last Used)\n");
                    displayTA.append("You Lose!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Last Used)\n");
                    displayTA.append("You Win!\n\n");
                }
            } else if (currentMode == 3) {
                int botOut = ComputerPlayer.ModeThree(playerMove);
                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Cheat Sometimes)\n");
                    displayTA.append("Draw\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Cheat Sometimes)\n");
                    displayTA.append("You Lose!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Cheat Sometimes)\n");
                    displayTA.append("You Win!\n\n");
                }
            } else if (currentMode == 4) {
                int botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);
                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Most Used)\n");
                    displayTA.append("Draw\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Most Used)\n");
                    displayTA.append("You Lose!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Most Used)\n");
                    displayTA.append("You Win!\n\n");
                }
            } else if (currentMode == 5) {
                int botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);
                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Least Used)\n");
                    displayTA.append("Draw\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Least Used)\n");
                    displayTA.append("You Lose!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Least Used)\n");
                    displayTA.append("You Win!\n\n");
                }
            }

            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });

        playPaperBtn = new JButton("Play Paper!");
        playPaperBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playPaperBtn.addActionListener((ActionEvent ae) ->
        {
            displayTA.append("You Played Paper!\n");



            int playerMove = 2;

            int currentMode = modeChooser.nextInt(5) + 1;
//            int currentMode = 5;
            if(currentMode == 1) {
                int botOut = ComputerPlayer.ModeOne();

                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Random)\n");
                    displayTA.append("You Win\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Random)\n");
                    displayTA.append("Draw!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Random)\n");
                    displayTA.append("You Lose!\n\n");
                }
            } else if (currentMode == 2) {
                int botOut = ComputerPlayer.ModeTwo(firstLastMove);

                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Last Used)\n");
                    displayTA.append("You Win\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Last Used)\n");
                    displayTA.append("Draw!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Last Used)\n");
                    displayTA.append("You Lose!\n\n");
                }
            } else if (currentMode == 3) {
                int botOut = ComputerPlayer.ModeThree(playerMove);

                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Cheat Sometimes)\n");
                    displayTA.append("You Win\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Cheat Sometimes)\n");
                    displayTA.append("Draw!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Cheat Sometimes)\n");
                    displayTA.append("You Lose!\n\n");
                }
            } else if (currentMode == 4) {
                int botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);

                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Most Used)\n");
                    displayTA.append("You Win\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Most Used)\n");
                    displayTA.append("Draw!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Most Used)\n");
                    displayTA.append("You Lose!\n\n");
                }
            } else if (currentMode == 5) {
                int botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);

                if (botOut == 1) {
                    displayTA.append("Computer Played Rock! (Least Used)\n");
                    displayTA.append("You Win\n\n");
                } else if (botOut == 2) {
                    displayTA.append("Computer Played Paper! (Least Used)\n");
                    displayTA.append("Draw!\n\n");
                } else {
                    displayTA.append("Computer Played Scissors! (Least Used)\n");
                    displayTA.append("You Lose!\n\n");
                }
            }

            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });




        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Thin", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(playRockBtn);
        controlPnl.add(playPaperBtn);
        controlPnl.add(quitBtn);

    }

}