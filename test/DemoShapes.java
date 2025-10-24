package test;

import com.clay.gl.GL;

public class DemoShapes {
    public static void main(String[] args) {
        GL.initgraph("Demo Shape", 800, 600);

        while (GL.isavailablegraph()) {
            GL.cleargraph();

            GL.setcolor(GL.YELLOW);
            GL.circle(100, 100, 50);

            GL.setcolor(GL.RED);
            GL.rectangle(200, 100, 120, 60);

            GL.setcolor(GL.CYAN);
            GL.triangle(400, 200, 450, 100, 500, 200);

            GL.setcolor(GL.WHITE);
            GL.text("Hello Graphics!", 50, 300);

            GL.refreshgraph();
        }

        GL.closegraph();
    }
}
