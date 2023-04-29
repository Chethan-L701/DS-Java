package DataStructs.LinkedList;

public class LinkList {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public void insert(int item) {
        if (head == null) {
            head = new Node();
            head.setData(item);
        } else {
            Node temp = head;
            while (temp.getLink() != null) temp = temp.getLink();
            Node node = new Node();
            node.setData(item);
            temp.setLink(node);
        }
        size++;
    }

    public void insert(int item, int pos) {
        if (head == null) {
            head = new Node();
            head.setData(item);
        } else {
            Node temp = head;
            Node node = new Node();
            node.setData(item);
            if (pos > 1) {
                int count = 1;
                while ((count < pos - 1) && (temp.getLink() != null)) {
                    temp = temp.getLink();
                    count++;
                }
                node.setLink(temp.getLink());
                temp.setLink(node);
            } else if (pos == 1) {
                node.setLink(head);
                head = node;
            }
        }
        size++;
    }

    public void deleteItem(int item) {
        boolean itemFound = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp.getLink()!=null){
                if(temp.getLink().getData()==item){
                    itemFound=true;
                    break;
                }
                temp = temp.getLink();
            }
            if(itemFound)
                temp.setLink(temp.getLink().getLink());
        }
        size--;
    }

    public void deletePos(int pos){
        if(pos>size)
            System.out.println("Position is out of range.");
        else{
            if(pos >1) {
                Node temp = head;
                for (int i = 1; i < pos - 1; i++)
                    temp = temp.getLink();
                temp.setLink(temp.getLink().getLink());
            }else if(pos ==1){
                head=head.getLink();
            }
        }
    }

    public int getItem(int index){
        if(index<=size){
            Node temp=head;
            for (int i=1;i<index;i++)
                temp=temp.getLink();
            return temp.getData();
        }
        return 0;
    }

    public void displayList() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print("\t" + temp.getData());
                temp = temp.getLink();
            } while (temp.getLink() != null);
            System.out.println("\t" + temp.getData());
        } else System.out.println("List is empty.");
    }
}