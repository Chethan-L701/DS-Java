package learnds.DataStructs.LinkedList;

public class Node {
    private int data;
    private Node link = null;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLink(Node node) {
        link = node;
    }

    public Node getLink() {
        return link;
    }
}
