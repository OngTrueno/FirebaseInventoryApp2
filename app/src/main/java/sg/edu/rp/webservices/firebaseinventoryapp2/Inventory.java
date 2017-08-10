package sg.edu.rp.webservices.firebaseinventoryapp2;

import java.io.Serializable;

/**
 * Created by 15017470 on 10/8/2017.
 */

public class Inventory implements Serializable {

    private String id;
    private String name;
    private int cost;

    public Inventory() {

    }

    public Inventory(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
