import general.Window;

public class Main 
{
    public static void main(String[] args)
    {
        Window window = Window.getWindow();
        Thread mainThread = new Thread(window);
        mainThread.start();
    }
}
