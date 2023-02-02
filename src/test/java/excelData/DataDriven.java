package excelData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static void main(String[] args) throws IOException {


    }

    public ArrayList<String> getData(String testCase) throws IOException {
        ArrayList<String> array = new ArrayList<String>();
        //fileInputStream argument
        FileInputStream fis = new FileInputStream("C:\\Users\\hsnny\\workspace\\ExcelDrivenProject\\ExcelData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            //idetify the sheets which is testdata
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")){
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int count = 0;
                int column = 0;
                while (ce.hasNext()){
                    Cell value = ce.next();
                    //identify the which column is testcases
                    if (value.getStringCellValue().equalsIgnoreCase("testcases")){
                        column = count;
                    }
                    count++;
                }
                while (rows.hasNext()){
                    Row r = rows.next();
                    //find purchase row which is under the test cases column
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCase)){
                        Iterator<Cell> cv = r.cellIterator();
                        //get data from purchase column and feed into test
                        while (cv.hasNext()){
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING){
                                array.add(c.getStringCellValue());
                            }else {
                                array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return array;
    }
}
