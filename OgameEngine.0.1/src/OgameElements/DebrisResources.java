/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author andrzej
 */
public class DebrisResources extends Resources{
    private int recyclers;
    public DebrisResources(int m, int c,int r )
    {
        super(m,c,0);
        this.recyclers=r;        
    }
    public DebrisResources(String m, String c, String r)
    {
        super(m,c,"0");
        this.recyclers=Integer.parseInt(r);
        
    }
    @Override
    public String getSCrystal() {
        return super.getSCrystal();
    }

    @Override
    public String getSMetal() {
        return super.getSMetal();
    }

    @Override
    public int getCrystal() {
        return super.getCrystal();
    }

   

    @Override
    public int getMetal() {
        return super.getMetal();
    }

    /**
     * @return the recyclers
     */
    public int getRecyclers() {
        return recyclers;
    }
    public String getSRecyclers() {
        return Integer.toString(this.recyclers);
    }
    
    
    
}
