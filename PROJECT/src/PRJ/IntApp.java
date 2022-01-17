package PRJ;

import com.mysql.cj.xdevapi.CreateIndexParams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntApp extends JFrame {

    public JPanel panelMain;
    private JTabbedPane cnpClientLabel2;
    private JPanel autoturismePanel;
    private JPanel autoutilitarePanel;
    private JPanel evSpecialePanel;
    private JLabel CNPLabel;
    private JLabel numeLabel;
    private JLabel nrMasinaLabel;
    private JLabel perioadaLabel;
    private JButton acceptButton;
    private JTextField textFieldCNP;
    private JTextField textFieldNume;
    private JTextField textFieldMarca;
    private JTextField textFieldPerioada;
    private JLabel skodaLabel;
    private JLabel golfLabel;
    private JLabel cooperLabel;
    private JLabel fordLabel;
    private JLabel hondaLabel;
    private JLabel audiLabel;
    private JLabel prenumeLabel;
    private JTextField textFieldPrenume;
    private JTextField textFieldCNP2;
    private JTextField textFieldNume2;
    private JTextField textFieldPrenume2;
    private JTextField textFieldPerioada2;
    private JButton confirmButton2;
    private JLabel numeLabel2;
    private JLabel prenumeLabel2;
    private JLabel nrMasinaLabel2;
    private JLabel perioadaLabel2;
    private JLabel cnpLabel2;
    private JLabel fordLabel2;
    private JLabel vwLabel2;
    private JTextField textFieldCNP3;
    private JTextField textFieldNume3;
    private JTextField textFieldPrenume3;
    private JTextField textFieldPerioada3;
    private JButton confirmButton3;
    private JLabel cnpLabel3;
    private JLabel numeLabel3;
    private JLabel prenumeLabel3;
    private JLabel nrMasinaLabel3;
    private JLabel perioadaLabel3;
    private JLabel elicopterLabel;
    private JLabel limuzinaLabel;
    private JLabel epocaLabel;
    private JComboBox comboBoxMasina1;
    private JPanel istoricPanel;
    private JComboBox comboBoxMasina2;
    private JComboBox comboBoxMasina3;
    private JButton AFISEAZAISTORICButton;
    private JLabel textNrContractT;
    private JLabel textPerioadaT;
    private JLabel textMasinaT;
    private JLabel textPretT;
    private JLabel textDubaT;
    private JLabel textSpecialaT;
    private JLabel textCNPT;
    public JTextField nrContractTextField;
    public JTextField cnpTextField;
    public JTextField perioadaTextField;
    public JTextField pretTextField;
    public JTextField masinTextField;
    public JTextField dubaTextField;
    public JTextField specialaTextField;
    private JTextPane cnpTextPane;
    private JTextPane specialaTextPane;
    private JTextPane dubaTextPane;
    private JTextPane pretTextPane;
    private JTextPane perioadaTextPane;
    private JTextPane masinaTextPane;
    private JTextPane contractTextPane;
    private JButton inchiriazaAT;




    JFrame frame = new JFrame("App");
    public IntApp() {

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);

                    String que = "select ";

                    String query = "call insereaza_client(?, ?, ?)";
                    String query2 = "insert into contract(cnp_client, nr_masina, perioada) values(?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, textFieldCNP.getText());
                    pst.setString(2, textFieldNume.getText());
                    pst.setString(3, textFieldPrenume.getText());

                    PreparedStatement pst2 = con.prepareStatement(query2);
                    pst2.setString(1, textFieldCNP.getText());
                    //pst2.setString(2, textFieldMarca.getText());
                    pst2.setString(2, String.valueOf(comboBoxMasina1.getSelectedItem()));
                    pst2.setString(3, textFieldPerioada.getText());

                    pst.executeUpdate();
                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Acceptat", "Mesaj", JOptionPane.INFORMATION_MESSAGE);


                    String queryC = "select * from contract";
                    PreparedStatement pstC = con.prepareStatement(queryC);

                    //pst.executeQuery();
                    ResultSet rs = pstC.executeQuery();

                    while (rs.next()){
                        textNrContractT.setText(rs.getMetaData().getColumnLabel(1));
                        textCNPT.setText(rs.getMetaData().getColumnLabel(2));
                        textMasinaT.setText(rs.getMetaData().getColumnLabel(3));
                        textPerioadaT.setText(rs.getMetaData().getColumnLabel(4));
                        textPretT.setText(rs.getMetaData().getColumnLabel(5));
                        textDubaT.setText(rs.getMetaData().getColumnLabel(6));
                        textSpecialaT.setText(rs.getMetaData().getColumnLabel(7));

                        nrContractTextField.setText(rs.getString(1));
                        cnpTextField.setText(rs.getString(2));
                        masinTextField.setText(rs.getString(3));
                        perioadaTextField.setText(rs.getString(4));
                        pretTextField.setText(rs.getString(5));
                        dubaTextField.setText(rs.getString(6));
                        specialaTextField.setText(rs.getString(7));


                        //contractTextPane.setText(String.valueOf(rs.getArray(1)));
                        //RowId row = rs.getRowId(1);
                        //RowId row = rs.getRowId(1);

                    }
                    if(dubaTextField.getText().isEmpty())
                        dubaTextField.setText("null");
                    if(masinTextField.getText().isEmpty())
                        masinTextField.setText("null");
                    if(specialaTextField.getText().isEmpty())
                        specialaTextField.setText("null");


                    con.close();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        /*textFieldCNP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
        confirmButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);

                    String query = "call insereaza_client(?, ?, ?)";
                    String query2 = "call inseriaza_contract_duba(?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, textFieldCNP2.getText());
                    pst.setString(2, textFieldNume2.getText());
                    pst.setString(3, textFieldPrenume2.getText());

                    PreparedStatement pst2 = con.prepareStatement(query2);
                    pst2.setString(1, textFieldCNP2.getText());
                    //pst2.setString(2, textFieldMarca.getText());
                    pst2.setString(2, String.valueOf(comboBoxMasina2.getSelectedItem()));
                    pst2.setString(3, textFieldPerioada2.getText());

                    pst.executeUpdate();
                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Acceptat");

                    con.close();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        confirmButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);


                    String query = "call insereaza_client(?, ?, ?)";
                    String query2 = "call insereaza_contract_speciala(?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, textFieldCNP3.getText());
                    pst.setString(2, textFieldNume3.getText());
                    pst.setString(3, textFieldPrenume3.getText());

                    PreparedStatement pst2 = con.prepareStatement(query2);
                    pst2.setString(1, textFieldCNP3.getText());
                    //pst2.setString(2, textFieldMarca.getText());
                    pst2.setString(2, String.valueOf(comboBoxMasina3.getSelectedItem()));
                    pst2.setString(3, textFieldPerioada3.getText());

                    pst.executeUpdate();
                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Acceptat");


                    con.close();

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        AFISEAZAISTORICButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/proiect";
                    String uid = "root";
                    String pw = "Portar!12";
                    BufferedReader reader;
                    Connection con = DriverManager.getConnection(url, uid, pw);

                    String query = "select * from contract";
                    PreparedStatement pst = con.prepareStatement(query);

                    //pst.executeQuery();
                    ResultSet rs = pst.executeQuery();

                    while (rs.next()){
                        textNrContractT.setText(rs.getMetaData().getColumnLabel(1));
                        textCNPT.setText(rs.getMetaData().getColumnLabel(2));
                        textMasinaT.setText(rs.getMetaData().getColumnLabel(3));
                        textPerioadaT.setText(rs.getMetaData().getColumnLabel(4));
                        textPretT.setText(rs.getMetaData().getColumnLabel(5));
                        textDubaT.setText(rs.getMetaData().getColumnLabel(6));
                        textSpecialaT.setText(rs.getMetaData().getColumnLabel(7));

                        nrContractTextField.setText(rs.getString(1));
                        cnpTextField.setText(rs.getString(2));
                        masinTextField.setText(rs.getString(3));
                        perioadaTextField.setText(rs.getString(4));
                        pretTextField.setText(rs.getString(5));
                        dubaTextField.setText(rs.getString(6));
                        specialaTextField.setText(rs.getString(7));


                    }
                    if(dubaTextField.getText().isEmpty())
                        dubaTextField.setText("null");
                    if(masinTextField.getText().isEmpty())
                        masinTextField.setText("null");
                    if(specialaTextField.getText().isEmpty())
                        specialaTextField.setText("null");



                    con.close();

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args)
    {
        IntApp app = new IntApp();
        app.run();
    }

    private void run(){

        frame.setContentPane(new IntApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1024, 768);
        frame.setResizable(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        //imageLabel1 = new JLabel(new ImageIcon("SO.PNG"));


    }

}
