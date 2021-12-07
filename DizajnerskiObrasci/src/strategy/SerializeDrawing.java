package strategy;

import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import mvc.DrawingFrame;

public class SerializeDrawing implements OptionChooser {

	private DrawingFrame frame;

	public SerializeDrawing(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void saveFile(File file) {
		BufferedImage imageBuffer = null;
		try {
			imageBuffer = new Robot().createScreenCapture(frame.getView().getBounds());
			frame.getView().paint(imageBuffer.createGraphics());
			ImageIO.write(imageBuffer,"jpeg", new File(file + ".jpeg"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void openFile(File file) {
		// TODO Auto-generated method stub

	}
}
