import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main game screen
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class MyWorld extends World
{
    private boolean gameEnded = false;
    Label youDied = new Label("You Died", 80);
    Label restart = new Label("Press R to restart", 40);
    Label autoShoot = new Label("Autoshoot",20);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        gameStart();
    }
    public void act(){
        if(gameEnded && Greenfoot.isKeyDown("r")){
            gameEnded = false;
            removeObject(youDied);
            removeObject(restart);
            MyWorld nWorld = new MyWorld();
            Greenfoot.setWorld(nWorld);
            gameStart();
        }
        if(getObjects(Shape.class).size() < 40)
        {
            for(int i = 0; i < 10; i++){
            Shape sp = new Square();
            addObject(sp, getRandomNumber(80,1200), getRandomNumber(20,700));
            }
        }
        AngleDummy ang = new AngleDummy();
        addObject(ang, getWidth()/2, getHeight()/2);
        // Player tk = (Player) getObjects(Player.class);
        // tk.rotateTank(ang.getMouseAngle());
    }
    public void gameOver(){
        addObject(youDied, getWidth()/2, getHeight()/2);
        addObject(restart, getWidth()/2, getHeight()/2+80);
        gameEnded = true;
    }
    public void gameStart(){
        Player tk =  new Player();
        addObject(tk, getWidth()/2, getHeight()/2);
        for(int i = 0; i < 50; i++){
            Shape sp = new Square();
            addObject(sp, getRandomNumber(80,1200), getRandomNumber(20,700));
        }
    }
    // overloading default random number generator
    public int getRandomNumber(int start,int end)
    {  
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    public void printAutoMode(boolean mode){
        if(mode){
            addObject(autoShoot, getWidth()-400, 100);
        } else {
            removeObject(autoShoot);
        }
    }
}
