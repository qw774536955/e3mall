package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.service.ItemService;

@Controller
public class PageController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/")
	public String showIndex(){
		
		return "index";
	}
	@RequestMapping("/{page}")
	public String showView(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(Integer page ,Integer rows){
		DataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
