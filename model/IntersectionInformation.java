package recursive_bubble.model;

/**
 * Created by prajogotio on 25/2/15.
 */

public class IntersectionInformation {
    private static IntersectionInformation EMPTY_INTERSECTION = null;
    private Bubble bubble;
    private boolean isEmpty;

    private IntersectionInformation(Bubble bubble, boolean isEmpty) {
        this.bubble = bubble;
        this.isEmpty = isEmpty;
    }

    public static IntersectionInformation getEmptyIntersection() {
        if(EMPTY_INTERSECTION == null) EMPTY_INTERSECTION = new IntersectionInformation(null, true);
        return EMPTY_INTERSECTION;
    }

    public static IntersectionInformation getIntersection(Bubble bubble) {
        return new IntersectionInformation(bubble, false);
    }

    public boolean isEmpty() { return isEmpty; }
    public Bubble getBubble() { return bubble; }
}