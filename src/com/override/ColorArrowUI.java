package com.override;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.elements.Game;

public class ColorArrowUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
    	return new ColorArrowUI();
    }

	@Override 
    protected JButton createArrowButton() {
        return new BasicArrowButton(
        		BasicArrowButton.SOUTH,
        		Color.WHITE, Color.WHITE,
        		Game.clrAutomatic, Color.WHITE);
    }
}