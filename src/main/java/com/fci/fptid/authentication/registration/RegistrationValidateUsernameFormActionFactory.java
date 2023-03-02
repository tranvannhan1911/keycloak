package com.fci.fptid.authentication.registration;

import java.util.List;

import org.keycloak.Config.Scope;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormActionFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

public class RegistrationValidateUsernameFormActionFactory implements FormActionFactory{
	public static final String PROVIDER_ID = "registration-validate-username";
	public static final String PROVIDER_NAME = "Registration Validate Username";
	private static AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.DISABLED
    };
	
	@Override
	public FormAction create(KeycloakSession session) {
		// TODO Auto-generated method stub
		return new RegistrationValidateUsernameFormAction(session);
	}

	@Override
	public void init(Scope config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return PROVIDER_ID;
	}

	@Override
	public String getDisplayType() {
		// TODO Auto-generated method stub
		return PROVIDER_NAME;
	}

	@Override
	public String getReferenceCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConfigurable() {
		return true;
	}

	@Override
	public Requirement[] getRequirementChoices() {
		// TODO Auto-generated method stub
		return REQUIREMENT_CHOICES;
	}

	@Override
	public boolean isUserSetupAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHelpText() {
		return PROVIDER_NAME;
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}
