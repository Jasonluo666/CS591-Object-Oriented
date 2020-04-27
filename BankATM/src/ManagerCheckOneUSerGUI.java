import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ManagerCheckOneUSerGUI extends JFrame{
	
	public ManagerCheckOneUSerGUI(BankManager manager, String username){
		JPanel panel = new JPanel(new BorderLayout());
        
        // table name
        Object[] columnNames = {"username", "accountID","Type","Currency and Balance"};
        
        // table data
        User user = manager.retrieveUser(username);
        int accoutNumber = user.getAccountNumber();
        Object[][] rowData = new Object[accoutNumber][];
        
        for(int i=0; i<accoutNumber; i++) 
    		rowData[i] = new String[]{user.getName(),user.retrieveAccountList()[i][0],user.retrieveAccountList()[i][1],user.retrieveAccountList()[i][2]};
        
        // new table 
        JTable table = new JTable(rowData, columnNames);
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        
        // add table header 
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        
        // add table content
        panel.add(table, BorderLayout.CENTER);
        
        setTitle("User: " + username );
        setSize(1500, 500);
        setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setVisible(true);
        
        setContentPane(panel);
	}

}
