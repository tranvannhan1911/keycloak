package com.fci.fptid.validator;

import java.util.regex.Pattern;

import org.keycloak.services.validation.Validation;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class UsernameValidator extends Validation{
	public static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
	

    public static boolean isUsernameValid(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }
}
