import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    public MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        setLayout(null);

        // Bank title
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("System", Font.BOLD, 20));
        bank.setBounds(160, 20, 200, 25);
        add(bank);

        // Card number label
        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.PLAIN, 14));
        card.setBounds(20, 60, 400, 20);
        add(card);

        // Text area for transaction history
        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 100, 400, 250);
        add(scroll);

        // Balance label
        JLabel bal = new JLabel();
        bal.setFont(new Font("System", Font.BOLD, 14));
        bal.setBounds(20, 370, 400, 25);
        add(bal);

        try {
            Conn c = new Conn();

            // ✅ Fetch card number from signupthree
            ResultSet rs1 = c.s.executeQuery("SELECT * FROM signupthree WHERE pin = '" + pinnumber + "'");
            if (rs1.next()) {
                String cardNum = rs1.getString("cardnumber");
                card.setText("Card Number: " + cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(12));
            }

            // ✅ Fetch transactions from bank table
            ResultSet rs2 = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");

            int balance = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("Date           Type        Amount\n");
            sb.append("-------------------------------------\n");

            while (rs2.next()) {
                String date = rs2.getString("date");
                String type = rs2.getString("type");
                String amount = rs2.getString("amount");

                sb.append(String.format("%-15s %-10s Rs %s\n", date, type, amount));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            area.setText(sb.toString());
            bal.setText("Your Current Balance: Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame settings
        setSize(450, 500);
        setLocation(300, 50);  // Change if needed
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement(""); // Pass sample PIN if needed
    }
}
