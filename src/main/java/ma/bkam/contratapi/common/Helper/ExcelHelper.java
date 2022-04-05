package ma.bkam.contratapi.common.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ma.bkam.contratapi.dao.model.BorederexDePrixEntity;
import ma.bkam.contratapi.dao.model.CataloguePrixEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";



    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<CataloguePrixEntity> excelToCataloguePrix(InputStream is) {



        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(11);
            System.out.println(workbook.getSheetName(11));
            Iterator<Row> rows = sheet.iterator();
            rows.next();
            List<CataloguePrixEntity> catalogues = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();
                CataloguePrixEntity c = new CataloguePrixEntity();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    int cellIndex = currentCell.getColumnIndex();
                    switch (cellIndex) {
                        case 0:
                            c.setNature(currentCell.getStringCellValue());
                            break;
                        case 1:
                            c.setArticle(currentCell.getStringCellValue());
                            break;
                        case 2:

                            c.setCritere(currentCell.getStringCellValue());
                            break;
                        case 3:

                            c.setLimiteChargeBanque(currentCell.getStringCellValue());
                            break;
                        case 4:
                            c.setPrix((double) currentCell.getNumericCellValue());
                            break;
                        case 5:
                            c.setQuantite((int) currentCell.getNumericCellValue());
                            break;
                        case 6:
                            c.setNumeroContrat((long) currentCell.getNumericCellValue());
                            break;
                        case 7:
                            c.setZone(currentCell.getStringCellValue());

                            break;
                        default:
                            break;
                    }
                    catalogues.add(c);

                }
            }
            workbook.close();
            System.out.println(catalogues.size());
            return catalogues;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }

    }

    public static List<BorederexDePrixEntity> excelToBoredereuxDePrix(InputStream is) {



        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(10);
            System.out.println(workbook.getSheetName(10));
            Iterator<Row> rows = sheet.iterator();
            rows.next();
            List<BorederexDePrixEntity> boredereux = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();
                BorederexDePrixEntity c = new BorederexDePrixEntity();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    int cellIndex = currentCell.getColumnIndex();
                    switch (cellIndex) {
                        case 0:
                            c.setNumContrat((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            c.setBatiment(currentCell.getStringCellValue());
                            break;
                        case 2:

                            c.setLot(currentCell.getStringCellValue());
                            break;
                        case 3:

                            c.setFamilleEquipement(currentCell.getStringCellValue());
                            break;
                        case 4:
                            c.setQuantiteReel(currentCell.getStringCellValue());
                            break;
                        case 5:
                            c.setPuissance(currentCell.getStringCellValue());
                            break;
                        case 6:
                            c.setpU((long) currentCell.getNumericCellValue());

                            break;
                        default:
                            break;
                    }
                    boredereux.add(c);

                }
            }
            workbook.close();
            System.out.println(boredereux.size());
            return boredereux;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }

    }





}