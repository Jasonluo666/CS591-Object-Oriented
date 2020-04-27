import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateUserAccountGUI extends JFrame {

    private User user;

    CreateUserAccountGUI(User name){
        user = name;

        JLabel Title = new JLabel("Which type of account would you like to create?");
        Title.setFont(new Font("Serif", Font.PLAIN, 22));

        JPanel contentPane = new JPanel(new BorderLayout());

        JLabel label=new JLabel("Please choose:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        contentPane.add(label);

        JButton checkingButton = new JButton("Checking");
        checkingButton.setBounds(10, 20, 150, 25);
        checkingButton.addActionListener(new CheckingListener());
        contentPane.add(checkingButton);

        JButton savingButton = new JButton("Saving");
        savingButton.setBounds(80, 40, 150, 25);
        savingButton.addActionListener(new SavingListener());
        contentPane.add(savingButton);

        /*
        JButton loanButton = new JButton("Loan");
        loanButton.setBounds(80, 60, 150, 25);
        loanButton.addActionListener(new LoanListener());
        contentPane.add(loanButton);

         */

        contentPane.setBounds(100,100,250,100);
        contentPane.setBorder(new EmptyBorder(40,40,40,40));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));

        setTitle("Account Creation Menu");
        add(Title,BorderLayout.NORTH);
        add(contentPane);
        setSize( 500, 500 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setVisible( true );
    }

    class CheckingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Checking account created", "Info", JOptionPane.INFORMATION_MESSAGE);
            new CurrencySelector(user.createAccount("CheckingAccount"));
            dispose();
        }
    }

    class SavingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Savings account created", "Info", JOptionPane.INFORMATION_MESSAGE);
            new CurrencySelector(user.createAccount("SavingAccount"));
            dispose();
        }
    }

    /*
    class LoanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Loan account created", "Info", JOptionPane.INFORMATION_MESSAGE);
            new LoanCurrency(user.createAccount("LoanAccount"));
            dispose();
        }
    }
     */

    class CurrencySelector extends JFrame {

        String c1;
        String c2;
        String c3;

        CurrencySelector(String id) {
            JPanel panel = new JPanel(new BorderLayout());

            JLabel Title = new JLabel("Please choose three different types of currency!");
            Title.setFont(new Font("Serif", Font.PLAIN, 20));

            JPanel contentPane = new JPanel(new BorderLayout());

            JLabel label = new JLabel("Please choose:");
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            JComboBox comboBox1 = new JComboBox();
            comboBox1.addItem(" ");
            for (String s : Money.all_currencies) {
                comboBox1.addItem(s);
            }
            comboBox1.setFont(new Font("Serif", Font.PLAIN, 20));

            comboBox1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent arg0) {

                    //according to the manager's choice to show next GUI
                    if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                        System.out.println("You chose:" + comboBox1.getSelectedItem());

                        c1 = (String) comboBox1.getSelectedItem();
                    }
                }
            });

            label.setFont(new Font("Serif", Font.PLAIN, 20));
            JComboBox comboBox2 = new JComboBox();
            comboBox2.addItem(" ");
            for (String s : Money.all_currencies) {
                comboBox2.addItem(s);
            }
            comboBox2.setFont(new Font("Serif", Font.PLAIN, 20));

            comboBox2.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent arg0) {

                    //according to the manager's choice to show next GUI
                    if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                        System.out.println("You chose:" + comboBox2.getSelectedItem());

                        c2 = (String) comboBox2.getSelectedItem();
                    }
                }
            });

            label.setFont(new Font("Serif", Font.PLAIN, 20));
            JComboBox comboBox3 = new JComboBox();
            comboBox3.addItem(" ");
            for (String s : Money.all_currencies) {
                comboBox3.addItem(s);
            }
            comboBox3.setFont(new Font("Serif", Font.PLAIN, 20));

            comboBox3.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent arg0) {

                    //according to the manager's choice to show next GUI
                    if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                        System.out.println("You chose:" + comboBox3.getSelectedItem());

                        c3 = (String) comboBox3.getSelectedItem();
                    }
                }
            });

            JButton currencyButton = new JButton("Create");
            currencyButton.setBounds(80, 80, 150, 25);
            currencyButton.addActionListener(new CreateListener(id));
            panel.add(currencyButton);

            contentPane.add(label);
            contentPane.setBounds(100, 100, 250, 100);
            contentPane.setBorder(new EmptyBorder(40, 40, 40, 40));
            contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
            contentPane.add(comboBox1);
            contentPane.add(comboBox2);
            contentPane.add(comboBox3);
            contentPane.add(currencyButton);

            setTitle("Currency Menu");
            add(Title, BorderLayout.NORTH);
            add(contentPane);
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        class CreateListener implements ActionListener {

            String s;

            CreateListener(String type) {
                s = type;
            }

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Account a = user.retrieveAccountByID(s);
                a.setCurrency(0, c1);
                a.setCurrency(1, c2);
                a.setCurrency(2, c3);
                JOptionPane.showMessageDialog(null, "Account created", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
/*
    class LoanCurrency extends JFrame {

        String c1;

        LoanCurrency(String id) {
            JPanel panel = new JPanel(new BorderLayout());

            JLabel Title = new JLabel("Please choose a currency!");
            Title.setFont(new Font("Serif", Font.PLAIN, 20));

            JPanel contentPane = new JPanel(new BorderLayout());

            JLabel label = new JLabel("Please choose:");
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            JComboBox comboBox1 = new JComboBox();
            comboBox1.addItem(" ");
            for (String s : Money.all_currencies) {
                comboBox1.addItem(s);
            }
            comboBox1.setFont(new Font("Serif", Font.PLAIN, 20));

            comboBox1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent arg0) {

                    //according to the manager's choice to show next GUI
                    if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                        System.out.println("You chose:" + comboBox1.getSelectedItem());

                        c1 = (String) comboBox1.getSelectedItem();
                    }
                }
            });

            JButton currencyButton = new JButton("Create");
            currencyButton.setBounds(80, 80, 150, 25);
            currencyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Account a = user.retrieveAccountByID(id);
                    a.setCurrency(0, c1);
                    JOptionPane.showMessageDialog(null, "Loan account created", "Info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            });
            panel.add(currencyButton);

            contentPane.add(label);
            contentPane.setBounds(100, 100, 250, 100);
            contentPane.setBorder(new EmptyBorder(40, 40, 40, 40));
            contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
            contentPane.add(comboBox1);
            contentPane.add(currencyButton);

            setTitle("Currency Menu");
            add(Title, BorderLayout.NORTH);
            add(contentPane);
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }

 */
}
