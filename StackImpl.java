/**
 * A Stack Implementation
 *
 * @author Laurent Mignot
 */
public class StackImpl extends AbstractStack {

    public StackImpl (List list) {
        super(list);
    }

    /**
     * @see Stack#isEmpty()
     */
    public boolean isEmpty () {
        return this.internalList != null ? this.internalList.isEmpty() : true;
    }

    /**
     * @see Stack#size()
     */
    public int size () {
        return this.internalList != null ? this.internalList.size() : 0;
    }

    /**
     * @see Stack#push()
     */
    public void push (Object item) {
        if (this.internalList != null && item != null) {
            this.internalList.add(item);
        }
    }

    /**
     * @see Stack#top()
     */
    public ReturnObject top () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.internalList.get(this.size() - 1);
    }

    /**
     * @see Stack#pop()
     */
    public ReturnObject pop () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return this.internalList.remove(this.size() - 1);
    }
}