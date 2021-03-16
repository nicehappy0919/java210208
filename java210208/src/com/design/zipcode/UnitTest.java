package com.design.zipcode;

import java.util.ArrayList;

public class UnitTest {

	public static void main(String[] args) {
		ZipCodeDao zcd = new ZipCodeDao();
		ArrayList<ZipCodeVO> zipCodeList = null;
		zipCodeList = zcd.getZipCodeList("가산동");
		zipCodeList = zcd.getZipCodeList("당산동");
		zipCodeList = zcd.getZipCodeList("개봉동");
		System.out.println(zipCodeList);
	}

}
