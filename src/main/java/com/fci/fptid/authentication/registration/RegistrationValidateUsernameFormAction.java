package com.fci.fptid.authentication.registration;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.jboss.logging.Messages;
import org.keycloak.Config.Scope;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormActionFactory;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.ValidationContext;
import org.keycloak.authentication.forms.RegistrationPage;
import org.keycloak.events.Errors;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.FormMessage;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.services.validation.Validation;

import com.fci.fptid.validator.UsernameValidator;

public class RegistrationValidateUsernameFormAction implements FormAction{

	public RegistrationValidateUsernameFormAction(KeycloakSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildPage(FormContext context, LoginFormsProvider form) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(ValidationContext context) {
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
        List<FormMessage> errors = new ArrayList<>();

        String eventError = Errors.INVALID_REGISTRATION;

        if (Validation.isBlank(formData.getFirst((RegistrationPage.FIELD_USERNAME)))) {
            errors.add(new FormMessage(RegistrationPage.FIELD_USERNAME, "Username không được bỏ trống"));
        }
        
        if (!UsernameValidator.isUsernameValid(formData.getFirst((RegistrationPage.FIELD_USERNAME)))) {
            errors.add(new FormMessage(RegistrationPage.FIELD_USERNAME, "Username không hợp lệ"));
        }

        if (errors.size() > 0) {
            context.validationError(formData, errors);
            return;
        } else {
            context.success();
        }
    }

	@Override
	public void success(FormContext context) {
		UserModel user = context.getUser();
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
        user.setFirstName(formData.getFirst(RegistrationPage.FIELD_FIRST_NAME));
        user.setLastName(formData.getFirst(RegistrationPage.FIELD_LAST_NAME));
        user.setEmail(formData.getFirst(RegistrationPage.FIELD_EMAIL));
	}

	@Override
	public boolean requiresUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
		// TODO Auto-generated method stub
		
	}

}
