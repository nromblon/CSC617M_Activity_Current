package com.elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.music.Music;
import com.override.CustomScrollBarUISky;
import com.screens.MainMenu;

public class Game extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_WIDTH = 1366;
	public static final int MAX_HEIGHT = 768;

	public static final int SCROLLBAR_HEIGHT_H = 10;
	public static final int NEXT_DOOR_X = 1045;
	public static final int PREV_DOOR_X = 5;
	
	
	
	public static Color clrTransparent = new Color(1.0f, 1.0f, 1.0f, 0.0f);
	public static Color clrBlack70 = new Color(0.0f, 0.0f, 0.0f, 0.7f);
	public static Color darkGrey = new Color(38, 38, 38);

	public static Color clrAutomatic = new Color(50, 50, 50, 255);
	public static Color clrRed = new Color(229, 28, 74, 180);
	public static Color clrYellow = new Color(235, 228, 21, 200);
	public static Color clrLime =new Color(137, 234, 22, 220);
	public static Color clrAqua = new Color(109, 241, 255, 240);
	public static Color clrSeaGreen = new Color(32, 206, 156, 255);

	public static Color clrTurquoise = new Color(39, 196, 210, 255);
	public static Color clrLightBlue =new Color(77, 204, 228, 150);
	public static Color clrBlue = new Color(49, 137, 181, 150);
	
	public static Font fntGothamLight12 = new Font("GOTHAM-LIGHT", Font.PLAIN, 12);
	public static Font fntGothamLight14 = new Font("GOTHAM-LIGHT", Font.PLAIN, 14);
	public static Font fntGothamLight18 = new Font("GOTHAM-LIGHT", Font.PLAIN, 18);
	public static Font fntGothamLight20 = new Font("GOTHAM-LIGHT", Font.PLAIN, 20);
	public static Font fntGothamLight29 = new Font("GOTHAM-LIGHT", Font.PLAIN, 29);

	public static Font fntDefault12 = new Font("Arial", Font.PLAIN, 12);
	public static Font fntDefault11 = new Font("Arial", Font.PLAIN, 11);
	public static Font fntDefault10 = new Font("Arial", Font.PLAIN, 10);
	public static Font fntDefault50 = new Font("Arial", Font.PLAIN, 50);

	public static Font fntConsolas12 = new Font("Consolas", Font.PLAIN, 12);
	public static Font fntConsolas16 = new Font("Consolas", Font.PLAIN, 16);
	public static Font fntConsolas20 = new Font("Consolas", Font.PLAIN, 20);

	public static Font fntConsolas30 = new Font("Consolas", Font.PLAIN, 30);

	
	public static Color clrBorderLine = new Color(122, 138, 158);
	public static Border brdrLine = new LineBorder(clrBorderLine);
	public static Border brdrDefault = BorderFactory.createCompoundBorder(brdrLine, BorderFactory.createEmptyBorder(0, 3, 0, 3));
	
	public static Music M;
	public Game() {
		this.initComponents();
		M = new Music();

//		this.add(new Splash(this));
		this.add(new MainMenu(this));
		this.setVisible(true);
	}
	private void initComponents() {
		this.setSize(MAX_WIDTH, MAX_HEIGHT);
		this.setLayout(null);		
		this.setUndecorated(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.GRAY);
		
		this.setFocusable(true);
		this.setAutoRequestFocus(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public static void initButtons(JButton button, Color color, int x, int y, int width, int height, MouseListener listener) {
		button.addMouseListener(listener);
		button.setContentAreaFilled(true);
		button.setLocation(x, y);
		
		button.setSize(width, height);
		button.setBorder(null);
		button.setFocusable(false);
		button.setBackground(color);
		
		button.setVisible(true);
	}
	
	public static void initButtons(JButton button, String iconName, int x, int y, boolean isRollover, MouseListener listener) {
		button.addMouseListener(listener);
		button.setContentAreaFilled(false);
		button.setLocation(x, y);
		
		button.setIcon(new ImageIcon("images/"+iconName+".png"));
		button.setDisabledIcon(button.getIcon());
		button.setSize(button.getIcon().getIconWidth(), button.getIcon().getIconHeight());
		
		if(isRollover) {
			button.setRolloverIcon(new ImageIcon("images/"+iconName+"_on.png"));
			button.setPressedIcon(button.getRolloverIcon());
		}
//		button.setBackground(Game.clrBlack70);
		button.setBorder(null);
		button.setFocusable(false);
		
		button.setVisible(true);
	}
	
	public static void initLabels(JLabel label, String iconPath, MouseListener listener) {
		label.addMouseListener(listener);
		label.setIcon(new ImageIcon("images/"+iconPath+".png"));
		
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
		label.setBackground(color);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
	}
	
	public static void initPanel(JPanel panel, Color color, int width, int height) {
		initPanel(panel, color, 0, 0, width, height);
	}
	
	public static void initPanel(JPanel panel, Color color, int x, int y, int width, int height) {
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(color);
		
		panel.setBounds(x, y, width, height);
		panel.setSize(width, height);
		panel.setMinimumSize(panel.getSize());
		panel.setMaximumSize(panel.getSize());
		panel.setPreferredSize(panel.getSize());
		
		panel.setFocusable(true);
		panel.setVisible(true);
	}
	
	
	public static void initTextField(JTextField textfield, int x, int y, int width, int height, Font font, Color color) {
		textfield.setBounds(x, y, width, height);
		textfield.setSize(width, height);
		textfield.setPreferredSize(textfield.getSize());
		textfield.setMinimumSize(textfield.getSize());
		textfield.setMaximumSize(textfield.getSize());

		textfield.setBorder(brdrDefault);
		textfield.setFont(font);
		textfield.setForeground(color);
		textfield.setOpaque(true);
	}
	
	public static void initScrollPane(JScrollPane scrollpane, Component viewport, Rectangle bounds) {
		int horizontalHeight = SCROLLBAR_HEIGHT_H;
		int verticalWidth = horizontalHeight;
		
		scrollpane.setViewportView(viewport);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);
		
		scrollpane.setSize(bounds.getSize());
		scrollpane.setMaximumSize(bounds.getSize());
		scrollpane.setMinimumSize(bounds.getSize());
		scrollpane.setPreferredSize(bounds.getSize());
		
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

	
	@Override
	public void mouseClicked(MouseEvent e) {
	
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
		// TODO Auto-generated method stub
		
	}
}
