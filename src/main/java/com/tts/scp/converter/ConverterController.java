package com.tts.scp.converter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class ConverterController {


	@GetMapping(path = "/convertDoc", produces = MediaType.APPLICATION_PDF_VALUE)
	public void convertedDocument(@RequestParam(defaultValue = "true") boolean printResume,
			@RequestParam(defaultValue = "true") boolean printCoverLetter,
			@RequestParam(defaultValue = "true") boolean printAttachments, @RequestParam String applicationId, HttpServletResponse response) throws IOException, DocumentException {
				
		Document doc = new Document();
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph paragraph = new Paragraph();
		
		paragraph.add(new Paragraph("Hallo Welt"));
		paragraph.add(new Paragraph(" "));
		paragraph.add(new Paragraph("Hallo Welt 2"));
		paragraph.add(new Paragraph(" "));
		paragraph.add(new Paragraph("Hallo Welt 3"));
		doc.add(paragraph);
		doc.close();
				
//		PDDocument doc = new PDDocument();
//		PDPage page = new PDPage();
//		doc.addPage(page);
//		   final PDFont courierBoldFont = PDType1Font.TIMES_ROMAN;  
//		   final int fontSize = 12; 
//		final PDPageContentStream contentStream = new PDPageContentStream(doc, page);  
//	      contentStream.beginText();  
//	      contentStream.setFont(courierBoldFont, fontSize);  
//	      contentStream.setLeading(2.5);
//	      contentStream.newLineAtOffset(150, 750);  
//	      contentStream.showText("Hello PDFBox");
//	      contentStream.newLine();
//	      contentStream.showText("Hello PDFBox2");  
//	      contentStream.endText();  
//	      contentStream.close();  // Stream must be closed before saving document.  
//	      doc.save(response.getOutputStream());
//		  doc.close();
		


	}
}
