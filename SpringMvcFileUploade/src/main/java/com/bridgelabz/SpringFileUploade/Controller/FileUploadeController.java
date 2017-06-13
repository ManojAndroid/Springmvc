package com.bridgelabz.SpringFileUploade.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView userRegistration() 
	{
		System.out.println("hello1 ");
		return new ModelAndView("ImageUploade");

	}

	/*
	 * @RequestMapping(value = "/uploadeFile", method = RequestMethod.POST)
	 * public ModelAndView UploadeFil(FileUploadeModel fileUploadeModel) {
	 * 
	 * System.out.println(fileUploadeModel);
	 * fileUploadeDao.save(fileUploadeModel); return new
	 * ModelAndView("HomePage"); }
	 */

	@RequestMapping(value = "/uploadeFile", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, @RequestParam ("Type") CommonsMultipartFile[] fileUploadeModel)
			throws Exception
	{

		if (fileUploadeModel != null && fileUploadeModel.length > 0) 
		{
			for (CommonsMultipartFile aFile : fileUploadeModel) 
			{

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				FileUploadeModel uploadFile = new FileUploadeModel();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setImage(aFile.getBytes());
				fileUploadeDao.save(uploadFile);
			}
		}

		return "HomePage";
	}

}
