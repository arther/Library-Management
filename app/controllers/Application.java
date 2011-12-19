package controllers;

import play.*;
import play.mvc.*;

import java.sql.ResultSet;
import java.util.*;

import models.*;

public class Application extends Controller {
	public static Library library = new Library();

    public static void index() {
        render();
    }

	public static void addItem(Item item) {
		item.save();
	}

	public static void getItemListByCreator(String creator){
		List resultList =  library.findItemByCreator(creator);
		render(resultList);
	}
	
	public static void getCreatorForSearch(){
		render();
	}
	
}