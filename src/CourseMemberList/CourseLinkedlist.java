package CourseMemberList;

public class CourseLinkedlist {
    private StudentNode head;
    private int size;

    public static void main(String[] args) {
        Student markPeng = new Student(711648, "Peng", "Mark");
        Student yiboSun = new Student(749763, "Sun", "Yibo");
        Student aayushPanda = new Student(894896, "Panda", "Aayush");

        StudentNode aayushNode = new StudentNode(aayushPanda, null);

        CourseLinkedlist students = new CourseLinkedlist();
        students.addToFront(aayushPanda);

        System.out.println("Original List:");
        students.printList();

        System.out.println("Add Kevin and Andy to List:");
        Student kevinAn = new Student(783643, "An", "Kevin");
        students.addToFront(kevinAn);

        Student andyLuo = new Student(707918, "Luo", "Andy");
        students.addToEnd(andyLuo);
        students.printList();

        System.out.println("Sorted List:");
        students.sort();
        students.printList();
    }

    public CourseLinkedlist() {
        head = null;
        size = 0;
    }

    public CourseLinkedlist(StudentNode head, int size) {
        this.head = head;
        this.size = size;
    }

    public void sort() {
        // O(NlogN) time complexity as we are using merge sort, which is O(NlogN) time complexity
        this.head = mergeSort(head);
    }

    public StudentNode mergeSort(StudentNode h) {
        // Literally just merge sort, so always O(NlogN) time complexity as rigorously proven in previous assignment
        if (h == null || h.getNext() == null)
            return h;

        StudentNode mid = getMiddle(h);
        StudentNode nextOfMid = mid.getNext();
        mid.setNext(null);

        StudentNode left = mergeSort(h);
        StudentNode right = mergeSort(nextOfMid);

        return merge(left, right);
    }

    public StudentNode merge(StudentNode left, StudentNode right) {
        // Operationally identical to merge used in prev. assignment, but recursive to be neater
        // always O(N) time complexity as rigorously proven in previous assignment
        StudentNode result = null;
        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.getStudent().getId() <= right.getStudent().getId()) {
            result = left;
            result.setNext(merge(left.getNext(), right));
        } else {
            result = right;
            result.setNext(merge(left, right.getNext()));
        }
        return result;
    }

    public StudentNode getMiddle(StudentNode head) {
        // Using this instead of getting node at size/2 because size variable is not updated in recursive calls for mergeSort
        // O(N) time complexity as we have to perform N/2 operations to get to the middle node, where 1/2*N is still O(N)
        if (head == null)
            return head;

        StudentNode slow = head, fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public void addatIndex(Student student, int index){
        // O(N) time complexity as we have to traverse the list to get to the index
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        } else{
            StudentNode temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.getNext();
            }
            StudentNode newNode = new StudentNode(student);
            if(temp != null){
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            } else {
                head = newNode;
            }
            size++;
        }
    }

    public StudentNode getAtIndex(int index){
        // O(N) time complexity as we have to traverse the list to get to the index
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        } else{
            StudentNode temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.getNext();
            }
            return temp;
        }
    }

    public void addToFront(Student student){
        // O(1) time complexity as we always traverse a constant number of nodes (0)
        this.addatIndex(student, 0);
    }

    public void addToEnd(Student student){
        // O(N) time complexity as we have to traverse the entire list to get to the end
        this.addatIndex(student, size);
    }

    public String toString(){
        // O(N) time complexity as we have to traverse the entire list to get to the end, as we print each node
        String result = "";
        StudentNode temp = head;
        while(temp != null){
            result += temp.toString() + "\n";
            temp = temp.getNext();
        }
        return result;
    }

    public void printList(){
        // O(N) time complexity as as it is only calling and printing resutls of toString(), an O(N) method
        System.out.println(toString());
    }
}
