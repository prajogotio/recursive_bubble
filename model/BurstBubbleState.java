package recursive_bubble.model;

/**
 * Created by prajogotio on 25/2/15.
 */

public class BurstBubbleState implements BubbleState {
    private static BurstBubbleState INSTANCE = null;
    private double delta;

    private BurstBubbleState() {}
    public static BurstBubbleState getState() {
        if(INSTANCE == null) INSTANCE = new BurstBubbleState();
        return INSTANCE;
    }

    @Override
    public void handleBurst(Bubble bubble) {
        //
    }

    @Override
    public IntersectionInformation intersect(Bubble bubble, double x, double y) {
        if(x < bubble.getX() || bubble.getX() + bubble.getLength() < x) return IntersectionInformation.getEmptyIntersection();
        if(y < bubble.getY() || bubble.getY() + bubble.getLength() < y) return IntersectionInformation.getEmptyIntersection();
        for (Bubble b : bubble) {
            IntersectionInformation info = b.intersect(x, y);
            if(!info.isEmpty()) return info;
        }
        return IntersectionInformation.getEmptyIntersection();
    }

    @Override
    public void render(Bubble bubble, Renderer renderer) {
        renderer.render(bubble);
        bubble.decrementDelta();
        for (Bubble b : bubble) {
            b.render(renderer);
        }
    }
}