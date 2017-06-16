package com.bridgelabz.SpringFileUploade.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.bridgelabz.SpringFileUploade.Dao.FileUploadeDao;
import com.bridgelabz.SpringFileUploade.Model.FileUploadeModel;

@Controller
public class FileUploadeController {
	@Autowired
	FileUploadeDao fileUploadeDao;

	@RequestMapping(value = "/")
	public ModelAndView userRegistration() {
		System.out.println("hello1 ");
		return new ModelAndView("ImageUploade");

	}

	@RequestMapping(value = "/uploadeFile", method = RequestMethod.POST)
	public ModelAndView handleFileUpload(HttpServletRequest request,
			@RequestParam("Containt") CommonsMultipartFile[] fileUploadeModel) throws Exception {
		if (fileUploadeModel != null && fileUploadeModel.length > 0) {
			for (CommonsMultipartFile aFile : fileUploadeModel) {
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				FileUploadeModel uploadFile = new FileUploadeModel();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setImage(aFile.getBytes());
				fileUploadeDao.save(uploadFile);
			}
		}

		return new ModelAndView("HomePage");

	}

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		FileUploadeModel item = fileUploadeDao.getImage(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		ServletOutputStream responseOutputStream = response.getOutputStream();
		responseOutputStream.write(item.getImage());
		responseOutputStream.flush();
		responseOutputStream.close();

	}

	@RequestMapping("/DisplayList")
	public ModelAndView download(Integer documentId, HttpServletResponse response) {

		List<FileUploadeModel> allFiles = null;

		try {
			allFiles = fileUploadeDao.display();

			ModelAndView model = new ModelAndView("imageList");
			model.addObject("imageList", allFiles);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
