import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class LogoutApiTest {

    @Test
    public void testLogoutApiResponse() {
        Response response = given()
                .when()
                .get("https://qauto.forstudy.space/api/auth/logout")
                .then()
                .extract().response();

        // Отримання статус-коду і тіла відповіді
        int statusCode = response.getStatusCode();
        String status = response.jsonPath().getString("status");

        // Використання SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Перевірка статус-коду");
        softAssert.assertEquals(status, "ok", "Перевірка значення status у тілі");

        // Важливо: завершити soft assert
        softAssert.assertAll();
    }
}
