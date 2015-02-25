package recursive_bubble.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prajogotio on 25/2/15.
 */
public class Bubble implements Iterable<Bubble>{
    private static double DELTA_DECAY_RATE = 0.035;
    private static double INITIAL_DELTA = 0.0;
    public static final double ERROR_PRECISION_RATE = 1e-4;
    private double x;
    private double y;
    private double length;
    private BubbleState state;
    private ArrayList<Bubble> bubbleList;
    private double delta;

    public Bubble(double x, double y, double length) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.state = InitialBubbleState.getState();
        delta = INITIAL_DELTA;
        bubbleList = new ArrayList<Bubble>();
    }

    public void burst() {
        state.handleBurst(this);
    }

    public void setState(BubbleState state) {
        this.state = state;
    }

    public IntersectionInformation intersect(double x, double y) {
        return state.intersect(this, x, y);
    }

    public void add(Bubble bubble) {
        bubbleList.add(bubble);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getLength() { return length; }
    public double getDelta() { return delta; }

    public void decrementDelta() {
        delta -= DELTA_DECAY_RATE;
        if(delta < 0.0) delta = 0.0;
    }

    public void incrementDelta() {
        delta += DELTA_DECAY_RATE;
        if(delta > 1.0) delta = 1.0;
    }

    public Iterator<Bubble> iterator() {
        return bubbleList.iterator();
    }
    public void render(Renderer renderer) {
        state.render(this, renderer);
    }
}

