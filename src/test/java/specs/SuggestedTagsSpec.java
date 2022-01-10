package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class SuggestedTagsSpec {
    public static RequestSpecification suggestedTagsRequest = with()
            .basePath("/api/composer-api.bx/_action")
            .filter(customLogFilter().withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification suggestedTagsResponse = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("shemas/getSuggestedTapTagsShema.json"))
//            .expectBody(containsString("suggestedTapTags"))
            .expectBody("suggestedTapTags.items", hasSize(greaterThan(0)))
            .build();
}
