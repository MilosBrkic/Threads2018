package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JSeparator;

public class ThreadsGUI extends JFrame {

	private JPanel panel;
	protected JTextArea textArea;
	private JScrollPane scrollPane;
	protected JButton btnStart;
	protected JButton btnStop;
	protected JButton btnFirst;
	protected JButton btnSecond;
	protected JButton btnThird;
	private JButton btnClean;
	protected JLabel lblThread;
	private JPanel panelCenter;
	private JPanel panelWest;
	private JPanel panel_1;
	private JSeparator separator;
	private JSeparator separator_1;


	/**
	 * Create the frame.
	 */
	public ThreadsGUI() {
		setMinimumSize(new Dimension(300, 300));
		setTitle("Threads");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(getPanelCenter(), BorderLayout.CENTER);
		panel.add(getPanelWest(), BorderLayout.WEST);
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start all");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.startAll();	
				}
			});
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.stop();
				}
			});
		}
		return btnStop;
	}
	private JButton getBtnFirst() {
		if (btnFirst == null) {
			btnFirst = new JButton("First");
			btnFirst.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnFirst.setEnabled(false);
					GUIKontroler.start(true, false, false);
				}
			});
		}
		return btnFirst;
	}
	private JButton getBtnSecond() {
		if (btnSecond == null) {
			btnSecond = new JButton("Second");
			btnSecond.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSecond.setEnabled(false);
					GUIKontroler.start(false, true, false);
				}
			});
		}
		return btnSecond;
	}
	private JButton getBtnThird() {
		if (btnThird == null) {
			btnThird = new JButton("Third");
			btnThird.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnThird.setEnabled(false);
					GUIKontroler.start(false, false, true);
				}
			});
		}
		return btnThird;
	}
	private JButton getBtnClean() {
		if (btnClean == null) {
			btnClean = new JButton("Clean");
			btnClean.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
				}
			});
		}
		return btnClean;
	}
	private JLabel getLblThread() {
		if (lblThread == null) {
			lblThread = new JLabel("");
			lblThread.setBounds(0, 0, 215, 29);
		}
		return lblThread;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new BorderLayout(0, 0));
			panelCenter.add(getPanel_1(), BorderLayout.NORTH);
			panelCenter.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelCenter;
	}
	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setLayout(new MigLayout("", "[90.00,grow,fill]", "[][][][][][][][][grow]"));
			panelWest.add(getBtnStart(), "cell 0 0,grow");
			panelWest.add(getSeparator_1(), "cell 0 1");
			panelWest.add(getBtnFirst(), "cell 0 2,grow");
			panelWest.add(getBtnSecond(), "cell 0 3,grow");
			panelWest.add(getBtnThird(), "cell 0 4,grow");
			panelWest.add(getSeparator(), "cell 0 5");
			panelWest.add(getBtnStop(), "cell 0 6,grow");
			panelWest.add(getBtnClean(), "cell 0 7,grow");
		}
		return panelWest;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(100, 30));
			panel_1.setMinimumSize(new Dimension(100, 50));
			panel_1.setMaximumSize(new Dimension(100, 50));
			panel_1.setLayout(null);
			panel_1.add(getLblThread());
		}
		return panel_1;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
}
