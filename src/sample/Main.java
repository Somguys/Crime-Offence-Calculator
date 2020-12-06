package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.stream.Collectors;


public class Main extends Application
{
    private TableView<Crime> table = new TableView<Crime>();
    private TableView<Crime> table2 = new TableView<Crime>();

    private final ObservableList<Crime> data
            = FXCollections.observableArrayList(                // adds default list of Crimes to list
           new Crime("Assault","Assault on another person",24),
            new Crime("DUI","Drinking while Driving or under other substances",6),
            new Crime("Treason","The crime of betraying your country", 12000000),
            new Crime("Terrorism","The act of terrorizing someone",360),
            new Crime("Having Firearms","The act of keeping firearms which is illegal",180),
            new Crime("Corruption","Dishonest or fraudulent conduct",144),
            new Crime("Sexual Offence","The act of harassing someone physically",120),
            new Crime("1st degree Murder"," The act of intentionally murdering someone",300),
            new Crime("2nd degree murder","The act of assaulting someone who later dies",120),
            new Crime("3rd degree murder","The act of killing by recklessness",96),
            new Crime("4th degree murder","The act of killing without planning",60),
            new Crime("First Degree Assault", "The act of giving someone bodily injury",120),
            new Crime("Second Degree Assault","The act of recklessly causing bodily harm", 96),
            new Crime("3rd Degree Assault","The act of maiming or endangering someone's life",60),
            new Crime("4th degree Assault", "The act of attempting to cause bodily harm to someone",48),
            new Crime("Hate Propaganda","The act of promoting hate against someone",180),
            new Crime("Abortion","The act of killing an unborn baby",12000000),
            new Crime("Kidnapping", "The act of taking a person illegally by force",240),
            new Crime("Dognapping", "The act of taking a dog illegally by force",240),
            new Crime("Pickpocketing","The art of stealing from a person's pockets",5),
            new Crime("Burglary", "The entry of a building illegally with intent to commit a crime",60),
            new Crime("Breaking and entering", "The act of breaking into a building as well as entering it",48),
            new Crime("Forgery", "The act of forging a document",3),
            new Crime("Fraud", "The act of scamming someone",5),
            new Crime("Petty Crimes","Crimes that are not serious compared to other crimes",1),
            new Crime("Illegal Distribution of items","The unlawful distribution of items that are not permitted",180),
            new Crime("Hacking","The unlawful crime of breaking into a person's computer",240),
            new Crime("Ponzi Schemes", "The act of luring potential buyers to pay previous investors",600),
            new Crime("Rape","The act of raping another person",480),
            new Crime("Impersonating another person", "the act of unlawfully pretending to be another person",1),
            new Crime("Vandalism","The act of destroying another person's property",5),
            new Crime("Unorderly Conduct","The act of being unorderly within the public area",1),
            new Crime("Catnapping","The act of taking a cat illegally by force",240),
            new Crime("Animal Abuse","The act of abusing an animal",240),
            new Crime("Burglary","Steal other persons possessions by force",72)
    );


   public static Label totalLabelY = new Label();           //label for total sentence
    public static Label person = new Label("null");     // label for name of person created

   static TextField name = new TextField("Enter Full Name"); // textfields for entering values
   static TextField age = new TextField("Enter Age");
   static TextField city = new TextField(("Enter City of Origin"));

   static ChoiceBox<String> choiceBox1 = new ChoiceBox(); // choicebox for selecting person type


    public ObservableList<Crime> data1          // second list that takes added crimes and adds to this list
            = FXCollections.observableArrayList(
                    new Crime("Being Human","The Act of being a human",0)
    );

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("⚖️Crime Calculator ⚖️");
        stage.setWidth(1100);
        stage.setHeight(550);

        final Label label = new Label("Crime Book");        // labels
        final Label label1 = new Label("List of Offences");
        label.setFont(new Font("Arial", 20)); // set fonts
        label1.setFont(new Font("Arial", 20));

        final Label createperson = new Label("Submit Person");

        table.setEditable(false);

        TableColumn crime0 = new TableColumn("Crime");  // first table column
        crime0.setMinWidth(100);
        crime0.setCellValueFactory(
                new PropertyValueFactory<Crime, String>("crimeName"));  //takes value of crime

        TableColumn descript0 = new TableColumn("Description");//first table
        descript0.setMinWidth(180);
        descript0.setCellValueFactory(
                new PropertyValueFactory<Crime, String>("description"));

        TableColumn sent0 = new TableColumn("Sentence in Months");//first table
        sent0.setMinWidth(180);
        sent0.setCellValueFactory(
                new PropertyValueFactory<Crime, String>("sentence"));


        TableColumn crime1 = new TableColumn("Crime");   // second table
        crime1.setMinWidth(100);
        crime1.setCellValueFactory(
                new PropertyValueFactory<Crime, String>("crimeName"));

        TableColumn sent1 = new TableColumn("Sentence in Months");  //second table
        sent1.setMinWidth(180);
        sent1.setCellValueFactory(
                new PropertyValueFactory<Crime, String>("sentence"));


        FilteredList<Crime> flCrime= new FilteredList(data, p -> true);//Pass the data to a filtered list
        table.setItems(flCrime);//Set the table's items using the filtered list
        table.getColumns().addAll(crime0, descript0, sent0);  // adds all columns to table1

        table2.setItems(data1); //sets table2 data
        table2.getColumns().addAll(crime1,sent1); // adds all columns to table2

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox();              // first choicebox for selecting search
        choiceBox.getItems().addAll("Crime", "Description");
        choiceBox.setValue("Crime");

        Button createp = new Button("Process");

        // second choicebox for selecting gender
        choiceBox1.getItems().addAll("Male", "Female","Youth");
        choiceBox1.setValue(null);


        createp.setOnAction(e-> { // creates person based on class

            if (choiceBox1.getValue() == "Male" ){    //if male create a male
                Male male = new Male(name.getText(),age.getText(),city.getText());
                person.setText(male.toString());
            } else if(choiceBox1.getValue() == "Female"){  //if female create a female
                Female female = new Female(name.getText(),age.getText(),city.getText());
                person.setText(female.toString());
            } else {  // if youth, create child
                Child child = new Child (name.getText(),age.getText(),city.getText());
                person.setText(child.toString());
            }});


        name.setOnMouseClicked(e -> {   // clears textfields when mouse clicked in textfield
            name.clear();
        });
        age.setOnMouseClicked(e-> {
             age.clear(); });
        city.setOnMouseClicked(e-> {
            city.clear();
        });

        TextField textField = new TextField(); // textfield for searching
        textField.setPromptText("Search here!");
        textField.setOnKeyReleased(keyEvent ->
        {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Crime":  //predicates filter list according to entered values
                    flCrime.setPredicate(p -> p.getCrimeName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
                    break;
                case "Description": //another predicate for filtering description
                    flCrime.setPredicate(p -> p.getDescription().toLowerCase().contains(textField.getText().toLowerCase().trim()));
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {//reset table and textfield when new choice is selected
            if (newVal != null)     // resets to different predicate when choicebox is changed
            {
                textField.setText("");
                flCrime.setPredicate(null);//This is same as saying flCrime.setPredicate(p->true);
            }
        });

        Button add1 = new Button("Add to list");
        add1.setOnAction(e -> {
          Crime a =   table.getSelectionModel().getSelectedItem();          //adds selected items to table2 list
            data1.add(a);
            table2.setItems(data1);
        });

        add1.disableProperty().bind(Bindings.isEmpty(table.getSelectionModel().getSelectedItems()));  //disables add button when no property is selected

        Button save = new Button ("Save File");  // saves all information as a file using writeToTextFile in crime class
        save.setOnAction(e -> {
            try {   if (checkPerson()) {
                for (Crime p : data1) {
                    p.writeToTextFile("ListofOffences.txt", data1); // saves file as "ListofOffences.txt"
                }
                System.out.println("Sucessfully wrote to file, named \"ListofOffences.txt\"");
            }   } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Button delete = new Button ("Delete selected"); // deletes selected item in table2 on click
        delete.setOnAction((e->{
            data1.remove(table2.getSelectionModel().getSelectedItem());
        }));

        IntegerBinding total = Bindings.createIntegerBinding(() ->      //sums all values in "sentence" in table2
                        table2.getItems().stream().collect(Collectors.summingInt(Crime::getSentence)),
                table2.getItems());

        Label totalLabel = new Label(); // total label for months

        totalLabel.textProperty().bind(Bindings.format("Total: %d Months", total));       // get value of total and set as label property
        IntegerBinding years1 = total.divide(12);                               // converts month to years
        totalLabelY.textProperty().bind(Bindings.format("Total: %d Years", years1));  //total label for years

        HBox hBox = new HBox(choiceBox, textField,add1);//Add choiceBox and textField to hBox  // and sets up UI format using HBox and VBox
        VBox vBox = new VBox(label,table,hBox);
        HBox hBox1 = new HBox(save,delete);  // HBox and VBox for creating UI format
        VBox vBox2 = new VBox(label1,person,table2,totalLabel,totalLabelY,hBox1);
        VBox vBox1 = new VBox(createperson,choiceBox1,name,age,city,createp);
        vBox1.setPadding(new Insets(10, 20, 50, 15)); // spacings
        vBox1.setSpacing(10);

        HBox hBox2 = new HBox(vBox,vBox1, vBox2);

        hBox.setAlignment(Pos.CENTER);//Center HBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hBox2);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);  // sets stage
        stage.show();
    }

    public static String getValue0(){           // getter method for total label of years
        String a =  totalLabelY.getText();
        return a;
    }

    public static String getPerson0(){    // getter method for person label
        String a = person.getText();
        return a;
    }

    public static boolean checkPerson(){
     if ( person.textProperty().getValue()== "null") {
         Alert alert = new Alert(Alert.AlertType.WARNING);  //creates alertbox if person label is empty
         alert.setTitle("Error, Please Enter a Person");  // show Alert
         alert.setHeaderText("Person Has not been entered");
         alert.setContentText("Please enter a Full Name, Followed by Age, Followed by City");
         alert.showAndWait();
         return false;
     }
     else if (choiceBox1.getValue().isEmpty()){   // else if choicebox1 is empty show Alert
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("ERROR");
         alert.setHeaderText("ChoiceBox selection");
         alert.setContentText("Please enter ChoiceBox Selection");
         alert.showAndWait();
         return false;
     } else {
         return true;
     }
}
}
