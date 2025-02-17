import javax.swing.*;
import java.util.List;

public class GUI extends JFrame {
    private JPanel pnMain;
    private JCheckBox cbZakoupeno;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JButton btPrev;
    private JButton btNext;
    private JLabel textLabel;
    private List<DeskoveHry> games;
    private int currentIndex = 0;

    public GUI(List<DeskoveHry> games) {
        this.games = games;
        this.setContentPane(pnMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Deskové hry");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        btPrev.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateGameInfo();
            }
        });

        btNext.addActionListener(e -> {
            if (currentIndex < games.size() - 1) {
                currentIndex++;
                updateGameInfo();
            }
        });

        if (!games.isEmpty()) {
            updateGameInfo();
        }
    }

    private void updateGameInfo() {
        DeskoveHry game = games.get(currentIndex);
        textLabel.setText(game.getNazev());
        cbZakoupeno.setSelected(game.isZakoupeno());
        rb1.setSelected(game.getNejoblibenejsi() == 1);
        rb2.setSelected(game.getNejoblibenejsi() == 2);
        rb3.setSelected(game.getNejoblibenejsi() == 3);
    }
}