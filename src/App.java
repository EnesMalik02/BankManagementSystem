import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

    public static int userID = 0;
    private JPanel Banka;
    private JButton girişYapButton;
    private JButton kayıtOlButton;
    private JTextField GirisSifre;
    private JTextField GirisId;
    private JTextField kayitOlSifre;
    private JTextField kayitOlIsım;

    private JFrame frame; // JFrame referansını sınıf seviyesinde saklayın

    public App() {
        kayıtOlButton.addActionListener(this);
        girişYapButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == kayıtOlButton) {
            String isim = kayitOlIsım.getText();
            String sifre = kayitOlSifre.getText();

            System.out.println("Kayıt olundu: " + isim + ", Şifre: " + sifre);
            userOperations.createUser(isim, sifre);
            kayitOlIsım.setText("");
            kayitOlSifre.setText("");
            JOptionPane.showMessageDialog(null, "Kullanıcı ID'niz: " + userOperations.ID + "\nLütfen ID'nizi unutmayın!");


        } else if (clickedButton == girişYapButton) {
            int ID = Integer.parseInt(GirisId.getText());
            String enteredPassword = GirisSifre.getText();
            userID = ID;
            boolean login = userOperations.login(ID, enteredPassword);
            if (login) {
                System.out.println("Giriş Yapılıyor: " + ID + "-------------  Şifre: " + enteredPassword);

                // Giriş başarılı olduğunda mainPage sınıfına geçiş yapın
                mainPage mainPageInstance = new mainPage();
                frame.setContentPane(mainPageInstance.getSayfa2());
                frame.revalidate();
                frame.repaint();
            } else {
                System.out.println("Giriş başarısız!");
            }
            GirisId.setText("");
            GirisSifre.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        App appInstance = new App();
        appInstance.frame = frame; // JFrame referansını saklayın
        frame.setContentPane(appInstance.Banka);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
