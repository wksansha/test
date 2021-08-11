package studydatastruct.test.datastruct.linked;

/**
 * @author wangkai
 * @create 2020/4/13
 */
public class SNode<T> {
    private T element;
    private SNode<T> next;
    public SNode(T element,SNode<T> next){
        this.element = element;
        this.next = next;
    }
    public SNode() {
        this.next = null;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

    public SNode<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
