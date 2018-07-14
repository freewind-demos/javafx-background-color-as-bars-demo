package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().addAll(
                    new Label("Background color by code") {{
                        setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    }},
                    new Label("Background color by css") {{
                        setStyle("-fx-background-color: BLUE");
                    }}
            );
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}