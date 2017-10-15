package com.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.characters.Player;
import com.elements.Game;

import world.Room;

public class CharacterSelect extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private JFrame parent;
	private MapSelect mapSelect;
	
	private boolean isSet;
	private boolean isReady;
	private boolean isEscape;
	
	private int selectedChara;
	private int selectedClass;
	
	private JPanel pnlImage;
	
	private JLabel lblBackground;
	private JLabel lblImage;
	private JLabel lblClass;
	private JLabel lblName;
	
	private ImageIcon iiChara1;
	private ImageIcon iiChara1_2;
//	
//	private ImageIcon iiChara2;
//	private ImageIcon iiChara2_2;
//	
//	private ImageIcon iiChara3;
//	private ImageIcon iiChara3_2;
//	
//	private ImageIcon iiChara4;
//	
//	private ImageIcon iiChara5;
//	private ImageIcon iiChara5_2;
//	
//	private ImageIcon iiChara6;
//	private ImageIcon iiChara7;
//	
//	private ImageIcon iiChara8;
//	private ImageIcon iiChara8_2;
//	
//	private ImageIcon iiChara9;
//	private ImageIcon iiChara10;
//	private ImageIcon iiChara11;
	
	private JButton btnStart;
	
//	private JButton btnChara1;
//	private JButton btnChara2;
//	private JButton btnChara3;
//	
//	private JButton btnChara4;
//	private JButton btnChara5;
//	private JButton btnChara6;
//	
//	private JButton btnChara7;
//	private JButton btnChara8;
//	private JButton btnChara9;
//	
//	private JButton btnChara10;
//	private JButton btnChara11;
//	private JButton btnChara12;
//	
	private JButton btnClass1;
	private JButton btnClass2;
	private JButton btnClass3;

	private Timer tmrFocus;


	public CharacterSelect(JFrame parent) {
		this.parent = parent;
		this.initComponents();		

		this.add(this.mapSelect);
		this.add(btnStart);
		
		this.add(btnClass1);
		this.add(btnClass2);
//		this.add(btnClass3);
		
		this.add(lblClass);
		this.add(lblName);
		this.add(pnlImage);
		
		this.add(lblBackground);
		this.parent.revalidate();
		this.parent.repaint();
		
		this.selectedChara = 1;
		this.selectedClass = 1;
		this.select(this.selectedChara);
		
		this.isSet = false;
		this.isReady = false;
		this.isEscape = false;

		this.tmrFocus = new Timer(0, this);
		this.tmrFocus.start();
//		Game.M.play("SE1.wav", Clip.LOOP_CONTINUOUSLY);
//		Game.M.sound("SE1.wav", Clip.LOOP_CONTINUOUSLY);
	}
	
	public void initComponents() {
		int offsetY = 14;
		
		Game.initPanel(this, Color.GRAY, 0, 0, Game.MAX_WIDTH, Game.MAX_WIDTH);
		
		this.mapSelect = new MapSelect(this);
		this.mapSelect.setVisible(false);
		
		
		this.btnClass1 = new JButton();
		this.btnClass2 = new JButton();
		this.btnClass3 = new JButton();
		
//		Game.initButtons(this.btnClass1, "Class", 829, 200, true, this);
//		Game.initButtons(this.btnClass2, "Class", btnClass1.getX(), btnClass1.getY()+btnClass1.getHeight()+offsetY, true, this);
//		Game.initButtons(this.btnClass3, "Class", btnClass1.getX(), btnClass2.getY()+btnClass2.getHeight()+offsetY, true, this);

//		Game.initButtons(this.btnClass1, "Class", 829, 200, true, this);
		Game.initButtons(this.btnClass1, "Class", 829, 292+offsetY, true, this);
		Game.initButtons(this.btnClass2, "Class", btnClass1.getX(), btnClass1.getY()+btnClass1.getHeight()+offsetY, true, this);
		Game.initButtons(this.btnClass3, "Class", btnClass1.getX(), btnClass2.getY()+btnClass2.getHeight()+offsetY, true, this);

		this.pnlImage = new JPanel();
		Game.initPanel(this.pnlImage, Game.clrBlack70, 394, 144, 474, 528);
		
		this.lblImage = new JLabel();
		Game.initLabel(this.lblImage, Game.fntGothamLight12, Color.WHITE, 22, 22, 430, 484);
		this.lblImage.setVerticalAlignment(JLabel.TOP);
		
		this.pnlImage.add(this.lblImage);
		
		this.btnStart = new JButton();
//		Game.initButtons(this.btnStart, Game.clrTransparent, 995, 23, 371, 74, this);
		Game.initButtons(this.btnStart, "btnStart", 995, 23, true, this);
		this.btnStart.setOpaque(false);
		this.btnStart.setContentAreaFilled(false);
		
		this.lblBackground = new JLabel();
		Game.initLabels(this.lblBackground, "CharacterSelect", null);
		
		this.lblClass = new JLabel("JOB CLASS");
		Game.initLabel(this.lblClass, Game.fntGothamLight29, Game.clrBlack70, 379, 571, 451, 66);
		lblClass.setForeground(Color.WHITE);
		
		this.lblName = new JLabel("NAME");
		Game.initLabel(this.lblName, Game.fntGothamLight29, Game.clrBlack70, 394, 74, 474, 58);
		lblName.setForeground(Color.WHITE);
		
//		this.btnChara1 = new JButton();
//		this.btnChara2 = new JButton();
//		this.btnChara3 = new JButton();
//		
//		this.btnChara4 = new JButton();
//		this.btnChara5 = new JButton();
//		this.btnChara6 = new JButton();
//		
//		this.btnChara7 = new JButton();
//		this.btnChara8 = new JButton();
//		this.btnChara9 = new JButton();
//
//		this.btnChara10 = new JButton();
//		this.btnChara11 = new JButton();
//		this.btnChara12 = new JButton();
		
		offsetY = 8;
		
//		Game.initButtons(this.btnChara1, "Chara1", 39, 36, true, this);
//		Game.initButtons(this.btnChara2, "Chara2", btnChara1.getX()+btnChara1.getWidth()+offsetX, btnChara1.getY(), true, this);
//		Game.initButtons(this.btnChara3, "Chara3", btnChara2.getX()+btnChara2.getWidth()+offsetX, btnChara2.getY(), true, this);
//		
//		Game.initButtons(this.btnChara4, "Chara4", btnChara1.getX(), btnChara1.getY()+btnChara1.getHeight()+offsetY, true, this);
//		Game.initButtons(this.btnChara5, "Chara5", btnChara2.getX(), btnChara4.getY(), true, this);
//		Game.initButtons(this.btnChara6, "Chara6", btnChara3.getX(), btnChara4.getY(), true, this);
//		
//		Game.initButtons(this.btnChara7, "Chara7", btnChara1.getX(), 540, true, this);
//		Game.initButtons(this.btnChara8, "Chara8", btnChara2.getX(), btnChara7.getY(), true, this);
//		Game.initButtons(this.btnChara9, "Chara9", btnChara3.getX(), btnChara7.getY(), true, this);
//		
//		Game.initButtons(this.btnChara10, "Chara10", btnChara1.getX(), btnChara7.getY()+btnChara7.getHeight()+offsetY, true, this);
//		Game.initButtons(this.btnChara11, "Chara11", btnChara2.getX(), btnChara10.getY(), true, this);
//		Game.initButtons(this.btnChara12, Game.clrBlack70, btnChara3.getX(), btnChara11.getY(), 92, 92, this);
//		
//		
		this.iiChara1 = new ImageIcon("images/Maynard_arcadePic.png");
		this.iiChara1_2 = new ImageIcon("images/Neil_arcadePic.png");
//		
//		this.iiChara2 = new ImageIcon("images/Josm_arcadePic.png");
//		this.iiChara2_2 = new ImageIcon("images/jOS_arcadePic.png");
//		
//		this.iiChara3 = new ImageIcon("images/Neil_arcadePic.png");
//		this.iiChara3_2 = new ImageIcon("images/Protacio_arcadePic.png");
//		
//		
//		this.iiChara4 = new ImageIcon("images/Gyra_arcadePic.png");
//		
//		this.iiChara5 = new ImageIcon("images/Chino_arcadePic.png");
//		this.iiChara5_2 = new ImageIcon("images/FroshChino_arcadePic.png");
//		
//		this.iiChara6 = new ImageIcon("images/Jarl_arcadePic.png");
//		this.iiChara7 = new ImageIcon("images/JJ_arcadePic.png");
//		
//		this.iiChara8 = new ImageIcon("images/Jazz_arcadePic.png");
//		this.iiChara8_2 = new ImageIcon("images/EDMJazz_arcadePic.png");
//		
//		this.iiChara9 = new ImageIcon("images/Amze_arcadePic.png");
//		this.iiChara10 = new ImageIcon("images/Luis_arcadePic.png");
//		this.iiChara11 = new ImageIcon("images/Xei_arcadePic.png");
		
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new TAdapter());
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor( getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	public void selectClass(int selected) {
		this.deselectAllClass();		
		
		this.btnClass1.setIcon(new ImageIcon("images/Chara"+this.selectedChara+"_Class1.png"));
		this.btnClass1.setRolloverIcon(new ImageIcon("images/Chara"+this.selectedChara+"_Class1_on.png"));
		
		/*
		 * Condition for those who have a Second Class 
		 */
//		if(this.selectedChara == 1 || this.selectedChara == 2 || this.selectedChara == 3 || this.selectedChara == 5 || this.selectedChara == 8) {
			this.btnClass2.setIcon(new ImageIcon("images/Chara"+this.selectedChara+"_Class2.png"));
			this.btnClass2.setRolloverIcon(new ImageIcon("images/Chara"+this.selectedChara+"_Class2_on.png"));
//			this.btnClass3.setIcon(new ImageIcon("images/Chara"+this.selectedChara+"_Class3.png"));
//		}
//		else {
//			selected = 1;
//		}
		
		this.selectedClass = selected;
		switch(this.selectedClass) {
			case 1: this.btnClass1.setIcon(btnClass1.getRolloverIcon());
			break;
			case 2: this.btnClass2.setIcon(btnClass2.getRolloverIcon());
			break;
			case 3: this.btnClass3.setIcon(btnClass3.getRolloverIcon());
			break;
		}
		
		switch(this.selectedClass) {
		case 2:
			this.lblClass.setText("MAY");
			this.lblImage.setIcon(this.iiChara1_2);
			break;
		default:
			this.lblClass.setText("DEFAULT");
			this.lblImage.setIcon(this.iiChara1);
	}
//		
//		switch(this.selectedChara) {
//		case 1: 
//				switch(this.selectedClass) {
//					case 2:
//						this.lblClass.setText("MAY");
//						this.lblImage.setIcon(this.iiChara1_2);
//						break;
//					default:
//						this.lblClass.setText("DEFAULT");
//						this.lblImage.setIcon(this.iiChara1);
//				}
//				
//				break;
//		case 2:
//				switch(this.selectedClass) {
//				case 2:
//					this.lblClass.setText("jOS");
//					this.lblImage.setIcon(this.iiChara2_2);
//					break;
//				default:
//					this.lblClass.setText("DEFAULT");
//					this.lblImage.setIcon(this.iiChara2);
//			}
//				break;
//		case 3:
//				switch(this.selectedClass) {
//					case 2:
//						this.lblClass.setText("PROTACIO");
//						this.lblImage.setIcon(this.iiChara3_2);
//						break;
//					default:
//						this.lblClass.setText("DEFAULT");
//						this.lblImage.setIcon(this.iiChara3);
//				}
//				break;
//		case 4: this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara4);
//				break;
//		case 5:
//				switch(this.selectedClass) {
//					case 2:
//						this.lblClass.setText("FROSH CHINO");
//						this.lblImage.setIcon(this.iiChara5_2);
//						break;
//					default:
//						this.lblClass.setText("DEFAULT");
//						this.lblImage.setIcon(this.iiChara5);
//				}
//				break;
//		case 6: this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara6);
//				break;
//		case 7: this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara7);
//				break;
//		case 8:
//				switch(this.selectedClass) {
//				case 2:
//					this.lblClass.setText("DJ JAZZ");
//					this.lblImage.setIcon(this.iiChara8_2);
//					break;
//				default:
//					this.lblClass.setText("DEFAULT");
//					this.lblImage.setIcon(this.iiChara8);
//				}
//				break;
//		case 9: this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara9);
//				break;
//		case 10: 
//				this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara10);
//				break;
//		case 11:
//				this.lblClass.setText("DEFAULT");
//				this.lblImage.setIcon(this.iiChara11);
//				break;
//		default:
//				this.lblClass.setText("DEFAULT");
//				break;
//		}
		
		this.repaint();
	}
	
	public void deselectAllClass() {
		this.btnClass1.setIcon(btnClass1.getDisabledIcon());
		this.btnClass1.setRolloverIcon(btnClass1.getDisabledIcon());
		
		this.btnClass2.setIcon(btnClass2.getDisabledIcon());
		this.btnClass2.setRolloverIcon(btnClass2.getDisabledIcon());
		
		this.btnClass3.setIcon(btnClass3.getDisabledIcon());
		this.btnClass3.setRolloverIcon(btnClass3.getDisabledIcon());
	}
	
	public void select(int selected) {

		Game.M.play("SE1.wav", 0);
		this.deselectAll();
		this.selectedClass = 1;
		
//		switch(selected) {
//			case 1:
//				this.btnChara1.setIcon(btnChara1.getRolloverIcon());
//				this.lblName.setText("MAYNARD");
//				break;
//			case 2:
//				this.btnChara2.setIcon(btnChara2.getRolloverIcon());
//				this.lblName.setText("JOSM");
//				break;
//			case 3:
//				this.btnChara3.setIcon(btnChara3.getRolloverIcon());
//				this.lblName.setText("NEIL");
//				break;
//				
//			case 4:
//				this.btnChara4.setIcon(btnChara4.getRolloverIcon());
//				this.lblName.setText("GYRA");
//				break;
//			case 5:
//				this.btnChara5.setIcon(btnChara5.getRolloverIcon());
//				this.lblName.setText("CHINO");
//				break;
//			case 6:
//				this.btnChara6.setIcon(btnChara6.getRolloverIcon());
//				this.lblName.setText("JARL");
//				
//				break;
//				
//			case 7:
//				this.btnChara7.setIcon(btnChara7.getRolloverIcon());
//				this.lblName.setText("JJ");
//				break;
//			case 8:
//				this.btnChara8.setIcon(btnChara8.getRolloverIcon());
//				this.lblName.setText("JAZZ");
//				break;
//			case 9:
//				this.btnChara9.setIcon(btnChara9.getRolloverIcon());
//				this.lblName.setText("AMZE");
//				break;
//				
//			case 10:
//				this.btnChara10.setIcon(btnChara10.getRolloverIcon());
//				this.lblName.setText("LUIS");
//				break;
//			case 11:
//				this.btnChara11.setIcon(btnChara11.getRolloverIcon());
//				this.lblName.setText("XEI");
//				break;
//			case 12:
//				this.btnChara12.setIcon(btnChara12.getRolloverIcon());
//				break;
//		}
		this.selectedChara = selected;
		this.lblClass.setText(this.lblName.getText());
		this.selectClass(1);
		this.repaint();
//		Game.M.stop();
//		Game.M.play("SE1.wav", 1);
	}
	
	public void deselectAll() {
//		this.btnChara1.setIcon(btnChara1.getDisabledIcon());
//		this.btnChara2.setIcon(btnChara2.getDisabledIcon());
//		this.btnChara3.setIcon(btnChara3.getDisabledIcon());
//
//		this.btnChara4.setIcon(btnChara4.getDisabledIcon());
//		this.btnChara5.setIcon(btnChara5.getDisabledIcon());
//		this.btnChara6.setIcon(btnChara6.getDisabledIcon());
//
//		this.btnChara7.setIcon(btnChara7.getDisabledIcon());
//		this.btnChara8.setIcon(btnChara8.getDisabledIcon());
//		this.btnChara9.setIcon(btnChara9.getDisabledIcon());
//
//		this.btnChara10.setIcon(btnChara10.getDisabledIcon());
//		this.btnChara11.setIcon(btnChara11.getDisabledIcon());
//		this.btnChara12.setIcon(btnChara12.getDisabledIcon());
	}
	
	public void start() {
//		this.mapSelect.setVisible(true);

		this.tmrFocus.stop();
		this.addPlayer();
		this.parent.remove(this);
	}
	
	public void addPlayer() {
		this.parent.add(new Room(parent, new Player()));
	}	
	
	public void toSplash() {
//		this.setVisible(false);
		this.tmrFocus.stop();
		this.parent.add(new Splash(parent));
		this.parent.remove(this);
		this.parent.repaint();
		this.parent.revalidate();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.btnStart) {
			this.start();
		}
//		if(e.getSource() == this.btnChara1) {
//			this.select(1);
//		}
//		if(e.getSource() == this.btnChara2) {
//			this.select(2);
//		}
//		if(e.getSource() == this.btnChara3) {
//			this.select(3);
//		}
//		if(e.getSource() == this.btnChara4) {
//			this.select(4);
//		}
//		if(e.getSource() == this.btnChara5) {
//			this.select(5);
//		}
//		if(e.getSource() == this.btnChara6) {
////			Game.M.stop();
////			Game.M.play("Jarl.wav", Clip.LOOP_CONTINUOUSLY);
//			this.select(6);
//		}
//		if(e.getSource() == this.btnChara7) {
////			Game.M.stop();
////			Game.M.play("JJ.wav", Clip.LOOP_CONTINUOUSLY);
//			this.select(7);
//		}
//		if(e.getSource() == this.btnChara8) {
//			this.select(8);
//		}
//		if(e.getSource() == this.btnChara9) {
//			this.select(9);
//		}
//		if(e.getSource() == this.btnChara10) {
//			this.select(10);
//		}
//		if(e.getSource() == this.btnChara11) {
//			this.select(11);
//		}
		
		
		if(e.getSource() == this.btnClass1) {
			this.selectClass(1);
		}
		if(e.getSource() == this.btnClass2) {
			this.selectClass(2);
					
			}
		if(e.getSource() == this.btnClass3) {
			this.selectClass(3);			
		}
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
//		if(e.getSource() == this.btnChara1 ||
//				e.getSource() == this.btnChara2 ||
//				e.getSource() == this.btnChara3 ||
//				e.getSource() == this.btnChara4 ||
//				e.getSource() == this.btnChara5 ||
//				e.getSource() == this.btnChara6 ||
//				e.getSource() == this.btnChara7 ||
//				e.getSource() == this.btnChara8 ||
//				e.getSource() == this.btnChara9 ||
//				e.getSource() == this.btnChara10 ||
//				e.getSource() == this.btnChara11 ||
//				e.getSource() == this.btnChara12 ||
//				e.getSource() == this.btnClass1 ||
//				e.getSource() == this.btnClass2 ||
//				e.getSource() == this.btnClass3) {
//			Game.M.stopSound();
//			Game.M.sound("SE1.wav", Clip.LOOP_CONTINUOUSLY);
//			Game.M.play("SE1.wav", 0);
//		}
	}
	
	private class TAdapter extends KeyAdapter {	
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				isEscape = true;
			}
			else {
				if(!isSet) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						setSelectedChara(selectedChara-3);
						break;
					case KeyEvent.VK_DOWN:
						setSelectedChara(selectedChara+3);
						break;
					case KeyEvent.VK_LEFT:
						setSelectedChara(selectedChara-1);
						break;
					case KeyEvent.VK_RIGHT:
						setSelectedChara(selectedChara+1);
						break;
					case KeyEvent.VK_Z:
						isSet = true;
						break;
					}		
				}
				else if(!isReady) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						setSelectedClass(selectedClass-1);
						break;
					case KeyEvent.VK_DOWN:
						setSelectedClass(selectedClass+1);
						break;
					case KeyEvent.VK_LEFT:
						setSelectedClass(selectedClass-1);
						break;
					case KeyEvent.VK_RIGHT:
						setSelectedClass(selectedClass+1);
						break;
					case KeyEvent.VK_X:
						isSet = false;
						break;
					case KeyEvent.VK_Z:
						isReady = true;
						break;
					}	
				}
				else {
					switch(e.getKeyCode()) {
					case KeyEvent.VK_X:
						isReady = false;
						break;
					}
				}	
			}			
		}		
	}

	public int getSelectedChara() {
		return selectedChara;
	}
	
	public void setSelectedChara(int selectedChara) {
		if(selectedChara < 1)
			selectedChara = 1;
		if(selectedChara > 11)
			selectedChara = 11;
		this.selectedChara = selectedChara;
		
		this.selectedChara = selectedChara;
		this.select(this.selectedChara);
	}
	
	public int getSelectedClass() {
		return selectedClass;
	}
	
	public void setSelectedClass(int selectedClass) {
		this.selectedClass = selectedClass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		requestFocus();
		if(isReady)
			this.start();
		if(isEscape) {
			this.toSplash();
		}
	}
}
