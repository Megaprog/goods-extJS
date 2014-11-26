package goods.controller;

import goods.model.Goods;
import goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    protected GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Goods> getCars(String search) {
        return goodsService.getGoods(search);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ExtResult setCar(@RequestBody Goods goods) {
        return new ExtResult(goodsService.add(goods), goods);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteCar(@RequestBody Goods goods) {
        goodsService.delete(goods);
        return "delete";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ExtResult updateCar(@RequestBody Goods goods) {
        return new ExtResult(goodsService.update(goods), goods);
    }

    public static class ExtResult {
        private boolean success;
        private Goods data;


        public ExtResult(boolean success, Goods data) {
            this.success = success;
            this.data = data;
        }

        public ExtResult() {
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Goods getData() {
            return data;
        }

        public void setData(Goods data) {
            this.data = data;
        }
    }
}
