function remainderOfDays(date) {
	
	//오늘날짜와 특정날짜 사이의 남은 날짜 계산

	//오늘 날짜 및 시간
	var date1 = new Date(); //시간 정보 포함 -> 포함 되지 않도록 설정
	date1.setHours(0);
	date1.setMilliseconds(0);
	date1.setMinutes(0);
	date1.setSeconds(0);
	
	//특정 날짜 및 시간
	var date2 = new Date(date); //시간 정보 포함(09시 기준) -> 포함 되지 않도록 설정
	date2.setHours(0);
	date2.setMilliseconds(0);
	date2.setMinutes(0);
	date2.setSeconds(0);
	
	return ( ((((date2 - date1) / 1000) / 60) / 60) / 24 );
}