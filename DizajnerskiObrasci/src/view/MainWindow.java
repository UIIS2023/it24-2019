package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import command.*;
import commandx.CommandTextType;
import commandx.UnselectAll;
import controller.ButtonControlor;
import controller.LogoControlor;

import model.Model;



import javax.swing.BorderFactory;

import javax.swing.ButtonGroup;

import java.awt.FlowLayout;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;


import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainWindow extends JFrame  implements PropertyChangeListener{

	private Model model = new Model();
	private MainPanel mainPanel;
	private JRadioButton rdbtnPoint = new JRadioButton("POINT");
	private JRadioButton rdbtnLine = new JRadioButton("LINE");
	private JRadioButton rdbtnCircle = new JRadioButton("CIRCLE");
	private JRadioButton rdbtnDonut = new JRadioButton("DONUT");
	private JRadioButton rdbtnRectangle = new JRadioButton("RECTANGLE");
	private JRadioButton rdbtnHexagon = new JRadioButton("HEXAGON");
	public JRadioButton tglbtnSelect = new JRadioButton("SELECT");
	private JMenuItem menuItemModify = new JMenuItem("MODIFY");
	private JMenuItem menuItemDelete = new JMenuItem("DELETE");
	private JMenuItem menuItemToBack = new JMenuItem("TO BACK");
	private JMenuItem menuItemToFront = new JMenuItem("TO FRONT");
	private JMenuItem menuItemBringToBack = new JMenuItem("BRING TO BACK");
	private JMenuItem menuItemBringToFront = new JMenuItem("BRING TO FRONT");
	private JMenuItem menuItemUndo = new JMenuItem("UNDO         CTRL + Z");
	private JMenuItem menuItemRedo = new JMenuItem("REDO         CTRL + Y");
	
	
	public JButton next =     new JButton("  NEXT  ");
	public JButton previous = new JButton("PREVIOUS");
	public JButton cancel =   new JButton("CANCEL LOGO");
	public JButton accept =   new JButton("ACCEPT LOGO");
	public JButton btnSelectInnerColor = new JButton();
	public JButton btnSelectEdgeColor = new JButton();
	public JTextArea textArea = new JTextArea(5,20);

	private ButtonControlor buttonControlor;
	private LogoControlor logoControlor;
	

	public MainWindow() {
		
		
		setTitle("IT24/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		setResizable(true);
		setLayout(new BorderLayout());
		
		model.addPropertyChangeListener(this);

		setCenterOfBorderLayout();
		setNorthOfBorderLayout();
		setSouthOfBorderLayout();
		
		//tglbtnSelect.setFont(new Font("SansSerif", tglbtnSelect.getFont().getStyle(), tglbtnSelect.getFont().getSize() + 2));
		menuItemModify.setEnabled(false);
		menuItemDelete.setEnabled(false);
		menuItemUndo.setEnabled(false);
		menuItemRedo.setEnabled(false);
		
		menuItemToBack.setEnabled(false);
		menuItemToFront.setEnabled(false);
		menuItemBringToBack.setEnabled(false);
		menuItemBringToFront.setEnabled(false);
		
		
		
		
		
		next.setEnabled(false);
		previous.setEnabled(false);
		next.setVisible(false);
		previous.setVisible(false);
		cancel.setVisible(false);
		accept.setVisible(false);
		next.addActionListener(logoControlor);
		previous.addActionListener(logoControlor);
		cancel.addActionListener(logoControlor);
		accept.addActionListener(logoControlor);
		btnSelectEdgeColor.setPreferredSize(new Dimension(40,30));
		btnSelectInnerColor.setPreferredSize(new Dimension(40,30));
		
		
		
	
		btnSelectEdgeColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "SET EGDE COLOR", Color.blue);
			
				if(color != null)
				{
					btnSelectEdgeColor.setBackground(color);
				}
				
			}
			
		});
		
		btnSelectInnerColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "SET INNER COLOR", Color.blue);
				
				if(color != null)
				{
					btnSelectInnerColor.setBackground(color);
				}
				
			}
			
		});
		
		/*tglbtnSelect.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					
					if(!((JRadioButton)e.getSource()).isSelected()) {
						
						if(model.isShapeSelected() ) {
							model.unSelectAll();
						}
		
						
	
						mainPanel.repaint();
					}
					
				}
		    	
		   });*/
		
		
		
	}
	
	private void setCenterOfBorderLayout() {
		
		mainPanel = new MainPanel(this);
		add(mainPanel, BorderLayout.CENTER);
		buttonControlor = new ButtonControlor(this);
		logoControlor = new LogoControlor(this);
		mainPanel.setBackground(Color.WHITE);
		
		
	}
	
	private void setSouthOfBorderLayout() {
		
		
		JScrollPane scroolArea = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroolArea.setBorder(new LineBorder(Color.black, 1,true));
		
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createTitledBorder("Logo"));
		textArea.setEditable(false); 
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textArea.setBackground(Color.green);
	
		add(BorderLayout.SOUTH, scroolArea);
		
	}
	
	private void setNorthOfBorderLayout() {
		
		JPanel pnlNorth = new JPanel(new GridLayout(3,1, 3, 3));
		JPanel pnlMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JMenuBar menuBar = new JMenuBar();
		setMenu(menuBar);
		pnlMenu.add(menuBar);
		pnlNorth.add(pnlMenu);
		
		JPanel pnlCreateSelect = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlCreateSelect.setBackground(Color.green);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPoint);
		btnGroup.add(rdbtnLine);
		btnGroup.add(rdbtnCircle);
	    btnGroup.add(rdbtnDonut);
	    btnGroup.add(rdbtnRectangle);
	    btnGroup.add(rdbtnHexagon);
	    btnGroup.add(tglbtnSelect);
	    
	    JPanel pnlNorthButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
	  
	    pnlCreateSelect.add(rdbtnPoint);
	    pnlCreateSelect.add(rdbtnLine);
	    pnlCreateSelect.add(rdbtnCircle);
	    pnlCreateSelect.add(rdbtnDonut);
	    pnlCreateSelect.add(rdbtnRectangle);
	    pnlCreateSelect.add(rdbtnHexagon);
	    
	    
	    
	    ChangeEventHandler eventHandler = new ChangeEventHandler();
	    
	    
	    rdbtnPoint.addChangeListener(eventHandler);
	    rdbtnLine.addChangeListener(eventHandler);
	    rdbtnCircle.addChangeListener(eventHandler);
	    rdbtnDonut.addChangeListener(eventHandler);
	    rdbtnRectangle.addChangeListener(eventHandler);
	    rdbtnHexagon.addChangeListener(eventHandler);
	    
	  
	    
	    pnlCreateSelect.add(new JLabel("                "));
	    pnlCreateSelect.add(tglbtnSelect);
	    pnlNorth.add(pnlCreateSelect);
	    
	    pnlNorthButton.add(new JLabel("     SET EDGE COLOR:    "));
	    pnlNorthButton.add(btnSelectEdgeColor);
	    pnlNorthButton.add(new JLabel("     SET INNER COLOR:    "));
	    pnlNorthButton.add(btnSelectInnerColor);
	    pnlNorthButton.add(new JLabel("       "));
	    pnlNorthButton.add(next);
	    pnlNorthButton.add(previous);
	    pnlNorthButton.add(cancel);
	    pnlNorthButton.add(accept);
	    pnlNorth.add(pnlNorthButton);
	    
		add(pnlNorth, BorderLayout.NORTH);
		
		
		
		for(Component btn : pnlCreateSelect.getComponents()) {
		    	btn.setBackground(new Color(255,255,150));
		 }
		
		btnSelectEdgeColor.setBackground(new Color(0,0,250));
		btnSelectInnerColor.setBackground(new Color(0,0,250));
		
		
	}
	
	
		
	
	
	private void setMenu(JMenuBar menuBar) {
		

		
		JMenu fileMenu = new JMenu("FILE");
		JMenuItem open = new JMenuItem("OPEN");
		JMenuItem save = new JMenuItem("SAVE");
		JMenuItem saveLogo = new JMenuItem("SAVE AS LOGO");
		JMenuItem loadLogo = new JMenuItem("LOAD LOGO");
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveLogo);
		fileMenu.add(loadLogo);
		open.addActionListener(buttonControlor);
		save.addActionListener(buttonControlor);
		saveLogo.addActionListener(logoControlor);
		loadLogo.addActionListener(logoControlor);
	
		JMenu editMenu = new JMenu("EDIT");
		
		editMenu.add(menuItemUndo);
		editMenu.add(menuItemRedo);
		editMenu.add(menuItemModify);
		editMenu.add(menuItemDelete);
		editMenu.add(menuItemToBack);
		editMenu.add(menuItemToFront);
		editMenu.add(menuItemBringToBack);
		editMenu.add(menuItemBringToFront);
		menuItemUndo.addActionListener(buttonControlor);
		menuItemRedo.addActionListener(buttonControlor);
		menuItemModify.addActionListener(buttonControlor);
		menuItemDelete.addActionListener(buttonControlor);
		menuItemToBack.addActionListener(buttonControlor);
		menuItemToFront.addActionListener(buttonControlor);
		menuItemBringToBack.addActionListener(buttonControlor);
		menuItemBringToFront.addActionListener(buttonControlor);
		
		menuItemUndo.setActionCommand("UNDO");
		menuItemRedo.setActionCommand("REDO");
		
		
		
		
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(new JMenu("HELP"));
		
	}
	
	private class ChangeEventHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if(((JRadioButton)e.getSource()).isSelected()) {
				if(model.isShapeSelected()) {
					//UnselectAll comm = new UnselectAll(model.getSelectedShapes());
					//model.execute(comm);
					//getConsole().append(comm.stringForLogo(CommandTextType.CONSOLE) + "\n");
					//mainPanel.repaint();
				}
			}
			
		}
		
	}
	
	

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if(evt.getPropertyName().equals("oneselect")) {
			
			menuItemModify.setEnabled(true);
			menuItemDelete.setEnabled(true);
			
			menuItemToBack.setEnabled(true);
			menuItemToFront.setEnabled(true);
			
			menuItemBringToBack.setEnabled(true);
			menuItemBringToFront.setEnabled(true);
			this.tglbtnSelect.setSelected(true);
			
			
		}
		
		else if(evt.getPropertyName().equals("moreselect")) {
			
			menuItemModify.setEnabled(false);
			menuItemDelete.setEnabled(true);
			
			menuItemToBack.setEnabled(false);
			menuItemToFront.setEnabled(false);
			
			menuItemBringToBack.setEnabled(false);
			menuItemBringToFront.setEnabled(false);
			this.tglbtnSelect.setSelected(true);
			
		}
		
		else if(evt.getPropertyName().equals("noselect")) {
			
			menuItemModify.setEnabled(false);
			menuItemDelete.setEnabled(false);
			
			menuItemToBack.setEnabled(false);
			menuItemToFront.setEnabled(false);
			menuItemBringToBack.setEnabled(false);
			menuItemBringToFront.setEnabled(false);
			
		}
		
		else if(evt.getPropertyName().equals("undoDisable")) {
			menuItemUndo.setEnabled(false);
			
		}
		else if(evt.getPropertyName().equals("undoEnable")) {
			menuItemUndo.setEnabled(true);	
					
					
		}
		else if(evt.getPropertyName().equals("redoDisable")) {
			menuItemRedo.setEnabled(false);
			
			
		}
		else if(evt.getPropertyName().equals("redoEnable")) {
			
			menuItemRedo.setEnabled(true);
			
		}
		
		
	}
	
	
	
	
	

	public Model getModel() {
		return model;
	}
	



	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	
	public JRadioButton getRdbtnPoint() {
		return rdbtnPoint;
	}

	

	public JRadioButton getRdbtnLine() {
		return rdbtnLine;
	}

	

	public JRadioButton getRdbtnCircle() {
		return rdbtnCircle;
	}

	

	public JRadioButton getRdbtnDonut() {
		return rdbtnDonut;
	}

	

	public JRadioButton getRdbtnRectangle() {
		return rdbtnRectangle;
	}
	
	public JRadioButton getRdbtnHexagon() {
		return rdbtnHexagon;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public JTextArea getConsole() {
		return textArea;
	}
	


	

	
}
