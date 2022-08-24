package DealX.web;

//import javafx.scene.input.KeyCode;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.awt.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class test {
    public test() throws AWTException {
    }

    public static void main(String[] args) throws AWTException {

//        Robot r = new Robot();
//
//        int mask = InputEvent.BUTTON1_DOWN_MASK;
//        r.mouseMove(1000, 1000);
//        r.mousePress(mask);
//        r.mouseRelease(mask);

        Response response = get("https://ptgbr.mybronte.co.uk/redirect/credit_staq?p=ZmQyOTVlNDc4OTFiNmUwNzNmN2Q0YWVjNGUxMzQ4Njg0ZWIxZjNlYjk1YzNkZmQ3ZmQ2ZWFiNDcwN2I3OTU3MQ");

        given().header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().response().then().statusCode(200).
                log();

        String body = response.getBody().asString();

        System.out.println(body);
    }
}

