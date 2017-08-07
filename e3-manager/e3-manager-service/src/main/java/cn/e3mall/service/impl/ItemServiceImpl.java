package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(Long id) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}

	@Override
	public DataGridResult getItemList(int page, int rows) {
			//1.设置分页信息
		PageHelper.startPage(page, rows);		
			//2.执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
			//3.取查询结果：总记录数、商品列表
		PageInfo<TbItem> pageInfo =new PageInfo<>(list);
		long total = pageInfo.getTotal();
			//4.把结果封装到DataGridResult中
		DataGridResult result = new DataGridResult();
		result.setTotal(total);
		result.setRows(list);
			//5.返回结果
		return result;
	}

}
