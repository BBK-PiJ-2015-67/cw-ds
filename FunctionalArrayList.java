/**
 * Implementation of FunctionalList extending ArrayList
 *
 * @author Laurent Mignot
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
    /**
     * @see FunctionalList#head()
     */
    @Override
    public ReturnObject head () {
        if (this.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        return new ReturnObjectImpl(this.storage[0]);
    }

    /**
     * @see FunctionalList#rest()
     */
    @Override
    public FunctionalList rest () {
        // @TODO: implement this
        return this; // temporary
    }
}