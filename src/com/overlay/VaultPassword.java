package com.overlay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

import world.GameWorld;

public class VaultPassword extends OverlayObject implements ActionListener{
	private static final long serialVersionUID = 1L;
	
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
		
//		this.close();
	}
	
	private void initComponents() {		
		this.lblOverlay = new JLabel();
		
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_vault.png"), null);

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
		this.txtf1.setHorizontalAlignment(JTextField.CENTER);
		
		this.txtf2 = new JTextField();
		Game.initTextField(txtf2, txtf1.getX()+txtf1.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);
		this.txtf2.setHorizontalAlignment(JTextField.CENTER);
		
		this.txtf3 = new JTextField();
		Game.initTextField(txtf3, txtf2.getX()+txtf2.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);
		this.txtf3.setHorizontalAlignment(JTextField.CENTER);
		
		this.txtf4 = new JTextField();
		Game.initTextField(txtf4, txtf3.getX()+txtf3.getWidth()+offsetX, 0, 87, 100, txtf1.getFont(), Game.clrAutomatic);
		this.txtf4.setHorizontalAlignment(JTextField.CENTER);

		this.initTextFields();
		
		this.pnlCode.add(this.txtf1);
		this.pnlCode.add(this.txtf2);
		this.pnlCode.add(this.txtf3);
		this.pnlCode.add(this.txtf4);
	}
	
	public void initTextFields() {		
		PlainDocument doc = (PlainDocument) txtf1.getDocument();
		doc.setDocumentFilter(new MyIntFilter());
		this.txtf1.addActionListener(this);
				
		doc = (PlainDocument) txtf2.getDocument();
		doc.setDocumentFilter(new MyIntFilter());
		this.txtf2.addActionListener(this);
		
		doc = (PlainDocument) txtf3.getDocument();
		doc.setDocumentFilter(new MyIntFilter());
		this.txtf3.addActionListener(this);
		
		doc = (PlainDocument) txtf4.getDocument();
		doc.setDocumentFilter(new MyIntFilter());
		this.txtf4.addActionListener(this);
		
		this.setTextFields("0");
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
			this.correctPin();
//			if(this.correctPin())
//				this.close();
		}
	}
	
	private boolean correctPin() {
		if(this.parsePin() == GameWorld.VAULT_PIN) {
			this.lblCircle.setIcon(new ImageIcon("images/VaultCircle_right.png"));
			return true;
		}
		else {
			this.lblCircle.setIcon(new ImageIcon("images/VaultCircle_wrong.png"));
			Game.M.play("SE1.wav", 0);
			this.setTextFields("0");
			return false;
		}
	}
	
	private int parsePin() {
		String pin = this.txtf1.getText() + this.txtf2.getText() + this.txtf3.getText() + this.txtf4.getText();
		int nPin = 0;
		
		try {
			nPin = Integer.parseInt(pin);
			return nPin;
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	private void setTextFields(String text) {
		this.txtf1.setText(text);
		this.txtf2.setText(text);
		this.txtf3.setText(text);
		this.txtf4.setText(text);
	}
	
	class MyIntFilter extends DocumentFilter {
		   @Override
		   public void insertString(FilterBypass fb, int offset, String string,
		         AttributeSet attr) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, 1));
		      sb.insert(offset, string);

		      if (test(sb.toString())) {
		         super.insertString(fb, offset, string, attr);
		      } else {
		         // warn the user and don't allow the insert
		      }
		   }

		   private boolean test(String text) {
			  if(text.equals(""))
				  return true;
			  if(text.length() > 1)
				  return false;
			  
		      try {
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		         return false;
		      }
		   }

		   @Override
		   public void replace(FilterBypass fb, int offset, int length, String text,
		         AttributeSet attrs) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.replace(offset, offset + length, text);

		      if (test(sb.toString())) {
		         super.replace(fb, offset, length, text, attrs);
		      } else {
		         // warn the user and don't allow the insert
		      }

		   }

		   @Override
		   public void remove(FilterBypass fb, int offset, int length)
		         throws BadLocationException {
		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.delete(offset, offset + length);

		      if (test(sb.toString())) {
		         super.remove(fb, offset, length);
		      } else {
		         // warn the user and don't allow the insert
		      }

		   }
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.correctPin();
	}

	
}
