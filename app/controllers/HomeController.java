package controllers;

import models.Product;
import models.Revenue;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class HomeController extends Controller {

    public Result index() {
        List<Product> products = Product.findAll();
        List<Revenue> revenues = Revenue.findAll();
        return ok(views.html.index.render(products, revenues));
    }
}
