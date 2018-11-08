package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.CheckpointPage;
import page.ConfirmPasswordPage;
import page.HomePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/*
1. Зайти на страницу и кликнуть Сменить пароль
2. Перейти на страницу смены пароля пройти верификацию
3. Ввести почту
4. Получить ссылку и вставить в окно
5. Перейти на страницу с вводом и подветждением пароль, верифицироваться
6. Ввести пароль и подтвердить пароль, отправить


 */
public class ChangePasswordTest extends BaseTest{

    public WebDriver webDriver;

    @Test
    public void changePassword (){

        ChangePasswordPage changePasswordPage = loginPage.changePassword();
        Assert.assertTrue(changePasswordPage.isPageLoaded(),"page.ChangePasswordPage page is not loaded.");
        CheckpointPage checkpointPage = changePasswordPage.checkpoint("serggrishkovedu@gmail.com");

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"PageChangePasswordLoaded is not loaded");

        String newPassword = "!QAZ@WSX";
        checkpointPage.inputNewPassword(newPassword);

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"Page for change password is not loaded");
        changePasswordPage.clickTransferToHeadPage();
        checkpointPage.logoutPage();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HomePage homePage = loginPage.login("serggrishkovedu@gmail.com", newPassword);
        Assert.assertTrue(homePage.isPageLoaded(),"page.HomePage is not displayed on Login Page!");

    }

    @Test
    public void prnt () {
        String a = "\"C:\\Program Files\\Java\\jdk-10.0.2\\bin\\java.exe\" -ea -Didea.test.cyclic.buffer.size=1048576 \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\lib\\idea_rt.jar=53098:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\bin\" -Dfile.encoding=UTF-8 -classpath \"C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\lib\\idea_rt.jar;C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\plugins\\testng\\lib\\testng-plugin.jar;C:\\Users\\SERG\\IdeaProjects\\qaauto-24.09.2018\\target\\test-classes;C:\\Users\\SERG\\IdeaProjects\\qaauto-24.09.2018\\target\\classes;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-java\\3.14.0\\selenium-java-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-api\\3.14.0\\selenium-api-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\3.14.0\\selenium-chrome-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-edge-driver\\3.14.0\\selenium-edge-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-firefox-driver\\3.14.0\\selenium-firefox-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-ie-driver\\3.14.0\\selenium-ie-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-opera-driver\\3.14.0\\selenium-opera-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-remote-driver\\3.14.0\\selenium-remote-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-safari-driver\\3.14.0\\selenium-safari-driver-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-support\\3.14.0\\selenium-support-3.14.0.jar;C:\\Users\\SERG\\.m2\\repository\\net\\bytebuddy\\byte-buddy\\1.8.15\\byte-buddy-1.8.15.jar;C:\\Users\\SERG\\.m2\\repository\\org\\apache\\commons\\commons-exec\\1.3\\commons-exec-1.3.jar;C:\\Users\\SERG\\.m2\\repository\\commons-codec\\commons-codec\\1.10\\commons-codec-1.10.jar;C:\\Users\\SERG\\.m2\\repository\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;C:\\Users\\SERG\\.m2\\repository\\com\\google\\guava\\guava\\25.0-jre\\guava-25.0-jre.jar;C:\\Users\\SERG\\.m2\\repository\\com\\google\\code\\findbugs\\jsr305\\1.3.9\\jsr305-1.3.9.jar;C:\\Users\\SERG\\.m2\\repository\\org\\checkerframework\\checker-compat-qual\\2.0.0\\checker-compat-qual-2.0.0.jar;C:\\Users\\SERG\\.m2\\repository\\com\\google\\errorprone\\error_prone_annotations\\2.1.3\\error_prone_annotations-2.1.3.jar;C:\\Users\\SERG\\.m2\\repository\\com\\google\\j2objc\\j2objc-annotations\\1.1\\j2objc-annotations-1.1.jar;C:\\Users\\SERG\\.m2\\repository\\org\\codehaus\\mojo\\animal-sniffer-annotations\\1.14\\animal-sniffer-annotations-1.14.jar;C:\\Users\\SERG\\.m2\\repository\\org\\apache\\httpcomponents\\httpclient\\4.5.5\\httpclient-4.5.5.jar;C:\\Users\\SERG\\.m2\\repository\\org\\apache\\httpcomponents\\httpcore\\4.4.9\\httpcore-4.4.9.jar;C:\\Users\\SERG\\.m2\\repository\\com\\squareup\\okhttp3\\okhttp\\3.10.0\\okhttp-3.10.0.jar;C:\\Users\\SERG\\.m2\\repository\\com\\squareup\\okio\\okio\\1.14.1\\okio-1.14.1.jar;C:\\Users\\SERG\\.m2\\repository\\org\\testng\\testng\\6.14.3\\testng-6.14.3.jar;C:\\Users\\SERG\\.m2\\repository\\com\\beust\\jcommander\\1.72\\jcommander-1.72.jar;C:\\Users\\SERG\\.m2\\repository\\org\\apache-extras\\beanshell\\bsh\\2.0b6\\bsh-2.0b6.jar;C:\\Users\\SERG\\.m2\\repository\\com\\sun\\mail\\javax.mail\\1.6.2\\javax.mail-1.6.2.jar;C:\\Users\\SERG\\.m2\\repository\\javax\\activation\\activation\\1.1\\activation-1.1.jar;C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\plugins\\testng\\lib\\jcommander.jar\" org.testng.RemoteTestNGStarter -usedefaultlisteners false -socket53097 @w@C:\\Users\\SERG\\AppData\\Local\\Temp\\idea_working_dirs_testng.tmp -temp C:\\Users\\SERG\\AppData\\Local\\Temp\\idea_testng.tmp\n" +
                "1541624155724\tmozrunner::runner\tINFO\tRunning command: \"C:\\\\Program Files\\\\Mozilla Firefox\\\\firefox.exe\" \"-marionette\" \"-foreground\" \"-no-remote\" \"-profile\" \"C:\\\\Users\\\\SERG\\\\AppData\\\\Local\\\\Temp\\\\rust_mozprofile.JCWY3MCw0JYQ\"\n" +
                "1541624156179\tMarionette\tDEBUG\tReceived observer notification profile-after-change\n" +
                "1541624156883\tMarionette\tDEBUG\tReceived observer notification toplevel-window-ready\n" +
                "1541624156904\tMarionette\tDEBUG\tReceived observer notification command-line-startup\n" +
                "1541624156904\tMarionette\tDEBUG\tReceived observer notification nsPref:changed\n" +
                "1541624156905\tMarionette\tDEBUG\tInit aborted (running=false, enabled=true, finalUIStartup=false)\n" +
                "1541624157903\tMarionette\tDEBUG\tReceived observer notification toplevel-window-ready\n" +
                "1541624159261\tMarionette\tDEBUG\tReceived observer notification sessionstore-windows-restored\n" +
                "1541624159261\tMarionette\tDEBUG\tWaiting for delayed startup...\n" +
                "1541624159333\tMarionette\tDEBUG\tSetting recommended pref security.turn_off_all_security_so_that_viruses_can_take_over_this_computer to true\n" +
                "1541624159334\tMarionette\tDEBUG\tSetting recommended pref apz.content_response_timeout to 60000\n" +
                "1541624159334\tMarionette\tDEBUG\tSetting recommended pref browser.download.panel.shown to true\n" +
                "1541624159334\tMarionette\tDEBUG\tSetting recommended pref browser.pagethumbnails.capturing_disabled to true\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.search.update to false\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref toolkit.cosmeticAnimations.enabled to false\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.tabs.disableBackgroundZombification to false\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.tabs.warnOnCloseOtherTabs to false\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.tabs.warnOnOpen to false\n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.usedOnWindows10.introURL to \n" +
                "1541624159335\tMarionette\tDEBUG\tSetting recommended pref browser.urlbar.suggest.searches to false\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref datareporting.policy.dataSubmissionPolicyAccepted to false\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref dom.disable_beforeunload to true\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref dom.disable_open_during_load to false\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref dom.file.createInChild to true\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref dom.max_chrome_script_run_time to 0\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref dom.max_script_run_time to 0\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref extensions.getAddons.cache.enabled to false\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref extensions.webservice.discoverURL to http://%(server)s/dummy/discoveryURL\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref network.http.prompt-temp-redirect to false\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref network.http.speculative-parallel-limit to 0\n" +
                "1541624159336\tMarionette\tDEBUG\tSetting recommended pref security.fileuri.strict_origin_policy to false\n" +
                "1541624159337\tMarionette\tDEBUG\tSetting recommended pref security.notification_enable_delay to 0\n" +
                "1541624159337\tMarionette\tDEBUG\tSetting recommended pref signon.autofillForms to false\n" +
                "1541624159337\tMarionette\tDEBUG\tSetting recommended pref signon.rememberSignons to false\n" +
                "1541624159375\tMarionette\tINFO\tListening on port 53108\n" +
                "1541624159375\tMarionette\tDEBUG\tRemote service is active\n" +
                "1541624159529\tMarionette\tDEBUG\tAccepted connection 0 from 127.0.0.1:53134\n" +
                "1541624159530\tMarionette\tTRACE\t0 -> [0,1,\"WebDriver:NewSession\",{\"acceptInsecureCerts\":true,\"browserName\":\"firefox\"}]\n" +
                "1541624159530\tMarionette\tWARN\tTLS certificate errors will be ignored for this session\n" +
                "1541624159565\tMarionette\tDEBUG\t[6442450945] Frame script loaded\n" +
                "1541624159565\tMarionette\tDEBUG\t[6442450945] Frame script registered\n" +
                "1541624159567\tMarionette\tTRACE\t0 <- [1,1,null,{\"sessionId\":\"e9586595-c9c2-4b61-9963-2cb67b5e07b3\",\"capabilities\":{\"browserName\":\"firefox\",\"browserVersion\":\"63.0. ... AppData\\\\Local\\\\Temp\\\\rust_mozprofile.JCWY3MCw0JYQ\",\"moz:useNonSpecCompliantPointerOrigin\":false,\"moz:webdriverClick\":true}}]\n" +
                "нояб. 07, 2018 10:55:59 ПП org.openqa.selenium.remote.ProtocolHandshake createSession\n" +
                "INFO: Detected dialect: W3C\n" +
                "1541624159704\tMarionette\tTRACE\t0 -> [0,2,\"WebDriver:Navigate\",{\"url\":\"https://www.linkedin.com/\"}]\n" +
                "1541624159711\tMarionette\tDEBUG\t[6442450945] Received DOM event beforeunload for about:blank\n" +
                "1541624160793\tMarionette\tDEBUG\t[6442450945] Received DOM event pagehide for about:blank\n" +
                "1541624161669\tMarionette\tDEBUG\t[6442450945] Received DOM event DOMContentLoaded for https://www.linkedin.com/\n" +
                "1541624161833\tMarionette\tDEBUG\t[6442450945] Received DOM event pageshow for https://www.linkedin.com/\n" +
                "1541624161847\tMarionette\tTRACE\t0 <- [1,2,null,{\"value\":null}]\n" +
                "1541624161928\tMarionette\tTRACE\t0 -> [0,3,\"WebDriver:FindElement\",{\"using\":\"xpath\",\"value\":\"//*[@class='link-forgot-password']\"}]\n" +
                "1541624161932\tMarionette\tTRACE\t0 <- [1,3,null,{\"value\":{\"element-6066-11e4-a52e-4f735466cecf\":\"c26c3df8-9b42-475e-8c72-07f4f7cf0d7c\"}}]\n" +
                "1541624161949\tMarionette\tTRACE\t0 -> [0,4,\"WebDriver:ElementClick\",{\"id\":\"c26c3df8-9b42-475e-8c72-07f4f7cf0d7c\"}]\n" +
                "1541624161963\tMarionette\tDEBUG\t[6442450945] Received DOM event beforeunload for https://www.linkedin.com/\n" +
                "1541624162290\tMarionette\tDEBUG\t[6442450945] Received DOM event pagehide for https://www.linkedin.com/\n" +
                "1541624162291\tMarionette\tDEBUG\t[6442450945] Received DOM event unload for https://www.linkedin.com/\n" +
                "1541624162354\tMarionette\tDEBUG\t[6442450945] Received observer notification outer-window-destroyed\n" +
                "1541624162381\tMarionette\tDEBUG\t[6442450945] Received DOM event DOMContentLoaded for https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\n" +
                "1541624162385\tMarionette\tDEBUG\t[6442450945] Received DOM event pageshow for https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\n" +
                "1541624162386\tMarionette\tTRACE\t0 <- [1,4,null,{\"value\":null}]\n" +
                "1541624165389\tMarionette\tTRACE\t0 -> [0,5,\"WebDriver:GetCurrentURL\",{}]\n" +
                "1541624165390\tMarionette\tTRACE\t0 <- [1,5,null,{\"value\":\"https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\"}]\n" +
                "1541624165396\tMarionette\tTRACE\t0 -> [0,6,\"WebDriver:GetCurrentURL\",{}]\n" +
                "1541624165396\tMarionette\tTRACE\t0 <- [1,6,null,{\"value\":\"https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\"}]\n" +
                "1541624165400\tMarionette\tTRACE\t0 -> [0,7,\"WebDriver:GetTitle\",{}]\n" +
                "1541624165406\tMarionette\tTRACE\t0 <- [1,7,null,{\"value\":\"Изменить пароль | LinkedIn\"}]\n" +
                "1541624165413\tMarionette\tTRACE\t0 -> [0,8,\"WebDriver:FindElement\",{\"using\":\"xpath\",\"value\":\"//*[@id=\\\"username\\\"]\"}]\n" +
                "1541624165415\tMarionette\tTRACE\t0 <- [1,8,null,{\"value\":{\"element-6066-11e4-a52e-4f735466cecf\":\"3dc0dbc7-30e5-433e-a5bc-72fdab5fa6eb\"}}]\n" +
                "1541624165446\tMarionette\tTRACE\t0 -> [0,9,\"WebDriver:ExecuteScript\",{\"args\":[{\"element-6066-11e4-a52e-4f735466cecf\":\"3dc0dbc7-30e5-433e-a5bc-72fdab5fa6eb\"}],\"newS ... dow!='undefined'?window.document:null}, arguments);}\\n).apply(null, arguments);\",\"scriptTimeout\":null,\"specialPowers\":false}]\n" +
                "1541624165461\tMarionette\tTRACE\t0 <- [1,9,null,{\"value\":true}]\n" +
                "1541624167022\tMarionette\tTRACE\t0 -> [0,10,\"WebDriver:FindElement\",{\"using\":\"xpath\",\"value\":\"//*[@id=\\\"username\\\"]\"}]\n" +
                "1541624167029\tMarionette\tTRACE\t0 <- [1,10,null,{\"value\":{\"element-6066-11e4-a52e-4f735466cecf\":\"3dc0dbc7-30e5-433e-a5bc-72fdab5fa6eb\"}}]\n" +
                "1541624167038\tMarionette\tTRACE\t0 -> [0,11,\"WebDriver:ElementSendKeys\",{\"id\":\"3dc0dbc7-30e5-433e-a5bc-72fdab5fa6eb\",\"text\":\"serggrishkovedu@gmail.com\",\"value\":[\"s\",\"e\",\"r\",\"g\",\"g\",\"r\",\"i\",\"s\",\"h\",\"k\",\"o\",\"v\",\"e\",\"d\",\"u\",\"@\",\"g\",\"m\",\"a\",\"i\",\"l\",\".\",\"c\",\"o\",\"m\"]}]\n" +
                "1541624167063\tMarionette\tTRACE\t0 <- [1,11,null,{\"value\":null}]\n" +
                "1541624167068\tMarionette\tTRACE\t0 -> [0,12,\"WebDriver:FindElement\",{\"using\":\"xpath\",\"value\":\"//*[@id=\\\"reset-password-submit-button\\\"]\"}]\n" +
                "1541624167070\tMarionette\tTRACE\t0 <- [1,12,null,{\"value\":{\"element-6066-11e4-a52e-4f735466cecf\":\"f0084f3a-aa3b-437a-bcf0-62b5abac2c57\"}}]\n" +
                "1541624167075\tMarionette\tTRACE\t0 -> [0,13,\"WebDriver:ElementClick\",{\"id\":\"f0084f3a-aa3b-437a-bcf0-62b5abac2c57\"}]\n" +
                "1541624167086\tMarionette\tDEBUG\t[6442450945] Received DOM event beforeunload for https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\n" +
                "1541624168291\tMarionette\tDEBUG\t[6442450945] Received DOM event pagehide for https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\n" +
                "1541624168293\tMarionette\tDEBUG\t[6442450945] Received DOM event unload for https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password\n" +
                "1541624168371\tMarionette\tDEBUG\t[6442450945] Received DOM event DOMContentLoaded for https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\n" +
                "1541624168389\tMarionette\tDEBUG\t[6442450945] Received DOM event pageshow for https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\n" +
                "1541624168389\tMarionette\tTRACE\t0 <- [1,13,null,{\"value\":null}]\n" +
                "Content: <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> <html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"ru\" xml:lang=\"ru\"> <head> <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"> <meta name=\"HandheldFriendly\" content=\"true\"> <meta name=\"viewport\" content=\"width=device-width; initial-scale=0.666667; maximum-scale=0.666667; user-scalable=0\"> <meta name=\"viewport\" content=\"width=device-width\"> <title></title> <!--[if mso]><style type=\"text/css\">body {font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;}.phoenix-email-container {width: 512px !important;}</style><![endif]--> <!--[if IE]><style type=\"text/css\">.phoenix-email-container {width: 512px !important;}</style><![endif]--> <style type=\"text/css\">@media only screen and (max-width:32em) { .phoenix-email-container { width:100% !important; } } @media only screen and (max-width:20em) {} @media only screen and (max-device-width:30em) {} @media screen and (device-width:30em) and (device-height:22.5em), screen and (device-width:22.5em) and (device-height:30em), screen and (device-width:20em) and (device-height:15em) {} @media screen and (-webkit-min-device-pixel-ratio:0) {} @media screen and (max-device-width:25.88em) and (max-device-height:48.5em) {} </style> </head> <body style=\"padding:0;margin:0 auto;-webkit-text-size-adjust:100%;width:100% !important;-ms-text-size-adjust:100%;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;\"> <div style=\"overflow:hidden;color:transparent;visibility:hidden;mso-hide:all;width:0;font-size:0;opacity:0;height:0;\"> Срок действия этой ссылки истечёт через 24&nbsp;часа </div> <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#EDF0F3\" style=\"background-color:#EDF0F3;table-layout:fixed;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td align=\"center\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <center style=\"width:100%;\"> <table border=\"0\" class=\"phoenix-email-container\" cellspacing=\"0\" cellpadding=\"0\" width=\"512\" bgcolor=\"#FFFFFF\" style=\"background-color:#FFFFFF;margin:0 auto;max-width:512px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;width:inherit;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td bgcolor=\"#F6F8FA\" style=\"background-color:#F6F8FA;padding:12px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;border-bottom:1px solid #ECECEC;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;width:100% !important;mso-table-lspace:0pt;-ms-text-size-adjust:100%;min-width:100% !important;\"> <tbody> <tr> <td align=\"left\" valign=\"middle\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"><a href=\"https://www.linkedin.com/comm/feed/?midToken=AQFbl_rMtF1W0Q&amp;trk=eml-security_password_reset_checkpoint-header-0-home&amp;trkEmail=eml-security_password_reset_checkpoint-header-0-home-null-bf32e8%7Ejo7n82zs%7Ek5-null-neptune%2Ffeed&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\"> <img alt=\"LinkedIn \" border=\"0\" src=\"https://static.licdn.com/scds/common/u/images/email/phoenix/logos/logo_phoenix_header_blue_78x66_v1.png\" height=\"34\" width=\"40\" style=\"outline:none;-ms-interpolation-mode:bicubic;color:#FFFFFF;text-decoration:none;\"></a></td> <td valign=\"middle\" width=\"100%\" align=\"right\" style=\"padding:0 0 0 10px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"><a href=\"https://www.linkedin.com/comm/in/serg-autotest-96829a173?midToken=AQFbl_rMtF1W0Q&amp;trk=eml-security_password_reset_checkpoint-header-5-profile&amp;trkEmail=eml-security_password_reset_checkpoint-header-5-profile-null-bf32e8%7Ejo7n82zs%7Ek5-null-neptune%2Fprofile%7Evanity%2Eview&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D\" style=\"cursor:pointer;margin:0;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\"> <span style=\"word-wrap:break-word;color:#4C4C4C;word-break:break-word;font-weight:400;-ms-word-break:break-all;font-size:14px;line-height:1.429;overflow-wrap:break-word;\">Serg AutoTest</span></a></td> <td width=\"1\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\">&nbsp;</td> </tr> </tbody> </table></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td style=\"padding:20px 24px 32px 24px;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <h2 style=\"margin:0;color:#262626;font-weight:700;font-size:20px;line-height:1.2;\">Здравствуйте, Serg!</h2></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Измените свой пароль, и мы поможем Вам исправить ситуацию.</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Чтобы изменить пароль в LinkedIn, нажмите <a href=\"https://www.linkedin.com/e/v2?e=bf32e8-jo7n82zs-k5&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D&amp;a=checkpoint-password-reset&amp;midToken=AQFbl_rMtF1W0Q&amp;tracking=eml-jav-saved-job&amp;ek=security_password_reset_checkpoint&amp;encryptedEmail=AgGpAsld5XCiNgAAAWbv9fQU3NmoL83GXvcYaBNbULEQdGq4g_sTJ1yhvm4wllxffxk39Y0M5t_R1_o&amp;requestSubmissionId=AgFk0ckN5vIyYQAAAWbv9fQcNQ3oiNNiowrHUXRWC4dSc4ajAPL-_FY_NieJ7L5KfEZC4Y6b_IjpSe1UY2YgeGDL4SYSv2cAnZ5KIIo413I&amp;oneTimeToken=7074851998674137427&amp;_sig=0wzlzLCnsE3Ew1\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">здесь</a> или вставьте в адресную строку браузера следующую ссылку:</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">https://www.linkedin.com/e/v2?e=bf32e8-jo7n82zs-k5&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D&amp;a=checkpoint-password-reset&amp;midToken=AQFbl_rMtF1W0Q&amp;tracking=eml-jav-saved-job&amp;ek=security_password_reset_checkpoint&amp;encryptedEmail=AgGpAsld5XCiNgAAAWbv9fQU3NmoL83GXvcYaBNbULEQdGq4g_sTJ1yhvm4wllxffxk39Y0M5t_R1_o&amp;requestSubmissionId=AgFk0ckN5vIyYQAAAWbv9fQcNQ3oiNNiowrHUXRWC4dSc4ajAPL-_FY_NieJ7L5KfEZC4Y6b_IjpSe1UY2YgeGDL4SYSv2cAnZ5KIIo413I&amp;oneTimeToken=7074851998674137427&amp;_sig=0wzlzLCnsE3Ew1</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Срок действия этой ссылки истечёт через 24&nbsp;часа, поэтому воспользуйтесь ею прямо сейчас.</p></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;padding-bottom:20px;\"> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">Благодарим за использование LinkedIn,</p> <p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\">коллектив компании LinkedIn</p></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#EDF0F3\" align=\"center\" style=\"background-color:#EDF0F3;padding:0 24px;color:#6A6C6D;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <tbody> <tr> <td align=\"center\" style=\"padding:16px 0 0 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"></td> </tr> <tr> <td style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;\"> <tbody> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;color:#6A6C6D;font-weight:400;font-size:12px;line-height:1.333;\"></p></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;word-wrap:break-word;color:#6A6C6D;word-break:break-word;font-weight:400;-ms-word-break:break-all;font-size:12px;line-height:1.333;overflow-wrap:break-word;\">Это сообщение адресовано участнику Serg AutoTest (Automation Technician – test). <a href=\"https://www.linkedin.com/e/v2?e=bf32e8-jo7n82zs-k5&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D&amp;a=customerServiceUrl&amp;midToken=AQFbl_rMtF1W0Q&amp;ek=security_password_reset_checkpoint&amp;articleId=4788\" style=\"cursor:pointer;color:#6A6C6D;-webkit-text-size-adjust:100%;text-decoration:underline;display:inline-block;-ms-text-size-adjust:100%;\">Что это значит?</a></p></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 8px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"><a href=\"https://www.linkedin.com/comm/feed/?midToken=AQFbl_rMtF1W0Q&amp;trk=eml-security_password_reset_checkpoint-footer-2-home&amp;trkEmail=eml-security_password_reset_checkpoint-footer-2-home-null-bf32e8%7Ejo7n82zs%7Ek5-null-neptune%2Ffeed&amp;lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BX8t67m%2FxT1SAoglwmiQoQQ%3D%3D\" style=\"cursor:pointer;color:#6A6C6D;-webkit-text-size-adjust:100%;text-decoration:underline;display:inline-block;-ms-text-size-adjust:100%;\"><img alt=\"LinkedIn \" border=\"0\" height=\"14\" src=\"https://static.licdn.com/scds/common/u/images/email/phoenix/logos/logo_phoenix_footer_darkgray_197x48_v1.png\" width=\"58\" style=\"outline:none;-ms-interpolation-mode:bicubic;color:#FFFFFF;display:block;text-decoration:none;\"></a></td> </tr> <tr> <td align=\"center\" style=\"padding:0 0 12px 0;-webkit-text-size-adjust:100%;mso-table-rspace:0pt;mso-table-lspace:0pt;-ms-text-size-adjust:100%;text-align:center;\"> <p style=\"margin:0;color:#6A6C6D;font-weight:400;font-size:12px;line-height:1.333;\">© 2018 LinkedIn Ireland Unlimited Company, Wilton Plaza, Wilton Place, Dublin 2. LinkedIn является зарегистрированным фирменным наименованием LinkedIn Ireland Unlimited Company. LinkedIn и эмблема LinkedIn являются товарными знаками компании LinkedIn.</p></td> </tr> </tbody> </table></td> </tr> </tbody> </table></td> </tr> </tbody> </table> </center></td> </tr> </tbody> </table> <img src=\"https://www.linkedin.com/emimp/ip_WW1Zek1tVTRMV3B2TjI0NE1ucHpMV3MxOmMyVmpkWEpwZEhsZmNHRnpjM2R2Y21SZmNtVnpaWFJmWTJobFkydHdiMmx1ZEE9PTo=.gif\" style=\"outline:none;-ms-interpolation-mode:bicubic;color:#FFFFFF;text-decoration:none;width:1px;height:1px;\"> </body> </html>\n" +
                "1541624178366\tMarionette\tTRACE\t0 -> [0,14,\"WebDriver:GetCurrentURL\",{}]\n" +
                "1541624178367\tMarionette\tTRACE\t0 <- [1,14,null,{\"value\":\"https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\"}]\n" +
                "1541624178376\tMarionette\tTRACE\t0 -> [0,15,\"WebDriver:GetTitle\",{}]\n" +
                "1541624178377\tMarionette\tTRACE\t0 <- [1,15,null,{\"value\":\"Проверьте, получили ли вы сообщение эл. почты со ссылкой для изменения пароля. | LinkedIn\"}]\n" +
                "1541624178388\tMarionette\tTRACE\t0 -> [0,16,\"WebDriver:FindElement\",{\"using\":\"xpath\",\"value\":\"//*[@id=\\\"resend-url\\\"]\"}]\n" +
                "1541624178394\tMarionette\tTRACE\t0 <- [1,16,null,{\"value\":{\"element-6066-11e4-a52e-4f735466cecf\":\"7cc28501-2292-49e6-9ba1-a700ca39e061\"}}]\n" +
                "1541624178408\tMarionette\tTRACE\t0 -> [0,17,\"WebDriver:ExecuteScript\",{\"args\":[{\"element-6066-11e4-a52e-4f735466cecf\":\"7cc28501-2292-49e6-9ba1-a700ca39e061\"}],\"new ... dow!='undefined'?window.document:null}, arguments);}\\n).apply(null, arguments);\",\"scriptTimeout\":null,\"specialPowers\":false}]\n" +
                "1541624178426\tMarionette\tTRACE\t0 <- [1,17,null,{\"value\":true}]\n" +
                "1541624181433\tMarionette\tTRACE\t0 -> [0,18,\"WebDriver:Navigate\",{\"url\":\"https://www.linkedin.com/e/v2?e=bf32e8-jo4lfsk8-4r&lipi=urn%3Ali%3Apage%3Aemail_security_p ... ANaleAikhmMNoqMMZ5F4dkrXvHc_RSS9_vErK4olVn3gmNruycedYz9sdi9n5qqUTA3o&oneTimeToken=-2121975437222171256&_sig=0wjBGfmAQC0Ew1\"}]\n" +
                "1541624181444\tMarionette\tDEBUG\t[6442450945] Received DOM event beforeunload for https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\n" +
                "1541624181997\tMarionette\tDEBUG\t[6442450945] Received DOM event pagehide for https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\n" +
                "1541624181998\tMarionette\tDEBUG\t[6442450945] Received DOM event unload for https://www.linkedin.com/checkpoint/rp/request-password-reset-submit\n" +
                "1541624182045\tMarionette\tDEBUG\t[6442450945] Received DOM event DOMContentLoaded for https://www.linkedin.com/checkpoint/rp/request-password-reset?report%2Efailure=rW3axyeYczUiP2UIxCCxwh_d06nwEmS0BE43YhNA5Pw85YArKJ0fRUvmJqKCpPA8b08nBxkO0rno5JAr7JafRcvmfqj85XA_7JA5UOvqHq3yXPj9wD\n" +
                "1541624182055\tMarionette\tDEBUG\t[6442450945] Received DOM event pageshow for https://www.linkedin.com/checkpoint/rp/request-password-reset?report%2Efailure=rW3axyeYczUiP2UIxCCxwh_d06nwEmS0BE43YhNA5Pw85YArKJ0fRUvmJqKCpPA8b08nBxkO0rno5JAr7JafRcvmfqj85XA_7JA5UOvqHq3yXPj9wD\n" +
                "1541624182056\tMarionette\tTRACE\t0 <- [1,18,null,{\"value\":null}]\n" +
                "1541624185063\tMarionette\tTRACE\t0 -> [0,19,\"WebDriver:GetCurrentURL\",{}]\n" +
                "1541624185065\tMarionette\tTRACE\t0 <- [1,19,null,{\"value\":\"https://www.linkedin.com/checkpoint/rp/request-password-reset?report%2Efailure=rW3axyeYczUiP2UIxCCxwh_d06nwEmS0BE43YhNA5Pw85YArKJ0fRUvmJqKCpPA8b08nBxkO0rno5JAr7JafRcvmfqj85XA_7JA5UOvqHq3yXPj9wD\"}]\n" +
                "\n" +
                "java.lang.AssertionError: PageChangePasswordLoaded is not loaded expected [true] but found [false]\n" +
                "Expected :true\n" +
                "Actual   :false\n" +
                " <Click to see difference>\n" +
                "\n" +
                "\n" +
                "\tat org.testng.Assert.fail(Assert.java:96)\n" +
                "\tat org.testng.Assert.failNotEquals(Assert.java:776)\n" +
                "\tat org.testng.Assert.assertTrue(Assert.java:44)\n" +
                "\tat test.ChangePasswordTest.changePassword(ChangePasswordTest.java:51)\n" +
                "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n" +
                "\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\n" +
                "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)\n" +
                "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:583)\n" +
                "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)\n" +
                "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)\n" +
                "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\n" +
                "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\n" +
                "\tat org.testng.TestRunner.privateRun(TestRunner.java:648)\n" +
                "\tat org.testng.TestRunner.run(TestRunner.java:505)\n" +
                "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:455)\n" +
                "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)\n" +
                "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)\n" +
                "\tat org.testng.SuiteRunner.run(SuiteRunner.java:364)\n" +
                "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
                "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)\n" +
                "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)\n" +
                "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1137)\n" +
                "\tat org.testng.TestNG.runSuites(TestNG.java:1049)\n" +
                "\tat org.testng.TestNG.run(TestNG.java:1017)\n" +
                "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
                "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
                "\n" +
                "\n" +
                "===============================================\n" +
                "Default Suite\n" +
                "Total tests run: 1, Failures: 1, Skips: 0\n" +
                "===============================================\n" +
                "\n" +
                "\n" +
                "Process finished with exit code 0\n";

        Pattern p = Pattern.compile("Чтобы изменить пароль в LinkedIn, нажмите <a href=\"([[^\"].]{0,})\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(a);
        if (m.find()) {
            String link = m.group(1);
            link = link.replaceAll("&amp;", "&");
            System.out.println(link);
        }

    }

}
