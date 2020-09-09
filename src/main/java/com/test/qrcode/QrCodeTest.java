package com.test.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class QrCodeTest {

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}

		return image;
	}

	public static String createBuffer(String content) {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		String binary = null;

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
			// 实现二：生成二维码图片并将图片转为二进制传递给前台
			// 1、读取文件转换为字节数组
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedImage image = toBufferedImage(bitMatrix);
			////
			ImageIO.write(image, "png", out);
			byte[] bytes = out.toByteArray();

			// 2、将字节数组转为二进制
			BASE64Encoder encoder = new BASE64Encoder();
			binary = encoder.encodeBuffer(bytes).trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(binary);
		return binary;
	}

	public static void main(String[] args) {
		try {
			String content = "test";
			String buffer = createBuffer(content);
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes1 = decoder.decodeBuffer(buffer);

			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
			BufferedImage bi1 = ImageIO.read(bais);
			File w2 = new File("D://meinv.png");// 可以是jpg,png格式
			ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
