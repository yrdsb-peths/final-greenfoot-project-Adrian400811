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
    private boolean freeplay = true;
    Label youDied = new Label("You Died", 80);
    Label restart = new Label("Press R to restart", 40);
    Label autoShoot = new Label("Autoshoot",20);
    Player tk =  new Player(freeplay);
    SimpleTimer gameTime = new SimpleTimer();
    Label sc = new Label("",0);
    Bar hp = new Bar("HP:", "", 100, 100);
    Bar ex = new Bar("Exp:", "", 0, 100);
    Label lv = new Label("Level 0", 30);
    Label totalTime = new Label("Time: ",80);
    Class[] shapes = {Triangle.class, Square.class, Pentagon.class};
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(boolean free)
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        gameStart();
        freeplay = free;
    }
    public void act(){
        if(gameEnded && Greenfoot.isKeyDown("r")){
            gameEnded = false;
            removeObject(youDied);
            removeObject(restart);
            MyWorld nWorld = new MyWorld(freeplay);
            Greenfoot.setWorld(nWorld);
            gameStart();
        }
        if(gameEnded && Greenfoot.isKeyDown("r")){
            gameEnded = false;
            removeObject(youDied);
            removeObject(restart);
            MyWorld nWorld = new MyWorld(freeplay);
            Greenfoot.setWorld(nWorld);
            gameStart();
        }
        if(getObjects(Shape.class).size() < 40)
        {
            for(int i = 0; i < 10; i++){
                int shapesInd = Greenfoot.getRandomNumber(shapes.length);
                Class selectedShape = shapes[shapesInd];
                try{
                    Actor newShape = (Actor) selectedShape.newInstance();
                    addObject(newShape, getRandomNumber(80,1200), getRandomNumber(20,700));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void gameOver(){
        addObject(youDied, getWidth()/2, getHeight()/2);
        addObject(restart, getWidth()/2, getHeight()/2+80);
        gameEnded = true;
    }
    public void targetReached(){
        int allSecond = gameTime.millisElapsed()/1000;
        int minute = allSecond/60;
        int second = allSecond%60;
        totalTime.setValue("Time: "+minute+":"+second);
        addObject(totalTime, getWidth()/2, getHeight()/2);
        addObject(restart, getWidth()/2, getHeight()/2+80);
        removeObject(tk);
        gameEnded = true;
    }
    public void gameStart(){
        addObject(tk, getWidth()/2, getHeight()/2);
        addObject(sc, 0, 0);
        addObject(hp, getWidth()/4, getHeight()-50);
        addObject(ex, getWidth()/4*3, getHeight()-50);
        addObject(lv, getWidth()/2, getHeight()-50);
        if(!freeplay){
            gameTime.mark();
        }
        for(int i = 0; i < 50; i++){
            int shapesInd = Greenfoot.getRandomNumber(shapes.length);
            Class selectedShape = shapes[shapesInd];
            try{
                Actor newShape = (Actor) selectedShape.newInstance();
                addObject(newShape, getRandomNumber(80,1200), getRandomNumber(20,700));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
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
    public boolean getMode(){
        return freeplay;
    }
}

