package net.shinc.service.edu.video;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoPoint;

import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName: VideoPointService
 * @Description: 知识点视频服务接口
 * @author hushichong
 * @date 2015年7月31日 下午5:21:13
 */
public interface VideoPointService {

	public void deleteVideoPointById(Integer id);

	/**
	 * @Title: insertVideoPoint
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoPoint
	 * @return Map
	 */
	public Map insertVideoPoint(VideoPoint videoPoint);

	/**
	 * @Title: updateVideoPoint
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoPoint
	 * @return Map
	 */
	public Map updateVideoPoint(VideoPoint videoPoint);

	public VideoPoint getByVideoPointById(Integer id);

	public List<VideoPoint> getVideoPointList(VideoPoint videoPoint);


	/**
	 * @Title: getVideoPoint
	 * @Description: 根据对象参数得到单个实例
	 * @param videoPoint
	 * @return videoPoint
	 */
	public VideoPoint getVideoPoint(VideoPoint videoPoint);

	/**
	 * @Title: getVideoPointAndRelevantInfoList
	 * @Description: 得到知识点视频以及其相关信息列表
	 * @param videoPastpaper
	 * @return List<VideoPastpaper>
	 */
	public List<Map> getVideoPointAndRelevantInfoList(QueryBean queryBean, RowBounds rowBounds);

}