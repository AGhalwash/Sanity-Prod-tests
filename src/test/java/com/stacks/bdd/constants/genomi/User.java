package com.stacks.bdd.constants.genomi;

import com.stacks.bdd.constants.core.IUser;
import org.apache.log4j.Logger;

import java.util.EnumSet;

public enum User implements IUser {

	//COMMON USERS
	ADMIN_USER_BDD(null, "USER_BDD_ADMIN", "Cambiar_20", "BDD Admin"),

	//HOME PAGE USER
	HOME_PAGE_USER(null,"USER_BDD_NEW_HOME","Cambiar_20", "USER_BDD_NEW_HOME" ),
	OLD_HOME_PAGE_USER(null,"USER_BDD_OLD_HOME","Cambiar_20","USER_BDD_OLD_HOME"),

	USER_HOME_CHRONO(null,"USER_HOME_CHRONO","Cambiar_20", "USER_HOME_CHRONO"),

	//AXA USERS
	ADMIN_AXA_USER_BDD(null, "USER_AXA_BDD_ADMIN", "Cambiar_20", "AXA BDD Admin"),

	//-----------------------------------------------------------------------------------------//

	USER_BDD_SANITARY01(null, "USER_BDD_SANITARY01", "Cambiar_20", "BDD Sanitary01"),

	USER_BDD_SANITARY02(null, "USER_BDD_SANITARY02", "Cambiar_20", "BDD Sanitary02"),

	USER_BDD_SANITARY03(null, "USER_BDD_SANITARY03", "Cambiar_20", "BDD Sanitary03"),

	USER_BDD_CHRONO03(null, "USER_BDD_CHRONO03", "Cambiar_20", "BDD Chrono03"),

	USER_BDD_NO_SANITARY03(null, "USER_BDD_SANITARY03", "Cambiar_20", "BDD NoSanitary03"),

	USER_BDD_SANITARY04(null, "USER_BDD_SANITARY04", "Cambiar_20", "BDD Sanitary04"),

	USER_BDD_CHRONO04(null, "USER_BDD_CHRONO04", "Cambiar_20", "BDD Chrono04"),

	USER_BDD_SANITARY05(null, "USER_BDD_SANITARY05", "Cambiar_20", "BDD Sanitary05"),

	USER_BDD_SANITARY07(null, "USER_BDD_SANITARY07", "Cambiar_20", "BDD Sanitary07"),

	USER_BDD_SANITARY08(null, "USER_BDD_SANITARY08", "Cambiar_20", "BDD Sanitary08"),

	USER_BDD_MAIIA(null, "USER_BDD_MAIIA", "Cambiar_20", "USER_BDD_MAIIA"),

	USER_BDD_6006(null, "USER_BDD_6006", "Cambiar_20", "BDD6006"),

	USER_BDD_NOSANITARY(null, "USER_BDD_NOSANITARY", "Cambiar_20", "BDD NoSanitary"),

	USER_BDD_INVALIDUSER(null, "USER_BDD_INVALID", "invalid", "BDD InvalidUser"),


	USER_BDD_LOCKED_WRONGPASS(null, "USER_BDD_UNLOCKED", "locked", "BDD Unlocked Wrong Pass"),

    USER_BDD_LOCKED(null, "USER_BDD_LOCKED", "Cambiar_20", "BDD Locked"),
    
    USER_BDD_UNLOCKED02(null, "USER_BDD_LOCKED02", "Cambiar_20", "BDD Unlocked 2"),

	USER_BDD_EXPIRED(null,"USER_EXPIRED", "Cambiar_20", "BDD ExpiredPass"),
	
	USER_BDD_CONCTACTCENTER(null, "USER_BDD_CONTACTCENT", "Cambiar_20", "BDD ContactCenter"),

	USER_BDD_CHILE_SANITARY(null, "USER_CHILE_SANITARY", "Cambiar_20", "BDD ChileSanitary"),
	
	USER_BDD_COMPLETE(null, "smonge@stacks.es", "1111", "BDD User Admin"),

	USER_BDD_INACTIVE(null, "USER_BDD_INACTIVE", "Cambiar_20", "USER_BDD_INACTIVE"),

	USER_BDD_TO_DEACT(null, "USER_BDD_TO_DEACT", "Cambiar_20", "USER_BDD_TO_DEACT"),

	USER_COMMON_INACTIVE(null, "USER_COMMON_INACTIVE", "Cambiar_20", "USER_COMMON_INACTIVE"),

	USER_COMMON_TO_DEACT(null, "USER_COMMON_TO_DEACT", "Cambiar_20", "USER_COMMON_TO_DEACT"),

	USER_AGENDA(null, "USER_AGENDA", "Cambiar_20", "USER_AGENDA"),

	USER_AGENDA_6006(null, "USER_AGENDA_6006", "Cambiar_20", "USER_AGENDA_6006"),

	USER_OBSER_6006(null, "USER_OBSER_6006", "Cambiar_20", "USER_OBSER_6006"),

	//Don't use the user USER_CHRONO_6006 unless you use the correct precondition because it uses both classic & chrono views
	USER_CHRONO_6006(null, "USER_CHRONO_6006", "Cambiar_20", "USER_CHRONO_6006"),

	USER_GROUP_001(null, "USER_GROUP_001", "Cambiar_20", "USER_GROUP_001"),

	SUPER_USER_BDD(null, "USER_BDD_SUPER", "Cambiar_20", "USER_BDD_SUPER"),

	ACTIVATE_POP_UP(null, "ACTIVATE_POP_UP", "Cambiar_20", "ACTIVATE_POP_UP"),

	DEACTIVATE_POP_UP(null, "DEACTIVATE_POP_UP", "Cambiar_20", "DEACTIVATE_POP_UP"),

	CONSULTER_POP_UP(null, "CONSULTER_POP_UP", "Cambiar_20", "CONSULTER_POP_UP"),

	USER_BDD_PATIENTLIST(null, "USER_BDD_PATIENTLIST", "Cambiar_20", "USER_BDD_PATIENTLIST"),

	USER_BDD_PATIENTFILE(null, "USER_BDD_PATIENTFILE", "Cambiar_20", "USER_BDD_PATIENTFILE"),

	USER_BDD_GRP_USR(null, "USER_BDD_GRP_USR", "Cambiar_20", "USER_BDD_GRP_USR"),

	USER_BDD_GRP_SLV(null, "USER_BDD_GRP_SLV", "Cambiar_20", "USER_BDD_GRP_SLV"),

	USER_BDD_SEGURE(null, "USER_BDD_SEGURE", "Cambiar_20", "USER_BDD_SEGURE"),

	USER_BDD_CONSENT(null, "USER_BDD_CONSENT", "Cambiar_20", "USER_BDD_CONSENT"),

	USER_BDD_CONSENT2(null, "USER_BDD_CONSENT2", "Cambiar_20", "USER_BDD_CONSENT2"),

	USER_BDD_CONSENT3(null, "USER_BDD_CONSENT3", "Cambiar_20", "USER_BDD_CONSENT3"),

	USER_SHARE_LIST(null, "USER_SHARE_LIST", "Cambiar_20", "USER_SHARE_LIST"),

	NOTE_SANITARY(null, "NOTE_SANITARY", "Cambiar_20", "NOTE_SANITARY"),

	NOTE_SANITARY_OBS(null, "NOTE_SANITARY_OBS", "Cambiar_20", "NOTE_SANITARY_OBS"),

	NOTE_SANITARY_ACU(null, "NOTE_SANITARY_ACU", "Cambiar_20", "NOTE_SANITARY_ACU"),

	NOTE_SANIT_ACU_OBS(null, "NOTE_SANIT_ACU_OBS", "Cambiar_20", "NOTE_SANIT_ACU_OBS"),

	NOTE_ADMIN(null, "NOTE_ADMIN", "Cambiar_20", "NOTE_ADMIN"),

	NOTE_SUPERVISOR(null, "NOTE_SUPERVISOR", "Cambiar_20", "NOTE_SUPERVISOR"),

	MSG_SANITARY(null, "MSG_SANITARY", "Cambiar_20", "MSG_SANITARY"),

	MSG_SANITARY_OBS(null, "MSG_SANITARY_OBS", "Cambiar_20", "MSG_SANITARY_OBS"),

	MSG_SANITARY_ACU(null, "MSG_SANITARY_ACU", "Cambiar_20", "MSG_SANITARY_ACU"),

	MSG_SANIT_ACU_OBS(null, "MSG_SANIT_ACU_OBS", "Cambiar_20", "MSG_SANIT_ACU_OBS"),

	MSG_ADMIN(null, "MSG_ADMIN", "Cambiar_20", "MSG_ADMIN"),

	BDDQA_SANITARY(null, "BDDQA_SANITARY", "Cambiar_20", "BDDQA_SANITARY"),

	BDDQA_SANITARY_OBS(null, "BDDQA_SANITARY_OBS", "Cambiar_20", "BDDQA_SANITARY_OBS"),

	BDDQA_SANITARY_ACU(null, "BDDQA_SANITARY_ACU", "Cambiar_20", "BDDQA_SANITARY_ACU"),

	BDDQA_SANIT_ACU_OBS(null, "BDDQA_SANIT_ACU_OBS", "Cambiar_20", "BDDQA_SANIT_ACU_OBS"),

	BDDQA_ADMIN(null, "BDDQA_ADMIN", "Cambiar_20", "BDDQA_ADMIN"),

	USER_OBSER_ACU(null, "USER_OBSER_ACU", "Cambiar_20", "USER_OBSER_ACU"),

	USER_BDD_MEDECIN(null, "USER_BDD_MEDECIN", "Cambiar_20", "USER_BDD_MEDECIN"),

	USER_BDD_SNCF1(null, "USER_BDD_SNCF1", "Cambiar_20", "USER_BDD_SNCF1"),

	USER_BDD_SNCF2(null, "USER_BDD_SNCF2", "Cambiar_20", "USER_BDD_SNCF2"),

	;

	static Logger logger = Logger.getLogger(User.class.getName());
	
	private final String name;
	private final String username;
	private final String password;
	private final String role;
	
	User(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public static User getUserByRole(String role) {
		logger.trace("getUserByRole :: " + role);
		EnumSet<User> allUsers = EnumSet.allOf(User.class);
		for (User user : allUsers) {
			if (role.equals(user.role)) {
				return user;
			}
		}

		throw new IllegalArgumentException("User with role \"" + role + "\" not found.");
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

}
