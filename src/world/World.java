package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.characters.Character;
import com.elements.Game;
import com.elements.GameBar;
import com.elements.Stage;
import com.search.SearchPlatforms;

public abstract class World extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	public static boolean IS_PAUSED;
	
	protected boolean isActive;
	protected boolean isNextDoorOpened;
	protected boolean isPrevDoorOpened;
	
	protected int stageIndex;
	
	protected JFrame parent;
	protected Character player;
	protected ArrayList<Stage> stages;
	protected Stage stage;

	protected GameBar gamebar;
	protected Timer gameTimer;
	
	protected JLabel lblResult;
	protected JButton btnCharacterSelect;
	
	protected ImageIcon iiResultWin;
	protected ImageIcon iiResultLose;
	protected abstract void startWorld();
	
	public World(JFrame parent, Character player) {
		this.parent = parent;
		this.isActive = true;

		this.isNextDoorOpened = false;
		this.isPrevDoorOpened = false;
		
		this.isActive = true;
		IS_PAUSED = false;
		
		this.player = player;
		this.stageIndex = 0;
		this.stages = new ArrayList<Stage>();
		this.gameTimer = new Timer(0, this);	

		this.initComponents();
		
		this.add(btnCharacterSelect);
		this.add(lblResult);
	}
	
	private void initComponents() {
		Game.initPanel(this, Color.GRAY, 0, 0, Game.MAX_WIDTH, Game.MAX_WIDTH);
		
		this.iiResultLose = new ImageIcon("images/Result_Lose.png");
		this.iiResultWin = new ImageIcon("images/Result_Win.png");
		this.lblResult = new JLabel();
		this.lblResult.setVisible(false);
		
		Game.initLabels(lblResult, iiResultWin, null);
		
		this.btnCharacterSelect = new JButton("BACK");
		Game.initButtons(this.btnCharacterSelect, Game.clrTransparent, (Stage.MAX_WIDTH-180)/2, Stage.MAX_HEIGHT-200, 180, 50, this);
		this.btnCharacterSelect.setFont(Game.fntGothamLight20);
		this.btnCharacterSelect.setVisible(false);
		
		this.setVisible(true);
		this.setFocusable(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor( getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	
	public void pause() {
		IS_PAUSED = !IS_PAUSED;
	}
	
	public void endWorld(boolean isWin) {
		this.isActive = false;

		this.gameTimer.stop();
		if(isWin) {
			this.btnCharacterSelect.setForeground(Color.WHITE);
			this.btnCharacterSelect.setBackground(Color.BLACK);
			this.lblResult.setIcon(this.iiResultWin);
			Game.M.play("win.wav", 0);
		}
		else {
			this.btnCharacterSelect.setForeground(Color.BLACK);
			this.btnCharacterSelect.setBackground(Color.WHITE);
			
			this.lblResult.setIcon(this.iiResultLose);
			Game.M.play("lose.wav", 0);
		}
		this.btnCharacterSelect.setVisible(true);
		this.lblResult.setVisible(true);
	}

	public void toStage(int i, int iX, int direction) {
		this.stageIndex = i;
		if(stageIndex < stages.size()) {
			stage.setVisible(false);
			stage = stages.get(stageIndex);
			stage.add(player.getLblCharacter());
			player.setX(iX);
			player.setDirection(direction);
			stage.start();
		}
		else {
			this.endWorld(true);
		}
	}
	
	public void nextStage() {
		this.stageIndex += 1;
		if(stageIndex < stages.size()) {
			stage.setVisible(false);
			System.out.println("NEXT STAGE");
			stage = stages.get(stageIndex);
			stage.add(player.getLblCharacter());
			stage.start();
		}
		else {
			this.endWorld(true);
		}
	}
	
	public void gravity(Character player) {
		if(!hasLanded(player)) {
			player.setDown(true);
			player.setY(player.getY()+player.getWeight());
		}
	}
	public boolean hasLanded(Character player) {
		SearchPlatforms search = stage.hasPlatform(player.getX(), player.getY());
		if(search.hasPlatform()) {
			player.setY(search.getY());
			player.setDown(false);
			return true;
		}		
		return false;
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
		
	}

	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

	public ArrayList<Stage> getStages() {
		return stages;
	}

	public void setStages(ArrayList<Stage> stages) {
		this.stages = stages;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Timer getGameTimer() {
		return gameTimer;
	}

	public void setGameTimer(Timer gameTimer) {
		this.gameTimer = gameTimer;
	}
	public boolean isNextDoorOpened() {
		return isNextDoorOpened;
	}
	public void setNextDoorOpened(boolean isNextDoorOpened) {
		this.isNextDoorOpened = isNextDoorOpened;
	}
	public boolean isPrevDoorOpened() {
		return isPrevDoorOpened;
	}
	public void setPrevDoorOpened(boolean isPrevDoorOpened) {
		this.isPrevDoorOpened = isPrevDoorOpened;
	}
}
