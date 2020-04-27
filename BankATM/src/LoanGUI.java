import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoanGUI extends JFrame{
		private User user;
		private String currency;
		private String amount;
		private JTextField amountText;
		
		public LoanGUI(User user) {
			this.user = user;
			JPanel panel = new JPanel(new BorderLayout());
			
			JLabel Title = new JLabel("Please choose the currency of loan!");
		    
			Title.setFont(new Font("Serif", Font.PLAIN, 20));
		
			JPanel contentPane = new JPanel(new BorderLayout());

	        JComboBox comboBox1 = new JComboBox();
	        comboBox1.addItem(" ");
	        for(String s : Money.all_currencies){
	            comboBox1.addItem(s);
	        }
	        comboBox1.setFont(new Font("Serif", Font.PLAIN, 20));
	        
	        JLabel amountLabel = new JLabel("Please enter the amount if loan:");
	        amountLabel.setFont(new Font("Serif", Font.PLAIN, 20));
	        
	        amountText = new JTextField(10);
	        amountText.setFont(new Font("Serif", Font.PLAIN, 20));
	        
	        comboBox1.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent arg0) {
		
	                //according to the manager's choice to show next GUI
	                if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
	                    System.out.println("You chose :" + comboBox1.getSelectedItem());
	
	                    currency = (String) arg0.getItem();
	                }
	            }
	        });
	        
	        contentPane.add(Title);
			contentPane.setBounds(10,10,10,10);
			contentPane.setBorder(new EmptyBorder(10,10,10,10));
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			contentPane.add(comboBox1);
			
			JPanel cp = new JPanel();
			cp.add(amountLabel,BorderLayout.EAST);
			cp.add(amountText,BorderLayout.WEST);
			
			JPanel p = new JPanel();
			
			panel.add(contentPane,BorderLayout.NORTH);
	        panel.add(cp,BorderLayout.CENTER);
	        
	        JButton LoanButton = new JButton("Confirm");
	        LoanButton.addActionListener(new LoanListener());
	        p.add(LoanButton);
	        panel.add(p,BorderLayout.SOUTH);
	        
	        
	        add(panel);
			setTitle( "Request a loan" );
			setSize( 500, 200 );
			setLocationRelativeTo( null );
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			setVisible( true );
		}
		
        
		
      //deal with user requesting a loan
    	class LoanListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//user.loan(currency,amount);
                amount = amountText.getText();
				Account loan_account = null;
				
				// create account if user doesn't have one
				if(loan_account == null) {
					String account_id = user.createAccount("LoanAccount");
					loan_account = user.retrieveAccountByID(account_id);
					loan_account.setCurrency(0, currency);
					loan_account.setCurrency(1, currency);
					loan_account.setCurrency(2, currency);
				}
				
				//System.out.println(currency + "+" + amount);
				Money money = new Money(currency, Double.valueOf(amount));
				loan_account.actionWithCharge("loan", money);
				
				JOptionPane.showMessageDialog(null, "Successfully requested a loan!", "Info", JOptionPane.INFORMATION_MESSAGE);

				dispose();
			}
    	}

}
