package DSA4.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    BinaryNode root;
    int depth = 0;
    int width = 0;

    String graphString;

    public static int[] genNumList(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] randomNumList(int n, int min, int max){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter min value in array: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter max value i array: ");
        int max = Integer.parseInt(scanner.nextLine());
        scanner.close();

        int[] arr = randomNumList(size, min, max);
        BinaryTree tree = new BinaryTree();
        for (int i : arr) {
            tree.insert(i);
        }
        System.out.println("UNOPTIMISED TREE");
        System.out.println("Input array: " + Arrays.toString(arr));
        System.out.println("Graph: ");
        tree.printGraphString();
        System.out.println("Traversal output: " + tree);
        System.out.println("Tree depth: " + tree.depth);

        System.out.println("\nOPTIMISED TREE");
        tree.balanceTree();
        System.out.println("Graph: ");
        tree.printGraphString();
        System.out.println("Traversal output: " + tree);
        System.out.println("Tree depth: " + tree.depth);
    }

    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(int data) {
        depth = 1;
        boolean farLeft = true;
        boolean farRight = true;
        if (this.root == null) {
            this.root = new BinaryNode(data);
            return;
        }
        BinaryNode current = this.root;
        while (true) {
            depth++;
            if (data < current.data) {
                if (current.left == null) {
                    current.left = new BinaryNode(data);
                    if (farLeft) width++;
                    return;
                }
                current = current.left;
                farRight = false;
            } else {
                if (current.right == null) {
                    current.right = new BinaryNode(data);
                    if (farRight) width++;
                    return;
                }
                current = current.right;
                farLeft = false;
            }
        }
    }

    public void remove(int data){
        if (this.root == null) {
            return;
        }
        BinaryNode current = this.root;
        BinaryNode parent = null;
        boolean farLeft = true;
        boolean farRight = true;
        while (current != null) {
            if (data < current.data) {
                parent = current;
                current = current.left;
                farRight = false;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                farLeft = false;
            } else {
                if (current.left == null && current.right == null) {
                    if (parent == null) {
                        this.root = null;
                    } else if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (current.left == null) {
                    if (parent == null) {
                        this.root = current.right;
                    } else if (parent.left == current) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                } else if (current.right == null) {
                    if (parent == null) {
                        this.root = current.left;
                    } else if (parent.left == current) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                } else {
                    BinaryNode successor = current.right;
                    BinaryNode successorParent = current;
                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    }
                    if (successorParent.left == successor) {
                        successorParent.left = successor.right;
                    } else {
                        successorParent.right = successor.right;
                    }
                    successor.left = current.left;
                    successor.right = current.right;
                    if (parent == null) {
                        this.root = successor;
                    } else if (parent.left == current) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                return;
            }
        }
        if (farLeft||farRight) width --;
    }

    public Integer[] fullTraverse(){
        Object[] t = Arrays.stream(this.toString().split(",")).map(Integer::parseInt).toArray();
        return Arrays.copyOf(t, t.length, Integer[].class);
    }

    public int binarySearch(int data) {
        if (root == null) {
            return -1;
        }
        if (root.data == data) {
            return 0;
        }
        if (data < root.data) {
            int left = binarySearch(root.left, data);
            if (left == -1) {
                return -1;
            }
            return left + 1;
        }
        int right = binarySearch(root.right, data);
        if (right == -1) {
            return -1;
        }
        return right + 1;
    }

        public static int binarySearch(BinaryNode root, int data) {
            if (root == null) {
                return -1;
            }
            if (root.data == data) {
                return 0;
            }
            if (data < root.data) {
                int left = binarySearch(root.left, data);
                if (left == -1) {
                    return -1;
                }
                return left + 1;
            }
            int right = binarySearch(root.right, data);
            if (right == -1) {
                return -1;
            }
            return right + 1;
        }

    public void balanceTree(){
        Integer[] arr = this.fullTraverse();
        this.root = null;
        balanceTree(arr, 0, arr.length-1);
    }

    public void balanceTree(Integer[] arr, int l, int r){
        if (l > r) return;
        int mid = (l+r)/2;
        this.insert(arr[mid]);
        balanceTree(arr, l, mid-1);
        balanceTree(arr, mid+1, r);
    }

    public static String toString(BinaryNode root) {
        if (root == null) {
            return "";
        }
        return (toString(root.left) + root.data  + "," + toString(root.right));
    }

    public String toString(){
        return toString(this.root);
    }

    //Print util

    public void printGraphString(){
        printGraphString(Collections.singletonList(root), 1, maxLevel(root));
    }

    private static <T extends Comparable<?>> void printGraphString(List<BinaryNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryNode> newNodes = new ArrayList<BinaryNode>();
        for (BinaryNode BinaryNode : nodes) {
            if (BinaryNode != null) {
                System.out.print(BinaryNode.data);
                newNodes.add(BinaryNode.left);
                newNodes.add(BinaryNode.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printGraphString(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryNode BinaryNode) {
        if (BinaryNode == null) {
            return 0;
        }

        return Math.max(maxLevel(BinaryNode.left), maxLevel(BinaryNode.right)) + 1;
    }

    private static  boolean isAllElementsNull(Iterable<?> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

}
