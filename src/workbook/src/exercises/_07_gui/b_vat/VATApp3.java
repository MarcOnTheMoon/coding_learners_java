package exercises._07_gui.b_vat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class VATApp3 {
	
	/** Constructor creating and displaying frame.
	 */
	private VATApp3() {
		// Create frame and set properties
		JFrame frame = new JFrame("MwSt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);

		// Elements
		JLabel vatLabel = new JLabel("0,00 €");
		JTextField grossText = new JTextField("0,00");
		
		JRadioButton vat7Button = new JRadioButton("7 %");
		JRadioButton vat19Button = new JRadioButton("19 %");
		ButtonGroup vatGroup = new ButtonGroup();
		vatGroup.add(vat7Button);
		vatGroup.add(vat19Button);
		vat19Button.setSelected(true);
		
		// Event handling
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// Get entered gross
				String input = grossText.getText();
				input = input.replace(',', '.');		// Locale for decimal places from US to DE
				
				// Determine and set VAT
				// Note: try/catch to be added in task for chapter on exception handling 
				try {
					int vatPercent = (vat7Button.isSelected()) ? 7 : 19; 
					double gross = Double.parseDouble(input);
					double net = gross / (1.0 + vatPercent / 100.0);
					vatLabel.setText(String.format("%.2f €", gross - net));
				} catch (NumberFormatException e) {
					vatLabel.setText("Fehlerhafte Eingabe!");
				}
			}
		};
		
		grossText.addActionListener(actionListener);
		vat7Button.addActionListener(actionListener);
		vat19Button.addActionListener(actionListener);
		
		// Layout: Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(vat7Button);
		buttonPanel.add(vat19Button);
		
		// Layout: Content pane
		int border = 5;		
		Container contentPane = frame.getContentPane();
		((JPanel)contentPane).setBorder(new EmptyBorder(border, border, border, border));
		contentPane.setLayout(new GridLayout(3, 2, 2 * border, border));
		contentPane.add(new JLabel("Steuersatz:"));
		contentPane.add(buttonPanel);
		contentPane.add(new JLabel("Bruttobetrag:"));
		contentPane.add(grossText);
		contentPane.add(new JLabel("Enthaltene MwSt:"));
		contentPane.add(vatLabel);

		// Show frame
		frame.pack();
		frame.setVisible(true);		
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new VATApp3();
	}
}
