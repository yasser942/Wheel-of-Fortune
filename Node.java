public class Node {
    Object data;
    Node link;
    Object score;

    public Node(Object dataToaAdd) {
        this.data = dataToaAdd;
        link= null;
    }
    public Node(Object dataToaAdd,Object score) {
        this.data = dataToaAdd;
        link= null;
        this.score=score;
    }//constructor with Score attribute

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }
}
