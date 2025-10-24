package test;

import com.clay.gl.GL; // guna perpustakaan kamu

public class DemoGL {
    public static void main(String[] args) {
        // Inisialisasi tetingkap grafik
        GL.initgraph("Demo GL Shapes", 800, 600);
        GL.setstrokecolor(GL.WHITE);
        GL.setfillcolor(GL.GRAY);

        // Gelung utama program
        while (GL.isavailablegraph()) {
            // Bersihkan skrin
            GL.cleargraph();

            // Contoh: Bulatan
            GL.setstrokecolor(GL.YELLOW);
            GL.setfillcolor(GL.ORANGE);
            GL.setfilled(true);
            GL.circle(100, 100, 50);

            // Contoh: Segi empat
            GL.setstrokecolor(GL.GREEN);
            GL.setfillcolor(GL.BLUE);
            GL.setfilled(true);
            GL.rectangle(200, 70, 100, 60);

            // Contoh: Garis
            GL.setstrokecolor(GL.CYAN);
            GL.line(50, 250, 300, 250);

            // Contoh: Segitiga
            GL.setstrokecolor(GL.RED);
            GL.setfillcolor(GL.PINK);
            GL.setfilled(true);
            GL.triangle(400, 200, 450, 100, 500, 200);

            // Contoh: Teks
            GL.setstrokecolor(GL.WHITE);
            GL.text("Demo Perpustakaan GL by Clay", 50, 350);

            // Papar grafik ke skrin
            GL.refreshgraph();
        }

        GL.closegraph();
    }

}

