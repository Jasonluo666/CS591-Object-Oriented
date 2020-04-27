import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ManagerGenerateReportGUI extends JFrame{

	JPanel middlePanel;
	JTextArea display;
	JScrollPane scroll;

	public ManagerGenerateReportGUI(BankManager manager) {
		middlePanel=new JPanel();
		middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));

		// create the middle panel components

		display = new JTextArea(22, 53);
		display.setEditable(false); // set textArea non-editable
		display.setText(manager.getReport());
		scroll = new JScrollPane(display);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//Add Textarea in to middle panel
		middlePanel.add(scroll);

		setContentPane(middlePanel);

		setTitle( "ATM" );
		setSize( 500, 500 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setVisible( true );
	}
}
