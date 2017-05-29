package com.gs.reusebook.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 生成验证码图片
 * 
 * @author 丁修正 from red_maple_final
 *
 */
public class SecurityImageGenerate {

	public static BufferedImage createImage(String securityCode) {

		int codeLength = securityCode.length();
		int fSize = 15;
		int fWidth = fSize + 1;
		int width = codeLength * fWidth + 6;
		int height = fSize * 2 + 1;

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, height - 2));
		g.drawRect(0, 0, width - 1, height - 1);

		Random rand = new Random();
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < codeLength * 6; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			g.drawRect(x, y, 1, 1);
		}

		int codeY = height - 10;
		g.setColor(new Color(19, 148, 246));
		g.setFont(new Font("Georgia", Font.BOLD, fSize));
		for (int i = 0; i < codeLength; i++) {
			g.drawString(String.valueOf(securityCode.charAt(i)), i * 16 + 5,
					codeY);
		}
		g.dispose();
		return image;
	}

	public static ByteArrayInputStream getImageAsInputStream(String securityCode) {
		BufferedImage image = createImage(securityCode);
		return convertImageToStream(image);
	}

	private static ByteArrayInputStream convertImageToStream(BufferedImage image) {

		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
		try {
			jpeg.encode(image);
			byte[] bts = bos.toByteArray();
			inputStream = new ByteArrayInputStream(bts);
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputStream;
	}
}
