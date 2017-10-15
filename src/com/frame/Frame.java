package com.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ScrollBarUI;

import com.override.CustomScrollBarUILime;
import com.override.CustomScrollBarUISky;
import com.override.CustomScrollBarUIViolet;


public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int MAX_WIDTH = 560;
	public static final int MAX_HEIGHT = 450;
	public static final int SCROLLBAR_HEIGHT_H = 10;
	
	public static Color clrTransparent = new Color(1.0f, 1.0f, 1.0f, 0.0f);
	public static Color clrAutomatic = new Color(50, 50, 50, 255);
	
	public static Color clrBlack70 = new Color(0.0f, 0.0f, 0.0f, 0.7f);
	public static Color clrBlack33 = new Color(33, 33, 33, 255);
	
	public static Color clrWhite = new Color(255, 255, 255, 255);
	public static Color clrTransBlack = new Color(0, 0, 0, 200);
	public static Color clrAccentDark = new Color(11, 59, 64, 255);
	public static Color clrLightGray = new Color(0, 0, 0, 30);

	public static Color clrRed = new Color(229, 28, 74, 180);
	public static Color clrSeaGreen = new Color(32, 206, 156, 255);
	public static Color clrLightSeaGreen = new Color(102, 216, 166, 255);
	public static Color clrLime = new Color(116, 218, 50, 255);
	public static Color clrPurple = new Color(141, 105, 216, 255);
	public static Color clrAqua = new Color(109, 241, 255, 240);
	 
	public static Color clrTurquoise = new Color(185, 235, 220, 255);
	public static Color clrLightBlue = new Color(48, 212, 225, 255);
	public static Color clrBlue = new Color(49, 137, 181, 150);
	public static Color clrError = new Color(240, 80, 114, 255);
	public static Color clrDisabled = new Color(235, 235, 235, 255);
	
	public static Color clrEditOff = new Color(235, 235, 235, 255);
	public static Color clrEditOn = new Color(66, 184, 192, 220);

	public static Color clrBorderLine = new Color(122, 138, 158);
	public static Border brdrLine = new LineBorder(clrBorderLine);

	// Color Un
	public static Color clrBarUn = new Color(66, 184, 192, 220);
	public static Color clrMinValueUn = new Color(31, 150, 168, 230);
	public static Color clrMaxValueUn = new Color(44, 234, 226, 220);
	
	public static Color clrBarBorderUn = new Color(66, 184, 192, 190); //new Color(49, 185, 183, 255);
	public static Color clrMinBorderUn = new Color(39, 158, 163, 255);
	public static Color clrMaxBorderUn = new Color(20, 215, 204, 255);
	
	public static Border brdrLineBarUn = new LineBorder(clrBarBorderUn);
	public static Border brdrLineMinUn = new LineBorder(clrMinBorderUn);
	public static Border brdrLineMaxUn = new LineBorder(clrMaxBorderUn);
	
	public static Border brdrBarUn = BorderFactory.createCompoundBorder(brdrLineBarUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMinUn = BorderFactory.createCompoundBorder(brdrLineMinUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMaxUn = BorderFactory.createCompoundBorder(brdrLineMaxUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrBoredUn = new Color(190, 190, 190); // Grey
	public static Color clrInterestedUn = new Color(86, 217, 41, 255); // new Color(86, 217, 41, 255); // new Color(0, 0, 255); // Green
	public static Color clrFrustratedUn = new Color(236, 56, 78, 255); // new Color(255, 0, 0); // Red
	public static Color clrConfusedUn = new Color(238, 246 , 12, 255); // new Color(255, 255, 0); // Yellow

	
	public static Color clrBoredBorderUn = new Color(164, 164, 164, 255);
	public static Color clrInterestedBorderUn = new Color(72, 184, 34, 255); 
	public static Color clrFrustratedBorderUn = new Color(207, 49, 68, 255);
	public static Color clrConfusedBorderUn = new Color(217, 224 , 19, 255);
	
	
	public static Border brdrLineInterestedUn = new LineBorder(clrInterestedBorderUn);
	public static Border brdrLineConfusedUn = new LineBorder(clrConfusedBorderUn);
	public static Border brdrLineFrustratedUn = new LineBorder(clrFrustratedBorderUn);
	public static Border brdrLineBoredUn = new LineBorder(clrBoredBorderUn);
	
	
	public static Border brdrInterestedUn = BorderFactory.createCompoundBorder(brdrLineInterestedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrConfusedUn = BorderFactory.createCompoundBorder(brdrLineConfusedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrFrustratedUn = BorderFactory.createCompoundBorder(brdrLineFrustratedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrBoredUn = BorderFactory.createCompoundBorder(brdrLineBoredUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrAccentUn = clrLightBlue;
	public static ScrollBarUI scrlUIUn = new CustomScrollBarUISky();
	
	
	// Color Deux
	public static Color clrBarDeux = new Color(63, 170, 1, 220);
	public static Color clrMinValueDeux = new Color(42, 127, 11, 230);
	public static Color clrMaxValueDeux = new Color(244, 233, 62, 230);
	
	public static Color clrBarBorderDeux = new Color(41, 118, 1, 255);
	public static Color clrMinBorderDeux = new Color(14, 70, 0, 255);
	public static Color clrMaxBorderDeux = new Color(224, 195, 42, 255);
	
	public static Border brdrLineBarDeux = new LineBorder(clrBarBorderDeux);
	public static Border brdrLineMinDeux = new LineBorder(clrMinBorderDeux);
	public static Border brdrLineMaxDeux = new LineBorder(clrMaxBorderDeux);
	
	public static Border brdrBarDeux = BorderFactory.createCompoundBorder(brdrLineBarDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMinDeux = BorderFactory.createCompoundBorder(brdrLineMinDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMaxDeux = BorderFactory.createCompoundBorder(brdrLineMaxDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrBoredDeux = new Color(190, 190, 190);
	public static Color clrInterestedDeux = clrLightBlue;
	public static Color clrFrustratedDeux = new Color(236, 56, 78, 255);
	public static Color clrConfusedDeux = new Color(255, 163, 22, 255);
	
	public static Color clrBoredBorderDeux = new Color(164, 164, 164, 255);
	public static Color clrInterestedBorderDeux = clrBarBorderUn;
	public static Color clrFrustratedBorderDeux = new Color(207, 49, 68, 255);
	public static Color clrConfusedBorderDeux = new Color(229, 142 , 31, 255);
	
	public static Border brdrLineInterestedDeux = new LineBorder(clrInterestedBorderDeux);
	public static Border brdrLineConfusedDeux = new LineBorder(clrConfusedBorderDeux);
	public static Border brdrLineFrustratedDeux = new LineBorder(clrFrustratedBorderDeux);
	public static Border brdrLineBoredDeux = new LineBorder(clrBoredBorderDeux);

	public static Border brdrInterestedDeux = BorderFactory.createCompoundBorder(brdrLineInterestedDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrConfusedDeux = BorderFactory.createCompoundBorder(brdrLineConfusedDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrFrustratedDeux = BorderFactory.createCompoundBorder(brdrLineFrustratedDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrBoredDeux = BorderFactory.createCompoundBorder(brdrLineBoredDeux, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	
	public static Color clrAccentDeux = clrLime;
	public static ScrollBarUI scrlUIDeux = new CustomScrollBarUILime();
	
	
	// Color Trois
	public static Color clrMinValueTrois = new Color(50, 215, 225, 220);
	public static Color clrMaxValueTrois = new Color(152, 248, 45, 230);;
	public static Color clrBarTrois = new Color(129, 44, 182, 210);
	
	public static Color clrMinBorderTrois = new Color(25, 167, 175, 255);
	public static Color clrMaxBorderTrois = new Color(101, 154, 42, 255);
	public static Color clrBarBorderTrois = new Color(88, 32, 123, 255);
	
	public static Border brdrLineBarTrois = new LineBorder(clrBarBorderTrois);
	public static Border brdrLineMinTrois = new LineBorder(clrMinBorderTrois);
	public static Border brdrLineMaxTrois = new LineBorder(clrMaxBorderTrois);
	
	public static Border brdrBarTrois = BorderFactory.createCompoundBorder(brdrLineBarTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMinTrois = BorderFactory.createCompoundBorder(brdrLineMinTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMaxTrois = BorderFactory.createCompoundBorder(brdrLineMaxTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrBoredBorderTrois = new Color(164, 164, 164, 255);
	public static Color clrInterestedBorderTrois = new Color(72, 184, 34, 255); 
	public static Color clrFrustratedBorderTrois = new Color(207, 49, 68, 255);
	public static Color clrConfusedBorderTrois = new Color(217, 224 , 19, 255);
	
	public static Border brdrLineInterestedTrois = new LineBorder(clrInterestedBorderTrois);
	public static Border brdrLineConfusedTrois = new LineBorder(clrConfusedBorderTrois);
	public static Border brdrLineFrustratedTrois = new LineBorder(clrFrustratedBorderTrois);
	public static Border brdrLineBoredTrois = new LineBorder(clrBoredBorderTrois);
	
	public static Border brdrInterestedTrois = BorderFactory.createCompoundBorder(brdrLineInterestedTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrConfusedTrois = BorderFactory.createCompoundBorder(brdrLineConfusedTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrFrustratedTrois = BorderFactory.createCompoundBorder(brdrLineFrustratedTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrBoredTrois = BorderFactory.createCompoundBorder(brdrLineBoredTrois, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrBoredTrois = new Color(190, 190, 190);
	public static Color clrInterestedTrois = new Color(86, 217, 41, 255);
	public static Color clrFrustratedTrois = new Color(236, 56, 78, 255);
	public static Color clrConfusedTrois = new Color(238, 246 , 12, 255);
	
	public static Color clrAccentTrois = clrBarTrois;
	public static ScrollBarUI scrlUITrois = new CustomScrollBarUIViolet();
	
	// Selected Color
	public static Color clrBar = clrBarUn;
	public static Color clrMinValue = clrMinValueUn;
	public static Color clrMaxValue = clrMaxValueUn;
	
	public static Border brdrBar = brdrBarUn;
	public static Border brdrMin = brdrMinUn;
	public static Border brdrMax = brdrMaxUn;

	public static Color clrCellAccent = clrBar;
	public static Color clrAccent = clrAccentUn;
	
	
	public static Color clrBored = clrBoredUn;
	public static Color clrInterested = clrInterestedUn;
	public static Color clrFrustrated = clrFrustratedUn;
	public static Color clrConfused = clrConfusedUn;
	public static Color clrDifficulty = clrTransBlack;
	
	public static Border brdrInterested = brdrInterestedUn;
	public static Border brdrConfused = brdrConfusedUn;
	public static Border brdrFrustrated = brdrFrustratedUn; 
	public static Border brdrBored = brdrBoredUn;

	public static Border brdrDifficulty = brdrLine;
	
	
	// Selected Color for Feature Graph
	public static Color clrBarFeat = new Color(66, 184, 192, 190);
	public static Color clrMinValueFeat = new Color(31, 150, 168, 190);
	public static Color clrMaxValueFeat = new Color(44, 234, 226, 190);
	
	public static Color clrBarBorderFeat = new Color(49, 185, 183, 255);
	public static Color clrMinBorderFeat = new Color(39, 158, 163, 255);
	public static Color clrMaxBorderFeat = new Color(20, 215, 204, 255);
	
	public static Border brdrLineBarFeat = new LineBorder(clrBarBorderUn);
	public static Border brdrLineMinFeat = new LineBorder(clrMinBorderUn);
	public static Border brdrLineMaxFeat = new LineBorder(clrMaxBorderUn);
	
	public static Border brdrBarFeat = BorderFactory.createCompoundBorder(brdrLineBarUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMinFeat = BorderFactory.createCompoundBorder(brdrLineMinUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrMaxFeat = BorderFactory.createCompoundBorder(brdrLineMaxUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrInterestedFeat = new Color(86, 217, 41, 190); // new Color(86, 217, 41, 255); // new Color(0, 0, 255); // Green
	public static Color clrConfusedFeat = new Color(238, 246 , 12, 190); // new Color(255, 255, 0); // Yellow
	public static Color clrFrustratedFeat = new Color(236, 56, 78, 190); // new Color(255, 0, 0); // Red
	public static Color clrBoredFeat = new Color(190, 190, 190); // Grey
	public static Color clrDifficultyFeat = new Color(0, 0, 0, 160);;
	
	
	public static Color clrBoredBorderFeat = new Color(164, 164, 164, 255);
	public static Color clrInterestedBorderFeat = new Color(72, 184, 34, 255); 
	public static Color clrFrustratedBorderFeat = new Color(207, 49, 68, 255);
	public static Color clrConfusedBorderFeat = new Color(217, 224 , 19, 255);
	
	
	public static Border brdrLineInterestedFeat = new LineBorder(clrInterestedBorderUn);
	public static Border brdrLineConfusedFeat = new LineBorder(clrConfusedBorderUn);
	public static Border brdrLineFrustratedFeat = new LineBorder(clrFrustratedBorderUn);
	public static Border brdrLineBoredFeat = new LineBorder(clrBoredBorderUn);
	
	
	public static Border brdrInterestedFeat = BorderFactory.createCompoundBorder(brdrLineInterestedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrConfusedFeat = BorderFactory.createCompoundBorder(brdrLineConfusedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrFrustratedFeat = BorderFactory.createCompoundBorder(brdrLineFrustratedUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));
	public static Border brdrBoredFeat = BorderFactory.createCompoundBorder(brdrLineBoredUn, BorderFactory.createEmptyBorder(0, 1, 0, 1));

	public static Color clrAccentFeat = clrLightBlue;
	
	
	public static ScrollBarUI scrlUI = scrlUIUn;
	public static Color clrMark = new Color(140, 140, 140, 128);

	public static Color clrMarkFeat = new Color(140, 140, 140, 128);
	
	public static Font fntDefault = new Font("Arial", Font.PLAIN, 14);
	public static Font fntDefault12 = new Font("Arial", Font.PLAIN, 12);
	public static Font fntDefault11 = new Font("Arial", Font.PLAIN, 11);
	public static Font fntDefault13 = new Font("Arial", Font.PLAIN, 13);
	public static Font fntDefault10 = new Font("Arial", Font.PLAIN, 10);
	public static Font fntDefault16 = new Font("Arial", Font.PLAIN, 16);
	
	public static Font fntGothamLight8 = new Font("GOTHAM-LIGHT", Font.PLAIN, 8);
	public static Font fntGothamLight12 = new Font("GOTHAM-LIGHT", Font.PLAIN, 12);
	public static Font fntGothamLight14 = new Font("GOTHAM-LIGHT", Font.PLAIN, 14);
	public static Font fntGothamLight18 = new Font("GOTHAM-LIGHT", Font.PLAIN, 18);
	public static Font fntGothamLight20 = new Font("GOTHAM-LIGHT", Font.PLAIN, 20);

	public static Font fntGothamLight29 = new Font("GOTHAM-LIGHT", Font.PLAIN, 29);
	
	public static Border brdrEmpty = new EmptyBorder(0, 5, 0, 5);


	public static Border brdrTabOff = BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(122, 138, 158));
	public static Border brdrTabOn = BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(122, 138, 158));

	
	public static Border brdrDefault = BorderFactory.createCompoundBorder(brdrLine, BorderFactory.createEmptyBorder(0, 3, 0, 3));
	public static Border brdrError = BorderFactory.createCompoundBorder(new LineBorder(Frame.clrRed, 2), BorderFactory.createEmptyBorder(0, 3, 0, 3));

	
	public static Border brdrCompound = new CompoundBorder(brdrEmpty, brdrLine);
	
	// TODO: Call setVisible(true) on the child element (must be called last)
	protected void initComponents() {
		this.setSize(MAX_WIDTH, MAX_HEIGHT);
		this.setLayout(null);		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setBackground(Color.GRAY);
		
		this.setFocusable(true);
		this.setAutoRequestFocus(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void initPanel(JPanel panel, Color color, int x, int y, int width, int height) {
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(color);
		panel.setBounds(x, y, width, height);
		panel.setVisible(true);
	}
	
	public static void initPanel(JPanel panel, Color color, int width, int height) {
		initPanel(panel, color, 0, 0, width, height);
	}
	public static void initLayeredPane(JLayeredPane panel, Color color, int width, int height) {
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(color);
		
		panel.setBounds(0, 0, width, height);
		panel.setFocusable(true);
		panel.setVisible(true);
	}
	public static void initTabbedPane(JTabbedPane tabbedPane, Color color, int x, int y, int width, int height) {
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(color);
		
		tabbedPane.setBounds(x, y, width, height);
		tabbedPane.setVisible(true);
	}
	
	public static void initTextField(JTextField textfield, int x, int y, int width, int height, Font font, Color color, MouseListener listener) {
		textfield.setBounds(x, y, width, height);
		textfield.addMouseListener(listener);
		textfield.setBorder(brdrDefault);
		
		textfield.setForeground(color);
		textfield.setOpaque(true);
		textfield.setFocusable(true);
	}
	
	public static void initComboBox(JComboBox<String> combobox, int x, int y, int width, int height, Color color, MouseListener mouseListener, ItemListener itemListener) {
		combobox.setBounds(x, y, width, height);
		combobox.addMouseListener(mouseListener);
		combobox.addItemListener(itemListener);

		combobox.setBorder(brdrCompound);
		combobox.setFocusable(false);
		
		combobox.setForeground(color);
		combobox.setBackground(Color.WHITE);
		combobox.setOpaque(false);
	}
	
	public static void initSpinner(JSpinner spinner, int x, int y, int width, int height, Color color, Font font,
									int initialValue, int minValue, int maxValue, int valueIncrement, MouseListener mouseListener) {
		spinner.setBounds(x, y, width, height);
		spinner.addMouseListener(mouseListener);
		spinner.setFont(font);

		spinner.setBorder(brdrCompound);
		spinner.setFocusable(false);
		
		spinner.setForeground(color);
		spinner.setBackground(Color.WHITE);
		spinner.setOpaque(false);
		
		SpinnerModel model = new SpinnerNumberModel(initialValue, minValue, maxValue, valueIncrement);
		spinner.setModel(model);
		
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner);
		editor.getFormat().setGroupingUsed(false);
		spinner.setEditor(editor);
	}
	
	public static void initButtons(JButton button, Color color, int x, int y, int width, int height, MouseListener listener) {
		button.addMouseListener(listener);
		button.setContentAreaFilled(true);
		button.setLocation(x, y);
		
		button.setSize(width, height);
		button.setFocusable(false);
		button.setBackground(color);
		button.setVisible(true);
	}
	
	// TODO: Right way is: new ImageIcon(getClass().getClassLoader().getResource("img_navigator/"+iconName+"_on.png")
	// When getting from a resource/img_navigator folder
	public static void initButtons(JButton button, String iconName, int x, int y, boolean isRollover, MouseListener listener) {
		
		button.addMouseListener(listener);
		button.setContentAreaFilled(false);
		button.setLocation(x, y);
		
		button.setIcon(new ImageIcon("resource/img_navigator/"+iconName+"_off.png"));
		button.setDisabledIcon(button.getIcon());
		button.setSize(button.getIcon().getIconWidth(), button.getIcon().getIconHeight());
		
		if(isRollover) {
			button.setRolloverIcon(new ImageIcon("resource/img_navigator/"+iconName+"_on.png"));
			button.setPressedIcon(button.getRolloverIcon());
		}
		button.setBorder(null);
		button.setFocusable(false);
		
		button.setVisible(true);
	}
	
	public static void initLabels(JLabel label, String iconPath, MouseListener listener) {
		label.addMouseListener(listener);
		label.setIcon(new ImageIcon("resource/img_navigator/"+iconPath+".png"));
		
		label.setSize(label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setBorder(null);
		label.setFocusable(false);
		label.setBackground(clrTransparent);
	}
	
	public static void initLabels(JLabel label, ImageIcon icon, MouseListener listener) {
	
		label.addMouseListener(listener);
		label.setIcon(icon);
		
		label.setSize(label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setBorder(null);
		label.setFocusable(false);
		label.setBackground(clrTransparent);
	}
	
	public static void initLabel(JLabel label, Font font, Color color, int x, int y, int w, int h) {
	
		label.setBounds(x, y, w, h);
		label.setPreferredSize(label.getSize());
		label.setMinimumSize(label.getSize());
		label.setOpaque(true);
		
		label.setFont(font);
		label.setBackground(clrTransparent);
		label.setForeground(color);
		
		label.setVerticalAlignment(JLabel.CENTER);
	}
	
	public static void initTextArea(JTextArea textarea, Font font, Color color, int x, int y, int w, int h) {
		
		textarea.setBounds(x, y, w, h);
		textarea.setSize(textarea.getSize());
		textarea.setPreferredSize(textarea.getSize());
		textarea.setMinimumSize(textarea.getSize());
//		textarea.setMaximumSize(textarea.getSize());
		textarea.setOpaque(true);
		
		textarea.setFont(font);
		textarea.setBackground(clrTransparent);
		textarea.setForeground(color);
	}
	
	public static void initLabel(JLabel label, Font font, Color colorForeground, Color colorBackground, int w, int h) {
		
		label.setSize(w, h);
		label.setPreferredSize(label.getSize());
		label.setMinimumSize(label.getSize());
		label.setMaximumSize(label.getSize());
		label.setOpaque(true);
		
		label.setFont(font);
		label.setBackground(colorBackground);
		label.setForeground(colorForeground);
		
		label.setVerticalAlignment(JLabel.CENTER);
	}
	
	public static void initDialog(JDialog dialog, int width, int height, Color color, boolean isModal, boolean isResizable, boolean isUndecorated) {
		dialog.setLayout(null);
		
		dialog.setResizable(isResizable);
		dialog.setUndecorated(isUndecorated);		
		dialog.setSize(width, height);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
		
		dialog.setBackground(color);
		dialog.setModal(isModal);
		dialog.setLocationRelativeTo(null);

	}
	
	public static void initScrollPane(JScrollPane scrollpane, Component viewport, Rectangle bounds) {
		initScrollPane(scrollpane, viewport, (int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());		
	}
	
	public static void initScrollPane(JScrollPane scrollpane, Component viewport, int x, int y, int width, int height) {
		int horizontalHeight = SCROLLBAR_HEIGHT_H;
		int verticalWidth = horizontalHeight+4;
		
		scrollpane.setViewportView(viewport);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);
		scrollpane.setBounds(x, y, width, height);
		scrollpane.setSize(width, height);
		scrollpane.setPreferredSize(scrollpane.getSize());
		scrollpane.setMaximumSize(scrollpane.getSize());
		scrollpane.setMinimumSize(scrollpane.getSize());
		
		scrollpane.setBackground(viewport.getBackground());
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.getVerticalScrollBar().setUI(new CustomScrollBarUISky());
		scrollpane.getHorizontalScrollBar().setUI(new CustomScrollBarUISky());
		scrollpane.getVerticalScrollBar().setBorder(null);
		scrollpane.setBorder(null);
		
		scrollpane.getHorizontalScrollBar().setPreferredSize(new Dimension(
		        (int)scrollpane.getHorizontalScrollBar().getPreferredSize().getWidth(),
		        (int)horizontalHeight
		));
		
		scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(
				verticalWidth,
				(int)scrollpane.getVerticalScrollBar().getPreferredSize().getHeight()
		));
		
	}
	
	public static void placeDirectlyBelow(JComponent source, JComponent reference) {
		placeDirectlyBelow(source, reference, 0);
	}
	
	public static void placeDirectlyBelow(JComponent source, JComponent reference, int padding) {
		source.setBounds(reference.getX(), reference.getY()+reference.getHeight()+padding, source.getWidth(), source.getHeight());		
	}
	
	public static void placeBelow(JComponent source, JComponent reference) {
		source.setBounds(source.getX(), reference.getY()+reference.getHeight(), source.getWidth(), source.getHeight());		
	}
	
	public static void placeBelow(JComponent source, JComponent reference, int padding) {
		source.setBounds(source.getX(), reference.getY()+reference.getHeight()+padding, source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Places the source to the right of the reference but keeps its Y value
	 * @param source
	 * @param reference
	 */
	public static void placeRight(JComponent source, JComponent reference) {
		source.setBounds(reference.getX()+reference.getWidth(), source.getY(), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Places the source to the right of the reference aligned at the top
	 * @param source
	 * @param reference
	 */
	public static void placeDirectlyRight(JComponent source, JComponent reference) {
		source.setBounds(reference.getX()+reference.getWidth(), reference.getY(), source.getWidth(), source.getHeight());		
	}

	public static void placeDirectlyRight(JComponent source, JComponent reference, int padding) {
		source.setBounds(reference.getX()+reference.getWidth()+padding, reference.getY(), source.getWidth(), source.getHeight());		
	}

	
	/**
	 * Places the source to the left of the reference but keeps its Y value with padding
	 * @param source
	 * @param reference
	 */
	public static void placeLeft(JComponent source, JComponent reference, int padding) {
		source.setBounds(reference.getX()-source.getWidth()-padding, source.getY(), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Aligns the bottom of the source with that of reference
	 * @param source
	 * @param reference
	 */
	public static void alignBaseline(JComponent source, JComponent reference) {
		source.setBounds(source.getX(), reference.getY()+(reference.getHeight()-source.getHeight()), source.getWidth(), source.getHeight());		
	}

	/**
	 * Aligns the bottom of the source with that of reference with no reference to Y.
	 * @param source
	 * @param reference
	 */
	public static void alignBottom(JComponent source, JComponent reference) {
		source.setBounds(source.getX(), (reference.getHeight()-source.getHeight()), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Aligns the bottom of the source with that of reference+padding
	 * @param source
	 * @param reference
	 */
	public static void alignBaseline(JComponent source, JComponent reference, int padding) {
		source.setBounds(source.getX(), reference.getY()+(reference.getHeight()-source.getHeight())-padding, source.getWidth(), source.getHeight());		
	}
	
	
	/**
	 * Aligns the right of the source with that of the reference.
	 * @param source
	 * @param reference
	 */
	public static void alignRight(JComponent source, JComponent reference) {
		source.setBounds(reference.getWidth()-source.getWidth(), source.getY(), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Aligns the right of the source with that of the reference with padding.
	 * @param source
	 * @param reference
	 */
	public static void alignRight(JComponent source, JComponent reference, int padding) {
		source.setBounds(reference.getWidth()-source.getWidth()-padding, source.getY(), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Aligns the left of the source with that of the reference with padding.
	 * @param source
	 * @param reference
	 * @param padding
	 */
	public static void alignLeft(JComponent source, JComponent reference, int padding) {
		source.setBounds(reference.getX()+padding, source.getY(), source.getWidth(), source.getHeight());		
	}
	
	
	/**
	 * Places the source to the right of the reference aligned at the bottom
	 * @param source
	 * @param reference
	 */
	public static void placeRightBaseline(JComponent source, JComponent reference) {
		source.setBounds(reference.getX()+reference.getWidth(), reference.getY()+(reference.getHeight()-source.getHeight()), source.getWidth(), source.getHeight());		
	}
	
	/**
	 * Centers the source horizontally from the reference
	 * @param source
	 * @param reference
	 */
	public static void centerHorizontally(JComponent source, JComponent reference) {
		source.setBounds((reference.getWidth()-source.getWidth())/2, source.getY(), source.getWidth(), source.getHeight());
	}
	
	public static void centerVertically(JComponent source, JComponent reference) {
		source.setBounds(source.getX(), (reference.getHeight()-source.getHeight())/2, source.getWidth(), source.getHeight());
	}
	
	public static int getIndexOfMax(ArrayList<Double> list) {
		return list.indexOf(Collections.max(list));
	}
	
	public static int getIndexOfMin(ArrayList<Double> list) {
		return list.indexOf(Collections.min(list));
	}
	
	public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

	    int original_width = imgSize.width;
	    int original_height = imgSize.height;
	    int bound_width = boundary.width;
	    int bound_height = boundary.height;
	    int new_width = original_width;
	    int new_height = original_height;

	    // first check if we need to scale width
	    if (original_width > bound_width) {
	        //scale width to fit
	        new_width = bound_width;
	        //scale height to maintain aspect ratio
	        new_height = (new_width * original_height) / original_width;
	    }

	    // then check if we need to scale even with the new height
	    if (new_height > bound_height) {
	        //scale height to fit instead
	        new_height = bound_height;
	        //scale width to maintain aspect ratio
	        new_width = (new_height * original_width) / original_height;
	    }

	    return new Dimension(new_width, new_height);
	}
	
	public static ImageIcon setIconToFit(ImageIcon icon, Dimension boundary) {
		int width = icon.getIconWidth();
	    int height = icon.getIconHeight();
		Dimension imgSize = new Dimension(width, height);
		Dimension newSize = getScaledDimension(imgSize, boundary);
		ImageIcon newIcon = new ImageIcon(icon.getImage().getScaledInstance((int)newSize.getWidth(), (int)newSize.getHeight(), BufferedImage.SCALE_SMOOTH));
		return newIcon;
	}
	
	public static Image resize(ImageIcon originalIcon, int width, int height) {
		return originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

}
