package com.tts.scp.converter.DTOs;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttachmentDTO {
	
	@JsonProperty("results")
	Collection<Attachment> attachments;

	public Collection<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Collection<Attachment> attachments) {
		this.attachments = attachments;
	}
}
