
/**
 * Write a description of class Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Engine
{
    private String name = "";
    private float tpl;
    private float totalNumTurns;

    public Engine(String name, float tpl)
    {
        this.name = name;
        this.tpl = tpl;
    }
    
    public float getTpl() {
        return tpl;
    }
    
    public float getTotalNumTurns() {
        return totalNumTurns;
    }
    
    public String getEngineName() {
        return name;
    }
}
