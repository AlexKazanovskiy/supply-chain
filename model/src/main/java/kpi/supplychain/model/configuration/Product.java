package kpi.supplychain.model.configuration;

public class Product {
    private int id;
    private String nameString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nameString=" + nameString + "]";
    }
}
