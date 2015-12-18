package org.andersonkmi.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.andersonkmi.service.ConversionFormat;
import org.andersonkmi.service.DocumentConversionService;

@WebServlet("/upload.action")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("convert".equals(action)) {
			Part filePart = request.getPart("file");
		    String fileName = getSubmittedFileName(filePart);
		    InputStream fileContent = filePart.getInputStream();		    
		    byte[] buffer = new byte[fileContent.available()];
		    fileContent.read(buffer);
		    File targetFile = new File(fileName);
		    OutputStream outStream = new FileOutputStream(targetFile);
		    outStream.write(buffer);
		    outStream.flush();
		    outStream.close();
		    
		    String format = request.getParameter("conversionFormat");
		    ConversionFormat conversionFormat = ConversionFormat.findByFormatName(format);
		    
		    DocumentConversionService service = new DocumentConversionService();
		    String convertedContent = service.convert(targetFile, conversionFormat);
		    request.setAttribute("convertedText", convertedContent);
		    
		    targetFile.delete();
		}
		request.getRequestDispatcher("/WEB-INF/uploadAndConvert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
}
