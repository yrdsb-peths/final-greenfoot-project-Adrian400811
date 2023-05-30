import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen of game
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        Label title = new Label("A Random Game", 70);
        Label start = new Label("Press Space to Start", 30);
        Label help = new Label("Press q for Help",30);
        addObject(title, getWidth()/2, getHeight()/2);
        addObject(start, getWidth()/2, getHeight()/2+100);
        addObject(help, getWidth()/2, getHeight()/2+150);
    }
    public void act(){
        if(Greenfoot.isKeyDown("q")){
            HelpScreen tutWorld = new HelpScreen();
            Greenfoot.setWorld(tutWorld);
        }
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
