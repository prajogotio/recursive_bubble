package recursive_bubble.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by prajogotio on 25/2/15.
 */
public class Renderer {
    private Canvas canvas;
    private GraphicsContext graphics;

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.graphics = canvas.getGraphicsContext2D();
    }

    public void render(Bubble bubble) {
        if(bubble.getDelta() < Bubble.ERROR_PRECISION_RATE) return;
        double x = bubble.getX();
        double y = bubble.getY();
        double length = bubble.getLength();
        double currentLength = bubble.getDelta() * length;
        double margin = (length - currentLength)/2;
        graphics.save();
        graphics.translate(x+margin, y+margin);
        graphics.setFill(Color.DARKKHAKI);
        graphics.fillOval(0, 0, currentLength, currentLength);
        graphics.restore();
    }
}
