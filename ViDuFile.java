import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ViDuFile {
	
	public static void CoppyAll(File file1, File file2) {
		try {
			Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(file1.isDirectory()) {
			File[] mangCon = file1.listFiles();
			for (File file : mangCon) {
				File fileNew = new File(file2.getAbsoluteFile()+"/"+file.getName());
				CoppyAll(file, fileNew);
			}
		}
	}
	public static void main(String[] args) {
		File f1File =  new File("/Applications/Tài liệu/Java Core/File_Copy_Move/f1.txt");
		File f2File = new File("/Applications/Tài liệu/Java Core/File_Copy_Move/f2.txt");
		
		
		// doi ten thu muc
		try {
			Files.move(f1File.toPath(), f2File.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//di chuyen file thu muc
		File f3 = new File("/Applications/Tài liệu/Java Core/File_Copy_Move/folder/f2.txt");
		try {
			Files.move(f1File.toPath(), f3.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Copy file
		File file = new File("/Applications/Tài liệu/Java Core/File_Copy_Move/f1");
		File file_copy = new File("/Applications/Tài liệu/Java Core/File_Copy_Move/f1_copy");
		ViDuFile.CoppyAll(file, file_copy);
	}
}
