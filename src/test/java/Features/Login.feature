Feature: Login Test Scenarios

  Background: Go to Hepsiburada.com/Login

  Scenario: Happy path with email for login
    Given enter email address on email field
    When click Giriş Yap button
    Given enter password on password field
    When click Giriş Yap button
    Then hepsiburada logo is visible

  Scenario: Happy path with telephone number starting with 0 for Login
    Given enter telephone number with 0 on email address or telephone number field
    When click Giriş Yap button
    Then screen is visible for verification code
    Given enter verification code within 3 minutes
    When click Onayla button
    Then hepsiburada logo is visible

  Scenario: Happy path with telephone number starting without 0 for Login
    Given enter telephone number without 0 on email address or telephone number field
    When click Giriş Yap button
    Then screen is visible for verification code
    Given enter verification code within 3 minutes
    When click Onayla button
    Then hepsiburada logo is visible

  Scenario: Happy path with Google ile Giriş Yap option for login
    When click Google ile Giriş Yap option on "Sosyal hesap ile giriş yap" field
    Then "Google ile oturum açın" is visible
    When click available Google account
    Then hepsiburada logo is visible

  Scenario: Happy path with Google ile Giriş Yap option for login
    When click Google ile Giriş Yap option on "Sosyal hesap ile giriş yap" field
    Then "Google ile oturum açın" is visible
    When click available Google account
    Then hepsiburada logo is visible


  Scenario: Missing @ character on email address for login
    Given enter missing email address as "$missingEmailAddress" on email field
    When click Giriş Yap button
    Then "$missingValidationMessage" element equals "Geçerli bir e-posta adresi girmelisiniz."

  Scenario: General field control
    Then hepsiburada logo is visible on the top
    Then "Üye ol" field is visible near the "Giriş Yap" field
    Then "Yardıma ihtiyacım var" field is visible under the Giriş Yap button

  Scenario: Social account field control
    Then "Sosyal hesap ile giriş yap" field is visible
    Then "Hepsiburada'ya şifresiz giriş yapabilmek için Google, Apple veya Facebook hesabınızı bağlayabilirsiniz." text field is visible under "Sosyal hesap ile giriş yap" field
    Then "Google ile Giriş yap" field is visible
    Then "Apple ile Giriş yap" field is visible
    Then "Facebook ile Giriş yap" field is visible

  Scenario: Missing . character on email address for login
    Given enter missing email address as "$missingEmailAddress2" on email field
    When click Giriş Yap button
    Then "$missingValidationMessage" element equals "Geçerli bir e-posta adresi girmelisiniz."

  Scenario: All uppercase email address for login
    Given enter all uppercase email address as "$allUppercaseEmailAddress" on email field
    When click Giriş Yap button
    Then "$allUppercaseValidationMessage" element equals "E-posta adresi eksik veya hatalı.Girdiğiniz bilgiler ile herhangi bir hesabı eşleştiremedik, kontrol edip tekrar deneyin."

  Scenario: Blank email address for Login
    Given leave email address field blank
    When click Giriş Yap button
    Then "$blankEmailAddress" element equals "E-posta adresinizi veya telefon numaranızı girmelisiniz."

  Scenario: Special character email address for Login
    Given try to enter "$specialCharacter" for email address field
    Then Special character is not clickable for email address field

  Scenario: Turkish character email address for Login
    Given try to enter "$turkishCharacter" for email address field
    Then Turkish character is not clickable for email address field

  Scenario: Missing telephone number with clicking Giriş Yap button for login
    Given enter missing telephone number as "$missingTelephoneNumber" on email address or telephone number field
    When click Giriş Yap button
    Then "$missingTelephoneNumberMessage" element equals "Geçerli bir cep telefonu girmelisiniz"

  Scenario: Missing telephone number without clicking Giriş Yap button for login
    Given enter missing telephone number as "$missingTelephoneNumber" on email address or telephone number field
    Then "$missingTelephoneNumberMessage" element equals "Geçerli bir cep telefonu girmelisiniz"

  Scenario: Available prefix without 0 and extra digit telephone number for login
    Given enter available prefix without 0 and extra digit telephone number as "$wrongTelephoneNumber" on email address or telephone number field
    When click Giriş Yap button
    Then "$wrongTelephoneNumberMessage" element equals "Geçerli bir cep telefonu girmelisiniz"

  Scenario: Starting with 0 and having extra digits telephone number for Login
    Given enter Starting with 0 and having extra digits telephone number as "$longTelephoneNumber" on email address or telephone number field
    When click Giriş Yap button
    Then "$longTelephoneNumberMessage" element equals "Geçerli bir cep telefonu girmelisiniz"

  Scenario: Phone number with unavailable prefix for login
    Given enter phone number with unavailable prefix as "$unavailablePrefixTelephoneNumber" on email address or telephone number field
    When click Giriş Yap button
    Then "$unavailableTelephoneNumberMessage" element equals "Geçerli bir cep telefonu girmelisiniz"

