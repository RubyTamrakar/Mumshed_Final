package edu.mum.mumsched.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public interface MessageByLocaleService {
	
	public static final String MESSAGE_ATTRIBUTE = "message";
	public static String MSG_CreateSuccess = "create.success";
	public static String MSG_UpdateSuccess = "update.success";
	public static String MSG_RemoveSuccess = "remove.success";
	
	public static final String NOT_FOUND_MESSAGE = "validate.notFoundP";
	public static final String HAS_REF_MESSAGE = "validate.hasRefP";
	public static final String MUST_BE_GREATER_THAN_MESSAGE = "validate.mustBeGreaterThanP";
	public static final String INVALID_MESSAGE = "validate.invalid";
	public static final String ALREADY_EXISTS_MESSAGE = "validate.alreadyExists";

    public String getMessage(String id);

	String getMessage(String id, Object[] args);

	void addRedirectMessage(RedirectAttributes ra, String code, Object[] args);

	String getUpdateSuccess();

	String getCreateSuccess();

	String getRemoveSuccess();
}