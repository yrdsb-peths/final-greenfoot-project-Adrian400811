import greenfoot.*;

/**
 * Player class of the game
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class Player extends SmoothMover
{
    private static final int TANK_SIZE = 50;
    private static final int MAX_HP = 100;
    private static final int HP_INCREASE_PER_LEVEL = 50;
    private static final int EXP_PER_LEVEL = 100;
    private static final int HP_INCREASE_PER_EXP = 25;
    private static final int SPEED_INCREASE_PER_LEVEL = 1;
    private static final double BULLET_SPEED_INCREASE_PER_LEVEL = 1.50;
    private static final int SHOOT_INTERVAL_DECREASE_PER_LEVEL = 4;
    private static final int SHOOT_INTERVAL_DIVISOR = 3;

    private SimpleTimer shootTimer = new SimpleTimer();
    private SimpleTimer modeTimer = new SimpleTimer();
    private GreenfootImage tankImage;
    private boolean autoShoot = false;
    private int hp = MAX_HP;
    private int speed = 2;
    private int exp = 1;
    private int level = 0;
    private double bulSpeed = 2.50;
    private int shootInterval = 500;
    private boolean freeplay = true;

    /**
     * Constructor of Player class
     */
    public Player() {
        tankImage = new GreenfootImage("DiepTank.png");
        tankImage.scale(TANK_SIZE, TANK_SIZE);
        setImage(tankImage);
    }

    public Player(boolean freeplay) {
        this();
        this.freeplay = freeplay;
    }

    public void act() {
        MyWorld world = getMyWorld();

        updateTankRotation();
        handleMovement();
        handleShooting();
        handleModeChange();
        handleCollision(world);

        checkGameOver(world);
    }

    private void updateTankRotation() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }
    }

    private void handleMovement() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getExactX(), getExactY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getExactX() - speed, getExactY());
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getExactX(), getExactY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getExactX() + speed, getExactY());
        }
    }

    private void handleShooting() {
        if (shootTimer.millisElapsed() > shootInterval && (Greenfoot.isKeyDown("space") || autoShoot)) {
            shoot();
            shootTimer.mark();
        }
    }

    private void handleModeChange() {
        if (modeTimer.millisElapsed() > 100 && Greenfoot.isKeyDown("e")) {
            MyWorld world = getMyWorld();
            autoShoot = !autoShoot;
            world.printAutoMode(autoShoot);
            modeTimer.mark();
        }
    }

    private void handleCollision(MyWorld world) {
        if (isTouching(Shape.class)) {
            hp--;
            world.updateHpBar(hp);
        }
    }

    private void checkGameOver(MyWorld world) {
        if (hp <= 0) {
            world.gameOver();
            world.removeObject(this);
        }
    }

    private void shoot() {
        Bullet bullet = new Bullet(getRotation(), bulSpeed);
        MyWorld world = getMyWorld();
        world.addObject(bullet, getX(), getY());
    }

    public void increaseExperience(int expIncrease) {
        if (hp < MAX_HP + (HP_INCREASE_PER_LEVEL * level)) {
            hp += expIncrease;
        } else {
            exp += expIncrease;
        }
        if (exp > (EXP_PER_LEVEL * level)) {
            level++;
            exp = 0;
            hp += HP_INCREASE_PER_EXP;
            speed += SPEED_INCREASE_PER_LEVEL;
            bulSpeed += BULLET_SPEED_INCREASE_PER_LEVEL;
            shootInterval = shootInterval / SHOOT_INTERVAL_DECREASE_PER_LEVEL * SHOOT_INTERVAL_DIVISOR;
        }
        MyWorld world = getMyWorld();
        if (!freeplay && level > 10) {
            world.targetReached();
        }
        world.updateHpBar(hp);
        world.updateExp(exp);
        world.updateLv(level);
    }

    private MyWorld getMyWorld() {
        return (MyWorld) getWorld();
    }

    public void setFreeplay(boolean freeplay) {
        this.freeplay = freeplay;
    }

    public boolean isFreeplay() {
        return freeplay;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public boolean isAutoShoot() {
        return autoShoot;
    }

    public void setAutoShoot(boolean autoShoot) {
        this.autoShoot = autoShoot;
    }
}
