package sample;

public class Male {
    String name;
    String age;  // changed to String
    String City;
    Integer suspectID;


    @Override
    public String toString() {
        return "SUSPECT-> Gender: Male|ID:"+ getSuspectID()+ " |Full Name: " + getName() +"| Age: " + getAge() +"| From: " + getCity();
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

    public Integer getSuspectID() {
        return suspectID;
    }

    public Male (String name, String age, String city){

        this.name= name;
        this.age= age;
        this.City = city;
        this.suspectID = addSuspectNum();
    }
    public int addSuspectNum() {//creates suspect number
        int k = 0;
        k = (int) Math.round(Math.random() * 10000);
        return k;
    }


}