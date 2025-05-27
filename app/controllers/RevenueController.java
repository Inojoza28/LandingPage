package controllers;

import models.Revenue;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class RevenueController extends Controller {
    
    public Result getAll() {
        List<Revenue> revenues = Revenue.findAll();
        return ok(Json.toJson(revenues));
    }
}
