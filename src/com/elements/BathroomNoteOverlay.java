package com.elements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.characters.Character;

public class BathroomNoteOverlay extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	private JPanel parent;
	private Character player;

	private JLabel lblOverlay;
	
	public BathroomNoteOverlay(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		

		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_bathroomnote.png"), null);
	}
	
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
	}
}
