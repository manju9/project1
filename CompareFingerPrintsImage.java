import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
 
public class CompareFingerPrintsImage 
{
 
    static void processImage()
    {
        String file1 = "D:\\stock-vector-fingerprint-vector-187341962.jpg";
        String file2 = "D:\\stock-vector-fingerprint-vector-187341962.jpg";
        
        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
 
        try 
        {    
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
 
            int[] data1 = null;
 
            if (grab1.grabPixels()) 
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }
 
            int[] data2 = null;
 
            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }
 
            if(java.util.Arrays.equals(data1, data2))
            {
            	System.out.println(file1);
            	System.out.println(file2);
            	System.out.println("Finger Prints images are Equal");
            }
            else 
            {
            	System.out.println(file1);
            	System.out.println(file2);
            	
            	System.out.println("Finger Prints Images are not Equal");
            }
            //System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
 
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
 
    public static void main(String args[]) {
        processImage();
    }
}