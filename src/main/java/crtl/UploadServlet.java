package crtl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bd.bd;
import metier.Users;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 设置在内存中存储数据的阈值（1MB）
    maxFileSize = 1024 * 1024 * 5, // 设置上传文件的最大大小（5MB）
    maxRequestSize = 1024 * 1024 * 10 // 设置上传请求的最大大小（10MB）
)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";

    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 获取应用程序的真实路径
        String applicationPath = request.getServletContext().getRealPath("");
        // 将上传文件存储到指定的目录
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdir();
        }

        // 获取上传的文件
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String filePath = UPLOAD_DIR + File.separator + fileName;

        // 将上传的文件保存到指定的目录
        InputStream inputStream = filePart.getInputStream();
        Files.copy(inputStream, Paths.get(uploadFilePath + File.separator + fileName),
                StandardCopyOption.REPLACE_EXISTING);
        
        Users u1=new Users("weichen@gmail.com","1234","zzz","rrr","Mme",null,"aaa@qqq","aaaaaaaaaa");

        try {
			bd.uploadPhoto(u1, filePath);
			String i="";
			i="Photo déposée avec succès !";
			request.setAttribute("msg_photo", i);
			request.getRequestDispatcher("res").forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}

        
        
        
        
    

		
	}

}
