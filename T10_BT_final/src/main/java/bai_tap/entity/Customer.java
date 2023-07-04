package bai_tap.entity;

public class Customer {
    private String name;
    private String data;
    private String adress;
    private String image;

    public Customer() {
    }

    public Customer(String name, String data, String adress, String image) {
        this.name = name;
        this.data = data;
        this.adress = adress;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
