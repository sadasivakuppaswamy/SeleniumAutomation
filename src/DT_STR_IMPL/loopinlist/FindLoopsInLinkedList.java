package DT_STR_IMPL.loopinlist;

/**
 * Created by Sadasiva.Kuppaswamy on 03-12-2015.
 */
public class FindLoopsInLinkedList {
    public static void main(String args[]) {

        FindLoopsInLinkedList finder = new FindLoopsInLinkedList();

        SinglyLinkedList sampleList = new SinglyLinkedList();
        // First Insert randomly ten elements in a linked list
        for (int i = 0; i < 1; i++) {
            sampleList.add(i);
        }

            System.out.println(sampleList.getStart().getNext().getValue());

        System.out.println(sampleList);

        System.out.println("Loop Existence : " + finder.doesLoopExist(sampleList));
        System.out.println("Loop Existence : " + finder.doesLoopExist(finder.createLoop(sampleList)));
    }

    public boolean doesLoopExist(SinglyLinkedList listToCheck) {
        SinglyLinkedList.Node tortoise = listToCheck.getStart();
        SinglyLinkedList.Node hare = listToCheck.getStart();

        try {
            while (true) {
                tortoise = tortoise.getNext();
                hare = hare.getNext().getNext();
                if (tortoise == hare) {
                    return true;
                }
            }
        } catch (NullPointerException ne) {
            return false;
        }
    }

    private SinglyLinkedList createLoop(SinglyLinkedList sampleList) {
        sampleList.getStart().getNext().getNext().getNext().setNext(sampleList.getStart().getNext());
        return sampleList;
    }
}
