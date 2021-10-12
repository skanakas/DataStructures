package com.srk.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HotelViewEvent{
	long hotelId;
	String areaCode;
	String userID;
	Boolean loggedIn;
	public HotelViewEvent(long hotelId, String areaCode, String userID, Boolean loggedIn) {
		super();
		this.hotelId = hotelId;
		this.areaCode = areaCode;
		this.userID = userID;
		this.loggedIn = loggedIn;
	}

	public long getHotelId() {
		return hotelId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public String getUserID() {
		return userID;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelViewEvent [hotelId=").append(hotelId).append(", areaCode=").append(areaCode)
				.append(", userID=").append(userID).append(", loggedIn=").append(loggedIn).append("]");
		return builder.toString();
	}
}

class OutputMessage {
	public String hotel_area_code;
	public long hotel_id;
	public int views;
	OutputMessage(String hotel_area_code, long hotel_id, int views){
		this.hotel_area_code = hotel_area_code;
		this.hotel_id = hotel_id;
		this.views = views;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutputMessage [hotel_area_code=").append(hotel_area_code).append(", hotel_id=").append(hotel_id)
				.append(", views=").append(views).append("]");
		return builder.toString();
	}
	
}

public class HotelLoggedInRate {

	private static List<OutputMessage> getSolution(List<HotelViewEvent> events){

		return events.stream()
				.filter(event -> event.getLoggedIn())
				.map(msg ->{
					return new OutputMessage(msg.areaCode, msg.hotelId, 1);
				})
				.collect(Collectors.groupingBy(oMsg -> oMsg.hotel_area_code+"_"+oMsg.hotel_id))
				.entrySet()
				.stream()
				.map(entry -> {
					String key = entry.getKey();
					String[] keyData = key.split("_");
					String hotelID = keyData[1];
					String areaCode = keyData[0];
					List<OutputMessage> hData = entry.getValue();
					OutputMessage hDataMsg = hData.stream().reduce(new OutputMessage(areaCode, Long.parseLong(hotelID), 0), (a,b) -> {
						a.views = a.views + b.views;
						return a;
					});
					return hDataMsg;
				})
				.collect(Collectors.groupingBy(oMsg -> oMsg.hotel_area_code))
				.values()
				.stream()
				.map(areaData -> {
					areaData.sort((h1,h2)->(h2.views - h1.views));
					return areaData.get(0);
				})
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<HotelViewEvent> list = new ArrayList<>();
		
		list.add(new HotelViewEvent(23, "IT", "user1", true));
		list.add(new HotelViewEvent(23, "IT", "user2", true));
		list.add(new HotelViewEvent(23, "IT", "user1", true));
		list.add(new HotelViewEvent(24, "IT", "user1", true));
		list.add(new HotelViewEvent(24, "IT", "user2", true));
		list.add(new HotelViewEvent(24, "IT", "user1", true));
		list.add(new HotelViewEvent(24, "IT", "user1", true));
		list.add(new HotelViewEvent(35, "FR", "user1", true));
		
		System.out.println(getSolution(list));
	}
}
