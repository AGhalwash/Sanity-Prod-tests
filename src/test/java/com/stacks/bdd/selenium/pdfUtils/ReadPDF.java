package com.stacks.bdd.selenium.pdfUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ReadPDF {

	private static Logger logger = Logger.getLogger(ReadPDF.class.getName());
	
	public static String getContentPdf(String strURL, String cookieSession) {
		logger.trace("getContentPdf");
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			URL url = new URL(strURL);

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("Cookie", cookieSession);
			urlConn.setUseCaches(true);
			urlConn.connect();

			PDFParser parser = new PDFParser(urlConn.getInputStream());

			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);

			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (MalformedURLException e2) {
			logger.error("URL string could not be parsed " + e2.getMessage());
		} catch (IOException e) {
			logger.error("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (IOException e1) {
				logger.error(e);
			}
		}
		return parsedText ;
	}

}