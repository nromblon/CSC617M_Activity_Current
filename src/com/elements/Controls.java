package com.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import com.characters.Character;
import com.elements.parser.Action;
import com.elements.parser.ActionParser;
import com.elements.parser.Commands;
import com.frame.Frame;


import com.objects.InteractableObject;
import world.GameWorld;

public class Controls extends JPanel {
	private static final long serialVersionUID = 1L;
	private GameWorld parent;
	private Character player;
	
	private int keyPointer;
	private boolean isSuccessful;
	
	private JLabel lblControls;
	private JTextField txtfControls;
	private JPanel pnlControlLog;

	private JScrollPane scrlpControlLog;
	private ArrayList<String> strControlLog;

    private boolean isInAction;
    private Queue<Action> actionQueue;

	public Controls(GameWorld parent, Character player) {
		this.parent = parent;
		this.player = player;
		this.isSuccessful = false;
		
		Game.initPanel(this, Game.clrBlack70, Stage.MAX_WIDTH, 0, parent.getWidth()-Stage.MAX_WIDTH, parent.getHeight());	
		this.initComponents();

		this.isInAction = false;
		this.actionQueue = new LinkedList<Action>();

		this.add(lblControls);
		this.add(txtfControls);
		this.add(scrlpControlLog);
		this.setVisible(true);
		
	  	this.txtfControls.addKeyListener(new TAdapter());	
	  	
	}
	
	public void initComponents() {
		this.setLayout(new FlowLayout());
		this.strControlLog = new ArrayList<String>();
		
		this.lblControls = new JLabel("Commands");
		Game.initLabel(lblControls, Game.fntGothamLight20, Game.clrTransparent, 0, 0, this.getWidth(), 30);
		this.lblControls.setForeground(Color.WHITE);
		
		this.txtfControls = new JTextField();
		Game.initTextField(txtfControls, 0, 0, this.getWidth()-50, 25, Game.fntDefault11, Game.clrAutomatic);
		
		this.pnlControlLog = new JPanel();
		pnlControlLog.setBackground(Color.WHITE);
		pnlControlLog.setLayout(new BoxLayout(pnlControlLog, BoxLayout.Y_AXIS));
		
		this.scrlpControlLog = new JScrollPane(pnlControlLog);
		Frame.initScrollPane(scrlpControlLog, pnlControlLog, 0, 0, txtfControls.getWidth(), 72);
		scrlpControlLog.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}



	public void processAction(Action a){
		if(a.getCommand().equals(Commands.ERROR))
			getParent().updateMessage("I don't know what you mean.");
		else {
			InteractableObject o = a.getObject();
			switch (a.getCommand()) {
				case MOVE:
					if (!o.isTaken())
						player.moveTo(o);
					break;

				case VIEW:
					o.view();
					break;
				case OPEN:
					o.open();
					break;
				case TAKE:
					if (!o.isTaken())
						o.take();
					break;

				case CLOSE:
					o.close();
					break;
				case USE:
					o.use();
					break;
				default:
					break;
			}
//		if(a.getCommand() != Commands.MOVE && !this.getParent().getGamebar().getMessageQueue().isEmpty())
			if (a.getCommand() != Commands.MOVE && !actionQueue.isEmpty()) {
				player.setInAction(true);
				getParent().getGamebar().getNextBtn().setVisible(true);
			}

			if (actionQueue.isEmpty())
				player.getParent().getParent().getGamebar().getNextBtn().setVisible(false);

		}
    }

	public void action(String strAction) {

        endAction();
        actionQueue.clear();

		Stage stage = player.getParent();
		Action[] actions = ActionParser.parse(strAction,stage);

		for (Action action : actions) {
			if(!action.getCommand().equals(Commands.ERROR) && action.getObject().getTarget() != null)
		  	  actionQueue.add(new Action(Commands.MOVE,action.getObject().getTarget()));
            actionQueue.add(action);
        }

	}
	
	public void endAction() {
		player.stop();
		this.isInAction = false;
	}
	
	public void startAction() {
		String strAction = txtfControls.getText().trim();
//		this.getParent().updateMessage(strAction);
		if(strAction.length() > 1) {
			action(strAction);
			this.strControlLog.add(strAction);
			
			pnlControlLog.add(createItem(strAction, pnlControlLog), null, 0);
			txtfControls.setText("");
		}

	}
	
	public JLabel createItem(String text, JPanel parent) {
		JLabel label = new JLabel("   "+text);
		JLabel labelBorder = new JLabel();
//		JButton button = new JButton("Delete");
		
		Frame.initLabel(label, Frame.fntDefault13, Frame.clrAutomatic, Frame.clrLightGray, parent.getWidth(), 17);
//		label.addMouseListener(this);
		Frame.initLabel(labelBorder, Frame.fntDefault13, Frame.clrAutomatic, Color.WHITE, parent.getWidth(), 18);
		
//		Frame.initButtons(button, label.getBackground(), label.getWidth()-63, 0, 50, label.getHeight(), this);
//		button.setBorder(Frame.brdrEmpty);
//		button.setVisible(false);
//		label.add(button);
		labelBorder.add(label);
		return labelBorder;
	}
	
	private class TAdapter extends KeyAdapter implements ActionListener {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				startAction();
				break;
			}		
			
		}
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				break;
			}	
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}		
	}

    public boolean isInAction() {
        return isInAction;
    }

    public void setInAction(boolean inAction) {
        isInAction = inAction;
    }

    public Queue<Action> getActionQueue() {
        return actionQueue;
    }

    public void setActionQueue(Queue<Action> actionQueue) {
        this.actionQueue = actionQueue;
    }
	
	public GameWorld getParent() {
		return parent;
	}

	public void setParent(GameWorld parent) {
		this.parent = parent;
	}

	public int getKeyPointer() {
		return keyPointer;
	}
	
	public void setKeyPointer(int keyPointer) {
		this.keyPointer = keyPointer;
	}
	
	public KeyListener getKeyListener() {
		return this.getKeyListener();
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public JTextField getTxtfControls() {
		return txtfControls;
	}

	public void setTxtfControls(JTextField txtfControls) {
		this.txtfControls = txtfControls;
	}

	public JPanel getPnlControlLog() {
		return pnlControlLog;
	}

	public void setPnlControlLog(JPanel pnlControlLog) {
		this.pnlControlLog = pnlControlLog;
	}
}
