package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName VideoDetail 
 * @Description 视频详细信息
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:53:09  
 */
public class VideoDetail  {
	
	private Integer videoBaseId;
	
	@NotEmpty(message = "{videoDetail.type.not.empty}")
	private String type;
	
	@NotEmpty(message = "{videoDetail.url.not.empty}")
    private String url;

    private Date updatetime;

    private String storeInfo;

    private String storeType;
    
    private String videoDuration;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

	public String getVideoDuration() {
		return videoDuration;
	}

	public void setVideoDuration(String videoDuration) {
		this.videoDuration = videoDuration;
	}
}