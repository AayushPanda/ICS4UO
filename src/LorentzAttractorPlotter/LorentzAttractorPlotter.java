package LorentzAttractorPlotter;

public class LorentzAttractorPlotter {
    // Plot the Lorentz Attractor
    public static void main(String[] args) {
        // Create a Lorentz Attractor
        LorentzAttractor attractor = new LorentzAttractor(10, 28, 8.0 / 3.0);
        // Plot the Lorentz Attractor
        attractor.plot(0.01, 10000);
    }

    // A class for plotting the Lorentz Attractor
    private static class LorentzAttractor {
        // The parameters for the Lorentz Attractor
        private double sigma;
        private double rho;
        private double beta;

        // Constructor for a Lorentz Attractor
        public LorentzAttractor(double sigma, double rho, double beta) {
            this.sigma = sigma;
            this.rho = rho;
            this.beta = beta;
        }

        // Plot the Lorentz Attractor
        public void plot(double dt, int iterations) {
            // Create a GenericStack of Points
            GenericStack<Point> points = new GenericStack<>();
            // Add the initial point to the stack
            points.push(new Point(1, 1, 1));
            // Iterate through the points
            for (int i = 0; i < iterations; i++) {
                // Get the previous point
                Point previous = points.peek();
                // Calculate the next point
                Point next = new Point(
                        previous.getX() + dt * sigma * (previous.getY() - previous.getX()),
                        previous.getY() + dt * (previous.getX() * (rho - previous.getZ()) - previous.getY()),
                        previous.getZ() + dt * (previous.getX() * previous.getY() - beta * previous.getZ())
                );
                // Add the next point to the stack
                points.push(next);
            }
            // Plot the points
            points.plot();
        }

        // A class for a point in 3D space
        public static class Point {
            // The coordinates of the point
            private double x;
            private double y;
            private double z;

            // Constructor for a point
            public Point(double x, double y, double z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }

            // Get the x coordinate
            public double getX() {
                return x;
            }

            // Get the y coordinate
            public double getY() {
                return y;
            }

            // Get the z coordinate
            public double getZ() {
                return z;
            }
        }
    }

    // A class for a GenericStack of objects
    private static class GenericStack<T> {
        // The top of the GenericStack
        private Node<T> top;

        // Constructor for an empty GenericStack
        public GenericStack() {
            this.top = null;
        }

        // Constructor for a GenericStack with an initial object
        public GenericStack(T object) {
            this.top = new Node<>(object, null);
        }

        // Push an object onto the GenericStack
        public void push(T object) {
            this.top = new Node<>(object, this.top);
        }

        // Pop an object off of the GenericStack
        public T pop() {
            T object = this.top.getObject();
            this.top = this.top.getNext();
            return object;
        }

        // Peek at the top of the GenericStack
        public T peek() {
            return this.top.getObject();
        }

        // Check if the GenericStack is empty
        public boolean isEmpty() {
            return this.top == null;
        }

        // Plot the GenericStack of Points
        public void plot() {
            // Create a new Plot
            Plot plot = new Plot("Lorentz Attractor", "x", "z");
            // Create an array of x coordinates
            double[] x = new double[this.size()];
            // Create an array of z coordinates
            double[] z = new double[this.size()];
            // Iterate through the points
            int i = 0;
            for (GenericStack<T>.Node<T> node = this.top; node != null; node = node.getNext()) {
                // Get the point
                Point point = node.getObject();
                // Add the coordinates to the arrays
                x[i] = point.getX();
                z[i] = point.getZ();
                // Increment the index
                i++;
            }
            // Plot the points
            plot.addPoints(x, z);
            // Display the plot
            plot.display();
        }

        // Get the size of the GenericStack
        private int size() {
            int size = 0;
            for (Node<T> node = this.top; node != null; node = node.getNext()) {
                size++;
            }
            return size;
        }

        private class Node<T> {
            // The object in the node
            private T object;
            // The next node
            private Node<T> next;

            // Constructor for a node
            public Node(T object, Node<T> next) {
                this.object = object;
                this.next = next;
            }

            // Get the object in the node
            public LorentzAttractorPlotter.Point getObject() {
                return object;
            }

            // Get the next node
            public Node<T> getNext() {
                return next;
            }
        }
    }

    // A class for a plot
    private static class Plot {
        // The title of the plot
        private String title;
        // The x axis label
        private String xLabel;
        // The y axis label
        private String yLabel;
        // The x coordinates of the points
        private double[] x;
        // The y coordinates of the points
        private double[] y;

        // Constructor for a plot
        public Plot(String title, String xLabel, String yLabel) {
            this.title = title;
            this.xLabel = xLabel;
            this.yLabel = yLabel;
            this.x = new double[0];
            this.y = new double[0];
        }

        // Add points to the plot
        public void addPoints(double[] x, double[] y) {
            // Check if the arrays are the same length
            if (x.length != y.length) {
                throw new IllegalArgumentException("Arrays must be the same length");
            }
            // Create new arrays with the new points
            double[] newX = new double[this.x.length + x.length];
            double[] newY = new double[this.y.length + y.length];
            // Copy the old points into the new arrays
            for (int i = 0; i < this.x.length; i++) {
                newX[i] = this.x[i];
                newY[i] = this.y[i];
            }
            // Copy the new points into the new arrays
            for (int i = 0; i < x.length; i++) {
                newX[i + this.x.length] = x[i];
                newY[i + this.y.length] = y[i];
            }
            // Set the new arrays
            this.x = newX;
            this.y = newY;
        }

        // Display the plot
        public void display() {
            // Create a new plot
            StdDraw.setCanvasSize(800, 800);
            StdDraw.setXscale(0, 1);
            StdDraw.setYscale(0, 1);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(new Color(0, 0, 0));
            StdDraw.text(0.5, 0.95, this.title);
            StdDraw.text(0.5, 0.05, this.xLabel);
            StdDraw.text(0.05, 0.5, this.yLabel);
            // Plot the points
            for (int i = 0; i < this.x.length; i++) {
                StdDraw.point(this.x[i], this.y[i]);
            }

            // Wait for the user to close the plot
            StdDraw.show();
            StdDraw.pause(100000);

            // Close the plot
            StdDraw.close();
        }
    }
    
    // A class for a standard draw
    private static class StdDraw {
        // Set the canvas size
        public static void setCanvasSize(int width, int height) {
            System.out.printf("Set canvas size to %d x %d\n", width, height);
        }

        // Set the x scale
        public static void setXscale(double min, double max) {
            System.out.printf("Set x scale to %f - %f\n", min, max);
        }

        // Set the y scale
        public static void setYscale(double min, double max) {
            System.out.printf("Set y scale to %f - %f\n", min, max);
        }

        // Set the pen radius
        public static void setPenRadius(double radius) {
            System.out.printf("Set pen radius to %f\n", radius);
        }

        // Set the pen color
        public static void setPenColor(Color color) {
            System.out.printf("Set pen color to %s\n", color);
        }

        // Draw a point
        public static void point(double x, double y) {
            System.out.printf("Draw point at (%f, %f)\n", x, y);
        }

        // Draw a line
        public static void line(double x1, double y1, double x2, double y2) {
            System.out.printf("Draw line from (%f, %f) to (%f, %f)\n", x1, y1, x2, y2);
        }

        // Draw a filled polygon
        public static void filledPolygon(double[] x, double[] y) {
            System.out.printf("Draw filled polygon with %d points\n", x.length);
        }

        // Draw a text string
        public static void text(double x, double y, String text) {
            System.out.printf("Draw text \"%s\" at (%f, %f)\n", text, x, y);
        }

        // Show the plot
        public static void show() {
            System.out.println("Show plot");
        }

        // Pause the plot
        public static void pause(int milliseconds) {
            System.out.printf("Pause plot for %d milliseconds\n", milliseconds);
        }

        // Close the plot
        public static void close() {
            System.out.println("Close plot");
        }
    }

    // A class for a color
    private static class Color {
        // The red value
        private int red;
        // The green value
        private int green;
        // The blue value
        private int blue;

        // Constructor for a color
        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        // Get the red value
        public int getRed() {
            return red;
        }

        // Get the green value
        public int getGreen() {
            return green;
        }

        // Get the blue value
        public int getBlue() {
            return blue;
        }

        // Get the color as a string
        public String toString() {
            return String.format("#%02x%02x%02x", this.red, this.green, this.blue);
        }
    }
}
