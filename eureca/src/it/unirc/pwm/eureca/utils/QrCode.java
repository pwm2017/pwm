package it.unirc.pwm.eureca.utils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QrCode
{
	public void generaQrCode(String nome,int id, String path)
	{
		ByteArrayOutputStream bout=QRCode.from(nome+"@"+id).withSize(150, 150).to(ImageType.PNG).stream();

		try {
			OutputStream out = new FileOutputStream(path);
			bout.writeTo(out);
			out.flush();
			out.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
