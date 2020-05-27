package com.icss.wuliu.biz;


import java.util.List;



import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ciss.wuliu.entity.Tclass;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.ClassInfodto;
import com.icss.wuliu.dao.ClassInfoDao;

@Service("classInfoBiz")
@Transactional(readOnly=true)
public class ClassInfoBiz {
	
	@Autowired
	ClassInfoDao classInfoDao;
	
	@Transactional(rollbackFor=Throwable.class)
	public void addClassInfo(Tclass tclass) throws Exception{
		
		classInfoDao.addClassInfo(tclass);
	}
	
	
	public String getClassInfo(String startSite,String endSite, TurnPage tp) throws Exception{
		String ClassInfoSTR;
		List<ClassInfodto> classInfo = classInfoDao.getClassInfo(startSite, endSite, tp);
		
		ClassInfoSTR = JSONArray.fromObject(classInfo).toString();
		System.out.println(ClassInfoSTR);
		return ClassInfoSTR;
	}
	
	public List<ClassInfodto> queryPassClassInfo(String classid,long pointid,TurnPage tp) throws Exception{

		List<ClassInfodto> classInfo = classInfoDao.queryPassClassInfo(classid,pointid, tp);
		return classInfo;
	}
	
	public Tclass getTclassById(int classid) throws Exception{
		
		return classInfoDao.getTclassById(classid);
	}
}
