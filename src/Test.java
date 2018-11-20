import java.util.ArrayList;

public class Test
{
    public static void main(String args[])
    {
        Coords point1 = new Coords(3,-7);
        Coords point2 = new Coords(2.1);
        Coords point3 = new Coords();
        Coords point4 = new Coords(point1);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);

        ArrayList<Coords> myList = new ArrayList<>();
        myList.add(new Coords(6,5));
        myList.add(new Coords(5,8));
        myList.add(new Coords(3,8));
        myList.add(new Coords(7,11));
        myList.add(new Coords(2000,9));
        myList.add(new Coords(5,9));
        myList.add(new Coords(7,7));
        myList.add(new Coords(5,-5));
        myList.add(new Coords(6,5));

        Coords closestToOrigin = Coords.closestPointToOrigin(myList);
        System.out.println(closestToOrigin);
    }
}
