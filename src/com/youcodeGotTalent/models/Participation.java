package com.youcodeGotTalent.models;

public class Participation {
	private long id_user;
	private long id_category;
	private String description;
	private java.sql.Timestamp show_start_time;
	private java.sql.Timestamp show_end_time;
	private String attached_file;
	private boolean is_accepted;

//	public Participation(long l, long m, String string, java.sql.Timestamp timestamp, java.sql.Timestamp timestamp2,
//			String string2, boolean b) {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Participation(long id_user, long id_category, String description, java.sql.Timestamp show_start_time,
			java.sql.Timestamp show_end_time, String attached_file, boolean is_accepted) {
		super();
		this.id_user = id_user;
		this.id_category = id_category;
		this.description = description;
		this.show_start_time = show_start_time;
		this.show_end_time = show_end_time;
		this.attached_file = attached_file;
		this.is_accepted = is_accepted;
	}

	@Override
	public String toString() {
		return "Participation [id_user=" + id_user + ", id_category=" + id_category + ", description=" + description
				+ ", show_start_time=" + show_start_time + ", show_end_time=" + show_end_time + ", attached_file="
				+ attached_file + ", is_accepted=" + is_accepted + "]";
	}
	// Participation methods

	// add user
	public void addParticipation() {

	}
}
