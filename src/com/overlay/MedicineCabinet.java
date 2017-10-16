package com.overlay;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

public class MedicineCabinet extends OverlayObject {
	private static final long serialVersionUID = 1L;

	private JButton btnEnter;
	
	private JButton btnSlot1;
	private JButton btnSlot2;
	private JButton btnSlot3;
	private JButton btnSlot4;
	private JButton btnSlot5;

	private ImageIcon iiIcon1;
	private ImageIcon iiIcon2;
	private ImageIcon iiIcon3;
	private ImageIcon iiIcon4;
	private ImageIcon iiIcon5;
	
	private ImageIcon iiIcon1_on;
	private ImageIcon iiIcon2_on;
	private ImageIcon iiIcon3_on;
	private ImageIcon iiIcon4_on;
	private ImageIcon iiIcon5_on;
	
	private int indexSlot1;
	private int indexSlot2;
	private int indexSlot3;
	private int indexSlot4;
	private int indexSlot5;
	
	private ArrayList<ImageIcon> listImageIcon;
	private ArrayList<ImageIcon> listImageIcon_on;
	
	
	
	public MedicineCabinet(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		

		this.add(btnSlot1);
		this.add(btnSlot2);
		this.add(btnSlot3);
		this.add(btnSlot4);
		this.add(btnSlot5);
		
		this.add(btnEnter);
		this.add(lblOverlay);

		this.close();
	}
	
	private void initComponents() {		
		this.lblOverlay = new JLabel();		
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_medicinecabinet.png"), null);

		this.btnEnter = new JButton();
		Game.initButtons(btnEnter, "btnMedicineCabinetEnter", 427, 455, true, this);

		this.iiIcon1 = new ImageIcon("images/Icon1.png");
		this.iiIcon2 = new ImageIcon("images/Icon2.png");
		this.iiIcon3 = new ImageIcon("images/Icon3.png");
		this.iiIcon4 = new ImageIcon("images/Icon4.png");
		this.iiIcon5 = new ImageIcon("images/Icon5.png");
		
		this.iiIcon1_on = new ImageIcon("images/Icon1_on.png");
		this.iiIcon2_on = new ImageIcon("images/Icon2_on.png");
		this.iiIcon3_on = new ImageIcon("images/Icon3_on.png");
		this.iiIcon4_on = new ImageIcon("images/Icon4_on.png");
		this.iiIcon5_on = new ImageIcon("images/Icon5_on.png");
		
		this.listImageIcon = new ArrayList<ImageIcon>();
		listImageIcon.add(this.iiIcon1);
		listImageIcon.add(this.iiIcon2);
		listImageIcon.add(this.iiIcon3);
		listImageIcon.add(this.iiIcon4);
		listImageIcon.add(this.iiIcon5);
		
		this.listImageIcon_on = new ArrayList<ImageIcon>();
		listImageIcon_on.add(this.iiIcon1_on);
		listImageIcon_on.add(this.iiIcon2_on);
		listImageIcon_on.add(this.iiIcon3_on);
		listImageIcon_on.add(this.iiIcon4_on);
		listImageIcon_on.add(this.iiIcon5_on);
		
		this.btnSlot1 = new JButton();
		Game.initButtons(btnSlot1, "Icon1", 280, 297, true, this);
		
		this.btnSlot2 = new JButton();
		Game.initButtons(btnSlot2, "Icon1", 381, 297, true, this);

		this.btnSlot3 = new JButton();
		Game.initButtons(btnSlot3, "Icon1", 482, 297, true, this);

		this.btnSlot4 = new JButton();
		Game.initButtons(btnSlot4, "Icon1", 583, 297, true, this);

		this.btnSlot5 = new JButton();
		Game.initButtons(btnSlot5, "Icon1", 684, 297, true, this);


		this.setIndexSlot1(0);
		this.setIndexSlot2(0);
		this.setIndexSlot3(0);
		this.setIndexSlot4(0);
		this.setIndexSlot5(0);
		
	}
	
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(e.getSource() == this.btnSlot1) {
			this.setSlot1(this.getIndexSlot1()+1);
		}
		
		if(e.getSource() == this.btnSlot2) {
			this.setSlot2(this.getIndexSlot2()+1);
		}
		
		if(e.getSource() == this.btnSlot3) {
			this.setSlot3(this.getIndexSlot3()+1);
		}
		
		if(e.getSource() == this.btnSlot4) {
			this.setSlot4(this.getIndexSlot4()+1);
		}
		
		if(e.getSource() == this.btnSlot5) {
			this.setSlot5(this.getIndexSlot5()+1);
		}
		
		if(e.getSource() == this.btnEnter) {
			if(this.checkPin()) {
				this.close();
			}
			else {
				Game.M.play("SE1.wav", 0);
				this.reset();
			}
		}
	}
	
	public void reset() {
		this.setSlot1(0);
		this.setSlot2(0);
		this.setSlot3(0);
		this.setSlot4(0);
		this.setSlot5(0);
	}
	
	public void setSlot1(int slot) {
		this.setIndexSlot1(slot);
		btnSlot1.setIcon(listImageIcon.get(this.getIndexSlot1()));
		btnSlot1.setRolloverIcon(listImageIcon_on.get(this.getIndexSlot1()));
		btnSlot1.setPressedIcon(listImageIcon_on.get(this.getIndexSlot1()));
	}
	
	public void setSlot2(int slot) {
		this.setIndexSlot2(slot);
		btnSlot2.setIcon(listImageIcon.get(this.getIndexSlot2()));
		btnSlot2.setRolloverIcon(listImageIcon_on.get(this.getIndexSlot2()));
		btnSlot2.setPressedIcon(listImageIcon_on.get(this.getIndexSlot2()));
	}
	
	public void setSlot3(int slot) {
		this.setIndexSlot3(slot);
		btnSlot3.setIcon(listImageIcon.get(this.getIndexSlot3()));
		btnSlot3.setRolloverIcon(listImageIcon_on.get(this.getIndexSlot3()));
		btnSlot3.setPressedIcon(listImageIcon_on.get(this.getIndexSlot3()));
	}
	
	public void setSlot4(int slot) {
		this.setIndexSlot4(slot);
		btnSlot4.setIcon(listImageIcon.get(this.getIndexSlot4()));
		btnSlot4.setRolloverIcon(listImageIcon_on.get(this.getIndexSlot4()));
		btnSlot4.setPressedIcon(listImageIcon_on.get(this.getIndexSlot4()));
	}
	
	public void setSlot5(int slot) {
		this.setIndexSlot5(slot);
		btnSlot5.setIcon(listImageIcon.get(this.getIndexSlot5()));
		btnSlot5.setRolloverIcon(listImageIcon_on.get(this.getIndexSlot5()));
		btnSlot5.setPressedIcon(listImageIcon_on.get(this.getIndexSlot5()));
	}
	
	public boolean checkPin() {
		if(this.getIndexSlot1() == 0 &&
				this.getIndexSlot2() == 1 &&
				this.getIndexSlot3() == 2 &&
				this.getIndexSlot4() == 3 &&
				this.getIndexSlot5() == 4) {
			return true;
		}
		else
			return false;
	}

	public int getIndexSlot1() {
		return indexSlot1;
	}

	public void setIndexSlot1(int indexSlot1) {
		if(indexSlot1 < listImageIcon.size())
			this.indexSlot1 = indexSlot1;
		else
			this.indexSlot1 = 0;
	}

	public int getIndexSlot2() {
		return indexSlot2;
	}

	public void setIndexSlot2(int indexSlot2) {
		if(indexSlot2 < listImageIcon.size())
			this.indexSlot2 = indexSlot2;
		else
			this.indexSlot2 = 0;
	}

	public int getIndexSlot3() {
		return indexSlot3;
	}

	public void setIndexSlot3(int indexSlot3) {
		if(indexSlot3 < listImageIcon.size())
			this.indexSlot3 = indexSlot3;
		else
			this.indexSlot3 = 0;
	}

	public int getIndexSlot4() {
		return indexSlot4;
	}

	public void setIndexSlot4(int indexSlot4) {
		if(indexSlot4 < listImageIcon.size())
			this.indexSlot4 = indexSlot4;
		else
			this.indexSlot4 = 0;
	}

	public int getIndexSlot5() {
		return indexSlot5;
	}

	public void setIndexSlot5(int indexSlot5) {
		if(indexSlot5 < listImageIcon.size())
			this.indexSlot5 = indexSlot5;
		else
			this.indexSlot5 = 0;
	}
}
