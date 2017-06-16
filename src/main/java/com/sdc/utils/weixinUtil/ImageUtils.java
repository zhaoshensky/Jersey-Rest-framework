package com.sdc.utils.weixinUtil;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 图片加水印
 * @author admin
 *
 */
public class ImageUtils {
	
	/**图片格式：JPG*/
	private static final String PICTRUE_FORMATE_JPG = "jpg";
	
	private ImageUtils(){}
	/**
	 * 添加图片水印
	 * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
	 * @param waterImg  水印图片路径，如：C://myPictrue//logo.png
	 * @param x 水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间
	 * @param y 水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间
	 * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 */
	public final static void pressImage(String targetImg, String waterImg, float alpha) {
			try {
				File file = new File(targetImg);
				Image image = ImageIO.read(file);
				int width = image.getWidth(null);
				int height = image.getHeight(null);
				BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = bufferedImage.createGraphics();
				g.drawImage(image, 0, 0, width, height, null);
			    Image waterImage = ImageIO.read(new File(waterImg));	// 水印文件
				int width_1 = waterImage.getWidth(null);
				int height_1 = waterImage.getHeight(null);
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				int x=width;
				int y=height;
				if(x < 0){
					x = x-width/10;
				}else{
					x = x-width_1-2;
				}
				if(y < 0){
					y = y-height/10;
				}else {
					y = y-height_1-2;
				}
				g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束
				g.dispose();
				ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	/**
	 * 添加图片水印
	 * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
	 * @param waterImg  水印图片路径，如：C://myPictrue//logo.png
	 * @param x 水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间
	 * @param y 水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间
	 * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 */
	public final static void pressImage(File targetImg, File waterImg, float alpha) {
			try {
				Image image = ImageIO.read(targetImg);
				int width = image.getWidth(null);
				int height = image.getHeight(null);
				BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = bufferedImage.createGraphics();
				g.drawImage(image, 0, 0, width, height, null);
			    Image waterImage = ImageIO.read(waterImg);	// 水印文件
				int width_1 = waterImage.getWidth(null);
				int height_1 = waterImage.getHeight(null);
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				int x=width;
				int y=height;
				if(x < 0){
					x = x-width/10;
				}else{
					x = x-width_1-2;
				}
				if(y < 0){
					y = y-height/10;
				}else {
					y = y-height_1-2;
				}
				g.drawImage(waterImage, x, y, width_1, height_1, null); // 水印文件结束
				g.dispose();
				ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, targetImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	

	public static void main(String[] args) throws IOException {
		pressImage("d:\\1419988976968048958.jpg", "d:\\water.png", 0.5f);
	}

}
