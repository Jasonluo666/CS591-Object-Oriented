import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ManagerCheckAllUSerGUI extends JFrame {
	private BankManager manager;
	private JTable table;
    
    public ManagerCheckAllUSerGUI(BankManager manager){
    	this.manager = manager;
    	
    	JPanel panel = new JPanel(new BorderLayout());
        
        // table name
        Object[] columnNames = {"username", "description"};

        // table data
        Object[][] rowData = new Object[manager.retrieveUserList().size()][];
        
        for(int i=0; i<manager.retrieveUserList().size(); i++) { 	
        	User user = manager.retrieveUserList().get(i);
			rowData[i] = new String[]{user.getName(),user.getDesc()};
        }

        // new table 
        table = new JTable(rowData, columnNames);
        
        //adjust the font
        table.setFont(new java.awt.Font("Dialog", 1, 15));
        
        // add table header 
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        
        // add table content
        panel.add(table, BorderLayout.CENTER);
        
        JButton checkbutton=new JButton("check");
        checkbutton.addActionListener(new CheckListener());
        panel.add(checkbutton,BorderLayout.SOUTH);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        setContentPane(panel);
        
        setTitle( "ATM" );
		setSize( 500, 500 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setVisible( true );
	}
        
    	//deal with check customers for manager
        class CheckListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//get the name from the selected row and pass it into a new GUI to show
				String getname= table.getValueAt(table.getSelectedRow(), 0).toString();
				//System.out.print(getname);
				new ManagerCheckOneUSerGUI(manager,getname);
			}
        }
    
}
