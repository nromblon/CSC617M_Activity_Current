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

public class VaultPassword extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	private JPanel parent;
	private Character player;

	private JLabel lblOverlay;
	private JLabel lblCircle;
	private JPanel pnlCode;

	private JTextField txtf1;
	private JTextField txtf2;
	private JTextField txtf3;
	private JTextField txtf4;

	private JButton btnEnter;
	
	public VaultPassword(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_overlay.png"), null);
		
		this.add(btnEnter);
		this.add(lblCircle);
		this.add(pnlCode);
		this.add(lblOverlay);

		this.close();
	}
	
	private void initComponents() {		
		this.lblOverlay = new JLabel();
		
		Game.initLabels(this.lblOverlay, new ImageIcon("images/Gamebar_versus_player1.png"), null);

		this.btnEnter = new JButton();
		Game.initButtons(btnEnter, "btnVaultEnter", 280, 460, true, this);
		
		this.lblCircle = new JLabel();
		Game.initLabels(this.lblCircle, new ImageIcon("images/VaultCircle_default.png"), null);
		lblCircle.setLocation(632, 258);
		
		this.pnlCode = new JPanel();
		Game.initPanel(pnlCode, Game.clrTransparent, 390, 100);
		pnlCode.setLocation(184, 302);
		
		
		int offsetX = 14;
		this.txtf1 = new JTextField();
		Game.initTextField(txtf1, 0, 0, 87, 100, Game.fntConsolas30, Game.clrAutomatic);
		
		this.txtf2 = new JTextField();
		Game.initTextField(txtf2, txtf1.getX()+txtf1.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);
		
		this.txtf3 = new JTextField();
		Game.initTextField(txtf3, txtf2.getX()+txtf2.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);
		
		this.txtf4 = new JTextField();
		Game.initTextField(txtf4, txtf3.getX()+txtf3.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);

		this.initTextFields();
		
		this.pnlCode.add(this.txtf1);
		this.pnlCode.add(this.txtf2);
		this.pnlCode.add(this.txtf3);
		this.pnlCode.add(this.txtf4);
	}
	
	public void initTextFields() {
//		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
//		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
//		decimalFormat.setGroupingUsed(false);
//		txtf1 = new JFormattedTextField(decimalFormat);
//		txtf1.setColumns(1);
//		
//		txtf2 = new JFormattedTextField(decimalFormat);
//		txtf2.setColumns(1);
//		
//		txtf3 = new JFormattedTextField(decimalFormat);
//		txtf3.setColumns(1);
//		
//		txtf4 = new JFormattedTextField(decimalFormat);
//		txtf4.setColumns(1);
		
		AbstractDocument d1 = (AbstractDocument) txtf1.getDocument();
		d1.setDocumentFilter(new DocumentFilter(){
		    int max = 1;
		    @Override
		    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        int documentLength = fb.getDocument().getLength();
		        if (documentLength - length + text.length() <= max)
		        	super.replace(fb, offset, length, text.toUpperCase(), attrs);
		         
		    }
		});
		
		AbstractDocument d2 = (AbstractDocument) txtf1.getDocument();
		d2.setDocumentFilter(new DocumentFilter(){
		    int max = 1;
		    @Override
		    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        int documentLength = fb.getDocument().getLength(); 
		            if (documentLength - length + text.length() <= max)
		        super.replace(fb, offset, length, text.toUpperCase(), attrs);
		    }
		});
		
		AbstractDocument d3 = (AbstractDocument) txtf1.getDocument();
		d3.setDocumentFilter(new DocumentFilter(){
		    int max = 1;
		    @Override
		    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        int documentLength = fb.getDocument().getLength(); 
		            if (documentLength - length + text.length() <= max)
		        super.replace(fb, offset, length, text.toUpperCase(), attrs);
		    }
		});
		
		AbstractDocument d4 = (AbstractDocument) txtf1.getDocument();
		d4.setDocumentFilter(new DocumentFilter(){
		    int max = 1;
		    @Override
		    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        int documentLength = fb.getDocument().getLength(); 
		            if (documentLength - length + text.length() <= max)
		        super.replace(fb, offset, length, text.toUpperCase(), attrs);
		    }
		});		
				
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
		if(e.getSource() == this.btnEnter) {
			//TODO Check PIN
			this.close();
		}
	}
}
