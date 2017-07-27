package resources;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.net.URL;
//import java.net.URLConnection;

import javax.imageio.ImageIO;

public class VerifyImage {
	
	public static String processImage(String image1,String image2)
	{
		try{
			
			//String file1="D:\\Avaya\\AboutAvaya.jpg";
			//String file2="http://www.avaya.com/usa/images/aboutavayaimage";
			//saveImage(file2);
			Image actual = Toolkit.getDefaultToolkit().getImage(image1);
			Image expected = Toolkit.getDefaultToolkit().getImage(image2);
			
			PixelGrabber grabActual = new PixelGrabber(actual, 0, 0, -1, -1, false);
			PixelGrabber grabExpected = new PixelGrabber(expected, 0, 0, -1, -1, false);
			
			int[] array1 = null;
			int[] array2 = null;
			if(grabActual.grabPixels())
			{
				int width = grabActual.getWidth();
				int height = grabActual.getHeight();
				System.out.println(width);
				System.out.println(height);
				array1 = new int[width*height];
				array1 = (int[])grabActual.getPixels();
			}
			if(grabExpected.grabPixels())
			{
				int width = grabExpected.getWidth();
				int height = grabExpected.getHeight();
				System.out.println(width);
				System.out.println(height);
				array2 = new int[width*height];
				array2 = (int[])grabExpected.getPixels();
			}
			if(java.util.Arrays.equals(array1, array2)){
				return "Pass";
			}else{
				return "Fail";
			}
			}
			
			catch(Throwable t)
			{
				return "Fail:"+t.getMessage();
			}
		
		
		
		
}
	
	
	public static void saveImage(String imageUrl) {
		try{
		URL url = new URL(imageUrl);
		String fileName = url.getFile();
		//String destName = "./figures" + fileName.substring(fileName.lastIndexOf("/"));
		//String destName = "D:/Avaya" + fileName.substring(fileName.lastIndexOf("/"))+".jpg";
		//System.out.println(destName);
		//URLConnection connection = url.openConnection();
		
		BufferedImage image = null;
		image = ImageIO.read(url);
		ImageIO.write(image, "jpg",new File("D:/Avaya" + fileName.substring(fileName.lastIndexOf("/"))+".jpg"));
		//image = ImageIO.read(url);
		//InputStream is = connection.getInputStream();
		/*OutputStream os = new FileOutputStream(destName);
		
		byte[] b = new byte[2048];
		int length;
	 
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
	 
		is.close();
		os.close();*/
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
