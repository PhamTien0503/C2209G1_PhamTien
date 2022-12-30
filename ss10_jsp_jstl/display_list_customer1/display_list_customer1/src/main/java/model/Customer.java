package model;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String address;
    private String imageLink;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String address, String imageLink) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

