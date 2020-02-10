package chapter03_0108;

public class SongApp {

	public static void main(String[] args) {
		
		Song song = new Song();
		
		song.setTitle("좋은날");
		song.setAlbum("Real");
		song.setArtist("아이유");
		song.setComposer("이민수");
		song.setYear(2010);
		song.setTrack(3);
		
		song.show();
		globalTest();
		Global.globalFunc();
		
		Song song2 = new Song("Blueming","아이유",null,null,0,0);
		song2.show();
		
		Song song3 = new Song("Square(2017)","백예린");
		song3.show();
	}
	
	public static void globalTest() {
		System.out.println(Global.globalVar);
	}
	
}
