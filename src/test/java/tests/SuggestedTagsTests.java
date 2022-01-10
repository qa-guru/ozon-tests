package tests;

import io.restassured.response.Response;
import models.CellTrackingInfo;
import models.SuggestedTag;
import models.SuggestedTapTags;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static specs.SuggestedTagsSpec.suggestedTagsRequest;
import static specs.SuggestedTagsSpec.suggestedTagsResponse;

public class SuggestedTagsTests extends TestBase {
    @Test
    void getSuggestedTapTagsTest() {
        String searchTag = "lenovo";
        //         String data = "{\"text\":\"lenovo\"}";
        SuggestedTag suggestedTag = new SuggestedTag();
        suggestedTag.setText(searchTag);

        SuggestedTapTags response =
                given()
                        .spec(suggestedTagsRequest)
                        .body(suggestedTag)
                        .when()
                        .post("/getSuggestedTapTags")
                        .then()
                        .spec(suggestedTagsResponse)
                        .extract().as(SuggestedTapTags.class);

        System.out.println(response);
        CellTrackingInfo item = response.getSuggestedTapTags()

    }
}
