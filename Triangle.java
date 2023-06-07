import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangle extends Shape
{
    GreenfootImage tr = new GreenfootImage("shapes/triangle.png");
    public Triangle(){
        super(15);
        tr.scale(50, 50);
        setImage(tr);
    }
}
