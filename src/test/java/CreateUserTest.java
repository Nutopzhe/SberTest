import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri("http://users.bugred.ru/tasks")
            .setBasePath("/rest/createuser")
            .setContentType(ContentType.JSON)
            .build();

    @DataProvider(name = "createNewUser")
    public Object[][] getData() {
        //случайная генерация имени и email
        String email = (UUID.randomUUID() + "@mail.com").replace("-", "");
        String name = (UUID.randomUUID().toString()).replace("-", "");
        
        //компании должны быть созданы заранее (каждый день компании затираются)
        List<Integer> companies = Arrays.asList(29, 31);
        List<Integer> tasks = Arrays.asList(12);
        String hobby = "Стрельба из лука";
        String phone = "8 999 123 45 67";
        String inn = "123456789012";

        User userReq = new User(email, name, tasks, companies, hobby, phone, inn);

        return new Object[][]{{userReq}};
    }

    @Test(testName = "Checking response fields when creating a user", dataProvider = "createNewUser")
    public void createUser(User userReq) {

        //отправка post запроса с созданными пользователем, и дальнейшей проверкой полей ответа
        given()
                .spec(SPEC)
                .body(userReq)
                .when().log().all().post()
                .then().log().all()
                .body("name", equalTo(userReq.getName()))
                .body("email", equalTo(userReq.getEmail()))
                .body("phone", equalTo(userReq.getPhone()))
                .body("hobby", equalTo(userReq.getHobby()));

    }
}
