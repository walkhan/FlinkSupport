//import com.weiwan.support.runtime.SupportAppEnter;

/**
 * @Author: xiaozhennan
 * @Date: 2020/11/3 13:48
 * @Package: PACKAGE_NAME.TestEnter
 * @ClassName: TestEnter
 * @Description:
 **/
public class TestEnter {

    public static void main(String[] args) throws Exception {
        args = new String[5];
        args[0] = "-logLevel";
        args[1] = "INFO";
        args[2] = "-x";
        args[3] = "-jobConf";
        args[4] = "eyJldGwucHJvY2Vzc2VyLm5hbWUiOiJleGFtcGxlY2hhbm5sZSIsImFwcC5zcWxNb2RlIjoiZmFsc2UiLCJldGwucHJvY2Vzc2VyLnBhcmFsbGVsaXNtIjoiMSIsImZsaW5rLnRhc2suY29tbW9uLnBhcmFsbGVsaXNtIjoiMSIsImhhZG9vcENvbmZpZ3VyYXRpb24iOnsiZmluYWxQYXJhbWV0ZXJzIjpbIm1hcHJlZHVjZS5qb2IuZW5kLW5vdGlmaWNhdGlvbi5tYXgucmV0cnkuaW50ZXJ2YWwiLCJoYWRvb3Auc3NsLnJlcXVpcmUuY2xpZW50LmNlcnQiLCJoYWRvb3Auc3NsLmNsaWVudC5jb25mIiwiaGFkb29wLnNzbC5zZXJ2ZXIuY29uZiIsIm1hcHJlZHVjZS5qb2IuZW5kLW5vdGlmaWNhdGlvbi5tYXguYXR0ZW1wdHMiLCJoYWRvb3Auc3NsLmtleXN0b3Jlcy5mYWN0b3J5LmNsYXNzIl19LCJldGwud3JpdGVyLmJhdGNoV3JpdGVTaXplIjoiMTAwIiwiZmxpbmsudGFzay5jaGVja3BvaW50Lm1vZGUiOiJFWEFDVExZX09OQ0UiLCJIQURPT1BfVVNFUl9OQU1FIjoiZWFzeWxpZmUiLCJmbGluay50YXNrLmNvbW1vbi5yZXN0YXJ0TW9kZSI6Im5vbmUiLCJmbGluay50YXNrLmNoZWNrcG9pbnQuaW50ZXJ2YWwiOiI2MDAwMCIsImV0bC5yZWFkZXIubmFtZSI6ImV4YW1wbGVyZWFkZXIiLCJTQ0FMQV9WRVJTSU9OIjoiMi4xMSIsImZsaW5rLnRhc2suY2hlY2twb2ludC5leHRlcm5hbGl6ZWQuZW5hYmxlIjoiZmFsc2UiLCJldGwucHJvY2Vzc2VyLmV4YW1wbGUuY2hhbm5lbFZhciI6ImNoYW5uZWxfdmFyIiwiZmxpbmsudGFzay5jb21tb24ucmVzdGFydEZhaWxNYXhOdW0iOiIxIiwiZXRsLnJlYWRlci5leGFtcGxlLmVuZEluZGV4IjoiMTAwMCIsImZsaW5rLnRhc2sudHlwZSI6InN0cmVhbSIsImFwcC5hcHBDbGFzcyI6ImNvbS53ZWl3YW4udGVzdGVyLnJ1bi5UYXN0ZXJBcHAiLCJmbGluay50YXNrLnN0YXRlQmFja2VuZC50eXBlIjoiTWVtb3J5IiwiZmxpbmtDb25maWd1cmF0aW9uIjp7fSwiZmxpbmsudGFzay5jaGVja3BvaW50LmVuYWJsZSI6ImZhbHNlIiwiYXBwLm5hbWUiOiJGbGlua1N1cHBvcnRFdGwiLCJhcHAuZXRsTW9kZSI6InRydWUiLCJldGwud3JpdGVyLnBhcmFsbGVsaXNtIjoiMSIsImZsaW5rLnRhc2suY2hlY2twb2ludC5leHRlcm5hbGl6ZWQuY2xlYW5VcCI6IkRFTEVURV9PTl9DQU5DRUxMQVRJT04iLCJhcHAuYXBwTmFtZSI6IlRlc3RBcHAiLCJldGwud3JpdGVyLmJhdGNoV3JpdGVNb2RlIjoiZmFsc2UiLCJGTElOS19IT01FIjoiL2hvbWUvZWFzeWxpZmUvYXBwcy9mbGluay0xLjExLjEiLCJmbGluay50YXNrLmNvbW1vbi5yZXN0YXJ0TnVtIjoiMSIsImZsaW5rLnRhc2suY2hlY2twb2ludC50aW1lb3V0IjoiNjAwMDAiLCJmbGluay50YXNrLnN0YXRlQmFja2VuZC5hc3luYyI6InRydWUiLCJmbGluay50YXNrLm5hbWUiOiJUZXN0QXBwIiwiZmxpbmsudGFzay5jaGVja3BvaW50Lm1heENvbmN1cnJlbnQiOiIxIiwiZXRsLndyaXRlci5uYW1lIjoiZXhhbXBsZXdyaXRlciIsImZsaW5rLnRhc2suY29tbW9uLnJlc3RhcnRJbnRlcnZhbCI6IjMwMDAwIiwiZXRsLnJlYWRlci5wYXJhbGxlbGlzbSI6IjEiLCJ5YXJuQ29uZmlndXJhdGlvbiI6eyJmaW5hbFBhcmFtZXRlcnMiOltdfSwiZmxpbmsudGFzay5jaGVja3BvaW50Lm1pbkludGVydmFsIjoiNTAwIiwiYXBwLmFwcFR5cGUiOiJzdHJlYW0iLCJIQURPT1BfSE9NRSI6Ii9vcHQvY2xvdWRlcmEvcGFyY2Vscy9DREgvbGliL2hhZG9vcCIsImZsaW5rLnRhc2suY29tbW9uLnF1ZXVlIjoicm9vdC51c2Vycy5lYXN5bGlmZSIsIkZMSU5LX1ZFUlNJT04iOiIxLjExLjEiLCJmbGluay50YXNrLmNoZWNrcG9pbnQub25GYWlsIjoidHJ1ZSIsImV0bC53cml0ZXIuZXhhbXBsZS53cml0ZXJWYXIiOiJ3cml0ZXJfdmFyIn0=";

//        SupportAppEnter.main(args);

    }

}
