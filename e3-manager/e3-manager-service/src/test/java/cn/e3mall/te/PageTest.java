package cn.e3mall.te;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageTest {
	@Test
	public void testpage(){
		//设置分页信息
		PageHelper.startPage(1, 10);
		//执行查询
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//从容器中获取代理对象
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class); 
		//执行查询
		TbItemExample example = new TbItemExample();//查全部 
		List<TbItem> list = tbItemMapper.selectByExample(example);
		System.out.println(list.size());//list查到的记录数
		//取查询结果，然后包装这个结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());//取总记录数，相当于以前的count
		System.out.println(pageInfo.getPages());//总页数
		System.out.println(pageInfo.getSize());//list中的记录数,也就是分页信息设置的每页几条
		
	}
}
