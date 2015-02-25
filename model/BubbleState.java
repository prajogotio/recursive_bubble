package recursive_bubble.model;

/**
 * Created by prajogotio on 25/2/15.
 */



public interface BubbleState {
    public void handleBurst(Bubble bubble);
    public IntersectionInformation intersect(Bubble bubble, double x, double y);
    public void render(Bubble bubble, Renderer renderer);
}
