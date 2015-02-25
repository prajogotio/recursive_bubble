package recursive_bubble;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import recursive_bubble.view.PlainView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Recursive Bubble by Prajogo Tio");
        PlainView plainView = new PlainView(50, 50, 500);
        primaryStage.setScene(new Scene(plainView));
        plainView.start();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}