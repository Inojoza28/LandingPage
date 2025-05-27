package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Product;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class ProductController extends Controller {
    
    public Result getAll() {
        List<Product> products = Product.findAll();
        return ok(Json.toJson(products));
    }
    
    public Result getById(Long id) {
        Product product = Product.find.byId(id);
        if (product == null) {
            return notFound("Produto não encontrado");
        }
        return ok(Json.toJson(product));
    }
}
