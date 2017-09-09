package es.bjt.photowall.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Document(collection="photoViewedByUser")
@JsonPropertyOrder({"photoUID","userId"})
public class PhotoViewedByUser 
{
	@NotNull
	private String photoUID;
	
	@NotNull
	private String userId;
	
	public String getPhotoUID() {
		return photoUID;
	}
	public void setPhotoUID(String photoUID) {
		this.photoUID = photoUID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "PhotoViewedByUser [photoUID=" + photoUID + ", userId=" + userId + "]";
	}

}
