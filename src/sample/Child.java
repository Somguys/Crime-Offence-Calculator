package sample;

public class Child {
    String name;
    String age;  // changed to String
    String City;
    Integer suspectID;

    public Integer getSuspectID() {
        return suspectID;
    }

    public Child(String name, String age, String city) {  // constructor
        this.name= name;
        this.age =age;
        this.City = city;
        this.suspectID = addSuspectNum() ;
    }

    public String getName() {
        return name;
    }


    public String getAge() {
        return age;
    }


    public String getCity() {
        return City;
    }

    @Override
    public String toString() {
        return "SUSPECT->|ID:"+ getSuspectID()+ " |Full Name: undisclosed| Age: Under 18| From: undisclosed";
    }

    public void setCity(String city) {
        City = city;
    }

    public int addSuspectNum() {//creates suspect number
        int k = 0;
        k = (int) Math.round(Math.random() * 10000);
        return k;
    }


}
