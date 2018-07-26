package demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Integer> numbers = FXCollections.observableArrayList(43, 65, 10, 98);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().addAll(
                    new ListView<Integer>() {{
                        setItems(numbers);
                        setCellFactory(param -> new ListCell<Integer>() {
                            @Override
                            protected void updateItem(Integer item, boolean empty) {
                                super.updateItem(item, empty);
                                setText(null);
                                if (!empty) {
                                    setText(item.toString());
                                    LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, new Stop[]{
                                            new Stop(0, Color.RED), new Stop(item / 100.0, Color.RED), new Stop(item / 100.0, Color.WHITE), new Stop(1, Color.WHITE)
                                    });
                                    setBackground(new Background(new BackgroundFill(lg1, null, null)));
                                }
                            }
                        });
                    }});
        }};
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }
}