import greenfoot.*;

/**
 * Main game screen
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class MyWorld extends World
{
    private boolean gameEnded = false;
    private boolean freeplay = true;
    private Label youDied = new Label("You Died", 80);
    private Label restart = new Label("Press R to restart", 40);
    private Label autoShoot = new Label("Autoshoot",20);
    private Player player = new Player(freeplay);
    private SimpleTimer gameTime = new SimpleTimer();
    private Label sc = new Label("",0);
    private Bar hp = new Bar("HP:", "", 100, 100);
    private Bar ex = new Bar("Exp:", "", 0, 100);
    private Label lv = new Label("Level 0", 30);
    private Label totalTime = new Label("Time: ",80);
    private Class<? extends Shape>[] shapes = new Class[]{Triangle.class, Square.class, Pentagon.class};
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(boolean freeplay) {    
        super(1280, 720, 1);
        this.freeplay = freeplay;
        gameStart();
    }
    
    public void act() {
        if (gameEnded && Greenfoot.isKeyDown("r")) {
            gameEnded = false;
            removeObject(youDied);
            removeObject(restart);
            MyWorld nWorld = new MyWorld(freeplay);
            Greenfoot.setWorld(nWorld);
            gameStart();
        }
        
        if (getObjects(Shape.class).size() < 40) {
            addShapesToWorld(10);
        }
    }
    
    private void addShapesToWorld(int count){
        for (int i = 0; i < count; i++) {
            int shapeIndex = Greenfoot.getRandomNumber(shapes.length);
            Class<? extends Shape> selectedShape = shapes[shapeIndex];
            
            try {
                Shape newShape = selectedShape.getDeclaredConstructor().newInstance();
                addObject(newShape, getRandomNumber(80, 1200), getRandomNumber(20, 700));
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void gameOver() {
        addObject(youDied, getWidth() / 2, getHeight() / 2);
        addObject(restart, getWidth() / 2, getHeight() / 2 + 80);
        gameEnded = true;
    }
    
    public void targetReached() {
        int allSeconds = gameTime.millisElapsed() / 1000;
        int minutes = allSeconds / 60;
        int seconds = allSeconds % 60;
        totalTime.setValue("Time: " + minutes + ":" + seconds);
        addObject(totalTime, getWidth() / 2, getHeight() / 2);
        addObject(restart, getWidth() / 2, getHeight() / 2 + 80);
        removeObject(player);
        gameEnded = true;
    }
    
    public void gameStart() {
        addObject(player, getWidth() / 2, getHeight() / 2);
        addObject(sc, 0, 0);
        addObject(hp, getWidth() / 4, getHeight() - 50);
        addObject(ex, getWidth() / 4 * 3, getHeight() - 50);
        addObject(lv, getWidth() / 2, getHeight() - 50);
        
        if (!freeplay) {
            gameTime.mark();
        }
        
        addShapesToWorld(50);
    }
    
    public void printAutoMode(boolean mode) {
        if (mode)
        {
            addObject(autoShoot, getWidth() - 400, 100);
        } 
        else
        {
            removeObject(autoShoot);
        }
    }
    
    public void updateHpBar(int newHp) {
        hp.setValue(newHp);
    }
    
    public void increaseExp(int exp) {
        player.increaseExperience(exp);
    }
    
    public void updateExp(int exp) {
        ex.setValue(exp);
    }
    
    public void updateLv(int level) {
        lv.setValue("Level " + level);
        ex.setMaximumValue(100 * level);
        hp.setMaximumValue(100 + (50 * (level - 1)));
    }
    
    public boolean getMode() {
        return freeplay;
    }
    
    // Overloading default random number generator
    public int getRandomNumber(int start, int end) {  
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
}
