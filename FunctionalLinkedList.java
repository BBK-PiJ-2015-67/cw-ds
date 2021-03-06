/**
 * Implementation of FunctionalList extending LinkedList
 *
 * @author Laurent Mignot
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    /**
     * @see FunctionalList#head()
     */
    @Override
    public ReturnObject head () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        return new ReturnObjectImpl(this.get(0).getReturnValue());
    }

    /**
     * @see FunctionalList#rest()
     */
    @Override
    public FunctionalList rest () {

        FunctionalList list = new FunctionalLinkedList();

        if (this.isEmpty() || this.size() == 1) {
            return list;
        }

        Node current = this.getNodeAtIndex(1);
        list.add(new Node(current.getValue()));

        while (current.getNext() != null) {
            current = current.getNext();
            list.add(new Node(current.getValue()));
        }

        return list;
    }
}