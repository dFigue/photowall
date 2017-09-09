package es.bjt.photowall.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection="photo")
@JsonPropertyOrder({"uid","numVotes","idUser"})
public class Photo 
{
	@Id
	@NotNull
	private String uid;
	private String comments;
	private long numVotes;
	
	@NotNull
	private String idUser;
	
	private boolean blocked;
	private String extension;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(long numVotes) {
		this.numVotes = numVotes;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	@Override
	public String toString() {
		return "Photo [uid=" + uid + ", comments=" + comments + ", numVotes=" + numVotes + ", idUser=" + idUser
				+ ", blocked=" + blocked + "]";
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	
	
	
	

}
