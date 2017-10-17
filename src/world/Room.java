package world;

import java.util.ArrayList;

import javax.swing.JFrame;
import com.characters.Character;
import com.elements.Stage;
import com.objects.InteractableObject;
import com.objects.bathroom.BathroomCabinet;
import com.objects.bathroom.BathroomLight;
import com.objects.bathroom.BathroomNote;
import com.objects.bathroom.BathroomShelf;
import com.objects.bathroom.BathroomSink;
import com.objects.bathroom.BathroomWindow;
import com.objects.bathroom.Bathtub;
import com.objects.bathroom.DaisyBottle;
import com.objects.bathroom.DaisyBubbles;
import com.objects.bathroom.HallwayBathroomDoor;
import com.objects.bathroom.LotusBottle;
import com.objects.bathroom.LotusBubbles;
import com.objects.bathroom.Mirror;
import com.objects.bathroom.RoseBottle;
import com.objects.bathroom.RoseBubbles;
import com.objects.bathroom.Toilet;
import com.objects.bathroom.ToiletPaper;
import com.objects.bedroom.Bed;
import com.objects.bedroom.BedroomCloset;
import com.objects.bedroom.BedroomLight;
import com.objects.bedroom.BedroomWindow;
import com.objects.bedroom.BottomDrawer;
import com.objects.bedroom.Clock;
import com.objects.bedroom.Drawer;
import com.objects.bedroom.Floorboard;
import com.objects.bedroom.HallwayBedroomDoor;
import com.objects.bedroom.Key;
import com.objects.bedroom.Lamp;
import com.objects.bedroom.LampLight;
import com.objects.bedroom.Picture;
import com.objects.bedroom.PillowLeft;
import com.objects.bedroom.PillowRight;
import com.objects.bedroom.Shirt;
import com.objects.bedroom.TopDrawer;
import com.objects.bedroom.Vault;
import com.objects.hallway.AcidRecipe;
import com.objects.hallway.BathroomDoor;
import com.objects.hallway.BedroomDoor;
import com.objects.hallway.BlueBook;
import com.objects.hallway.Bomb;
import com.objects.hallway.GreenBook;
import com.objects.hallway.HallwayShelfBottom;
import com.objects.hallway.HallwayShelfTop;
import com.objects.hallway.KitchenDoor;
import com.objects.hallway.OrangeBook;
import com.objects.hallway.PinkBook;
import com.objects.hallway.PurpleBook;
import com.objects.hallway.RedBook;
import com.objects.hallway.Whiteboard;
import com.objects.kitchen.Apple;
import com.objects.kitchen.Blender;
import com.objects.kitchen.Can;
import com.objects.kitchen.CarBattery;
import com.objects.kitchen.Cheese;
import com.objects.kitchen.CoffeePot;
import com.objects.kitchen.Dishes;
import com.objects.kitchen.Flask;
import com.objects.kitchen.Fridge;
import com.objects.kitchen.FridgeDoor;
import com.objects.kitchen.Garbage;
import com.objects.kitchen.Goblet;
import com.objects.kitchen.HallwayKitchenDoor;
import com.objects.kitchen.Honey;
import com.objects.kitchen.KitchenLight;
import com.objects.kitchen.KitchenShelf;
import com.objects.kitchen.SideTable;
import com.objects.kitchen.Sink;
import com.objects.kitchen.KitchenWindow;
import com.objects.kitchen.Mixer;
import com.objects.kitchen.Mug;
import com.objects.kitchen.Pot;
import com.objects.kitchen.Stove;
import com.objects.kitchen.StrawberryJam;
import com.objects.kitchen.Table;
import com.objects.kitchen.ToolBox;
import com.objects.kitchen.ToolBoxKey;
import com.objects.kitchen.Tumbler;
import com.objects.kitchen.WaterBottle;
import com.objects.kitchen.WireCutter;
import com.objects.kitchen.Wrench;

public class Room extends GameWorld {
	public static final int INDEX_HALLWAY = 0;
	public static final int INDEX_KITCHEN = 1;
	public static final int INDEX_BEDROOM = 2;
	public static final int INDEX_BATHROOM = 3;
	
	public static final int INDEX_X = 100;
	public static final int INDEX_Y = 550;

	public static final int INDEX_BATHROOM_X = 926;
	public static final int INDEX_BATHROOM_Y = 285;
	
	public static final int INDEX_KITCHEN_X = 120;
	public static final int INDEX_KITCHEN_Y = 285;
	
	public static final int INDEX_BEDROOM_X = 720;
	public static final int INDEX_BEDROOM_Y = 285;
	
	private static final long serialVersionUID = 1L;

	private String[][] basic;
	
	public Room(JFrame parent, Character player, boolean isRight) {
		super(parent, player, isRight);

		this.initBlueprints();
		
		/*
		 * ROOM 0 :: HALLWAY
		 */		
		ArrayList<InteractableObject> objects = new ArrayList<InteractableObject>();
		objects.add(new Bomb());
		
		objects.add(new OrangeBook());
		objects.add(new PurpleBook());
		objects.add(new AcidRecipe());
		objects.add(new GreenBook());
		objects.add(new BlueBook());
		objects.add(new PinkBook());		
		objects.add(new RedBook());
		
		objects.add(new HallwayShelfTop());
		objects.add(new HallwayShelfBottom());
		
		objects.add(new Whiteboard());
		objects.add(new KitchenDoor());
		objects.add(new BedroomDoor());
		objects.add(new BathroomDoor());

		stage = new Stage(this, this.basic, objects, "bg_hallway");
		this.stages.add(stage);		
		this.add(stage);
		

		/*
		 * ROOM 1 :: KITCHEN
		 */		
		objects = new ArrayList<InteractableObject>();

		objects.add(new HallwayKitchenDoor());
		objects.add(new KitchenLight());

		objects.add(new CarBattery());
		objects.add(new WireCutter());
		objects.add(new Wrench());
		objects.add(new ToolBox());
		
		objects.add(new Garbage());
		objects.add(new KitchenWindow());
		
		objects.add(new FridgeDoor());
		

		objects.add(new Cheese());
		objects.add(new Apple());
		objects.add(new Can());
		objects.add(new WaterBottle());
		objects.add(new Flask());
		objects.add(new StrawberryJam());
		
		objects.add(new Fridge());
		
		objects.add(new Goblet());
		objects.add(new ToolBoxKey());
		
		objects.add(new Blender());
		objects.add(new Tumbler());
		objects.add(new Dishes());
		objects.add(new Honey());
		objects.add(new Mixer());
		objects.add(new Pot());
		objects.add(new Sink());
		objects.add(new Mug());
		objects.add(new CoffeePot());
		objects.add(new SideTable());
		objects.add(new Stove());
		objects.add(new Table());
		objects.add(new KitchenShelf());
		
		stage = new Stage(this, this.basic, objects, "bg_kitchen");

		
		this.stages.add(stage);		
		this.add(stage);
		
		/*
		 * ROOM 2 :: BEDROOM
		 */		
		objects = new ArrayList<InteractableObject>();
		objects.add(new HallwayBedroomDoor());
		objects.add(new LampLight());
		objects.add(new Floorboard());
		objects.add(new Key());
		objects.add(new PillowLeft());
		objects.add(new PillowRight());
		
		objects.add(new BedroomLight());
		objects.add(new Clock());
		objects.add(new Picture());
		objects.add(new Lamp());
		objects.add(new Drawer());
		objects.add(new BottomDrawer());
		objects.add(new TopDrawer());
		objects.add(new Vault());
		objects.add(new Bed());
		objects.add(new Shirt());
		objects.add(new BedroomCloset());
		objects.add(new BedroomWindow());
		stage = new Stage(this, this.basic, objects, "bg_bedroom");
		this.stages.add(stage);		
		this.add(stage);
		
		/*
		 * ROOM 3 :: BATHROOM
		 */		
		objects = new ArrayList<InteractableObject>();
		objects.add(new HallwayBathroomDoor());
		objects.add(new BathroomLight());
		objects.add(new BathroomWindow());
		objects.add(new ToiletPaper());
		objects.add(new Toilet());
		objects.add(new BathroomSink());
		
		RoseBubbles roseBubbles = new RoseBubbles();
		DaisyBubbles daisyBubbles = new DaisyBubbles();
		LotusBubbles lotusBubbles = new LotusBubbles();
		
		objects.add(roseBubbles);
		objects.add(daisyBubbles);
		objects.add(lotusBubbles);
		
		objects.add(new Bathtub());
		
		RoseBottle roseBottle = new RoseBottle();
		DaisyBottle daisyBottle = new DaisyBottle();
		LotusBottle lotusBottle = new LotusBottle();
	
		objects.add(roseBottle);
		objects.add(daisyBottle);
		
		
		objects.add(lotusBottle);
		objects.add(new BathroomShelf());
		objects.add(new BathroomCabinet());

		objects.add(new BathroomNote());
		objects.add(new Mirror());
		
		
		stage = new Stage(this, this.basic, objects, "bg_bathroom");
		this.stages.add(stage);		
		this.add(stage);
		
		
		this.startWorld();
		this.gameTimer.start();		
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void startWorld() {		
		this.stage = this.stages.get(0);
		player.setParent(stage);
		player.setiX(INDEX_X);
		player.setiY(INDEX_Y);
		player.setX(player.getiX());
		player.setY(player.getiY());
		
		stage.start();
		swMoveListener.execute();
	}
	
	public void initBlueprints() {
		
		String[][] basic =                                                                                  //21
			   {{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //3
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //7
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //9
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //7
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //7
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //7
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //4
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //6
				{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //7
				{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//10
				{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//10
				{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//10
				{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};//10
		
		this.basic = basic;	
		
	}
}
