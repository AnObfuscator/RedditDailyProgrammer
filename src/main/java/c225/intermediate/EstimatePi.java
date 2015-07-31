package c225.intermediate;


import java.awt.image.BufferedImage;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3f0hzk/20150729_challenge_225_intermediate_estimating_pi/
 */
public class EstimatePi
{
    public static double from(BufferedImage imageOfCircle)
    {
        int area = 0;
        int diameter = 0;

        int width = imageOfCircle.getWidth();
        int height = imageOfCircle.getHeight();

        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                int pixelColor = imageOfCircle.getRGB(x, y);
                if (isNotWhite(pixelColor))
                {
                    area++;
                    
                    if (y < bottom)
                    {
                        bottom = y;
                    }
                    if (y > top)
                    {
                        top = y;
                    }
                }
            }
        }

        diameter = top - bottom;
        
        return calculateEstimate(area, diameter);
    }
    
    private static boolean isNotWhite(int pixelColor)
    {
        return pixelColor != -1;
    }
    
    private static double calculateEstimate(int area, int diameter)
    {
        double r = (double)diameter / 2;
        double r2 = r * r;

        return area / r2;
    }
    
    private enum Color
    {
        BLACK,
        WHITE
    }

}
