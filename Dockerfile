FROM quay.io/keycloak/keycloak:21.0.1

WORKDIR /opt/keycloak

ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

COPY target/*.jar /opt/keycloak/providers
CMD ["start-dev"]