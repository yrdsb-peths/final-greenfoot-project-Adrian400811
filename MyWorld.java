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
<<<<<<< Updated upstream
=======
    public void printAutoMode(boolean mode){
        if(mode){
            addObject(autoShoot, getWidth()-400, 100);
        } else {
            removeObject(autoShoot);
        }
    }
    public void updateHpBar(int nhp){
        hp.setValue(nhp);
    }
    public void increaseExp(int exp){
        tk.incExp(exp);
    }
    public void updateExp(int exp){
        ex.setValue(exp);
    }
    public void updateLv(int lvl){
        lv.setValue("Level "+lvl);
        ex.setMaximumValue(100*lvl);
        hp.setMaximumValue(100+(50*(lvl-1)));
    }
>>>>>>> Stashed changes
}
