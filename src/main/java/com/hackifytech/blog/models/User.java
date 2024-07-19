package com.hackifytech.blog.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
//	TODO: Add a the validations line @NotNull @Email etc...
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String profilePicture;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column
    private Date dateOfBirth;

    @Column
    private String gender;

    @Column
    private String location;

    @Column
    private String occupation;

    @Column
    private String education;

    @Column(nullable = false)
    private Date dateRegistered;

    @Column
    private Date lastLoginDate;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private AccountVerificationStatus verificationStatus;

    @Enumerated(EnumType.STRING)
    private AccountPrivacySettings privacySettings;

    @Column
    private boolean twoFactorAuthenticationEnabled;

    @Column
    private NotificationPreferences notificationPreferences;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    @Column
    private String paymentInformation;

    @Column(columnDefinition = "TEXT")
    private String accountActivityLogs;

    @Column
    private String securityTokens;

    @Column
    private String oauthProvider;

    @Column
    private String oauthProviderId;

    @Column
    private String oauthAccessToken;

    @Column
    private String oauthRefreshToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public AccountVerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(AccountVerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public AccountPrivacySettings getPrivacySettings() {
		return privacySettings;
	}

	public void setPrivacySettings(AccountPrivacySettings privacySettings) {
		this.privacySettings = privacySettings;
	}

	public boolean isTwoFactorAuthenticationEnabled() {
		return twoFactorAuthenticationEnabled;
	}

	public void setTwoFactorAuthenticationEnabled(boolean twoFactorAuthenticationEnabled) {
		this.twoFactorAuthenticationEnabled = twoFactorAuthenticationEnabled;
	}

	public NotificationPreferences getNotificationPreferences() {
		return notificationPreferences;
	}

	public void setNotificationPreferences(NotificationPreferences notificationPreferences) {
		this.notificationPreferences = notificationPreferences;
	}

	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public String getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public String getAccountActivityLogs() {
		return accountActivityLogs;
	}

	public void setAccountActivityLogs(String accountActivityLogs) {
		this.accountActivityLogs = accountActivityLogs;
	}

	public String getSecurityTokens() {
		return securityTokens;
	}

	public void setSecurityTokens(String securityTokens) {
		this.securityTokens = securityTokens;
	}

	public String getOauthProvider() {
		return oauthProvider;
	}

	public void setOauthProvider(String oauthProvider) {
		this.oauthProvider = oauthProvider;
	}

	public String getOauthProviderId() {
		return oauthProviderId;
	}

	public void setOauthProviderId(String oauthProviderId) {
		this.oauthProviderId = oauthProviderId;
	}

	public String getOauthAccessToken() {
		return oauthAccessToken;
	}

	public void setOauthAccessToken(String oauthAccessToken) {
		this.oauthAccessToken = oauthAccessToken;
	}

	public String getOauthRefreshToken() {
		return oauthRefreshToken;
	}

	public void setOauthRefreshToken(String oauthRefreshToken) {
		this.oauthRefreshToken = oauthRefreshToken;
	}

    
}

enum UserRole {
    ADMIN,
    AUTHOR,
    SUBSCRIBER
    // Add more roles as needed
}

enum UserStatus {
    ACTIVE,
    SUSPENDED,
    DELETED
    // Add more status options as needed
}

enum AccountVerificationStatus {
    VERIFIED,
    UNVERIFIED,
    PENDING
    // Add more verification status options as needed
}

enum AccountPrivacySettings {
    PUBLIC,
    PRIVATE,
    FRIENDS_ONLY
    // Add more privacy settings options as needed
}

enum NotificationPreferences {
    EMAIL,
    PUSH_NOTIFICATIONS,
    SMS
    // Add more notification preferences options as needed
}

enum SubscriptionStatus {
    FREE,
    PREMIUM,
    TRIAL
    // Add more subscription status options as needed
}