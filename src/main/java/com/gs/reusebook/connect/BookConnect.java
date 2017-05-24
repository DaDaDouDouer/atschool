package com.gs.reusebook.connect;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import com.gs.reusebook.bean.Book;
import com.gs.reusebook.util.BookConnectProperty;
import com.gs.reusebook.util.HttpUtil;
/**
 * 书籍信息Connect
 * @author HughDing
 *
 */
@Component
public class BookConnect {
	/**
	 * 从接口获取书籍信息
	 * @param isbn
	 * @return
	 */
	public Book getBookInformation(String isbn){
		String serverUrl = BookConnectProperty.getValue("book_url");
		long timeout = Long.parseLong(BookConnectProperty.getValue("book_timeout"));
		serverUrl = serverUrl + isbn;
		try {
			String responseBody = HttpUtil.doGet(serverUrl, timeout);
			System.out.println(responseBody);
			ObjectMapper mapper = new ObjectMapper().configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			BookInformationResponse response = mapper.readValue(responseBody, BookInformationResponse.class);
			
			Book book = new Book();
			book.setName(response.getTitle());
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < response.getAuthor().length; i++)
				sb. append(response.getAuthor()[i] + " ");
	        String author = sb.toString();
	        book.setAuthor(author);
			book.setIsbn(response.getIsbn13());
			book.setImgUrl(response.getImage());
			List<String> types = new LinkedList<String>();
			for(int i = 0; i < response.getTags().length; i++){
				types.add(response.getTags()[i].name);
			}
			book.setTypes(types);
			book.setDescription(response.getSummary());
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static class ImageDTO{
		private String small;
		private String large;
		private String medium;
		
		public String getSmall() {
			return small;
		}
		public void setSmall(String small) {
			this.small = small;
		}
		public String getLarge() {
			return large;
		}
		public void setLarge(String large) {
			this.large = large;
		}
		public String getMedium() {
			return medium;
		}
		public void setMedium(String medium) {
			this.medium = medium;
		}
	}
	public static class RatingDTO{
		private Integer max;
		private Integer min;
		private Integer numRaters;
		private Double average;
		public Integer getMax() {
			return max;
		}
		public void setMax(Integer max) {
			this.max = max;
		}
		public Integer getMin() {
			return min;
		}
		public void setMin(Integer min) {
			this.min = min;
		}
		public Integer getNumRaters() {
			return numRaters;
		}
		public void setNumRaters(Integer numRaters) {
			this.numRaters = numRaters;
		}
		public Double getAverage() {
			return average;
		}
		public void setAverage(Double average) {
			this.average = average;
		}
	}
	public static class TagDTO{
		private Integer count;
		private String name;
		private String title;
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
	public static class SeriesDTO{
		private String id;
		private String title;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
	public static class BookInformationResponse{
		private String id;
		private String isbn10;
		private String isbn13;
		private String title;
		private String origin_title;
		private String alt_title;
		private String subtitle;
		private String url;
		private String alt;
		private String image;
		private ImageDTO images;
		private String[] author;
		private String[] translator;
		private String publisher;
		private String pubdate;
		private RatingDTO rating;
		private TagDTO[] tags;
		private String binding;
		private String price;
		private SeriesDTO series;
		private Integer pages;
		private String author_intro;
		private String summary;
		private String catalog;
		private String ebook_url;
		private Double ebook_price;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIsbn10() {
			return isbn10;
		}
		public void setIsbn10(String isbn10) {
			this.isbn10 = isbn10;
		}
		public String getIsbn13() {
			return isbn13;
		}
		public void setIsbn13(String isbn13) {
			this.isbn13 = isbn13;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getOrigin_title() {
			return origin_title;
		}
		public void setOrigin_title(String origin_title) {
			this.origin_title = origin_title;
		}
		public String getAlt_title() {
			return alt_title;
		}
		public void setAlt_title(String alt_title) {
			this.alt_title = alt_title;
		}
		public String getSubtitle() {
			return subtitle;
		}
		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getAlt() {
			return alt;
		}
		public void setAlt(String alt) {
			this.alt = alt;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public ImageDTO getImages() {
			return images;
		}
		public void setImages(ImageDTO images) {
			this.images = images;
		}
		public String[] getAuthor() {
			return author;
		}
		public void setAuthor(String[] author) {
			this.author = author;
		}
		public String[] getTranslator() {
			return translator;
		}
		public void setTranslator(String[] translator) {
			this.translator = translator;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getPubdate() {
			return pubdate;
		}
		public void setPubdate(String pubdate) {
			this.pubdate = pubdate;
		}
		public RatingDTO getRating() {
			return rating;
		}
		public void setRating(RatingDTO rating) {
			this.rating = rating;
		}
		public TagDTO[] getTags() {
			return tags;
		}
		public void setTags(TagDTO[] tags) {
			this.tags = tags;
		}
		public String getBinding() {
			return binding;
		}
		public void setBinding(String binding) {
			this.binding = binding;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public SeriesDTO getSeries() {
			return series;
		}
		public void setSeries(SeriesDTO series) {
			this.series = series;
		}
		public Integer getPages() {
			return pages;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public String getAuthor_intro() {
			return author_intro;
		}
		public void setAuthor_intro(String author_intro) {
			this.author_intro = author_intro;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getCatalog() {
			return catalog;
		}
		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}
		public String getEbook_url() {
			return ebook_url;
		}
		public void setEbook_url(String ebook_url) {
			this.ebook_url = ebook_url;
		}
		public Double getEbook_price() {
			return ebook_price;
		}
		public void setEbook_price(Double ebook_price) {
			this.ebook_price = ebook_price;
		}			
	}

}
