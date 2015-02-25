package recursive_bubble.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import recursive_bubble.model.Bubble;
import recursive_bubble.model.IntersectionInformation;
import recursive_bubble.model.Renderer;

/**
 * Created by prajogotio on 25/2/15.
 */
public class PlainView extends AnchorPane {
    private Bubble bubble;
    private Canvas canvas;
    private Renderer renderer;
    private Timeline timeline;
    public PlainView(double x, double y, double length) {
        super();
        bubble = new Bubble(x, y, length);
        canvas = new Canvas(600,600);
        renderer = new Renderer(canvas);
        getChildren().add(canvas);
        setOnMouseMoved(new PlainViewEventListener(bubble));
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000 / 60), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.getGraphicsContext2D().clearRect(0, 0, 600, 600);
                render();
            }
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void render() {
        bubble.render(renderer);
    }

    public void start() {
        timeline.play();
    }

}


class PlainViewEventListener implements EventHandler<MouseEvent>{
    private Bubble bubble;

    public PlainViewEventListener(Bubble bubble) {
        this.bubble = bubble;
    }

    @Override
    public void handle(MouseEvent event) {
        double mouseX = event.getSceneX();
        double mouseY = event.getSceneY();
        IntersectionInformation info = bubble.intersect(mouseX, mouseY);
        if(!info.isEmpty()) {
            info.getBubble().burst();
        }
    }
}