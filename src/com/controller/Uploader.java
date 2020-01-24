package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.beans.Student;
import com.model.Account;



public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/Upload";
	//String relativeWebPath = "/";
	//ServletContext context = getServletContext();
	//String absoluteFilePath = context.getRealPath(relativeWebPath);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("Hello");
	}
	
	
	
	/* private String folderLocation = null;
	public void init() throws ServletException {
		  super.init();
		  this.folderLocation = getServletContext().getInitParameter("/upload");
		 }
*/

	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//String email=request.getParameter("email");
		String email=null;
		
		email=request.getSession().getAttribute("email").toString();
		
		
		String year = null;
		String stream = null;
		String s_name= null;
		Student s = null;
		Account acc=new Account();
		
		
		
		if(ServletFileUpload.isMultipartContent(request)){
            try {
            	
            	try {
            		
        			s=acc.fetchStudent(email);
        			year=s.getYear();
        			stream=s.getStream();
        			s_name=s.getName();
        			//new File("C:\\year\\stream\\s_name");
        			//PrintWriter out = response.getWriter();
        			//out.println("Hello");

        			
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
             //   if (this.extension.toLowerCase() != ".doc")
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	String path="C:\\Upload\\"+year+"\\"+stream+"\\"+s_name;
                    	new File(path).mkdir();
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY+"/"+year+"/"+stream+"/"+s_name + File.separator + name));
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
            
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/uploadresult.jsp").forward(request, response);
     
    }
  
}
