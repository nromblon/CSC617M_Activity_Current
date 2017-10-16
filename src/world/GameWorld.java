package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import com.characters.Character;
import com.elements.Controls;
import com.elements.Game;
import com.elements.GameBar;
import com.elements.Instructions;
import com.elements.Inventory;
import com.elements.Stage;
import com.elements.parser.Action;
import com.objects.bedroom.PictureNote;
import com.overlay.AcidRecipeOverlay;
import com.overlay.BathroomNoteOverlay;
import com.overlay.BombClueOverlay;
import com.overlay.BombWiring;
import com.overlay.MedicineCabinet;
import com.overlay.OverlayObject;
import com.overlay.PictureNoteOverlay;
import com.overlay.SinkTopView;
import com.overlay.SliderGame;
import com.overlay.VaultPassword;
import com.screens.MainMenu;


public abstract class GameWorld extends World {
	private static final long serialVersionUID = 1L;
	public static boolean IS_PAUSED;

	
	protected JFrame parent;
	
	protected Controls controls;
	protected Inventory inventory;
	protected Instructions instructions;
	
	protected VaultPassword vault;
	protected SinkTopView sink;
	protected BathroomNoteOverlay note;
	protected SliderGame sliderGame;
	protected BombWiring bombWiring;
	protected MedicineCabinet medicineCabinet;
	protected PictureNoteOverlay pictureNote;
	protected AcidRecipeOverlay acidRecipe;
	protected BombClueOverlay bombClue;
	
	protected Timer gameTimer;
	
	protected JLabel lblResult;
	protected JButton btnCharacterSelect;
	
	protected ImageIcon iiResultWin;
	protected ImageIcon iiResultLose;
	protected boolean isRight;
	protected SwingWorker<Void, Object> swMoveListener;
	protected abstract void startWorld();
	protected ArrayList<OverlayObject> listOverlay;
	/**
	 * @param parent
	 * @param player
	 */
	public GameWorld(JFrame parent, Character player, boolean isRight) {
		super(parent, player);
		this.parent = parent;
		this.isActive = true;
		IS_PAUSED = false;
		
		this.player = player;
		this.stageIndex = 0;
		this.stages = new ArrayList<Stage>();
		this.gameTimer = new Timer(0, this);	
		this.setRight(isRight);
		this.initComponents();

		this.swMoveListener = new MovementListener();
		this.gamebar = new GameBar(this, this.player);
		this.vault = new VaultPassword(this, this.player);

		this.sink = new SinkTopView(this, this.player);
		this.note = new BathroomNoteOverlay(this, this.player);
		
		this.controls = new Controls(this, this.player);
		this.inventory = new Inventory(this, this.player);
		this.instructions = new Instructions(this);

		this.sliderGame = new SliderGame(this, this.player);
		this.medicineCabinet = new MedicineCabinet(this, this.player);
		this.bombWiring = new BombWiring(this, this.player);
		this.pictureNote = new PictureNoteOverlay(this, this.player);
		this.acidRecipe = new AcidRecipeOverlay(this, this.player);
		this.bombClue = new BombClueOverlay(this, this.player, this.isRight);
		
//		controls.setBounds(0, 0, controls.getWidth(), controls.getHeight());
		
		this.listOverlay = new ArrayList<OverlayObject>();

		listOverlay.add(sliderGame);
		listOverlay.add(pictureNote);
		listOverlay.add(vault);
		listOverlay.add(sink);
		listOverlay.add(note);
		listOverlay.add(medicineCabinet);
		listOverlay.add(bombWiring);
		listOverlay.add(acidRecipe);
		listOverlay.add(bombClue);
		
		this.add(btnCharacterSelect);
		this.add(instructions);
		this.add(inventory);
		this.add(controls);

		this.add(lblResult);

		this.add(sliderGame);		
		this.add(vault);
		this.add(sink);	
		this.add(acidRecipe);	
		this.add(pictureNote);
		this.add(note);
		this.add(bombWiring);
		this.add(medicineCabinet);
		this.add(bombClue);	
		this.add(gamebar);		

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
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor( getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	public void closeAllOverlays() {
		int size = listOverlay.size();
		for(int i = 0; i < size; i++) {
			listOverlay.get(i).close();
		}
	}
	
	public void openOverlaySink() {
		this.closeAllOverlays();
		this.sink.open();
	}
	
	public void openOverlayVault() {
		this.closeAllOverlays();
		this.vault.open();
	}
	
	public void openOverlayNote() {
		this.closeAllOverlays();
		this.note.open();
	}

	public void openSliderGame() {
		this.closeAllOverlays();
		this.sliderGame.open();
	}
	
	public void openBombWiring() {
		this.closeAllOverlays();
		this.bombWiring.open();
	}
	
	public void openOverlayMedicineCabinet() {
		this.closeAllOverlays();
		this.medicineCabinet.open();
	}
	
	public void openPictureNoteOverlay() {
		this.closeAllOverlays();
		this.pictureNote.open();
	}
	public void openAcidRecipeOverlay() {
		this.closeAllOverlays();
		this.acidRecipe.open();
	}
	class MovementListener extends SwingWorker<Void, Object> {
		private Timer moveTimer;
		public MovementListener() {
			this.moveTimer = new Timer(0, new MoveListener());
			this.moveTimer.start();
		}
		private class MoveListener implements ActionListener {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!IS_PAUSED) {
					if(player.isBusy()) {
						player.continueAction();
					}
					player.move();
					if(!player.isUp()) {
						gravity(player);
					}		
					player.getLblCharacter().setLocation(player.getX()-player.getCenterX(), player.getY()-player.getLblCharacter().getHeight());							
					
					if(!isActive)
						   moveTimer.stop();
				}
			}
		}
		public Timer getMoveTimer() {
			return moveTimer;
		}
		@Override
		public Void doInBackground() {
			return null;
		}
	   @Override
	   protected void done() {
	   }
	}
	
	public void actionPerformed(ActionEvent e) {
		gamebar.update();
		this.update();
		repaint();
		revalidate();
	}
	
	public void update() {
		// TODO END Update

		if(!player.isBusy()){
			Action a = controls.getActionQueue().poll();
			if(a != null){
				controls.processAction(a);
			}
		}

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


	public void addPictureNote() {
		PictureNote picturenote = new PictureNote();
		this.getInventory().addItem(picturenote);
	}
	
	public void updateMessage(String text){
		this.getGamebar().addMsgQueue(text);
	}

	public void toCharacterSelect() {
		this.isActive = false;
		if(this.gameTimer.isRunning())
			this.gameTimer.stop();
		Game.M.stop();
		this.parent.add(new MainMenu(this.parent));
		this.parent.remove(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.btnCharacterSelect) {
			this.toCharacterSelect();
		}
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

	public Controls getControls(){ return controls;}

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

	public GameBar getGamebar() {
		return gamebar;
	}

	public void setGamebar(GameBar gamebar) {
		this.gamebar = gamebar;
	}

	public Timer getGameTimer() {
		return gameTimer;
	}

	public void setGameTimer(Timer gameTimer) {
		this.gameTimer = gameTimer;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public VaultPassword getVault() {
		return vault;
	}
	public void setVault(VaultPassword vault) {
		this.vault = vault;
	}
	public SinkTopView getSink() {
		return sink;
	}
	public void setSink(SinkTopView sink) {
		this.sink = sink;
	}
	
	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
}
