import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPage implements ActionListener {

    private JPanel sayfa2;
    private JButton paraYatırButton;
    private JTextField yatirilacakPara;
    private JButton paraÇekButton;
    private JTextField cekilecekPara;
    private JLabel paraMiktari;


    public mainPage() {
        double balance = transactions.getUserBalance(App.userID);
        paraMiktari.setText(String.valueOf(balance));
        paraÇekButton.addActionListener(this);
        paraYatırButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == paraÇekButton) {
            // Get user input from text fields
            String para = cekilecekPara.getText();
            transactions.withdraw(App.userID, Integer.parseInt(para));
            int cekilecekPara = Integer.parseInt(para);
            double balance = transactions.getUserBalance(App.userID);

            if (cekilecekPara - balance < 0) {
                JOptionPane.showMessageDialog(null, "Yetersiz bakiye");
            } else {
                paraMiktari.setText(String.valueOf(balance));
            }


        } else if (clickedButton == paraYatırButton) {
            // Get the password entered in GirisSifre
            String para = yatirilacakPara.getText();
            transactions.deposit(App.userID, Integer.parseInt(para));
            double balance = transactions.getUserBalance(App.userID);
            paraMiktari.setText(String.valueOf(balance));


        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new mainPage().sayfa2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set preferred size (optional)
        frame.setPreferredSize(new Dimension(400, 300));

        // Allow resizing the window
        frame.setResizable(true);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public JPanel getSayfa2() {
        return sayfa2;
    }
}
