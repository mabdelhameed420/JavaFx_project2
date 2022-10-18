package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        int spacing = 20;
        BorderPane bpmain = new BorderPane();
        bpmain.setPadding(new Insets(spacing));

        GridPane gptop = new GridPane();
        gptop.setHgap(spacing * 0.5);
        gptop.setVgap(spacing * 0.5);
        gptop.add(new Label("Name: "), 0, 0);
        gptop.add(new Label("Email: "), 0, 1);


        TextField txf1 = new TextField();
        TextField txf2 = new TextField();
        txf1.setPrefSize(spacing * 15, spacing * 1.5);
        txf2.setPrefSize(spacing * 15, spacing * 1.5);
        gptop.add(txf1, 1, 0);
        gptop.add(txf2, 1, 1);
        bpmain.setTop(gptop);

        GridPane gpcenter = new GridPane();
        gpcenter.setHgap(spacing * 0.5);
        gpcenter.setVgap(spacing * 0.5);
        gpcenter.setAlignment(Pos.CENTER_LEFT);

        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb1.setSelected(true);

        CheckBox chb1 = new CheckBox("Arabic");
        CheckBox chb2 = new CheckBox("English");
        CheckBox chb3 = new CheckBox("Spain");

        gpcenter.add(new Label("Country: "), 0, 0);
        gpcenter.add(new Label("Gender: "), 0, 1);
        gpcenter.add(new Label("Language"), 0, 2);

        gpcenter.add(rb1, 1, 1);
        gpcenter.add(rb2, 2, 1);
        gpcenter.add(chb1, 1, 2);
        gpcenter.add(chb2, 2, 2);
        gpcenter.add(chb3, 3, 2);
        bpmain.setCenter(gpcenter);

        ComboBox cb = new ComboBox();
        cb.getItems().addAll("Egypt", "france", "usa");
        gpcenter.add(cb, 1, 0);

        Button btregister = new Button("Register");
        bpmain.setBottom(btregister);
        btregister.setPrefWidth(spacing * 18);

        BorderPane pbSecond = new BorderPane();
        Menu menu = new Menu("File");
        MenuBar menubar = new MenuBar(menu);
        MenuItem mb = new MenuItem("Registration");
        menu.getItems().addAll(mb);
        pbSecond.setTop(menubar);

        GridPane sgp = new GridPane();
        pbSecond.setCenter(sgp);
        sgp.setPadding(new Insets(20));
        sgp.setVgap(10);

        Stage sstage = new Stage();
        Scene sscene = new Scene(bpmain, spacing * 20, spacing * 15);
        sstage.setScene(sscene);
        sstage.setResizable(false);
        sstage.setTitle("Registration");

        mb.setOnAction(e -> {
            sstage.show();
            stage.close();
        });

        btregister.setOnAction(e -> {
            sstage.close();
            stage.show();
            String ss = "Gender :  ";
            if (rb1.isSelected())
                ss += rb1.getText();
            else
                ss += rb2.getText();

            String s = "language :  ";
            if (chb1.isSelected())
                s += chb1.getText() + "  ";
            if (chb2.isSelected())
                s += chb2.getText() + "  ";
            if (chb3.isSelected())
                s += chb3.getText() + "  ";

            sgp.addColumn(0,
                    new Label("Name  :  " + txf1.getText()),
                    new Label("Email :  " + txf2.getText()),
                    new Label("country : " + cb.getSelectionModel().getSelectedItem().toString()),
                    new Label(s),
                    new Label(ss)

            );
        });


        Scene scene = new Scene(pbSecond, 500, 300);
        stage.setScene(scene);
        stage.setTitle("admin");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}