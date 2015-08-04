package com.infrutious.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.infrutious.springmvc.logic.ExcelParser;
import com.infrutious.springmvc.service.CustomService;
import com.infrutious.springmvc.util.DBUtil;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CustomService service;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = {"/","/index"})
    public String index()
    {
        return "index";
    }
	@RequestMapping(value = {"/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		System.out.println("Coming here");
		return "upload";
	}
	
	@RequestMapping(value = { "/parseExcel" }, method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listEmployees(@RequestParam String filePath) {
		try{
			List<List<String>> data = ExcelParser.parse(filePath);
			return new Gson().toJson(data );
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = { "/dropandCreate" }, method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String dropAndCreate(@RequestParam String tableName) {
		try{
			System.out.println("Entered");
			service.dropTable(tableName);
			service.createTable(tableName, DBUtil.getHardCodeData());
			service.createData(tableName,DBUtil.getHardCodeData());
			return "success";
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public String uploadExcel(@RequestParam MultipartFile fileToUpload,ModelMap model) {
		try{
			System.out.println("Entered");
			String fileName = fileToUpload.getOriginalFilename().substring(0,fileToUpload.getOriginalFilename().lastIndexOf("."));
			System.out.println("File Name:"+fileName);
			List<List<String>> data = ExcelParser.parse(fileToUpload.getInputStream());
			model.addAttribute("data", data);
			model.addAttribute("tableName", fileName);
			return "upload";
//			return new Gson().toJson(data );
		} catch (Exception e) {
			return null;
		}
	}

}
