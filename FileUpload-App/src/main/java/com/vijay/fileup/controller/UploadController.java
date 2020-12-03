package com.vijay.fileup.controller;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	private static String UPLOAD_FOLDER = "D:\\Temp";

	@GetMapping("/")
	public String index() {
		return "upload";

	}
	@PostMapping("/upload")
	public String UploadFile(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			byte[] bytes=file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER+file.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message","file Seccefully Uploaded"+file.getOriginalFilename()+"'");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/uploadStatus";
		
	}
	@GetMapping("/uploadStatus")
public String uploadStatus() {
	return "uploadStatus";
		
	}
}
