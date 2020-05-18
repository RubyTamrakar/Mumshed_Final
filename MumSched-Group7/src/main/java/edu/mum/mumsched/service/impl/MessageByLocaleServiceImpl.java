package edu.mum.mumsched.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.mumsched.service.MessageByLocaleService;

@Component
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String id) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(id, null, locale);
	}

	@Override
	public String getMessage(String id, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(id, args, locale);
	}

	/**
	 * add redirect message
	 * 
	 * @param ra
	 * @param code
	 * @param args
	 */
	@Override
	public void addRedirectMessage(RedirectAttributes ra, String code, Object[] args) {
		ra.addFlashAttribute(MESSAGE_ATTRIBUTE, getMessage(code, args));
	}

	@Override
	public String getUpdateSuccess() {
		return getMessage(MSG_UpdateSuccess);
	}

	@Override
	public String getCreateSuccess() {
		return getMessage(MSG_CreateSuccess);
	}

	@Override
	public String getRemoveSuccess() {
		return getMessage(MSG_RemoveSuccess);
	}
}
