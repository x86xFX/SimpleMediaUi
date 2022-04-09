package module;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ui/mediaPlayer.fxml"));
            Parent root = loader.load();
            Controller controller = loader.getController();
            root.setStyle("-fx-background-color: transparent ;");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/resources/css/style.css")).toExternalForm());
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setTitle("Media Player");
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            controller.setStage(primaryStage);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}