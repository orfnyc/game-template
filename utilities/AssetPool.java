package utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class AssetPool 
{
    public static HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();

    public static BufferedImage getSprite(String file)
    {
        if (!AssetPool.sprites.containsKey(file))
        {
            try
            {
                InputStream is = AssetPool.class.getResourceAsStream("/" + file);
                AssetPool.sprites.put(file, ImageIO.read(is));
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return AssetPool.sprites.get(file);
    }
}
