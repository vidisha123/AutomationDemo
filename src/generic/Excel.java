package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getCellValue(String path, String sheet, int r,int c)
	{
		String s=" ";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			s=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
		}
		return s;
	}
	public static int getRowCount(String path, String sheet)
	{
		int rc=0;
		try {
			Workbook wb1=WorkbookFactory.create(new FileInputStream(path));
			rc=wb1.getSheet(sheet).getLastRowNum();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
		}
		return rc;
	}

}

