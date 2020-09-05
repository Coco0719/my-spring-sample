package my.spring.sample.coupon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @GetMapping("/{userId}")
    public ResponseEntity getAllCoupon(@PathVariable(value = "userId") int userId) {
        List<Coupon> couponlist = new ArrayList<Coupon>();
        couponlist.add(new Coupon(3, "추석 쿠폰", 30));
        couponlist.add(new Coupon(5, "설날 쿠폰", 55));
        Object json = new Object() {
            public List<Coupon> couponList = couponlist;
        };
        return ResponseEntity.ok(json);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody int userId) {
        Coupon newCoupon = new Coupon(4, "생일 축하 쿠폰", 100);
        return newCoupon;
    }

    @PutMapping("/{userId}/{couponId}/{discount}")
    public Coupon updateCouponDiscount(@PathVariable(value = "userId") int userId,
                                       @PathVariable(value = "couponId") int couponId,
                                       @PathVariable(value = "discount") int updatedDiscount) {
        Coupon updatedCoupon = new Coupon(couponId, "생일 축하 쿠폰", updatedDiscount);
        return updatedCoupon;
    }

    @PutMapping("/{userId}/{couponId}")
    public Coupon deleteCoupon(@PathVariable(value = "userId") int userId,
                               @PathVariable(value = "couponId") int couponId) {
        Coupon deletedConpon = new Coupon(couponId, "생일 축하 쿠폰", 100);
        return deletedConpon;
    }
}
