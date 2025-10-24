package com.clay.gl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class GL {

    private static String title = "Untitled";
    private static int x = 0;
    private static int y = 0;
    private static int width = 640;
    private static int height = 480;
    private static double scalex = 1.2;
    private static double scaley = 1.2;
    private static boolean available = false;

    private static JFrame frame;
    private static Canvas canvas;
    private static BufferStrategy bufferstrategy;
    private static Graphics2D graphics2d;
    private static Color backgroundcolor = Color.BLACK;
    private static Color strokecolor = Color.WHITE;
    private static Color fillcolor = Color.WHITE;
    private static float strokewidth = 1.0f;
    private static boolean filled = false;
    private static boolean antialias = true;

    private static String fontname = "Monospaced";
    private static int fontstyle = Font.PLAIN;
    private static int fontsize = 12;

    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int TRANSPARENT = 0x00000000;
    public static final int YELLOW = 0xFFFFFF00;
    public static final int CYAN = 0xFF00FFFF;
    public static final int MAGENTA = 0xFFFF00FF;
    public static final int GRAY = 0xFF808080;
    public static final int SILVER = 0xFFC0C0C0;
    public static final int MAROON = 0xFF800000;
    public static final int OLIVE = 0xFF808000;
    public static final int LIME = 0xFF00FF00;
    public static final int TEAL = 0xFF008080;
    public static final int NAVY = 0xFF000080;
    public static final int PURPLE = 0xFF800080;
    public static final int ORANGE = 0xFFFFA500;

    public static final int KEY_ENTER = KeyEvent.VK_ENTER;
    public static final int KEY_BACK_SPACE = KeyEvent.VK_BACK_SPACE;
    public static final int KEY_TAB = KeyEvent.VK_TAB;
    public static final int KEY_CANCEL = KeyEvent.VK_CANCEL;
    public static final int KEY_CLEAR = KeyEvent.VK_CLEAR;
    public static final int KEY_SHIFT = KeyEvent.VK_SHIFT;
    public static final int KEY_CONTROL = KeyEvent.VK_CONTROL;
    public static final int KEY_ALT = KeyEvent.VK_ALT;
    public static final int KEY_PAUSE = KeyEvent.VK_PAUSE;
    public static final int KEY_CAPS_LOCK = KeyEvent.VK_CAPS_LOCK;
    public static final int KEY_ESCAPE = KeyEvent.VK_ESCAPE;
    public static final int KEY_SPACE = KeyEvent.VK_SPACE;
    public static final int KEY_PAGE_UP = KeyEvent.VK_PAGE_UP;
    public static final int KEY_PAGE_DOWN = KeyEvent.VK_PAGE_DOWN;
    public static final int KEY_END = KeyEvent.VK_END;
    public static final int KEY_HOME = KeyEvent.VK_HOME;
    public static final int KEY_LEFT = KeyEvent.VK_LEFT;
    public static final int KEY_UP = KeyEvent.VK_UP;
    public static final int KEY_RIGHT = KeyEvent.VK_RIGHT;
    public static final int KEY_DOWN = KeyEvent.VK_DOWN;
    public static final int KEY_COMMA = KeyEvent.VK_COMMA;
    public static final int KEY_MINUS = KeyEvent.VK_MINUS;
    public static final int KEY_PERIOD = KeyEvent.VK_PERIOD;
    public static final int KEY_SLASH = KeyEvent.VK_SLASH;
    public static final int KEY_0 = KeyEvent.VK_0;
    public static final int KEY_1 = KeyEvent.VK_1;
    public static final int KEY_2 = KeyEvent.VK_2;
    public static final int KEY_3 = KeyEvent.VK_3;
    public static final int KEY_4 = KeyEvent.VK_4;
    public static final int KEY_5 = KeyEvent.VK_5;
    public static final int KEY_6 = KeyEvent.VK_6;
    public static final int KEY_7 = KeyEvent.VK_7;
    public static final int KEY_8 = KeyEvent.VK_8;
    public static final int VK_9 = KeyEvent.VK_9;
    public static final int KEY_SEMICOLON = KeyEvent.VK_SEMICOLON;
    public static final int KEY_A = KeyEvent.VK_A;
    public static final int KEY_B = KeyEvent.VK_B;
    public static final int KEY_C = KeyEvent.VK_C;
    public static final int KEY_D = KeyEvent.VK_D;
    public static final int KEY_E = KeyEvent.VK_E;
    public static final int KEY_F = KeyEvent.VK_F;
    public static final int KEY_G = KeyEvent.VK_G;
    public static final int KEY_H = KeyEvent.VK_H;
    public static final int KEY_I = KeyEvent.VK_I;
    public static final int KEY_J = KeyEvent.VK_J;
    public static final int KEY_K = KeyEvent.VK_K;
    public static final int KEY_L = KeyEvent.VK_L;
    public static final int KEY_M = KeyEvent.VK_M;
    public static final int KEY_N = KeyEvent.VK_N;
    public static final int KEY_O = KeyEvent.VK_O;
    public static final int KEY_P = KeyEvent.VK_P;
    public static final int KEY_Q = KeyEvent.VK_Q;
    public static final int KEY_R = KeyEvent.VK_R;
    public static final int KEY_S = KeyEvent.VK_S;
    public static final int KEY_T = KeyEvent.VK_T;
    public static final int KEY_U = KeyEvent.VK_U;
    public static final int KEY_V = KeyEvent.VK_V;
    public static final int KEY_W = KeyEvent.VK_W;
    public static final int KEY_X = KeyEvent.VK_X;
    public static final int KEY_Y = KeyEvent.VK_Y;
    public static final int KEY_Z = KeyEvent.VK_Z;
    public static final int KEY_OPEN_BRACKET = KeyEvent.VK_OPEN_BRACKET;
    public static final int KEY_BACK_SLASH = KeyEvent.VK_BACK_SLASH;
    public static final int KEY_CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;
    public static final int KEY_NUMPAD0 = KeyEvent.VK_NUMPAD0;
    public static final int KEY_NUMPAD1 = KeyEvent.VK_NUMPAD1;
    public static final int KEY_NUMPAD2 = KeyEvent.VK_NUMPAD2;
    public static final int KEY_NUMPAD3 = KeyEvent.VK_NUMPAD3;
    public static final int KEY_NUMPAD4 = KeyEvent.VK_NUMPAD4;
    public static final int KEY_NUMPAD5 = KeyEvent.VK_NUMPAD5;
    public static final int KEY_NUMPAD6 = KeyEvent.VK_NUMPAD6;
    public static final int KEY_NUMPAD7 = KeyEvent.VK_NUMPAD7;
    public static final int KEY_NUMPAD8 = KeyEvent.VK_NUMPAD8;
    public static final int KEY_NUMPAD9 = KeyEvent.VK_NUMPAD9;
    public static final int KEY_MULTIPLY = KeyEvent.VK_MULTIPLY;
    public static final int KEY_ADD = KeyEvent.VK_ADD;
    public static final int KEY_SEPARATER = KeyEvent.VK_SEPARATER;
    public static final int KEY_SEPARATOR = KeyEvent.VK_SEPARATOR;
    public static final int KEY_SUBTRACT = KeyEvent.VK_SUBTRACT;
    public static final int KEY_DECIMAL = KeyEvent.VK_DECIMAL;
    public static final int KEY_DIVIDE = KeyEvent.VK_DIVIDE;
    public static final int KEY_DELETE = KeyEvent.VK_DELETE;
    public static final int KEY_NUM_LOCK = KeyEvent.VK_NUM_LOCK;
    public static final int KEY_SCROLL_LOCK = KeyEvent.VK_SCROLL_LOCK;
    public static final int KEY_F1 = KeyEvent.VK_F1;
    public static final int KEY_F2 = KeyEvent.VK_F2;
    public static final int KEY_F3 = KeyEvent.VK_F3;
    public static final int KEY_F4 = KeyEvent.VK_F4;
    public static final int KEY_F5 = KeyEvent.VK_F5;
    public static final int KEY_F6 = KeyEvent.VK_F6;
    public static final int KEY_F7 = KeyEvent.VK_F7;
    public static final int KEY_F8 = KeyEvent.VK_F8;
    public static final int KEY_F9 = KeyEvent.VK_F9;
    public static final int KEY_F10 = KeyEvent.VK_F10;
    public static final int KEY_F11 = KeyEvent.VK_F11;
    public static final int KEY_F12 = KeyEvent.VK_F12;
    public static final int KEY_F13 = KeyEvent.VK_F13;
    public static final int KEY_F14 = KeyEvent.VK_F14;
    public static final int KEY_F15 = KeyEvent.VK_F15;
    public static final int KEY_F16 = KeyEvent.VK_F16;
    public static final int KEY_F17 = KeyEvent.VK_F17;
    public static final int KEY_F18 = KeyEvent.VK_F18;
    public static final int KEY_F19 = KeyEvent.VK_F19;
    public static final int KEY_F20 = KeyEvent.VK_F20;
    public static final int KEY_F21 = KeyEvent.VK_F21;
    public static final int KEY_F22 = KeyEvent.VK_F22;
    public static final int KEY_F23 = KeyEvent.VK_F23;
    public static final int KEY_F24 = KeyEvent.VK_F24;
    public static final int KEY_PRINTSCREEN = KeyEvent.VK_PRINTSCREEN;
    public static final int KEY_INSERT = KeyEvent.VK_INSERT;
    public static final int KEY_HELP = KeyEvent.VK_HELP;
    public static final int KEY_META = KeyEvent.VK_META;
    public static final int KEY_BACK_QUOTE = KeyEvent.VK_BACK_QUOTE;
    public static final int KEY_QUOTE = KeyEvent.VK_QUOTE;
    public static final int KEY_KP_UP = KeyEvent.VK_KP_UP;
    public static final int KEY_KP_DOWN = KeyEvent.VK_KP_DOWN;
    public static final int KEY_KP_LEFT = KeyEvent.VK_KP_LEFT;
    public static final int KEY_KP_RIGHT = KeyEvent.VK_KP_RIGHT;
    public static final int KEY_AT = KeyEvent.VK_AT;
    public static final int KEY_COLON = KeyEvent.VK_COLON;
    public static final int KEY_CIRCUMFLEX = KeyEvent.VK_CIRCUMFLEX;
    public static final int KEY_DOLLAR = KeyEvent.VK_DOLLAR;
    public static final int KEY_EURO_SIGN = KeyEvent.VK_EURO_SIGN;
    public static final int KEY_EXCLAMATION_MARK = KeyEvent.VK_EXCLAMATION_MARK;
    public static final int KEY_INVERTED_EXCLAMATION_MARK = KeyEvent.VK_INVERTED_EXCLAMATION_MARK;
    public static final int KEY_LEFT_PARENTHESIS = KeyEvent.VK_LEFT_PARENTHESIS;
    public static final int KEY_RIGH_PARENTHESIS = KeyEvent.VK_RIGHT_PARENTHESIS;
    public static final int KEY_NUMBER_SIGN = KeyEvent.VK_NUMBER_SIGN;
    public static final int KEY_PLUS = KeyEvent.VK_PLUS;
    public static final int KEY_UNDERSCORE = KeyEvent.VK_UNDERSCORE;
    public static final int KEY_WINDOWS = KeyEvent.VK_WINDOWS;
    public static final int KEY_CONTEXT_MENU = KeyEvent.VK_CONTEXT_MENU;
    public static final int KEY_FINAL = KeyEvent.VK_FINAL;
    public static final int KEY_CONVERT = KeyEvent.VK_CONVERT;
    public static final int KEY_NONCONVERT = KeyEvent.VK_NONCONVERT;
    public static final int KEY_ACCEPT = KeyEvent.VK_ACCEPT;
    public static final int KEY_MODECHANGE = KeyEvent.VK_MODECHANGE;
    public static final int KEY_KANA = KeyEvent.VK_KANA;
    public static final int KEY_KANJI = KeyEvent.VK_KANJI;
    public static final int KEY_ALPHANUMERIC = KeyEvent.VK_ALPHANUMERIC;
    public static final int KEY_CUT = KeyEvent.VK_CUT;
    public static final int KEY_COPY = KeyEvent.VK_COPY;
    public static final int KEY_PASTE = KeyEvent.VK_PASTE;
    public static final int KEY_UNDO = KeyEvent.VK_UNDO;
    public static final int KEY_AGAIN = KeyEvent.VK_AGAIN;
    public static final int KEY_FIND = KeyEvent.VK_FIND;
    public static final int KEY_PROPS = KeyEvent.VK_PROPS;
    public static final int KEY_STOP = KeyEvent.VK_STOP;
    public static final int KEY_COMPOSE = KeyEvent.VK_COMPOSE;
    public static final int KEY_ALT_GRAPH = KeyEvent.VK_ALT_GRAPH;
    public static final int KEY_BEGIN = KeyEvent.VK_BEGIN;
    public static final int KEY_UNDEFINED = KeyEvent.VK_UNDEFINED;

    public static final String MONOSPACED = Font.MONOSPACED;
    public static final String DIALOG = Font.DIALOG;
    public static final String DIALOG_INPUT = Font.DIALOG_INPUT;
    public static final String SANS_SERIF = Font.SANS_SERIF;
    public static final String SERIF = Font.SERIF;

    public static final int PLAIN = Font.PLAIN;
    public static final int BOLD = Font.BOLD;
    public static final int ITALIC = Font.ITALIC;

    private static boolean[] keydown = new boolean[512];
    private static Set<Integer> keypressed = new HashSet<>();
    private static Set<Integer> keyreleased = new HashSet<>();
    private static volatile char lastchar = '\0';

    public static final int MOUSE_BUTTON_LEFT = MouseEvent.BUTTON1;
    public static final int MOUSE_BUTTON_MIDDLE = MouseEvent.BUTTON2;
    public static final int MOUSE_BUTTON_RIGHT = MouseEvent.BUTTON3;

    private static volatile int mousex = 0;
    private static volatile int mousey = 0;
    private static boolean[] mousedown = new boolean[8];
    private static Set<Integer> mousepressed = new HashSet<>();
    private static Set<Integer> mousereleased = new HashSet<>();
    private static int mousewheelrotation = 0;
    private static int mousescrollwheelrotation = 0;

    /*
    private static String modifyName = "name";
    private static String modifyType = "type";
    private static String modifyValues = "values";
    private static ArrayList<String> modifyData = new ArrayList<String>(); // [name], [type], [values]
     */

    public static void initgraph() {
        window();
    }

    public static void initgraph(String title) {
        GL.title = title;
        window();
    }

    public static void initgraph(String title, int width, int height) {
        GL.title = title;
        GL.width = width;
        GL.height = height;
        window();
    }

    public static void initgraph(String title, int x, int y, int width, int height) {
        GL.title = title;
        GL.x = x;
        GL.y = y;
        GL.width = width;
        GL.height = height;
        window();
    }

    private static void window() {
        frame = new JFrame(title);
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                lastchar = e.getKeyChar();
                int code = e.getKeyCode() & 0xFF;
                if (!keydown[code]) keypressed.add(code);
                keydown[code] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                lastchar = '\0';
                int code = e.getKeyCode() & 0xFF;
                keydown[code] = false;
                keyreleased.add(code);
            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                int b = e.getButton();
                if (b >= 0 && b < mousedown.length) {
                    if (!mousedown[b]) mousepressed.add(b);
                    mousedown[b] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int b = e.getButton();
                if (b >= 0 && b < mousedown.length) {
                    mousedown[b] = false;
                    mousereleased.add(b);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mousex = e.getX();
                mousey = e.getY();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mousex = e.getX();
                mousey = e.getY();
            }
        });

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousex = e.getX();
                mousey = e.getY();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mousex = e.getX();
                mousey = e.getY();
            }
        });

        canvas.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                mousewheelrotation = e.getWheelRotation();
                mousescrollwheelrotation += mousewheelrotation;
            }
        });

        canvas.setFocusable(true);

        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();

        frame.setLocation(x, y);
        frame.setVisible(true);

    }

    private static void createbuffer() {
        canvas.createBufferStrategy(3);
        bufferstrategy = canvas.getBufferStrategy();
    }

    private static Graphics2D getGraphics2d() {
        if (bufferstrategy == null) createbuffer();
        Graphics2D g2d = (Graphics2D) bufferstrategy.getDrawGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        return g2d;
    }

    public static int getwidth() {
        return width;
    }

    public static int getheight() {
        return height;
    }

    public static void setscale(double scale) {
        GL.scalex = scale;
        GL.scaley = scale;
    }

    public static void setscale(double sx, double sy) {
        GL.scalex = sx;
        GL.scaley = sy;
    }

    public static void setbackgroundcolor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        if (alpha == 0x00) backgroundcolor = new Color(0xFF000000 | color);
        else backgroundcolor = new Color(color);
    }

    public static void setbackgroundcolor(int red, int green, int blue) {
        backgroundcolor = new Color(red, green, blue);
    }

    public static void setbackgroundcolor(String value) {
        Color color = colorvalue(value);
        if (color == null) color = new Color(0, 0, 0);
        backgroundcolor = color;
    }

    public static void cleargraph() {
        graphics2d = getGraphics2d();
        graphics2d.setColor(backgroundcolor);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public static void refreshgraph() {
        if (bufferstrategy != null) {
            graphics2d.dispose();
            bufferstrategy.show();
            Toolkit.getDefaultToolkit().sync();
        }
    }

    public static void closegraph() {
        try {
            if (frame != null) {
                frame.setVisible(false);
                frame.dispose();
                System.exit(0);
            }
        } finally {
            frame = null;
            canvas = null;
        }
    }

    public static boolean isavailablegraph() {
        if (frame == null) return false;
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {}
        return frame.isVisible();
    }

    /*
    public static void modify(String name, String type, String values) {
        GL.modifyName = name;
        GL.modifyType = type;
        GL.modifyValues = values;
        GL.modifyData.add("[" + name + "], [" + type + "], [" + values + "]");
    }
     */

    public static void setstrokewidth(float stroke) {
        GL.strokewidth = stroke;
        graphics2d.setStroke(new BasicStroke(stroke));
    }

    public static void setfilled(boolean filled) {
        GL.filled = filled;
    }

    public static void setantialias(boolean antialias) {
        GL.antialias = antialias;
        if (antialias) {
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        } else {
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
    }

    public static void setcolor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = color & 0xFF;
        if (alpha == 0x00) {
            strokecolor = new Color(red, green, blue, 255);
            fillcolor = new Color(red, green, blue, 255);
        } else {
            strokecolor = new Color(color);
            fillcolor = new Color(color);
        }
    }

    public static void setcolor(int red, int green, int blue) {
        strokecolor = new Color(red, green, blue);
        fillcolor = new Color(red, green, blue);
    }

    public static void setcolor(int alpha, int red, int green, int blue) {
        strokecolor = new Color(red, green, blue, alpha);
        fillcolor = new Color(red, green, blue, alpha);
    }

    public static void setcolor(String value) {
        Color color = colorvalue(value);
        if (color == null) color = new Color(0, 0, 0);
        strokecolor = color;
        fillcolor = color;
    }

    public static void setstrokecolor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = color & 0xFF;
        if (alpha == 0x00) strokecolor = new Color(red, green, blue, 255);
        else strokecolor = new Color(red, green, blue, alpha);
    }

    public static void setstrokecolor(int red, int green, int blue) {
        strokecolor = new Color(red, green, blue);
    }

    public static void setstrokecolor(int alpha, int red, int green, int blue) {
        strokecolor = new Color(red, green, blue, alpha);
    }

    public static void setstrokecolor(String value) {
        Color color = colorvalue(value);
        if (color == null) color = new Color(0, 0, 0);
        strokecolor = color;
    }

    public static void setfillcolor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = color & 0xFF;
        if (alpha == 0x00) fillcolor = new Color(red, green, blue, 255);
        else fillcolor = new Color(red, green, blue, alpha);
    }

    public static void setfillcolor(int red, int green, int blue) {
        fillcolor = new Color(red, green, blue);
    }

    public static void setfillcolor(int alpha, int red, int green, int blue) {
        fillcolor = new Color(red, green, blue, alpha);
    }

    public static void setfillcolor(String value) {
        Color color = colorvalue(value);
        if (color == null) color = new Color(0, 0, 0);
        fillcolor = color;
    }

    private static Color colorvalue(String value) {
        value = value.trim().toLowerCase();
        if (value.startsWith("#")) {
            value = value.substring(1);
            if (value.length() == 6) return new Color(0xFF000000 | Integer.parseInt(value, 16));
            else if (value.length() == 8) return new Color((int) Long.parseLong(value, 16));
        } else if (value.startsWith("0x")) {
            value = value.substring(2);
            if (value.length() == 6) return new Color(0xFF000000 | Integer.parseInt(value, 16));
            else if (value.length() == 8) return new Color((int) Long.parseLong(value, 16));
        }
        return null;
    }

    public static void settextfont(String name) {
        GL.fontname = name;
    }

    public static void settextstyle(int style) {
        GL.fontstyle = style;
    }

    public static void settextsize(int size) {
        GL.fontsize = size;
    }

    public static void pixel(int x, int y) {
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Line2D.Float(x, y, x, y));
    }

    public static void line(int x1, int y1, int x2, int y2) {
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    public static void circle(int x, int y, int radius) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Ellipse2D.Float(x, y, radius, radius));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Ellipse2D.Float(x, y, radius, radius));
    }

    public static void arc(int x, int y, int width, int height, int start, int sweep) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Arc2D.Float(x, y, width, height, start, sweep, Arc2D.PIE));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Arc2D.Float(x, y, width, height, start, sweep, Arc2D.PIE));
    }

    public static void arc(int x, int y, int radius, int start, int sweep) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Arc2D.Float(x, y, radius, radius, start, sweep, Arc2D.PIE));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Arc2D.Float(x, y, radius, radius, start, sweep, Arc2D.PIE));
    }

    public static void rectangle(int x, int y, int width, int height) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Rectangle2D.Float(x, y, width, height));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Rectangle2D.Float(x, y, width, height));
    }

    public static void square(int x, int y, int size) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Rectangle2D.Float(x, y, size, size));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Rectangle2D.Float(x, y, size, size));
    }

    public static void ellipse(int x, int y, int width, int height) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Ellipse2D.Float(x, y, width, height));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Ellipse2D.Float(x, y, width, height));
    }

    public static void ellipse(int x, int y, int radius) {
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Ellipse2D.Float(x, y, radius, radius));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Ellipse2D.Float(x, y, radius, radius));
    }

    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        int[] xpoints = {x1, x2, x3};
        int[] ypoints = {y1, y2, y3};
        int numpoint = xpoints.length;
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Polygon(xpoints, ypoints, numpoint));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Polygon(xpoints, ypoints, numpoint));
    }

    public static void polygon(int[] xpoints, int[] ypoints) {
        if (xpoints.length != ypoints.length) return;
        int numpoint = xpoints.length;
        if (filled) {
            graphics2d.setColor(fillcolor);
            graphics2d.fill(new Polygon(xpoints, ypoints, numpoint));
        }
        graphics2d.setColor(strokecolor);
        graphics2d.draw(new Polygon(xpoints, ypoints, numpoint));
    }

    public static void polyline(int[] xpoints, int[] ypoints) {
        if (xpoints.length != ypoints.length) return;
        int numpoint = xpoints.length;
        graphics2d.setColor(strokecolor);
        graphics2d.drawPolyline(xpoints, ypoints, numpoint);
    }

    public static void text(String text, int x, int y) {
        Font fonttext = new Font(fontname, fontstyle, fontsize);
        graphics2d.setFont(fonttext);
        FontMetrics fm = graphics2d.getFontMetrics();
        graphics2d.setColor(strokecolor);
        graphics2d.drawString(text, x, (y + fm.getAscent()));
    }

    public static void image(String res, int x, int y) {
        if (!new File(res).exists()) return;
        ImageIcon image = new ImageIcon(res);
        graphics2d.drawImage(image.getImage(), x, y, null);
    }

    public static void image(String res, int x, int y, int width, int height) {
        if (!new File(res).exists()) return;
        ImageIcon image = new ImageIcon(res);
        graphics2d.drawImage(image.getImage(), x, y, width, height, null);
    }

    public static boolean iskey(char key) {
        return iskey((int) key);
    }

    public static boolean iskey(int code) {
        return keydown[code & 0xFF];
    }

    public static boolean iskb() {
        for (boolean kd : keydown) if (kd) return true;
        if (!keypressed.isEmpty() || !keyreleased.isEmpty()) return true;
        return false;
    }

    public static char getch() {
        char c = lastchar;
        return c;
    }

    public static boolean ismousebutton(int button) {
        return (button >= 0 && button < mousedown.length) && mousedown[button];
    }

    public static int getmousex() {
        return mousex;
    }

    public static int getmousey() {
        return mousey;
    }

    public static int getmousescrollwheel() {
        return mousescrollwheelrotation;
    }

}
