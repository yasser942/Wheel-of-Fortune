public class SingleLinkedList {
    Node head;
    int position;//position of the required letter

    public void addPlayers(Object dataToAdd, Object score) {
        if (head == null) {
            Node newnode = new Node(dataToAdd, score);
            head = newnode;
        } else if (Integer.parseInt(score.toString()) >= Integer.parseInt(head.getScore().toString())) {
            Node newnode = new Node(dataToAdd, score);
            newnode.setLink(head);
            head = newnode;
        } else {
            Node temp = head;
            Node previous = null;
            while (temp != null && Integer.parseInt(score.toString()) <= Integer.parseInt(temp.getScore().toString())) {
                previous = temp;
                temp = temp.getLink();
            }
            if (temp == null) {
                Node newnode = new Node(dataToAdd, score);
                previous.setLink(newnode);
            } else {
                Node newnode = new Node(dataToAdd, score);
                newnode.setLink(previous.getLink());
                previous.setLink(newnode);
            }
        }
    }//this method to add and sort the high scores

    public void add(Object data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getLink() != null) {
                temp = temp.getLink();
            }
            Node newNode = new Node(data);
            temp.setLink(newNode);
        }
    }//

    public void sort(Object dataToAdd) {
        if (head == null) {
            Node newnode = new Node(dataToAdd);
            head = newnode;
        } else if (dataToAdd.toString().compareTo(head.getData().toString()) <= 0) {
            Node newnode = new Node(dataToAdd);
            newnode.setLink(head);
            head = newnode;
        } else {
            Node temp = head;
            Node previous = null;
            while (temp != null && dataToAdd.toString().compareTo(temp.getData().toString()) >= 0) {
                previous = temp;
                temp = temp.getLink();
            }
            if (temp == null) {
                Node newnode = new Node(dataToAdd);
                previous.setLink(newnode);
            } else {
                Node newnode = new Node(dataToAdd);
                newnode.setLink(previous.getLink());
                previous.setLink(newnode);
            }
        }
    }//sorts the list of animals

    public int size() {
        if (head == null) {
            return 0;
        } else {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                temp = temp.getLink();
                count++;
            }
            return count;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("list is empty!");
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.getScore() == null) {
                    System.out.print(temp.getData() + " ");

                } else {
                    System.out.println(temp.getData() + " " + temp.getScore());

                }

                temp = temp.getLink();
            }
        }

    }

    public boolean search(Object item, int a) {
        boolean flag = false;
        int count = 0;

        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            Node temp = head;
            while (temp != null) {
                if (count == a && item.toString().equalsIgnoreCase(temp.getData().toString())) {
                    flag = true;
                    position = count;
                }
                temp = temp.getLink();
                count++;


            }
        }
        return flag;
    }//searching in list

    public Object select(int a) {
        Object element = null;
        int count = 1;
        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            Node temp = head;
            while (temp != null) {

                if (count == a) {
                    element = temp.getData();
                }
                temp = temp.getLink();
                count++;
            }
        }
        return element;
    }//this method to choose an element from the list

    public Object select_Score(int a) {
        Object element = null;
        int count = 1;
        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            Node temp = head;
            while (temp != null) {

                if (count == a) {
                    element = temp.getScore();
                }
                temp = temp.getLink();
                count++;
            }
        }
        return element;
    }//to the score of a player(I use it during storing high scores)

    public void changeChar(int a, Object c) {
        Object element = null;
        int count = 0;
        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            Node temp = head;
            while (temp != null) {

                if (count == a) {
                    temp.setData(c);
                }
                temp = temp.getLink();
                count++;
            }
        }
    }//replaces (_) with the correct letter

    public void delete(Object dataToDelete) {
        if (head == null) {
            System.out.println("Linked list if empty!");
        } else {
            while (head != null && head.getData().toString().compareTo(dataToDelete.toString()) == 0) {
                head = head.getLink();
            }
            Node temp = head;
            Node previous = null;
            while (temp != null) {
                if (temp.getData().toString().compareTo(dataToDelete.toString()) == 0) {
                    previous.setLink(temp.getLink());
                    temp = previous;
                }
                previous = temp;
                temp = temp.getLink();
            }
        }
    }

}






