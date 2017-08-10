package es.bjt.photowall.model;

public class Photo 
{
	
	private String uid;
	private String comments;
	private long numVotes;
	private String idUser;
	
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
	@Override
	public String toString() {
		return "Photo [uid=" + uid + ", comments=" + comments + ", numVotes=" + numVotes + ", idUser=" + idUser + "]";
	}
	
	
	

}
