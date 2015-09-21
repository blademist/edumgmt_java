package net.shinc.service.edu.recommend.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.Recommend;
import net.shinc.orm.mybatis.bean.edu.RecommendHasCourseGrade;
import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;
import net.shinc.orm.mybatis.mappers.edu.RecommendHasCourseGradeMapper;
import net.shinc.orm.mybatis.mappers.edu.RecommendHasVideoBaseMapper;
import net.shinc.orm.mybatis.mappers.edu.RecommendMapper;
import net.shinc.service.edu.recommend.RecommendService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RecommendService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	private RecommendMapper recommendMapper;
	
	@Autowired
	private RecommendHasVideoBaseMapper recommendHasVideoBaseMapper;
	
	@Autowired
	private RecommendHasCourseGradeMapper recommendHasCourseGradeMapper;
	
	@Override
	public Integer addRecommend(Recommend recommend) {
		recommend.setAddTime(new Date());
		recommend.setTopTime(new Date());
		return recommendMapper.insert(recommend);
	}

	@Override
	public Integer updateRecommend(Recommend recommend) {
		return recommendMapper.update(recommend);
	}

	@Override
	public Integer deleteRecommendById(Integer id) {
		return recommendMapper.deleteById(id);
	}

	@Override
	public Recommend getRecommendById(Integer id) {
		return recommendMapper.findById(id);
	}

	@Override
	public List<Recommend> getRecommendList(Recommend recommend) {
		return recommendMapper.findAll(recommend);
	}
	
	@Override
	public Integer addRecommendVideoBase(Recommend recommend) {
		int i = 0;
		if(StringUtils.isNotEmpty(recommend.getVideoBaseIds())){
			for (String videoBaseId : StringUtils.split(recommend.getVideoBaseIds(), ",")) {
				RecommendHasVideoBase r = new RecommendHasVideoBase();
				r.setAddTime(new Date());
				r.setTopTime(new Date());
				r.setRecommendId(recommend.getId());
				r.setVideoBaseId(Integer.valueOf(videoBaseId));
				r.setVideoType(recommend.getVideoType());
				r.setDimension("9");// 这一版推荐视频不按初中高中维度排，后期会把这个字段删除掉
				recommendHasVideoBaseMapper.insert(r);
				i++;
			}
		}
		return i;
	}

	@Override
	public Integer deleteRecommendVideoBaseById(Integer id) {
		return recommendHasVideoBaseMapper.deleteById(id);
	}

	@Override
	public List<Map> getRecommendVideoBaseList(RecommendHasVideoBase recommendHasVideoBase){
		return recommendMapper.getRecommendVideoBaseList(recommendHasVideoBase);
	}

	@Override
	public boolean isRecommendHasVideo(Recommend recommend) {
		if (recommend.getType().equals("1")) {// 单视频
			RecommendHasVideoBase recommendHasVideoBase = new RecommendHasVideoBase();
			recommendHasVideoBase.setRecommendId(recommend.getId());
			List list = recommendHasVideoBaseMapper.findAll(recommendHasVideoBase);
			if(list == null || list.size() == 0){
				return false;
			}
		}
		if (recommend.getType().equals("2")) {// 视频库
			RecommendHasCourseGrade recommendHasCourseGrade = new RecommendHasCourseGrade();
			recommendHasCourseGrade.setRecommendId(recommend.getId());
			List list = recommendHasCourseGradeMapper.findAll(recommendHasCourseGrade);
			if(list == null || list.size() == 0){
				return false;
			}
		}
		return true;
		
	}

	

}
