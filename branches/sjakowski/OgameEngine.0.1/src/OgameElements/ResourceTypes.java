/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author dyschemist
 */
public class ResourceTypes {
    protected ResourceTypes (String name){
     this.name=name;   
    }
    private String name;
    static ResourceTypes METAL = new ResourceTypes("METAL");
    static ResourceTypes CRYSTAL = new ResourceTypes("CRYSTAL");
    static ResourceTypes DEUTERIUM= new ResourceTypes("DEUTER");

    @Override
    public String toString() {
        return "ResourceTypes{" + "name=" + name + '}';
    }
    
}
