package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Crime {

    private final SimpleStringProperty crimeName;
    private final SimpleStringProperty description;
    private final SimpleIntegerProperty sentence;

    public Crime(String cName, String dName, Integer sentence)
    {
        this.crimeName = new SimpleStringProperty(cName);
        this.description = new SimpleStringProperty(dName);
        this.sentence = new SimpleIntegerProperty(sentence);
    }


    public String getCrimeName() {
        return crimeName.get();
    }

    public SimpleStringProperty crimeNameProperty() {
        return crimeName;
    }

    public void setCrimeName(String crimeName) {
        this.crimeName.set(crimeName);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getSentence() {
        return sentence.get();
    }

    public SimpleIntegerProperty sentenceProperty() {
        return sentence;
    }

    public void setSentence(Integer sentence) {
        this.sentence.set(sentence);
    }


    public static void writeToTextFile(String filename, ObservableList<Crime> crimes)
            throws IOException {    // file writer that writes to filename
        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        writer.write("The List: ");
        writer.write(Main.getPerson0()+ "\n" +"\n");   // writes the person created to file
        for (Crime person : crimes) {                      // writes list of crimes from added list
            writer.write(person.getCrimeName() + ", " + person.getDescription() + ", " + person.getSentence() + " Months" + "\n"); // formats list
        }

            writer.write("\n"+Main.getValue0()); // gets value of Total Sentence label
        writer.close();
    }
}