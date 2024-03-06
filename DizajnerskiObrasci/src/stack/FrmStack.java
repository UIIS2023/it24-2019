package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class FrmStack extends JFrame {
    
	private JPanel contentPane;
	JList listStack = new JList();
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	
	
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setTitle("Natasa Jovanovic IT24/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.CYAN);
		
		JPanel panelSouth = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
						.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(41))
		);
		
		JScrollPane scrollPaneStack = new JScrollPane();
		
		JLabel lblName = new JLabel("ADD RACTANGLES ON STACK");
		lblName.setFont(new Font("SansSerif", lblName.getFont().getStyle(), lblName.getFont().getSize() + 3));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneStack, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addComponent(lblName)
					.addGap(7)
					.addComponent(scrollPaneStack, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JList listStack_1 = new JList();
		scrollPaneStack.setViewportView(listStack_1);
		listStack_1.setModel(dlm);
		panelCenter.setLayout(gl_panelCenter);
		
		JButton btnAdd = new JButton("Add rectangle");
		btnAdd.setBackground(Color.lightGray);
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("SansSerif", btnAdd.getFont().getStyle(), btnAdd.getFont().getSize() + 2));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgStack dlgRactk= new DlgStack();
				dlgRactk.setVisible(true);
				if(dlgRactk.isOk) {
					String element= ("Upper left point=( " + dlgRactk.getTxtX().getText() + " "+ ","+ " " +  dlgRactk.getTxtY().getText() + " " + "), width= " + dlgRactk.getTxtWidth().getText() + " height= " + dlgRactk.getTxtHeight().getText());
					dlm.add(0, element);
				}
			}
			
		});
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnDelete = new JButton("Delete rectangle");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("SansSerif", btnDelete.getFont().getStyle(), btnDelete.getFont().getSize() + 2));
		btnDelete.setBackground(Color.lightGray);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dlm.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "List is empty!");
				}
				else if(listStack_1.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "You must select a row!");
				} 
				else {
					DlgStack dlgDelete = new DlgStack();
					String[] split= dlm.getElementAt(listStack_1.getSelectedIndex()).toString().split(" ");
					int index = listStack_1.getSelectedIndex();
					dlgDelete.getTxtX().setText(split[3]);
					dlgDelete.getTxtY().setText(split[5]);
					dlgDelete.getTxtWidth().setText(split[8]);
					dlgDelete.getTxtHeight().setText(split[10]);
					dlgDelete.getTxtX().setEditable(false);
					dlgDelete.getTxtY().setEditable(false);
					dlgDelete.getTxtWidth().setEditable(false);
					dlgDelete.getTxtHeight().setEditable(false);
					dlgDelete.setVisible(true);
					
					if(dlgDelete.isOk) {
						dlm.remove(0);
					}
					
				}
			}
		}
		);
		GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
		gl_panelSouth.setHorizontalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addGap(111)
					.addComponent(btnAdd)
					.addGap(51)
					.addComponent(btnDelete)
					.addGap(210))
		);
		gl_panelSouth.setVerticalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelSouth.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnDelete)))
		);
		panelSouth.setLayout(gl_panelSouth);
		contentPane.setLayout(gl_contentPane);
		
	}
}
