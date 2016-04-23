package co.dito.abako.abako.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtils {
	
	
	public static String compress(String string) throws IOException {
	    byte[] blockcopy = ByteBuffer
	        .allocate(4)
	        .order(java.nio.ByteOrder.LITTLE_ENDIAN)
	        .putInt(string.length())
	        .array();
	    ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());
	    GZIPOutputStream gos = new GZIPOutputStream(os);
	    gos.write(string.getBytes());
	    gos.close();
	    os.close();
	    byte[] compressed = new byte[4 + os.toByteArray().length];
	    System.arraycopy(blockcopy, 0, compressed, 0, 4);
	    System.arraycopy(os.toByteArray(), 0, compressed, 4, os.toByteArray().length);
	    String retorno= new String(Base64.encodeBytes(compressed));
	    return retorno;
	}
	

	public static String decompress(String zipText) throws IOException {
			int size = 0;
			byte[] gzipBuff = Base64.decode(zipText);
			ByteArrayInputStream memstream = new ByteArrayInputStream(gzipBuff, 4,gzipBuff.length - 4);
			GZIPInputStream gzin = new GZIPInputStream(memstream);
			final int buffSize = 8192;
			byte[] tempBuffer = new byte[buffSize];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((size = gzin.read(tempBuffer, 0, buffSize)) != -1) {
				baos.write(tempBuffer, 0, size);
			}
			byte[] buffer = baos.toByteArray();
			baos.close();
			return new String(buffer, "UTF-8"); 
		}
}
