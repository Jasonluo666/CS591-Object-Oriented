import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class UserMenuGUI extends JFrame{
	private User user;
	
	public UserMenuGUI(User user){
    	this.user = user;
    	
    	JPanel panel = new JPanel(new BorderLayout());
		
        JLabel Title = new JLabel("Hi "+ user.getName() +"! This is your menu");
        Title.setFont(new Font("Serif", Font.PLAIN, 26));
        
        JPanel contentPane = new JPanel(new BorderLayout());
        
        JLabel label=new JLabel("Please choose:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
		JComboBox comboBox=new JComboBox();
		comboBox.addItem(" ");
		comboBox.addItem("Create an account");
		comboBox.addItem("Withdrawal");
		comboBox.addItem("Deposit");
		comboBox.addItem("Request a Loan");
		comboBox.addItem("View Balances");
		comboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                
            	//according to the manager's choice to show next GUI
            	if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                    System.out.println("You chose to:" + comboBox.getSelectedItem());
                    
                    switch((String)arg0.getItem()){
                    	case "Create an account" :
                    		new CreateUserAccountGUI(user);
                    		break;
                    	case "Withdrawal" :
                    		new WithdrawalGUI(user);
                    		break;
                    	case "Deposit" :
                    		new DepositGUI(user);
                    		break;
                    	case "Request a Loan" :
                    		new LoanGUI(user);
                    		break;
                    	case "View Balances" :
                    		new ViewBalancesGUI(user);
                    		break;
                    }
                }
            }
        });
		
		contentPane.add(label);
		contentPane.setBounds(100,100,250,100);
		contentPane.setBorder(new EmptyBorder(40,40,40,40));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
		contentPane.add(comboBox);

        setTitle("Manager Menu");
        add(Title,BorderLayout.NORTH);
        add(contentPane);
        setSize( 500, 500 );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setVisible( true );
	}
}
