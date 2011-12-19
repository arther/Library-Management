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

	public static void addItem() {
		render();

	}

	public static void addItemToLibrary(String title, String creator) {

		Item item = new Book(title, creator);
		String result = null;
		if (library.addItem(item))
			result = "Item added Successfully";
		else
			result = "Item is not added..";
		render(result);
	}

	// public static void issueItemToLibrary(String title, String creator) {
	//		
	// Item item = new Book(title, creator);
	// String result = null;
	// library.issueItem(item);
	// }

	public static void issueItem() {
		render();
	}

	public static void issueItemResult(String itemId) {
		library.issueItem(library.getItemById(itemId));

	}

	public static void getItemsByTitle() {
		render();
	}

	public static void getItemsByTitleResult(String title) {
		List list = Item.getItemsByTitle(title);
		render(list);
	}

	public static void getItemsByCreator() {
		render();
	}

	public static void getItemsByCreatorResult(String creator) {
		List list = Item.findItemByCreator(creator);
		render(list);
	}

	public static void getItemListByCreator(String creator) {
		render(Item.findItemByCreator(creator), ItemRegistry
				.findItemByCreator(creator));

	}

	public static void getCreatorForSearch() {
		render();
	}

}
