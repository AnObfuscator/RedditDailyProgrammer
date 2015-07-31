package c225.intermediate;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class EstimatePiExamples
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Loading Image1");
        String image1Path = "/Users/jona8276/Projects/RedditDailyProgrammer/src/main/resources/c225/input1.png";
        BufferedImage image1 = ImageIO.read(new File(image1Path));
        double estimate1 = EstimatePi.from(image1);
        System.out.println("Estimate 1: "+estimate1);

        System.out.println("Loading Image2");
        String image2Path = "/Users/jona8276/Projects/RedditDailyProgrammer/src/main/resources/c225/input2.png";
        BufferedImage image2 = ImageIO.read(new File(image2Path));
        double estimate2 = EstimatePi.from(image2);
        System.out.println("Estimate 2: "+estimate2);
    }
}
