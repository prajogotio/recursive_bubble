package recursive_bubble.model;

/**
 * Created by prajogotio on 25/2/15.
 */

public class InitialBubbleState implements BubbleState {
    private static InitialBubbleState INSTANCE = null;
    private InitialBubbleState() {}
    public static InitialBubbleState getState() {
        if(INSTANCE == null) INSTANCE = new InitialBubbleState();
        return INSTANCE;
    }

    @Override
    public void handleBurst(Bubble bubble) {
        double x = bubble.getX();
        double y = bubble.getY();
        double length = bubble.getLength()/2;
        bubble.add(new Bubble(x, y, length));
        bubble.add(new Bubble(x+length, y, length));
        bubble.add(new Bubble(x, y+length, length));
        bubble.add(new Bubble(x+length, y+length, length));
        bubble.setState(BurstBubbleState.getState());
    }

    @Override
    public IntersectionInformation intersect(Bubble bubble, double x, double y) {
        double dx = x - (bubble.getX()+bubble.getLength()/2);
        double dy = y - (bubble.getY()+bubble.getLength()/2);
        boolean isIntersecting =  dx*dx + dy*dy < bubble.getLength() * bubble.getLength() / 4;
        if(isIntersecting) return IntersectionInformation.getIntersection(bubble);
        return IntersectionInformation.getEmptyIntersection();
    }

    @Override
    public void render(Bubble bubble, Renderer renderer) {
        renderer.render(bubble);
        bubble.incrementDelta();
    }

}

