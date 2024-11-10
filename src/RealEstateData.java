/**
 * @file: RealEstateData.java
 * @description: The RealEstateData class models a real estate property with various attribues. It implements the
 * comparable interface, allowing properties to be compared based on price, sqft price, and ID. THe class also overrides
 * equals for checking equality between property objects and provides a toString method for generating a readable string
 * representation of property details.
 * @author: Massie Flippin
 * @date: September 26th , 2024
 ************************/

public class RealEstateData implements Comparable<RealEstateData> {
    //ID, Possession Status, Commercial, Developer, Price, SqFt Price, Furnished, Bathroom, Facing, Transaction Type, Type of Property, City, Bedroom, Floors, isPrimeLocation, Lifespan
    private int ID;
    private String possessionstatus;
    private String commercial;
    private String developer;
    private int price;
    private int sqftprice;
    private String furnished;
    private int bathrooms;
    private String facing;
    private String transaction;
    private String type;
    private String city;
    private int bedrooms;
    private int floors;
    private String isPrimeLocation;
    private String lifespan;
    //Constructor to initialize the RealEstateData object with all its attributes
    public RealEstateData(int id, String possessionStatus, String commercial, String developer, int price, int sqftprice, String funished, int bathroom, String facing, String transaction, String type, String city, int bedrooms, int floors, String isPrimeLocatoin, String lifespan) {
        this.ID = id;
        this.possessionstatus = possessionStatus;
        this.commercial = commercial;
        this.developer = developer;
        this.price = price;
        this.sqftprice = sqftprice;
        this.furnished = funished;
        this.bathrooms = bathroom;
        this.facing = facing;
        this.transaction = transaction;
        this.type = type;
        this.city = city;
        this.bedrooms = bedrooms;
        this.floors = floors;
        this.isPrimeLocation = isPrimeLocatoin;
        this.lifespan = lifespan;
    }


    //Overriding the toString method to provide a readable string representation of RealEstateData
    @Override
    public String toString() {
        return "ID: " + ID + " Possession Status: " + possessionstatus + " Commercial: " + commercial + " Developer: " + developer + " Price: " + price + " Sqftprice: " + sqftprice + " Furnished: " + furnished + " Bathrooms: " + bathrooms + " Facing: " + facing + " Transaction: " + transaction + " Type: " + type + " City: " + city + " Bedrooms: " + bedrooms + " Floors: " + floors + " Prime Location: " + isPrimeLocation + " Lifespan: " + lifespan;
    }
    //Comparable interface for how RealEstateData objects should be stored.
    @Override
    public int compareTo(RealEstateData other) {
        //First compare by price
        if(this.price != other.price){
            return Integer.compare(this.price, other.price);
        }
        //If the price is the same, compare by square foot price
        if(this.sqftprice != other.sqftprice){
            return Integer.compare(this.sqftprice, other.sqftprice);
        }
        //If both price and square foot price are the same, compare by ID as a fallback
        return Integer.compare(this.ID, other.ID);
    }

    //equals method to check if two RealEstateData objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        //check each field for equality
        RealEstateData other = (RealEstateData) o;
        return ID == other.ID &&
                this.possessionstatus.equals(other.possessionstatus) &&
                this.commercial.equals(other.commercial) &&
                this.developer.equals(other.developer) &&
                this.price == other.price &&
                this.sqftprice == other.sqftprice &&
                this.furnished.equals(other.furnished) &&
                this.bathrooms == other.bathrooms &&
                this.facing.equals(other.facing) &&
                this.transaction.equals(other.transaction) &&
                this.type.equals(other.type) &&
                this.city.equals(other.city) &&
                this.bedrooms == other.bedrooms &&
                this.floors == other.floors &&
                this.isPrimeLocation.equals(other.isPrimeLocation) &&
                this.lifespan.equals(other.lifespan);
    }

    //Getters and Setters for ID
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    //Getters and Setters for Possession Status
    public String getPossessionstatus() {
        return possessionstatus;
    }
    public void setPossessionstatus(String possessionstatus) {
        this.possessionstatus = possessionstatus;
    }
    //getters and setters for Commercial
    public String getCommercial() {
        return commercial;
    }
    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }
    //getters and setters for developer
    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    //Getters and setters for price
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //getters and setters for sqftprice
    public int getSqftprice() {
        return sqftprice;
    }
    public void setSqftprice(int sqftprice) {
        this.sqftprice = sqftprice;
    }
    //getters and setters for furnished
    public String getFurnished() {
        return furnished;
    }
    public void setFurnished(String furnished) {
        this.furnished = furnished;
    }
    //getters and setters for batheroom count
    public int getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
    //getters and setters for the count
    public String getFacing() {
        return facing;
    }
    public void setFacing(String facing) {
        this.facing = facing;
    }
    //getters and setters for transaction type
    public String getTransaction() {
        return transaction;
    }
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
    //getters and setters for type of housing
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    //getters and setters for the city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    //getters and setters for the bedroom count
    public int getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    //getters and setters for the number of floors
    public int getFloors() {
        return floors;
    }
    public void setFloors(int floors) {
        this.floors = floors;
    }
    //getters and setters for if its a prime locatin or not
    public String getIsPrimeLocation() {
        return isPrimeLocation;
    }
    public void setIsPrimeLocation(String isPrimeLocation) {
        this.isPrimeLocation = isPrimeLocation;
    }
    //getters and setters for the lifespan
    public String getLifespan() {
        return lifespan;
    }
    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }
}
