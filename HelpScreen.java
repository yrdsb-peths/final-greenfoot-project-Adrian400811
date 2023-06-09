import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tutorial Screen for the game
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class HelpScreen extends World
{
    /**
     * Constructor for objects of class HelpScreen.
     * 
     */
    public HelpScreen()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        // Create label entries
        Label title = new Label("Tutorial", 80);
        Label back = new Label("q: back to main menu", 30);
        Label ctrl = new Label("Controls", 60);
        Label move = new Label("w, a, s, d: move character", 40);
        Label turn = new Label("mouse movement: gun direction",40);
        Label auto = new Label("e: toggle auto-shoot", 40);
        Label soot = new Label("space / left-click (hold): shoot bullet", 40);
        Label targ = new Label("Target", 60);
        Label shot = new Label("Shoot objects to gain experience \nand regen health", 40);
        Label upgr = new Label("Upgrade every level",40);
        Label tank = new Label("New tank every lv 15", 40);
        
        // Put label entries to suitable places
        addObject(title, 150, 50);
        addObject(ctrl, 300, 130);
        addObject(move, 300, 200);
        addObject(turn, 300, 250);
        addObject(auto, 300, 300);
        addObject(soot, 300, 350);
        addObject(targ, getWidth()-300, 130);
        addObject(shot, getWidth()-300, 200);
        addObject(upgr, getWidth()-300, 275);
        addObject(tank, getWidth()-300, 325);
        addObject(back, getWidth()-300, getHeight()-50);
    }
    public void act(){
        if(Greenfoot.isKeyDown("q")){  // Back to title if "q" is pressed
            TitleScreen titlWorld = new TitleScreen();
            Greenfoot.setWorld(titlWorld);
        }
    }
}
