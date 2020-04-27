import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagerMenuGUI extends JFrame{
	private BankManager manager;
	
	public ManagerMenuGUI(BankManager manager){
		this.manager = manager;
		
		JPanel panel = new JPanel(new BorderLayout());
		
        JLabel Title = new JLabel("Hi Manager! This is your menu");
        Title.setFont(new Font("Serif", Font.PLAIN, 26));
        
        JPanel contentPane = new JPanel(new BorderLayout());
        
        JLabel label=new JLabel("Please choose:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
		JComboBox comboBox=new JComboBox();
		comboBox.addItem(" ");
		comboBox.addItem("Check users");
		comboBox.addItem("Generate reports");
		comboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                
            	//according to the manager's choice to show next GUI
            	if (arg0.getStateChange() == ItemEvent.SELECTED && !arg0.getItem().equals(" ")) {
                    System.out.println("You chose to:" + comboBox.getSelectedItem());
                    
                    if(arg0.getItem().equals("Check users"))
                    	new ManagerCheckAllUSerGUI(manager);
                    else
                    	new ManagerGenerateReportGUI(manager);
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
