package com.fci.fptid.validator;

import java.util.regex.Pattern;

import org.keycloak.services.validation.Validation;

public class UsernameValidator extends Validation{
	private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.{6,32}$)(?![0-9_\\-.])[a-zA-Z0-9_\\-.]+$");
}
