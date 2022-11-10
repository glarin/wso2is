package org.wso2.custom.user.store.manager;

import org.wso2.carbon.user.api.Property;
import org.wso2.carbon.user.core.UserStoreConfigConstants;
import org.wso2.carbon.user.core.jdbc.JDBCRealmConstants;
import java.util.ArrayList;

public class CustomUserStoreConstants {
	public static final ArrayList<Property> CUSTOM_UM_MANDATORY_PROPERTIES = new ArrayList<Property>();
	public static final ArrayList<Property> CUSTOM_UM_OPTIONAL_PROPERTIES = new ArrayList<Property>();
	public static final ArrayList<Property> CUSTOM_UM_ADVANCED_PROPERTIES = new ArrayList<Property>();
	static {
		setMandatoryProperty(JDBCRealmConstants.DRIVER_NAME, "Driver Name", "org.postgresql.Driver", "Full qualified driver name");
		setMandatoryProperty(JDBCRealmConstants.URL, "Connection URL", "jdbc:postgresql://fabrica-digital-aurora-dev-cluster.cluster-chmkjdaeuw9h.us-east-1.rds.amazonaws.com:5432/dropin_database", "URL of the user store database");
		setMandatoryProperty(JDBCRealmConstants.USER_NAME, "User Name", "usr_dropin", "Username for the database");
		setMandatoryProperty(JDBCRealmConstants.PASSWORD, "Password", "xxxxxx", "Password for the database");
		setProperty(UserStoreConfigConstants.disabled, "Disabled", "false",
				UserStoreConfigConstants.disabledDescription);
		setProperty("ReadOnly", "Read Only", "true",
				"Indicates whether the user store of this realm operates in the user read only mode or not");
		setProperty(UserStoreConfigConstants.SCIMEnabled, "SCIM Enabled", "false",
				UserStoreConfigConstants.SCIMEnabledDescription);
//Advanced Properties
		setAdvancedProperty("SelectUserSQL", "Select User SQL", "SELECT * FROM USERS WHERE USERNAME=?", "");
		setAdvancedProperty("UserFilterSQL", "User Filter SQL",
				"SELECT USERNAME FROM USERS WHERE USERNAME LIKE ? ORDER BY ID", "");
	}

	private static void setProperty(String name, String displayName, String value, String description) {
		Property property = new Property(name, value, displayName + "#" + description, null);
		CUSTOM_UM_OPTIONAL_PROPERTIES.add(property);
	}

	private static void setMandatoryProperty(String name, String displayName, String value, String description) {
		Property property = new Property(name, value, displayName + "#" + description, null);
		CUSTOM_UM_MANDATORY_PROPERTIES.add(property);
	}

	private static void setAdvancedProperty(String name, String displayName, String value, String description) {
		Property property = new Property(name, value, displayName + "#" + description, null);
		CUSTOM_UM_ADVANCED_PROPERTIES.add(property);
	}
}