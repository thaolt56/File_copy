import java.io.File;

public class XoaFile {
	public static void XoaFile(File file) {
		if(file.isFile()) {
			file.delete();
			
		}else if(file.isDirectory()) {
			File[] mangCon = file.listFiles();
			for (File file2 : mangCon) {
				XoaFile(file2);
			}
			
			file.delete();
		}
	}
	public static void main(String[] args) {
		File f1 = new File("/Applications/Tài liệu/Java Core/XoaFile/f1");
		XoaFile(f1);
	}
}
