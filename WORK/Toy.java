//ИГРУШКИ

package WORK;

public class Toy {
    private int id; // ID ИГРУШКИ
    private String name; // НАЗВАНИЕ ИГРУШКИ
    private int quantity; // КОЛИЧЕСТВО
    private double frequency; // ЧАСТОТА ВЫПАДЕНИЯ ИГРУШКИ

    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id; // ID ИГРУШКИ
        this.name = name; // НАЗВАНИЕ ИГРУШКИ
        this.quantity = quantity; // КОЛИЧЕСТВО
        this.frequency = frequency; // ЧАСТОТА ВЫПАДЕНИЯ ИГРУШКИ

    }

    public void setId(int id) { // ID set
        this.id = id;
    }

    public void setName(String name) { // НАЗВАНИЕ set
        this.name = name;
    }

    public int getId() { // ID get
        return id;
    }

    public String getName() { // НАЗВАНИЕ get
        return name;
    }

    public int getQuantity() { // КОЛИЧЕСТВО get
        return quantity;
    }

    public double getFrequency() { // ЧАСТОТА get
        return frequency;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; // КОЛИЧЕСТВО set
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency; // ЧАСТОТА set
    }

}