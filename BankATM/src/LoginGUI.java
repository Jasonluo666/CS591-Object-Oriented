import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JFrame {
    private JTextField userText;
    private JTextField passwordText;
    private Bank bank;
    private BankManager manager;

    public LoginGUI(Bank bank, BankManager manager) {
        this.bank = bank;
        this.manager = manager;

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(30);
        userLabel.setBounds(10,20,80,25);
        userText.setBounds(80,20,150,25);
        panel.add(userLabel);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password:");
        passwordText = new JTextField(30);
        passwordLabel.setBounds(10,50,80,25);
        passwordText.setBounds(80,50,150,25);
        panel.add(passwordLabel);
        panel.add(passwordText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(80, 80, 150, 25);
        loginButton.addActionListener(new LoginListener());
        panel.add(loginButton);


        JButton enterManager = new JButton("I'm the manager");
        enterManager.setBounds(80, 110, 150, 25);
        enterManager.addActionListener(new EnterManager());
        panel.add(enterManager);

        add(panel);
        setTitle( "ATM" );
        setSize( 270, 200 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
    }

    //deal with user login
    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String username = userText.getText();
            String password = passwordText.getText();

            if(bank.login(username, password) != null) {
                new UserMenuGUI(bank.login(username, password));
                //JOptionPane.showMessageDialog(null, "Login successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
                userText.setText("");
                passwordText.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Info", JOptionPane.ERROR_MESSAGE);
                userText.setText("");
                passwordText.setText("");
			}
		}
	}
	
	class EnterManager implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ManagerMenuGUI(manager);
		}
	}
	
	public static void main( String[] args ) {
		Bank bank = new Bank();
    	BankManager m = new BankManager(bank);

		new LoginGUI(bank,m);
	}
}
