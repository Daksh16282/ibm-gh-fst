package fst;

abstract class Book {

	String title;

	abstract public void setTitle(String title);

	public String getTitle() {
		return this.title;
	}

}

class MyBook extends Book {

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

}

public class Activity5 {

	public static void main(String[] args) {

		MyBook newNovelBook = new MyBook();
		newNovelBook.setTitle("Banta Rikshe Vala");
		System.out.println(newNovelBook.getTitle());

	}

}
