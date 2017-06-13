package com.bridgelabz.SpringFileUploade.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class FileUploadeModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public FileUploadeModel() {

	}

	@Id
	@GenericGenerator(name = "file", strategy = "increment")
	@GeneratedValue(generator = "file")
	@Column
	private int id;
	@Column
	private String fileName;
	@Lob
	@Column
	private byte[] Type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getImage() {
		return Type;
	}

	public void setImage(byte[] Type) {
		this.Type = Type;
	}

}
