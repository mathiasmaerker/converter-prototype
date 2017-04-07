package com.tts.scp.converter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.tts.scp.converter.config.HttpProviderConfig;


@RestController
public class ConverterController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConverterController.class);

	@Autowired @Lazy
	private HttpProviderConfig client;
	
	@GetMapping(path = "/convertDoc", produces = MediaType.APPLICATION_PDF_VALUE)
	public void convertedDocument(
			@RequestParam(defaultValue = "true") boolean printResume,
			@RequestParam(defaultValue = "true") boolean printCoverLetter,
			@RequestParam(defaultValue = "true") boolean printAttachments, 
			@RequestParam String applicationId,
			HttpServletResponse response) throws IOException, DocumentException {

		
		HttpResponse httpResponse = client.getClient();
		logger.info("HTTP RESPONSE STATUS IS: " + httpResponse.getStatusLine());
		
		
//		Document doc = new Document();
//		PdfWriter.getInstance(doc, response.getOutputStream());
//		doc.open();
//		Paragraph paragraph = new Paragraph();
//
//		paragraph.add(new Paragraph("Hallo Welt"));
//		paragraph.add(new Paragraph(" "));
//		paragraph.add(new Paragraph("Hallo Welt 2"));
//		paragraph.add(new Paragraph(" "));
//		paragraph.add(new Paragraph("Hallo Welt 3"));
//		doc.add(paragraph);
//		doc.close();

	}
}
