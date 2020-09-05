package my.spring.sample.coupon;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class}) // https://docs.spring.io/spring-restdocs/docs/2.0.3.RELEASE/reference/html5/#getting-started-documentation-snippets-setup-junit-5
@WebMvcTest(CouponController.class)
@AutoConfigureRestDocs
//@SpringBootTest(classes = RestDocsSampleApplication.class) // https://stackoverflow.com/questions/41057602/spring-boot-1-4-testing-configuration-error-found-multiple-declarations-of-b
class CouponControllerTests {

    private MockMvc mockMvc;

    @MockBean
    private CouponController couponController;

    // mockMvc 설정
    // documentationConfiguration(다양한 커스터마이징 설정 가능): https://docs.spring.io/spring-restdocs/docs/2.0.3.RELEASE/reference/html5/#configuration
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentationContextProvider)
                        .snippets().withEncoding("UTF-8") // https://docs.spring.io/spring-restdocs/docs/1.2.6.RELEASE/reference/html5/#configuration-snippet-encoding
                            .and()
                        .operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint())
                ).build();
    }

    @Test
    @DisplayName("모든 쿠폰 조회")
    void getAllCoupon() throws Exception{
        List<Coupon> couponListByUserId = Arrays.asList(
                new Coupon(3, "추석 쿠폰", 30),
                new Coupon(5, "설날 쿠폰", 55));

        int userId = 5;
        Object json = new Object() { public List<Coupon> couponList = couponListByUserId; };
        when(couponController.getAllCoupon(userId)).thenReturn(ResponseEntity.ok(json));

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/coupon/{userId}", userId)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("get-all-coupon",
                        pathParameters(
                                parameterWithName("userId").description("사용자 아이디")
                        ),
                        requestHeaders(
//                                headerWithName(HttpHeaders.AUTHORIZATION).description("Bearer Token"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("컨텐츠 타입")
                        ),
//                        requestFields(
//                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("컨텐츠 타입")
                        ),
                        responseFields(
                                fieldWithPath("couponList.[]").type(JsonFieldType.ARRAY).description("쿠폰 리스트"),
                                fieldWithPath("couponList[].id").type(JsonFieldType.NUMBER).description("쿠폰 아이디"),
                                fieldWithPath("couponList[].name").type(JsonFieldType.STRING).description("쿠폰 이름"),
                                fieldWithPath("couponList[].discountValue").type(JsonFieldType.NUMBER).description("할인율")
                        )
                ));
    }
//
//    @Test
//    @DisplayName("신규 쿠폰 생성")
//    void createCoupon() {
//    }
//
//    @Test
//    @DisplayName("쿠폰 할인율 업데이터")
//    void updateCouponDiscount() {
//    }
//
//    @Test
//    @DisplayName("쿠폰 삭제")
//    void deleteCoupon() {
//    }
}