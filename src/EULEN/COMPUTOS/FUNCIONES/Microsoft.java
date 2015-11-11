/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.FUNCIONES;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 *
 * @author jmsanchez
 */
public class Microsoft {

private void leerFicheroExcel(String fileName){
   List cellDataList = new ArrayList();
   try {
    FileInputStream fileInputStream = new FileInputStream(fileName);
    POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
    HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
    HSSFSheet hssfSheet = workBook.getSheetAt(0);
    Iterator rowIterator = hssfSheet.rowIterator();
    while (rowIterator.hasNext()){
        HSSFRow hssfRow = (HSSFRow) rowIterator.next();
        Iterator iterator = hssfRow.cellIterator();
        List cellTempList = new ArrayList();
        while (iterator.hasNext()){
            HSSFCell hssfCell = (HSSFCell) iterator.next();
            cellTempList.add(hssfCell);
        }
    cellDataList.add(cellTempList);
    }
   }
   catch (Exception e) {
     e.printStackTrace();
   }
   imprimirDatos(cellDataList);
}
private void imprimirDatos(List cellDataList){
   for (int i = 0; i < cellDataList.size(); i++) {
       List cellTempList = (List) cellDataList.get(i);
       for (int j = 0; j < cellTempList.size(); j++){
           HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
           String stringCellValue = hssfCell.toString();
           System.out.print(stringCellValue + "\t");
       }
       System.out.println();
   }
}
}

