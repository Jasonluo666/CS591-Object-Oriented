import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class DepositGUI extends JFrame{
	private User user;
	private JTable table;
	
	public DepositGUI(User user) {
		this.user = user;
		
		JPanel contentpanel = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new BorderLayout());
		JPanel cp = new JPanel(new BorderLayout());
        
		Object[] columnNames = {"AccountID","Type","Currency and Balance"};
		
		// table data
        int accoutNumber = user.getAccountNumber();
        Object[][] rowData = new Object[accoutNumber][];

        int index = 0;
        ArrayList<Account> accounts = null;
        
        accounts = user.retrieveAccountByType("LoanAccount");
        
        if(accounts != null)
        	for(Account account: accounts)
        		rowData[index++] = new String[]{account.getAccountID(), "LoanAccount", account.toString()};
        
        accounts = user.retrieveAccountByType("SavingAccount");
       
        if(accounts != null)
        	for(Account account: accounts)
        		rowData[index++] = new String[]{account.getAccountID(), "SavingAccount", account.toString()};
        
        accounts = user.retrieveAccountByType("CheckingAccount");
       
        if(accounts != null)
        	for(Account account: accounts)
        		rowData[index++] = new String[]{account.getAccountID(), "CheckingAccount", account.toString()};
        
        // new table 
        table = new JTable(rowData, columnNames);
        table.setFont(new Font("Serif", Font.PLAIN, 20));

        // add table header 
        contentpanel.add(table.getTableHeader(), BorderLayout.NORTH);
        
        // add table content
        contentpanel.add(table, BorderLayout.CENTER);
        
		
		panel.add(contentpanel,BorderLayout.NORTH);
        
		JLabel DepositLabel = new JLabel("Please choose an account to deposit then click the button");
		DepositLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        JButton DepositButton = new JButton("Confirm");
        DepositButton.addActionListener(new DepositListener());
        cp.add(DepositLabel,BorderLayout.NORTH);
        cp.add(DepositButton,BorderLayout.SOUTH);
        
        panel.add(cp,BorderLayout.CENTER);
        
        add(panel);
        setTitle("User: " + user.getName() );
        setSize(1500, 500);
        setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setVisible(true);
	}

	
	//deal with user deposit
	class DepositListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String getAccountID = table.getValueAt(table.getSelectedRow(), 0).toString();

			JList list = new JList(user.retrieveAccountByID(getAccountID).getCurrencies());
			JOptionPane.showMessageDialog(null, list, "Please select the currency", JOptionPane.PLAIN_MESSAGE);
			String currency = user.retrieveAccountByID(getAccountID).getCurrencies()[list.getSelectedIndex()];
			
			String amount = JOptionPane.showInputDialog("Please input the amount:");
			

			
			Money money = new Money(currency,Double.valueOf(amount));
			user.retrieveAccountByID(getAccountID).actionWithCharge("save", money);
			
			JOptionPane.showMessageDialog(null, "Successfully deposit!", "Info", JOptionPane.INFORMATION_MESSAGE);
			
			dispose();
		}		
	}
}
