package general;

import javax.swing.JFrame;

import java.awt.*;
import java.util.HashMap;

import utilities.*;

public class Window extends JFrame implements Runnable
{
    private static Window window;
    
    private Image doubleBufferImage;
    private Graphics doubleBufferGraphics;

    private ML mouseListener;
    private KL keyListener;

    private GameNode currentScene;
    private HashMap<String, GameNode> scenes;

    public Window()
    {
        this.setSize((int)(Constants.SCREEN_WIDTH), (int)(Constants.SCREEN_HEIGHT));
        this.setTitle(Constants.TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.mouseListener = new ML();
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);

        this.keyListener = new KL();
        this.addKeyListener(keyListener);

        this.scenes = new HashMap<String, GameNode>();
        this.scenes.put("sample", new GameNode("sample"));

        this.currentScene = scenes.get(Constants.ROOT_SCENE);
        this.currentScene.start();
    }

    public static Window getWindow()
    {
        if (Window.window == null)
        {
            Window.window = new Window();
        }
        return Window.window;
    }

    public GameNode getCurrentScene()
    {
        return this.currentScene;
    }

    public int changeScene(String scene)
    {
        if (this.scenes.containsKey(scene))
        {
            this.currentScene = this.scenes.get(scene);
            this.currentScene.start();
            return 1;
        }
        return 0;
    }

    public ML getMouseListener()
    {
        return this.mouseListener;
    }

    public KL getKeyListener()
    {
        return this.keyListener;
    }

    public void renderOffScreen(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g2);
    }

    public void update(double dt)
    {
        currentScene.update(dt);
        draw(getGraphics());
    }

    public void draw(Graphics g)
    {
        if(doubleBufferImage == null)
        {
            doubleBufferImage = createImage(getWidth(), getHeight());
            doubleBufferGraphics  = doubleBufferImage.getGraphics();
        }
        renderOffScreen(doubleBufferGraphics);
        g.drawImage(doubleBufferImage, 0, 0, getWidth(), getHeight(), null);
    }

    public void run()
    {
        double lastFrameTime = 0.0;
        try
        {
            while(true)
            {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;
                update(deltaTime);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
