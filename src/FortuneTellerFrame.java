import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private Random random;
    private int previousFortune = -1;

    public FortuneTellerFrame() {


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;

        int frameWidth = screenWidth * 3 / 4;
        int frameHeight = screenHeight * 3 / 4;

        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);


        Font titleFont = new Font("Serif", Font.BOLD, 48);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font fortuneFont = new Font("Arial", Font.PLAIN, 20);



        JPanel topPanel = new JPanel();

        JLabel titleLabel = new JLabel("Fortune Teller");
        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel);

        fortuneArea = new JTextArea();
        fortuneArea.setFont(fortuneFont);
        fortuneArea.setEditable(false);
        fortuneArea.setLineWrap(true);
        fortuneArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);


        JPanel bottomPanel = new JPanel();

        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);


        fortunes = new ArrayList<>();

        fortunes.add("You will find money in an unexpected place.");
        fortunes.add("Your computer will crash at the worst possible time.");
        fortunes.add("You will soon eat something delicious.");
        fortunes.add("A great opportunity is coming... probably.");
        fortunes.add("Someone thinks you are cooler than you think.");
        fortunes.add("You will become famous among your friends.");
        fortunes.add("Your next nap will be extremely productive.");
        fortunes.add("You will finally find what you were looking for.");
        fortunes.add("Your Wi-Fi will mysteriously become faster.");
        fortunes.add("You will make a decision that saves you $5.");
        fortunes.add("Today is a good day to avoid unnecessary responsibilities.");
        fortunes.add("Your future contains snacks.");

        random = new Random();


        fortuneButton.addActionListener(e -> {

            int currentFortune;

            do {
                currentFortune = random.nextInt(fortunes.size());
            } while (currentFortune == previousFortune);

            fortuneArea.append(fortunes.get(currentFortune) + "\n");

            previousFortune = currentFortune;
        });

        quitButton.addActionListener(e -> {
            System.exit(0);
        });


        setLayout(new BorderLayout());

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}