package fuzzing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Tools {

	public Tools() {
		// TODO Auto-generated constructor stub
	}

	public static void wait1Sec() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static File writeFile(String path, String input) {
		File f = createFile(path);
		return writeFile(f, input);

	}

	public static File writeFile(File f, String input) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(input);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

	public static File copyFile(File f, String path) {
		File nf = createFile(path);
		try {
			FileInputStream in = new FileInputStream(f);
			FileOutputStream os = new FileOutputStream(nf);
			int i;
			while ((i = in.read()) > 0) {
				os.write(i);
			}
			in.close();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nf;

	}

	public static String getString(File f) {
		String result = "";
		try {
			FileInputStream in = new FileInputStream(f);
			int i;
			while ((i = in.read()) > 0) {
				result += String.valueOf((char) (i));
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void deleteFile(File f) {
		f.delete();
	}

	public static void deleteFile(String path) {
		new File(path).delete();
	}

	public static File createFile(String path) {
		File f = new File(path);
		if (f.getParentFile() != null) {
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
		}
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	//
	public static int random(int min, int max) {
		return (int) (min + (Math.random() * (max - min)));
	}

	public static int random(int max) {
		return random(0, max);
	}

	public static String randomChar(char min, char max) {
		return String.valueOf((char) (random(min, max)));
	}

	public static String randomChar() {
		return String.valueOf((char) (random(32, 127)));
	}

}
