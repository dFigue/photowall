package es.bjt.photowall.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection="users")
@JsonPropertyOrder({"idUser","name"})
public class User {
	
	@Id
	@NotNull
	private String idUser;
	
	@NotNull
	private String name;
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + "]";
	}
	
	

}
