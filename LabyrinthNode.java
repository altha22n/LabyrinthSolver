/**
 * Created by peter on 3/29/17.
 */
public enum LabyrinthNode {
    PATH(true,false,false),
    WALL(false,false,false),
    ENTRANCE(true,true,false),
    EXIT(true,false,true);

    private final boolean isPassable;
    private final boolean isEntrance;
    private final boolean isExit;

    LabyrinthNode(boolean passable, boolean entrance, boolean exit) {
        isPassable = passable;
        isEntrance = entrance;
        isExit     = exit;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public boolean isEntrance() {
        return isEntrance;
    }

    public boolean isExit() {
        return isExit;
    }

    public String toString() {
        String result = super.toString();

        if( isPassable() )
            result += " is Passable";
        else
            result += " is not Passable";

        if( isEntrance() )
            result += ", Entrance,";


        if( isExit() )
            result += ", Exit";

        return result;
    }

    public String drawNode() {
        String result = "";

        if( isEntrance() )
            result += "E";
        else if( isExit() )
            result += "X";
        else if( isPassable() )
            result += "_";
        else
            result += "#";

        return result;
    }

    public static void main(String[] args) {
        for( LabyrinthNode l : LabyrinthNode.values() ) {
            System.out.println(l.toString());
        }
    }
}
