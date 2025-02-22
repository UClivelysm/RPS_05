import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;


public class RockPaperScissorsFrame extends JFrame {

    int firstLastMove = 0;
    int secondLastMove = 0;
    int thirdLastMove = 0; //ape method of remembering last move because ArrayLists gave annoying errors

    int wins;
    int losses;
    int draws;


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
        int boarderPadding = 10;
        EmptyBorder paddingBorder = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        LineBorder lineBorder = new LineBorder(Color.BLACK);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, paddingBorder);
        EmptyBorder outerPadding = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        CompoundBorder compoundBorder2 = new CompoundBorder(outerPadding, compoundBorder);



        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        playRockBtn = new JButton("Play Rock!");
        playRockBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playRockBtn.setIcon(new ImageIcon("Images/rock.png"));
        playRockBtn.addActionListener((ActionEvent ae) ->
        {


            int playerMove = 1;
            int botOut = 0;
            String winner = "";
            int winnerLogic;


            int currentMode = modeChooser.nextInt(5) + 1;
//            int currentMode = 5;
            if(currentMode == 1) {
                botOut = ComputerPlayer.ModeOne();

            } else if (currentMode == 2) {
                botOut = ComputerPlayer.ModeTwo(firstLastMove);

            } else if (currentMode == 3) {
                botOut = ComputerPlayer.ModeThree(playerMove);

            } else if (currentMode == 4) {
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);

            } else if (currentMode == 5) {
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);

            }
//            System.out.println(playerMove);
//            System.out.println(botOut);
//            System.out.println(currentMode);
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            winnerLogic = Decider.PickWinnerLogic(playerMove, botOut);
            if (winnerLogic == 1){
                wins++;
            } else if (winnerLogic == 2){
                losses++;
            } else if (winnerLogic == 0){
                draws++;
            }




            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });

        playPaperBtn = new JButton("Play Paper!");
        playPaperBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playRockBtn.setIcon(new ImageIcon("Images/paper.png"));
        playPaperBtn.addActionListener((ActionEvent ae) ->
        {


            int playerMove = 2;
            int botOut = 0;
            String winner = "";


            int currentMode = modeChooser.nextInt(5) + 1;
//            int currentMode = 5;
            if(currentMode == 1) {
                botOut = ComputerPlayer.ModeOne();

            } else if (currentMode == 2) {
                botOut = ComputerPlayer.ModeTwo(firstLastMove);

            } else if (currentMode == 3) {
                botOut = ComputerPlayer.ModeThree(playerMove);

            } else if (currentMode == 4) {
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);

            } else if (currentMode == 5) {
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);

            }
//            System.out.println(playerMove);
//            System.out.println(botOut);
//            System.out.println(currentMode);
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });



        playScissorsBtn = new JButton("Play Scissors!");
        playScissorsBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        playScissorsBtn.setIcon(new ImageIcon("Images/paper.png"));
        playScissorsBtn.addActionListener((ActionEvent ae) ->
        {


            int playerMove = 3;
            int botOut = 0;
            String winner = "";


            int currentMode = modeChooser.nextInt(5) + 1;
//            int currentMode = 5;
            if(currentMode == 1) {
                botOut = ComputerPlayer.ModeOne();

            } else if (currentMode == 2) {
                botOut = ComputerPlayer.ModeTwo(firstLastMove);

            } else if (currentMode == 3) {
                botOut = ComputerPlayer.ModeThree(playerMove);

            } else if (currentMode == 4) {
                botOut = ComputerPlayer.ModeFour(firstLastMove, secondLastMove, thirdLastMove);

            } else if (currentMode == 5) {
                botOut = ComputerPlayer.ModeFive(firstLastMove, secondLastMove, thirdLastMove);

            }
//            System.out.println(playerMove);
//            System.out.println(botOut);
//            System.out.println(currentMode);
            winner = Decider.PickWinner(playerMove, botOut, currentMode);
            displayTA.append(winner);

            thirdLastMove = secondLastMove;
            secondLastMove = firstLastMove;
            firstLastMove = playerMove;

        });




        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Thin", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(playRockBtn);
        controlPnl.add(playPaperBtn);
        controlPnl.add(playScissorsBtn);
        controlPnl.add(quitBtn);
        controlPnl.setBorder(compoundBorder2);

    }

}