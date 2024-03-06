package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorButtonPanel extends JPanel {
	
	private JButton btnInnerColor = new JButton("          ");
	private JButton btnEdgeColor = new JButton("          ");
	private JLabel lblInnerColor = new JLabel("INNER COLOR  ");
	private JLabel lblEdgeColor =  new JLabel("EDGE COLOR   ");
	
	public ColorButtonPanel() {
		setLayout(new GridLayout(2,2,5,5));
		setBackground(Color.lightGray);
		btnInnerColor.setVisible(false);
		btnEdgeColor.setVisible(false);
	
		
		
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
				if (color != null)
					btnInnerColor.setBackground(color);

			}
		});
	
		
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose outline color",
						btnEdgeColor.getBackground());
				if (color != null)
					btnEdgeColor.setBackground(color);

			}
		});
	
		add(lblEdgeColor);
		add(btnEdgeColor);
		add(lblInnerColor);
		add(btnInnerColor);
		
	}
	public void setVisibleInnerColorBtn(boolean value) {
		btnInnerColor.setVisible(value);
		lblInnerColor.setVisible(value);
	}
	public void setVisibleEdgeColorBtn(boolean value) {
		lblEdgeColor.setVisible(value);
		btnEdgeColor.setVisible(value);
	}
	
	public Color getInnerColor() {
		return btnInnerColor.getBackground();
	}

	
	public Color getEdgeColor() {
		return btnEdgeColor.getBackground();
	}
	
	public void setInnerColor(Color color) {
		btnInnerColor.setBackground(color);
	}

	
	public void setEdgeColor(Color color) {
		btnEdgeColor.setBackground(color);
	}

	

}
