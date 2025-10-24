package test;

import static com.clay.gl.GL.*;

public class InitGraph {
    public static void main(String[] args) {

        initgraph();

        while (isavailablegraph()) {
            cleargraph();

            refreshgraph();
        }

        closegraph();
      
    }
}
