import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class test {
    private static PDDocument pdDocument;
	private static FileInputStream fileInputStream;
	public static void main(String[] args) {
        String string = null;
        try {
            fileInputStream = new FileInputStream("sample.pdf");
			PDFParser pdfParser = new PDFParser(fileInputStream);
            pdfParser.parse();
            pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(string);
    }
}