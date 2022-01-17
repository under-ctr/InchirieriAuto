package PRJ;

import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;


public class IntLogIn extends JFrame {

    private JPanel panelMainLog;
    private JTextField usernameTextField1;
    private JButton AUTENTIFICAREButton;
    private JButton CREARECONTNOUButton;
    private JLabel userLabel;
    private JLabel parolaLabel;
    private JPasswordField passwordField1;


    JFrame frame = new JFrame("LogIn");

    public IntLogIn() {
        AUTENTIFICAREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);

                    String sqll= "select * from login where username=? and parola=?";
                    PreparedStatement pstl = con.prepareStatement(sqll);
                    pstl.setString(1, usernameTextField1.getText());
                    pstl.setString(2, passwordField1.getText());

                    ResultSet rs = pstl.executeQuery();
                    if (rs.next()){
                        JOptionPane.showMessageDialog(null, "Autentificare reusita!");
                        IntApp app = new IntApp();
                        app.setContentPane(new IntApp().panelMain);
                        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        app.setSize(1024, 768);
                        app.setVisible(true);
                        app.setLocation(400, 100);
                        frame.setVisible(false);
                        //frame.hide();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Autentificare respinsa!", "Eroare", JOptionPane.ERROR_MESSAGE);
                        usernameTextField1.setText("");
                        passwordField1.setText("");
                    }
                    con.close();
                } catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }



            }
        });
        CREARECONTNOUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);



                    String sqll= "inserare_user(?, ?)";
                    PreparedStatement pstl = con.prepareStatement(sqll);
                    pstl.setString(1, usernameTextField1.getText());
                    pstl.setString(2, passwordField1.getText());
                    pstl.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Creare cont nou reusita");
                    usernameTextField1.setText("");
                    passwordField1.setText("");

                    con.close();
                } catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


            }
        });
    }

    public static void main(String[] args)
    {
        IntLogIn log = new IntLogIn();

        log.run();
    }

    private void run(){

        frame.setContentPane(new IntLogIn().panelMainLog);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setResizable(false);





    }

}
